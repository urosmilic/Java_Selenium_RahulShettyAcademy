package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testComponents.BaseTest;

import java.io.IOException;

public class SubmitOrderTest extends BaseTest {

    String productName = "IPHONE 13 PRO";
    @Test (groups = {"smoke"})
    public void submitOrder() {
        ProductCataloguePage productCataloguePage = loginPage.login("testiranje123@gmail.com", "Testiranje123");

        productCataloguePage.clickOnProduct(productName);
        CartPage cartPage = productCataloguePage.clickOnCart();
        boolean isInCart = cartPage.verifyThatProductIsInCart(productName);
        Assert.assertTrue(isInCart);
        OrderPage orderPage = cartPage.clickOnCheckoutButton();
        orderPage.chooseCountry("Yugoslav");
        ThankYouPage thankYouPage = orderPage.clickOnPlaceOrderButton();
        String expectedThankYouPageHeading = "THANKYOU FOR THE ORDER.";
        String actualThankYouPageHeading = thankYouPage.getPageHeadingText();
        Assert.assertEquals(actualThankYouPageHeading,expectedThankYouPageHeading);
        thankYouPage.clickOnSignOut();
    }

    @Test (dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {
        //proveravamo da li se proizvod koji smo u testu iznad kupili nalazi u listi Orders.
        ProductCataloguePage productCataloguePage = loginPage.login("testiranje123@gmail.com", "Testiranje123");
        OrdersHistoryPage ordersHistoryPage = productCataloguePage.clickOnOrders();
        ordersHistoryPage.clickOnOrders();
        String productName_Ordered = ordersHistoryPage.getLatestOrderText();
        Assert.assertEquals(productName_Ordered.toUpperCase(),productName.toUpperCase());
    }













}
