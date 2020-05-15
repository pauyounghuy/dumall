package com.byh.mall.exception;
import lombok.Getter;

public class NoSuchCacheException extends RuntimeException
{
	@Getter
	private String code = "-1";

	public NoSuchCacheException(String message) {
		super(message);
	}

	public NoSuchCacheException(String code, String message) {
		super(message);
		this.code = code;
	}
}
