package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {

       // By managerLogin = By.xpath("//button[contains(text(),'Bank Manager Login')]");

    @CacheLookup

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement managerLogin;


    public  void clickOnBankManagerLogin() {
        clickOnElement(managerLogin);
    }






}
