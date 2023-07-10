package day08_practice;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.WatchEvent;

public class C03_Screenshot extends TestBase {



        // https://www.teknosa.com/ adresine gidin
        // arama cubuguna oppo yazip enter'a basınız
        // sonuc yazısını yazdiriniz
        // ilk urunun fotografını cekin


    @Test
    public void test01() throws IOException {

        // https://www.teknosa.com/ adresine gidin
        driver.get("https://www.teknosa.com/");





        // arama cubuguna oppo yazip enter'a basınız

        driver.findElement(By.xpath("(//input)[6]")).sendKeys("Oppo" + Keys.ENTER);




        // sonuc yazısını yazdiriniz
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='plp-panel-block1']"));
        System.out.println(sonucYazisi.getText());

        // ilk urunun fotografını cekin

        WebElement ilkUrun = driver.findElement(By.xpath("(//a[@class=' prd-link '])[1]"));

        File kayit = new File("target/ekranGoruntusu/urun.Jpeg");

        File geciciDosya = ilkUrun.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya,kayit);

    }
}
