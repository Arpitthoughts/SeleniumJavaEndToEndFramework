package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.utils.DynamicXpathUtils;
import com.tmb.utils.JavaScriptExecutorUtils;

public final class AmazonHamBurgerMenuPage extends BasePage {

	@FindBy(xpath = "//div[text()='Mobiles, Computers']/parent::a")
	private WebElement MobilesAndComputer;

	public AmazonHamBurgerMenuPage() {

		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	private String linkSubMenu = "//a[text()='%replace%']";

	public AmazonHamBurgerMenuPage clickMobilesAndComputers() {
		JavaScriptExecutorUtils.scrollToElement(MobilesAndComputer);
		MobilesAndComputer.click();
		return this;
	}

	// option in sub menu
	public AmazonLaptopPage clickOnSubMenuItem(String menuText) {

		String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, menuText);
		System.out.println(newXpath);
		JavaScriptExecutorUtils.scrollToElement(By.xpath(newXpath));
	
		click(By.xpath(newXpath), WaitStrategy.NONE, menuText);
		return new AmazonLaptopPage();
	}
}
