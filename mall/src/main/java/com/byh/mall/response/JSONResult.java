package com.byh.mall.response;
import com.alibaba.fastjson.annotation.JSONField;
import com.byh.mall.utils.ConfigurationUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * @Description: 自定义响应数据结构
 * 				这个类是提供给门户，ios，安卓，微信商城用的
 * 				门户接受此类数据后需要使用本类的方法转换成对于的数据类型格式（类，或者list）
 * 				其他自行处理
 * 				200：表示成功
 * 				500：表示错误，错误信息在msg字段中
 * 				501：bean验证错误，不管多少个错误都以map形式返回
 * 				502：拦截器拦截到用户token出错
 * 				555：异常抛出信息
 */

@Component
@JsonIgnoreProperties(value={"config"})
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)  为空不返回
public class JSONResult {

    @Value("${validator.config}")
    @JSONField(serialize=false)
    private String config;

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    
    private String ok;	// 不使用

    public JSONResult build(Integer status, String msg, Object data) {
        return new JSONResult(status, msg, data);
    }

    public JSONResult ok(Object data) {
        return new JSONResult(data);
    }

    public JSONResult ok() {
        return new JSONResult(null);
    }

    public JSONResult errorMsg(String msg) {
        return new JSONResult(500, msg, null);
    }
    public JSONResult errorCode(String code){
        if(StringUtils.isEmpty(code)){
            return new JSONResult(500, "查无关联统一提示文件", null);
        }
        String value =ConfigurationUtils.getValue(code, new File(config));
        return new JSONResult(500, value, null);
    }
    public JSONResult errorMap(Object data) {
        return new JSONResult(501, "error", data);
    }
    
    public JSONResult errorTokenMsg(String msg) {
        return new JSONResult(502, msg, null);
    }
    
    public JSONResult errorException(String msg) {
        return new JSONResult(555, msg, null);
    }

    public JSONResult() {
    }

    public JSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

	public String getOk() {
		return ok;
	}

	public void setOk(String ok) {
		this.ok = ok;
	}
    public String getConfig()
    {
        return config;
    }
    public void setConfig(String config)
    {
        this.config = config;
    }
}
