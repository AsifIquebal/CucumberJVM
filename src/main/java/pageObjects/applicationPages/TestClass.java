package pageObjects.applicationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestClass {

    @Test
    public void homePageTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://automationpractice.com");
        HomePage homePage = new HomePage(driver);
        homePage
                .enterSearchQuery("Sari")
                .clickOnSearchInButton();
    }
}
