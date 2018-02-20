package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AsusFeatureTest_StepDef {
    WebDriver driver = null;

    @Given("^user is on selenium practice home page$")
    public void user_on_Selenium_Practice_Page() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        /*System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();*/
        //driver.get("http://localhost:63342/cucumberJVM/selPractice.htm");
        driver.get("http://localhost:63342/Selenium/CucumberJVM/selPractice.htm?_ijt=n5lhlrghgnibi1jjie0q437i8l");
    }

    @Then("^user enters \"(.*?)\" on text box$")
    public void enter_text(String text) {
        driver.findElement(By.id("textinput")).sendKeys(text);
    }

    @Then("^user selects value from Select drop down$")
    public void selectValue() throws Exception {
        Select dd = new Select(driver.findElement(By.name("PASAM")));
        List<WebElement> ddl = dd.getOptions();
        for(int i=0 ; i<ddl.size() ; i++)
        {
            System.out.println("Dropdown: "+(i+1)+ " Option: "+ ddl.get(i).getText()+" Status: "+ddl.get(i).isSelected());
        }
        Thread.sleep(2000);
        dd.selectByIndex(1);
        Thread.sleep(2000);
        dd.selectByIndex(ddl.size()-1);

        driver.findElement(By.xpath("//select[@id='PASAM1']/option[@value='amlu' and .='Amlan']")).click();
    }

    /*@Then("click on Home")
    public void clickHome()throws Exception
    {
        WebElement homeLink = driver.findElement(By.xpath(".//a[contains(text(),'Home')]"));
        Actions act1 = new Actions(driver);
        Thread.sleep(3000);
        act1.moveToElement(homeLink).perform();
    }*/

    @Then("^user wants to know the OS$")
    public void getOS()
    {
        System.out.println("OS is: "+OSDetector());
    }

    @Then("^user enters \"(.*?)\" on username$")
    public void setUserName(String text)
    {
        driver.findElement(By.id("userId")).sendKeys(text);
    }

    @And("^user enters \"([0-9]*)\" on password$")
    public void setPasswordName(int value)
    {
        driver.findElement(By.id("passWd")).sendKeys(""+value);
    }

    @Then("^we verify following data exists$")
    public void dataVerification(DataTable dataDetails)
    {
        List<List<String>> data = dataDetails.raw();
        System.out.println(data.get(1).get(1));
        System.out.println(data);
    }

    public static String OSDetector ()
    {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win"))
        {
            return "Windows";
        }
        else if (os.contains("nux") || os.contains("nix"))
        {
            return "Linux";
        }
        else if (os.contains("mac"))
        {
            return "Mac";
        }
        else if (os.contains("sunos"))
        {
            return "Solaris";
        }
        else
        {
            return "Other";
        }
    }

    @After
    public void cleanUp()
    {
        driver.quit();
    }




}
