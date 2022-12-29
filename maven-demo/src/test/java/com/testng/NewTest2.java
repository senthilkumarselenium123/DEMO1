package com.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest2 {
  @Test(dataProvider = "dp")
  public void f(Integer n, String s) {
	  System.out.println("test annoatation suite2:  "+n);
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method2");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("After method2");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before Class2");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("After Class2");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before TEST2");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("After TEST2");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before Suite2");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite2");
  }

}
