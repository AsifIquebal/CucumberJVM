package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pageObjects.SharedClass;
import pageObjects.automationPractice.LoginPage;
import pageObjects.automationPractice.MyAccount;
import pageObjects.automationPractice.base.BaseClass;

public class AutomationPractice_Steps extends BaseClass{

    //SharedClass sharedClass;
    LoginPage loginPage;
    MyAccount myAccount;

    @Given("^user navigate to the application URL$")
    public void user_navigate_to_the_application_URL() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        LaunchApplication();
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

}
