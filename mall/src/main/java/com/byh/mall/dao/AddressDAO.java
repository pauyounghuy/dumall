package com.byh.mall.dao;
import com.byh.mall.entity.Address;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AddressDAO
{
	PageInfo<Address> getAddressByPage(SearchVO searchVO, int pageNum, int pageSize);
	List<Address> getAddress(Long userKey);
	Address getAddressOne(Long id);
	void saveAddress(Address address);
	void updateAddress(Address address);
	void deleteAddress(Long id);
}
