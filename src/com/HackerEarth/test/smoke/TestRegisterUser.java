package com.HackerEarth.test.smoke;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HackerEarth.test.config.CreateWebDriver;
import com.HackerEarth.ui.RegisterUserPage;

import com.HackerEarth.utils.TakeScreenShot;

public class TestRegisterUser {
	WebDriver driver;
	RegisterUserPage RegPage;
	
	@BeforeMethod
	public void setup(){
		driver=CreateWebDriver.instance();
		RegPage=new RegisterUserPage(driver);
	}
	@Test
	public void testNewUserRegistration(){
		RegPage.clickSignUp();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		RegPage.giveFirstName();
		RegPage.giveLastName();
		RegPage.giveEmail();
		RegPage.givePassword();
		RegPage.clickStart();
		RegPage.validateWelcomeMsg();
		RegPage.selectProfile();
		RegPage.clickNext();
		RegPage.selectExperience();
		RegPage.giveCmpnyName();
		RegPage.giveJobTitle();
		RegPage.clickNextDetails();
		RegPage.selectProgrammingSkills();
		RegPage.clickFinish();
		RegPage.Logout();
	}
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(ITestResult.FAILURE==result.getStatus()){
			TakeScreenShot ts=new TakeScreenShot(driver);
			ts.screenShot();
		}
		driver.quit();
	}
}
