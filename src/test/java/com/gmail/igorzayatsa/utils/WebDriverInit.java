package com.gmail.igorzayatsa.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverInit {
    public WebDriver webDriver = new ChromeDriver();
    private static WebDriverInit driverInit = null;

    public static WebDriverInit getInstance() {
        if (driverInit == null) {
            driverInit = new WebDriverInit();
        }

        return driverInit;
    }

    private WebDriverInit() {
        this.webDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        this.webDriver.get(ConfProperties.getProperty("mainPage"));
    }

    public WebDriver getDriver() {
        return this.webDriver;
    }
}
