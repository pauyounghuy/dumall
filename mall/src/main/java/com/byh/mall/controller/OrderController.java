package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.Address;
import com.byh.mall.entity.Goods;
import com.byh.mall.entity.Order;
import com.byh.mall.entity.OrderGoods;
import com.byh.mall.service.AddressService;
import com.byh.mall.service.GoodsService;
import com.byh.mall.service.OrderService;
import com.byh.mall.vo.OrderVO;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import com.byh.mall.response.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController extends BaseController
{
	@Autowired
	private OrderService orderService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private GoodsService goodsService;


	//分页显示订单信息
	@RequestMapping("/getByPageCondition")
	public JSONResult getOrderByCondition(HttpServletRequest request, SearchVO searchVO, int pageNum, int pageSize)
	{
		PageInfo<Order> gdsPage = orderService.getOrderByPage(searchVO, pageNum, pageSize);
		return jsonResult.ok(gdsPage);
	}
	//获取所有订单
	@RequestMapping("/getAllOrder")
	public JSONResult getAllOrder(HttpServletRequest request, Long userKey)
	{
		OrderVO orderVO =null;
		List<OrderVO> odvList = new ArrayList<>();
		List<Address> adsList= addressService.getAddress(userKey);
		for (Address address: adsList){
			List<Order> orderList = orderService.getOrder(address.getId(), userKey);
			for(Order order: orderList){
				List<Goods> goodsList=new ArrayList<>();
				List<OrderGoods> oglist=orderService.getOgList(order.getId());
				for(OrderGoods orderGoods: oglist){
					Goods goods= goodsService.getGoods(orderGoods.getGid());
					if(goods!=null){
						goodsList.add(goods);
					}
				}
				orderVO=new OrderVO();
				orderVO.setOrderId(order.getId().toString());
				orderVO.setAddressInfo(address);
				orderVO.setGoodsList(goodsList);
				orderVO.setOrderStatus(order.getStatus());
				orderVO.setCompleteDate(order.getCompleteDate());
				orderVO.setCreateDate(orderVO.getCreateDate());
				odvList.add(orderVO);

			}
		}

		return jsonResult.ok(odvList);
	}
	//订单商品详情
	@RequestMapping("/getOrderGoods")
	public JSONResult getOrderGoods(HttpServletRequest request, Long orderId)
	{
		Order order=orderService.getOrder(orderId);
		Address address=addressService.getAddressOne(order.getId());
		List<Goods> goodsList=new ArrayList<>();
		List<OrderGoods> oglist=orderService.getOgList(order.getId());
		for(OrderGoods orderGoods: oglist){
			Goods goods= goodsService.getGoods(orderGoods.getGid());
			if(goods!=null){
				goodsList.add(goods);
			}
		}
		OrderVO orderVO=new OrderVO();
		orderVO.setOrderId(order.getId().toString());
		orderVO.setAddressInfo(address);
		orderVO.setGoodsList(goodsList);
		orderVO.setOrderStatus(order.getStatus());
		orderVO.setCompleteDate(order.getCompleteDate());
		orderVO.setCreateDate(orderVO.getCreateDate());

		return jsonResult.ok(orderVO);
	}
	//保存
	@RequestMapping("/save")
	public JSONResult saveOrder(HttpServletRequest request, Long userKey, Long adsKey, int status, String completeDate, String goodsList)
	{





		return jsonResult.ok();
	}
	//删除
	@RequestMapping("/delete")
	public JSONResult deleteOrder(HttpServletRequest request,String ids)
	{
		if (ids.indexOf(",") != -1){
			String[] idsArr = ids.split(",");
			for (String id: idsArr){
				Long idx = Long.parseLong(id);
				orderService.deleteOrder(idx);
				orderService.deleteOrderGoods(idx, null);
			}
		}
		else{
			Long id = Long.parseLong(ids);
			orderService.deleteOrder(id);
			orderService.deleteOrderGoods(id, null);
		}
		return jsonResult.ok();
	}



}
