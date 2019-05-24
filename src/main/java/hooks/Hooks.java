package hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.json.simple.parser.ParseException;
import selenium.SeleniumWrapper;
import selenium.exceptions.UnsupportedBrowserException;

import java.io.IOException;

public class Hooks {

    private SeleniumWrapper selenium;

    @Before
    public void setup(Scenario scenario) throws ParseException, UnsupportedBrowserException, IOException {

    }

    @After
    public void tearDown() throws ParseException, UnsupportedBrowserException, IOException {
        selenium = SeleniumWrapper.getInstance();
        if (!selenium.driverIsNull())
            selenium.disposeDriver();
    }
}
