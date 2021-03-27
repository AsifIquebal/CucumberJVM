package cukeTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/GitHub.feature",
        strict = true,
        glue = "stepDef",
        plugin = {"pretty", "html:target/cucumber-reports"}
        // use plugin instead, as format has been deprecated
        /*plugin = {"pretty", "json:FolderName/cucumber.json"}
        plugin= {"pretty", "junit:FolderNam0e/cucumber.xml"}
        plugin= {"pretty", "html:FolderName/cucumber.html"}
        plugin=
        {
                "pretty"
                , "json:FolderName/cucumber.json"
                , "junit:FolderNam0e/cucumber.xml"
                , "html:FolderName/cucumber.html"
        }*/
        //tags={"@mercury"}

)
public class GitHub_CukeTest {
}