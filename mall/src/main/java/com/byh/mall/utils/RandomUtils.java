package com.byh.mall.utils;
import java.util.Random;

public class RandomUtils
{
	//随机产生数字与字母组合的字符串
	public static final String RAND_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public static String getRandom(int index){
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<index; i++){
			sb=sb.append(RAND_STR.charAt(new Random().nextInt(RAND_STR.length())));
		}
		return sb.toString();
	}


}
