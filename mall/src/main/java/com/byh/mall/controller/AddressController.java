package com.byh.mall.controller;
import com.byh.mall.base.BaseController;
import com.byh.mall.entity.Address;
import com.byh.mall.service.AddressService;
import com.byh.mall.vo.SearchVO;
import com.github.pagehelper.PageInfo;
import commons.JSONResult;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController
{
	@Autowired
	private AddressService addressService;

	//查
	@RequestMapping("/get")
	public JSONResult getAddress(HttpServletRequest request, Long userKey){
		List<Address> adsList = addressService.getAddress(userKey);
		return JSONResult.ok(adsList);
	}
	//多条件 分页查
	@RequestMapping("/getByPageCondition")
	public JSONResult getAddressByCondition(HttpServletRequest request, SearchVO searchVO,int pageNum, int pageSize)
	{
		PageInfo<Address> adsPage = addressService.getAddressByPage(searchVO, pageNum, pageSize);
		return JSONResult.ok(adsPage);
	}
	//增
	@RequestMapping("/add")
	public JSONResult add(HttpServletRequest request, Address address,Long userKey)
	{
		address.setUserKey(userKey);
		addressService.saveAddress(address);
		return JSONResult.ok();
	}
	//改
	@RequestMapping("/update")
	public JSONResult update(HttpServletRequest request, Address address,Long userKey)
	{
		address.setUserKey(userKey);
		address.setUpdateDate(DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
		addressService.saveAddress(address);
		return JSONResult.ok();
	}
	//删
	@RequestMapping("/delete")
	public JSONResult delete(HttpServletRequest request,Long id)
	{
		addressService.deleteAddress(id);
		return JSONResult.ok();
	}
	//改状态
	@RequestMapping("/updateStatus")
	public JSONResult delete(HttpServletRequest request,Long id,Long userKey)
	{
		List<Address> adsList = addressService.getAddress(userKey);
		for (Address address : adsList){
			if (address.getId().equals(id)){
				address.setIsDefault(1);
			}
			else {
				address.setIsDefault(0);
			}
			addressService.updateAddress(address);
		}
		return JSONResult.ok();
	}

}
