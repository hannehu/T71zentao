package com.first.demo;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.WebDriver;

import com.first.uiframework.DriverFactory;
import com.first.uiframework.Locator;
import com.first.uiframework.Locator.ByType;
import com.first.utils.AssertUtils;
import com.first.utils.ExeclUtils;
import com.first.utils.PropertiesUtils;
import com.first.utils.TestCase;
import com.first.utils.XmlUtils;

import junit.framework.Assert;

public class Demo {

	public static void main(String[] args) throws DocumentException {
//		AssertUtils ass=new AssertUtils();
//		ass.assertNotNull(null);
//		//读excel
//		String fileName="UITestData.xlsx";
//		List<TestCase> testDataList=ExeclUtils.getUITestData(fileName);
//		for(int i=0;i<testDataList.size();i++){
//			System.out.println(testDataList.get(i).getCaseName());
//			System.out.println(testDataList.get(i).getIsCheck());
//			System.out.println(testDataList.get(i).getExpectedResult());
//			for(Entry<String,String> m:testDataList.get(i).getTestData().entrySet()){
//				System.out.println(m.getKey()+":"+m.getValue());
//			}
//		}
		
//		HashMap<String,Locator> info=XmlUtils.readElementInfo("LoginPage.xml");
//		String name=info.get("englishLink").getElementName().toString();
//		System.out.println(name);
		
//		PropertiesUtils p=new PropertiesUtils("local.properties");
//		String url=p.getPropertiesValue( "url");
//		System.out.println(url);
//		
//		WebDriver dr=DriverFactory.getChromeDriver();
//		dr.get("https://www.baidu.com");
//		
//		String path=System.getProperty("user.dir");
//		System.out.println(path);
//		String xp=System.getProperty("user.dir")+"/webelementdata/LoginPage.xml";
//		Map<String,Locator> elementinfos=new HashMap<String,Locator>();
//		SAXReader saxReader = new SAXReader();
//		Document document = saxReader.read(new File(xp));
//		Element root = document.getRootElement();
//		List<Element> childList = root.elements("locator");
//		for(Element e:childList){
//			String name=e.attributeValue("name").toString();
//			String element=e.attributeValue("value").toString();
//			int timeOut=Integer.parseInt(e.attributeValue("timeout").toString());
//			String type=e.attributeValue("type").toString();
//			Locator l=new Locator(name,element,timeOut,getType(type));
//			String keyName=e.getText();
//			elementinfos.put(keyName, l);
//			
//		}
//		System.out.println(elementinfos.get("forgetPassword").getElementName().toString());
//	}
//	public static ByType getType(String value){
//		ByType type=null;
//		switch(value){
//		case("css"):
//			type=ByType.cssSelector;
//			break;
//		case("xpath"):
//			type=ByType.xpath;
//			break;
//		}
//		return type;
//	}
	}

}
