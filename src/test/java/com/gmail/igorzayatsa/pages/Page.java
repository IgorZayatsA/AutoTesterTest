package com.gmail.igorzayatsa.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected PageManager pages;

    public Page(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 10);
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public String getTitle(){
        return webDriver.getTitle();
    }

    public Page ensurePageLoaded(){
        return this;
    }

    public boolean waitPageLoaded(){
        try{
            ensurePageLoaded();
            return true;
        } catch (TimeoutException tOE){
            return false;
        }
    }
}
