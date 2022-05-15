package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.PublicKey;
import java.time.Duration;


public class practise {
    WebDriver driver;
    @Before

    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After

    public void close(){
     driver.close();
    }
    @Test

    public void test(){
        //        1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        //        2-Sayfayi “refresh” yapin
        driver.findElement(By.id("nav-logo-sprites")).click();
        //        3- Sayfanin “Return Order” ifadesi icerdigini test edin
        WebElement returnOrder = driver.findElement(By.id("nav-orders"));
        if (returnOrder.isDisplayed()){
            System.out.println("Test is PASS");
        }else{
            System.out.println("Test is FAILED");
        }
        //        4- Gift Cards sekmesine basin
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[4]")).click();
        //        5- Birthday butonuna basin
        driver.findElement(By.xpath("(//div[@class='bxc-grid__image   bxc-grid__image--light'])[2]")).click();
        //        6- Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//div[@id='acs-product-block-0'])[1]")).click();
        //        7- Gift card details’den 25 $’i secin
        driver.findElement(By.xpath("(//button[@id='gc-mini-picker-amount-1'])[1]")).click();
        //        8-Urun ucretinin 25$ oldugunu test edin
        WebElement tutarKontrol = driver.findElement(By.id("gc-buy-box-text"));
        if (tutarKontrol.isDisplayed()){
            System.out.println("Tutar testi PASSED");
        }else{
            System.out.println("Tutar testi FAILED");

        }


    }


}
