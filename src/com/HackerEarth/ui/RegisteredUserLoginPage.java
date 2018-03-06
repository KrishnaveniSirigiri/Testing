package com.HackerEarth.ui;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.HackerEarth.utils.GetTestData;

public class RegisteredUserLoginPage {
	WebDriver driver;
	public RegisteredUserLoginPage(WebDriver driver){
		this.driver=driver;
	}
	public void clickLoginLink(){
		String LoginLink=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 27, 2);
		driver.findElement(By.xpath(LoginLink)).click();
	}
	public void giveUserNameOrEmail(){
		String UserNameOrEmail=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 28, 2);
		String UserNameOrEmailValue=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 28, 3);
		driver.findElement(By.xpath(UserNameOrEmail)).sendKeys(UserNameOrEmailValue);
	}
	public void givePassword(){
		String Password=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 29, 2);
		String PwdValue=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 29, 3);
		driver.findElement(By.xpath(Password)).sendKeys(PwdValue);
	}
	public void clickLoginButton(){
		String LoginButton=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 30, 2);
		driver.findElement(By.xpath(LoginButton)).click();
	}
	public void navigateToPracticeTab(){
		String PracticeTab=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 31, 2);
		driver.findElement(By.linkText(PracticeTab)).click();
	}
	public void selectOptionFromAllTracks(){
		String selectOptionAllTracks=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 32, 2);
		driver.findElement(By.xpath(selectOptionAllTracks)).click();
	}
	public void clickProblemsTab(){
		String ProblemsTab=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 33, 2);
		driver.findElement(By.linkText(ProblemsTab)).click();
	}
	public void clickOptionFromProblems(){
		String OptionFromProblems=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 34, 2);
		driver.findElement(By.linkText(OptionFromProblems)).click();
	}
	public void selectLangugaeFromEditor(){
		String LanguageDropDownSelector=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 35, 2);
		String SelectionValue=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 36, 2);
		WebElement SelectorElement=driver.findElement(By.id(LanguageDropDownSelector));
		Select sct=new Select(SelectorElement);
		sct.selectByValue(SelectionValue);
	}
	public void typeInCodeEditor(){
		String TextAreaElement=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 37, 2);
		
		String jscommand="window.scroll(0, 800)";
		JavascriptExecutor jsdriver=(JavascriptExecutor) driver;
		jsdriver.executeScript(jscommand);
		WebElement element=driver.findElement(By.xpath(TextAreaElement));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		element.sendKeys(Keys.CONTROL+"a");
		element.sendKeys(Keys.DELETE);
		element.sendKeys("public class PalindromeString {");
		element.sendKeys(Keys.ENTER);
		element.sendKeys(" public static void main (String []args){");
		element.sendKeys(Keys.ENTER);
		String v="String s="+"\""+"aba"+"\""+";";
		element.sendKeys(v);
		element.sendKeys(Keys.ENTER);
		element.sendKeys("String r="+"\""+"\""+";");
		element.sendKeys(Keys.ENTER);
		element.sendKeys("for(int i=s.length()-1;i>=0;i--){");
		element.sendKeys(Keys.ENTER);
		element.sendKeys("r=r+s.charAt(i);");
		element.sendKeys(Keys.DOWN);
		element.sendKeys(Keys.ENTER);
		element.sendKeys("if(s.equals(r)){");
		element.sendKeys(Keys.ENTER);
		element.sendKeys("System.out.println("+"\""+"YES"+"\""+");");
		element.sendKeys(Keys.DOWN);
		element.sendKeys(Keys.ENTER);
		element.sendKeys("else{");
		element.sendKeys(Keys.ENTER);
		element.sendKeys("System.out.println("+"\""+"NO"+"\""+");");
		element.sendKeys(Keys.DOWN);
		element.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	public void clickOnCompileAndTest(){
		String CompileAndTestButton=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 38, 2);
		driver.findElement(By.id(CompileAndTestButton)).click();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	public void validateCompilation(){
		String ActualElement=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 40, 2);
		WebElement element=driver.findElement(By.xpath(ActualElement));
		Boolean status=element.isDisplayed();
		if(status==true){
			System.out.println(status);
		}
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	
	public void clickOnSubmit(){
		String SubmitButton=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 39, 2);
		WebElement element=driver.findElement(By.id(SubmitButton));
		Actions act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}
	public void validateSubmit(){
		String SubmitElement=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 41, 2);
		Boolean status=driver.findElement(By.xpath(SubmitElement)).isDisplayed();
		if(status==true){
			System.out.println(status);
		}
	}
	public void Logout(){
		String HomeDropdown=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 24, 2);
		String LogoutElement=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 24, 2);
		WebElement element=driver.findElement(By.xpath(HomeDropdown));
		Actions act=new Actions(driver);
		act.moveToElement(element).click().build().perform();
		WebElement element2=driver.findElement(By.xpath(LogoutElement));
		act.moveToElement(element2).click().build().perform();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("loggedout");
	}
}
