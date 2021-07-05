package com.Automation.PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.TestBase;

public class AmazonLoginPage extends TestBase {

	@FindBy(className = "a-icon a-icon-logo")
	WebElement AmzLogoLogin;
	@FindBy(id = "ap_email")
	WebElement LoginEmailid;
	@FindBy(id = "continue")
	WebElement ContinueBtn;
	@FindBy(id = "ap_password")
	WebElement Passwd;
	@FindBy(id = "signInSubmit")
	WebElement SignInBtn;
	@FindBy(xpath = "//span[@class = 'a-list-item']")
	WebElement InvalidPwdError;
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement ClickSignin;

	AmazonHomePage AmazonHomePage = new AmazonHomePage();

	public AmazonLoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void EnterUserName(String emailid) {

		try {
			LoginEmailid.sendKeys(emailid);
			//LoginEmailid.sendKeys(Properties.getProperty("UserName"));
		} catch (Exception e) {
			System.out.println("UserName not present in the Properties file");
		}

	}

	public void ClickContinue() {
		ContinueBtn.click();
	}

	public void EnterPwd(String pwd) {

		try {
			//Passwd.sendKeys(Properties.getProperty("Password"));
			Passwd.sendKeys(pwd);
		} catch (Exception e) {
			System.out.println("Password not present in the Properties file");
		}
	}

	public void Signin() {
		SignInBtn.click();

		if (AmazonHomePage.AmazonHomeLogo.isDisplayed()) {
			System.out.println("Login Successful");
		} else if (InvalidPwdError.isDisplayed()) {
			System.out.println("Login Failed");

		}

	}

	public void clicksignin() {
		ClickSignin.click();
	}
}
