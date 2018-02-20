package cukeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // facing issue with feature file location
        features="src/test/java/features/GitHubTest.feature",
        glue = "stepDef",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class GitHub_CukeTest {
}