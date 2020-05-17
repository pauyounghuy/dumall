package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.User;
import com.byh.mall.service.UserService;
import com.byh.mall.service.VisitorService;
import com.byh.mall.utils.VerifyCodeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import com.byh.mall.response.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class IndexController extends BaseController
{
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private VisitorService visitorService;
	@Autowired
	private HazelcastInstance hazelcast;

	//登录
	@RequestMapping("/login")
	public JSONResult login(String username, String password, String code, HttpServletRequest request, HttpServletResponse response,String ip){
		log.info("username:"+username+"==> password:"+password);

		if(StringUtils.isEmpty(username)){
			Cookie[] cookies=request.getCookies();
			if (cookies != null && cookies.length>0){
				for(Cookie cookie: cookies){
					if (cookie.getName().equals("username")){
						username=cookie.getValue();
					}
				}
			}
		}

		if (StringUtils.isEmpty(username)){
			log.info("用户名不能为空");
			return jsonResult.errorMsg("100000");
		}

		ObjectMapper om = new ObjectMapper();
		Object obj= hazelcast.getMap("hazelcast-instance").get("username");  //先通过缓存获取是否存在
		User user = om.convertValue(obj, User.class);

		if(ObjectUtils.isEmpty(user)){
			//校验验证码
			int bool=VerifyCodeUtils.checkVerifyCode(request,hazelcast);
			if(bool==0){
				return jsonResult.errorMsg("000006");
			}
			if(bool==2){
				return jsonResult.errorMsg("000005");
			}
			if (bool==3){
				return jsonResult.errorMsg("000007");
			}

			//获取用户数据
			user = userService.checkUsername(username);
			if(ObjectUtils.isEmpty(user)){
				log.info("用户名不存在");
				return jsonResult.errorMsg("000001");
			}
			else{  //存在用户名,存入缓存
				if (!password.equals(user.getPassword())){
					return jsonResult.errorMsg("000000");
				}

				hazelcast.getMap("hazelcast-instance").putAsync("username", user);
				Cookie cookie=new Cookie("username", user.getUsername());
				cookie.setMaxAge(7200);
				cookie.setPath("/");
				response.addCookie(cookie);
			}
		}

		//mongo记录登录
		addRecord(username,ip);

		return jsonResult.ok(user);
	}
	//注册
	@RequestMapping("/register")
	public JSONResult register(String username,String password,String pwd,String name,String mobile,String qq,String email){
		if(!password.equals(pwd)){
			log.info("前后密码不一致");
			return jsonResult.errorMsg("100001");
		}
		if(StringUtils.isEmpty(username) && StringUtils.isEmpty(mobile) && StringUtils.isEmpty(email)){
			return jsonResult.errorMsg("100010");
		}
		User user=null;
		if (!StringUtils.isEmpty(username)){
			user=userService.checkUsername(username);
			if (!ObjectUtils.isEmpty(user))
			{
				return jsonResult.errorMsg("000002");
			}
		}
		if (!StringUtils.isEmpty(email)){
			user = userService.checkUsername(email);
			if (!ObjectUtils.isEmpty(user))
			{
				return jsonResult.errorMsg("000004");
			}
		}
		if (!StringUtils.isEmpty(mobile)){
			user=userService.checkUsername(mobile);
			if (!ObjectUtils.isEmpty(user))
			{
				return jsonResult.errorMsg("000003");
			}
		}

		user = new User(username, name, password, mobile, email,qq);
		userService.saveUser(user);

		return jsonResult.ok();
	}

	//退出
	@RequestMapping("/logout")
	public JSONResult logout(HttpServletRequest request,HttpServletResponse response,String username)
	{
		//清空缓存与cookies
		hazelcast.getMap("hazelcast-instance").removeAsync("username");
		Cookie[] cookies=request.getCookies();

		for(Cookie cookie: cookies){
			if (cookie.getName().equals("username")){
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
			}

		}
		//mongo记录时长
		addRecord(username,null);

		return jsonResult.ok();
	}
	private void addRecord(String username,String ip)
	{
//		if (!StringUtils.isEmpty(ip)){ //登录
//			Visitor visitor = new Visitor(ip,username,1);
//			visitor.setVisitTime(visitor.getVisitTime());
//			visitorService.saveVisitor(visitor);
//		}
//		else{  //退出
//			Visitor visitor = visitorService.getVisitorEnter(username);
//			if(!ObjectUtils.isEmpty(visitor) && visitor.getIsEnter() ==1){
//				visitor.setQuitTime(visitor.getQuitTime());
//				visitor.setDuration(visitor.getDuration());
//				visitor.setIsEnter(0);
//				visitorService.saveVisitor(visitor);
//			}
//
//		}

	}



}
