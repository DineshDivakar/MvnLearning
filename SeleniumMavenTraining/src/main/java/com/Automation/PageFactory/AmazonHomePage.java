package com.Automation.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.BrowserFactory;
import com.Automation.Base.TestBase;

public class AmazonHomePage extends TestBase {

	@FindBy(id = "nav-logo-sprites")
	WebElement AmazonHomeLogo;
	@FindBy(id = "twotabsearchtextbox")
	WebElement SearchItem;
	@FindBy(id = "nav-search-submit-button")
	WebElement SearchSubmit;
	@FindBy(xpath = "//select[@aria-describedby = 'searchDropdownDescription']")
	WebElement Deptmnt;

	public AmazonHomePage() {
		PageFactory.initElements(driver, this);
	}

	public String getpagetitle() {
		return driver.getTitle();
	}

	public boolean pageloadedsuccessfully() {
		return AmazonHomeLogo.isDisplayed();
	}

	public void SearchProduct(String Items) {
		SearchItem.sendKeys(Items);
		SearchSubmit.click();
		SearchItem.clear();
	}

	public void SelectDepartment(String Department) {
		Select Dept = new Select(Deptmnt);
		Dept.selectByVisibleText(Department);
	}
	
	}
