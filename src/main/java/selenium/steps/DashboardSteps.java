package selenium.steps;

import cucumber.api.java.en.And;
import org.json.simple.parser.ParseException;
import selenium.SeleniumWrapper;
import selenium.exceptions.UnsupportedBrowserException;
import selenium.pages.DashboardPage;

import java.io.IOException;

public class DashboardSteps {

    private SeleniumWrapper seleniumWrapper = SeleniumWrapper.getInstance();
    private DashboardPage dashboardPage = new DashboardPage(seleniumWrapper.getDriver(), seleniumWrapper.getConfigurator());

    public DashboardSteps() throws ParseException, UnsupportedBrowserException, IOException {
    }

    @And("I go to settings")
    public void iGoToSettings() {
        dashboardPage.goToSettingsPage();
    }

    @And("I expected to be on Dashboard page")
    public void iExpectedToBeOnDashboardPage() {
        dashboardPage.assertDashboardPage();
    }
}
