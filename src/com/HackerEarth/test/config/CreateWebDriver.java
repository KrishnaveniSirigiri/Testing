package com.HackerEarth.test.config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.HackerEarth.utils.GetTestData;

public class CreateWebDriver {
	public static WebDriver instance(){
		WebDriver driver=null;
		String browserName=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 2, 3);
		String URL=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 3, 3);
		String time=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 4, 3);
		Double timeD=new Double(time);
		int Timeouts=timeD.intValue();
        if(browserName.equalsIgnoreCase("firefox")){
			
			System.setProperty("webdriver.gecko.driver", "./BrowserDrivers/Latest/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/Latest/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else{
			
			System.err.print("improper browser selection");
		}
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Timeouts, TimeUnit.SECONDS);
		driver.get(URL);
		return driver;
		
	}
}
