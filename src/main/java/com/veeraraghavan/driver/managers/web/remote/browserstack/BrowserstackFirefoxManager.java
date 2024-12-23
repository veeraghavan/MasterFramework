package com.veeraraghavan.driver.managers.web.remote.browserstack;

import com.veeraraghavan.config.BrowserstackConfigFactory;
import enums.BrowserTypeEnums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class BrowserstackFirefoxManager {

    private BrowserstackFirefoxManager() {}

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", BrowserTypeEnums.FIREFOX.name());
        capabilities.setCapability("browser_version", "latest");
        capabilities.setCapability("os", "Windows");
        capabilities.setCapability("os_version", "11");
        return new RemoteWebDriver(BrowserstackConfigFactory.getConfig().browserstackURL(), capabilities);
    }
}
