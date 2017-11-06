package com.first.pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.first.uiframework.BasePage;
import com.first.uiframework.Locator;

/**
 * @author hu
 * @date *{data}
 * @version 0.0
 */
public class MainPage extends BasePage{

	//private WebElement userMenu;
	public MainPage (WebDriver driver){
		super(driver);
		//userMenu=getElement("css","div#userMenu");//driver.findElement(By.cssSelector("div#userMenu"));
	}
	Locator userMenu=getLocator("userMenu");
	public String getUsername(){
		return getText(userMenu);//userMenu.getText();
	}
}
