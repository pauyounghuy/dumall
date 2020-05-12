package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.Goods;
import com.byh.mall.service.GoodsService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import commons.JSONResult;
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
		return JSONResult.ok(gdsPage);
	}

}
