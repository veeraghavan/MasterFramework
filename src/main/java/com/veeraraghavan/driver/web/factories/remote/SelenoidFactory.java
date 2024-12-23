package com.veeraraghavan.driver.web.factories.remote;

import com.veeraraghavan.driver.managers.web.remote.selenoid.SelenoidChromeManager;
import com.veeraraghavan.driver.managers.web.remote.selenoid.SelenoidFirefoxManager;
import enums.BrowserTypeEnums;
import org.openqa.selenium.WebDriver;

public final class SelenoidFactory {

    private SelenoidFactory() {}

    public static WebDriver getDriver(BrowserTypeEnums browserTypeEnum) {
        WebDriver driver = null;
        if (browserTypeEnum == BrowserTypeEnums.CHROME)
            driver = SelenoidChromeManager.getDriver();
        else if (browserTypeEnum == BrowserTypeEnums.FIREFOX)
            driver = SelenoidFirefoxManager.getDriver();
        return driver;
    }
}
