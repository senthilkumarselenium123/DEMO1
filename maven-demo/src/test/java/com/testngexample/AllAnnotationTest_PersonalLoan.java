package com.testngexample;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AllAnnotationTest_PersonalLoan {
	
	@Test(priority=-1)
	public static void personalLoan() throws InterruptedException
	{
		//Thread.sleep(3000);
		System.out.println("Personal Loan-3");
	}
	
	

}
