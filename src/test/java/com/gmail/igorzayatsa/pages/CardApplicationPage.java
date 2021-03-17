package com.gmail.igorzayatsa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.qameta.allure.Step;


public class CardApplicationPage {

    public WebDriver webDriver;

    public CardApplicationPage (WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    @FindBy(id = "t1")
    private WebElement clientLastNameTextBox;

    @FindBy(id = "t2")
    private WebElement clientNameTextBox;

    @FindBy(xpath = "//label/div")
    private WebElement clientSecondNameCheckBox;

    @FindBy(id = "t4")
    private WebElement clientMobilePhoneTextBox;

    @FindBy(id = "t38")
    private WebElement additionalEmailTextBox;

    @FindBy(xpath = "//div[8]/div/div/div")
    private WebElement regionSelectBox;

    @Step ("Fills in the Last Name Field")
    public void setClientLastNameTextBox(String text){
        clientLastNameTextBox.sendKeys(text);
    }

    @Step ("Fills in the Name Field")
    public void setClientNameTextBox(String text){
        clientNameTextBox.sendKeys(text);
    }

    @Step ("Fills in the Mobile Phone Field")
    public void setClientMobilePhoneTextBox(String text){
        clientMobilePhoneTextBox.click();
        clientMobilePhoneTextBox.sendKeys(text);
    }

    @Step ("Sets Client Second Name Toggle On")
    public void onClientSecondNameCheckbox(){
        if (!clientSecondNameCheckBox.isSelected()){
            clientSecondNameCheckBox.click();
        }
    }

    @Step ("Fills in the Email Field")
    public void setAdditionalEmailTextBox(String text){
        additionalEmailTextBox.sendKeys(text);
    }

    @Step ("Selects Region")
    public void setCreditRegionSelectBox(String text){
        regionSelectBox.click();
        WebElement selectBoxField = webDriver.findElement(By.xpath("//li[contains(.,'" + text + "')]"));
        selectBoxField.click();
    }


}
