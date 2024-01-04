package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public class RetryFailedTests implements IRetryAnalyzer {

	int counter = 0;
	int limit = 1;

	@Override
	public boolean retry(ITestResult result) {
		boolean value = false;
		try {
			if (ReadPropertyFile.get(ConfigProperties.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
				value = counter < limit;
				counter++;

			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return value;
	}
}
