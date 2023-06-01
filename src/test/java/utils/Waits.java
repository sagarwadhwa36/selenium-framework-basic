package utils;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.util.concurrent.TimeUnit;

public class Waits extends BaseTest {

    public static void explicitWait(WebElement element) throws InterruptedException {
    try{
    WebElement wait = new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOf(element));
    }catch(Exception e){
    e.printStackTrace();
    }

    }


    public static void implicitWait(WebDriver driver, int timeOut) {
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
    }

    public static void waitFor(String secs) {
        try {
            Thread.sleep(Integer.parseInt(secs)*1000);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }






}
