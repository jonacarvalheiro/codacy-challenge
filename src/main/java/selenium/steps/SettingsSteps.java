package selenium.steps;

import cucumber.api.java.en.And;
import org.json.simple.parser.ParseException;
import selenium.SeleniumWrapper;
import selenium.exceptions.UnsupportedBrowserException;
import selenium.pages.SettingsPage;

import java.io.IOException;

public class SettingsSteps {

    private SeleniumWrapper seleniumWrapper = SeleniumWrapper.getInstance();
    private SettingsPage settingsPage = new SettingsPage(seleniumWrapper.getDriver(), seleniumWrapper.getConfigurator());

    public SettingsSteps() throws ParseException, UnsupportedBrowserException, IOException {
    }


    @And("I remove the project")
    public void iRemoveTheProject() {
        settingsPage.removeProject();
    }


    @And("I expected to be on Settings page")
    public void iExpectedToBeOnSettingsPage() {
        settingsPage.assertSettingsPage();
    }
}
