package com.loop.step_definitions;

import com.loop.pages.HomePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
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
        BrowserUtils.takeScreenshot();
        loginPage.findUserRole();
        BrowserUtils.takeScreenshot();
        BrowserUtils.takeScreenshotAndSave("client_profile");
        assertEquals("User role: " + loginPage.userRole.getText() + " is not visible", loginPage.userRole.getText().toLowerCase(), DocuportConstants.CLIENT);
    }


    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        loginPage.findUserRole();
        assertEquals("User role: " + loginPage.userRole.getText() + " is not visible", loginPage.userRole.getText().toLowerCase(), DocuportConstants.EMPLOYEE);
    }

    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        loginPage.findUserRole();
        assertEquals("User role: " + loginPage.userRole.getText() + " is not visible", loginPage.userRole.getText().toLowerCase(), DocuportConstants.ADVISOR);
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
    }


    @When("user enters username for {string}")
    public void userEntersUsernameFor(String arg0) {
        BrowserUtils.waitForClickable(loginPage.usernameInput, DocuportConstants.large).click();
        switch (arg0){
            case "client":
                loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
                BrowserUtils.takeScreenshotAndSave("client_username");
                break;
            case "employee":
                loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                break;
            case "advisor":
                loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                break;
            case "supervisor":
                loginPage.usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                break;
            default:
                System.out.println("This is not a valid role");
        }
    }

    @And("user enters password for {string}")
    public void userEntersPasswordFor(String arg0) {
        BrowserUtils.waitForClickable(loginPage.passwordInput, DocuportConstants.large).click();
        switch (arg0) {
            case "client":
                loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_CLIENT);
                BrowserUtils.takeScreenshotAndSave("client_password");
                break;
            case "employee":
                loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_EMPLOYEE);
                break;
            case "advisor":
                loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_ADVISOR);
                break;
            case "supervisor":
                loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_SUPERVISOR);
                break;
            default:
                System.out.println("This is not a valid role");

        }
    }
        @When("user enters credentials")
        public void user_enters_credentials(Map<String,String> credentials) {

//            for (Map.Entry <String, String> entry : credentials.entrySet()){
//                String key = entry.getKey();
//                System.out.println("key = " + key);
//                String value = entry.getValue();
//                System.out.println("value = " + value);

            loginPage.loginDocuport(credentials.get("username"),credentials.get("password"));

            }

        }





