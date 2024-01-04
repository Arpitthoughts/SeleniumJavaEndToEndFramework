package com.tmb.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tmb.constants.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public class ExplicitWaitFactory {
	
	private ExplicitWaitFactory() {
		
	}

	public static WebElement performExplicitWait(By by, WaitStrategy waitStrategy) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.PRESENCE) {
			element = WaitUtils.waitUntilElementIsPresent(by, FrameworkConstants.getWaitTime());
		} else if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = WaitUtils.waitUntilElementIsClickable(by, FrameworkConstants.getWaitTime());
		} else {
			element=DriverManager.getDriver().findElement(by);
		}
		return element;
	}

}
