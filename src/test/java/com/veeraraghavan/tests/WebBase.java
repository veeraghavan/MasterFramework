package com.veeraraghavan.tests;

import com.veeraraghavan.driver.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.groovy.parser.antlr4.GroovyParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebBase {

    @BeforeMethod
    public void setUp() {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }
}
