package pageObjects;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SharedClass {

    private static boolean startBrowser = false;

    private WebDriver driver;
    public String title = "";

    public SharedClass(){
        System.out.println("Shared Class called...............");
        init();
    }

    //@Before
    public void init(){
        System.out.println("Inside Before ...");
        if (!startBrowser) {
            System.out.println("Initializing Firefox Browser...");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            //System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            //driver = new FirefoxDriver();
            driver = new ChromeDriver();
            //To stop launching browser after every scenario, assign below variable with true value
            startBrowser = false;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    //@After
    public void cleanUp() {
        System.out.println("Quiting Browser...");
        driver.close();
        driver.quit();

    }
}
