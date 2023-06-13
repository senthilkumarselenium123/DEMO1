package com.testngexample;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTestNgExample {
	
	@DataProvider(name= "testname")
	public Object[][] testMethod()
	{
		return new Object[][] {{"1","2"}};
		
	}
	
	@Test(dataProvider = "testname")
	public static void carLoan(String aa, String bb)
	{
//		System.out.println("Car Loan-1  "+aa);
//		System.out.println("Car Loan-2  "+bb);
		
		int aaa = Integer.parseInt(aa);
		int bbb = Integer.parseInt(bb);
		for(int i=1;i<=aaa;i++)
		{
			for(int ii=1;ii<=bbb;ii++)
			{
			System.out.println("Total iteration");
			}	
		}
	}

	
}
