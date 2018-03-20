package stepDef;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook1 extends BaseUtil{

    private BaseUtil baseUtil;

    public Hook1(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        baseUtil.driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        baseUtil.driver.quit();
    }
}
