package webDriverFactory;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	private static DriverFactory instance = new DriverFactory();
	
	public static DriverFactory getInstance()
	{
		System.out.println("instance:   "+instance);
		return instance;
	}
	
	ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	
	public void setDriver(WebDriver driverpar)
	{
		getInstance().driver.set(driverpar);
	}

	public WebDriver getDriver()
	{
		System.out.println("getdriver:  "+getInstance().driver.get());
		return getInstance().driver.get();
	}

	
	public void closedriver()
	{
		System.out.println("Closedriver:  "+getInstance().driver.get());
		getInstance().driver.get().quit();
		getInstance().driver.remove();
	}
	
}
