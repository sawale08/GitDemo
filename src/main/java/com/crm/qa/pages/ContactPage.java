package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{

	@FindBy(xpath="//td[contains(text(), 'Contacts']")
	WebElement contactslabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactslabel(){
		return contactslabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td"
				+ "[@class='datalistrow']//input[@name='contact_id']")).click();
	}
	
	//Write Select for dropdown only when you want to open or click one of the item from dropdown list
	//write only Action for mousehover, here in this case nothing is being clicked u
	public void createNewContact(String title, String ftname, String ltname, String comp){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		company.sendKeys(comp);
		saveBtn.click();
	
		
	}
}
