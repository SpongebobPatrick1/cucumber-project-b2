package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement continueButton;

    @FindBy(xpath = "//span[.='Batch1 Group1']")
    public WebElement b1g1;

    @FindBy(xpath = "//span[.='Home']")
    public WebElement home;

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
