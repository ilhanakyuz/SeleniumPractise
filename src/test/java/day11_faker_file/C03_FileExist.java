package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01(){

        System.out.println(System.getProperty("user.dir"));
        //bana icinde oldugum projenin dosya yolunu(path) verir.

        System.out.println(System.getProperty("user.home"));
        //C:\Users\ilhan ==> bilgisayarimin bana ozel kismini verdi
        //C:\Users\ilhan\Downloads

        //homePath + "/Downloads"

        // Masaustudeki text dosyasinin varligini test edelim
        // C:\Users\ilhan\Desktop\text.txt
        String dosyaYolu = System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyaYolu);


        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Desktop\\text.txt";
        String masaUstuDosyaYolu = farkliKisim + ortakKisim;

     //   System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));

        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));

    }
}
