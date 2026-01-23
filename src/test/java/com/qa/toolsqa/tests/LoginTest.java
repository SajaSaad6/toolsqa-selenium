package com.qa.toolsqa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.toolsqa.pages.LoginPage;
import com.qa.toolsqa.testdata.LoginTestData;

public class LoginTest extends BaseTest{

	private LoginPage loginPage;
	@BeforeMethod
	public void testSetup() {
		url = "https://demoqa.com/login";
		driver.get(url);	
		loginPage = new LoginPage(driver);
	}
	
	@Test(description= "Verify successful login with valid credentials")
	public void testLoginWithValidCredentials() {
		loginPage.login(
				LoginTestData.ValidCredential.USERNAME, 
				LoginTestData.ValidCredential.PASSWORD);
		
		Assert.assertTrue(loginPage.isRedirected("profile"),
				"Should redirect to profile page after successful login. Current URL: " +
				driver.getCurrentUrl());
	}
	
	@Test(description = "Verify login fails when first name is empty")
	public void testLoginFailsWithEmptyUsername() {	
		loginPage.login("", LoginTestData.ValidCredential.PASSWORD);
		
		Assert.assertTrue(loginPage.isUserNameInvalid(),
				"Username field should marked as invalid when empty");
	}
	
	@Test(description = "Verify login fails when password is empty")
	public void testLoginFailWithEmptyPassword() {
		loginPage.login(LoginTestData.ValidCredential.USERNAME, "");
		
		Assert.assertTrue(loginPage.isPasswordInvalid(),
				"Password field should be marked as invalid when empty");
	}
	
	@Test(description = "Verfy password field is case-sensetive")
	public void testPasswordIsCaseSensitive() {
		loginPage.login(
				LoginTestData.ValidCredential.USERNAME, 
				LoginTestData.CaseSensitiveCredential.PASSWORD);
		
		String actualErrorMessage = loginPage.getErrorMessage();
	    
	    Assert.assertEquals(actualErrorMessage, LoginTestData.ErrorMessages.INVALID_CREDENTIALS,
	    		"Should display invalid credentials error when username case doesn't match");	
	}

	@Test(description = "Verify login fails with invalid password")
	public void testLoginFailsWithInvalidPassword(){
		
		loginPage.login(
				LoginTestData.ValidCredential.USERNAME, 
				LoginTestData.InvalidCredential.PASSWORD);

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("/login"));
	}

	@Test(description = "Verify login fails with invalid credential")
	public void testLoginFailsWithInvalidCredential() {
		loginPage.login(
				LoginTestData.InvalidCredential.USERNAME, 
				LoginTestData.InvalidCredential.PASSWORD);

		String actualErrorMessage = loginPage.getErrorMessage();
	    
	    Assert.assertEquals(actualErrorMessage, LoginTestData.ErrorMessages.INVALID_CREDENTIALS,
	    		"Should display invalid credentials error when username case doesn't match");	
	}
	/*
	 * Can't be automated
	@Test (description = "Verify user can login after a succesful registeratio")
	public void testLoginAfterRegisteration() {
		loginPage.clickNewUesrButton();
		
		registrationPage.registerWithRecaptcha(RegistrationTestData.ValidUser.FIRST_NAME,
				RegistrationTestData.ValidUser.LAST_NAME,
				RegistrationTestData.ValidUser.USERNAME,
				RegistrationTestData.ValidUser.PASSWORD);
		
		//"User Register Successfully Alert 
		//Click OK
		registrationPage.acceptAlert();
		
		//Still in Register page 
		//click Back to Login button
		registrationPage.clickBackToLoginButton();
		
		//Won't be registered because of recaptcha
	}
	*/

	
	@Override
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}

}
