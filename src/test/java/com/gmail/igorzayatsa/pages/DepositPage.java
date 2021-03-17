package com.gmail.igorzayatsa.pages;

import com.gmail.igorzayatsa.utils.SQLManager;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import java.sql.Timestamp;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepositPage {
    public WebDriver webDriver;
    protected Timestamp beginTime;
    protected Timestamp endTime;
    @FindBy(
            xpath = "//span/div"
    )
    private WebElement inBankCheck;
    @FindBy(
            name = "amount"
    )
    private WebElement amountInput;
    @FindBy(
            xpath = "//div[3]/div/span"
    )
    private WebElement periodSlider;
    @FindBy(
            linkText = "Сравнить все вклады между собой"
    )
    private WebElement depositsCompareButton;

    public DepositPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @Step("In-Bank Selection")
    @Description("Enables In-Bank Selection")
    public void calculatorInBankCheckOn() {
        this.beginTime = new Timestamp((new Date()).getTime());
        if (!inBankCheck.isSelected()) {
            inBankCheck.click();
        }

        endTime = new Timestamp((new Date()).getTime());
        SQLManager.addToList("In-Bank Selection", beginTime, endTime);
    }

    @Step("Deposit Amount")
    @Description("Set Deposit Amount")
    public void setAmountInput(String text) {
        beginTime = new Timestamp((new Date()).getTime());
        amountInput.sendKeys(text);
        endTime = new Timestamp((new Date()).getTime());
        SQLManager.addToList("Deposit Amount", beginTime, endTime);
    }

    @Step("Period Slider")
    @Description("Moves Period Slider")
    public void setPeriodSlider() {
        beginTime = new Timestamp((new Date()).getTime());
        Actions action = new Actions(webDriver);
        action.dragAndDropBy(periodSlider, -200, 0).build().perform();
        endTime = new Timestamp((new Date()).getTime());
        SQLManager.addToList("Period Slide", beginTime, endTime);
    }

    @Step("Compare Deposits")
    @Description("Clicks Deposit Compare Button Which Show Up Popup Document")
    public void clickDepositsCompareButton() {
        beginTime = new Timestamp((new Date()).getTime());
        depositsCompareButton.click();
        endTime = new Timestamp((new Date()).getTime());
        SQLManager.addToList("Compare Deposits", beginTime, endTime);
    }
}
