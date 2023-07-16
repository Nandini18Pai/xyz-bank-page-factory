package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends Utility {

  //  By addCustomer = By.xpath("//button[normalize-space()='Add Customer']");
  //  By firstName = By.xpath("//input[@placeholder='First Name']");
 //   By lastName = By.xpath("//input[@placeholder='Last Name']");
  //  By postcode = By.xpath("//input[@placeholder='Post Code']");
  //  By addCustomerButton = By.xpath("//button[@type='submit']");


    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;

    public void addCustomerTab() {
        clickOnElement(addCustomer);
    }
    public void enterFirstName(String name) {
        sendTextToElement(firstName, name);
    }
    public void enterLastName(String name) {
        sendTextToElement(lastName, name);
    }
    public void enterPostcode(String code) {
        sendTextToElement(postcode, code);
    }
    public void clickAddToCustomerButton(){
        clickOnElement(addCustomerButton);
    }
    public String verifyTextCustomerAddedSuccessfully(){
        return getTextFromAlert();

    }


}
