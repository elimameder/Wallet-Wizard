package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.PayAndTransferPage;
import utils.BaseUI;

public class PayAndTransferSteps extends BaseUI {

    PayAndTransferPage page = new PayAndTransferPage();


    // =================== GIVEN ===================
    @Given("user is on Pay and Transfer page")
    public void user_is_on_pay_and_transfer_page() {
        explicitWait(5).until(ExpectedConditions.visibilityOf(page.payAndTransfer));
        waitUntilVisible(20, page.payAndTransfer);
        page.payAndTransfer.click();

    }

    // =================== REQUEST MONEY STEPS ===================
    @When("user clicks on Send Money button")
    public void user_clicks_on_send_money_button() {
        waitUntilVisible(20, page.requestMoneyTab);
        page.requestMoneyTab.click();
    }

    @When("user enters recipient {string}")
    public void user_enters_recipient(String recipient) {
        waitUntilVisible(20, page.emailOrPhone);
        page.emailOrPhone.sendKeys(recipient);
    }

    @When("user enters amount {string}")
    public void user_enters_amount(String amount) {
        waitUntilVisible(20, page.amount);
        page.amount.sendKeys(amount);
    }

    @When("user enters memo {string}")
    public void user_enters_memo(String memo) {
        waitUntilVisible(20, page.Memo);
        page.Memo.sendKeys(memo);
    }

    @When("user clicks on Request via Zelle button")
    public void user_clicks_on_request_via_zelle_button() {
        waitUntilVisible(20, page.requestViaZelleBtn);
        page.requestViaZelleBtn.click();
    }

    @Then("user should see a requested message displayed")
    public void user_should_see_a_requested_message_displayed() {
        explicitWait(5).until(ExpectedConditions.visibilityOf(page.requestedMessage));
        Assertions.assertTrue(page.isRequestedMessageDisplayed());
    }

    // =================== SEND MONEY STEPS ===================
    @When("user clicks on Send Money tab")
    public void user_clicks_on_send_money_tab() {
        waitUntilVisible(20, page.sendMoneyTab);
        page.sendMoneyTab.click();
    }

    @When("user enters send recipient {string}")
    public void user_enters_send_recipient(String recipient){
        waitUntilVisible(20, page.emailOrPhone);
        page.emailOrPhone.sendKeys(recipient);
    }

    @When("user enters send amount {string}")
    public void user_enters_send_amount(String amount) {
        waitUntilVisible(20, page.totalAmount);
        page.totalAmount.sendKeys(amount);
    }

    @When("user enters send memo {string}")
    public void user_enters_send_memo(String memo) {
        waitUntilVisible(20, page.memoOptional);
        page.memoOptional.sendKeys(memo);
    }

    @When("user clicks on Send via Zelle button")
    public void user_clicks_on_send_via_zelle_button() {
        explicitWait(5).until(ExpectedConditions.visibilityOf(page.sendViaZelleBtn));
        page.sendViaZelleBtn.click();
    }

    @Then("user should see Fraud Warning message")
    public void user_should_see_fraud_warning_message() {
        page.verifyWarningMessageIsDisplay();
    }

    @When("user clicks on Confirm and Send button")
    public void user_clicks_on_confirm_and_send_button() {
        waitUntilVisible(20, page.confirmAndSend);
        page.confirmAndSend.click();
    }

    @Then("user should see Payment Sent message")
    public void user_should_see_payment_sent_message() {
        page.paymentSentMessage();
        explicitWait(5).until(ExpectedConditions.visibilityOf(page.doneButton));
        waitAndClick(page.doneButton);
    }

    // =================== SHARED STEPS ===================
    @Then("user should see a fill in all fields notification")
    public void user_should_see_a_fill_in_all_fields_notification() {
        Assertions.assertTrue(page.isFillAllFields());
    }

    @Then("user should see an error message for invalid recipient")
    public void user_should_see_an_error_message_for_invalid_recipient() {
        Assertions.assertTrue(page.isFillAllFields());
    }
}