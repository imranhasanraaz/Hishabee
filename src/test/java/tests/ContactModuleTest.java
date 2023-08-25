package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactsPage;
import pageObjects.LoginPage;
import pageObjects.ShopPage;

public class ContactModuleTest extends BaseTest {
    @Test
    public void contactModule(){

        LoginPage loginPage = new LoginPage();
        loginPage.clickedOnWebLogin();
        Assert.assertTrue(loginPage.waitForDisplayed(), "Login Page is not open");
        logger.info("Login Page is Open");
        loginPage.insertPhoneNumber(testData.getValue("/validRegisteredNumber").toString());
        loginPage.clickedOnContinue();
        loginPage.insertPin(testData.getValue("/validRegisteredPin").toString());
        loginPage.clickOnSignIn();
        ShopPage shopPage = new ShopPage();
        Assert.assertTrue(shopPage.waitForDisplayed(), "Shop Module is not open");
        logger.info("Shop Module is Open After Login");

        shopPage.clickedSelectShop();
        ContactsPage contactsPage = new ContactsPage();
        Assert.assertTrue(contactsPage.waitForDisplayed(), "Shop is not open");

        logger.info("Verify that Contacts button is clickable");
        contactsPage.clickedOnContacts();

        logger.info("Verify That Add new customer is clickable");
        contactsPage.clickedOnAddNewCustomer();

        logger.info("Verify that User Can add new Customer");
        contactsPage.setName(testData.getValue("/customerDetails/name").toString());
        contactsPage.setPhone(testData.getValue("/customerDetails/phone").toString());
        contactsPage.setAddress(testData.getValue("/customerDetails/address").toString());
        contactsPage.clickedOnSave();
        String expectedSuccessMessage = testData.getValue("/customerAddSuccessMessage").toString();
        String actualMessage = contactsPage.getPopUpMessage();
        Assert.assertEquals(actualMessage, expectedSuccessMessage , "Customer is not added");
        logger.info("New Customer successfully added");
    }
}
