package com.Automation.Learning.TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class Retest {

	@Test (priority =1)
	public void timestamp() {
		SimpleDateFormat dformat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Timestamp tstmp = new Timestamp(System.currentTimeMillis());

		System.out.println(dformat.format(tstmp));

	}

	@Test(priority =2)

	public void filecopying() {
		File input = new File("C:\\Users\\dines\\Downloads\\W2 Form 1.pdf");
		File output = new File("C:\\Users\\dines\\Downloads\\W2 Form 1_copy.pdf");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(input);
			fos = new FileOutputStream(output);
			System.out.println(fis.available());

		} catch (Exception e) {
			e.printStackTrace();
		}

		int i = 0;
		try {
			while ((i = fis.read()) != -1) {
				fos.write(i);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		if (fis != null) {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (fos != null) {
			try {
				fos.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
	}
	
	public void screenshot() {
		//TakesScreenshot tshot = (TakesScreenshot)driver;
		//File screen = tshot.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(screen, null);
		
		}
	
	public void DDTmethod() {
		ArrayList<Object[]> testdata = new ArrayList<Object[]>();
		
		//Read excel
		
	
	/* Iterate through rows
	 * pass data for each element
	 * add to new Object[](ele1, ele2,...)
	 * 
	 * 
	 * 
	 */
		
	}
}
