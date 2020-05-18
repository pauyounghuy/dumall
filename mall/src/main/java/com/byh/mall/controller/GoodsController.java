package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.Goods;
import com.byh.mall.entity.Order;
import com.byh.mall.service.GoodsService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import com.byh.mall.response.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController
{
	@Autowired
	private GoodsService goodsService;

	//分页显示商品信息
	@RequestMapping("/getByPageCondition")
	public JSONResult getAddressByCondition(HttpServletRequest request, SearchVO searchVO, int pageNum, int pageSize)
	{
		PageInfo<Goods> gdsPage = goodsService.getGoodsByPage(searchVO, pageNum, pageSize);
		return jsonResult.ok(gdsPage);
	}

	//增
	@RequestMapping("/add")
	public JSONResult addGoods(HttpServletRequest request,Goods goods)
	{
		goods.setCreateDate(goods.getCreateDate());
		goodsService.saveGoods(goods);
		return jsonResult.ok();
	}
	// 删
	@RequestMapping("/delete")
	public JSONResult deleteGoods(HttpServletRequest request, Long id)
	{
		goodsService.deleteGoods(id);
		return jsonResult.ok();
	}
	// 改
	@RequestMapping("/update")
	public JSONResult updaterGoods(HttpServletRequest request,Goods goods)
	{
		goods.setUpdateDate(goods.getUpdateDate());
		goodsService.updateGoods(goods);
		return jsonResult.ok();
	}
	// 查
	@RequestMapping("/select")
	public JSONResult getGoods(HttpServletRequest request,Long id)
	{
		Goods goods = goodsService.getGoods(id);
		return jsonResult.ok(goods);
	}
}
