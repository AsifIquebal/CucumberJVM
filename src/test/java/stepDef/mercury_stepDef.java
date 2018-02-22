package stepDef;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.BaseClass;
import pageObjects.FlightFinderPage;
import pageObjects.LoginPage;

import java.util.List;

public class mercury_stepDef extends BaseClass {

    WebDriver driver;
    LoginPage loginPage;
    FlightFinderPage flightFinderPage;

    @Given("^User open firefox browser$")
    public void user_open_firefox_browser() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Then("^go to \"([^\"]*)\"$")
    public void go_to(String url) throws Throwable {
        driver.get(url);
        loginPage = new LoginPage(driver);
    }

    @Given("^user opens mercury tour application$")
    public void user_opens_mercury_tour_application() throws Throwable {
        Assert.assertEquals("Sign-on: Mercury Tours", driver.getTitle());
    }

    @Given("^user enters \"([^\"]*)\" on Username$")
    public void user_enters_on_Username(String arg1) throws Throwable {
        loginPage.typeUserName(arg1);
    }

    @Given("^user enters \"([^\"]*)\" on Password$")
    public void user_enters_on_Password(String arg1) throws Throwable {
        loginPage.typePassword(arg1);
    }

    @Given("^user clicks on Submit button$")
    public void user_clicks_on_Submit_button() throws Throwable {
        flightFinderPage = loginPage.clickOnLoginButton();
    }

    @Then("^user perform some action on Flight Finder Page$")
    public void user_perform_some_action_on_Flight_Finder_Page() {
        flightFinderPage
                .clickOneWayRadioButton()
                .selectPassengerCount("2")
                .selectFromPort("London")
                .selectToPort("Frankfurt")
                .selectServiceClassBussiness();
    }

    @Then("^user clicks on Continue button$")
    public void user_clicks_on_Continue_button() throws Throwable {
        flightFinderPage.clickOnContinueButton();
    }

    @Then("^user should be on Select a Flight page$")
    public void user_should_be_on_Select_a_Flight_page() throws Throwable {
        System.out.println(driver.getTitle());
        Thread.sleep(2000);
        Assert.assertEquals("Select a Flight: Mercury Tours", driver.getTitle());
    }

    @Then("^user closes the browser$")
    public void user_closes_the_browser() throws Throwable {
        driver.quit();
    }

    @Given("^user greeting$")
    public void user_greeting() throws Throwable {
        System.out.println("Scenario Outline Demo");
    }

    @Then("^print member name \"([^\"]*)\"$")
    public void print_member_name(String arg1) throws Throwable {
        System.out.println("Member Name: " + arg1);
    }

    @Then("^print member location \"([^\"]*)\"$")
    public void print_member_location(String arg1) throws Throwable {
        System.out.println("Member Location: " + arg1);
    }

    @Given("^user get the OS printed$")
    public void user_get_the_OS_printed() throws Throwable {
        System.out.println(System.getProperty("os.name"));
    }

    @Given("^My name is \"([^\"]*)\"$")
    public void my_name_is(String arg1) throws Throwable {
        System.out.println("Name: " + arg1);
    }

    @Given("^I am (\\d+) years old$")
    public void i_am_years_old(int arg1) throws Throwable {
        System.out.println("Year: " + arg1);
    }

    @Given("^I have been to \"(.+)\" for work$")
    public void i_have_been_to_for_work(List<String> list) throws Throwable {
        for (int i=0; i<list.size(); i++){
            System.out.println("Place " + (i+1) + ": " + list.get(i));
        }
    }


    @Then("^print the following$")
    public void print_the_following(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        List<List<String>> data = arg1.raw();
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                System.out.println(data.get(i).get(j));
            }
        }
    }


}
