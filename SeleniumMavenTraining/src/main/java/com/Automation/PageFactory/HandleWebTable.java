package com.Automation.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Automation.Base.TestBase;

public class HandleWebTable extends TestBase {

	public int getTableRowCount() {

		List<WebElement> Rows = driver.findElements(By.xpath("/html/body/div[3]/table/tbody/tr"));
		int rowCount = Rows.size();
		// System.out.println(rowCount);
		return rowCount;

	}

	/// html/body/div[3]/table/tbody/tr[1]/td[1]
	// /html/body/div[3]/table/tbody/tr[2]/td[1]
	/// html/body/div[3]/table/tbody/tr[3]/td[1]

	/// html/body/div[3]/table/thead/tr/th[1]
	// /html/body/div[3]/table/thead/tr/th[2]

	public int getTableColCount() {

		List<WebElement> Cols = driver.findElements(By.xpath("/html/body/div[3]/table/thead/tr/th"));
		int colCount = Cols.size();
		// System.out.println(colCount);
		return colCount;
	}

	public void PrintAllRowsInColumn() {
		String BeforeRowXpath = "/html/body/div[3]/table/tbody/tr[";
		String AfterRowXpath = "]/td[1]";

		for (int i = 1; i <= getTableRowCount(); i++) {
			String ActualXpath = (BeforeRowXpath + i + AfterRowXpath);
			WebElement RowValue = driver.findElement(By.xpath(ActualXpath));
			String Value = RowValue.getText();
			System.out.println(Value);
			if (Value.equalsIgnoreCase("Java")) {
				System.out.println(Value);
				break;
			}

		}

	}

	public void PrintColHeaders() {
		String BeforeColXpath = "/html/body/div[3]/table/thead/tr/th[";
		String AfterColXpath = "]";

		for (int i = 1; i <= getTableColCount(); i++) {

			String ActualColXPath = (BeforeColXpath + i + AfterColXpath);
			WebElement ColHeader = driver.findElement(By.xpath(ActualColXPath));
			String ColumnHeaderName = ColHeader.getText();
			System.out.println(ColumnHeaderName);

		}

	}

	public void GetAllValuesInRowBasedOnRowValue(String inputvalue) {

		String BeforeRowXpath = "/html/body/div[3]/table/tbody/tr[";

		// String BeforeColXpath = "/html/body/div[3]/table/thead/tr/th[";
		// String AfterColXpath = "]";
		String AfterRowXpath = "]/td[1]";

		for (int i = 1; i <= getTableRowCount(); i++) {
			String ActualXpath = (BeforeRowXpath + i + AfterRowXpath);
			WebElement RowValue = driver.findElement(By.xpath(ActualXpath));
			String Value = RowValue.getText();

			//System.out.println(Value);
			if (Value.equalsIgnoreCase(inputvalue)) {
				int j = 2;
				String AfterRowsXpath = ("]/td[" + j + "]");
				String ColXpath = (BeforeRowXpath +i+AfterRowsXpath);
				WebElement column = driver.findElement(By.xpath(ColXpath));
				String ColValue = column.getText();
				
				System.out.println("Language is " +Value+" and latest version is "+ColValue);
				break;
			}
		}
   	}

	/// html/body/div[3]/table/tbody/tr[1]/td[2]

	public void GetColValueBasedOnRowValue(String inputvalue) {

		String BeforeRowXpath = "/html/body/div[3]/table/tbody/tr[";
		String AfterRowXpath = "]/td[1]";
		

		for (int i = 1; i <= getTableRowCount(); i++) {
			String ActualXpath = (BeforeRowXpath + i + AfterRowXpath);
			WebElement RowValue = driver.findElement(By.xpath(ActualXpath));
			String Value = RowValue.getText();
			for (int j = 2; j <= getTableColCount(); j++) {
				String AfterColXpath = ("]/td[" + j + "]");
				String ColPath = (BeforeRowXpath + j + AfterColXpath);
				WebElement ColValue = driver.findElement(By.xpath(ColPath));
				String FValue = ColValue.getText();
				if (Value.equalsIgnoreCase(inputvalue)) {
					System.out.println(Value);
					System.out.println(FValue);
					break;
				}
			}

			// html/body/div[3]/table/tbody/tr[1]/td[2]
		}
	}
	
	public void selectvaluebyxpath(String language) {
		
		String Language = driver.findElement(By.xpath("//td[contains(text(),'"+language+"')]")).getText();
		if(Language.equalsIgnoreCase(language)) {
		
		String tagattribute = driver.findElement(By.xpath("//td[contains(text(),'"+language+"')]/following-sibling::td")).getAttribute("data-label");
		if(tagattribute.equalsIgnoreCase("Stable Version")) {
			String version = driver.findElement(By.xpath("//td[contains(text(),'"+language+"')]/following-sibling::td")).getText();	
			System.out.println(version);
		}
		
		
	
	
		}
	}
	
	
}
