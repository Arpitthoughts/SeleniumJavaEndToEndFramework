package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {
	}

	public static ExtentTest test;
	private static ExtentReports extentReports;

	public static void initReport()  {
		if (Objects.isNull(extentReports)) {
			extentReports = new ExtentReports();

			ExtentSparkReporter exSparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			exSparkReporter.config().setDocumentTitle("OrangeHRM");
			exSparkReporter.config().setReportName("OrangeHRM Report");
			exSparkReporter.config().setTheme(Theme.STANDARD);
			exSparkReporter.config().setEncoding("UTF-8");

			extentReports.attachReporter(exSparkReporter);

		}

	}

	public static void createTest(String testMethodName) {

		test = extentReports.createTest(testMethodName);
		ExtentReportManager.setExtentTest(test);
	}

	public static void flushReport() throws IOException  {

		if (Objects.nonNull(extentReports)) {
			extentReports.flush();

		}

		ExtentReportManager.unload();

		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());

	}

	public static void addAuthor(String[] authors) {
		for (String author : authors) {
			ExtentReportManager.getExtentTest().assignAuthor(author);
		}

	}

	public static void addCategory(CategoryType[] category) {

		for (CategoryType temp : category) {
			ExtentReportManager.getExtentTest().assignCategory(temp.name());
		}
	}
}
