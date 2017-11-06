package com.first.actions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.first.pages.LoginPage;
import com.first.pages.MainPage;

public class LoginOperate {

	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		return driver;
	}
	public static void setDriver(WebDriver driver) {
		LoginOperate.driver = driver;
	}
	
	static LoginPage loginPage;
	static MainPage mainPage;
	//登录成功测试用例
	public static MainPage loginSucess(String username,String password){
		loginPage=new LoginPage(getDriver());
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.click();
		return new MainPage(getDriver());
	}
	public static String getUsername(String username,String password){
		mainPage=loginSucess(username,password);
		return mainPage.getUsername();
	}
	//登录失败测试用例
	public static String loginFailOperate(String username,String password){
		loginPage=new LoginPage(getDriver());
		loginPage.inputUsername(username);
		loginPage.inputPassword(password);
		loginPage.click();
		loginPage.wait(3);
		String value=loginPage.getAlertText();
		loginPage.alertAccept();
		return value;
	}
	public static String getAlertText(String username,String password){
		String value=loginFailOperate(username,password);
		return value;
	}
}
