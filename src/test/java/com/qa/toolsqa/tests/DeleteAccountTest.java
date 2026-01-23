package com.qa.toolsqa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.toolsqa.pages.LoginPage;
import com.qa.toolsqa.pages.NavigationPage;
import com.qa.toolsqa.testdata.LoginTestData;

public class DeleteAccountTest extends BaseTest{

	private LoginPage loginPage;
	private NavigationPage navigationPage;
	
	@BeforeMethod
	public void testSetup() {
		url = "https://demoqa.com/login";
		driver.get(url);
		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
		
	}
	
	@Test (description = "Verify a confirmation message displayed to the user when delete an account")
	public void confermationMessage() {
		loginPage.login(
				LoginTestData.ValidCredential.USERNAME, 
				LoginTestData.ValidCredential.PASSWORD);
		
		navigationPage.clickDeleteAccountButton();
		
		Assert.assertEquals(navigationPage.getAlertText(), "Do you want to delete your account?");
	}
	
	
	@Override
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
	
}
