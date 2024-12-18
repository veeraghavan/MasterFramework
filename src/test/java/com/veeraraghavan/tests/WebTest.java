package com.veeraraghavan.tests;

import com.veeraraghavan.config.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTest {

    @Test
    public void launchATest() {

        System.out.println(ConfigFactory.getConfig().browser());
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.co.in");
        driver.manage().window().maximize();
        driver.quit();
    }
}
