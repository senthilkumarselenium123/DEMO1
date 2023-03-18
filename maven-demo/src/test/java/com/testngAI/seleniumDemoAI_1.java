package com.testngAI;

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

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import webDriverFactory.DriverFactory;

public class seleniumDemoAI_1 {


	@Test(invocationCount = 0, threadPoolSize = 02)
	public void verifyTitle() throws Exception {
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("file:///C:/Users/infok/OneDrive/Desktop/seleniumloginAI_1.html");


		WebElement element1 = driver.findElement(By.xpath("//*"));
		Document doc1 = Jsoup.parse(element1.getAttribute("innerHTML"));

		Elements title3 = doc1.getElementsByTag("input");
		Elements title4 = doc1.getElementsByTag("button");
		System.out.println("input is: " + title3);
		System.out.println("Button is: " + title4);
		InputButtonLocators.inputLocator("" + title3);
		InputButtonLocators.buttonLocator("" + title4);

		System.out.println("XPATH%^&:  "+Locators.textBoxXpath("Input_typetext"));
		System.out.println("ButtonXPATH%^&:  "+Locators.buttonXpath("Button_typesubmit"));
		Thread.sleep(1000);
		driver.findElement(By.xpath(Locators.textBoxXpath("Input_namefirstname"))).sendKeys("senthil");
		driver.findElement(By.xpath(Locators.textBoxXpath("Input_namemiddlename"))).sendKeys("kumar");
		driver.findElement(By.xpath(Locators.textBoxXpath("Input_namelastname"))).sendKeys("paul");
		driver.findElement(By.xpath(Locators.buttonXpath("Button_typesubmit"))).click();
		

		driver.quit();
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
