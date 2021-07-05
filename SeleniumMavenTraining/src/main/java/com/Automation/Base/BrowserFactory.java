package com.Automation.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver driver;
	public static Properties Properties;
	public static String BrowserName;
	
	

	public void DriverInitialize() {

		try {
			Properties = new Properties();
			FileInputStream Prop = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\main\\java\\com\\Automation\\Config\\RunConfig.Properties");
			Properties.load(Prop);

		} catch (IOException e) {

			e.printStackTrace();
		}

		String BrowserName = Properties.getProperty("browser");

		if (BrowserName.equalsIgnoreCase("Chrome"))
			try {
				
				System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} catch (Exception e) {
				System.out.println("Driver not found");
			}

		else if (BrowserName.equalsIgnoreCase("Firefox"))
			try {
				
				System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			} catch (Exception e) {
				System.out.println("Driver not found");
			}

		driver.get("https://www.delta.com");
		//System.out.println(driver.getTitle());
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT,TimeUnit.SECONDS);
		

	}
}
