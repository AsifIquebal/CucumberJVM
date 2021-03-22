package stepDef;

import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hook {

    public WebDriver driver;

    //@Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting: " + scenario.getName());
        System.out.println("====================================================================");
    }

    //@Before
    public void beforeScenario() {
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        //driver = new ChromeDriver();
        //driver = new DriverFactory().createDriver();
        System.out.println("this will run before the actual scenario");
    }

    //@After
    public void tearDown(Scenario scenario) {
        //driver.quit();
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
