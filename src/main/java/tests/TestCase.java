package tests;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase {

    @Test
    public void mainTest() throws InterruptedException {

        //chrome driver yolu ve giriş bilgileri
        String driverPath = "D:/chromedriver.exe";
        String url = "http://www.trendyol.com";
        System.setProperty("webdriver.chrome.driver",driverPath);
        String email = "Your e-mail";
        String password = "Your password";
        String searchQuery = "bilgisayar";
        String productPrice,cartPrice;


        //driver ve pageleri baslatma
        WebDriver driver = new ChromeDriver();
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        ResultPage resultPage = PageFactory.initElements(driver,ResultPage.class);
        CartPage cartPage = PageFactory.initElements(driver,CartPage.class);
        ProductPage productPage = PageFactory.initElements(driver,ProductPage.class);

        //Anasayfa gitme
        driver.get(url);

        //Pencereyi büyütme
        driver.manage().window().maximize();

        //Ara bekleme süreleri 4 er saniye
        Thread.sleep(4000);
        //İlk çıkan modalı kapama
        homePage.closeFancyBox();
        Thread.sleep(4000);

        //Giriş ekranına gidiş
        homePage.clickLoginPage();
        Thread.sleep(4000);

        //Giriş metodu
        loginPage.loginAction(email,password);
        Thread.sleep(4000);

        //Login sonrası modal kapama
        homePage.closePopup();
        Thread.sleep(4000);

        //Anasayda araması
        homePage.makeSearch(searchQuery);
        Thread.sleep(4000);

        //Ürün seçimi
        resultPage.goToProduct();
        Thread.sleep(4000);

        //Sepete ekleme
        productPage.addToCart();
        Thread.sleep(4000);

        //Ürün sayfa fiyatı
        productPrice = productPage.getProductPrice();
        System.out.println("Product price: "+productPrice);
        productPage.goToCart();
        Thread.sleep(4000);

        //Ürün sepet fiyatı
        cartPrice=cartPage.getProductPrice();


        //BU KISIM Utilities gibi farklı bir classa da konabilir

        //Fiyatları kolay karşılaştırmak için float a çevirme opersyonları
        //TL'ye kadar string kesilmesi örnek: 1.234,42 TL --> 1.234,42
        String[] s1=cartPrice.split("TL");
        String[] s2=productPrice.split("TL");


        //Float standardı için nokta ve virgül formatlanması
        s1[0] = s1[0].replace(".","");
        s1[0] = s1[0].replace(",",".");
        s2[0] = s2[0].replace(".","");
        s2[0] = s2[0].replace(",",".");
        Float prodpricefloat = Float.parseFloat(s2[0]);
        Float cartpricefloat = Float.parseFloat(s1[0]);
        System.out.println("Prices: "+ (prodpricefloat-cartpricefloat));


        if(prodpricefloat-cartpricefloat==0.00){
            System.out.println("Price comparison successful");
            Thread.sleep(4000);
            cartPage.increaseProductCount();
            Thread.sleep(4000);
            if (cartPage.productCountCheck(2)){
                cartPage.deleteProduct();
                if(cartPage.cartIsEmpty()){
                    System.out.println("Test Successful");
                }
                else System.out.println("delete failed");
            }

        }

    }

}
