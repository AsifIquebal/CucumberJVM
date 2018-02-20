package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 13-May-17.
 */
public class DriverFactory {
    public static WebDriver driver = null;

    public WebDriver createDriver(){
        System.setProperty("webdriver.gecko.driver", "C:/Selenium/drivers/geckodriver-v0.16.1-win64/geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }
}
