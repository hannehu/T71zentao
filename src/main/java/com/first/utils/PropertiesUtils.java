package com.first.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
	private static Properties p=null;
	private static String propertiesFileName=null;
	public PropertiesUtils(String fileName){
		this.propertiesFileName=fileName;
	}
	public String getPropertiesValue(String key){
	InputStream in=PropertiesUtils.class.getClassLoader().getResourceAsStream("com/first/config/"+propertiesFileName);
	p=new Properties();
	String value=null;
	try {
		p.load(in);
		value=p.getProperty(key);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return value;
	
	}
}
