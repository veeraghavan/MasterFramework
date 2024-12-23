package com.veeraraghavan.driver;

import com.veeraraghavan.config.ConfigFactory;
import com.veeraraghavan.driver.web.factories.local.LocalDriverFactory;
import enums.RunModeEnums;
import org.openqa.selenium.WebDriver;

public class Driver {

    static WebDriver driver;

    public static void initDriver() {
        RunModeEnums runModeEnum = ConfigFactory.getConfig().runMode();
        if(runModeEnum == RunModeEnums.LOCAL)
            driver = LocalDriverFactory.getDriver(ConfigFactory.getConfig().browser());
        driver.get("https://google.co.in");
        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        driver.quit();
    }


}
