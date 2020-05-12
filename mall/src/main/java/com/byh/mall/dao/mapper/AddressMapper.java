package com.byh.mall.dao.mapper;
import com.byh.mall.entity.Address;
import commons.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AddressMapper extends MyMapper<Address>
{

}
