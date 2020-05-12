package com.byh.mall.service.impl;
import com.byh.mall.base.BaseService;
import com.byh.mall.dao.AddressDAO;
import com.byh.mall.entity.Address;
import com.byh.mall.service.AddressService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressServiceImpl extends BaseService implements AddressService
{
	@Autowired
	private AddressDAO addressDAO;

	@Override
	public PageInfo<Address> getAddressByPage(SearchVO searchVO, int pageNum, int pageSize)
	{
		return addressDAO.getAddressByPage(searchVO, pageNum, pageSize);
	}
	@Override
	public List<Address> getAddress(Long userKey)
	{
		return null;
	}
	@Override
	public void saveAddress(Address address)
	{
		addressDAO.saveAddress(address);
	}
	@Override
	public void updateAddress(Address address)
	{
		addressDAO.updateAddress(address);
	}
	@Override
	public void deleteAddress(Long id)
	{
		addressDAO.deleteAddress(id);
	}
}
