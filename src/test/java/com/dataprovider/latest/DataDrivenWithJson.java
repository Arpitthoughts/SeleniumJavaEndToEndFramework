package com.dataprovider.latest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataDrivenWithJson {
	
	@DataProvider
	public  static Object  giveDataFromJson() {
		Object [] data= new Object[1];
		Map<String, String> hm = new HashMap<>();
		
		try {
			hm=new ObjectMapper().readValue(new File(System.getProperty("user.dir") + "/src/test/java/com/dataprovider/latest/testjsonData.json"), new TypeReference<HashMap<String,String>>() {});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data[0]=hm;
		return data;
		

				
	}

}
