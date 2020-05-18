package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.Cart;
import com.byh.mall.entity.Goods;
import com.byh.mall.response.JSONResult;
import com.byh.mall.service.CartService;
import com.byh.mall.service.GoodsService;
import com.byh.mall.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController extends BaseController
{
	@Autowired
	private CartService cartService;
	@Autowired
	private GoodsService goodsService;

	//增
	@RequestMapping("/add")
	public JSONResult addCart(HttpServletRequest request, Cart cart)
	{
		cartService.saveCart(cart);
		return jsonResult.ok();
	}
	// 删
	@RequestMapping("/delete")
	public JSONResult deleteCart(HttpServletRequest request, String ids)
	{
		if (ids.indexOf(",") != -1){
			String[] idsArr = ids.split(",");
			for (String id: idsArr){
				Long idx = Long.parseLong(id);
				cartService.deleteCart(idx);
			}
		}
		else{
			Long id = Long.parseLong(ids);
			cartService.deleteCart(id);
		}

		return jsonResult.ok();
	}
	// 改
	@RequestMapping("/update")
	public JSONResult updateCart(HttpServletRequest request, Cart cart)
	{
		cartService.updateCart(cart);
		return jsonResult.ok();
	}
	// 查
	@RequestMapping("/select")
	public JSONResult getCart(HttpServletRequest request, Long userKey)
	{
		List<CartVO> cartVOs=new ArrayList<>();
		List<Cart> cartList=cartService.getCart(userKey);
		CartVO cartVO=null;
		for(Cart cart:cartList)
		{
			Goods goods=goodsService.getGoods(cart.getGid());
			cartVO=new CartVO();
			cartVO.setProductId(cart.getGid().toString());
			cartVO.setProductName(goods.getName());
			cartVO.setQty(cart.getQty());
			cartVO.setProductImage(goods.getProductImage());
			cartVO.setFavorPrice(goods.getFavorPrice().toString());
			cartVO.setCartId(cart.getId().toString());
			cartVO.setIsChecked(cart.getIsChecked());

			cartVOs.add(cartVO);
		}

		return jsonResult.ok(cartVOs);
	}
}
