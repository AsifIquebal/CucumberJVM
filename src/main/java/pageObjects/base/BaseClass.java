package pageObjects.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseClass {

    public WebDriver driver;


    @BeforeClass
    @Parameters("browser")
    public void launchBrowser(@Optional("firefox") String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    public void launchApplication(){
        driver.get("https://github.com/login");
    }

    @AfterMethod
    public void getScreenShot(ITestResult result) throws IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_hh.mm.ss");
        String formattedDate = formatter.format(date);
        if(!result.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String fileName = result.getMethod().getMethodName();
            String path = new File(System.getProperty("user.dir")).getAbsolutePath()+"/src/test/java/Selenium/screenshots/";
            File destFile = new File(path + fileName + "_" + formattedDate+".png");
            System.out.println("Project Location Root: " + System.getProperty("user.dir"));
            //File destFile = new File("C:/Other/screenShots/" + fileName + "_" + formattedDate + ".png");
            System.out.println(destFile.getAbsolutePath());
            FileUtils.copyFile(scrFile, destFile, true);
            Reporter.setCurrentTestResult(result);
            Reporter.log("<a href='" + destFile.getCanonicalPath() + "'> <img src='" + destFile.getCanonicalPath() + "' height='100' width='100'/> </a>");

        }
        if(result.getStatus() == ITestResult.FAILURE){
            System.out.println("Another way to check: result.getStatus() == ITestResult.FAILURE" );
        }
    }

    public void getScreenShot(String name){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "src/test/java/Selenium/screenshots/";
            File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
            FileUtils.copyFile(scrFile, destFile);
            // This will help us to link the screen shot in testNG report
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}
