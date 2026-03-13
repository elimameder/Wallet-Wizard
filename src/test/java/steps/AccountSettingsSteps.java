package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.AccountSettingsPage;
import utils.BaseUI;

public class AccountSettingsSteps extends BaseUI {

        AccountSettingsPage accountSettingsPage = new AccountSettingsPage();

        @When("user clicks Account settings")
        public void user_clicks_account_settings() {
            waitAndClick(accountSettingsPage.accountSettings);
        }
        @When("user enables Go Paperless")
        public void user_enables_go_paperless() {
            waitAndClick(accountSettingsPage.goPaperlessToggle);
        }
        @Then("Go Paperless should be enabled")
        public void go_paperless_should_be_enabled() {
            explicitWait(5).until(ExpectedConditions.visibilityOf(accountSettingsPage.goPaperlessToggle));
            Assertions.assertTrue(accountSettingsPage.goPaperlessToggle.isEnabled());
        }
        @When("user enables Hide Account")
        public void user_enables_hide_account() {
            waitAndClick(accountSettingsPage.hideAccountToggle);
        }
        @Then("account should be hidden from dashboard")
        public void account_should_be_hidden() {
            explicitWait(5).until(ExpectedConditions.visibilityOf(accountSettingsPage.hideAccountToggle));
            Assertions.assertTrue(accountSettingsPage.hideAccountToggle.isEnabled());
        }
    }

