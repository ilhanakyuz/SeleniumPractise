package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //1.Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3.chooseFile butonuna basalim

        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\text.txt";
        String yuklenecekDosya = farkliKisim + ortakKisim;


        //4.Yuklemek istediginiz dosyayi secelim.
        chooseFile.sendKeys(yuklenecekDosya);

        //5.Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();

        //6.“File Uploaded!” textinin goruntulendigini test edelim.
        WebElement yaziElemeti = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(yaziElemeti.isDisplayed());

        Thread.sleep(5000);

    }
}
