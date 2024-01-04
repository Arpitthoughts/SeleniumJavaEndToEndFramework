package com.tmb.listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Runner {
	
	
	@Test()
	public void Test1() {
		System.out.println("Test 1 method");
	
	}
	
	@Test(retryAnalyzer=Retry.class)
	public void Test2() {
		System.out.println("Test 2 method");
		Assert.assertTrue(false);
	}
	
	@Test
	public void Test3() {
		System.out.println("Test 3 method");
	}
	

}
