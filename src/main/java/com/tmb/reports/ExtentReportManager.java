package com.tmb.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentReportManager {
	
	private ExtentReportManager () {}

	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	 static ExtentTest getExtentTest() {
		return test.get();
	}

	 static void setExtentTest(ExtentTest testref) {

		test.set(testref);
	}

	 static void unload() {
		test.remove(); 
	}

}
