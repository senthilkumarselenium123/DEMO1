package com.testng;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import com.code.App;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import webDriverFactory.DriverFactory;

public class seleniumDemo {
	
	//public static ExtentReports report;
	
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
  
  @Test (invocationCount = 0,threadPoolSize =02)
  public void f() throws IOException {
	  
	  ExtentReports reports = new ExtentReports("C:\\Users\\infok\\OneDrive\\Documents\\GitHub\\DEMO1\\maven-demo\\target\\SeleniumDemo.html");

	  ExtentTest test = reports.startTest("SeleniumDemo");
	  
		//  App.sample3();
	  DriverFactory objdriver = new DriverFactory();
		
		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		objdriver.setDriver(new ChromeDriver());
		objdriver.getDriver().get("https://www.google.com");
		String tile = objdriver.getDriver().getTitle();
		if(tile.trim().equals("Google"))
		{
			
			test.log(LogStatus.PASS,"Expected tiltle present");
			test.log(LogStatus.PASS,test.addScreenCapture(capture(objdriver))+"TEST PASSEED");
			System.out.println("PASS");
		}else
		{
			test.log(LogStatus.FAIL,"Expected tiltle present");
			test.log(LogStatus.PASS,test.addScreenCapture(capture(objdriver))+"TEST FAILED");
			System.out.println("FAIL");
		}
		objdriver.closedriver();
		reports.endTest(test);
		reports.flush();
		
		
  }
  
  
  public static String capture(DriverFactory objdriver) throws IOException {
	  File scrFile = ((TakesScreenshot) objdriver.getDriver()).getScreenshotAs(OutputType.FILE);
	  File Dest = new File("C:\\Users\\infok\\OneDrive\\Documents\\GitHub\\DEMO1\\maven-demo\\target\\" + System.currentTimeMillis()
	  + ".png");
	  String errflpath = Dest.getAbsolutePath();
	  FileUtils.copyFile(scrFile, Dest);
	  return errflpath;
	  }
}
