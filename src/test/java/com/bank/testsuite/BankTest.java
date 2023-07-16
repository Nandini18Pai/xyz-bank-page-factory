package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {

    AccountPage accountPage;
    AddCustomerPage addCustomerPage ;
    BankManagerLoginPage bankManagerLoginPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    HomePage homePage;
    OpenAccountPage openAccountPage;


@BeforeMethod(alwaysRun = true)
public void inIT(){

    accountPage = new AccountPage();
    addCustomerPage = new AddCustomerPage();
    bankManagerLoginPage = new BankManagerLoginPage();
    customerLoginPage = new CustomerLoginPage();
    customersPage = new CustomersPage();
    homePage = new HomePage();
    openAccountPage = new OpenAccountPage();
}




    @Test(groups = {"sanity","smoke", "regression"} )
    public void bankManagerShouldAddCustomerSuccessfully() {

        bankManagerLoginPage.clickOnBankManagerLogin();  //  click On "Bank Manager Login" Tab
        customersPage.addCustomerTab();    //   click On "Add Customer" Tab
        customersPage.enterFirstName("Champa");  //  enter FirstName
        customersPage.enterLastName("Chameli");  //  enter LastName
        customersPage.enterPostcode("NN9 3JK"); //  enter PostCode
        customersPage.clickAddToCustomerButton();   //  click On "Add Customer" Button
        customersPage.getTextFromAlert(); //  popup display

        //  verify message "Customer added successfully"
        String actualText = customersPage.verifyTextCustomerAddedSuccessfully();
        String expectedText = "Customer added successfully with customer id :6";
        Assert.assertEquals(actualText, expectedText);

        //   click on "ok" button on popup.
        customersPage.acceptAlert();
    }

    @Test(groups = {"smoke", "regression"} )
    public void bankManagerShouldOpenAccountSuccessfully() {

        bankManagerLoginPage.clickOnBankManagerLogin(); //click On "Bank Manager Login" Tab
        openAccountPage.clickOnOpenAccount();           //	click On "Open Account" Tab
        openAccountPage.selectNameFromList("6"); //	Search customer that created in first test
        openAccountPage.selectCurrencyFromList("Pound"); //	Select currency "Pound"
        openAccountPage.clickOnProcessButton();   //	click on "process" button
        openAccountPage.getTextFromAlert(); //	popup displayed
        //	verify message "Account created successfully"
        String actualText = openAccountPage.verifyTextAccountCreatedSuccessfully();
        String expectedText = "Account created successfully";
        Assert.assertEquals(actualText, expectedText);
        openAccountPage.acceptAlert();    //	click on "ok" button on popup.

    }

    @Test(groups = {"regression"} )
    public void customerShouldLoginAndLogoutSuccessfully(){



        customerLoginPage.clickOnCustomerLogin();
        customerLoginPage.setSearchCustomer("champa chameli");
        customerLoginPage.clickOnLogin();

        //  verify "Logout" Tab displayed.

        String actualLogout = customerLoginPage.verifyLogoutButtonIsDisplayed();
        String expectedLogout = "Logout";
        Assert.assertEquals(actualLogout, expectedLogout);

        customerLoginPage.clickOnLogout(); // click on "Logout"

     //   verify "Your Name" text displayed.
        String actualNameText = customerLoginPage.verifyYourNameTextIsDisplayed();
        String expectedNameText = "champa chameli ";
        Assert.assertEquals(actualNameText,expectedNameText);


    }

    @Test(groups = {"regression"} )
    public void customerShouldDepositMoneySuccessfully(){
        customerLoginPage.clickOnCustomerLogin();
        customerLoginPage.setSearchCustomer("champa chameli");
        customerLoginPage.clickOnLogin();
        customerLoginPage.clickOnDeposit();
        //	Enter amount 100
        customerLoginPage.enterAmount("100");
        //	click on "Deposit" Button
        customerLoginPage.clickOnDeposit();

        //	verify message "Deposit Successful"
        String actualMessage = customerLoginPage.verifyDepositMessage();
        String expectedMessage = "Deposit Successful";
        Assert.assertEquals(expectedMessage, actualMessage);



      //  Enter amount 100
     //   click on "Deposit" Button
      //  verify message "Deposit Successful"


    }
    @Test(groups = {"regression"} )
    public void customerShouldWithdrawMoneySuccessfully() {
        // click on "Customer Login" Tab
        customerLoginPage.clickOnCustomerLogin();
        //	search customer that you created.
        customerLoginPage.setSearchCustomer("champa chameli");
        //	click on "Login" Button
        customerLoginPage.clickOnLogin();
        //	click on "WithDrawl" Tab
        customerLoginPage.setWithDrawl();
        //	Enter amount 50
        customerLoginPage.setWithDrawlAmount("50");
        //	click on "Withdraw" Button
        customerLoginPage.setClickWithdraw();
        //	verify message "Transaction Successful"
        String actualMessage = customerLoginPage.setWithdrawMessage();
        String expectedMessage = "Transaction successful";
        Assert.assertEquals(expectedMessage, actualMessage, "Text not verified");
    }


}
