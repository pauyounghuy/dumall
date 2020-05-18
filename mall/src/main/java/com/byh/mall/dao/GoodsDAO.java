package com.byh.mall.dao;
import com.byh.mall.entity.Goods;
import com.byh.mall.entity.Order;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;

public interface GoodsDAO
{
	PageInfo<Goods> getGoodsByPage(SearchVO searchVO, int pageNum, int pageSize);
	Goods getGoods(Long id);
	void saveGoods(Goods goods);
	void updateGoods(Goods goods);
	void deleteGoods(Long id);
}
