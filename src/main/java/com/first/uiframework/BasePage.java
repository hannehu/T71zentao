package com.first.uiframework;

import org.dom4j.DocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebElementUtils{

	public BasePage(WebDriver driver){
		super(driver);
	}
//获取网页源代码，弹窗处理，frame
	public String getPageSource(WebDriver driver){
		wait(3);
		return driver.getPageSource();
	}
	public void alertAccept(){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss(){
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public void alertInput(String value){
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(value);
	}
	public String getAlertText(){
		Alert alert=driver.switchTo().alert();
		return alert.getText();
	}

}
