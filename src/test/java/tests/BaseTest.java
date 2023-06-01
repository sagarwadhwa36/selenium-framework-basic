package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.Constants;
import utils.Utility;
import utils.Waits;

import java.io.IOException;
import java.lang.reflect.Method;

public class BaseTest {

    public static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest logger;



    @BeforeSuite
    public void beforeSuiteMethod(){
        try{
            ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("./reports/AutomationReport.html");
            htmlReporter.config().setReportName("Automation Tests Result");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @BeforeMethod
    @Parameters(value={"browserName"})
    public void beforeMethodMethod(String browserName, Method testMethod){
        logger = extent.createTest(testMethod.getName());

        setupDriver(browserName);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        Waits.implicitWait(driver,5);


    }


    @AfterMethod
    public void afterMethodMethod(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= Utility.getScreenshot(driver, result);

            logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }

        driver.quit();

    }



    @AfterSuite
    public void afterSuiteMethod(){
        extent.flush();

    }

    public void setupDriver(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){
            //write code for any other browser
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else{
            //write code for any other browser

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }



}
