package cukeTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "CucumberJVM/src/test/java/features/",
        glue = "stepDef",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = {"@asus,@autprac"}
)
public class TestSuite_CukeTest {
}