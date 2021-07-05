package com.Automation.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties Properties;
			
	public TestBase() {
		
		try {
			Properties = new Properties();
				
			FileInputStream ip = new FileInputStream (System.getProperty("user.dir")+"\\src\\main\\java\\com\\Automation\\Config\\RunConfig.Properties");
			
			Properties.load(ip);
		} catch(FileNotFoundException e) {
		 e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void initialization() {
		String BrowserName = Properties.getProperty("browser");
		if (BrowserName.equalsIgnoreCase("Chrome")) {
			try {
				System.setProperty("webdriver.chrome.driver",
						Properties.getProperty("chromedriverpath"));
				driver = new ChromeDriver();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		} else if (BrowserName.equalsIgnoreCase("FireFox")) {
			try {
				System.setProperty("webdriver.gecko.driver",
						Properties.getProperty("Firefoxdriverpath"));
				driver = new FirefoxDriver();
			} catch (Throwable e) {
				e.printStackTrace();
			}
			
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(Properties.getProperty("url"));
		//System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
	}
	}
	

