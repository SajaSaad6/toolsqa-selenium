package com.qa.toolsqa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.toolsqa.pages.LoginPage;
import com.qa.toolsqa.pages.NavigationPage;
import com.qa.toolsqa.testdata.LoginTestData;

public class NavigationTest extends BaseTest{

	private LoginPage loginPage;
	private NavigationPage navigationPage;
	
	@BeforeMethod
	public void testSetup() {
		url = "https://demoqa.com/login";
		driver.get(url);
		loginPage = new LoginPage(driver);
		navigationPage = new NavigationPage(driver);
	}

	@Test
	public void testUserCanLogoutFromPRofilePage() {
		loginPage.login(
				LoginTestData.ValidCredential.USERNAME,
				LoginTestData.ValidCredential.PASSWORD
				);
			
		navigationPage.clickLogOutButton();
		Assert.assertTrue(loginPage.isRedirected("login"), 
				"Should redirect to login page after successful logout. Current URL: " +
				driver.getCurrentUrl());
	}

	@Test
	public void testUserCanNavigateToBookStoreFromProfile() {
		loginPage.login(
				LoginTestData.ValidCredential.USERNAME,
				LoginTestData.ValidCredential.PASSWORD
				);
		
		navigationPage.clickGoToBookStoreButton();
		
		Assert.assertTrue(loginPage.isRedirected("books"), 
				"Should redirect to books page after clicking Go to Book Store button. Current URL: " +
				driver.getCurrentUrl());
	}
	
	@Test
	public void logoutFromBookStorePage() {
		loginPage.login(
				LoginTestData.ValidCredential.USERNAME,
				LoginTestData.ValidCredential.PASSWORD
				);
		
		navigationPage.clickGoToBookStoreButton();
		navigationPage.clickLogOutButton();
		
		Assert.assertTrue(loginPage.isRedirected("login"), 
				"Should redirect to login page after successful logout. Current URL: " +
				driver.getCurrentUrl());
	}
	
	@Override
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
	
}
