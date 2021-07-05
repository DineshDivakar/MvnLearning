package com.Automation.Learning.TestCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import com.Automation.Base.TestBase;
import com.Automation.Base.TestUtil;
import com.Automation.PageFactory.DeltaAirlinesHomePage;
import com.Automation.PageFactory.DeltaAirlinesSearchResultsPage;

public class DeltaAirlinesTest extends TestBase {

	DeltaAirlinesHomePage DHP;
	DeltaAirlinesSearchResultsPage DSR;

	public DeltaAirlinesTest() {
		super();

	}

	@BeforeMethod
	public void setup() {
		TestBase.initialization();
		DHP = new DeltaAirlinesHomePage();
		DSR = new DeltaAirlinesSearchResultsPage();
	}
	

	@Test (priority =2)
	public void SearchRoundTrip() {
		try{
			DHP.CloseCovidAlert();
			Thread.sleep(1000);
			DHP.BookTicket();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickFromLoc();
			DHP.EnterFromLoc("CHI");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectFromLoc("CHI");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickToLoc();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.EnterToLoc("DAL");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectToLoc("DAL");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectTripType("Round Trip");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickCalendar();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.PickTravelDate("27","July","2021");
			System.out.println("Departure Date selected");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.PickTravelDate("10","August","2021");
			System.out.println("Arrival Date selected");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.clickDoneInCalendar();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectNoOfPassengers("3 Passengers");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.searchFlights();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			//DSR.OutBoundFlightHeader();
			
		}
		catch (Exception e) {
			System.out.println("Element not found");
		}

	}

	@Test (priority =1)
	public void SearchOneWayTrip() {
		try{
			DHP.CloseCovidAlert();
			Thread.sleep(1000);
			DHP.BookTicket();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickFromLoc();
			DHP.EnterFromLoc("CHI");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectFromLoc("CHI");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickToLoc();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.EnterToLoc("DAL");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectToLoc("DAL");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectTripType("One Way");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickCalendar();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.PickTravelDate("27","July","2021");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.clickDoneInCalendar();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectNoOfPassengers("8 Passengers");
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.searchFlights();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			//DSR.OutBoundFlightHeader();
			
		}
		catch (Exception e) {
			System.out.println("Element not found");
		}

	}
	
	@Test (priority =3)
	public void SearchMultiTrip() {
		try{
			DHP.CloseCovidAlert();
			Thread.sleep(1000);
			DHP.BookTicket();
			driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickFromLoc();
			DHP.EnterFromLoc("LAX");
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectFromLoc("LAX");
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickToLoc();
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.EnterToLoc("CHI");
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectToLoc("CHI");
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectTripType("Multi-City");
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectNoOfPassengers("4 Passengers");
			DHP.ClickFlight1Calendar();
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.PickTravelDate("1","August","2021");
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.clickDoneInCalendar();
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.ClickToLocMultiCity();
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.EnterToLoc("ASE");
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.SelectToLocMultiCity("CHI", "ASE");
			DHP.ClickFlight2Calendar();
			DHP.PickTravelDate("10","October","2021");
			DHP.clickDoneInCalendar();
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			DHP.searchFlights();
			//driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_WAIT_TIME, TimeUnit.SECONDS);
			//DSR.OutBoundFlightHeader();
			
		}
		catch (Exception e) {
			System.out.println("Element not found");
		}

	}

	@AfterMethod
	public void teardown() {
		driver.quit();

	}
}
