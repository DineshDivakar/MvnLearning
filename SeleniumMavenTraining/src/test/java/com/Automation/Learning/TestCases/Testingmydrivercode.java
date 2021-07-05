package com.Automation.Learning.TestCases;

import org.testng.annotations.*;

import com.Automation.Base.BrowserFactory;
import com.Automation.PageFactory.AmazonHomePage;

public class Testingmydrivercode extends BrowserFactory {

	AmazonHomePage AHP;

	public Testingmydrivercode() {
		super();
	}

	@BeforeMethod
	public void setup() {
		BrowserFactory bf = new BrowserFactory();
		bf.DriverInitialize();
		AHP = new AmazonHomePage();
	}

	@Test
	public void print() {
		System.out.print(AHP.getpagetitle());
	}

	@AfterMethod()
	public void teardown() {
		driver.quit();
	}
}
