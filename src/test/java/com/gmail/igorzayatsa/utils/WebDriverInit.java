package com.gmail.igorzayatsa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverInit {
    public WebDriver webDriver;
    private static WebDriverInit driverInit = null;

    public static WebDriverInit getInstance() {
        if (driverInit == null) {
            driverInit = new WebDriverInit();
        }
        return driverInit;
    }

    private WebDriverInit() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get(ConfProperties.getProperty("mainPage"));
    }

    public WebDriver getDriver() {
        return this.webDriver;
    }
}
