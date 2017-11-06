package com.first.uiframework;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.first.config.LocalConfig;
import com.first.utils.Log;

public class DriverUtils {

	protected static WebDriver driver;
	protected static MouseUtils mouse;
	protected static KeyBoardUtils keyBoard;
	protected static Log log=new Log(DriverFactory.class);
	
	public DriverUtils(WebDriver driver){
		this.driver=driver;
		mouse= new MouseUtils(driver);
		keyBoard=new KeyBoardUtils(driver);
	}
	public void openUrl(String url){
		try{
		driver.get(url);
		log.info("打开网站"+url);
	}catch(Exception e){
		Assert.fail("打开URL失败");
	}
	}
	public void close(){
		driver.close();
		log.info("关闭浏览器");
	}
	public void quit(){
		driver.quit();
		log.info("退出关闭浏览器");
	}
	public void maxWindows(){
		driver.manage().window().maximize();
	}
	public void implicitlyWait(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void back(){
		driver.navigate().back();
		log.info("返回上一步");
	}
	public void forward(){
		driver.navigate().forward();
		log.info("前进");
	}
	public void refresh(){
		driver.navigate().refresh();
	}
	public String getUrl(){
		String URL=driver.getCurrentUrl();
		return URL;
	}
	public String getTitle(){
		String title=driver.getTitle();
		return title;
	}
	public static void wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//截图
	public void takeScreenShot(String... pngName){
		String fileName;
		String filePath=LocalConfig.SCREENSHOTPATH;
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdir();
		}
		if(pngName.length==0){
			fileName="shotImage";
		}else{
			fileName=pngName[0];
		}
		SimpleDateFormat sf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Calendar cal=Calendar.getInstance();
		Date date=cal.getTime();
		String dateStr=sf.format(date);
		String path="\\"+ filePath+"\\"+fileName+"_"+dateStr+".png";
		takeScreenShot(driver,path);
	}
	public void takeScreenShot(WebDriver driver,String path){
		String currentPath=System.getProperty("user.dir");
		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File picFile=new File(currentPath+path);
		  try {
	            FileUtils.copyFile(scrFile, picFile);
	            log.info("截图保存的路径:" + path);
	            log.info("截图成功");
	        } catch (Exception e) {
	            log.error("截图失败");
	            e.printStackTrace();
	        }
		  log.screenShotLog("截图："+scrFile,picFile);
	}
	
}
