package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.*;
import com.byh.mall.service.*;
import com.byh.mall.vo.CartVO;
import com.byh.mall.vo.OrderVO;
import com.byh.mall.vo.UserInfoVO;
import commons.JSONResult;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
			Goods goods = goodsService.getGoodsByKey(cart.getGid());
			cartVO.setFavorPrice(goods.getFavorPrice().toString());
			cartVO.setIsChecked(cart.getIsChecked());
			cartVO.setCarttId(cart.getId().toString());
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
					Goods goods=goodsService.getGoodsByKey(orderGoods.getGid());
					glist.add(goods);
				}
				OrderVO ov = new OrderVO(order.getId().toString(),order.getStatus(),order.getCreateDate(),order.getCompleteDate(),address,glist);
				ovlist.add(ov);
			}
		}
		userInfoVO=new UserInfoVO(user, addressList, cvlist, ovlist);
		return JSONResult.ok(userInfoVO);
	}


	//修改用户信息
	@RequestMapping("/update")
	public JSONResult update(HttpServletRequest request, User user)
	{
		user.setUpdateDate(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		userService.updateUser(user);
		return JSONResult.ok();
	}




}
