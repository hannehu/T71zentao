package com.first.utils;

import org.testng.Assert;

public class AssertUtils {

	private static Log log=new Log(AssertUtils.class);
	//整形比较
	public void assertIntNum(int actual,int expected,String... com){
		try{
	 Assert.assertEquals(actual,expected);
		}catch(AssertionError e){
			log.error("整形断言比较失败");
			Assert.fail("整形断言比较失败");
		}
	}
	//字符串比较
	public void assertString(String actual,String expected,String... com){
		try{
		 Assert.assertEquals(actual,expected);
		}catch(AssertionError e){
			log.error("String断言比较失败");
			Assert.fail("String断言比较失败");
		}
		}
	//字符串包含
	public void assertStringContains(String actual,String expected,String... com){
		try{
		 Assert.assertEquals(true,actual.contains(expected));
		}catch(AssertionError e){
			log.error("字符串包含断言失败");
			Assert.fail("字符串包含断言失败");
		}
		}
	//非空
	public void assertNotNull (Object object,String... com){
		try{
		 Assert.assertNotNull(object);
	}catch(AssertionError e){
		log.error("NULL断言失败");
		Assert.fail("NULL断言失败");
	}
		}
	//实型断言
}
