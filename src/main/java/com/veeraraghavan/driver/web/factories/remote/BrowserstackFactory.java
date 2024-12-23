package com.veeraraghavan.driver.web.factories.remote;

import com.veeraraghavan.driver.managers.web.remote.browserstack.BrowserstackChromeManager;
import com.veeraraghavan.driver.managers.web.remote.browserstack.BrowserstackFirefoxManager;
import enums.BrowserTypeEnums;
import org.openqa.selenium.WebDriver;

public final class BrowserstackFactory {

    private BrowserstackFactory() {}

    public static WebDriver getDriver(BrowserTypeEnums browserTypeEnum) {

        WebDriver driver = null;
        if (browserTypeEnum == BrowserTypeEnums.CHROME)
            driver = BrowserstackChromeManager.getDriver();
        else if (browserTypeEnum == BrowserTypeEnums.FIREFOX);
            driver = BrowserstackFirefoxManager.getDriver();

        return driver;
    }
}
