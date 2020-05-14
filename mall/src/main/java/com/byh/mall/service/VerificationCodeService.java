package com.byh.mall.service;
import com.byh.mall.entity.VerificationCode;

import java.util.List;

public interface VerificationCodeService
{
	VerificationCode getVerificationCode(Long id);
	List<VerificationCode> getVerificationCode(Long userKey, String mail, String mobile);
	void saveVerificationCode(VerificationCode verificationCode);
	void updateVerificationCode(VerificationCode verificationCode);
	void deleteVerificationCode(Long id);
}
