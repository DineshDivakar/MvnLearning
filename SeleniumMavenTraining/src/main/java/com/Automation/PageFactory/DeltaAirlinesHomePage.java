package com.Automation.PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Automation.Base.BrowserFactory;
import com.Automation.Base.TestBase;

public class DeltaAirlinesHomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"dtAdvisory\"]/div/div/div[1]")
	WebElement CovidAlertCheck;
	@FindBy(id = "changeCancel")
	WebElement ChangeCancelFlight;
	@FindBy(xpath = "//*[@class = 'siteLogo']")
	WebElement DeltaLogo;
	@FindBy(xpath = "//a[@id= 'headPrimary1']")
	WebElement BookFlightLink;
	@FindBy(xpath = "//*[@id ='fromAirportName']")
	WebElement FromLocation;
	@FindBy(id = "search_input")
	WebElement EnterLoc;
	@FindBy(xpath = "//*[@class = 'airport-code col-sm-2 col-md-1 col-lg-2 col-xl-2 col-xxl-2 pl-0 pr-3']")
	WebElement AirportList;
	@FindBy(xpath = "//*[@id ='toAirportName']")
	WebElement ToLocation;
	@FindBy(id = "toAirportLink2") WebElement ToLocMultiCity;
	
	@FindBy(id = "selectTripType-val")
	WebElement TripType;
	@FindBy(xpath = "//*[@id ='adv-search']")
	WebElement AdvancedSearch;
	@FindBy(id = "correctionBar")
	WebElement ErrorMsgBar;
	@FindBy(xpath = "//*[@class = 'select-ui-element-wrapper blue-theme ng-tns-c1-2 ng-star-inserted']//span[@aria-labelledby= 'passengers-label']"
			+ "//span[@class = 'select-ui-icon icon-Dropdown-caret ng-tns-c1-2']")
	WebElement PassenderDropDown;
	@FindBy(id = "selectTripType-val")
	WebElement TripTypeDropDownList;
	@FindBy(xpath = "//*[@class = 'calDispValueCont icon-Calendar  ']")
	WebElement TravelDate;
	@FindBy(id = "input_departureDate_1") WebElement MultiCityFlight1DepDate;
	@FindBy(id = "input_departureDate_2") WebElement MultiCityFlight2DepDate;
	@FindBy(xpath = "//*[@class = 'dl-datepicker-title']//span[@class = 'dl-datepicker-month-0']")
	WebElement MonthCal0;
	@FindBy(xpath = "//*[@class = 'dl-datepicker-title']//span[@class = 'dl-datepicker-year dl-datepicker-year-0']")
	WebElement YearCal0;
	@FindBy(xpath = "//*[@class = 'dl-datepicker-title']//span[@class = 'dl-datepicker-month-1']")
	WebElement MonthCal1;
	@FindBy(xpath = "//*[@class = 'dl-datepicker-title']//span[@class = 'dl-datepicker-year dl-datepicker-year-0']")
	WebElement YearCal1;
	@FindBy(xpath = ".//*[@class = 'dl-datepicker-1']//span[@class = 'monthSelector']")
	WebElement SpanToNextMonth;
	@FindBy(className = "donebutton")
	WebElement CalendarDoneBtn;
	@FindBy(id = "btn-book-submit")
	WebElement SrchFlights;
	

	public DeltaAirlinesHomePage() {

		PageFactory.initElements(driver, this);
	}

	public void CloseCovidAlert() {
		ChangeCancelFlight.click();
	}

	public void CheckDeltaLogo() {
		DeltaLogo.isDisplayed();
		System.out.println("Is Displayed");
	}

	public void BookTicket() {
		BookFlightLink.click();
	}

	public void ClickFromLoc() {
		FromLocation.click();
	}

	public void ClickToLoc() {
		ToLocation.click();
	}
	
	public void ClickToLocMultiCity() {
		ToLocMultiCity.click();
	}

	public void EnterFromLoc(String FromLoc) {
		EnterLoc.clear();
		EnterLoc.sendKeys(FromLoc);
	}
	
	public void EnterToLoc(String ToLoc) {
		EnterLoc.clear();
		EnterLoc.sendKeys(ToLoc);
	}

	
	

	public void SelectFromLoc(String FromArptName) {
		List<WebElement> FromLocList = driver.findElements(By.xpath(
				"//*[@class = 'airport-list ng-star-inserted']//a[@class = 'airportLookup-list']//span[@class='airport-code col-sm-2 col-md-1 col-lg-2 col-xl-2 col-xxl-2 pl-0 pr-3']"));
		int count = 0;
		for (WebElement FromLoc : FromLocList) {
			String FromAirport = FromLoc.getText();

			if (FromAirport.contains(FromArptName)) {
				FromLoc.click();
				count++;
				break;
			}

		}
		if (count != 0) {
			System.out.println("From Airport Selected");
		} else {
			System.out.println("From Airport NOT Found");
		}
	}

	public void SelectToLoc(String ToArptName) {
		List<WebElement> ToLocList = driver
				.findElements(By.xpath("//*[@class = 'airport-list ng-star-inserted']//a[@class = 'airportLookup-list']"
						+ "//span[@class='airport-code col-sm-2 col-md-1 col-lg-2 col-xl-2 col-xxl-2 pl-0 pr-3']"));
		int count = 0;
		for (WebElement ToLoc : ToLocList) {
			String ToAirport = ToLoc.getText();

			if (ToAirport.contains(ToArptName)) {
				ToLoc.click();
				count++;
				break;
			}

		}
		if (count != 0) {
			System.out.println("To Airport Selected");
		} else {
			System.out.println("To Airport NOT Found");
		}
	}

	public void SelectToLocMultiCity(String ToArptName,String ToArptNameMultiCity) {
		
		
		String Flight2FromLoc = driver.findElement(By.xpath("//*[@id = 'fromAirportLink2']//span[@class = 'airport-code d-block']")).getText();
		
		if(Flight2FromLoc.equalsIgnoreCase(ToArptName)) {
		List<WebElement> ToLocMultiCityList = driver
				.findElements(By.xpath("//*[@class = 'airport-list ng-star-inserted']//a[@class = 'airportLookup-list']"
						+ "//span[@class='airport-code col-sm-2 col-md-1 col-lg-2 col-xl-2 col-xxl-2 pl-0 pr-3']"));
		int count = 0;
		for (WebElement ToLocMultiCity : ToLocMultiCityList) {
			String ToAirportMultiCity = ToLocMultiCity.getText();

			if (ToAirportMultiCity.contains(ToArptNameMultiCity)) {
				ToLocMultiCity.click();
				count++;
				break;
			}

		}
		if (count != 0) {
			System.out.println("To Airport Selected");
		} else {
			System.out.println("To Airport NOT Found");
		}
		}
	}
	
	public void SelectTripType(String TripType) {
		TripTypeDropDownList.click();
		List<WebElement> TripList = driver.findElements(
				By.xpath("//ul[@id='selectTripType-desc']//li[@class='select-ui-optionList ng-tns-c1-2']"));
		int count = 0;
		for (WebElement TrpType : TripList) {
			String TrpTyp = TrpType.getText();

			if (TrpTyp.contains(TripType)) {
				TrpType.click();
				count++;
				break;
			}

		}
		if (count != 0) {
			System.out.println("Trip Selected");
		} else {
			System.out.println("Trip NOT Found");
		}
	}

	public void SelectNoOfPassengers(String Passengers) {
		PassenderDropDown.click();
		List<WebElement> PassengerCount = driver
				.findElements(By.xpath("//*[@id ='passengers-desc']//li"));
		int count = 0;
		for (WebElement Psgrs : PassengerCount) {
			String PsngrsCnt = Psgrs.getText();

			if (PsngrsCnt.contains(Passengers)) {
				Psgrs.click();
				count++;
				break;
			}

		}
		if (count != 0) {
			System.out.println("No. of Passengers Selected");
		} else {
			System.out.println("No. of Passengers Found");
		}
	}

	public void ClickCalendar() {
		TravelDate.click();
	}
	
	public void ClickFlight1Calendar() {
		MultiCityFlight1DepDate.click();
	}
	
	public void ClickFlight2Calendar() {
		MultiCityFlight2DepDate.click();
	}
	
	public void PickTravelDate(String Date, String Month, String Year) {
		
		while (true) {
			String DepMonthCal0 = MonthCal0.getText();
			String DepYrCal0 = YearCal0.getText();
			String DepMonthCal1 = MonthCal1.getText();
			String DepYrCal1 = YearCal1.getText();
			
			if (DepYrCal0.equalsIgnoreCase(Year)) {
				if (DepMonthCal0.equalsIgnoreCase(Month)) {

					driver.findElement(By.xpath("//*[@class = 'dl-datepicker-tbody-0']/tr//td//a[contains(text(),'" + Date + "')]"))
							.click();
					break;
				} 
				else if (DepYrCal1.equalsIgnoreCase(Year)) {
					if (DepMonthCal1.equalsIgnoreCase(Month)) {
				
						driver.findElement(By.xpath("//*[@class = 'dl-datepicker-tbody-1']/tr//td//a[contains(text(),'" + Date + "')]"))
								.click();
						break;
						
					}
					else 
					SpanToNextMonth.click();
				} 
					
			}
			}
						
		}
	

	public void clickDoneInCalendar() {
		CalendarDoneBtn.click();
	}
	public void searchFlights() {
		SrchFlights.click();
		System.out.println("Searching...");
	}

}
