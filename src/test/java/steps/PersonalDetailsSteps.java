package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.PersonalDetailsPage;
import pages.ProfileOverviewPage;
import utils.BaseUI;
import utils.Driver;

public class PersonalDetailsSteps extends BaseUI {

    private final ProfileOverviewPage overviewPage = new ProfileOverviewPage();
    private final PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();

    @When("user clicks Personal details in the sidebar")
    public void userClicksPersonalDetailsInTheSidebar() {
        overviewPage.clickPersonalDetailsMenuItem();
        personalDetailsPage.verifyPersonalInformationFormIsVisible();
    }

    @Then("Personal Information form should be visible")
    public void personalInformationFormShouldBeVisible() {
        personalDetailsPage.verifyPersonalInformationFormIsVisible();
    }

    @And("first name field should not be empty")
    public void firstNameFieldShouldNotBeEmpty() {
        personalDetailsPage.verifyFirstNameIsNotEmpty();
    }

    @And("last name field should not be empty")
    public void lastNameFieldShouldNotBeEmpty() {
        personalDetailsPage.verifyLastNameIsNotEmpty();
    }

    @Then("email field should be visible")
    public void emailFieldShouldBeVisible() {
        waitUntilVisible(20, personalDetailsPage.emailInput);
        Assertions.assertTrue(
                personalDetailsPage.emailInput.isDisplayed(),
                "Email field should be visible on Personal details page"
        );
    }

    @And("email field should contain {string}")
    public void emailFieldShouldContain(String expectedEmail) {
        personalDetailsPage.verifyEmailFieldValue(expectedEmail);
    }

    @And("user updates first name to {string}")
    public void userUpdatesFirstNameTo(String firstName) {
        personalDetailsPage.updateFirstName(firstName);
    }

    @And("user updates last name to {string}")
    public void userUpdatesLastNameTo(String lastName) {
        personalDetailsPage.updateLastName(lastName);
    }

    @And("user updates phone number to {string}")
    public void userUpdatesPhoneNumberTo(String phone) {
        personalDetailsPage.updatePhoneNumber(phone);
    }

    @And("user clicks the Save Changes button on personal details")
    public void userClicksSaveChangesButtonOnPersonalDetails() {
        personalDetailsPage.clickSaveChanges();
    }

    @Then("user should remain on the account page")
    public void userShouldRemainOnTheAccountPage() {
        Assertions.assertFalse(
                Driver.getDriver().getCurrentUrl().contains("login"),
                "User should NOT be redirected to login. Actual URL: " + Driver.getDriver().getCurrentUrl()
        );
    }
}
