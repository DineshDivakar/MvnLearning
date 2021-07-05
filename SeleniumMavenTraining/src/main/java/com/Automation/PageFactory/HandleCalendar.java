package com.Automation.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Automation.Base.TestBase;

public class HandleCalendar extends TestBase {

	public void CalrowCount() {
		List<WebElement> Rowcount = driver.findElements(By.xpath("/html/body/app-root/app-home/ngc-global-nav/header/div/div[1]/ngc-book/div[1]"
				+ "/div/form/div[1]/div/div[1]/div[1]/div[3]/date-selection-view/div/div/div/div/div[4]/div/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[1]"));
		//*[@id="booking"]/form/div[1]/div/div[1]/div[1]/div[3]/date-selection-view/div/div/div/div/div[4]/div/div[2]/div[1]/div[2]/table/tbody/tr//td//*[contains(text(),'26')]
		
	}
	
}
