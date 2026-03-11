package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUI;
import utils.Driver;

public class BusinessDetailsPage extends BaseUI {

    private final WebDriver driver = Driver.getDriver();

    public BusinessDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//header[@class='bg-nav w-full']//a[text()='Profile & settings']")
    public WebElement pageHeading;

    @FindBy(xpath = "//span[text()='Business details']/..")
    public WebElement businessDetailsHeading;

    @FindBy(xpath = "//input[@placeholder='Enter your business name'] | //input[@name='businessName']")
    public WebElement businessNameInput;

    @FindBy(xpath = "//input[@placeholder='e.g. $50,000 – $100,000'] | //input[@name='annualRevenue']")
    public WebElement annualRevenueInput;

    @FindBy(xpath = "//input[@placeholder='e.g. Technology, Retail'] | //input[@name='industry']")
    public WebElement industryInput;

    @FindBy(xpath = "//button[normalize-space()='Save Changes']")
    public WebElement saveChangesButton;

    public void verifyBusinessDetailsFormIsVisible() {
        waitUntilVisible(20, businessDetailsHeading);
        Assertions.assertTrue(
                businessDetailsHeading.isDisplayed(),
                "Business Details heading should be visible"
        );
    }

    public void verifyAllFieldsAreVisible() {
        waitUntilVisible(20, businessNameInput);
        Assertions.assertTrue(businessNameInput.isDisplayed(),
                "Business Name input should be visible");

        waitUntilVisible(20, annualRevenueInput);
        Assertions.assertTrue(annualRevenueInput.isDisplayed(),
                "Annual Revenue input should be visible");

        waitUntilVisible(20, industryInput);
        Assertions.assertTrue(industryInput.isDisplayed(),
                "Industry input should be visible");
    }

    public void verifySaveChangesButtonIsVisibleAndEnabled() {
        waitUntilVisible(20, saveChangesButton);
        Assertions.assertTrue(saveChangesButton.isDisplayed(),
                "Save Changes button should be visible");
        Assertions.assertTrue(saveChangesButton.isEnabled(),
                "Save Changes button should be enabled");
    }

    public void enterBusinessName(String businessName) {
        clearAndSendKeys(businessNameInput, businessName);
        Assertions.assertEquals(businessName, businessNameInput.getAttribute("value"),
                "Business Name field should contain: " + businessName);
    }

    public void enterAnnualRevenue(String revenue) {
        clearAndSendKeys(annualRevenueInput, revenue);
        Assertions.assertEquals(revenue, annualRevenueInput.getAttribute("value"),
                "Annual Revenue field should contain: " + revenue);
    }

    public void enterIndustry(String industry) {
        clearAndSendKeys(industryInput, industry);
        Assertions.assertEquals(industry, industryInput.getAttribute("value"),
                "Industry field should contain: " + industry);
    }

    public void clickSaveChanges() {
        waitUntilClickable(20, saveChangesButton);
        Assertions.assertTrue(saveChangesButton.isEnabled(),
                "Save Changes button must be enabled before clicking");
        saveChangesButton.click();
    }

    public void verifyBusinessNameFieldContains(String expectedValue) {
        Assertions.assertEquals(expectedValue, businessNameInput.getAttribute("value"),
                "Business Name field should contain: " + expectedValue);
    }
}
