package selenium;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/java/selenium/features", "src/main/java/api/features"},
        glue = {"selenium.steps", "api.steps", "hooks"}
)
public class Tests {

}
