package com.byh.mall.dao.impl;
import com.byh.mall.base.BaseDAO;
import com.byh.mall.dao.GoodsDAO;
import com.byh.mall.dao.mapper.GoodsMapper;
import com.byh.mall.entity.Address;
import com.byh.mall.entity.Goods;
import com.byh.mall.entity.Order;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class GoodsDAOImpl extends BaseDAO implements GoodsDAO
{
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public PageInfo<Goods> getGoodsByPage(SearchVO searchVO, int pageNum, int pageSize)
	{
		Example example = new Example(Address.class);
		example.createCriteria().andLike("name",searchVO.getName());
		PageHelper.startPage(pageNum, pageSize);
		List<Goods> list = goodsMapper.selectByExample(example);
		PageInfo<Goods> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public Goods getGoods(Long id)
	{
		return goodsMapper.selectByPrimaryKey(id);
	}
	@Override
	public void saveGoods(Goods goods)
	{
		goodsMapper.insertSelective(goods);
	}
	@Override
	public void updateGoods(Goods goods)
	{
		goodsMapper.updateByPrimaryKeySelective(goods);
	}
	@Override
	public void deleteGoods(Long id)
	{
		goodsMapper.deleteByPrimaryKey(id);
	}
}
