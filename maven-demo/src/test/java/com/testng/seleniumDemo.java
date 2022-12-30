package com.testng;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.code.App;

import io.github.bonigarcia.wdm.WebDriverManager;
import webDriverFactory.DriverFactory;

public class seleniumDemo {
	
  @Parameters("Browser")	
//  @Test 
//  public void f(String lBrowser) {
//	  if(lBrowser.equals("CHROME"))
//	  {
//		App.sample3();
//	  } 
//	  else
//	  {
//		  App.sample3();
//		  App.sample3();
//	  }
//  }
  
  @Test (invocationCount = 4,threadPoolSize = 2)
  public void f() {
		//  App.sample3();
	  DriverFactory objdriver = new DriverFactory();
		
		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		objdriver.setDriver(new ChromeDriver());
		objdriver.getDriver().get("https://www.google.com");
		objdriver.closedriver();
		
  }
}
