package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.gitHubPages.LoginPage;


public class GitHubLoginTest_Steps {

    public WebDriver driver;
    LoginPage loginPage;


    @Given("^user opens git hub login page$")
    public void user_opens_GitHub_login_page() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://github.com/login");
        //launchApplication();
    }

    @Then("^user enters login id$")
    public void user_enters_login_id() {
        loginPage = new LoginPage(driver);
        loginPage.enterEmail("test@test.com");
    }

    @Then("^user enters password$")
    public void user_enters_password() {
        loginPage.enterPassword("test123");
    }

    @And("^user clicks on signin button$")
    public void user_clicks_on_signin_button() {
        loginPage.clickOnSignInButton();
        driver.quit();
    }

}
