package com.gmail.igorzayatsa.pages;

import com.gmail.igorzayatsa.utils.ConfProperties;
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

    public void isMainPage(){
        if (!webDriver.getCurrentUrl().equals(ConfProperties.getProperty("mainPage"))){
            webDriver.get(ConfProperties.getProperty("mainPage"));
        }
    }

    @FindBy(css = ".service:nth-child(3) > .service__title > a:nth-child(1)")
    private WebElement depositButton;

    @FindBy(xpath= "//div[2]/div/div[2]/div/div/a")
    private WebElement cardsButton;

    public void clickDepositButton(){
        depositButton.click();
    }

    public void clickCardsButton(){
        cardsButton.click();
    }
}
