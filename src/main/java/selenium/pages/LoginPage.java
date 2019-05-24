package selenium.pages;

import org.json.simple.parser.ParseException;
import selenium.SeleniumWrapper;
import selenium.exceptions.UnsupportedBrowserException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;

public class LoginPage extends SeleniumWrapper {


    private final Map<String, Object> pageConfiguration;

    public LoginPage() throws IOException, ParseException, UnsupportedBrowserException {
        pageConfiguration = (Map<String, Object>) getConfigurator().getPages().get("login");
    }

    public void navigateToLoginPage() throws UnsupportedBrowserException, MalformedURLException {
        String loginUrl = pageConfiguration.get("url").toString();
        getDriver().get(loginUrl);
    }
}
