package com.byh.mall.controller;
import com.byh.mall.entity.Goods;
import com.byh.mall.service.GoodsService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController
{
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/get")
	public PageInfo<Goods> get(){
		return goodsService.getGoodsByPage(new SearchVO(),0,10);
	}


}
