package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static utils.waitClass.waitExplicit;

/**
 * Created by user on 18-Apr-17.
 */
public class FlightFinderPage {

    WebDriver driver;

    public FlightFinderPage(WebDriver driver){
        this.driver = driver;
    }

    By oneWayRadioButton = By.xpath("//input[@value='oneway']");
    By passengers = By.xpath("//select[@name='passCount']");
    By fromPort = By.xpath("//select[@name='fromPort']");
    By toPort = By.xpath("//select[@name='toPort']");
    By businessClassRadioButton =By.xpath("//input[@value='Business']");
    By continueButton =By.xpath("//input[contains(@name,'findFlights')]");

    public FlightFinderPage clickOneWayRadioButton()
    {
        waitExplicit(driver, oneWayRadioButton);
        driver.findElement(oneWayRadioButton).click(); return this;
    }

    public FlightFinderPage selectPassengerCount(String value)
    {
        //driver.findElement(passengers).click();
        Select select = new Select(driver.findElement(passengers));
        select.selectByValue(value);
        return this;
    }



    public FlightFinderPage selectFromPort(String value)
    {
        //driver.findElement(fromPort).click();
        Select select = new Select(driver.findElement(fromPort));
        select.selectByValue(value);
        return this;
    }

    public FlightFinderPage selectToPort(String value){
        Select select = new Select(driver.findElement(toPort));
        select.selectByValue(value);
        return this;
    }

    public FlightFinderPage selectServiceClassBussiness(){
        waitExplicit(driver,businessClassRadioButton);
        driver.findElement(businessClassRadioButton).click();
        return this;
    }

    public FlightFinderPage clickOnContinueButton(){
        driver.findElement(continueButton).click();
        return this;
    }
}
