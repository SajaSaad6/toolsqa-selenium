package com.qa.toolsqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage{
	
	private By logOutButton = By.xpath("//button[normalize-space()='Log out']");
	private By goToBookStoreButton = By.id("gotoStore");
	private By deleteAccountButton = By.xpath("//button[text()='Delete Account']");
	private By deletingModal = By.className("modal-body");
	private By acceptDeleteButton = By.id("closeSmallModal-ok");
	private By cancelDeleteButton = By.id("closeSmallModal-cancel");
	
	public NavigationPage(WebDriver driver) {
		super(driver);
	}
	
	public void clickLogOutButton() {
		jsClick(logOutButton);
	}
	
	public void clickGoToBookStoreButton() {
		jsClick(goToBookStoreButton);
	}
	
	public void clickDeleteAccountButton() {
		jsClick(deleteAccountButton);
	}
	
	public void confirmDeleteAccount() {
		waitForElement(deletingModal);
		jsClick(acceptDeleteButton);
	}
	
	public void cancelDeleteAccount() {
		waitForElement(deletingModal);
		jsClick(cancelDeleteButton);
	}
	
	public String getDeleteAccountModalText() {
		return waitForElement(deletingModal).getText();
	}
	
	public boolean isDeleteAccountModalDisplayed() {
	    return waitForElement(deletingModal).isDisplayed();
	}
}
