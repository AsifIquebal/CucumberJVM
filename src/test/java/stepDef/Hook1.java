package stepDef;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook1 {

    public WebDriver driver;

    //@Before
    public void setUp() {
        System.out.println("Before HOOK");
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new ChromeDriver();
    }

    //@After
    public void tearDown() {
        System.out.println("After HOOK");
        driver.quit();
    }
}
