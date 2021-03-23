package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class Hook {

    @Before
    public void setUp(Scenario scenario) {
        System.out.println("Starting: " + scenario.getName());
        System.out.println("ID: " + scenario.getId());
        System.out.println("====================================================================");
        //driver = SingleTonBase.getDriver();
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        //driver = new ChromeDriver();
        //driver = new DriverFactory().createDriver();
        //System.out.println("this will run before the actual scenario");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Call me before each step");
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Ending: " + scenario.getName());
        System.out.println("Status: " + scenario.getStatus());
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
