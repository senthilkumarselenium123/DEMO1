package com.testng;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.browserstack.local.Local;
import com.code.App;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import webDriverFactory.DriverFactory;

public class BrowserStack {
	
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
  public void f() throws Exception {
	  
//	  ExtentReports reports = new ExtentReports("C:\\Users\\infok\\OneDrive\\Documents\\GitHub\\DEMO1\\maven-demo\\target\\SeleniumDemo.html");
//
//	  ExtentTest test = reports.startTest("SeleniumDemo");
//	  
//	  DriverFactory objdriver = new DriverFactory();
//		
//		WebDriverManager.chromedriver().setup();
//		objdriver.setDriver(new ChromeDriver());
//		objdriver.getDriver().get("https://www.google.com");
//		String tile = objdriver.getDriver().getTitle();
//		if(tile.trim().equals("Google"))
//		{
//			
//			test.log(LogStatus.PASS,"Expected tiltle present");
//			test.log(LogStatus.PASS,test.addScreenCapture(capture(objdriver))+"TEST PASSEED");
//			System.out.println("PASS");
//		}else
//		{
//			test.log(LogStatus.FAIL,"Expected tiltle present");
//			test.log(LogStatus.PASS,test.addScreenCapture(capture(objdriver))+"TEST FAILED");
//			System.out.println("FAIL");
//		}
//		objdriver.closedriver();
//		reports.endTest(test);
//		reports.flush();
	  
	// declare BrowserStack credentails as environment variables
	  final String USERNAME = (System.getenv("BROWSERSTACK_USERNAME") != null) ? System.getenv("BROWSERSTACK_USERNAME") : "senthilkumar_VMjnqu";
	  final String AUTOMATE_KEY = (System.getenv("BROWSERSTACK_ACCESS_KEY") != null) ? System.getenv("BROWSERSTACK_ACCESS_KEY") : "dScf9K7RqHr4JZWDYMBR";
	  // declare remote URL in a variable
	  final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";
	  // intialize Selenium WebDriver
	  MutableCapabilities capabilities = new MutableCapabilities();
	  WebDriver driver = new RemoteWebDriver(new URL(URL), capabilities);
		System.out.println("PASSSS");
		
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		browserstackOptions.put("local", "true");
		capabilities.setCapability("bstack:options", browserstackOptions);
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");
		browserstackOptions.put("os", "Windows");
		browserstackOptions.put("osVersion", "10");
		capabilities.setCapability("bstack:options", browserstackOptions);
		browserstackOptions.put("projectName", "Marketing Website v2");
		browserstackOptions.put("buildName", "alpha_0.1.7");
		browserstackOptions.put("sessionName", "Home page must have a title");
		capabilities.setCapability("bstack:options", browserstackOptions);
		browserstackOptions.put("debug", "true"); // to enable visual logs
		browserstackOptions.put("consoleLogs", "info"); // to enable network logs to be logged
		browserstackOptions.put("networkLogs", "true"); // to enable console logs at the info level. You can also use other log levels here.
		capabilities.setCapability("bstack:options", browserstackOptions);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("title:   "+title);
		if(title.trim().equals("Google"))
		{
			// To mark the test as passed
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"<reason>\"}}");
		}else
		{
			// To mark the test as failed
			jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"<reason>\"}}");
		}
		driver.close();
		
		
		
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
