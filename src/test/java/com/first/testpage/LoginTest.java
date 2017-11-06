package com.first.testpage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.first.actions.LoginOperate;
import com.first.uiframework.DriverFactory;
import com.first.uiframework.DriverUtils;
import com.first.utils.AssertUtils;
import com.first.utils.ExeclUtils;
import com.first.utils.Log;
import com.first.utils.TestCase;

public class LoginTest {
	WebDriver driver;
	AssertUtils assertUtils=null;
	private Log log=new Log(LoginTest.class);
	@BeforeMethod
	public void setUp(){
		try{
		assertUtils=new AssertUtils();
		driver=DriverFactory.getChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}catch(Exception e){
			Assert.fail("测试浏览器初始化打开失败");
		}
		log.info("浏览器打开成功");
	}
	
	List<TestCase> testCases=ExeclUtils.getUITestData("UITestData.xlsx");
    @Test
    public void loginTest(){
    	Map<String,String> testData = testCases.get(0).getTestData();
    	LoginOperate.setDriver(driver);
	    String value=LoginOperate.getUsername(testData.get("username"), testData.get("password"));
	    assertUtils.assertStringContains(value, testCases.get(0).getExpectedResult(), "获取用户信息失败");
	   // Assert.assertEquals(value.contains("admin"), true,"获取用户信息失败");
    	log.info("正确的测试用例，登录成功");
   }
    @Test
    public void loginFailTest(){
    	Map<String,String> testData = testCases.get(2).getTestData();
    	LoginOperate.setDriver(driver);
    	String value=LoginOperate.getAlertText(testData.get("username"), testData.get("password"));
    	assertUtils.assertStringContains(value, testCases.get(2).getExpectedResult(), "登录失败，账号或密码错误");
    //	Assert.assertEquals(value.contains("登录失败"), true,"登录失败，账号或密码错误");
    	log.info("执行错误的测试用例完成");
    }
    @AfterMethod
    public void setDown() throws Exception{
    	DriverUtils.wait(3);
    	log.info("测试完毕，退出关闭浏览器");
    	driver.quit();
    }
}
