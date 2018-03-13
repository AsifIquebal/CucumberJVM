package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 13-May-17.
 */
public class DriverFactory {
    public WebDriver driver = null;

    public WebDriver createDriver(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }
}
