package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: sujatas s')]")
	WebElement usernameText;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[text()='Deals']")
	WebElement Dealskink;
	
	@FindBy(xpath="//a[text()='Tasks']")
	WebElement Taskslink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement NewContactlink;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
		
	}
	
	public String ValidTittle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidUserName()
	{
		return usernameText.isDisplayed();
	}
	
	//these are called Page Library
	public ContactPage clickingOnContactlink(){
		ContactsLink.click();
		return new ContactPage();
	}
	
	public DealPage clickOnDealsTab(){
		Dealskink.click();
		return new DealPage();
	}
	
	public TaskPage clickOnTaskTab(){
		Taskslink.click();
Taskslink.click();

Taskslink.click();

		return new TaskPage();
	}
	
	public void clickOnNewContactLink(){
		Actions act = new Actions(driver);
		act.moveToElement(ContactsLink).build().perform();
		NewContactlink.click();
	}
	
	
}
