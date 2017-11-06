package com.first.uiframework;

public class Locator {

	private String elementName;
	private String locatorInfo;
	private int timeOut;
	private ByType byType;
	public enum ByType{
		xpath,id,cssSelector,linkText,name,className,partialLinkText,tagName
	}
	public Locator(String name,String element,int waitSec,ByType byType){
		this.elementName=name;
		this.locatorInfo=element;
		this.timeOut=waitSec;
		this.byType=byType;
	}

	public String getElementName() {
		return elementName;
	}

	public String getLocatorInfo() {
		return locatorInfo;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public ByType getByType() {
		return byType;
	}
	
}

