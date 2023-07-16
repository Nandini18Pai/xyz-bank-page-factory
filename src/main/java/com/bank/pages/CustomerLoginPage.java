package com.bank.pages;

import com.bank.utilities.Utility;
import org.openqa.selenium.By;

public class CustomerLoginPage extends Utility {
    By customerLogin = By.xpath("//button[contains(text(),'Customer Login')]");
    By searchCustomer = By.xpath("//select[@id='userSelect']");
    By loginButton = By.xpath("//button[@type='submit']");
    By logoutButton = By.xpath("//button[@class='btn logout']");
    By yourName = By.xpath("//span[contains(text(),'champa chameli')]");
    By logout = By.xpath("//button[contains(text(),'Logout')]");
    By depositButton = By.xpath("//button[normalize-space()='Deposit']");
    By amount = By.xpath("//input[@placeholder='amount']");
    By deposit = By.xpath("//button[@type='submit']");
    By depositMessage = By.xpath("//span[@class='error ng-binding']");
    By withDrawl = By.xpath("//button[normalize-space()='Withdrawl']");
    By withDrawlAmount = By.xpath("//input[@placeholder='amount']");
    By clickWithdraw = By.xpath("//button[@type='submit']");
    By withdrawMessage = By.xpath("//span[@class='error ng-binding']");



    public void clickOnCustomerLogin(){
        clickOnElement(customerLogin);
    }

    public void setSearchCustomer(String dropDown) {
        selectByVisibleTextFromDropDown(searchCustomer, dropDown);  //
    }

    public void clickOnLogin() {
        clickOnElement(loginButton);
    }

    public String verifyLogoutButtonIsDisplayed() {
        return getTextFromElement(logoutButton);
    }

    public void clickOnLogout() {
        clickOnElement(logout);
    }

    //   verify "Your Name" text displayed.

    public String verifyYourNameTextIsDisplayed() {
        return getTextFromElement(yourName);

    }

    public void clickOnDeposit() {
        clickOnElement(depositButton);
    }

    public void enterAmount(String amounts) {
        sendTextToElement(amount, amounts);
    }

    public String verifyDepositMessage() {
        return getTextFromElement(depositMessage);
    }

    public void setWithDrawl() {
        clickOnElement(withDrawl);
    }

    public void setWithDrawlAmount(String withDrawlAmounts) {
        sendTextToElement(withDrawlAmount, withDrawlAmounts);
    }

    public void setClickWithdraw() {
        clickOnElement(clickWithdraw);
    }
    public String setWithdrawMessage() {
        return getTextFromElement(withdrawMessage);

    }

    }
