package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory ::OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//hiw to initialize Page Object -- by iniElements method pointing
	//driver ---ALl the elements will be initialized with help of driver
	//this --- pointing to current class
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		//can also be written as below syntax
		//PageFactory.initElements(driver, LoginPage);
	}
	
	//Actions
	public String validateloginPageTittle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMlogo()
	{
		return crmLogo.isDisplayed();
	}
	
	//After clicking on login button, home page will be open
	//HomePage is landing page for LoginPage ---thus new HomePage return type method is created 
	public HomePage login(String usn, String pwd ){
		username.sendKeys(usn);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
	}
	
	
	
	
	
	
	
}
