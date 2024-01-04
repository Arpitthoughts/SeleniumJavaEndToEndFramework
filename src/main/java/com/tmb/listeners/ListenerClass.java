package com.tmb.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tmb.annotations.FrameworkAnnotation;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReport();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReport();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName() + "--" + result.getMethod().getDescription());
		ExtentReport.addAuthor(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategory(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.logPassDetails(result.getMethod().getMethodName() + " test is passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.logFailDetails(result.getMethod().getMethodName() + " test is failed", true);
		ExtentLogger.logFailDetails(result.getThrowable().toString());
		StackTraceElement[] stackTrace = result.getThrowable().getStackTrace();
		String stackTraceError = Arrays.toString(stackTrace);
		stackTraceError = stackTraceError.replaceAll(",", "<br>");
		String formattedstackTraceError = "<details>\r\n"
				+ "  <summary>Click here to view Exception Details</summary>\r\n" + "  <p>" + stackTraceError
				+ "</p>\r\n" + "</details>";
		ExtentLogger.logFailDetails(formattedstackTraceError);
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		ExtentLogger.logSkipDetails("Test is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ExtentLogger.logFailDetails(result.getThrowable().toString());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ExtentLogger.logFailDetails(result.getThrowable().toString());
	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}
