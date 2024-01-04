package com.tmb.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {
	}

	public static List<Map<String, String>> getTestDetails(String sheetname) {
		List<Map<String, String>> testDetails = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(FrameworkConstants.getExcelTestDataPath());
			XSSFWorkbook workbook = new XSSFWorkbook(fin);
			XSSFSheet xsheet = workbook.getSheet(sheetname);
			int totalRows = xsheet.getLastRowNum();
			int totalCol = xsheet.getRow(0).getLastCellNum();

			testDetails = new ArrayList<>();
			Map<String, String> data = null;
			for (int i = 1; i <= totalRows; i++) {
				data = new HashMap<>();
				for (int j = 0; j < totalCol; j++) {
					String key = xsheet.getRow(0).getCell(j).getStringCellValue();
					String value = xsheet.getRow(i).getCell(j).getStringCellValue();
					data.put(key, value);
				}

				testDetails.add(data);
			}

		}
		catch (IOException e) {

		}

		finally {
			if (Objects.nonNull(fin)) {
				try {
					fin.close();

				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}
		return testDetails;

	}

}
