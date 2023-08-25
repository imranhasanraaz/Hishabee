package tests;

import aquality.selenium.core.logging.Logger;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.*;

public class BaseTest {
    protected final ISettingsFile testData = new JsonSettingsFile("testData.json");
    private final ISettingsFile configReader = new JsonSettingsFile("config.json");
    private final String URL = configReader.getValue("/URL").toString();
    public Logger logger = getLogger();

    @BeforeMethod
    public void SetUp() {
        getBrowser().maximize();
        getBrowser().goTo(URL);
        getBrowser().waitForPageToLoad();
    }

    @AfterClass
    public void Teardown() {
        getBrowser().getDriver().quit();
    }
}
