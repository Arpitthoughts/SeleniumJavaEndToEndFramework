package com.dataprovider.latest;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@BeforeMethod()
	public void BMTest(Object[] data) {
	
		System.out.println(Arrays.toString(data));
		System.out.println("first");
	}

	@Test(dataProvider = "getEmployeeData", dataProviderClass = Employee.class, enabled = false)
	public void test1(Employee emp) {

		System.out.println(emp.getId() + " " + emp.getName());

	}

	@Test(dataProvider = "giveDataFromExcel", dataProviderClass = DataDrivenWithExcel.class, enabled = false)
	public void DataFromExcelTest(Map<String, String> hm) {

		System.out
				.println(hm.get("username") + " " + hm.get("password") + " " + hm.get("city") + " " + hm.get("state"));

	}

	@Test(dataProvider = "giveDataFromJson", dataProviderClass = DataDrivenWithJson.class, enabled = false)
	public void DataFromJsonTest(Map<String, String> hm) {

		for (Entry<String, String> entry : hm.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		// System.out.println(hm.get("username") + " "+hm.get("password") + " "+
		// hm.get("city")+ " "+hm.get("state"));

	}

	@Test(dataProvider = "giveData")
	public void giveDataTest(String fname, String lname) {
		System.out.println("second");
		System.out.println(fname + " " + lname);
	}

	@DataProvider
	public Object[] getData() {
		Object[][] fruits = { { "apple" }, { "mango" }, { "guava" } };
		return fruits;
	}

	@DataProvider
	public Object[][] giveData() {
		return new Object[][] {

				{ "Amuthan", "Sakthivel" }, { "Arpit", "Arjaria" }

		};

	}

}
