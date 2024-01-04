package com.tmb.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	/*
	 * If any test method is failed then retry method return false by default means
	 * no retry logic should be executed. If any test method is failed and if retry
	 * method return true then test method will be executed endlessly. So we need to
	 * create a custom logic in order to implement retry mechanism correctly.
	 */

	int counter=0;
	int limit=2;
	@Override
	public boolean retry(ITestResult result) {

		if(counter<limit) {
			counter++;
			return true;
		}
		
		
		return false;
	}

}
