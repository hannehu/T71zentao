package com.first.uiframework;

import java.util.HashMap;

import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.first.uiframework.Locator.ByType;
import com.first.utils.XmlUtils;

import junit.framework.Assert;

public class WebElementUtils  extends DriverUtils{

	protected HashMap<String,Locator> locatorMap;
	protected String path;
	public WebElementUtils(WebDriver driver){
		super(driver);
		path=System.getProperty("user.dir")+"/webelementdata/"
				+this.getClass().getSimpleName()+".xml";
		try {
			locatorMap=XmlUtils.readElementInfo(path);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	//点击，输入，提交，查找元素，
	public WebElement getElement(Locator locator){
		WebElement el=null;
		ByType type=locator.getByType();
		String locatorvalue=locator.getLocatorInfo();
		try{
		switch(type){
		case id:
			el=driver.findElement(By.id(locatorvalue));
			break;
		case name:
			el=driver.findElement(By.name(locatorvalue));
			break;
		case className:
			el=driver.findElement(By.className(locatorvalue));
			break;
		case xpath:
			el=driver.findElement(By.xpath(locatorvalue));
			break;
		case cssSelector:
			el=driver.findElement(By.cssSelector(locatorvalue));
			break;
		case linkText:
			el=driver.findElement(By.linkText(locatorvalue));
			break;
		}}catch(Exception e){
			
			//如果元素识别异常开启截图，把当前页面截下来
			takeScreenShot("findElementErrorimage");
			
			log.info("元素"+locator.getElementName()+"识别异常");
			Assert.fail("元素识别失败");
		}
		return el;
	}
	//使用显示方法查找元素
	public WebElement findElement(final Locator locator){
		WebDriverWait wait = new WebDriverWait(driver, locator.getTimeOut());
		WebElement el = wait.until(new ExpectedCondition<WebElement>() {
		public WebElement apply(WebDriver d) {
		return getElement(locator);
		}
		}); 
		return el;
	}
	//click
	public void click(Locator locator){
		WebElement el=findElement(locator);
		el.click();
		log.info("点击元素"+locator.getElementName());
	}
	//submit
	public void submit(Locator locator){
		WebElement el=findElement(locator);
		el.submit();
	}
	//sendkeys
	public void input(Locator locator,String con){
		WebElement el=findElement(locator);
		el.sendKeys(con);
		log.info("在元素"+locator.getElementName()+"输入"+con);
	}
	//getText<a> </a>
	public String getText(Locator locator){
		WebElement el=findElement(locator);
		log.error("获取元素"+locator.getElementName()+"文本值");
		return el.getText();
	}
	//getattribute("")获取属性id值
	public String getAttribute(Locator locator,String by){
		WebElement el=findElement(locator);
		String value=el.getAttribute(by);
		return value;
	}
	public Locator getLocator(String locatorName){
		Locator locator=locatorMap.get(locatorName);
		return locator;
	}
	
}
