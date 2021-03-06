package cukeTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/features/AsusFeature.feature",
        //features="CucumberJVM/src/test/java/features/AsusFeature.feature:41",
        glue = "stepDef",
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = false,
        //tags={"@dataTable,@demoX"} // OR example, Scenarios tagged with either of them
        //tags={"@dataTable","@demoY"}, // AND example, Scenarios tagged with ALL of them
        //tags={"@demo"},
        //tags={"@DT"},

        /*dryRun = true,*/
        strict = true
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

)
public class AsusFeature_CukeTest {
}