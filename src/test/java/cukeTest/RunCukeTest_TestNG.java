package cukeTest; /**
 * Created by user on 14-Oct-16.
 */
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features="src/test/java/features/GitHubTest.feature",
        features="src/test/java/features/AsusFeature.feature"
        //format={"pretty","html:target/Reports"}
)
public class RunCukeTest_TestNG extends AbstractTestNGCucumberTests {
}