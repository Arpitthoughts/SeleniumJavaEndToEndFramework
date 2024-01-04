package com.tmb.tests;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class AnnotationTests {

	
	@Test(priority=1,description="This is a test")
	public void testingTest(Method m) {

		System.out.println(	m.getAnnotation(Test.class).priority());
		System.out.println(m.getAnnotation(Test.class).description());
	}
}
