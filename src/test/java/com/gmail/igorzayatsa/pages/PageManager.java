package com.gmail.igorzayatsa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageManager {

    private WebDriver webDriver;

    public CardApplicationPage cardApplicationPage;
    public DepositPage depositPage;
    public MainPage mainPage;

    public PageManager(WebDriver webDriver){
        this.webDriver = webDriver;
        //cardApplicationPage = initElements(new CardApplicationPage(this));
        //depositPage = initElements(new DepositPage(this));
        //mainPage = initElements(new MainPage(w));
    }

    private <T extends Page> T initElements(T page) {
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 10), page);
        return page;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
