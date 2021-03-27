package pageObjects.gitHubPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MyWrapper;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.xpath("//input[@name='login']");
    public LoginPage enterEmail(String string){
        MyWrapper.sendKeys(driver, email,string);
        return this;
    }

    private By passWord = By.xpath("//input[@name='password']");
    public LoginPage enterPassword(String string){
        MyWrapper.sendKeys(driver,passWord,string);
        return this;
    }

    private By signInButton = By.xpath("//input[@name='commit']");
    public LoginPage clickOnSignInButton(){
        MyWrapper.click(driver, signInButton);
        return this;
    }

    private By unsuccessfulLoginMessageContainer = By.xpath("//div[@id='js-flash-container']");
    public String unsuccessfulLoginMessage(){
        return driver.findElement(unsuccessfulLoginMessageContainer).getText();
    }

}
