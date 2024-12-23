package com.veeraraghavan.driver.managers.web.remote.selenoid;

import com.veeraraghavan.config.ConfigFactory;
import enums.BrowserTypeEnums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SelenoidChromeManager {

    private SelenoidChromeManager() {}

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", BrowserTypeEnums.CHROME.name());
        capabilities.setCapability("browserVersion", "113");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return  new RemoteWebDriver(ConfigFactory.getConfig().selenoidUrl(), capabilities);
    }
}
