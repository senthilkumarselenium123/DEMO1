package webDriverFactory;

import org.openqa.selenium.By;
//https://www.toolsqa.com/selenium-webdriver/webdrivermanager/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class factoryJAVA {
	
	
	
    
	public static void main(String ar[])
	{
		DriverFactory objdriver = new DriverFactory();
		
		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		objdriver.setDriver(new ChromeDriver());
		objdriver.getDriver().get("https://www.google.com");
		objdriver.closedriver();
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
//		driver.get("https://www.google.com");
		
	}

}
