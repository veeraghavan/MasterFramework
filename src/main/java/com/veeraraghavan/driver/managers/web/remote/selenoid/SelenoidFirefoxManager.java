package com.veeraraghavan.driver.managers.web.remote.selenoid;

import com.veeraraghavan.config.ConfigFactory;
import enums.BrowserTypeEnums;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SelenoidFirefoxManager {

    private SelenoidFirefoxManager() {}

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browser", BrowserTypeEnums.FIREFOX.name());
        capabilities.setCapability("browserVersion", "133");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return  new RemoteWebDriver(ConfigFactory.getConfig().selenoidUrl(), capabilities);
    }
}
