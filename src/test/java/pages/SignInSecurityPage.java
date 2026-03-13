package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class SignInSecurityPage {

    public SignInSecurityPage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(xpath = "//a[text()='Profile & settings']")
        public WebElement profileSettings;

        @FindBy(xpath = "//span[text()='Sign-in & security']")
        public WebElement signInSecurity;

        @FindBy (xpath = "//p[contains(text(),'Two-Factor')]/../..//button")
        public WebElement twoFactorToggle;

        @FindBy(xpath = "//button[contains(text(),'Password')]")
        public WebElement changePassword;

        @FindBy (xpath = "//div[text()='Password reset email sent!']")
        public WebElement passwordResetMessage;

    }

