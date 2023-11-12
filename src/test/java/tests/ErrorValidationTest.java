package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CartPage;
import pageObjects.OrderPage;
import pageObjects.ProductCataloguePage;
import pageObjects.ThankYouPage;
import testComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {

    @Test (groups = {"smoke"})
    public void invalidLogin() {
        ProductCataloguePage productCataloguePage = loginPage.login("testiranje123@gmail.com", "Pogresna sifra");
        Assert.assertEquals(loginPage.getErrorMessageText(), "Incorrect email or password.");
    }

    @Test
    public void productValidation() {
        ProductCataloguePage productCataloguePage = loginPage.login("testiranje123@gmail.com", "Testiranje123");
        String productName = "IPHONE 13 PRO";
        productCataloguePage.clickOnProduct(productName);
        CartPage cartPage = productCataloguePage.clickOnCart();
        boolean isInCart = cartPage.verifyThatProductIsInCart("IPHONE 13 PRO error");
        Assert.assertFalse(isInCart);
    }

}
