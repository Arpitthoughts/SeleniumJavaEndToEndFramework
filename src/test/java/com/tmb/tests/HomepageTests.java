package com.tmb.tests;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tmb.driver.DriverManager;

public final class HomepageTests extends BaseTests {

	private HomepageTests() {
	}

	@Test
	public void test3() {

		/*
		 * Validate whether the title is containing Google Search or google search
		 * validate whether the title is not null and the length of title is greater
		 * than 15 and less than 100 Check for the links in the pages --> Testing mini
		 * bytes - Youtube number of links displayed is exactly 10 or 15.
		 */

		DriverManager.getDriver().findElement(By.name("q")).sendKeys("naveen automationlabs", Keys.ENTER);
		String title=DriverManager.getDriver().getTitle();
		
		assertThat(title)
		.contains("Google Search")
		.hasSizeBetween(15, 100);
		
		
		
		List<WebElement>links=DriverManager.getDriver().findElements(By.xpath("//h3"));
		
		assertThat(links)
		.extracting(e->e.getText()).contains("Naveen AutomationLabs – Medium");
	}

}
