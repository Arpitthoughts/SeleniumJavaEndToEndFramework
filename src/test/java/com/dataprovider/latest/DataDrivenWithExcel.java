package com.dataprovider.latest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataDrivenWithExcel {

	@DataProvider
	public    Object[] giveDataFromExcel() throws IOException {

		FileInputStream fin = new FileInputStream(

				System.getProperty("user.dir") + "/src/test/java/com/dataprovider/latest/testData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalRows = sheet.getLastRowNum(); // 3
		int totalCol = sheet.getRow(0).getLastCellNum(); // 4

		System.out.println(totalRows + "  " + totalCol);
		Object[] data = new Object[totalRows];
		Map<String, String> hm = null;
		for (int i = 1; i <= totalRows; i++) {
			hm = new HashMap<>();
			for (int j = 0; j < totalCol; j++) {

				String key = sheet.getRow(0).getCell(j).getStringCellValue();
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				hm.put(key, value);

			}
			data[i - 1] = hm;

		}
		workbook.close();
		return data;
	}
}
