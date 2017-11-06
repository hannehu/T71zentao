package com.first.config;

import com.first.utils.PropertiesUtils;

public class LocalConfig {
	static PropertiesUtils p=new PropertiesUtils("local.properties");
	public static final String URL = p.getPropertiesValue( "url");
	public static final String CHROME_PATH = p.getPropertiesValue( "chromeDriverPath");
	public static final String SCREENSHOTPATH = p.getPropertiesValue( "shotPath");
}
