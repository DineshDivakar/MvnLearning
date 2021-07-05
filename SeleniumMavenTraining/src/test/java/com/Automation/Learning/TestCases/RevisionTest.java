package com.Automation.Learning.TestCases;

import org.testng.annotations.*;

import com.Automation.Base.BrowserFactory;
import com.Automation.PageFactory.DeltaAirlinesHomePage;

public class RevisionTest extends BrowserFactory {
	DeltaAirlinesHomePage DHP = new DeltaAirlinesHomePage();
	BrowserFactory bf = new BrowserFactory();
	
	public RevisionTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		
		bf.DriverInitialize();
		
	}
	
	@Test
	public void print() {
		DHP.CloseCovidAlert();
		//DHP.CheckDeltaLogo();
		//DHP.BookTicket();
		System.out.print("SUccess");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}

}
