package com.HackerEarth.utils;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.events.EventFiringWebDriver;



public class TakeScreenShot {
	
	WebDriver driver;
	
	public  TakeScreenShot(WebDriver driver) {
		this.driver=driver;
	}

	
	public void screenShot() throws IOException{
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		EventFiringWebDriver edriver=new EventFiringWebDriver(driver) ;
		File src=edriver.getScreenshotAs(OutputType.FILE);
		String fPath="./ScreenShot/scnshot";
		DateFormat df=new SimpleDateFormat("dd-MMM-yy_hhmmss");
		String fName=fPath+df.format(new Date())+".jpg";
		System.out.println(fName);
		File dest=new File(fName);
		FileUtils.copyFile(src, dest);
	}
}
