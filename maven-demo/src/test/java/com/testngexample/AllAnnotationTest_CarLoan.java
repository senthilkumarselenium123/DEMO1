package com.testngexample;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AllAnnotationTest_CarLoan {
	
	@Test(priority=0)
	public static void carLoan()
	{
		System.out.println("Car Loan-1");
	}

	@AfterSuite
	public static void afterSuiteExample()
	{
		System.out.println("After Suite Example");
	}
	
}
