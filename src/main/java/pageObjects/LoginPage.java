package pageObjects;

import abstractComponents.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "userEmail")
    WebElement emailField;
    @FindBy (id = "userPassword")
    WebElement passwordField;
    @FindBy (id = "login")
    WebElement loginButton;

    @FindBy (css = ".ng-trigger-flyInOut")
    WebElement errorMessage;

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }

    public ProductCataloguePage login(String email, String password){
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
        return new ProductCataloguePage(driver);
    }

    public String getErrorMessageText(){
        waitUntilElementIsVisible(errorMessage);
        return errorMessage.getText();
    }

}
