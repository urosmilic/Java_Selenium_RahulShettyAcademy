package pageObjects;

import abstractComponents.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractPage {
    WebDriver driver; //mozemo da skinemo jer nasledjujemo od AbstractPage
    public OrderPage(WebDriver driver) {
        super(driver);
        this.driver = driver;   //mozemo da skinemo jer nasledjujemo od AbstractPage, u nekim klasama i jesam skinuo kao dokaz
        PageFactory.initElements(driver, this);
    }

    @FindBy (css = "[placeholder='Select Country']")
    WebElement selectCountryField;

    @FindBy (css = "button.ta-item")
    List<WebElement>countries;
    @FindBy (css = ".btnn.action__submit")
    WebElement placeOrderButton;


    By countriesLocator = By.cssSelector("button.ta-item");

    public void chooseCountry (String country) {
        selectCountryField.sendKeys(country);
        waitUntilElementIsVisible(countriesLocator);
        WebElement countryToClick = countries.stream().findFirst().orElse(null);
        countryToClick.click();
    }

    public ThankYouPage clickOnPlaceOrderButton () {
        placeOrderButton.click();
        return new ThankYouPage(driver);
    }

}
