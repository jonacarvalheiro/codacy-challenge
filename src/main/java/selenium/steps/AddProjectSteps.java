package selenium.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.json.simple.parser.ParseException;
import selenium.SeleniumWrapper;
import selenium.exceptions.UnsupportedBrowserException;
import selenium.pages.AddProjectPage;
import selenium.pages.MyProjectsPage;

import java.io.IOException;
import java.net.MalformedURLException;

public class AddProjectSteps {

    private SeleniumWrapper seleniumWrapper = SeleniumWrapper.getInstance();
    private AddProjectPage addProjectPage = new AddProjectPage(seleniumWrapper.getDriver(), seleniumWrapper.getConfigurator());

    public AddProjectSteps() throws ParseException, UnsupportedBrowserException, IOException {
    }

    @When("I select project")
    public void iSelectProject() {
        addProjectPage.selectDummyProject();
        addProjectPage.goToMyProjectsPage();
    }

}
