package com.Automation.Learning.TestCases;

import org.testng.annotations.*;

import com.Automation.Base.TestBase;
import com.Automation.PageFactory.HandleWebTable;

public class WebTableTest extends TestBase {
	
	
	HandleWebTable HWT;
	public WebTableTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		TestBase.initialization();
		HWT = new HandleWebTable();
		
	}
	
	@Test
	public void WebtableRowCount() {
		//HWT.getTableRowCount();
		//HWT.getTableColCount();
		//HWT.PrintAllRowsInColumn();
		System.out.println("=============");
		//HWT.PrintColHeaders();
		HWT.GetAllValuesInRowBasedOnRowValue("Python");
		System.out.println("=============");
		//HWT.GetColValueBasedOnRowValue("Python");
		HWT.selectvaluebyxpath("C#");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
