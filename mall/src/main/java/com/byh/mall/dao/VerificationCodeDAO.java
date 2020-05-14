package com.byh.mall.dao;
import com.byh.mall.entity.VerificationCode;

import java.util.List;

public interface VerificationCodeDAO
{
	VerificationCode getVerificationCode(Long id);
	List<VerificationCode> getVerificationCode(Long userKey, String mail, String mobile);
	void saveVerificationCode(VerificationCode verificationCode);
	void updateVerificationCode(VerificationCode verificationCode);
	void deleteVerificationCode(Long id);
}
