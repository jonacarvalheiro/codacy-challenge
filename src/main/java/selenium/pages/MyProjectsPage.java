package selenium.pages;

import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.configuration.SeleniumConfigurator;
import selenium.helper.WebDriverHelper;

import java.util.Map;

public class MyProjectsPage extends WebDriverHelper {
    private final Map<String, Object> myProjectConfiguration;
    private final WebDriver driver;
    private By dummyProjectDivLocator;


    public MyProjectsPage(WebDriver driver, SeleniumConfigurator configurator) {
        super(driver, configurator);
        this.driver = driver;
        myProjectConfiguration = configurator.getPage("myProject");
    }

    private By projectSearchInputLocator = By.id("project-search");
    private By addProjectButtonLocator = By.id("add_project_btn");


    public void assertMyProjectPage() {
        waitUntilElementToBePresent(projectSearchInputLocator);
        try {
            Assert.assertEquals("https://app.codacy.com/projects", driver.getCurrentUrl());
        } catch (ComparisonFailure e) {
            Assert.assertEquals("https://app.codacy.com/projects#", driver.getCurrentUrl());
        }

    }


    public void addProject() {
        element(addProjectButtonLocator).click();
    }

    private String getData(String key) {
        return (String) myProjectConfiguration.get(key);
    }

    public void assertDummyProjectWasAdded() {
        dummyProjectDivLocator = By.xpath("//*[@data-name='" + getData("dummyProjectName") + "']");
        element(dummyProjectDivLocator);
    }

    public void openDummyProject() {
        By dummyProjectSelectableDivLocator = By.xpath("//*[@data-name='" + getData("dummyProjectName") + "']//*[contains(@class, 'project-name') ]");
        element(dummyProjectSelectableDivLocator).click();
    }

    public void assertDummyProjectWasRemoved() {
        Assert.assertEquals(0, elements(dummyProjectDivLocator).size());
    }
}
