package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ShopPage;

public class EditShopModuleTest extends BaseTest {
    @Test
    public void editModule() {
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

        logger.info("Verify that user can Can Add Shop logo from edit shop section");
        shopPage.clickedOnEditShop();
        shopPage.clickedEditShop();
        shopPage.setLogoUpload(testData.getValue("/editShop/logo").toString());

        logger.info("Verify that user can Update his shop phone number");
        shopPage.setUpdatePhoneNumber(testData.getValue("/editShop/updatedPhoneNumber").toString());

        logger.info("Verify that user can Edit his shop by change Shop address");
        shopPage.enterShopAddress(testData.getValue("/editShop/updatedShopAddress").toString());
        shopPage.clickedOnUpdate();

        String expectedUpdatedMessage = testData.getValue("/editShopMessage").toString();
        String actualUpdateMessage = shopPage.getUpdatedShopMessage();
        Assert.assertEquals(actualUpdateMessage, expectedUpdatedMessage, "Shop is not Updated");
        logger.info("Shop is updated");
    }
}