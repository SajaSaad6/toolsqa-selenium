package com.qa.toolsqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
	
	private By usernameField = By.id("userName");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login");
	private By errorMessage = By.id("name");
	private By newUserButton = By.id("newUser");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void login(String username, String password) {
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);

		jsClick(loginButton);
	}
	
	public boolean isFieldInvalid(By fieldLocator) {
		WebElement field = driver.findElement(fieldLocator);
		String classes = field.getAttribute("class");
		return classes.contains("is-invalid");
	}
	
	public boolean isUserNameInvalid() {
		return isFieldInvalid(usernameField);
	}
	
	public boolean isPasswordInvalid() {
		return isFieldInvalid(passwordField);
	}
	
	public String getErrorMessage() {
		WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
		return error.getText();
	}
	
	public boolean isRedirected(String urlFragment) {
		return wait.until(ExpectedConditions.urlContains(urlFragment));
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void clickNewUesrButton() {
		wait.until(ExpectedConditions.elementToBeClickable(newUserButton));
		jsClick(newUserButton);
	}
	
}
