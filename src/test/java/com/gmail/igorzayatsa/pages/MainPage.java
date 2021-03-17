package com.gmail.igorzayatsa.pages;

import com.gmail.igorzayatsa.utils.ConfProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public WebDriver webDriver;

    public MainPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(css = ".service:nth-child(3) > .service__title > a:nth-child(1)")
    private WebElement depositButton;

    @FindBy(xpath= "//div[2]/div/div[2]/div/div/a")
    private WebElement cardsButton;

    @Step ("Changes the Current Page oto the Main Page")
    public void isMainPage(){
        if (!webDriver.getCurrentUrl().equals(ConfProperties.getProperty("mainPage"))){
            webDriver.get(ConfProperties.getProperty("mainPage"));
        }
    }

    @Step ("Clicks on Deposit Button")
    public void clickDepositButton(){
        depositButton.click();
    }

    @Step ("Clicks on Cards Button")
    public void clickCardsButton(){
        cardsButton.click();
    }
}
