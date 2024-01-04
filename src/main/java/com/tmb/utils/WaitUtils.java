package com.tmb.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

public final class WaitUtils {
	private WaitUtils() {
		
	}

	
	public static WebElement waitUntilElementIsClickable(By locator, int waitTime) {
		return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(waitTime)).
	until(ExpectedConditions.elementToBeClickable(locator));
	
	}
	
	public static WebElement waitUntilElementIsPresent(By locator, int waitTime) {
		return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(waitTime))
	.until(ExpectedConditions.presenceOfElementLocated(locator));
	
	}
	
	
	public static void holdScript(int time)  {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	

}
