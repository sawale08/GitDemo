package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homepage;
	public LoginPageTest() {
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
		homepage = new HomePage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String tittle = loginPage.validateloginPageTittle();
		Assert.assertEquals(tittle, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void CRMlogoImageTest(){
		boolean flag =loginPage.validateCRMlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void logintest(){
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
