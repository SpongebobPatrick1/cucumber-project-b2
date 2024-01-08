package com.loop.step_definitions;

import com.loop.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//Before After Scenario come from io.cucumber.java
public class Hooks {

    @Before
    public void setUp(){
        Driver.getDriver();
    }

    @After
    public void tearDown(Scenario scenario){
        // only takes a screenshot when scenario is failed
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        //Driver.closeDriver();
    }
}
