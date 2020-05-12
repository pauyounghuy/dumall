package com.byh.mall.service;
import com.byh.mall.entity.Goods;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;

public interface GoodsService
{
	PageInfo<Goods> getGoodsByPage(SearchVO searchVO, int pageNum, int pageSize);
	Goods getGoodsByKey(Long id);
}
