package com.qa.toolsqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
	
	private By usernameInput = By.id("userName");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login");
	private By errorMessage = By.id("name");
	private By newUserButton = By.id("newUser");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String username, String password) {
		enterText(usernameInput, username);
		enterText(passwordInput, password);

		jsClick(loginButton);
	}
	
	public boolean isUserNameInvalid() {
		return isFieldInvalid(usernameInput);
	}
	
	public boolean isPasswordInvalid() {
		return isFieldInvalid(passwordInput);
	}
	
	public String getErrorMessage() {
		return getText(errorMessage);
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void clickNewUserButton() {
		wait.until(ExpectedConditions.elementToBeClickable(newUserButton));
		jsClick(newUserButton);
	}
	
}
