package com.byh.mall.dao.impl;
import com.byh.mall.base.BaseDAO;
import com.byh.mall.dao.VerificationCodeDAO;
import com.byh.mall.dao.mapper.VerificationCodeMapper;
import com.byh.mall.entity.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class VerificationCodeDAOImpl extends BaseDAO implements VerificationCodeDAO
{
	@Autowired
	VerificationCodeMapper verificationCodeMapper;

	@Override
	public VerificationCode getVerificationCode(Long id)
	{
		return verificationCodeMapper.selectByPrimaryKey(id);
	}
	@Override
	public List<VerificationCode> getVerificationCode(Long userKey, String mail, String mobile)
	{
		Example example = new Example(VerificationCode.class);
		example.createCriteria().andEqualTo("userKey",userKey);
		if (!StringUtils.isEmpty(mail)){
			example.and().andEqualTo("email",mail);
		}
		if (!StringUtils.isEmpty(mobile)){
			example.and().andEqualTo("mobile",mobile);
		}

		return verificationCodeMapper.selectByExample(example);
	}
	@Override
	public void saveVerificationCode(VerificationCode verificationCode)
	{
		verificationCodeMapper.insert(verificationCode);
	}
	@Override
	public void updateVerificationCode(VerificationCode verificationCode)
	{
		verificationCodeMapper.updateByPrimaryKeySelective(verificationCode);
	}
	@Override
	public void deleteVerificationCode(Long id)
	{
		verificationCodeMapper.deleteByPrimaryKey(id);
	}
}
