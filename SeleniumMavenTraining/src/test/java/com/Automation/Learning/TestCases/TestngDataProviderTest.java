package com.Automation.Learning.TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Automation.Base.TestBase;
import com.Automation.Base.TestUtil;
import com.Automation.PageFactory.AmazonHomePage;
import com.Automation.reusablecomponents.DDTTestData;
import com.Automation.reusablecomponents.ReadExcelByColHeader;
import com.Automation.reusablecomponents.ReadWriteExcel;

public class TestngDataProviderTest extends TestBase {

	DDTTestData DDT = new DDTTestData();
	ReadWriteExcel ExcelRW;
	AmazonHomePage AHP;
	TestUtil tu;

	@BeforeMethod
	public void Setup() {

		TestBase.initialization();
		// rcol = new ReadExcelByColHeader();
		AHP = new AmazonHomePage();
		ExcelRW = new ReadWriteExcel();
		tu = new TestUtil();

	}

	@DataProvider(name = "Testdataprovider")
	public Iterator<Object[]> Testdataprovider() {
		ArrayList<Object[]> DDTdata = DDT.testdatatestng();
		return DDTdata.iterator();
	}

	@Test(dataProvider = "Testdataprovider")
	public void dataprovidertestng(String Items, String Department) throws InterruptedException {

		try {
			AHP.SelectDepartment(Department);
		} catch (Exception e) {
			System.out.println("not found");
		}

		try {
			AHP.SearchProduct(Items);
			tu.captureScreenshot();
		} catch (Exception e) {
			System.out.println("not found");
		}
		System.out.println("Searched" + "\n");
		Thread.sleep(10);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
