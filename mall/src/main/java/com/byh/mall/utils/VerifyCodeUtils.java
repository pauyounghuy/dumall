package com.byh.mall.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.util.StringUtils;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerifyCodeUtils
{
	public static final String RANDOMKEY= "RANDOMKEY";//放到session中的key
	private int width = 95;// 图片宽
	private int height = 25;// 图片高
	private int lineSize = 40;// 干扰线数量
	private int stringNum = 4;// 随机产生字符数量

	private Random random = new Random();

	private static String cacheName="beanCache";
		//CaffeineCacheUtil.listCacheNames().stream().findFirst().get();

	/**
	 * 获得字体
	 */
	private Font getFont() {
		return new Font("Fixedsys", Font.CENTER_BASELINE, 18);
	}

	/**
	 * 获得颜色
	 */
	private Color getRandColor(int fc, int bc) {
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc - 16);
		int g = fc + random.nextInt(bc - fc - 14);
		int b = fc + random.nextInt(bc - fc - 18);
		return new Color(r, g, b);
	}

	/**
	 * 生成随机图片
	 */
	public void getRandcode(HttpServletRequest request, HttpServletResponse response, HazelcastInstance hazelcast) {
		HttpSession session = request.getSession();
		// BufferedImage类是具有缓冲区的Image类,Image类是用于描述图像信息的类
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		Graphics g = image.getGraphics();// 产生Image对象的Graphics对象,改对象可以在图像上进行各种绘制操作
		g.fillRect(0, 0, width, height);//图片大小
		g.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));//字体大小
		g.setColor(getRandColor(110, 133));//字体颜色
		// 绘制干扰线
		for (int i = 0; i <= lineSize; i++) {
			drowLine(g);
		}
		// 绘制随机字符
		String randomString = "";
		for (int i = 1; i <= stringNum; i++) {
			randomString = drowString(g, randomString, i);
		}
		//将生成的随机字符串保存到session中
//		session.removeAttribute(RANDOMKEY);
//		session.setAttribute(RANDOMKEY, randomString);
//		//设置失效时间5分钟
//		session.setMaxInactiveInterval(300);

		hazelcast.getMap("hazelcast-instance").remove(RANDOMKEY);
		hazelcast.getMap("hazelcast-instance").put(RANDOMKEY, randomString);

//		CaffeineCacheUtil.evictCache(cacheName, RANDOMKEY);
//		CaffeineCacheUtil.putCache(cacheName, RANDOMKEY,randomString);

		g.dispose();
		try {
			// 将内存中的图片通过流动形式输出到客户端
			ImageIO.write(image, "JPEG", response.getOutputStream());
		}
		catch (Exception e) {
		}

	}

	/**
	 * 绘制字符串
	 */
	private String drowString(Graphics g, String randomString, int i) {
		g.setFont(getFont());
		g.setColor(new Color(random.nextInt(101), random.nextInt(111), random.nextInt(121)));
		String rand = String.valueOf(getRandomString(random.nextInt(RandomUtils.RAND_STR.length())));
		randomString += rand;
		g.translate(random.nextInt(3), random.nextInt(3));
		g.drawString(rand, 13 * i, 16);
		return randomString;
	}

	/**
	 * 绘制干扰线
	 */
	private void drowLine(Graphics g) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int xl = random.nextInt(13);
		int yl = random.nextInt(15);
		g.drawLine(x, y, x + xl, y + yl);
	}

	/**
	 * 获取随机的字符
	 */
	public String getRandomString(int num) {
		return String.valueOf(RandomUtils.RAND_STR.charAt(num));
	}

	/**
	 * 验证码校验  0  不一致  1  成功  2失效  3传入失败
	 */
	public static int checkVerifyCode(HttpServletRequest request,HazelcastInstance hazelcast) {
		//获取用户输入的验证码
		String result = request.getParameter("code");
		if(!StringUtils.isEmpty(result)) {
			result = result.trim().toUpperCase();
			//获取生成的验证码
			//String verifyCodeExpected = (String) request.getSession().getAttribute(RANDOMKEY);
			Object object=hazelcast.getMap("hazelcast-instance").get(RANDOMKEY);
//			Object object= CaffeineCacheUtil.getCacheValue(cacheName,RANDOMKEY);
			ObjectMapper om = new ObjectMapper();
			String verifyCodeExpected=om.convertValue(object, String.class);

			if (!StringUtils.isEmpty(verifyCodeExpected))
			{
				verifyCodeExpected = verifyCodeExpected.toUpperCase().trim();
				if(result.equals(verifyCodeExpected)) {
					return 1;
				}
				else
				{
					return 0;
				}
			}
			else
			{
				return 2;
			}
		}
		return 3;
	}


}
