package com.tmb.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public class Driver {

	private Driver() {
	}

	public static void initDriver(String browserName)  {
		WebDriver driver = null;
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		if (Objects.isNull(DriverManager.getDriver())) {
			if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver(options);
				DriverManager.setDriver(driver);
			} else if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			}
		}
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().get(ReadPropertyFile.get(ConfigProperties.URL));

	}

	public static void quitDriver() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
