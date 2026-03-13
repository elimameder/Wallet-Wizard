package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.SignInSecurityPage;
import utils.BaseUI;


public class SignInSecuritySteps extends BaseUI {
    SignInSecurityPage securityPage = new SignInSecurityPage();

    @When("user clicks {string}")
    public void user_clicks_profile_settings(String menu) {
        waitAndClick(securityPage.profileSettings);
        waitAndClick(securityPage.signInSecurity);
        waitAndClick(securityPage.changePassword);
    }
    @Then("{string} button should be visible")
    public void button_should_be_visible(String string) {
        explicitWait(5).until(ExpectedConditions.visibilityOf(securityPage.passwordResetMessage));
        Assertions.assertTrue(securityPage.changePassword.isDisplayed());
    }
    @When("user enables Two-Factor Authentication")
    public void user_enables_two_factor_authentication() {
        waitAndClick(securityPage.twoFactorToggle);
    }

    @Then("Two-Factor Authentication should be enabled")
    public void two_factor_authentication_should_be_enabled() {
        Assertions.assertFalse(securityPage.twoFactorToggle.isSelected());
    }

    @Then("password reset email confirmation message should be displayed")
    public void password_reset_email_sent_message() {
        Assertions.assertFalse(securityPage.passwordResetMessage.isDisplayed());
    }
}

