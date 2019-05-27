package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.configuration.SeleniumConfigurator;
import selenium.helper.WebDriverHelper;

import java.util.Map;

public class SettingsPage extends WebDriverHelper {
    private final Map<String, Object> settingsConfiguration;
    private final WebDriver driver;
    private By removeProjectLocator = By.id("unregister_project_btn");
    private By confirmRemoveProjectButtonLocator = By.cssSelector(".btnRemoveProject");
    private By settingsSideBarSelectedLocator = By.xpath("//*[@id='sidebar_settings' and contains(@class, 'selected')]");


    public SettingsPage(WebDriver driver, SeleniumConfigurator configurator) {
        super(driver, configurator);
        this.driver = driver;
        settingsConfiguration = configurator.getPage("settings");
    }

    public String getData(String key) {
        return (String) settingsConfiguration.get(key);
    }

    public void assertSettingsPage() {
        waitUntilElementToBePresent(settingsSideBarSelectedLocator);
        Assert.assertEquals("https://app.codacy.com/app/" + getData("username") + "/" + getData("dummyProjectName") + "/settings", driver.getCurrentUrl());
    }

    public void removeProject() {
        element(removeProjectLocator).click();
        waitUntilElementToBePresent(confirmRemoveProjectButtonLocator);
        element(confirmRemoveProjectButtonLocator).click();
    }
}
