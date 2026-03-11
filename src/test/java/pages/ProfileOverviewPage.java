package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUI;
import utils.Driver;

public class ProfileOverviewPage extends BaseUI {

    private final WebDriver driver = Driver.getDriver();

    public ProfileOverviewPage() {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//h1[normalize-space()='Profile & Settings'] | //h2[normalize-space()='Profile & Settings']")
    public WebElement pageHeading;


    @FindBy(xpath = "//button[normalize-space()='Personal details'] | //a[normalize-space()='Personal details']")
    public WebElement personalDetailsMenuItem;

    @FindBy(xpath = "//button[normalize-space()='Business details'] | //a[normalize-space()='Business details']")
    public WebElement businessDetailsMenuItem;


    @FindBy(xpath = "//*[normalize-space()='Personal details'][ancestor::*[contains(@class,'card')]] | //h3[normalize-space()='Personal details']")
    public WebElement personalDetailsCard;

    @FindBy(xpath = "//*[normalize-space()='Business details'][ancestor::*[contains(@class,'card')]] | //h3[normalize-space()='Business details']")
    public WebElement businessDetailsCard;

    @FindBy(xpath = "//*[normalize-space()='Sign-in & security'][ancestor::*[contains(@class,'card')]] | //h3[normalize-space()='Sign-in & security']")
    public WebElement signInSecurityCard;

    @FindBy(xpath = "//*[normalize-space()='Account settings'][ancestor::*[contains(@class,'card')]] | //h3[normalize-space()='Account settings']")
    public WebElement accountSettingsCard;

    @FindBy(xpath = "//*[normalize-space()='Alerts'][ancestor::*[contains(@class,'card')]] | //h3[normalize-space()='Alerts']")
    public WebElement alertsCard;

    @FindBy(xpath = "//*[normalize-space()='Payment preferences'][ancestor::*[contains(@class,'card')]] | //h3[normalize-space()='Payment preferences']")
    public WebElement paymentPreferencesCard;


    @FindBy(xpath = "(//a[normalize-space()='Update info'])[1]")
    public WebElement personalDetailsUpdateLink;

    @FindBy(xpath = "(//a[normalize-space()='Update info'])[2]")
    public WebElement businessDetailsUpdateLink;

    @FindBy(xpath = "//a[normalize-space()='Protect info']")
    public WebElement signInSecurityProtectLink;

    @FindBy(xpath = "//a[normalize-space()='Customize settings']")
    public WebElement accountSettingsCustomizeLink;


    public void verifyPageHeading(String expectedHeading) {
        waitUntilVisible(20, pageHeading);
        Assertions.assertEquals(
                expectedHeading,
                pageHeading.getText().trim(),
                "Page heading should be: " + expectedHeading
        );
    }

    public void verifyCardIsVisible(WebElement card, String cardName) {
        waitUntilVisible(20, card);
        Assertions.assertTrue(
                card.isDisplayed(),
                cardName + " card should be visible on the overview page"
        );
    }

    public void clickPersonalDetailsMenuItem() {
        waitAndClick(personalDetailsMenuItem);
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("account"),
                "Should stay on account page after clicking Personal details"
        );
    }

    public void clickBusinessDetailsMenuItem() {
        waitAndClick(businessDetailsMenuItem);
        Assertions.assertTrue(
                driver.getCurrentUrl().contains("account"),
                "Should stay on account page after clicking Business details"
        );
    }
}
