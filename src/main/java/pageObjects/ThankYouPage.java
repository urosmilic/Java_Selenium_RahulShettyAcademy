package pageObjects;

import abstractComponents.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankYouPage extends AbstractPage {
    public ThankYouPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = "h1.hero-primary")
    WebElement pageHeading;

    public String getPageHeadingText(){
        waitUntilElementIsVisible(pageHeading);
        return pageHeading.getText();
    }

}
