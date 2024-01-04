package com.tmb.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.tmb.driver.DriverManager;

public final class JavaScriptExecutorUtils {

	private JavaScriptExecutorUtils() {
	}

	public static void scrollToElement(By xpath) {

		WebElement element = DriverManager.getDriver().findElement(xpath);
		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public static void scrollToElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	

}
