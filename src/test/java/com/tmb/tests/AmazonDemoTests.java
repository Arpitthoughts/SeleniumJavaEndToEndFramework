package com.tmb.tests;

import java.util.Map;

import org.testng.annotations.Test;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.pages.AmazonHomePage;

public final class AmazonDemoTests extends BaseTests {

	private AmazonDemoTests() {}
	
	
	@FrameworkAnnotation(author= {"Sachin","Ravi"}, category = { "Smoke","Regression" })
	@Test
	public void amazonTest(Map<String,String> data) {

	/*String title=	new AmazonHomePage().clickHamBurger().clickMobilesAndComputers().clickOnSubMenuItem(data.get("menuText")).getLaptopPageTitle();
	Assertions.assertThat(title).containsIgnoringCase("Laptop");*/
		//ExtentReportManager.getExtentTest().assignAuthor("Sachin","Ravi").assignCategory("Regression","Smoke");
		new AmazonHomePage().clickHamBurger().clickMobilesAndComputers();
	
	}


}
