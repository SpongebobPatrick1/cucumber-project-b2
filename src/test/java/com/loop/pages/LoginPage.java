package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class LoginPage {

    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;

    @FindBy(xpath = "//span[.='Batch1 Group1']")
    public WebElement b1g1;

    @FindBy(xpath = "//span[.='Home']")
    public WebElement home;

    @FindBy(xpath = "//span[.='Profile']")
    public WebElement profile;
    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logoutButton;
    @FindBy(xpath = "//div[@class='col col-12']/span[@class='body-2 gray--text']")
    public WebElement userRole;

    public String findUserRole() {
        BrowserUtils.waitForClickable(b1g1, DocuportConstants.large).click();
        BrowserUtils.waitForClickable(profile, DocuportConstants.large).click();
        BrowserUtils.waitForVisibility(userRole, DocuportConstants.large);
        return userRole.getText();
    }
    // Method to take a screenshot
    public void takeScreenshot(String screenshotName) {
        byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        // Attach the screenshot to the Cucumber report
        Scenario scenario = DocuportConstants.scenario; // Make sure 'scenario' is a static variable in your Constants class
        if (scenario != null) {
            scenario.attach(screenshot, "image/png", screenshotName);
        }
    }

//    // Method to take a screenshot and save it to a specified directory
//    public void takeScreenshotAndSave(String screenshotName) {
//        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
//        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//
//        // Specify the directory where you want to save the screenshots
//        String directoryPath = "C:\\Users\\quraa\\Documents\\CucumberScreenshots\\Docuport Login";
//
//        // Create the directory if it doesn't exist
//        File directory = new File(directoryPath);
//        if (!directory.exists()) {
//            directory.mkdirs();
//        }
//
//        // Specify the path for the screenshot file
//        Path targetPath = Path.of(directoryPath, screenshotName + ".png");
//
//        try {
//            // Copy the screenshot to the specified directory
//            Files.copy(sourceFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Handle the exception as needed
//        }
//    }

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
