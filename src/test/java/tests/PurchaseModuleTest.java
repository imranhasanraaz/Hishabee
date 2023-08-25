package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.PurchasePage;
import pageObjects.ShopPage;

public class PurchaseModuleTest extends BaseTest {
    @Test
    public void purchaseModule() {
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
        PurchasePage purchasePage = new PurchasePage();
        Assert.assertTrue(purchasePage.waitForDisplayed(), "Shop is not Open");

        logger.info("Verify That purchase menu is clickable");
        purchasePage.clickedOnPurchase();
        logger.info("Verify That Add new products is clickable");
        purchasePage.clickedOnAddNewProducts();

        logger.info("Verify that User Can add new products");
        purchasePage.setProductsName(testData.getValue("/productDetails/productName").toString());
        purchasePage.setSellingPrice(testData.getValue("/productDetails/sellingPrice").toString());
        purchasePage.setStock(testData.getValue("/productDetails/stock").toString());
        purchasePage.setPurchasePrice(testData.getValue("/productDetails/PurchasePrice").toString());
        purchasePage.clickedOnAddProduct();
        String expectedAddProductMessage = testData.getValue("/addProductMessage").toString();
        String actualAddProductMessage = purchasePage.getPopUpMessage();
        Assert.assertEquals(actualAddProductMessage, expectedAddProductMessage, "Product is no added");
        logger.info("products added successfully");

        logger.info("Verify that User Can Update Product stock");
        purchasePage.clickedOnProductTable();
        purchasePage.clickedOnEditProducts();
        purchasePage.setStock(testData.getValue("/productDetails/updatedStock").toString());
        purchasePage.clickedOnUpdateProduct();
        String expectedUpdatedProductMessage = testData.getValue("/updatedProductMessage").toString();
        Assert.assertEquals(purchasePage.getPopUpMessage(), expectedUpdatedProductMessage, "Product is not updated");
        logger.info("Product successfully updated");

        logger.info("Verify That user can delete products");
        purchasePage.clickedOnProductTable();
        purchasePage.clickedOnDeleteProduct();
        purchasePage.clickedOnYes();
        String expectedDeleteMessage = testData.getValue("/productDeleteMessage").toString();
        Assert.assertEquals(purchasePage.getPopUpMessage(), expectedDeleteMessage, "Products is not deleted");
        logger.info("Product Successfully Deleted");
    }
}