package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public class FrameworkConstants {

	private FrameworkConstants() {
	}

	private static final String RESOURCESPATH = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCESPATH + "/config/config.properties";
	private static final int WAITTIME = 10;
	private static final String EXTENTREPORTFOLDER = System.getProperty("user.dir") + "/extent-output-report/";
	private static final String EXCELTESTDATA = RESOURCESPATH + "/testdata/TestData.xlsx";
	private static final String RUNMANAGERDATA = "RUNMANAGER";
	private static final String ITERATIONTESTDATA = "DATA";
	private static String extentReportFilePath = "";
	
	public static String getExtentReportFilePath() throws Exception {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
			System.out.println(extentReportFilePath);
		}
		return extentReportFilePath;
	}

	private static String createReportPath() throws Exception {

		if (ReadPropertyFile.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return EXTENTREPORTFOLDER + "index.html";

		} else {

			return EXTENTREPORTFOLDER + System.currentTimeMillis() + "/index.html";

		}

	}

	public static int getWaitTime() {
		return WAITTIME;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

	public static String getExcelTestDataPath() {

		return EXCELTESTDATA;
	}
	
	public static String getRunmanagerdata() {
		return RUNMANAGERDATA;
	}

	public static String getIterationtestdata() {
		return ITERATIONTESTDATA;
	}


}
