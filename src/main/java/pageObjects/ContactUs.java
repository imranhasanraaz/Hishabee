package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import frameworks.BaseForm;
import org.openqa.selenium.By;

public class ContactUs extends BaseForm {
    public ContactUs(){
        super(By.xpath("//h2[contains(@class, 'elementor-heading-title') and contains(text(), 'Contact us')]"),"Contact Us page title");

    }

    private final IButton contactUs = getElementFactory().getButton(By.xpath("(//a[@class='elementor-item' and text()='Contact'])[1]"), "Contact Us BUtton");
    private final IButton facebook = getElementFactory().getButton(By.xpath("//i[@class='fab fa-facebook']"), "Facebook Button");
    private final IButton instagram = getElementFactory().getButton(By.xpath("//i[@class='fab fa-instagram']"), "instagram Button");

    public void clickedOnContactUS(){
        contactUs.getJsActions().click();
    }
    public void clickedOnFacebook(){
        facebook.getJsActions().click();
    }

    public void clickedOnInstagram(){
        instagram.getJsActions().click();
    }
}
