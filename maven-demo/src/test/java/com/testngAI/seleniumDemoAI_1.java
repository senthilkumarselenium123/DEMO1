package com.testngAI;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import webDriverFactory.DriverFactory;

public class seleniumDemoAI_1 {


	@Test(invocationCount = 0, threadPoolSize = 02)
	public void verifyTitle() throws Exception {
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("file:///C:/Users/infok/OneDrive/Desktop/seleniumloginAI_1.html");


		WebElement element1 = driver.findElement(By.xpath("//*"));
		Document doc1 = Jsoup.parse(element1.getAttribute("innerHTML"));

		Elements title3 = doc1.getElementsByTag("input");
		Elements title4 = doc1.getElementsByTag("button");
		Elements textareaTag = doc1.getElementsByTag("textarea");
		Elements optionTag = doc1.getElementsByTag("option");
		InputButtonLocators.inputLocator("" + title3, "InputLocators", "input");
		InputButtonLocators.inputLocator("" + title4, "ButtonLocators", "button");
		InputButtonLocators.inputLocator("" + textareaTag, "TextareaLocators", "textarea");
		InputButtonLocators.dropDownLocator("" + optionTag, "DropDownLocators", "option");
		

		driver.findElement(By.xpath(Locators.inputTagXpath("Input_FirstName"))).sendKeys("senthil Kumar");
		driver.findElement(By.xpath(Locators.inputTagXpath("Input_MiddleName"))).sendKeys("kumar");
		driver.findElement(By.xpath(Locators.inputTagXpath("Input_LastName"))).sendKeys("Paul Suyambu");
		driver.findElement(By.xpath(Locators.inputTagXpath("Input_Other"))).click();
		driver.findElement(By.xpath(Locators.inputTagXpath("Input_Phone_new"))).click();
		driver.findElement(By.xpath(Locators.inputTagXpath("Input_Phone_new"))).sendKeys("0987654321");
		driver.findElement(By.xpath(Locators.optionTagXpath("Option_BBA"))).click();
		driver.findElement(By.xpath(Locators.textAreaXpath("TextArea_Address"))).sendKeys("Chennai 123456");
		driver.findElement(By.xpath(Locators.inputTagXpath("Input_Email"))).sendKeys("senthil@kumar.com");
		driver.findElement(By.xpath(Locators.inputTagXpath("Input_Password"))).sendKeys("password8765");
		driver.findElement(By.xpath(Locators.inputTagXpath("Input_ReTypePassword"))).sendKeys("password8765");
		
		//new Select(driver.findElement(By.xpath("//select/option[contains(@value,'BBA')]"))).selectByVisibleText("BBA");
		
//		driver.findElement(By.xpath(Locators.buttonXpath("Button_Submit"))).click();
		
		//driver.quit();
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
