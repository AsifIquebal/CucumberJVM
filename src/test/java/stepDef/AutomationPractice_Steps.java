package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageObjects.SharedClass;
import pageObjects.automationPractice.HomePage;
import pageObjects.automationPractice.LoginPage;
import pageObjects.automationPractice.MyAccount;
import pageObjects.automationPractice.base.BaseClass;

public class AutomationPractice_Steps extends BaseClass{

    //SharedClass sharedClass;
    LoginPage loginPage;
    MyAccount myAccount;
    HomePage homePage;

    @Given("^user navigate to the application URL$")
    public void user_navigate_to_the_application_URL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        homePage = LaunchApplication();
    }

    @Given("^user opens Login Page$")
    public void user_opens_Login_Page(){
        loginPage = clickOnSignInLink();
        //sharedClass.getDriver();
        Assert.assertEquals(getPageTitle(),"Login - My Store");
    }

    @Given("^user enters \"([^\"]*)\" on Username$")
    public void user_enters_on_Username(String arg1) throws Throwable {
        loginPage.enterEmail(arg1);
    }

    @Given("^user enters \"([^\"]*)\" on Password$")
    public void user_enters_on_Password(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        loginPage.enterPassword(arg1);
    }

    @Given("^user clicks on SignIn button$")
    public void user_clicks_on_SignIn_button(){
        // Write code here that turns the phrase above into concrete actions
        myAccount = loginPage.clickOnSignInButton();
    }

    @Then("^user clicks on My Address section$")
    public void user_clicks_on_My_Address_section(){
        // Write code here that turns the phrase above into concrete actions
        myAccount.ClickOnMyAddress();
    }

    @Then("^user create a new address$")
    public void user_create_a_new_address() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user delete the address$")
    public void user_delete_the_address() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user log out of the application$")
    public void user_log_out_of_the_application() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("^user is on home page$")
    public void user_is_on_home_page() {
        homePage = LaunchApplication();
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    /*@When("^user search for Jama$")
    public void user_search_for_Jama() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }*/

    @When("^user search for(.*)$")
    public void user_search_for_(String string) throws Throwable {
        homePage
                .enterSearchQuery(string)
                .clickOnSearchInButton();
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

    @Then("^user get (\\d+) product as result$")
    public void user_get_product_as_result(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
    }

}
