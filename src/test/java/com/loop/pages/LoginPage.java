package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
