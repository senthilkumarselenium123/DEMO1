package com.testngexample;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotationTestAllScenarios {
	
	@BeforeSuite
	public static void beforeSuiteExample()
	{
		System.out.println("Before Suite Example");
	}
	
	@BeforeTest
	public static void beforeTestExample()
	{
		System.out.println("Before Test Example");
	}
	
	@Test(priority=0)
	public static void carLoan1()
	{
		System.out.println("Car Loan-1");
	}

	@Test(priority=1)
	public static void carLoan2()
	{
		System.out.println("Car Loan-2");
	}

	@Test(priority=2)
	public static void carLoan3()
	{
		System.out.println("Car Loan-3");
	}

	
}
