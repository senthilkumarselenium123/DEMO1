package com.testng;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.code.App;

import io.github.bonigarcia.wdm.WebDriverManager;
import webDriverFactory.DriverFactory;

public class RetryANalyzerDemo {
  
//  @Test (retryAnalyzer = MyRetry.class)
//  public void f() {
//		System.out.println("Retry Analyzer Demo");
//		 Assert.fail();
//
//  }
	
	@Test
	  public void f() {
			System.out.println("Retry Analyzer Demo");
			 Assert.fail();

	  }
}
