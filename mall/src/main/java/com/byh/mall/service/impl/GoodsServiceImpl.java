package com.byh.mall.service.impl;
import com.byh.mall.base.BaseService;
import com.byh.mall.dao.CartDAO;
import com.byh.mall.dao.GoodsDAO;
import com.byh.mall.entity.Goods;
import com.byh.mall.service.CartService;
import com.byh.mall.service.GoodsService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodsServiceImpl extends BaseService implements GoodsService
{
	@Autowired
	private GoodsDAO goodsDAO;

	@Override
	public PageInfo<Goods> getGoodsByPage(SearchVO searchVO, int pageNum, int pageSize)
	{
		return goodsDAO.getGoodsByPage(searchVO, pageNum, pageSize);
	}
	@Override
	public Goods getGoodsByKey(Long id)
	{
		return goodsDAO.getGoodsByKey(id);
	}
}
