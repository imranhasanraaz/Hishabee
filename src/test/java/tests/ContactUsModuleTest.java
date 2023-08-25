package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ContactUs;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class ContactUsModuleTest extends BaseTest{
    @Test
    public void TestContactUs(){
        ContactUs contactUs = new ContactUs();
        contactUs.clickedOnContactUS();

        logger.info("Verify that User can go hishabee Facebook account from contact US");
        contactUs.clickedOnFacebook();
        getBrowser().tabs().switchToLastTab();
        String facebookLink = getBrowser().getDriver().getCurrentUrl();
        getBrowser().tabs().closeTab();
        Assert.assertEquals(facebookLink, testData.getValue("/facebookLink").toString());
        logger.info("Facebook Link Works");

        logger.info("Verify that User can go hishabee Instagram account from contact US");
        getBrowser().tabs().switchToLastTab();
        contactUs.clickedOnInstagram();
        getBrowser().tabs().switchToLastTab();
        String instagramLink = getBrowser().getDriver().getCurrentUrl();
        getBrowser().tabs().closeTab();
        Assert.assertEquals(instagramLink, testData.getValue("/instagramLink").toString());
        logger.info("Instagram Link Works");
    }
}
