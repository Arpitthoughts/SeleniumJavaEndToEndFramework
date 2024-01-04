package com.tryresources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class TryWithResources {

	public static void main(String[] args) {

		Test();

	}

	private static void Test() {
		a();

	}

	private static void a() {
		
		try(FileInputStream file=new FileInputStream("C://")) {
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
