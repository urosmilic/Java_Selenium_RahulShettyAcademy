package pageObjects;

import abstractComponents.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage extends AbstractPage {
    WebDriver driver;
    public ProductCataloguePage(WebDriver driver) {
        super (driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".mb-3")
    List<WebElement> products;
    By productsLocator = By.cssSelector(".mb-3");

    By toastMessage = By.cssSelector("#toast-container");
    By spinner = By.cssSelector(".ng-animating");

    public void clickOnProduct (String productName) {
        waitUntilElementIsVisible(productsLocator);
        WebElement product = products.stream().filter(p -> p.findElement(By.cssSelector("h5 b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        product.findElement(By.cssSelector("button:nth-child(4)")).click();
        waitUntilElementIsVisible(spinner);
        waitUntilElementIsInisible(toastMessage);
    }

}
