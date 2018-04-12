package stepDef.picoContainerDemo;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StepDef1 /*extends BaseUtil*/{

    private BaseUtil base;

    public StepDef1(BaseUtil base) {
        this.base = base;
    }

    //WebDriver driver;
    /*@Before
    public void myDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "C:/Users/user/Desktop/chromedriver_win32_2.37/chromedriver.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        //driver = new FirefoxDriver();
        //driver = new DriverFactory().createDriver();
    }
    @After
    public void tearDown(){
        driver.quit();
    }*/

    @Given("^run stepDefinition file 1$")
    public void user_on_Selenium_Practice_Page() {
        String url = "http://localhost:63342/Selenium/CucumberJVM/selPractice.htm?_ijt=mbu7uh6u6o03f4jqni77i48clr";
        //driver.get(url);
        base.driver.get(url);

    }






}
