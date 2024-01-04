package com.tmb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tmb.driver.DriverManager;

public final class AmazonHomePage extends BasePage {

	@FindBy(id = "nav-hamburger-menu")
	private WebElement linkHamBurger;

	public AmazonHomePage() {
		PageFactory.initElements(DriverManager.getDriver(), this);
	}

	public AmazonHamBurgerMenuPage clickHamBurger() {

		linkHamBurger.click();
		
		return new AmazonHamBurgerMenuPage();
	}

}
