package com.qa.toolsqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{
	
	
	private By firstnameField = By.id("firstname");
	private By lastnameField = By.id("lastname");
	private By usernameField = By.id("userName");
	private By passwordField = By.id("password");
	private By registerButton = By.id("register");
	private By successMessage = By.xpath("//div[contains(text(),'User Register Successfully.')]");
    private By errorMessage = By.id("name"); //It should be the error message for everthing
    private By backToLoginButton = By.id("gotologin");
    
    public RegistrationPage(WebDriver driver) {
    	super(driver);
    }
    
    public void enterFirstName(String firstname) {
    	enterText(firstnameField, firstname);
    }
    
    public void enterLastName(String lastname) { 
    	enterText(lastnameField, lastname);
    }
    
    public void enterUserName(String username) {
    	enterText(usernameField, username);
    }
    
    public void enterPassword(String password) {
    	enterText(passwordField, password);
    }
    
    public void clickRegisterButton() {
    	jsClick(registerButton);
    }
    
    public void fillRegistrationForm(String firstname, String lastname, String username, String password) {
    	enterFirstName(firstname);
    	enterLastName(lastname);
    	enterUserName(username);
    	enterPassword(password);
    }
    
    public void testRegister(String firstname, String lastname, String username, String password) {
    	fillRegistrationForm(firstname, lastname, username, password);
    	clickRegisterButton();
    }
        
    public boolean isSuccessMessageDisplayed() {
        return waitForElement(successMessage).isDisplayed();
    }
    
    public String getErrorMessage() {
        return getText(errorMessage);
    }
    
    public boolean isFirstNameInvalid() {
        return isFieldInvalid(firstnameField);
    }
    
    public boolean isLastNameInvalid() {
        return isFieldInvalid(lastnameField);
    }
    
    public boolean isUserNameInvalid() {
        return isFieldInvalid(usernameField);
    }
    
    public boolean isPasswordInvalid() {
        return isFieldInvalid(passwordField);
    }
    
    public void clickBackToLoginButton() {
    	jsClick(backToLoginButton);
    }
    
    public Alert alert() {
    	wait.until(ExpectedConditions.alertIsPresent());
    	return driver.switchTo().alert();
    }
    
    public String getAlertText() {
    	Alert alert = alert();
    	return alert.getText();
    }
    
    public void acceptAlert() {
    	Alert alert = alert();
    	alert.accept();
    }
}
