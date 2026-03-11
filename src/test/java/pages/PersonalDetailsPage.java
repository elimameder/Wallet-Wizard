package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseUI;
import utils.Driver;

public class PersonalDetailsPage extends BaseUI {

    private final WebDriver driver = Driver.getDriver();

    public PersonalDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//header[@class='bg-nav w-full']//a[text()='Profile & settings']")
    public WebElement pageHeading;

    @FindBy(xpath = "//span[text()='Personal details']/..")
    public WebElement personalInformationHeading;


    @FindBy(xpath = "//label[contains(text(),'First Name')]/following-sibling::input | //input[@name='firstName' or @id='firstName']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//label[contains(text(),'Last Name')]/following-sibling::input | //input[@name='lastName' or @id='lastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//label[contains(text(),'Email')]/following-sibling::input | //input[@name='email' or @id='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//label[contains(text(),'Phone')]/following-sibling::input | //input[@name='phone' or @type='tel']")
    public WebElement phoneInput;


    @FindBy(xpath = "//button[normalize-space()='Save Changes']")
    public WebElement saveChangesButton;



    public void verifyPersonalInformationFormIsVisible() {
        waitUntilVisible(20, personalInformationHeading);
        Assertions.assertTrue(
                personalInformationHeading.isDisplayed(),
                "Personal Information form heading should be visible"
        );
    }

    public void verifyFirstNameIsNotEmpty() {
        waitUntilVisible(20, firstNameInput);
        String value = firstNameInput.getAttribute("value");
        Assertions.assertNotNull(value, "First name value should not be null");
        Assertions.assertFalse(value.trim().isEmpty(),
                "First name field should not be empty");
    }

    public void verifyLastNameIsNotEmpty() {
        waitUntilVisible(20, lastNameInput);
        String value = lastNameInput.getAttribute("value");
        Assertions.assertNotNull(value, "Last name value should not be null");
        Assertions.assertFalse(value.trim().isEmpty(),
                "Last name field should not be empty");
    }

    public void verifyEmailFieldValue(String expectedEmail) {
        waitUntilVisible(20, emailInput);
        Assertions.assertTrue(emailInput.isDisplayed(),
                "Email field should be visible");
        Assertions.assertEquals(expectedEmail, emailInput.getAttribute("value"),
                "Email field should contain: " + expectedEmail);
    }

    public void updateFirstName(String firstName) {
        clearAndSendKeys(firstNameInput, firstName);
        Assertions.assertEquals(firstName, firstNameInput.getAttribute("value"),
                "First name field should contain updated value: " + firstName);
    }

    public void updateLastName(String lastName) {
        clearAndSendKeys(lastNameInput, lastName);
        Assertions.assertEquals(lastName, lastNameInput.getAttribute("value"),
                "Last name field should contain updated value: " + lastName);
    }

    public void updatePhoneNumber(String phone) {
        clearAndSendKeys(phoneInput, phone);
        Assertions.assertEquals(phone, phoneInput.getAttribute("value"),
                "Phone field should contain updated value: " + phone);
    }

    public void clickSaveChanges() {
        waitUntilClickable(20, saveChangesButton);
        Assertions.assertTrue(saveChangesButton.isEnabled(),
                "Save Changes button must be enabled before clicking");
        saveChangesButton.click();
    }
}
