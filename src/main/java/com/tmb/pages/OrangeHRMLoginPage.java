package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage {

	private final By textboxUsername = By.xpath("//input[@placeholder='Username']");
	private final By textboxPassword = By.xpath("//input[@placeholder='Password']");
	private final By loginButton = By.xpath("//button[@type='submit']");

	public OrangeHRMLoginPage enterUserName(String username) {

		sendKeys(textboxUsername, username, WaitStrategy.PRESENCE, "Username");
		
	
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String passw) {

		sendKeys(textboxPassword, passw, WaitStrategy.PRESENCE,"Password");
		
		return this;
	}

	public OrangeHRMHomePage clickLoginButton() {
		click(loginButton, WaitStrategy.CLICKABLE,"LoginButton");
		
		return new OrangeHRMHomePage();
	}

	public String getLoginPageTitle() {

	
		return getTitle();
	}
}
