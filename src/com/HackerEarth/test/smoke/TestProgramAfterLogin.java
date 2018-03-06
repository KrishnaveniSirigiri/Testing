package com.HackerEarth.test.smoke;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HackerEarth.test.config.CreateWebDriver;
import com.HackerEarth.ui.RegisteredUserLoginPage;
import com.HackerEarth.utils.TakeScreenShot;

public class TestProgramAfterLogin {
	WebDriver driver;
	RegisteredUserLoginPage LoginPage;
	
	@BeforeMethod
	public void setup(){
		driver=CreateWebDriver.instance();
		LoginPage= new RegisteredUserLoginPage(driver);
	}
	@Test
	public void testLoginAndProgram(){
		LoginPage.clickLoginLink();
		LoginPage.giveUserNameOrEmail();
		LoginPage.givePassword();
		LoginPage.clickLoginButton();
		LoginPage.navigateToPracticeTab();
		LoginPage.selectOptionFromAllTracks();
		LoginPage.clickProblemsTab();
		LoginPage.clickOptionFromProblems();
		LoginPage.selectLangugaeFromEditor();
		LoginPage.typeInCodeEditor();
		LoginPage.clickOnCompileAndTest();
		LoginPage.validateCompilation();
		LoginPage.clickOnSubmit();
		LoginPage.validateSubmit();
		LoginPage.Logout();

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
