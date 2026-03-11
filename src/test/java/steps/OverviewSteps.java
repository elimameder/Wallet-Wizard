package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import pages.ProfileOverviewPage;
import utils.BaseUI;
import utils.ConfigurationReader;
import utils.Driver;

public class OverviewSteps extends BaseUI {

    private final ProfileOverviewPage overviewPage = new ProfileOverviewPage();

    @Given("user navigates to Profile and Settings overview")
    public void userNavigatesToProfileAndSettingsOverview() {
        waitAndClick(overviewPage.pageHeading);
    }

    @Then("the page heading should display {string}")
    public void thePageHeadingShouldDisplay(String expectedHeading) {
        overviewPage.verifyPageHeading(expectedHeading);
    }

    @Then("Personal details card should be visible on overview")
    public void personalDetailsCardShouldBeVisibleOnOverview() {
        overviewPage.verifyCardIsVisible(overviewPage.personalDetailsCard, "Personal details");
    }

    @And("Business details card should be visible on overview")
    public void businessDetailsCardShouldBeVisibleOnOverview() {
        overviewPage.verifyCardIsVisible(overviewPage.businessDetailsCard, "Business details");
    }

    @And("Sign-in and security card should be visible on overview")
    public void signInAndSecurityCardShouldBeVisibleOnOverview() {
        overviewPage.verifyCardIsVisible(overviewPage.signInSecurityCard, "Sign-in & security");
    }

    @And("Account settings card should be visible on overview")
    public void accountSettingsCardShouldBeVisibleOnOverview() {
        overviewPage.verifyCardIsVisible(overviewPage.accountSettingsCard, "Account settings");
    }

    @And("Alerts card should be visible on overview")
    public void alertsCardShouldBeVisibleOnOverview() {
        overviewPage.verifyCardIsVisible(overviewPage.alertsCard, "Alerts");
    }

    @And("Payment preferences card should be visible on overview")
    public void paymentPreferencesCardShouldBeVisibleOnOverview() {
        overviewPage.verifyCardIsVisible(overviewPage.paymentPreferencesCard, "Payment preferences");
    }

    @Then("Personal details card should contain {string} link")
    public void personalDetailsCardShouldContainLink(String linkText) {
        waitUntilVisible(20, overviewPage.personalDetailsUpdateLink);
        Assertions.assertTrue(
                overviewPage.personalDetailsUpdateLink.isDisplayed(),
                "Personal details card should contain '" + linkText + "' link"
        );
    }

    @Then("Business details card should contain {string} link")
    public void businessDetailsCardShouldContainLink(String linkText) {
        waitUntilVisible(20, overviewPage.businessDetailsUpdateLink);
        Assertions.assertTrue(
                overviewPage.businessDetailsUpdateLink.isDisplayed(),
                "Business details card should contain '" + linkText + "' link"
        );
    }

    @Then("Sign-in and security card should contain {string} link")
    public void signInSecurityCardShouldContainLink(String linkText) {
        waitUntilVisible(20, overviewPage.signInSecurityProtectLink);
        Assertions.assertTrue(
                overviewPage.signInSecurityProtectLink.isDisplayed(),
                "Sign-in & security card should contain '" + linkText + "' link"
        );
    }

    @Then("Account settings card should contain {string} link")
    public void accountSettingsCardShouldContainLink(String linkText) {
        waitUntilVisible(20, overviewPage.accountSettingsCustomizeLink);
        Assertions.assertTrue(
                overviewPage.accountSettingsCustomizeLink.isDisplayed(),
                "Account settings card should contain '" + linkText + "' link"
        );
    }
}