package com.gmail.igorzayatsa.tests;

import com.gmail.igorzayatsa.pages.CardApplicationPage;
import com.gmail.igorzayatsa.pages.CardsPage;
import com.gmail.igorzayatsa.pages.MainPage;
import com.gmail.igorzayatsa.utils.CardType;
import com.gmail.igorzayatsa.utils.WebDriverInit;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CardApplicationTest {

    public MainPage mainPage;
    public CardsPage cardsPage;
    public CardApplicationPage cardApplicationPage;

    public WebDriver webDriver;

    @BeforeClass
    public void setup(){
        webDriver = WebDriverInit.getInstance().getDriver();
        mainPage = PageFactory.initElements(webDriver, MainPage.class);
        cardApplicationPage = PageFactory.initElements(webDriver, CardApplicationPage.class);
        cardsPage = PageFactory.initElements(webDriver, CardsPage.class);
        webDriver.manage().window().maximize();
    }

    @Test (priority = 1)
    @Feature("Feature 2: Card Application")
    @Story("Card Application")
    public void cardApplicationTest() throws Exception{

        mainPage.clickCardsButton();

        cardsPage.applicationButtonClick(CardType.CREDIT365);

        cardApplicationPage.setClientLastNameTextBox("Тестов");
        cardApplicationPage.setClientNameTextBox("Тест");
        cardApplicationPage.onClientSecondNameCheckbox();
        cardApplicationPage.setClientMobilePhoneTextBox("9861234567");
        cardApplicationPage.setAdditionalEmailTextBox("Testov@tmail.com");
        cardApplicationPage.setCreditRegionSelectBox("Москва");
    }

}
