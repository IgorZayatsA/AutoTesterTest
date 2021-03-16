package com.gmail.igorzayatsa.tests;

import com.gmail.igorzayatsa.pages.DepositPage;
import com.gmail.igorzayatsa.pages.MainPage;
import com.gmail.igorzayatsa.utils.WebDriverInit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepositTest {

    public static DepositPage depositPage;
    public static MainPage mainPage;
    public static WebDriver webDriver;

    @BeforeClass
    public void setup(){
        webDriver = WebDriverInit.getInstance().getDriver();
        mainPage = PageFactory.initElements(webDriver, MainPage.class);
        depositPage = PageFactory.initElements(webDriver, DepositPage.class);
    }

    @Test (priority = 1)
    public void depositTest (){

        mainPage.isMainPage();
        mainPage.clickDepositButton();

        depositPage.calculatorInBankCheckOn();
        depositPage.setAmountInput("100000");
        depositPage.setPeriodSlider();
        depositPage.clickDepositsCompareButton();

    }

    @AfterSuite
    public void stopDriver(){
        webDriver.quit();
    }

}
