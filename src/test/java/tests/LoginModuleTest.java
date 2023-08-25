package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ShopPage;

public class LoginModuleTest extends BaseTest {
    @Test
    public void loginModule() {
        LoginPage loginPage = new LoginPage();
        loginPage.clickedOnWebLogin();
        Assert.assertTrue(loginPage.waitForDisplayed(), "Login Page is not open");
        logger.info("Login Page is Open");
        logger.info("Language change test starting");
        loginPage.changeLanguageTOBengali();
        String actualBengaliWelcomeTitle = loginPage.getBengaliWelcomeTitle();
        String expectedBengaliWelcomeTitle = testData.getValue("/bengaliWelcomeTitle").toString();
        Assert.assertEquals(actualBengaliWelcomeTitle, expectedBengaliWelcomeTitle, "Language is not changed to bengali");
        logger.info("Language is changed to bengali");
        loginPage.changeLanguageTOEnglish();
        logger.info("Successfully tested changed language");

        logger.info("Verify that User can not login with invalid Pin and get proper error message");
        loginPage.insertPhoneNumber(testData.getValue("/inValidPhone").toString());
        loginPage.clickedOnContinue();
        String actualErrorMessage = loginPage.getPhoneNumberErrorMessage();
        String expectedErrorMessage = testData.getValue("/invalidNumberErrorMessage").toString();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message doesn't Show");
        logger.info("Successfully Tested User Can not login with invalid Phone Number");

        logger.info("Verify that User can not login with invalid Pin and get proper error message");
        loginPage.insertPhoneNumber(testData.getValue("/validRegisteredNumber").toString());
        loginPage.clickedOnContinue();
        loginPage.insertPin(testData.getValue("/inValidPin").toString());
        loginPage.clickOnSignIn();
        String actualInvalidPinErrorMessage = loginPage.getErrorMessage();
        String expectedInvalidPinErrorMessage = testData.getValue("/invalidPinErrorMessage").toString();
        Assert.assertEquals(actualInvalidPinErrorMessage, expectedInvalidPinErrorMessage, "Error Message doesn't Show");
        logger.info("Successfully tested that user can not login with invalid pin");

        logger.info("Verify that user can login with valid pin");
        loginPage.insertPin(testData.getValue("/validRegisteredPin").toString());
        loginPage.clickOnSignIn();
        ShopPage shopPage = new ShopPage();
        Assert.assertTrue(shopPage.waitForDisplayed(), "Shop Module is not open");
        logger.info("Successfully tested login module");
    }
}