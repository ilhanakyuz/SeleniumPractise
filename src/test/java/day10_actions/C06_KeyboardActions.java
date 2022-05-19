package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //facebooka git, yeni kayıt oluştur, isim kutusunu locate edip, geriye kalanlari TAB ile formu doldurun
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);

        actions.click(isimKutusu).sendKeys("İlhan")
                .sendKeys(Keys.TAB)
                .sendKeys("Akyüz")
                .sendKeys(Keys.TAB)
                .sendKeys("ilhana38@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("ilhana38@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("ilhan")
                .sendKeys(Keys.TAB)
                        .sendKeys("20")
                                .sendKeys(Keys.TAB)
                                        .sendKeys("04")
                .sendKeys(Keys.TAB)
                        .sendKeys("1984")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).click()
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).click().perform();

        Thread.sleep(5000);

    }
}
