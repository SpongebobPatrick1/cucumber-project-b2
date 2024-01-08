package com.loop.step_definitions;

import com.loop.pages.HomePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(loginPage.usernameInput, DocuportConstants.large);
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        BrowserUtils.waitForClickable(loginPage.passwordInput, DocuportConstants.large);
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_CLIENT);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large).click();
    }

    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        BrowserUtils.justWait(3);
        BrowserUtils.waitForVisibility(loginPage.continueButton, DocuportConstants.large);
        homePage.continueButton.click();
        BrowserUtils.justWait(2);
        loginPage.findUserRole();
        assertEquals("User role: " + loginPage.userRole.getText() + " is not visible", loginPage.userRole.getText().toLowerCase(), DocuportConstants.CLIENT);
    }

    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        BrowserUtils.waitForClickable(loginPage.usernameInput, DocuportConstants.large).click();
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
    }

    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        BrowserUtils.waitForClickable(loginPage.passwordInput, DocuportConstants.large).click();
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_EMPLOYEE);
    }

    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        loginPage.findUserRole();
        assertEquals("User role: " + loginPage.userRole.getText() + " is not visible", loginPage.userRole.getText().toLowerCase(), DocuportConstants.EMPLOYEE);
    }

    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        BrowserUtils.waitForClickable(loginPage.usernameInput, DocuportConstants.large).click();
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
    }

    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        BrowserUtils.waitForClickable(loginPage.passwordInput, DocuportConstants.large).click();
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_ADVISOR);
    }

    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        loginPage.findUserRole();
        assertEquals("User role: " + loginPage.userRole.getText() + " is not visible", loginPage.userRole.getText().toLowerCase(), DocuportConstants.ADVISOR);
    }


    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        BrowserUtils.waitForClickable(loginPage.usernameInput, DocuportConstants.large).click();
        loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
    }

    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {
        BrowserUtils.waitForClickable(loginPage.passwordInput, DocuportConstants.large).click();
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_SUPERVISOR);
    }

    @Then("user should see the home page for supervisor")
    public void user_should_see_the_home_page_for_supervisor() {
        loginPage.findUserRole();
        assertEquals("User role: " + loginPage.userRole.getText() + " is not visible", loginPage.userRole.getText().toLowerCase(), DocuportConstants.SUPERVISOR);

    }

    @Then("user clicks logout button")
    public void user_clicks_logout_button() {
        BrowserUtils.waitForClickable(loginPage.b1g1, DocuportConstants.large).click();
        BrowserUtils.waitForClickable(loginPage.logoutButton, DocuportConstants.large).click();
        BrowserUtils.justWait(1);
        Driver.closeDriver();
    }


}
