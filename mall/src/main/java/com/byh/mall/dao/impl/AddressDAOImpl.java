package com.byh.mall.dao.impl;
import com.byh.mall.base.BaseDAO;
import com.byh.mall.dao.AddressDAO;
import com.byh.mall.dao.mapper.AddressMapper;
import com.byh.mall.entity.Address;
import com.byh.mall.entity.User;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class AddressDAOImpl extends BaseDAO implements AddressDAO
{
	@Autowired
	private AddressMapper addressMapper;
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public PageInfo<Address> getAddressByPage(SearchVO searchVO, int pageNum, int pageSize)
	{
		Example example = new Example(Address.class);
		example.createCriteria();
		if(!StringUtils.isEmpty(searchVO.getUserKey())){
			example.and().andEqualTo("userKey",searchVO.getUserKey());
		}
		if(!StringUtils.isEmpty(searchVO.getName())){
			example.and().andLike("name",searchVO.getName());
		}
		if(!StringUtils.isEmpty(searchVO.getStreetName())){
			example.and().andLike("streetName",searchVO.getStreetName());
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Address> list = addressMapper.selectByExample(example);
		PageInfo<Address> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}
	@Override
	public List<Address> getAddress(Long userKey)
	{
		Example example = new Example(Address.class);
		example.createCriteria().andEqualTo("userKey",userKey);
		return addressMapper.selectByExample(example);
	}
	@Override
	public Address getAddressOne(Long id)
	{
		return addressMapper.selectByPrimaryKey(id);
	}
	@Override
	public void saveAddress(Address address)
	{
		addressMapper.insertSelective(address);
	}

	@Override
	public void updateAddress(Address address)
	{
		addressMapper.updateByPrimaryKeySelective(address);
	}

	@Override
	public void deleteAddress(Long id)
	{
		addressMapper.deleteByPrimaryKey(id);
	}
}
