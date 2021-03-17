package com.gmail.igorzayatsa.tests;

import com.gmail.igorzayatsa.pages.DepositPage;
import com.gmail.igorzayatsa.pages.MainPage;
import com.gmail.igorzayatsa.utils.ConfProperties;
import com.gmail.igorzayatsa.utils.SQLManager;
import com.gmail.igorzayatsa.utils.WebDriverInit;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.sql.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DepositTest {
    public static DepositPage depositPage;
    public static MainPage mainPage;
    public static WebDriver webDriver;
    public static Connection connection;
    public SQLManager sqlManager;

    public DepositTest() {
    }

    @BeforeClass
    public void setup() {
        webDriver = WebDriverInit.getInstance().getDriver();
        connection = SQLManager.getInstance().getConnection();
        mainPage = PageFactory.initElements(webDriver, MainPage.class);
        depositPage = PageFactory.initElements(webDriver, DepositPage.class);
    }

    @Feature("Feature 1: Deposit")
    @Story("Deposit")
    @Test
    public void depositTest() {
        if (!webDriver.getCurrentUrl().equals(ConfProperties.getProperty("mainPage"))) {
            webDriver.get(ConfProperties.getProperty("mainPage"));
        }

        mainPage.clickDepositButton();
        depositPage.calculatorInBankCheckOn();
        depositPage.setAmountInput("100000");
        depositPage.setPeriodSlider();
        depositPage.clickDepositsCompareButton();
    }

    @AfterSuite
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }

        SQLManager.getInstance().insertIntoDataBase();
    }
}
