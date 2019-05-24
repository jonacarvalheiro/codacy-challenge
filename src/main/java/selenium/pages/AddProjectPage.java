package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.configuration.SeleniumConfigurator;
import selenium.helper.WebDriverHelper;

import java.util.Map;

public class AddProjectPage extends WebDriverHelper {
    private final Map<String, Object> addProjectConfiguration;
    private By myProjectsAncorLocator = By.xpath("//*[@id='dropdown-organization-name']/a");

    public AddProjectPage(WebDriver driver, SeleniumConfigurator configurator) {
        super(driver, configurator);
        addProjectConfiguration = configurator.getPage("addProject");
    }


    public void selectDummyProject() {
        By projectFromConfigurationDivLocator = By.xpath("//*[@data-project='" + getData("testProject") + "']");
        By dummyProjectStatusLocator = By.xpath("//*[@data-project='" + getData("testProject") + "']//div[@class='checkbox--analysing js-project-analysing']//span");
        element(projectFromConfigurationDivLocator).click();
        waitUntilTextToBePresentInElement(dummyProjectStatusLocator, "Reviewing...");
    }

    public void goToMyProjectsPage() {
        element(myProjectsAncorLocator).click();
    }

    public String getData(String key) {
        return (String) addProjectConfiguration.get(key);
    }

}
