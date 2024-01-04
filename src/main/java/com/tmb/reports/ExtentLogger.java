package com.tmb.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;
import com.tmb.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void logPassDetails(String message) {

		ExtentReportManager.getExtentTest().log(Status.PASS, MarkupHelper.createLabel(message, ExtentColor.GREEN));

	}

	public static void logInfoDetails(String message) {
		ExtentReportManager.getExtentTest().log(Status.INFO, MarkupHelper.createLabel(message, ExtentColor.GREY));
	}

	public static void logFailDetails(String message) {

		ExtentReportManager.getExtentTest().log(Status.FAIL, MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	public static void logPassDetails(String message, boolean isScreenShotNeeded) {

		try {
			if (ReadPropertyFile.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
					&& isScreenShotNeeded) {

				ExtentReportManager.getExtentTest().pass(message, MediaEntityBuilder
						.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			} else {
				logPassDetails(message);
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void logFailDetails(String message, boolean isScreenShotNeeded) {

		try {
			if (ReadPropertyFile.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
					&& isScreenShotNeeded) {

				ExtentReportManager.getExtentTest().fail(message, MediaEntityBuilder
						.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
			} else {
				logFailDetails(message);
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	public static void logSkipDetails(String message) {

		ExtentReportManager.getExtentTest().log(Status.SKIP, MarkupHelper.createLabel(message, ExtentColor.YELLOW));

	}

}
