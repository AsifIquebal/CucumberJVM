package stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GitHubLoginTest_StepDef {

    WebDriver driver = null;

    @Given("^user opens git hub login page$")
    public void user_opens_GitHub_login_page() {
        String driverPath = "C:/Selenium/drivers/geckodriver-v0.11.1-win64/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get("https://github.com/login");
    }

    @Then("^user enters login id$")
    public void user_enters_login_id() {
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("test@test.com");
    }

    @Then("^user enters password$")
    public void user_enters_password() {
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("test123");
    }

    @And("^user clicks on signin button$")
    public void user_clicks_on_signin_button() {
        driver.findElement(By.xpath("//input[@name='commit']")).click();
    }

    @And("^close the browser$")
    public void close_the_browser() {
        driver.quit();
    }
}
