package com.Automation.Learning.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import com.Automation.Base.TestBase;
import com.Automation.Base.TestUtil;
import com.Automation.PageFactory.AmazonHomePage;
import com.Automation.reusablecomponents.ReadExcelByColHeader;
import com.Automation.reusablecomponents.ReadWriteExcel;
import com.Automation.reusablecomponents.reusablefunctions;

public class DataDrivenTest extends TestBase {

	ReadExcelByColHeader rcol;
	AmazonHomePage AHP;
	ReadWriteExcel ExcelRW;
	TestUtil tu;

	public DataDrivenTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		TestBase.initialization();
		rcol = new ReadExcelByColHeader();
		AHP = new AmazonHomePage();
		ExcelRW = new ReadWriteExcel();
		tu = new TestUtil();

	}

	@Test
	public void OrderItemsinAmazon() {
		ExcelRW.ReadExcel(Properties.getProperty("inputfilepath"), Properties.getProperty("inputfilename"));

		// ExcelRW.ReadAllExcelDataUsingIterator(Properties.getProperty("inputsheetname"));
		AHP.getpagetitle();
		AHP.pageloadedsuccessfully();
		int Rowcount = ExcelRW.GetRowCount(Properties.getProperty("inputsheetname"));
		for (int i = 1; i <= Rowcount; i++) {
			String Product = ExcelRW.getsCellData(Properties.getProperty("inputsheetname"), "Items", i);
			String Department = ExcelRW.getsCellData(Properties.getProperty("inputsheetname"), "Department", i);
			AHP.SelectDepartment(Department);
			AHP.SearchProduct(Product);
			tu.captureScreenshot();
			
			System.out.println("Searched" + "\n");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);

		}

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
