package com.byh.mall.utils;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.byh.mall.entity.AliYun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SMSUtils
{
	@Autowired
	private AliYun aliYun;
	//"{\"code\":\"111\"}"
	public void sendSMS(String mobile, String paramContent){
		DefaultProfile profile = DefaultProfile.getProfile(aliYun.getRegionId(), aliYun.getAccessKey(), aliYun.getSecretKey());
		IAcsClient client = new DefaultAcsClient(profile);

		CommonRequest request = new CommonRequest();
		request.setSysMethod(MethodType.POST);
		request.setSysDomain("dysmsapi.aliyuncs.com");
		request.setSysVersion("2017-05-25");
		request.setSysAction("SendSms");
		request.putQueryParameter("RegionId",aliYun.getRegionId());
		request.putQueryParameter("PhoneNumbers", mobile);
		request.putQueryParameter("SignName", aliYun.getSignName());
		request.putQueryParameter("TemplateCode", aliYun.getTempCode());
		request.putQueryParameter("TemplateParam", paramContent);
		try {
			CommonResponse response = client.getCommonResponse(request);
			System.out.println(response.getData());
		} catch (ServerException e) {
			e.printStackTrace();
		} catch (ClientException e) {
			e.printStackTrace();
		}
	}

}
