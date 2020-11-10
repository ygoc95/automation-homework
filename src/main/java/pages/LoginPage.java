package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    WebDriver driver;

    @FindBy (id = "login-email")
    WebElement emailBox;

    @FindBy(id = "login-password-input")
    WebElement passwordBox;

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void loginAction(String email,String password){
        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        passwordBox.submit();
    }
}
