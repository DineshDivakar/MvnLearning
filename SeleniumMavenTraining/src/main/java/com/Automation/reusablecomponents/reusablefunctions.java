package com.Automation.reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import com.Automation.Base.TestBase;

public class reusablefunctions extends TestBase {

	public void ClickBtn(WebElement Element) {

		try {
			if (Element.isDisplayed()) {
				Element.click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
