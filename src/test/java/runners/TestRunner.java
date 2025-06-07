package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/login.feature",
        glue = "stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"
        }
)
public class TestRunner {
}
