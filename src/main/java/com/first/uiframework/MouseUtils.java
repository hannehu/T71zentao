package com.first.uiframework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseUtils {

	private Actions action;
	public MouseUtils(WebDriver driver){
		action = new Actions(driver);
	}
	//右击，双击，悬停，拖动
	public void rightClick(WebElement el){
		action.contextClick(el).perform();
	}
	public void doubleClick(WebElement el){
		action.doubleClick(el).perform();
	}
	public void clickHold(WebElement el){
		action.clickAndHold(el).perform();
	}
	public void clickDrag(WebElement el){
		action.dragAndDrop(el, el);
	}
}
