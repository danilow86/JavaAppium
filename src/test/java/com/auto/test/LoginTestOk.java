package com.auto.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import com.auto.base.TestCore;
import com.auto.configProperties.ConfigProperties;
import com.auto.pageObject.JoinPageObject;
import com.auto.pageObject.LoginPageObject;
import com.auto.pages.HomePage;
import com.auto.pages.LoginPage;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;


@Test(enabled=true)
public class LoginTestOk extends TestCore {
    LoginPage loginPage;
    HomePage homePage;

    @Given("My register is valid")
    public void loginWithvalidCredential() {
        loginPage = new LoginPage(driver);
    }

    @When("Authenticate with valid credentials")
    public void setValidCredentials() {
        loginPage.clickLoginButton();
        //loginPage.clearField(JoinPageObject.email);
        loginPage.enterUserName(ConfigProperties.email);
        loginPage.enterPassword(ConfigProperties.password);
    }

    @Then("the home page is showed")
    public void showHome() {
        loginPage.clickOtherLoginButton();
        assertTrue(homePage.verifyHomeScreenHeader("Home"),"not present on screen");
    }

}


