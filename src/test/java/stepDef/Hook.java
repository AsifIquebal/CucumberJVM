package stepDef;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.DriverFactory;

import java.io.IOException;

public class Hook {

    public WebDriver driver;

    @Before
    public void setUp(Scenario scenario){
        System.out.println("Starting: " + scenario.getName());
        System.out.println("====================================================================");
    }

    @Before
    public void beforeScenario() {
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        //driver = new ChromeDriver();
        //driver = new DriverFactory().createDriver();
        System.out.println("this will run before the actual scenario");
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("Ending: " + scenario.getName());
        System.out.println("====================================================================");
    }

    /*@After
    public void embedScreenshot(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {
            System.out.println("Scenarion Name: " + scenario.getName());
            System.out.println("Scenario Status: " + scenario.getStatus());
            try {
                scenario.write("Current Page URL is " + driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }*/
}
