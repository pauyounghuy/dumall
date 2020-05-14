package com.byh.mall.service.impl;
import com.byh.mall.base.BaseService;
import com.byh.mall.dao.VerificationCodeDAO;
import com.byh.mall.entity.VerificationCode;
import com.byh.mall.service.VerificationCodeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VerificationCodeServiceImpl extends BaseService implements VerificationCodeService
{
	@Autowired
	VerificationCodeDAO verificationCodeDAO;

	@Override
	public VerificationCode getVerificationCode(Long id)
	{
		return verificationCodeDAO.getVerificationCode(id);
	}
	@Override
	public List<VerificationCode> getVerificationCode(Long userKey, String mail, String mobile)
	{
		return verificationCodeDAO.getVerificationCode(userKey, mail, mobile);
	}
	@Override
	public void saveVerificationCode(VerificationCode verificationCode)
	{
		verificationCodeDAO.saveVerificationCode(verificationCode);
	}
	@Override
	public void updateVerificationCode(VerificationCode verificationCode)
	{
		verificationCodeDAO.updateVerificationCode(verificationCode);
	}
	@Override
	public void deleteVerificationCode(Long id)
	{
		verificationCodeDAO.deleteVerificationCode(id);
	}
}
