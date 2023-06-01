package pageObjects;

public interface LoginPageElements {

    String userNameField = "user-name";//"//input[@id='user-name']";
    String passwordField = "password";//"//input[@id='password']";
    String homePageLogo = "//div[@class='login_logo']";
    String loginButton = "login-button";////input[@id='login-button']
    String pageTitle = "//span[@class='title']";
    String cartIcon = "//a[@class='shopping_cart_link']";

    String itemBackpack = "//div[normalize-space()='Sauce Labs Backpack']";
    String itemOneSie = "//div[normalize-space()='Sauce Labs Onesie']";

    String itemBackpackAddtoCart = "add-to-cart-sauce-labs-backpack";//"//button[@id='add-to-cart-sauce-labs-backpack']"
    String itemOneSieAddtoCart = "add-to-cart-sauce-labs-onesie";////button[@id='add-to-cart-sauce-labs-onesie']
    String itemBikeLightAddtoCart = "add-to-cart-sauce-labs-bike-light";//"//button[@id='add-to-cart-sauce-labs-backpack']"
    String itemBoltTshirtAddtoCart = "add-to-cart-sauce-labs-bolt-t-shirt";////button[@id='add-to-cart-sauce-labs-onesie']
    String itemFleeceJacketAddtoCart = "add-to-cart-sauce-labs-fleece-jacket";//"//button[@id='add-to-cart-sauce-labs-backpack']"
    String itemTestAlltheThingsTshirtAddtoCart = "add-to-cart-test.allthethings()-t-shirt-(red)";////button[@id='add-to-cart-sauce-labs-onesie']

    String itemRemoveBackpack = "remove-sauce-labs-backpack";//button[@id='remove-sauce-labs-backpack']
    String itemRemoveBikeLight = "remove-sauce-labs-bike-light";//button[@id='remove-sauce-labs-backpack']
    String itemRemoveBoltTshirt = "remove-sauce-labs-bolt-t-shirt";//button[@id='remove-sauce-labs-backpack']
    String itemRemoveFleeceJacket = "remove-sauce-labs-fleece-jacket";//button[@id='remove-sauce-labs-backpack']
    String itemRemoveOneSie = "remove-sauce-labs-onesie";//button[@id='remove-sauce-labs-backpack']
    String itemRemoveTestAlltheThingsTshirt = "remove-test.allthethings()-t-shirt-(red)";//button[@id='remove-sauce-labs-backpack']

    String cartQuantity = "//div[@class='cart_quantity']";
    String checkoutButton = "checkout";//button[@id='checkout']";

    String firstName = "first-name";//input[@id='first-name']";
    String lastName = "last-name";
    String zipCode = "postal-code";

    String finishButton = "finish";//button[@id='finish']";
    String itemTotal = "//div[@class='summary_subtotal_label']";
    String confirmationMessage = "//h2[@class='complete-header']";
    String backHomeButton = "back-to-products";//button[@id='back-to-products']";
    String continueButton = "continue";//input[@id='continue']";
    String continueShoppingButton = "back-to-products";//button[@id='back-to-products']";
    String itemPrice = "//div[@class='inventory_details_price']";
    String itemPriceinCart = "//div[@class='inventory_item_price']";

    String topLeftNavigationButton = "react-burger-menu-btn";//button[@id='react-burger-menu-btn']";
    String logOut = "logout_sidebar_link";//a[@id='logout_sidebar_link']";

    String removeButton = "//button[text()='Remove']";



}
