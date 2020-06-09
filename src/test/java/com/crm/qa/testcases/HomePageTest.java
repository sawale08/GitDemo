package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactpage;
	public HomePageTest() {
		super();
	//super() --- has to be called bcoz we Need initialization() method from TestBase class
		//to do this initialization method needs prop initialization -- which is under TestBase constructor 
		//TestBase is parent class of ALL 
		//while calling define function of parent class constructor --- super() has to be used.
	}
	
	@BeforeMethod
	public void setup(){
		super.initialization();
		loginPage = new LoginPage();
		testutil = new TestUtil();
		contactpage = new ContactPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateTittleTest()
	{
		String tittle = homepage.ValidTittle();
		Assert.assertEquals(tittle, "CRMPRO", "Home Page tittle NOT matched");
	}
	
	@Test(priority=2)
	public void validUserNameTest()
	{
		testutil.switchToframe();
		Assert.assertTrue(homepage.ValidUserName());
		
	}
	
	@Test(priority=3)
	public void verifyContactslink(){
	testutil.switchToframe();
	contactpage = homepage.clickingOnContactlink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
