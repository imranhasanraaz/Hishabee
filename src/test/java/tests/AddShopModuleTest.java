package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ShopPage;

public class AddShopModuleTest extends BaseTest {
    @Test
    public void addModule() {
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

        logger.info("Verify that Add shop button is clickable and Add shop module is open");
        shopPage.clickedOnAddShop();
        String actualTitle = shopPage.getTitleOfCreateShop();
        String expectedTitle = testData.getValue("/createShop/pageTitle").toString();
        Assert.assertEquals(actualTitle, expectedTitle, "Create Shop Module is not open");
        logger.info("Verify that user can add shop");

        logger.info("Verify that user can add shop");
        shopPage.enterShopName(testData.getValue("/createShop/shopName").toString());
        shopPage.selectRandomShopType();
        shopPage.selectRandomDivision();
        shopPage.selectRandomDistrict();
        shopPage.selectRandomArea();
        shopPage.enterShopAddress(testData.getValue("/createShop/Address").toString());
        shopPage.clickedOnCreateShop();
        shopPage.clickedOnBusinessRecord();
        shopPage.clickedOnContinue();
        String actualShopTitle = shopPage.getShopTitle();
        String expectedShopTitle = testData.getValue("/createShop/shopName").toString();
        Assert.assertEquals(actualShopTitle, expectedShopTitle, "Shop is not created");
    }
}