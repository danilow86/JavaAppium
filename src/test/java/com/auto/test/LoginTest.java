package com.auto.test;

import static org.testng.Assert.assertTrue;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import com.auto.base.TestCore;
import com.auto.configProperties.ConfigProperties;
import com.auto.pageObject.JoinPageObject;
import com.auto.pageObject.LoginPageObject;
import com.auto.pages.HomePage;
import com.auto.pages.LoginPage;


@Test(enabled=false)
public class LoginTest extends TestCore{
	LoginPage loginPage;
	HomePage homePage;

	@Given("My register is valid")
	public void loginWithInvalidCredential() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@When("Authenticate with invalid credentials")
	public void setInvalidCredentials() {
		loginPage.clickLoginButton();
		loginPage.enterUserName(JoinPageObject.email);
		loginPage.enterPassword(JoinPageObject.password);
		loginPage.clickOtherLoginButton();
	}

	@Then("the home page is showed")
	public void checkErrorMessage() {
		assertTrue(loginPage.verifyAlertTitle(LoginPageObject.expectedTitle),LoginPageObject.expectedTitle+" not present on screen");
		loginPage.clickOkButton();
	}


}
