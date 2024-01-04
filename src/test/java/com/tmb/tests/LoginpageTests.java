package com.tmb.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class LoginpageTests extends BaseTests {

	private LoginpageTests() {
	}

	@Test
	public void test1() {

	
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("tmb", Keys.ENTER);

	}

	@Test
	public void test2() {

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("amazon", Keys.ENTER);

	}

}
