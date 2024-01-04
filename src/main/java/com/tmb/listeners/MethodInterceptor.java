package com.tmb.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.constants.FrameworkConstants;
import com.tmb.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor{
	
	//This class is used to alter the list of test methods that TestNG is about to run. 


	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String,String>> testDetails=ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagerdata());
		List<IMethodInstance> result = new ArrayList<>();
		
		for(int i=0;i<methods.size();i++) {
			
			for(int j=0;j<testDetails.size();j++) {
				
				if(testDetails.get(j).get("Testname").equalsIgnoreCase(methods.get(i).getMethod().getMethodName()) && (testDetails.get(j).get("execute").equalsIgnoreCase("yes"))) {
						
						methods.get(i).getMethod().setPriority(Integer.parseInt(testDetails.get(j).get("priority")));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(testDetails.get(j).get("count")));
						methods.get(i).getMethod().setDescription(testDetails.get(j).get("testdescription"));
					
						result.add(methods.get(i));
					
					
				}
			}
		}
		
		
		
		return result;
	}
	

}
