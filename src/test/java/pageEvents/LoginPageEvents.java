package pageEvents;


import org.testng.Assert;
import pageObjects.LoginPageElements;
import utils.*;

import java.util.Locale;

import static utils.Utility.getTestData;

public class LoginPageEvents {

    ElementFetch elementFetch;

    public LoginPageEvents(){
        elementFetch = new ElementFetch();
    }

    public void clickOnLoginButton() throws InterruptedException {

//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID", LoginPageElements.loginButton).click();
        Waits.explicitWait(elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle));
        Assert.assertEquals(elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle).getText().toUpperCase(Locale.ROOT),Constants.PRODUCTS);


    }

    public void verifyLoginPageOpenedOrNot(){
//        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(elementFetch.getWebElements("XPATH", LoginPageElements.homePageLogo).size()>0,"Home page is not opened properly");
        Assert.assertTrue(Utility.findElement(elementFetch.getWebElement("ID", LoginPageElements.loginButton)));
    }

    public void enterEmailID() throws Exception {
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID",LoginPageElements.userNameField).sendKeys(getTestData("UserName1"));
    }

    public void enterPassword() throws Exception {
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID",LoginPageElements.passwordField).sendKeys(getTestData("PassWord1"));

    }

    public void verifyLoggedInPage(){
//        ElementFetch elementFetch = new ElementFetch();
        Assert.assertTrue(Utility.findElement(elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle)));
        String title = elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle).getText();
        System.out.println("Title of logged in Page - "+title);
        Assert.assertEquals(title,"PRODUCTS");
    }

    public void makeCartEmpty(){
//        ElementFetch elementFetch = new ElementFetch();

        elementFetch.getWebElement("XPATH",LoginPageElements.cartIcon).click();
        int size = elementFetch.getWebElements("XPATH",LoginPageElements.removeButton).size();
        System.out.println("SIZE OF CART - "+size);
        for(int i=0;i<size;i++){
            elementFetch.getWebElement("XPATH",LoginPageElements.removeButton).click();
        }
        Assert.assertEquals(elementFetch.getWebElements("XPATH",LoginPageElements.removeButton).size(),0);
    }

    public void clickOnContinueShopping() throws InterruptedException {
        elementFetch.getWebElement("ID",LoginPageElements.continueShoppingButton).click();
        Waits.explicitWait(elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle));

    }

    public void checkItemAddedInCart(String itemName) throws InterruptedException {
        String element = getItemtoRemove(itemName);
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH",LoginPageElements.cartIcon).click();
        Waits.explicitWait(elementFetch.getWebElement("XPATH", LoginPageElements.cartQuantity));
        Assert.assertTrue(Utility.findElement(elementFetch.getWebElement("ID", element)));

    }


    public void addItemtoCartAfterOpen(String itemName) throws InterruptedException {

        String element = getItem(itemName);
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("XPATH", element).click();
        Waits.waitFor("1");
        Helpers.itemPrice = elementFetch.getWebElement("XPATH", LoginPageElements.itemPrice).getText();
        element = getItemtoAdd(itemName);
        elementFetch.getWebElement("ID", element).click();
        element = getItemtoRemove(itemName);
        Waits.explicitWait(elementFetch.getWebElement("ID", element));
        System.out.println("This is the item Price - "+ Helpers.itemPrice);

    }

    public void addItemtoCartDirect(String itemName) throws InterruptedException {
        String element = getItemtoAdd(itemName);
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID", element).click();
        element = getItemtoRemove(itemName);
        Waits.explicitWait(elementFetch.getWebElement("ID", element));

    }

    public void clickOnCheckOut() throws InterruptedException {
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID", LoginPageElements.checkoutButton).click();
        Waits.explicitWait(elementFetch.getWebElement("ID",LoginPageElements.continueButton));

    }

    public void putYourInformationContinue() throws Exception {
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID", LoginPageElements.firstName).sendKeys(getTestData("FirstName"));
        elementFetch.getWebElement("ID", LoginPageElements.lastName).sendKeys(getTestData("LastName"));
        elementFetch.getWebElement("ID", LoginPageElements.zipCode).sendKeys(getTestData("ZipCode"));
        elementFetch.getWebElement("ID",LoginPageElements.continueButton).click();
        Waits.explicitWait(elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle));
        Assert.assertEquals(elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle).getText().toUpperCase(Locale.ROOT),Constants.CHECKOUT_OVERVIEW);


    }

    public void verifyItemInformation(){
//        ElementFetch elementFetch = new ElementFetch();
        String itemPricePreTax = elementFetch.getWebElement("XPATH",LoginPageElements.itemTotal).getText();
        String[] itemPrice = itemPricePreTax.split(":");
        Assert.assertEquals(itemPrice[1].trim(), Helpers.itemPrice);

    }

    public void clickOnFinish() throws InterruptedException {
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID",LoginPageElements.finishButton).click();
        Waits.explicitWait(elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle));
        Assert.assertEquals(elementFetch.getWebElement("XPATH", LoginPageElements.pageTitle).getText().toUpperCase(Locale.ROOT),Constants.CHECKOUT_COMPLETE);
    }

    public void verifyOrderConfirmationPage(){
//        ElementFetch elementFetch = new ElementFetch();
        String orderConfirmationMessg = elementFetch.getWebElement("XPATH",LoginPageElements.confirmationMessage).getText();
        Assert.assertEquals(orderConfirmationMessg.toUpperCase(Locale.ROOT),Constants.ORDER_CONFIRMATION);
    }

    public void clickBackHome() throws InterruptedException {
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID",LoginPageElements.backHomeButton).click();
    }

    public void clickLogOut() throws InterruptedException {
//        ElementFetch elementFetch = new ElementFetch();
        elementFetch.getWebElement("ID",LoginPageElements.topLeftNavigationButton).click();
        elementFetch.getWebElement("ID",LoginPageElements.logOut).click();
        Waits.explicitWait(elementFetch.getWebElement("XPATH", LoginPageElements.homePageLogo));

    }


    private String getItemtoAdd(String itemName) {
        switch(itemName){
            case "BACKPACK":
                return LoginPageElements.itemBackpackAddtoCart;
            case "BIKE LIGHT":
                return LoginPageElements.itemBikeLightAddtoCart;
            case "BOLT TSHIRT":
                return LoginPageElements.itemBoltTshirtAddtoCart;
            case "FLEECE JACKET":
                return LoginPageElements.itemFleeceJacketAddtoCart;
            case "ONESIE":
                return LoginPageElements.itemOneSieAddtoCart;
            case "ALL THE THINGS THIRT":
                return LoginPageElements.itemTestAlltheThingsTshirtAddtoCart;
            default:
                return null;
        }

    }

    private String getItemtoRemove(String itemName) {
        switch(itemName){
            case "BACKPACK":
                return LoginPageElements.itemRemoveBackpack;
            case "BIKE LIGHT":
                return LoginPageElements.itemRemoveBikeLight;
            case "BOLT TSHIRT":
                return LoginPageElements.itemRemoveBoltTshirt;
            case "FLEECE JACKET":
                return LoginPageElements.itemRemoveFleeceJacket;
            case "ONESIE":
                return LoginPageElements.itemRemoveOneSie;
            case "ALL THE THINGS THIRT":
                return LoginPageElements.itemRemoveTestAlltheThingsTshirt;
            default:
                return null;
        }

    }

    private String getItem(String itemName) {
        switch(itemName){
            case "BACKPACK":
                return LoginPageElements.itemBackpack;
            case "BIKE LIGHT":
                return LoginPageElements.itemBikeLightAddtoCart;
            case "BOLT TSHIRT":
                return LoginPageElements.itemBoltTshirtAddtoCart;
            case "FLEECE JACKET":
                return LoginPageElements.itemFleeceJacketAddtoCart;
            case "ONESIE":
                return LoginPageElements.itemOneSie;
            case "ALL THE THINGS THIRT":
                return LoginPageElements.itemTestAlltheThingsTshirtAddtoCart;
            default:
                return null;
        }

    }

}
