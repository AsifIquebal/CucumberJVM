package stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.automationPractice.LoginPage;

public class AutomationPractice_Steps {

    LoginPage loginPage;

    @Given("^user opens Login Page$")
    public void user_opens_Login_Page(){

        loginPage = clickOnSignInLink();
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("^user clicks on SignIn button$")
    public void user_clicks_on_SignIn_button(){
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^user clicks on My Address section$")
    public void user_clicks_on_My_Address_section(){
        // Write code here that turns the phrase above into concrete actions

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
