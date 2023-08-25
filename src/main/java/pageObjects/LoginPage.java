package pageObjects;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import frameworks.BaseForm;
import org.openqa.selenium.By;

public class LoginPage extends BaseForm {

    private final IButton languageBn = getElementFactory().getButton(By.xpath("//label[@for='btn-check' and @class='btn']"), "Bengali language");
    private final IButton languageEn = getElementFactory().getButton(By.xpath("//label[@for='btn-check-2' and @class='btn']"), "English language");
    private final ILabel bengaliWelcome = getElementFactory().getLabel(By.xpath("//p[@class='text-center' and contains(text(), 'স্বাগতম ')]"), "Bengali Welcome");
    private final IButton webLogin = getElementFactory().getButton(By.xpath("//span[@class='elementor-button-text' and contains(text(), 'Web Login')]"), "Web Login");
    private final ITextBox phoneNumber = getElementFactory().getTextBox(By.xpath("//input[@type='number']"), "Phone Number Box");
    private final IButton continueButton = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Continue Button");
    private final ITextBox pinNumberBox = getElementFactory().getTextBox(By.xpath("//input[@type='password']"), "Pin Number Box");
    private final IButton signInButton = getElementFactory().getButton(By.xpath("//button[@type='submit']"), "Sign IN Button");
    private final ILabel invalidPinErrorMessage = getElementFactory().getLabel(By.xpath("//div[@class='snotifyToast animated snotify-error fadeIn']"), "Invalid Pin Error Message pop up");
    private final ILabel invalidPhoneErrorMessage = getElementFactory().getLabel(By.xpath("//div[@class='snotifyToast__body']"), "Invalid Phone Number Error Message pop up");
    public LoginPage() {
        super(By.xpath("//p[@class='text-center' and contains(text(), 'Welcome ')]"), "Welcome");
    }

    public void clickedOnWebLogin() {
        webLogin.clickAndWait();
    }

    public void changeLanguageTOBengali() {
        languageBn.clickAndWait();
    }

    public void changeLanguageTOEnglish() {
        languageEn.clickAndWait();
    }

    public String getBengaliWelcomeTitle() {
        return bengaliWelcome.getText();
    }

    public void insertPhoneNumber(String number) {
        phoneNumber.clearAndType("");
        phoneNumber.sendKeys(number);
    }

    public void clickedOnContinue() {
        continueButton.clickAndWait();
    }

    public void insertPin(String pin) {
        pinNumberBox.clearAndType(pin);
    }

    public void clickOnSignIn() {
        signInButton.clickAndWait();
    }

    public String getErrorMessage() {
        return invalidPinErrorMessage.getText();
    }

    public String getPhoneNumberErrorMessage() {
        return invalidPhoneErrorMessage.getText();
    }
}