package stepDef;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class AsusFeatureTest_StepDef extends BaseUtil{

    private BaseUtil baseUtil;

    public AsusFeatureTest_StepDef(BaseUtil baseUtil) {
        this.baseUtil = baseUtil;
    }

    /*WebDriver driver;
    @Before
    public void myDriver(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new ChromeDriver();
        //driver = new DriverFactory().createDriver();
    }*/


    @Given("^user is on selenium practice home page$")
    public void user_on_Selenium_Practice_Page() {
        baseUtil.driver.get("http://localhost:63343/Selenium/CucumberJVM/selPractice.htm?_ijt=47cm8ppk2lsnasqsjosc0pmqbb");
    }

    @Then("^user enters \"(.*?)\" on text box$")
    public void enter_text(String text) {
        baseUtil.driver.findElement(By.id("textinput")).sendKeys(text);
    }

    @Then("^user selects value from Select drop down$")
    public void selectValue() throws Exception {
        Select dd = new Select(baseUtil.driver.findElement(By.name("PASAM")));
        List<WebElement> ddl = dd.getOptions();
        for(int i=0 ; i<ddl.size() ; i++)
        {
            System.out.println("Dropdown: "+(i+1)+ " Option: "+ ddl.get(i).getText()+" Status: "+ddl.get(i).isSelected());
        }
        Thread.sleep(2000);
        dd.selectByIndex(1);
        Thread.sleep(2000);
        dd.selectByIndex(ddl.size()-1);

        baseUtil.driver.findElement(By.xpath("//select[@id='PASAM1']/option[@value='amlu' and .='Amlan']")).click();
    }

    @Then("click on Home")
    public void clickHome()throws Exception
    {
        WebElement homeLink = baseUtil.driver.findElement(By.xpath(".//a[contains(text(),'Home')]"));
        Actions act1 = new Actions(baseUtil.driver);
        Thread.sleep(3000);
        act1.moveToElement(homeLink).perform();
    }

    @Then("^user wants to know the OS$")
    public void getOS()
    {
        System.out.println("OS is: "+OSDetector());
    }

    @Then("^user enters \"(.*?)\" on username$")
    public void setUserName(String text)
    {
        baseUtil.driver.findElement(By.id("userId")).sendKeys(text);
    }

    @And("^user enters \"([0-9]*)\" on password$")
    public void setPasswordName(int value)
    {
        baseUtil.driver.findElement(By.id("passWd")).sendKeys(""+value);
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

    @Given("^user greeting$")
    public void user_greeting() {
        System.out.println("User Greeting step..");
    }

    @Then("^print member name \"([^\"]*)\"$")
    public void print_member_name(String arg1) {
        System.out.println("Member: " + arg1);
    }

    @Then("^print member location \"([^\"]*)\"$")
    public void print_member_location(String arg1) {
        System.out.println("Member Location: " + arg1);
    }

    @Given("^My name is \"([^\"]*)\"$")
    public void my_name_is(String arg1) {
        System.out.println("Name: " + arg1);
    }

    @Given("^I am (\\d+) years old$")
    public void i_am_years_old(int arg1) {
        System.out.println("Age: " + arg1);
    }

    @Given("^I have been to : \"(.+)\" for work$")
    public void i_have_been_to_Kolkata_Bhubaneswar_Pune_for_work(List<String> list) {
        System.out.println("Places I've been");
        list.forEach(elem-> System.out.println(elem));
    }


}
