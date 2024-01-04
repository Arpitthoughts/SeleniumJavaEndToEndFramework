package com.tmb.enums;

public class EnumRunner {

	public static void main(String[] args) {

		System.out.println(ConfigProperties.URL.name().toLowerCase());
		for(ConfigProperties s:ConfigProperties.values()) {
			System.out.println(s.name());
		}

	}
}
