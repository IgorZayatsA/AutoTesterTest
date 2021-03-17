package com.gmail.igorzayatsa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;


public class DepositPage {

    public WebDriver webDriver;

    public DepositPage (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy (css = ".check-deposit:nth-child(2) .jq-checkbox")
    private WebElement inBankCheck;

    @FindBy (name = "amount")
    private WebElement amountInput;

    @FindBy (xpath = "//div[3]/div/span")
    private WebElement periodSlider;

    @FindBy (linkText = "Сравнить все вклады между собой")
    private WebElement depositsCompareButton;

    public void calculatorInBankCheckOn(){
        if(!inBankCheck.isSelected()){
            inBankCheck.click();
        }
    }

    @Step ("Set Deposit Amount")
    public void setAmountInput(String text){
        amountInput.sendKeys(text);
    }

    @Step ("Moves Period Slider")
    public void setPeriodSlider(){
        Actions action = new Actions(webDriver);
        action.dragAndDropBy(periodSlider, -200, 0).build().perform();
    }

    @Step ("Clicks Deposit Compare Button Which Show Up Popup Document")
    public void clickDepositsCompareButton(){
        depositsCompareButton.click();
    }
}
