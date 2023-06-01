package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pageEvents.LoginPageEvents;
import utils.Helpers;

public class Tests extends BaseTest{


    @Test
    public void sampleTestforSiteLaunch(){
        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.verifyLoginPageOpenedOrNot();
    }

    @Test
    public void sampleTestforLogin() throws Exception {
        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.enterEmailID();
        loginPageEvents.enterPassword();
        loginPageEvents.clickOnLoginButton();
        loginPageEvents.verifyLoggedInPage();

    }

    @Test
    public void sampleUserJourney1() throws Exception {
        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.enterEmailID();
        loginPageEvents.enterPassword();
        loginPageEvents.clickOnLoginButton();
        loginPageEvents.addItemtoCartAfterOpen(Helpers.ItemID);
        loginPageEvents.checkItemAddedInCart(Helpers.ItemID);
        loginPageEvents.clickOnCheckOut();
        loginPageEvents.putYourInformationContinue();
        loginPageEvents.clickOnFinish();
        loginPageEvents.verifyOrderConfirmationPage();

    }

    @Test
    public void sampleUserJourney2() throws Exception {
        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.enterEmailID();
        loginPageEvents.enterPassword();
        loginPageEvents.clickOnLoginButton();
        loginPageEvents.verifyLoggedInPage();
        loginPageEvents.addItemtoCartAfterOpen(Helpers.ItemID);
        loginPageEvents.checkItemAddedInCart(Helpers.ItemID);
        loginPageEvents.clickOnCheckOut();
        loginPageEvents.putYourInformationContinue();
        loginPageEvents.clickOnFinish();
        loginPageEvents.verifyOrderConfirmationPage();
        loginPageEvents.clickBackHome();
        loginPageEvents.verifyLoggedInPage();
        loginPageEvents.addItemtoCartAfterOpen(Helpers.ItemID2);
        loginPageEvents.checkItemAddedInCart(Helpers.ItemID2);
        loginPageEvents.clickOnCheckOut();
        loginPageEvents.putYourInformationContinue();
        loginPageEvents.verifyItemInformation();
        loginPageEvents.clickOnFinish();
        loginPageEvents.verifyOrderConfirmationPage();
        loginPageEvents.clickBackHome();
        loginPageEvents.verifyLoggedInPage();
        loginPageEvents.clickLogOut();
        loginPageEvents.verifyLoginPageOpenedOrNot();

    }

    @Test
    public void removeProductsfromCart() throws Exception {
        LoginPageEvents loginPageEvents = new LoginPageEvents();
        loginPageEvents.enterEmailID();
        loginPageEvents.enterPassword();
        loginPageEvents.clickOnLoginButton();
        loginPageEvents.verifyLoggedInPage();
        loginPageEvents.addItemtoCartAfterOpen(Helpers.ItemID);
        loginPageEvents.clickOnContinueShopping();
        loginPageEvents.addItemtoCartAfterOpen(Helpers.ItemID2);
        loginPageEvents.makeCartEmpty();
    }


    @Test
    public void xpathTest(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rediff.com/");
        driver.findElement(By.xpath("//a[@class='signin']")).click();



    }

}
