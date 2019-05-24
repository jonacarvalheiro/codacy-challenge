package selenium.steps;


import cucumber.api.java.en.Given;
import org.json.simple.parser.ParseException;
import selenium.exceptions.UnsupportedBrowserException;
import selenium.pages.LoginPage;

import java.io.IOException;
import java.net.MalformedURLException;


public class LoginSteps {


    private LoginPage loginPage = new LoginPage();

    public LoginSteps() throws ParseException, UnsupportedBrowserException, IOException {
    }

    @Given("I login with google account")
    public void iLoginWithGoogleAccount() throws UnsupportedBrowserException, MalformedURLException {
        loginPage.navigateToLoginPage();
    }
}
