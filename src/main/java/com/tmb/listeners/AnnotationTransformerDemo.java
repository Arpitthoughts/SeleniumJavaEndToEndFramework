package com.tmb.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformerDemo implements IAnnotationTransformer  {

	//this method will be called before executing each test method
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
	
	
		Map<String, Object> test1 = new HashMap<>();
		test1.put("Testcase name", "Test1");
		test1.put("Count", "2");
		test1.put("Enabled", false);

		Map<String, Object> test2 = new HashMap<>();
		test2.put("Testcase name", "Test2");
		test2.put("Count", "3");
		test2.put("Enabled", true);

		List<Map<String, Object>> list = new ArrayList<>();
		list.add(test1);
		list.add(test2);
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).get("Testcase name").toString().equalsIgnoreCase(testMethod.getName())) {
				
				if(list.get(i).get("Enabled").equals(false)) {
					annotation.setEnabled(false);
				}
				else
				{
					annotation.setEnabled(true);
					annotation.setRetryAnalyzer(Retry.class);
				}
				
			}
		}
		
	}
	

}
