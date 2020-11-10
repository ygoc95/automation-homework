package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
    WebDriver driver;
    @FindBy(className = "prc-dsc")
        WebElement priceProductPage;
    @FindBy(className = "add-to-bs")
        WebElement addToCartButton;
    @FindBy(id = "myBasketListItem")
        WebElement myCartIcon;

    public ProductPage(WebDriver driver){
        this.driver=driver;


    }
    public void addToCart(){
        addToCartButton.click();
    }
    public String getProductPrice(){
        return priceProductPage.getText();
    }
    public void goToCart(){
        myCartIcon.click();
    }
}
