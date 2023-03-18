package com.testng;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bson.codecs.DocumentCodecProvider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.code.App;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import webDriverFactory.DriverFactory;

public class seleniumDemo_Headless {

	// public static ExtentReports report;

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

//  @Test (invocationCount = 0,threadPoolSize =02)
	public void f() throws IOException {

		ExtentReports reports = new ExtentReports(
				"C:\\Users\\infok\\OneDrive\\Documents\\GitHub\\DEMO1\\maven-demo\\target\\SeleniumDemo.html");

		ExtentTest test = reports.startTest("SeleniumDemo");

		// App.sample3();
		DriverFactory objdriver = new DriverFactory();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();

//		driver = new ChromeDriver();
		objdriver.setDriver(new ChromeDriver());
		objdriver.getDriver().get("https://www.google.com");
		String tile = objdriver.getDriver().getTitle();
		if (tile.trim().equals("Google")) {

			test.log(LogStatus.PASS, "Expected tiltle present");
			test.log(LogStatus.PASS, test.addScreenCapture(capture(objdriver)) + "TEST PASSEED");
			System.out.println("PASS");
		} else {
			test.log(LogStatus.FAIL, "Expected tiltle present");
			test.log(LogStatus.PASS, test.addScreenCapture(capture(objdriver)) + "TEST FAILED");
			System.out.println("FAIL");
		}
		objdriver.closedriver();
		reports.endTest(test);
		reports.flush();

	}

	@Test(invocationCount = 0, threadPoolSize = 02)
	public void verifyTitle() throws Exception {
		WebDriver driver;
		// WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.browserstack.com/");
//		System.out.println("Title is: " + driver.getTitle());
//		Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
//		String abc = driver.getPageSource();
//
//		WebElement element = driver.findElement(By.xpath("//*"));
//		Document doc = Jsoup.parse(element.getAttribute("innerHTML"));
//
//		Elements title2 = doc.getElementsByTag("input");
//		System.out.println("title is: " + title2);

		driver.findElement(By.xpath("//*[@id=\"post-26\"]/section//div[1]/div/a[@href='/live']")).click();

		WebElement element1 = driver.findElement(By.xpath("//*"));
		Document doc1 = Jsoup.parse(element1.getAttribute("innerHTML"));

		Elements title3 = doc1.getElementsByTag("input");
		System.out.println("input is: " + title3);

		excelpoi2.testinput("" + title3);

//		driver.findElement(By.xpath("//*[@autocomplete=\"off\" and @class=\"text input-lg input-primary input-margin\" and @id=\"live-form-url\"]")).sendKeys("Text Message");
		System.out.println("XPATH%^&:  "+ExcelPOIRead.xpath("Input_autocompleteoff"));
		driver.findElement(By.xpath(ExcelPOIRead.xpath("Input_autocompleteoff"))).sendKeys("Text Message");
		
//	System.out.println(doc);
//	element.getAttribute("innerHTML");
//	System.out.println(element.getAttribute("innerHTML"));
//	
//
//	String html = ""+element.getAttribute("innerHTML");
//	String title = html.substring(html.indexOf("<button"), html.indexOf("</button>"));
//	System.out.println("Button:  "+title);

//		driver.quit();
	}

	public static String capture(DriverFactory objdriver) throws IOException {
		File scrFile = ((TakesScreenshot) objdriver.getDriver()).getScreenshotAs(OutputType.FILE);
		File Dest = new File("C:\\Users\\infok\\OneDrive\\Documents\\GitHub\\DEMO1\\maven-demo\\target\\"
				+ System.currentTimeMillis() + ".png");
		String errflpath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return errflpath;
	}
}
