package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	
	String sheetName = "contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		super.initialization();
		loginPage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		contactpage = new ContactPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToframe();
		//contactpage = new ContactPage(); ----- We will NOT be writting this b'coz ContactPage refernce is already created on HomePage
		contactpage = homepage.clickingOnContactlink(); //this should be syntax and NOT the above one
		
	}
/*	
	@Test(priority=1)
	public void ContactPageText(){
	Assert.assertTrue(contactpage.verifyContactslabel(), "Contact labelis missing");	
	}
	
	//Most probably Assertion should be written ----- only for anykind of Action perform
	
	@Test(priority=2)
	public void verifySingleTableText(){
		contactpage.selectContactsByName("sujata s");
	}
	
	@Test(priority=3)
	public void verifyMultipleTableText(){
		contactpage.selectContactsByName("sujata s");
		contactpage.selectContactsByName("joy s");
	}
*/
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title, String firstname, String lastname, String company){
		homepage.clickOnNewContactLink();
		//contactpage.createNewContact("Mr", "Tom", "Peter", "Google");
		contactpage.createNewContact(title, firstname, lastname, company);
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}


