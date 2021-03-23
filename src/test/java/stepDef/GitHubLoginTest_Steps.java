package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageObjects.base.BaseTest;
import pageObjects.gitHubPages.LoginPage;

public class GitHubLoginTest_Steps extends BaseTest {

    private LoginPage loginPage;

    @Before
    public void setUp() {
        System.out.println("Just Experimenting...");
    }

    @Given("^user opens git hub login page$")
    public void user_opens_GitHub_login_page() {
        getDriver().get("https://github.com/login");
    }

    @And("^user clicks on signin button$")
    public void user_clicks_on_signin_button() {
        loginPage.clickOnSignInButton();
    }

    @Then("user getting unsuccessful login message")
    public void userGettingUnsuccessfulLoginMessage() {
        Assert.assertTrue("No Message Displayed...", loginPage.unsuccessfulLoginMessage().equalsIgnoreCase("Incorrect username or password."));
    }

    @When("user enters login id and password")
    public void userEntersLoginIdAndPassword() {
        loginPage = new LoginPage(getDriver());
        loginPage.enterEmail("test@test.com");
        loginPage.enterPassword("test123");
    }

    @After
    public void tearDown() {
        System.out.println("Hooks also have After, me too...");
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}