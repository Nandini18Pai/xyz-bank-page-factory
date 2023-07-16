package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class OpenAccountPage extends Utility {

    By openAccount = By.xpath("//button[normalize-space()='Open Account']");
    By customer = By.xpath("//select[@id='userSelect']");
    By currencyList = By.xpath("//select[@id='currency']");
    By process = By.xpath("//button[contains(text(),'Process')]");


    public void clickOnOpenAccount() {
        clickOnElement(openAccount);
    }
    public void selectNameFromList(String value){
        selectByValueFromDropDown(customer,value);
    }
    public void selectCurrencyFromList(String value){
        selectByValueFromDropDown(currencyList,value);
    }
    public void clickOnProcessButton() {
        clickOnElement(process);
    }

    public String verifyMessageAccountCreatedSuccessfully(){
        return getTextFromAlert();
    }

  public String verifyTextAccountCreatedSuccessfully(){
      return getTextFromAlert();
  }



}

