package com.testngexample;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotationTestDependsOnGroups {
	
	
	@Test(dependsOnGroups = {"SMOKE"})
	public static void carLoan1()
	{
		System.out.println("Car Loan-1");
	}

	@Test(groups = {"SMOKE"})
	public static void carLoan2()
	{
		System.out.println("Car Loan-2");
	}

	@Test()
	public static void carLoan3()
	{
		System.out.println("Car Loan-3");
	}

	
}
