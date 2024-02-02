package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedWriter;

public class DocuportBasePage {

    private static final Logger LOG = LogManager.getLogger();

    @FindBy(xpath = "//span[.='Home']")
    public static WebElement home;
    @FindBy(xpath = "//span[.=' Continue ']")
    public static WebElement continueButton;


    public String getElementText(String text) {
        String xpath = "//*[normalize-space()='" + text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath)).getText();
    }

    public WebElement getElement(String text) {
        String xpath = "//*[normalize-space()='" + text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public static void clickButton(String button) {
        switch (button.toLowerCase()) {
            case "continue":
//              //  BrowserUtils.justWait(2);
//                BrowserUtils.waitForVisibility(continueButton,DocuportConstants.large);
//                BrowserUtils.waitForClickable(continueButton,DocuportConstants.large);
//                BrowserUtils.clickWithJS(continueButton);
                break;
            case "home":
                // Re-locate the element
              //  BrowserUtils.justWait(1);
                WebElement homeButton = Driver.getDriver().findElement(By.xpath("//span[.='Home']"));
                BrowserUtils.waitForVisibility(home,DocuportConstants.large);
                BrowserUtils.waitForClickable(home, DocuportConstants.large);
                BrowserUtils.clickWithJS(home);
                // Alternatively, you can try clicking with JavaScript if the normal click fails
                // BrowserUtils.clickWithJS(homeButton);
                break;
            case "invitations":
                WebElement invitationButton = Driver.getDriver().findElement(By.xpath("//span[.='Invitations']"));
                BrowserUtils.waitForVisibility(invitationButton, 5);
                BrowserUtils.clickWithJS(invitationButton);
                //invitationButton.click();
                break;
            case "leads":
                WebElement leadsButton = Driver.getDriver().findElement(By.xpath("//span[.='Leads']"));
                BrowserUtils.waitForVisibility(leadsButton, 5);
                BrowserUtils.clickWithJS(leadsButton);
                break;
            case "users":
                WebElement usersButton = Driver.getDriver().findElement(By.xpath("//span[.='Users']"));
                BrowserUtils.waitForVisibility(usersButton, 5);
                BrowserUtils.clickWithJS(usersButton);
                break;
            default:
                LOG.error("No such " + button + "exists");
                throw new IllegalArgumentException();
        }

    }
}