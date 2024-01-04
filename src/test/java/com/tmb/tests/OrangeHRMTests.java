package com.tmb.tests;

import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.enums.CategoryType;
import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentLogger;

public final class OrangeHRMTests extends BaseTests {

	private OrangeHRMTests() {

	}

	@FrameworkAnnotation(author= {"sam","andrew"},category= {CategoryType.MINIREGRESSION,CategoryType.SMOKE})
	@Test
	public void loginLogoutTest(Map<String, String> data) {

		String loginPageTitle = new OrangeHRMLoginPage().enterUserName(data.get("username"))
				.enterPassword(data.get("password")).clickLoginButton().clickProfileOption().clickLogOut()
				.getLoginPageTitle();
		Assertions.assertThat(loginPageTitle).isEqualTo("OrangeHRM");
		ExtentLogger.logInfoDetails(data.get("fname"));

	}

	@Test()
	public void newTest(Map<String, String> data) {

		String loginPageTitle = new OrangeHRMLoginPage().enterUserName(data.get("username"))
				.enterPassword(data.get("password")).clickLoginButton().clickProfileOption().clickLogOut()
				.getLoginPageTitle();
		Assertions.assertThat(loginPageTitle).isEqualTo("OrangeHRM");

		ExtentLogger.logInfoDetails(data.get("fname"));

	}

	/*
	 * @DataProvider(name = "LoginTestDataProvider", parallel = true) 
	 * public Object[][] getData() {
	 * 
	 * return new Object[][] { { "Admin", "admin123" }, { "Adminx", "admin123" } ,{
	 * "Adminxx", "admin!!@3" },{ "Adminrr", "admin!!4@3" } };
	 * 
	 * }
	 */

}
