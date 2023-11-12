package abstractComponents;

import pageObjects.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.OrdersHistoryPage;

import java.time.Duration;

public class AbstractPage {
    public WebDriver driver;

    public AbstractPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = ".btn.btn-custom[routerlink='/dashboard/cart']")
    WebElement cartIcon;

    @FindBy (css = ".fa-sign-out")
    WebElement signOutIcon;

    @FindBy (css = "[routerlink='/dashboard/myorders']")
    WebElement ordersIcon;

    public CartPage clickOnCart(){
        cartIcon.click();
        return new CartPage(driver);
    }

    public void clickOnSignOut(){
        waitUntilElementIsVisible(signOutIcon);
        signOutIcon.click();
    }

    public OrdersHistoryPage clickOnOrders(){
        waitUntilElementIsVisible(ordersIcon);
        ordersIcon.click();
        return new OrdersHistoryPage(driver);
    }

    public void waitUntilElementIsVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilElementIsVisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitUntilElementIsInisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public void waitUntilElementIsInisible(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
