package com.Automation.Base;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public class TestUtil extends TestBase {

	public static final SimpleDateFormat dfmt = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
	Timestamp tmestp = new Timestamp(System.currentTimeMillis());

	static public long PAGE_LOAD_WAIT_TIME = 100;
	static public long PAGE_LOAD_TIME_OUT = 100;

	public void captureScreenshot() {

		// timestamp
		String StrtimeStamp = dfmt.format(tmestp);

		// new screenshotname
		String screenCaptureFileName = ("CompanyName" + "_" + StrtimeStamp + ".png");
		File screenCaptureFile = new File(".\\Screenshots\\"+screenCaptureFileName);

		// take screenshot method
		try {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File screenCapture = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenCapture, screenCaptureFile);
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
