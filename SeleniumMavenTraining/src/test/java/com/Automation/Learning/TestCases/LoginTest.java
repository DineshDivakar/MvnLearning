package com.Automation.Learning.TestCases;

import org.testng.annotations.*;

import com.Automation.Base.TestBase;
import com.Automation.PageFactory.AmazonLoginPage;

public class LoginTest extends TestBase {
	

	AmazonLoginPage AmazonLogin;
	
	public LoginTest() {	
		super();
	}
	
	@BeforeMethod
	public void setup(){
		TestBase.initialization();
		AmazonLogin = new AmazonLoginPage();
			}

	@Test
	@Parameters({"emailid","pwd"})
	public void login(String emailid, String pwd) {
		AmazonLogin.clicksignin();
		AmazonLogin.EnterUserName(emailid);
		AmazonLogin.ClickContinue();
		AmazonLogin.EnterPwd(pwd);
		AmazonLogin.Signin();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
