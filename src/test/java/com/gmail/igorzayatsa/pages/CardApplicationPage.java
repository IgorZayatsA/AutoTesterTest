package com.gmail.igorzayatsa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



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

    public void setClientLastNameTextBox(String text){
        clientLastNameTextBox.sendKeys(text);
    }

    public void setClientNameTextBox(String text){
        clientNameTextBox.sendKeys(text);
    }

    public void setClientMobilePhoneTextBox(String text){
        clientMobilePhoneTextBox.click();
        clientMobilePhoneTextBox.sendKeys(text);
    }

    public void onClientSecondNameCheckbox(){
        if (!clientSecondNameCheckBox.isSelected()){
            clientSecondNameCheckBox.click();
        }
    }

    public void setAdditionalEmailTextBox(String text){
        additionalEmailTextBox.sendKeys(text);
    }

    public void setCreditRegionSelectBox(String text){
        regionSelectBox.click();
        WebElement selectBoxField = webDriver.findElement(By.xpath("//li[contains(.,'" + text + "')]"));
        selectBoxField.click();
    }


}
