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

public class NewTest3 {

  @Test (invocationCount = 10, threadPoolSize=2)
  public void afterSuite() {
	  System.out.println("TESTTTTT33333333");
	  System.out.println("TESTTTTT33333334");
  }

}
