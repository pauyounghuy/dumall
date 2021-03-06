package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.*;
import com.byh.mall.mail.MailService;
import com.byh.mall.service.*;
import com.byh.mall.utils.RandomUtils;
import com.byh.mall.vo.CartVO;
import com.byh.mall.vo.OrderVO;
import com.byh.mall.vo.UserInfoVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import com.byh.mall.response.JSONResult;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController
{
	@Autowired
	private UserService userService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private CartService cartService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private VerificationCodeService verificationCodeService;
	@Autowired
	private HazelcastInstance hazelcast;
	@Autowired
	private MailService mailService;


	//获取用户信息
	@RequestMapping("/getUserInfo")
	public JSONResult getUserInfo(HttpServletRequest request,Long userKey)
	{
		UserInfoVO userInfoVO =new UserInfoVO();
		User user =userService.getKey(userKey);
		List<Address> addressList=addressService.getAddress(user.getId());
		List<Cart> cartlist=cartService.getCart(user.getId());
		List<CartVO> cvlist=new ArrayList<>();

		for(Cart cart: cartlist)
		{
			CartVO cartVO=new CartVO();
			Goods goods = goodsService.getGoods(cart.getGid());
			cartVO.setFavorPrice(goods.getFavorPrice().toString());
			cartVO.setIsChecked(cart.getIsChecked());
			cartVO.setCartId(cart.getId().toString());
			cartVO.setProductId(goods.getId().toString());
			cartVO.setProductImage(goods.getProductImage());
			cartVO.setProductName(goods.getName());
			cartVO.setQty(cart.getQty());
			cvlist.add(cartVO);
		}

		List<OrderVO> ovlist=new ArrayList<>();
		List<Goods> glist=null;
		for(Address address:addressList){
			List<Order> adsList = orderService.getOrder(address.getId(), user.getId());
			for(Order order:adsList){
				glist= new ArrayList<>();
				List<OrderGoods> oglist=orderService.getOgList(order.getId());
				for(OrderGoods orderGoods:oglist){
					Goods goods=goodsService.getGoods(orderGoods.getGid());
					glist.add(goods);
				}
				OrderVO ov = new OrderVO(order.getId().toString(),order.getStatus(),order.getCreateDate(),order.getCompleteDate(),address,glist);
				ovlist.add(ov);
			}
		}
		userInfoVO=new UserInfoVO(user, addressList, cvlist, ovlist);
		return jsonResult.ok(userInfoVO);
	}


	//修改用户信息
	@RequestMapping("/update")
	public JSONResult update(HttpServletRequest request, User user)
	{
		String username=user.getUsername();
		String mobile=user.getMobile();
		String email=user.getEmail();

		if (!StringUtils.isEmpty(username)){
			user=userService.checkUsername(username);
			if (!ObjectUtils.isEmpty(user))
			{
				//return jsonResult.errorMsg("邮箱已存在");
				return jsonResult.errorCode("000002");
			}
		}
		if (!StringUtils.isEmpty(email)){
			user = userService.checkUsername(email);
			if (!ObjectUtils.isEmpty(user))
			{
				//return jsonResult.errorMsg("邮箱已存在");
				return jsonResult.errorCode("000004");
			}
		}
		if (!StringUtils.isEmpty(mobile)){
			user=userService.checkUsername(mobile);
			if (!ObjectUtils.isEmpty(user))
			{
				//return jsonResult.errorMsg("手机号已存在");
				return jsonResult.errorCode("000003");
			}
		}

		user.setUpdateDate(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		userService.updateUser(user);
		return jsonResult.ok();
	}

	//发送邮件确认
	@RequestMapping("/sendEmail")
	public JSONResult sendEmail(HttpServletRequest request, Long userKey)
	{
		User user = userService.getKey(userKey);
		if(user== null){
			//return jsonResult.errorMsg("用户不存在");
			return jsonResult.errorCode("000000");
		}
		//生成验证码
		String code= RandomUtils.random(6).toUpperCase();
		hazelcast.getMap("hazelcast-instance").removeAsync(userKey);
		hazelcast.getMap("hazelcast-instance").putAsync(userKey, code);
		VerificationCode verificationCode = new VerificationCode();
		SimpleMailMessage sm=new SimpleMailMessage();

		sm.setFrom("928828480@qq.com");
		sm.setTo(user.getEmail());
		sm.setSubject("邮箱验证码");
		sm.setText(code);
		mailService.sendMail(sm);

		verificationCode.setCode(sm.getText());
		verificationCode.setUserKey(userKey);
		verificationCode.setEmail(user.getEmail());
		verificationCode.setSendTime(verificationCode.getSendTime());
		verificationCode.setCreateDate(verificationCode.getCreateDate());
		verificationCode.setStatus(1);

		verificationCodeService.saveVerificationCode(verificationCode);

		return jsonResult.ok();
	}
	//验证邮箱
	@RequestMapping("/verifyEmail")
	public JSONResult sendEmail(HttpServletRequest request, Long userKey,String code)
	{
		Object obj = hazelcast.getMap("hazelcast-instance").get(userKey);
		if (ObjectUtils.isEmpty(obj)){
			//return jsonResult.errorMsg("验证码已失效");
			return jsonResult.errorCode("000005");
		}
		ObjectMapper om = new ObjectMapper();
		String cde=om.convertValue(obj, String.class);

		if(StringUtils.isEmpty(code) || !code.toUpperCase().equals(cde)){
			//return jsonResult.errorMsg("验证码不一致,请重新输入");
			return jsonResult.errorCode("000006");
		}

		User user =userService.getKey(userKey);
		user.setIsVMail(1);
		user.setUpdateDate(user.getUpdateDate());
		userService.updateUser(user);

		hazelcast.getMap("hazelcast-instance").removeAsync(userKey);
		return jsonResult.ok();
	}

}
