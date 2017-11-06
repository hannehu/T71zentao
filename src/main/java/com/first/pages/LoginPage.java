package com.first.pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.first.config.LocalConfig;
import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;
import com.first.utils.XmlUtils;

/**
 * @author hu
 * @date *{data}
 * @version 0.0
 */
public class LoginPage extends BasePage{

//	private WebElement usernameInputBox;
//	private WebElement passwordInputBox;
//	private WebElement loginButton;
	
	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return driver;
	}
	public LoginPage(WebDriver driver){
		super(driver);
		openUrl(LocalConfig.URL);
		
//		usernameInputBox=getElement("css","input#account");//driver.findElement(By.cssSelector("input#account"));
//		passwordInputBox=getElement("css","input[name='password']");
//		loginButton=getElement("css","button#submit");
	}
	Locator usernameInputbox=getLocator("usernameInputbox");
			//XmlUtils.readElementInfo("LoginPage.xml").get("usernameInputbox");
	Locator passwordInputbox=getLocator("passwordInputbox");
			//XmlUtils.readElementInfo("LoginPage.xml").get("passwordInputbox");
	Locator loginButton=getLocator("loginButton");
			//XmlUtils.readElementInfo("LoginPage.xml").get("LoginButton");
	
	public void inputUsername(String name){
		 input(usernameInputbox,name);
	}
	public void inputPassword(String password){
		input(passwordInputbox,password);
	}
	public void click(){
		click(loginButton);
	}
	 
//	public void aaa(){
//		mouse.doubleClick(findElement(loginButton));
//	}
	
}
