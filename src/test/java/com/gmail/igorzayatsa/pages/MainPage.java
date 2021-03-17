package com.gmail.igorzayatsa.pages;

import com.gmail.igorzayatsa.utils.SQLManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import java.sql.Timestamp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public WebDriver webDriver;
    protected Timestamp beginTime;
    protected Timestamp endTime;
    @FindBy(
            css = ".service:nth-child(3) > .service__title > a:nth-child(1)"
    )
    private WebElement depositButton;
    @FindBy(
            xpath = "//div[2]/div/div[2]/div/div/a"
    )
    private WebElement cardsButton;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @Step("Deposit Button")
    @Description("Clicks on Deposit Button")
    public void clickDepositButton() {
        beginTime = new Timestamp(System.currentTimeMillis());
        depositButton.click();
        endTime = new Timestamp(System.currentTimeMillis());
        SQLManager.addToList("Deposit Button", beginTime, endTime);
    }

    @Step("Cards Button")
    @Description("Clicks on Cards Button")
    public void clickCardsButton() {
        cardsButton.click();
    }
}
