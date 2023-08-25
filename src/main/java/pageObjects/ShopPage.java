package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import frameworks.BaseForm;
import org.openqa.selenium.By;
import utils.RobotUtils;

public class ShopPage extends BaseForm {
    private final IButton addShop = getElementFactory().getButton(By.xpath("//button[@class='btn btn-primary' and contains(text(), '+ Add Shop')]"), "Add Shop");
    private final IButton editShop = getElementFactory().getButton(By.xpath("//button[contains(text(), 'Edit Shop')]"), "Edit Shop");
    private final ILabel createShopTitle = getElementFactory().getLabel(By.xpath("//p[contains(text(), 'Create Shop')]"), "Create Shop Title");
    private final ITextBox shopName = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Shop name']"), "Shop Name");
    private final ITextBox shopAddress = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Address']"), "Shop Address");
    private final IComboBox shopType = getElementFactory().getComboBox(By.xpath("//select[@class='form-select product_create_select' and option[text()='Select shop type']]"), "ShopType Dropdown");
    private final IComboBox division = getElementFactory().getComboBox(By.xpath("//select[@class='form-select product_create_select' and option[text()='Division']]"), "Division Dropdown");
    private final IComboBox district = getElementFactory().getComboBox(By.xpath("//select[@class='form-select product_create_select' and option[text()='District']]"), "District Dropdown");
    private final IComboBox area = getElementFactory().getComboBox(By.xpath("//select[@class='form-select product_create_select' and option[text()='Area']]"), "Area Dropdown");
    private final IButton createShop = getElementFactory().getButton(By.xpath("//button[@type='submit' and contains(text(), 'Create Shop')]"), "Create Shop Button");
    private final IButton businessPurpose = getElementFactory().getButton(By.xpath("//p[contains(text(), 'For keeping business records' )]"), "Business purpose");
    private final IButton continueButton = getElementFactory().getButton(By.xpath("//button[@type = 'submit']"), "Continue Button");
    private final ILabel ShopTitle = getElementFactory().getLabel(By.xpath("//h5[contains(@class, 'logo-title') and contains(@class, 'text-white')]"), "Shop title");
    private final IButton editDesireShop = getElementFactory().getButton(By.xpath("//div[@class='card-body'][h5='Imran & Sons']/button[@class='btn btn-primary']"), "Edit Desire Shop");
    private final IButton selectDesireShop = getElementFactory().getButton(By.xpath("//div[@class='card-body'][h5='Imran & Sons']/button[@class='btn btn-primary']"), "Edit Desire Shop");
    private final ILabel editShopMessage = getElementFactory().getLabel(By.xpath("//div[@class='snotifyToast__body']"), "Updated Shop Message");
    private final IButton updateButton = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Update Button");
    private final ITextBox updatePhone = getElementFactory().getTextBox(By.xpath("//input[@type='number']"), "Update Phone number");
    private final ILabel logoUpload = getElementFactory().getLabel(By.xpath("//label[@for = 'file-input']"), "Logo Upload");
    public ShopPage() {
        super(By.xpath("//p[@class='text-center' and contains(text(), 'Select your shop ')]"), "Select Shop title");
    }

    public void setLogoUpload(String path) {
        logoUpload.clickAndWait();
        RobotUtils robot = new RobotUtils();
        robot.uploadFile(path);

    }

    public void setUpdatePhoneNumber(String number) {
        updatePhone.getJsActions().scrollIntoView();
        updatePhone.clearAndType(number);

    }

    public void clickedOnAddShop() {
        addShop.clickAndWait();
    }

    public void clickedOnEditShop() {
        editShop.clickAndWait();
    }

    public String getTitleOfCreateShop() {
        return createShopTitle.getText();
    }

    public void enterShopName(String name) {
        shopName.clearAndType(name);
    }

    public void enterShopAddress(String address) {
        shopAddress.getJsActions().scrollIntoView();
        shopAddress.clearAndType(address);
    }

    public void selectRandomShopType() {
        shopType.state().waitForDisplayed();
        shopType.selectByIndex(1);
    }

    public void selectRandomDivision() {
        division.state().waitForDisplayed();
        division.selectByIndex(2);
    }

    public void selectRandomDistrict() {
        district.state().waitForDisplayed();
        district.selectByIndex(2);
    }

    public void selectRandomArea() {
        area.state().waitForDisplayed();
        area.getJsActions().scrollIntoView();
        area.selectByIndex(2);
    }

    public void clickedOnCreateShop() {
        createShop.getJsActions().scrollIntoView();
        createShop.state().waitForClickable();
        createShop.click();
    }

    public void clickedOnBusinessRecord() {
        businessPurpose.clickAndWait();
    }

    public void clickedOnContinue() {
        continueButton.getJsActions().scrollIntoView();
        continueButton.state().waitForClickable();
        continueButton.click();
    }

    public String getShopTitle() {
        return ShopTitle.getText();
    }

    public void clickedEditShop() {
        editDesireShop.state().waitForClickable();
        editDesireShop.click();
    }

    public void clickedSelectShop() {
        selectDesireShop.state().waitForClickable();
        selectDesireShop.click();
    }

    public void clickedOnUpdate() {
        updateButton.getJsActions().click();
    }

    public String getUpdatedShopMessage() {
        return editShopMessage.getText();
    }

}