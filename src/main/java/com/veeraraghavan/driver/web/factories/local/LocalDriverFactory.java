package com.veeraraghavan.driver.web.factories.local;

import com.veeraraghavan.driver.managers.web.local.ChromeDriverManager;
import com.veeraraghavan.driver.managers.web.local.FirefoxDriverManager;
import enums.BrowserTypeEnums;
import org.openqa.selenium.WebDriver;

public final class LocalDriverFactory {

    private LocalDriverFactory() {}

    static WebDriver driver;

    public static WebDriver getDriver(BrowserTypeEnums browserType) {
        return isChrome(browserType) ? ChromeDriverManager.getDriver() : FirefoxDriverManager.getDriver();
    }

    public static boolean isChrome(BrowserTypeEnums browserType) {
        return browserType == BrowserTypeEnums.CHROME;
    }
}
