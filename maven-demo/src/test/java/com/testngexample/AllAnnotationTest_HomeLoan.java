package com.testngexample;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AllAnnotationTest_HomeLoan {
	
	@Test
	public static void homeLoan()
	{
		System.out.println("Home Loan-2");
	}

	@BeforeSuite
	public static void beforeSuiteExample()
	{
		System.out.println("Before Suite Example");
	}
	
	@BeforeClass
	public static void beforeClassExample()
	{
		System.out.println("Before Class Example");
	}
}
