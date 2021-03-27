package cukeTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "CucumberJVM/src/test/java/features/",
        glue = "stepDef",
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = {"@tag1,@tag1"}
        /*dryRun = true,
        strict = true*/
)
public class RunSampleFeatures {
}



