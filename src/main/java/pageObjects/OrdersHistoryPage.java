package pageObjects;

import abstractComponents.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrdersHistoryPage extends AbstractPage {

    public OrdersHistoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//tr[@class = 'ng-star-inserted']")
    List<WebElement> listOfOrders;

    @FindBy (xpath = "//tr[@class = 'ng-star-inserted']/td[2]")
    List<WebElement> orderedProductNames;

    By listOfOrdersLocator = By.xpath("//tr[@class = 'ng-star-inserted']");

    By productNameLocator = By.xpath("//td[2]");


    public List<WebElement> getProductList(){
        waitUntilElementIsVisible(listOfOrdersLocator);
        return listOfOrders;
    }

    public String getLatestOrderText(){
        waitUntilElementIsVisible(listOfOrdersLocator);
        return orderedProductNames.get(orderedProductNames.size()-1).getText();
    }

}
