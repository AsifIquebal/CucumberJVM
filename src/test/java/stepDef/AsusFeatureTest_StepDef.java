package stepDef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import singleTonBase.SingleTonBase;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AsusFeatureTest_StepDef {

    WebDriver driver;

    @Before
    public void steUp() {
        driver = SingleTonBase.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("Scenarion: " + scenario.getName() + ", Status: " + scenario.getStatus());

        SingleTonBase.closeBrowser();
    }

    @Given("^user is on selenium practice home page$")
    public void user_on_Selenium_Practice_Page() {
        String url = "http://localhost:63342/Selenium/CucumberJVM/automationPracticeParallel.htm?_ijt=mbu7uh6u6o03f4jqni77i48clr";
        driver.get(url);

    }

    @Then("^user enters \"(.*?)\" on text box$")
    public void enter_text(String text) {
        driver.findElement(By.id("textinput")).sendKeys(text);
    }

    @Then("^user selects value from Select drop down$")
    public void selectValue() throws Exception {
        Select dd = new Select(driver.findElement(By.name("PASAM")));
        List<WebElement> ddl = dd.getOptions();
        for (int i = 0; i < ddl.size(); i++) {
            System.out.println("Dropdown: " + (i + 1) + " Option: " + ddl.get(i).getText() + " Status: " + ddl.get(i).isSelected());
        }
        Thread.sleep(2000);
        dd.selectByIndex(1);
        Thread.sleep(2000);
        dd.selectByIndex(ddl.size() - 1);
        driver.findElement(By.xpath("//select[@id='PASAM1']/option[@value='amlu' and .='Amlan']")).click();
    }

    @Then("click on Home")
    public void clickHome() throws Exception {
        WebElement homeLink = driver.findElement(By.xpath(".//a[contains(text(),'Home')]"));
        Actions act1 = new Actions(driver);
        Thread.sleep(3000);
        act1.moveToElement(homeLink).perform();
    }

    @Then("^user wants to know the OS$")
    public void getOS() {
        System.out.println("OS is: " + OSDetector());
    }

    @Then("^user enters \"(.*?)\" on username$")
    public void setUserName(String text) {
        driver.findElement(By.id("userId")).sendKeys(text);
    }

    @And("^user enters \"([0-9]*)\" on password$")
    public void setPasswordName(int value) {
        driver.findElement(By.id("passWd")).sendKeys("" + value);
    }

    @Then("^we verify following data exists$")
    public void dataVerification(DataTable dataTable) {
        // raw(): Returns a List of List of String.
        //List<List<String>> data = dataTable.raw();
        //System.out.println(data.get(1).get(1));
        //System.out.println(data);
    }

    public static String OSDetector() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("nux") || os.contains("nix")) {
            return "Linux";
        } else if (os.contains("mac")) {
            return "Mac";
        } else if (os.contains("sunos")) {
            return "Solaris";
        } else {
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
        list.forEach(elem -> System.out.println(elem));
    }

    @Given("^the following datatable and convert to list$")
    public void the_following_datatable_and_convert_to_list(DataTable dataTable) {
        // raw(): Returns a List of List of String.
        /*List<List<String>> data = dataTable.raw();
        System.out.println(data.get(1).get(1));
        System.out.println(data);*/
    }

    @Given("^the following datatable and convert to map")
    public void the_following_datatable_and_convert_to_map(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.print("key is: " + entry.getKey() + " & Value is: ");
            System.out.println(entry.getValue());
        }
        System.out.println("==============================");
        map.forEach((a, b) -> System.out.println(a + ":" + b));
    }

    @Given("^the following datatable and convert to list automatically$")
    public void the_following_datatable_and_convert_to_list_automatically(List<List<String>> lists) {
        System.out.println("\n------------------------------------------------------------------------");
        System.out.println(lists.get(1).get(1));
        System.out.println(lists.get(2).get(1));
        System.out.println("------------------------------------------------------------------------");
    }


}
