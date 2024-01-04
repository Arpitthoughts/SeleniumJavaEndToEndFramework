package com.dataprovider.latest;

import org.testng.annotations.DataProvider;

public class Employee {
	
	private int id;
	private String name;
	
	public Employee(int id,String name){
		this.id=id;
		this.name=name;
	}

	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}


@DataProvider
public static Employee[] getEmployeeData() {

	Employee[] emp= {new Employee(1,"arpit"),new Employee(2,"raja")};
	return emp;

	
	}
	}


