package com.veeraraghavan.driver.managers.web.remote.seleniumgrid;

import com.veeraraghavan.config.ConfigFactory;
import enums.BrowserTypeEnums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SeleniumGridFirefoxManager {

    private SeleniumGridFirefoxManager() {}

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName((BrowserTypeEnums.FIREFOX.name()));
        return new RemoteWebDriver(ConfigFactory.getConfig().seleniumGridUrl(), capabilities);
    }
}
