package hooks;

import cucumber.api.java.After;
import org.json.simple.parser.ParseException;
import selenium.SeleniumWrapper;

import java.io.IOException;

public class Hooks {


    @After
    public void tearDown() throws ParseException, IOException {
       SeleniumWrapper selenium = SeleniumWrapper.getInstance();
        if (!selenium.driverIsNull())
            selenium.disposeDriver();
    }
}
