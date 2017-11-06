package com.first.utils;

import java.util.HashMap;
import java.util.Map;

public class TestCase {

	private String caseName;
//	private String isRun;
	private String isCheck;
	private String expectedResult;
	private Map<String,String> testData = new HashMap<String,String>();
	public TestCase(String caseName,String isCheck,String expectedResult,Map<String,String> testData){
		this.caseName=caseName;
	//	this.isRun=isRun;
		this.isCheck=isCheck;
		this.expectedResult=expectedResult;
		this.testData=testData;
	}


	public Map<String, String> getTestData() {
		return testData;
	}

	public String getCaseName() {
		return caseName;
	}

	public String getIsCheck() {
		return isCheck;
	}

	public String getExpectedResult() {
		return expectedResult;
	}
	
}
