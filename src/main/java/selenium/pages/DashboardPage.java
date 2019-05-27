package selenium.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.configuration.SeleniumConfigurator;
import selenium.helper.WebDriverHelper;

import java.util.Map;

public class DashboardPage extends WebDriverHelper {
    private final Map<String, Object> dashboardConfiguration;
    private final WebDriver driver;
    private By settingsSideBarLocator = By.id("sidebar_settings");
    private By dashboardSideBarSelectedLocator = By.xpath("//*[@id='sidebar_dashboard' and contains(@class, 'selected')]");

    public DashboardPage(WebDriver driver, SeleniumConfigurator configurator) {
        super(driver, configurator);
        this.driver = driver;
        dashboardConfiguration = configurator.getPage("dashboard");
    }


    public String getData(String key) {
        return (String) dashboardConfiguration.get(key);
    }

    public void goToSettingsPage() {
        element(settingsSideBarLocator).click();
    }

    public void assertDashboardPage() {
        waitUntilElementToBePresent(dashboardSideBarSelectedLocator);
        Assert.assertEquals("https://app.codacy.com/project/" + getData("username") + "/" + getData("dummyProjectName") + "/dashboard", driver.getCurrentUrl());

    }
}
