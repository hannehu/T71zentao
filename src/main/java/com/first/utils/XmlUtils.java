package com.first.utils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.first.uiframework.Locator;
import com.first.uiframework.Locator.ByType;

public class XmlUtils {
	public static HashMap<String,Locator> readElementInfo(String filePath) throws DocumentException{
		//String xp=System.getProperty("user.dir")+"/webelementdata/"+fileName;
		Map<String,Locator> elementinfos=new HashMap<String,Locator>();
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(new File(filePath));
		Element root = document.getRootElement();
		List<Element> childList = root.elements("locator");
		for(Element e:childList){
			String name=e.attributeValue("name").toString();
			String element=e.attributeValue("value").toString();
			int timeOut=Integer.parseInt(e.attributeValue("timeout").toString());
			String type=e.attributeValue("type").toString();
			Locator l=new Locator(name,element,timeOut,getType(type));
			String keyName=e.getText();
			elementinfos.put(keyName, l);
	}
		return (HashMap<String, Locator>) elementinfos;
	}
	public static ByType getType(String value){
		//将字符串转换为枚举类型
		ByType type=null;
		switch(value){
		case("css"):
			type=ByType.cssSelector;
			break;
		case("xpath"):
			type=ByType.xpath;
			break;
		}
		return type;
	}
}
