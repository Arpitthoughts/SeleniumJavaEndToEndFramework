package com.tmb.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.tmb.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils() {
	}

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider(parallel = true)
	public static Object[] getData(Method m) {
		String testName = m.getName();
		System.out.println(testName);

		if (list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationtestdata());
		}

		List<Map<String, String>> smallList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).get("testname").equalsIgnoreCase(testName)
					&& (list.get(i).get("execute").equalsIgnoreCase("yes"))) {

				smallList.add(list.get(i));

			}

		}

		return smallList.toArray();
	}

}
