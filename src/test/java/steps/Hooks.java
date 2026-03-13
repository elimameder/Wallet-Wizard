package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.LoginPage;
import utils.ConfigurationReader;
import utils.Driver;

public class Hooks {

    @Before ("@loggedIn")
    public void signIn(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.loginAndStay();
    }

    @Before ("@logIn")
    public void logIn() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.loginAndStay();
    }

    @After ("@logOut")
    public void logOut() {
        LoginPage loginPage = new LoginPage();
        loginPage.logOut();
        Driver.quitDriver();
    }
}
