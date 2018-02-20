package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Created by user on 16-Nov-16.
 */
public class BaseClass {
    //ThreadLocal will keep local copy of driver
    //public static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();
    public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

    //@BeforeTest
    //Parameter will get browser from testng.xml on which browser test to run
    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) throws MalformedURLException {
        RemoteWebDriver driver = null;

        if(browser.equals("chrome")){
            /*DesiredCapabilities capability = new DesiredCapabilities().chrome();
            capability.setBrowserName("chrome");
            capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);*/
            System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browser.equals("firefox")){
            /*DesiredCapabilities capability = new DesiredCapabilities().firefox();
            capability.setBrowserName("firefox");
            capability.setPlatform(Platform.WINDOWS);
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);*/
            System.setProperty("webdriver.gecko.driver","C:/Selenium/drivers/geckodriver-v0.11.1-win64/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("ie"))
        {
            System.setProperty("webdriver.ie.driver","C:\\Selenium\\drivers\\IEDriverServer_Win32_2.53.1\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        //setting webdriver
        setWebDriver(driver);
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    public WebDriver getDriver() {
        System.out.println("dr.get() call: "+dr.get());

        return dr.get();
    }
    /*public void setWebDriver(RemoteWebDriver driver) {
        dr.set(driver);
    }*/

    // modified
    public void setWebDriver(WebDriver driver) {
        dr.set(driver);
    }
    /*@AfterClass
    public void afterClass(){
        getDriver().quit();
        dr.set(null);
    }*/
}
