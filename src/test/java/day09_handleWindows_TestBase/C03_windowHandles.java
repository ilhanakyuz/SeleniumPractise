package day09_handleWindows_TestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
     driver.quit();
    }
    @Test
    public void test01(){

//● Tests package’inda yeni bir class olusturun: WindowHandle2
//● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows ");

//● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfadakiYaziElementi = driver.findElement(By.xpath("//h3"));
        String excepteedYazi = "Opening a new window";
        String actualYazi = sayfadakiYaziElementi.getText();
        Assert.assertEquals(excepteedYazi,actualYazi);

//● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String exceptedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(exceptedTitle,actualTitle);

        String ilkSayfaWindowHandleDegeri = driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);


//● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();

        /*
        switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
        biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
        ve yeni sayfa ile ilgili hicbir islem yapamaz
        yeni sayfada driver'i calistirmak isterseniz
        once driver'i yeni sayfaya yollamalisiniz
         */
        Set<String> windowHandleSeti = driver.getWindowHandles();
        System.out.println(windowHandleSeti);
        String ikinciSayfaWindowHandleDegeri="";
        for (String each : windowHandleSeti){
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                 ikinciSayfaWindowHandleDegeri = each;
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String exceptedIkinciTitle = "New Window";
        String actualIkinciTitle = driver.getTitle();
        Assert.assertEquals(exceptedIkinciTitle,actualIkinciTitle);

//● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaYaziElementi = driver.findElement(By.xpath("//h3"));
        String exceptedIkinciYazi = "New Window";
        String actualIkinciYazi = ikinciSayfaYaziElementi.getText();
        Assert.assertEquals(exceptedIkinciYazi,actualIkinciYazi);
//● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);

// “The Internet” olduğunu doğrulayın.
         exceptedTitle = "The Internet";
         actualTitle = driver.getTitle();

         Assert.assertEquals(exceptedTitle,actualTitle);
    }
}
