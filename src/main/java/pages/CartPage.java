package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    WebDriver driver;

    @FindBy(className = "counter-content")
        WebElement productCountValue;
    @FindBy(xpath = "//*[@id=\"partial-basket\"]/div/div[2]/div[2]/div[3]/div[1]/div/button[2]")
        WebElement increaseProductButton;
    @FindBy(css="dd.total-price")
        WebElement productPriceValue;
    @FindBy(css = "i.i-trash")
        WebElement deleteButton;
    @FindBy(xpath = "//*[@id=\"ngdialog1\"]/div[2]/form/div/div[2]/div/div[1]/button[2]")
        WebElement confirmDelete;

    public CartPage(WebDriver driver){
        this.driver=driver;

    }
    public void deleteProduct(){
        deleteButton.click();
        confirmDelete.click();
    }

    public String getProductPrice(){
        return productPriceValue.getText();
    }
    public void increaseProductCount(){
        increaseProductButton.click();
    }

    public String getProductCount(){
        return productCountValue.getAttribute("value");
    }

    public boolean productCountCheck(int count){
        System.out.println("Your input: "+count);
        System.out.println("Cart check: "+getProductCount());


        if(count== Integer.parseInt(getProductCount())){
            System.out.println("Product count comparison returned sucessful");

            return true;
        }
        else{
            System.out.println("Product count comparison  failed");
            return false;
            }
        }
        public boolean cartIsEmpty(){
            if(deleteButton.isDisplayed()){
                return false;
            }
            else return true;
        }
    }


