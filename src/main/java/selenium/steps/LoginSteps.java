package selenium.steps;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.json.simple.parser.ParseException;
import selenium.SeleniumWrapper;
import selenium.exceptions.UnsupportedBrowserException;
import selenium.pages.LoginPage;

import java.io.IOException;


public class LoginSteps {

    private SeleniumWrapper seleniumWrapper = SeleniumWrapper.getInstance();
    private LoginPage loginPage = new LoginPage(seleniumWrapper.getDriver(),seleniumWrapper.getConfigurator());

    public LoginSteps() throws ParseException, UnsupportedBrowserException, IOException {
    }

    @When("I login with google account")
    public void iLoginWithGoogleAccount() {

        loginPage.loginWithGoogleAccount();
    }

    @Given("I navigate to Codacy Page")
    public void iNavigateToCodacyPage() {
        loginPage.navigateToLoginPage();
    }


}
