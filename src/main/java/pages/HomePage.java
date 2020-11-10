package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id="accountBtn")
        WebElement accountButton;
    @FindBy(css = "input.search-box")
        WebElement searchBox;
    @FindBy(css = "a.fancybox-close")
        WebElement fancyBoxCloseButton;
    @FindBy(css = "div.modal-close")
        WebElement closePopup;




    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public void clickLoginPage(){
        accountButton.click();
    }

    public void closeFancyBox(){
        fancyBoxCloseButton.click();
    }

    public void closePopup(){
        closePopup.click();
    }


    public void makeSearch(String searchQuery){
        searchBox.sendKeys(Keys.CONTROL+"a");
        searchBox.sendKeys(Keys.DELETE);
        searchBox.sendKeys(searchQuery);
        searchBox.sendKeys(Keys.ENTER);
    }




}
