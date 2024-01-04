package com.tmb.pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.utils.ExplicitWaitFactory;

public class BasePage {

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String element) {

		ExplicitWaitFactory.performExplicitWait(by, waitStrategy).sendKeys(value);
		ExtentLogger.logInfoDetails("values are entered for " + element);

	}

	protected void click(By by, WaitStrategy waitStrategy, String element) {

		ExplicitWaitFactory.performExplicitWait(by, waitStrategy).click();
		ExtentLogger.logInfoDetails(element + " is clicked");
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

}
