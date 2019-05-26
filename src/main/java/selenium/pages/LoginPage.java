package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import selenium.configuration.SeleniumConfigurator;
import selenium.helper.WebDriverHelper;

import java.util.Map;

public class LoginPage extends WebDriverHelper {


    private final Map<String, Object> pageConfiguration;
    private final WebDriver driver;
    private By loginButtonLocator = By.id("qa-login-link");
    private By loginWithGoogleAccountButtonLocator = By.id("qa-login-google");
    private By emailInputLocator = By.xpath("//*[@type='email']");
    private By nextEmailButtonLocator = By.id("identifierNext");
    private By pwdInputLocator = By.xpath("//*[@type='password']");
    private By nextPwdButtonLocator = By.id("passwordNext");

    public LoginPage(WebDriver driver, SeleniumConfigurator configurator) {
        super(driver, configurator);
        pageConfiguration = configurator.getPage("login");
        this.driver=driver;
        
    }


    public void navigateToLoginPage() {
        String loginUrl = pageConfiguration.get("url").toString();
        driver.get(loginUrl);
    }

    public void loginWithGoogleAccount() {
       element(loginButtonLocator).click();
       element(loginWithGoogleAccountButtonLocator).click();
       element(emailInputLocator).sendKeys(getData("username"));
       element(nextEmailButtonLocator).click();
       element(pwdInputLocator).sendKeys(getData("password"));
       element(nextPwdButtonLocator).click();

    }

    public String getData(String key) {
        return pageConfiguration.get(key).toString();
    }


}
