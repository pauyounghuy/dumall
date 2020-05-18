package com.byh.mall.exception;

public class NoSuchCacheException extends RuntimeException
{
	private String code = "-1";

	public NoSuchCacheException(String message) {
		super(message);
	}

	public NoSuchCacheException(String code, String message) {
		super(message);
		this.code = code;
	}
	public String getCode()
	{
		return code;
	}
	public void setCode(String code)
	{
		this.code = code;
	}
}
