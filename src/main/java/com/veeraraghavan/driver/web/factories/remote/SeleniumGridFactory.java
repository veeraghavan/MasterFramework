package com.veeraraghavan.driver.web.factories.remote;

import com.veeraraghavan.driver.managers.web.remote.seleniumgrid.SeleniumGridChromeManager;
import com.veeraraghavan.driver.managers.web.remote.seleniumgrid.SeleniumGridFirefoxManager;
import enums.BrowserTypeEnums;
import org.openqa.selenium.WebDriver;

public final class SeleniumGridFactory {

    private SeleniumGridFactory() {}

    public static WebDriver getDriver(BrowserTypeEnums browserTypeEnum) {
        WebDriver driver = null;
        if(browserTypeEnum == BrowserTypeEnums.CHROME)
            driver = SeleniumGridChromeManager.getDriver();
        else if (browserTypeEnum == BrowserTypeEnums.FIREFOX)
            driver = SeleniumGridFirefoxManager.getDriver();
        return driver;
    }
}
