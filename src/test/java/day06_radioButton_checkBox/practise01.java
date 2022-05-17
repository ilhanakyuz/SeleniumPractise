package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class practise01 {
    WebDriver driver;

//  1-  Bir Class olusturalim YanlisEmailTesti
//  2-  http://automationpractice.com/index.php sayfasina gidelim
//  3-  Sign in butonuna basalim
//  4-  Email kutusuna @isareti olmayan bir mail yazip enter’a
//     bastigimizda “Invalid email address” uyarisi ciktigini test edelim

   @Before
    public void setUp(){
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
   }
   @After
    public void tearDown(){
      // driver.close();
   }
   @Test
    public void test(){
       //  2-  http://automationpractice.com/index.php sayfasina gidelim
       driver.get("http://automationpractice.com/index.php");

       //  3-  Sign in butonuna basalim
       driver.findElement(By.xpath("//div[@class='header_user_info']")).click();

       //  4-  Email kutusuna asd.gmail.com yazip sign in bastigimizda “Invalid email address” uyarisi ciktigini test edelim
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys("asd.gmail.com");
       driver.findElement(By.id("SubmitLogin")).click();


   }
}
