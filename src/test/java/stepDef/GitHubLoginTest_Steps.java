package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.gitHubPages.LoginPage;

public class GitHubLoginTest_Steps {

    public WebDriver driver;
    LoginPage loginPage;


    @Given("^user opens git hub login page$")
    public void user_opens_GitHub_login_page() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://github.com/login");
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
