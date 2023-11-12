package pageObjects;

import abstractComponents.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractPage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "li.items")
    List<WebElement> productCards;
    @FindBy (css = ".totalRow button")
    WebElement checkoutButton;

    By productNameSublocator = By.cssSelector("h3");

    public boolean verifyThatProductIsInCart (String product){
        return productCards.stream().anyMatch(p->p.findElement(productNameSublocator).getText().equalsIgnoreCase(product));
    }

    public OrderPage clickOnCheckoutButton() {
        checkoutButton.click();
        return new OrderPage(driver);
    }


















}
