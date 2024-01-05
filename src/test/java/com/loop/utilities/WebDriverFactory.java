package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {

    /*
    * create a static method getDriver
    * Accepts argument String browserType
    * returns webdriver
     */

    /**
     * @param browserType
     * @return the browser
     * @jaadquraan
     */

    public static WebDriver getDriver(String browserType){
        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else {
            System.out.println("No driver found");
            System.out.println("Driver is null");
            return null;
        }
        //Return type is Webdriver which is an object. Should
    }
}
