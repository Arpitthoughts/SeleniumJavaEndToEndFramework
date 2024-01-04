package com.tmb.utils;

public final class DynamicXpathUtils {

	private DynamicXpathUtils() {}
	
	
	public static String getXpath(String xpath,String menuText) {
		
		return xpath.replace("%replace%", menuText);
	}
}
