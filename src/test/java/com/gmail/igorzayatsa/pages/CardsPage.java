package com.gmail.igorzayatsa.pages;

import com.gmail.igorzayatsa.utils.CardType;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardsPage {
    public WebDriver webDriver;
    @FindBy(
            xpath = "//div[2]/div/div[2]/a"
    )
    private WebElement creditCard365ApplicationButton;
    @FindBy(
            xpath = "//div[3]/div/div[2]/a"
    )
    private WebElement creditCardDrive365ApplicationButton;
    @FindBy(
            xpath = "//div[2]/div[4]/div/div[2]/a"
    )
    private WebElement debetCard365ApplicationButton;
    @FindBy(
            xpath = "//div[5]/div/div[2]/a"
    )
    private WebElement debetCardDrive365ApplicationButton;

    public CardsPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @Step("Application Button")
    @Description("Clicks on the Application Button Depending of a Card Type")
    public void applicationButtonClick(CardType cardType) throws InterruptedException {
        Thread.sleep(1000);
        switch(cardType) {
            case CREDIT365:
                creditCard365ApplicationButton.click();
                break;
            case CREDITDRIVE365:
                creditCardDrive365ApplicationButton.click();
                break;
            case DEBET365:
                debetCard365ApplicationButton.click();
                break;
            case DEBETDRIVE365:
                debetCardDrive365ApplicationButton.click();
        }

    }
}
