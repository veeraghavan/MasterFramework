package com.veeraraghavan.tests;

import com.veeraraghavan.config.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTest extends WebBase {

    @Test
    public void launchATest() {
        System.out.println(ConfigFactory.getConfig().runMode());
        System.out.println(ConfigFactory.getConfig().remotePlatform());
    }
}
