package com.Automation.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.TestBase;

public class DeltaAirlinesSearchResultsPage extends TestBase {

	@FindBy(className = "btn btn-danger btn-primary-cta flexi-continue-btn")
	WebElement ContinueBtn;
	@FindBy(xpath = "//*[@class = 'headingintro']")
	WebElement SearchHearder;
	@FindBy(xpath = "//*[@class = 'siteLogo']") WebElement DelaLogoSrchResultsPage;
	@FindBy(xpath = "//h1[@class = 'advanced-search-heading']") WebElement MultiCitySearchResultHeader;

	public DeltaAirlinesSearchResultsPage() {
		PageFactory.initElements(driver, this);
	}

	public void ContinueBtndisplayed() {
		if (ContinueBtn.isDisplayed()) {
			System.out.println("Round Trip Searched for the From and To Locations provided by the user");
		}

	}

	public void OutBoundFlightHeader() {
		try {
		if (SearchHearder.isDisplayed()) {
		String SrchHdr = SearchHearder.getText();
			
			if (SrchHdr.contains("One Way")) {
				System.out.println("One Way Searched for the From and To Locations provided by the user");
			} else if (SrchHdr.contains("Outbound")) {
				System.out.println("Round Trip Searched for the From and To Locations provided by the user");
			}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		try{
			if(MultiCitySearchResultHeader.isDisplayed()){
			
		String SrchHdrMultiCity = MultiCitySearchResultHeader.getText();
			if(SrchHdrMultiCity.contains(" BOOK A FLIGHT ")) {
				System.out.println("No Flights Found for the User Entered Airports");
			}
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void MultiCitySrchRsultsHeader() {
		String SrchHdrMultiCity = MultiCitySearchResultHeader.getText();
		try {
			if (SrchHdrMultiCity.contains(" BOOK A FLIGHT ")) {
				System.out.println("No Flights Found for the User Entered Airports");
			
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


