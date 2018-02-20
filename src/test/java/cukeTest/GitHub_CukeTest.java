package cukeTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="CucumberJVM/src/test/java/features/GitHubTest.feature",
        glue = "stepDef",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class GitHub_CukeTest extends AbstractTestNGCucumberTests {
}