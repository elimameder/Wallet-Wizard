package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BaseUI;
import utils.Driver;

public class PayAndTransferPage extends BaseUI {
    WebDriver driver = Driver.getDriver();

    public PayAndTransferPage() {
        PageFactory.initElements(driver, this);
    }


    // =================== NAVIGATION ===================
    @FindBy(xpath = "//a[normalize-space()='Pay & transfer']")
    public WebElement payAndTransfer;

    // =================== REQUEST MONEY ===================
    @FindBy(xpath = "//button[@type='button'][2]")
    public WebElement requestMoneyTab;

    @FindBy(xpath = "//input[@placeholder='name@email.com or (555) 123-4567']")
    public WebElement emailOrPhone;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement amount;

    @FindBy(xpath = "//input[@placeholder=\"What's it for?\"]")
    public WebElement Memo;

    @FindBy(xpath = "//button[normalize-space()='Request via Zelle']")
    public WebElement requestViaZelleBtn;

    @FindBy(xpath = "//*[contains(text(),'requested from')]")
    public WebElement requestedMessage;

    // =================== SEND MONEY ===================
   // @FindBy(xpath = "//button[@aria-controls='radix-:rb:-content-send']")
   // public WebElement sendMoneyTab;

    @FindBy(xpath = "//button[@role='tab' and contains(.,'Send Money')]")
    public WebElement sendMoneyTab;

    @FindBy(xpath = "//div[@id='radix-:rb:-content-send']//input[@placeholder='name@email.com or (555) 123-4567']")
    public WebElement eAndPhone;

    @FindBy(css = "input[type='number']")
    public WebElement totalAmount;

    @FindBy(xpath = "//div[@id='radix-:rb:-content-send']//input[contains(@placeholder,'it for')]")
    public WebElement memoOptional;

    @FindBy(xpath = "//button[contains(text(),'Send via Zelle')]")
    public WebElement sendViaZelleBtn;

    // =================== SHARED ===================
    @FindBy(xpath = "//button[normalize-space()='Confirm & Send']")
    public WebElement confirmAndSend;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//p[normalize-space()='Fraud Warning']")
    public WebElement warningMessage;

    @FindBy(xpath = "//*[contains(text(),'Please fill in all fields')]")
    public WebElement fillInEmptyFields;

    @FindBy(xpath = "//h3[normalize-space()='Payment Sent!']")
    public WebElement paymentSent;

    // =================== METHODS ===================
    public void verifyWarningMessageIsDisplay() {
        waitUntilVisible(20, warningMessage);
        Assertions.assertTrue(warningMessage.isDisplayed(), "Fraud Warning");
    }

    public void verifyEmptyField() {
        waitUntilVisible(20, fillInEmptyFields);
        Assertions.assertTrue(fillInEmptyFields.isDisplayed());
        Assertions.assertEquals("Please fill in all fields", fillInEmptyFields.getText());
    }

    public void paymentSentMessage() {
        waitUntilVisible(20, paymentSent);
        Assertions.assertTrue(paymentSent.isDisplayed());
        Assertions.assertEquals("Payment Sent!", paymentSent.getText());
    }

    public boolean isRequestedMessageDisplayed() {
        waitUntilVisible(20, requestedMessage);
        return requestedMessage.getText().contains("requested from");
    }

    public boolean isFillAllFields() {
        waitUntilVisible(20, fillInEmptyFields);
        return fillInEmptyFields.getText().contains("Please fill in all fields");
    }
}


