package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import frameworks.BaseForm;
import org.openqa.selenium.By;

public class ContactsPage extends BaseForm {
    public ContactsPage() {
        super(By.xpath("//h5[contains(@class, 'logo-title') and contains(@class, 'text-white')]"), "Shop Name");
    }

    private final IButton contacts = getElementFactory().getButton(By.xpath("//span[text()='Contacts']"), "Contacts");
    private final IButton addNewCustomer = getElementFactory().getButton(By.xpath("//a[@href='/customer/create']"), "Add New Products");
    private final ITextBox name = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Name']"), "Customer Name");
    private final ITextBox phone = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Mobile Number']"), "Customer Number");
    private final ITextBox address = getElementFactory().getTextBox(By.xpath("//input[@placeholder='Address']"), "Customer Address");
    private final IButton saveButton = getElementFactory().getButton(By.xpath("//button[@type='submit' and contains(text(), 'Save')]"), "Save BUtton");
    private final ILabel Message = getElementFactory().getLabel(By.xpath("//div[@class='snotifyToast__body']"), "Pop UP Message");

    public void clickedOnContacts(){
        contacts.click();
    }

    public void clickedOnAddNewCustomer(){
        addNewCustomer.getJsActions().click();
    }

    public void setName(String customerName){
        name.clearAndType(customerName);
    }

    public void setPhone(String customerPhone){
        phone.clearAndType(customerPhone);
    }
    public void setAddress(String customerAddress){

        address.clearAndType(customerAddress);
    }
    public void clickedOnSave(){
        saveButton.getJsActions().click();
    }
    public String getPopUpMessage() {
        return Message.getText();
    }
}