package com.qa.toolsqa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage{
	
	
	private By firstnameField = By.id("firstname");
	private By lastnameField = By.id("lastname");
	private By usernameField = By.id("userName");
	private By passwordField = By.id("password");
	private By registerButton = By.id("register");
	private By recaptchaFrame = By.xpath("//iframe[contains(@src, 'recaptcha')]");
	private By recaptchaCheckbox = By.xpath("//*[@id=\"recaptcha-anchor\"]/div[3]");
	private By successMessage = By.xpath("//div[contains(text(),'User Register Successfully.')]");
    private By errorMessage = By.id("name"); //It should be the error message for everthing
    private By backToLoginButton = By.id("gotologin");
    
    public RegistrationPage(WebDriver driver) {
    	super(driver);
    }
    
    public void enterFirstName(String firstname) {
    	driver.findElement(firstnameField).sendKeys(firstname);
    }
    
    public void enterLastName(String lastname) { 
    	driver.findElement(lastnameField).sendKeys(lastname);
    }
    
    public void enterUserName(String username) {
    	driver.findElement(usernameField).sendKeys(username);
    }
    
    public void enterPassword(String password) {
    	driver.findElement(passwordField).sendKeys(password);
    }
    
    public void clickRegisterButton() {
    	jsClick(registerButton);
    }
    
    public void solveRecaptcha() {
    	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(recaptchaFrame));
    	driver.findElement(recaptchaCheckbox).click();
    	driver.switchTo().defaultContent();
    }
    
    public void fillRegistrationForm(String firstname, String lastname, String username, String password) {
    	enterFirstName(firstname);
    	enterLastName(lastname);
    	enterUserName(username);
    	enterPassword(password);
    }
    
    public void registerWithRecaptcha(String firstname, String lastname, String username, String password) {
    	fillRegistrationForm(firstname, lastname, username, password);
    	solveRecaptcha();
    	clickRegisterButton();
    }
    
    public void registerWithoutRecaptcha(String firstname, String lastname, String username, String password) {
    	fillRegistrationForm(firstname, lastname, username, password);
    	clickRegisterButton();
    }
    
    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
    
    public String getRecaptchaErrorMessage() {
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText();
    }
    
    public boolean isFieldInvalid(By fieldLocator) {
        WebElement field = driver.findElement(fieldLocator);
        String classes = field.getAttribute("class");
        return classes.contains("is-invalid");
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
    
    public String getUserExistsErrorMessage() {
    	WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    	return error.getText();
    }
}
