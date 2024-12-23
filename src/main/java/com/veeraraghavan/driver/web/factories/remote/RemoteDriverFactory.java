package com.veeraraghavan.driver.web.factories.remote;

import enums.BrowserTypeEnums;
import enums.RemotePlatformEnums;
import org.openqa.selenium.WebDriver;

public final class RemoteDriverFactory {

    private RemoteDriverFactory() {}

    public static WebDriver getDriver(RemotePlatformEnums remotePlatformEnum, BrowserTypeEnums browserTypeEnum) {
        WebDriver driver;
        if (remotePlatformEnum == RemotePlatformEnums.SELENIUM)
            driver = SeleniumGridFactory.getDriver(browserTypeEnum);
        else if (remotePlatformEnum == RemotePlatformEnums.SELENOID)
            driver = SelenoidFactory.getDriver(browserTypeEnum);
        else if (remotePlatformEnum == RemotePlatformEnums.BROWSERSTACK)
            driver = BrowserstackFactory.getDriver(browserTypeEnum);
        return null;
    }
}
