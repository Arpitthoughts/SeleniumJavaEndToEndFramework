package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.enums.WaitStrategy;

public class OrangeHRMHomePage extends BasePage {

	private final By paulCollingsDd = By.cssSelector(".oxd-userdropdown-tab");
	private final By linkLogOut = By.cssSelector("a[href*='logout']");

	public OrangeHRMHomePage clickProfileOption() {
		click(paulCollingsDd, WaitStrategy.CLICKABLE, "Welcome link");
		return this;
	}

	public OrangeHRMLoginPage clickLogOut() {
		click(linkLogOut, WaitStrategy.CLICKABLE, "Logout button");

		return new OrangeHRMLoginPage();
	}

}
