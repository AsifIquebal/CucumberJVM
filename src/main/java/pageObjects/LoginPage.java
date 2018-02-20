package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.waitClass.waitExplicit;

/**
 * Created by user on 18-Apr-17.
 */
public class LoginPage {

    public WebDriver driver;

    By userName = By.xpath("//input[@name='userName']");
    By password = By.xpath("//input[@name='password']");
    By loginButton = By.xpath("//input[@name='login']");
    By loginButtonFalse = By.xpath("//input[@name='login123']");
    // Explicit Wait


    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPage typeUserName(String uid)
    {
        waitExplicit(driver, userName);
        driver.findElement(userName).sendKeys(uid); return this;
    }

    public LoginPage typePassword(String pass)
    {
        waitExplicit(driver, password);
        driver.findElement(password).sendKeys(pass); return this;
    }

    public FlightFinderPage clickOnLoginButton()
    {
        waitExplicit(driver, loginButton);
        driver.findElement(loginButton).click(); return new FlightFinderPage(driver);
    }
}
