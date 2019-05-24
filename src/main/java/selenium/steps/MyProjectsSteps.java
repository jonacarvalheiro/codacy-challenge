package selenium.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.json.simple.parser.ParseException;
import selenium.SeleniumWrapper;
import selenium.exceptions.UnsupportedBrowserException;
import selenium.pages.MyProjectsPage;

import java.io.IOException;

public class MyProjectsSteps {
    private SeleniumWrapper seleniumWrapper = SeleniumWrapper.getInstance();
    private MyProjectsPage myProjectPage = new MyProjectsPage(seleniumWrapper.getDriver(), seleniumWrapper.getConfigurator());

    public MyProjectsSteps() throws ParseException, UnsupportedBrowserException, IOException {
    }

    @Then("I expected to My Projects page")
    public void iExpectedToBeLoggedIn() {
        myProjectPage.assertMyProjectPage();
    }

    @And("I click on add project button")
    public void iClickOnAddProjectButton() {
        myProjectPage.addProject();
    }

    @Then("The project should appear on My Projects page")
    public void theProjectShouldAppearOnMyProjectsPage() {
        myProjectPage.assertMyProjectPage();
        myProjectPage.assertDummyProjectWasAdded();
    }

    @And("I open the project")
    public void iOpenTheProject() {
        myProjectPage.openDummyProject();
    }

    @And("The project shouldn't appear on My Projects page")
    public void theProjectShouldnTAppearOnMyProjectsPage() {
        myProjectPage.assertMyProjectPage();
        myProjectPage.assertDummyProjectWasRemoved();
    }
}
