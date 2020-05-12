package com.byh.mall.service;
import com.byh.mall.entity.Address;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AddressService
{
	PageInfo<Address> getAddressByPage(SearchVO searchVO, int pageNum, int pageSize);
	List<Address> getAddress(Long userKey);
	void saveAddress(Address address);
	void updateAddress(Address address);
	void deleteAddress(Long id);



}
