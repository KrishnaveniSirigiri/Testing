package com.HackerEarth.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;


import com.HackerEarth.utils.GetTestData;

public class RegisterUserPage {

	WebDriver driver;
	String FirstName=null;
	String LastName=null;
	public RegisterUserPage(WebDriver driver){
		this.driver=driver;
	}
	public void clickSignUp(){
		String SignUpButton=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 5, 2);
		driver.findElement(By.xpath(SignUpButton)).click();
	}
	public void giveFirstName(){
		String FirstNameInput=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 6, 2);
		FirstName=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 6, 3);
		driver.findElement(By.xpath(FirstNameInput)).sendKeys(FirstName);
	}
	public void giveLastName(){
		String LastNameInput=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 7, 2);
		LastName=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 7, 3);
		driver.findElement(By.xpath(LastNameInput)).sendKeys(LastName);
	}
	public void giveEmail(){
		String EmailInput=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 8, 2);
		String Email=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 8, 3);
		driver.findElement(By.xpath(EmailInput)).sendKeys(Email);
	}
	public void givePassword(){
		String PwdInput=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 9, 2);
		String pwd=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 9, 3);
		driver.findElement(By.xpath(PwdInput)).sendKeys(pwd);
	}
	public void clickStart(){
		String StartButton=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 10, 2);
		driver.findElement(By.xpath(StartButton)).click();
	}
	public void validateWelcomeMsg(){
		String WelcomeText=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 11, 2);
		String WelcomeMsg=driver.findElement(By.xpath(WelcomeText)).getText();
		if(WelcomeMsg.contains(FirstName)){
			this.selectProfile();
		}
	}
	public void selectProfile(){
		String ProfileSelection=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 14, 2);
		String SelectYes=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 16, 2);
		WebElement profile=driver.findElement(By.xpath(ProfileSelection));
		profile.click();
		WebElement Yes=driver.findElement(By.xpath(SelectYes));
		Yes.click();
		
	}
	public void clickNext(){
		String NextButton=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 17, 2);
		driver.findElement(By.xpath(NextButton)).click();
	}
	public void selectExperience(){
		String exp=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 18, 2);
		String ExpValueS=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 18, 3);
		double ExpValueD=Double.parseDouble(ExpValueS);
		int ExpValueI=(int) ExpValueD;
		String ExpValue=Integer.toString(ExpValueI);
		WebElement ExpElement=driver.findElement(By.id(exp));
		Select sct=new Select(ExpElement);
		sct.selectByValue(ExpValue);
	}
	public void giveCmpnyName(){
		String CmpnyNameInput=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 19, 2);
		String CmpnyName=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 19, 3);
		driver.findElement(By.name(CmpnyNameInput)).sendKeys(CmpnyName);
	}
	public void giveJobTitle(){
		String JobTitleInput=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 20, 2);
		String JobTitle=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 20, 3);
		driver.findElement(By.name(JobTitleInput)).sendKeys(JobTitle);
	}
	public void clickNextDetails(){
		String NextButton=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 21, 2);
		driver.findElement(By.xpath(NextButton)).click();
	}
	public void selectProgrammingSkills(){
		String PrgmSkillsOption=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 22, 2);
		WebElement Element=driver.findElement(By.xpath(PrgmSkillsOption));
		if(Element.isSelected()==false){
			driver.findElement(By.xpath(PrgmSkillsOption)).click();
		}
	}
	public void clickFinish(){
		String FinishButton=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 23, 2);
		driver.findElement(By.xpath(FinishButton)).click();
	}
	public void Logout(){
		
		String LogoutSelector=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 24, 2);
		String logout=GetTestData.fromExcel("./TestData/TestData.xlsx", "SignUp", 25, 2);
			driver.findElement(By.xpath(LogoutSelector)).click();
			driver.findElement(By.xpath(logout)).click();
		
	}
}
