package singleTonBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SingleTonBase {
    static WebDriver driver = null;
    private SingleTonBase() {}
    private static WebDriver createDriver(){
        if (driver == null) {
            System.out.println("Driver Instance is null. Creating driver.");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
            ChromeOptions options = new ChromeOptions();
            //options.setAcceptInsecureCerts(true);
            //options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
            //disable automation info bar
            options.addArguments("disable-infobars");
            // Start in Maximized mode
            options.addArguments("--start-maximized");
            /*Headless on Windows, Check periodically for any modification*/
            //options.addArguments("--headless","--disable-gpu");
            //Exception exception = new Exception()
            driver = new ChromeDriver(options);
        }
        else {
            System.out.println("Driver instance is not Null");
        }
        return driver;
    }
    public static WebDriver getDriver() {
        WebDriver driver = createDriver();
        return driver;
    }
    public static void closeBrowser() {
        System.out.println("Closing All browsers!");
        driver.quit();
        driver = null;
    }
}
