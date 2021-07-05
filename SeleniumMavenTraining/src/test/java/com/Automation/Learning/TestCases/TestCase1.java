package com.Automation.Learning.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.Automation.PageFactory.*;

import com.Automation.Base.TestBase;

public class TestCase1 extends TestBase {
	
	AmazonHomePage Search;
	
	public TestCase1() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		TestBase.initialization();
		Search = new AmazonHomePage();
			}

	@Test(priority=1)
	public void pageloadedsuccessfully() {
		Search.getpagetitle();
		Search.pageloadedsuccessfully();
			}
	
	@Test(priority=2)
		public void searchitem() {
		//Search.SelectDepartment();
		Search.SearchProduct("Bike");
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
