package com.tmb.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tmb.driver.Driver;

public class BaseTests {

	protected BaseTests() {
	}

	@BeforeSuite
	protected void beforeSuite() {

}

	@AfterSuite
	protected void afterSuite() throws IOException {

	}

	@SuppressWarnings("unchecked")
	@BeforeMethod
	protected void setUp(Object[] data)  {
		Map<String, String> map = ((Map<String, String>) data[0]);
		Driver.initDriver(map.get("browser"));

	}

	@AfterMethod()
	protected void tearDown() {
		Driver.quitDriver();
	}
}
