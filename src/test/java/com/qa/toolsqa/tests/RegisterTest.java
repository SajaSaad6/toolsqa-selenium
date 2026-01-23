package com.qa.toolsqa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.toolsqa.pages.RegistrationPage;
import com.qa.toolsqa.testdata.RegistrationTestData;

public class RegisterTest extends BaseTest{
	
	private RegistrationPage registrationPage;
	
	@BeforeMethod
	public void testSetup() {
		url = "https://demoqa.com/register";
		driver.get(url);
		registrationPage = new RegistrationPage(driver);
		
	}
	/*
	 * Can't be automated
	@Test(description = "Verify successful registeration with valid credentials and reCaptcha")
	public void testSuccessfulRegistration() {
		
		registrationPage.registerWithRecaptcha(
				RegistrationTestData.ValidUser.FIRST_NAME,
				RegistrationTestData.ValidUser.LAST_NAME,
				RegistrationTestData.ValidUser.USERNAME,
				RegistrationTestData.ValidUser.PASSWORD);
		
		
		Assert.assertTrue(registrationPage.isSuccessMessageDisplayed(),
				"Success message should be displayed after successful registeration");
		}

	@Test(description = "Verify registeration fails with already existing user")
	public void testRegistrationWithExistingUser() {
		
		registrationPage.registerWithRecaptcha(
				RegistrationTestData.ValidUser.FIRST_NAME,
				RegistrationTestData.ValidUser.LAST_NAME,
				RegistrationTestData.ValidUser.USERNAME,
				RegistrationTestData.ValidUser.PASSWORD);
			
		Assert.assertEquals(registrationPage.getUserExistsErrorMessage(), "User exists!",
				"User exists message should be displayed after registration with an existing user data");
		}
	 */
	
	@Test(description = "Verify registration fails when first name is empty")
	public void testRegistrationFailsWithoutFirstName() {
		registrationPage.fillRegistrationForm(
	            "",  
	            RegistrationTestData.ValidUser.LAST_NAME,
	            RegistrationTestData.ValidUser.USERNAME,
	            RegistrationTestData.ValidUser.PASSWORD
	        );
	        registrationPage.clickRegisterButton();
	        
	        Assert.assertTrue(registrationPage.isFirstNameInvalid(), 
	            "First name field should be marked as invalid when empty");
	}
	
	@Test(description = "Verify registration fails when last name is empty")
	public void testRegistrationFailsWithoutLastName() {
		registrationPage.fillRegistrationForm(
	            RegistrationTestData.ValidUser.FIRST_NAME,
	            "",  
	            RegistrationTestData.ValidUser.USERNAME,
	            RegistrationTestData.ValidUser.PASSWORD
	        );
	        registrationPage.clickRegisterButton();
	        
	        Assert.assertTrue(registrationPage.isLastNameInvalid(), 
	            "Last name field should be marked as invalid when empty");
	}

	@Test(description = "Verify registration fails when username is empty")
	public void testRegistrationFailsWithoutUsername() {
		
		registrationPage.fillRegistrationForm(
	            RegistrationTestData.ValidUser.FIRST_NAME,
	            RegistrationTestData.ValidUser.LAST_NAME,
	            "",  
	            RegistrationTestData.ValidUser.PASSWORD
	        );
	        registrationPage.clickRegisterButton();
	        
	        Assert.assertTrue(registrationPage.isUserNameInvalid(), 
	            "Username field should be marked as invalid when empty");
	    }
	
	@Test(description = "Verify registration fails when password is empty")
	public void testRegistrationFailsWithoutPassword() {
		
		registrationPage.fillRegistrationForm(
	            RegistrationTestData.ValidUser.FIRST_NAME,
	            RegistrationTestData.ValidUser.LAST_NAME,
	            RegistrationTestData.ValidUser.USERNAME,
	            ""  
	        );
	        registrationPage.clickRegisterButton();
	        
	        Assert.assertTrue(
	        		registrationPage.isPasswordInvalid(), 
	        		"Password field should be marked as invalid when empty");
	    }

	@Test(description = "Verify registration fails when reCaptcha is not completed")
	public void testRegistrationFailsWithoutRecaptcha() {
		
		registrationPage.registerWithoutRecaptcha(
	            RegistrationTestData.ValidUser.FIRST_NAME,
	            RegistrationTestData.ValidUser.LAST_NAME,
	            RegistrationTestData.ValidUser.USERNAME,
	            RegistrationTestData.ValidUser.PASSWORD
	        );
	        
	        Assert.assertEquals(
	        		registrationPage.getRecaptchaErrorMessage(), 
	        		"Please verify reCaptcha to register!", 
	        		"Expected reCaptcha error message should be displayed");
	    }
	
	@Override
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
	
	//AfterTestMethod

}
