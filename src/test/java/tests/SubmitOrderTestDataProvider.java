package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.*;
import testComponents.BaseTest;

import java.util.HashMap;

public class SubmitOrderTestDataProvider extends BaseTest {

    String productName = "IPHONE 13 PRO";
    @Test (dataProvider = "getData", groups = {"smoke"})
    public void submitOrder2(String email,String password) {
        ProductCataloguePage productCataloguePage = loginPage.login(email, password);

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

    @Test (dataProvider = "getDataAsMap")
    public void submitOrder3(HashMap<String,String> input) {
        ProductCataloguePage productCataloguePage = loginPage.login(input.get("email"), input.get("password"));

        productCataloguePage.clickOnProduct(input.get("productN"));
        CartPage cartPage = productCataloguePage.clickOnCart();
        boolean isInCart = cartPage.verifyThatProductIsInCart(input.get("productN"));
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
        ProductCataloguePage productCataloguePage = loginPage.login("testiranje123@gmail.com", "Testiranje123");
        OrdersHistoryPage ordersHistoryPage = productCataloguePage.clickOnOrders();
        ordersHistoryPage.clickOnOrders();
        String productName_Ordered = ordersHistoryPage.getLatestOrderText();
        Assert.assertEquals(productName_Ordered.toUpperCase(),productName.toUpperCase());
    }

    @DataProvider
    public Object[][] getData(){
        return new Object [] [] {{"testiranje123@gmail.com","Testiranje123"},{"testiranje12345@gmail.com","Testiranje1234"}};
    }


    @DataProvider
    public  Object [] [] getDataAsMap(){

        HashMap <String, String> map1 = new HashMap<>();
        HashMap <String, String> map2 = new HashMap<>();

        map1.put("email", "testiranje123@gmail.com");
        map1.put("password", "Testiranje123");
        map1.put("productN", "IPHONE 13 PRO");

        map2.put("email", "testiranje12345@gmail.com");
        map2.put("password", "Testiranje1234");
        map2.put("productN", "ZARA COAT 3");

        return new Object [] [] {{map1}, {map2}};
    }













}
