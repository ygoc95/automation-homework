package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class ResultPage {

    WebDriver driver;
    static Random rand = new Random();
    int productIndex = rand.nextInt(23)+1;
    String productXpath = "//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[1]";

    @FindBy (className = "srch-prdcts-cntnr")
    WebElement resultsDiv;


    @FindBy (xpath = "//*[@id=\"search-app\"]/div/div/div[2]/div[2]/div/div[15]")
    WebElement someProduct;


    public ResultPage(WebDriver driver){
        this.driver=driver;
    }

    public boolean verifyPageLoaded(){
        return resultsDiv.isDisplayed();
    }
    public void goToProduct(){
        someProduct.click();
    }
}
