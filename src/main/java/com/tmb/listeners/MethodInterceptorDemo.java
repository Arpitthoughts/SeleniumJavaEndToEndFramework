package com.tmb.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class MethodInterceptorDemo implements IMethodInterceptor {

	//this method gives the list of all TestMethods that will be executed
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

		List<IMethodInstance> result = new ArrayList<>();
		

		Map<String, String> test1 = new HashMap<>();
		test1.put("Testcase name", "TestOrangeHRM");
		test1.put("Count", "2");

		Map<String, String> test2 = new HashMap<>();
		test2.put("Testcase name", "Test2");
		test2.put("Count", "3");

		List<Map<String, String>> list = new ArrayList<>();
		list.add(test1);
		list.add(test2);
		
		for(int i=0;i<methods.size();i++) {
			
			for(int j=0;j<list.size();j++) {
			
				if(list.get(j).get("Testcase name").equalsIgnoreCase(methods.get(i).getMethod().getMethodName())) {
					
					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));	
				
					result.add(methods.get(i));
				}
		}
		}
		
		return result;

	}

}
