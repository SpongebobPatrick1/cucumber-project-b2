package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {



    public void clickCategory(String category){
        Driver.getDriver().findElement(By.xpath("//a[contains(.,'" + category +"')]")).click();
    }

    public String getProductPrice(String productName){
        String xpath = "//a[normalize-space(.)='" + productName + "']/../../h5";
        String actualPrice = Driver.getDriver().findElement(By.xpath(xpath)).getText();
        return actualPrice.substring(1);
    }

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
