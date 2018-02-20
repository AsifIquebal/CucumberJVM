package utils;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 30-Jan-17.
 */
public class waitClass {
    public static WebElement waitUntilElementExists(WebDriver driver, final By by) {

        FluentWait<WebDriver> my_wait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.MICROSECONDS)
                .ignoring(NoSuchElementException.class);

        WebElement my_element = my_wait
                .until(new Function<WebDriver, WebElement>() {
                    //@Override
                    public WebElement apply(WebDriver driver) {
                        return (driver.findElement(by));
                        //return driver.findElement(By.id(element_identifier_id));
                    }
                });
        return my_element;
    }

    public static WebDriverWait waitExplicit(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        return wait;
    }



}
