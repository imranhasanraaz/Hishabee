package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import frameworks.BaseForm;
import org.openqa.selenium.By;

public class PurchasePage extends BaseForm {

    private final IButton purchase = getElementFactory().getButton(By.xpath("//span[text()='Purchase']"), "Purchase");
    private final IButton addNewProducts = getElementFactory().getButton(By.xpath("//a[@href='/products/create']"), "Add New Products");
    private final ITextBox productsName = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Product Name']"), "Product Name");
    private final ITextBox sellingPrice = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Sale Price']"), "selling Price");
    private final ITextBox stock = getElementFactory().getTextBox(By.xpath("//input[@placeholder='stock available']"), "Stock");
    private final ITextBox purchasePrice = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Purchase Price']"), "Purchase Price");
    private final IButton addProduct = getElementFactory().getButton(By.xpath("//button[@type='submit' and contains(text(), 'Add products')]"), "Add Products");
    private final ILabel productsTable = getElementFactory().getLabel(By.xpath("//*[@id='productShoingTable']/div/table/tbody/tr"), "products table");
    private final IButton deleteProducts = getElementFactory().getButton(By.xpath("//img[@src='/assets/images/hishabee/delete-bg-none.svg']"), "Delete Product Button");
    private final IButton confirmDelete = getElementFactory().getButton(By.xpath("//button[normalize-space()='Yes' and contains(@class, 'snotifyToast__buttons--bold')]"), "Confirm Delete");
    private final ILabel Message = getElementFactory().getLabel(By.xpath("//div[@class='snotifyToast__body']"), "delete Product Message");
    private final IButton editProducts = getElementFactory().getButton(By.xpath("//img[@src='/assets/images/hishabee/edit-blue.svg']"), "edit Product Button");
    private final IButton updateProduct = getElementFactory().getButton(By.xpath("//button[@type='submit' and contains(text(), 'Update the product')]"), "Update Products");
    public PurchasePage() {
        super(By.xpath("//h5[contains(@class, 'logo-title') and contains(@class, 'text-white')]"), "Shop Name");
    }

    public void clickedOnUpdateProduct() {
        updateProduct.getJsActions().scrollIntoView();
        updateProduct.getJsActions().clickAndWait();
    }

    public void clickedOnEditProducts() {
        editProducts.getJsActions().click();
    }

    public void clickedOnYes() {
        confirmDelete.getJsActions().click();
    }

    public void clickedOnDeleteProduct() {
        deleteProducts.getJsActions().click();
    }

    public void clickedOnProductTable() {
        productsTable.getJsActions().click();
    }

    public void clickedOnPurchase() {
        purchase.state().waitForDisplayed();
        purchase.click();
    }

    public void clickedOnAddNewProducts() {
        addNewProducts.click();
    }

    public void setProductsName(String Name) {
        productsName.clearAndType(Name);
    }

    public void setSellingPrice(String price) {
        sellingPrice.clearAndType(price);
    }

    public void setStock(String stock1) {
        stock.clearAndType(stock1);
    }

    public void setPurchasePrice(String purchasePrice1) {
        purchasePrice.clearAndType(purchasePrice1);
    }

    public void clickedOnAddProduct() {
        addProduct.getJsActions().click();

    }

    public String getPopUpMessage() {
        return Message.getText();
    }

}
