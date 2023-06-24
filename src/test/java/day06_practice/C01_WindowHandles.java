package day06_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.awt.image.Kernel;
import java.util.Set;

public class C01_WindowHandles extends TestBase {

        // 'https://www.n11.com' adresine gidin
        // arama motoruna 'Oppo' yazıp aratın
        // ilk ürüne tıklayın
        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.
        // ilk sayfaya donun ve Title'ını yazdırın


    @Test
    public void test01() throws InterruptedException {

        // 'https://www.n11.com' adresine gidin
        driver.get("https://www.n11.com");

        String  sayfa1Handle = driver.getWindowHandle();
        System.out.println("SAYFA1HANDLE: " + sayfa1Handle);



        Thread.sleep(2000);


        // arama motoruna 'Oppo' yazıp aratın
        driver.findElement(By.xpath("//input[@id='searchData']")).sendKeys("Oppo" + Keys.ENTER);


        Thread.sleep(2000);

        // ilk ürüne tıklayın
        WebElement ilkUrun = driver.findElement(By.xpath("(//img[@class='lazy cardImage'])[1]"));
        ilkUrun.click();

        Thread.sleep(2000);



        Set<String> windowHandleSeti = driver.getWindowHandles();
        /* Ilk urune tiklayinca yeni bir sekmede acti.Acilan sekmede islem yapabilmek icin driver'imizi acilan sekmeye
        gecirmemmiz gerekli bu yuzden bizde acilan butun sayfalarin handle degerini assign ettik.for ve if ile istedigimiz sayfaya
        driveri gecirdik ve handle degerini yazdirdik.

          */

        String sayfa2Handle="";

        for (String w:windowHandleSeti) {

            if(!w.equals((sayfa1Handle))){
                sayfa2Handle = w;
            }


        }

        System.out.println("SAYFA2HANDLE: " + sayfa2Handle);


        driver.switchTo().window(sayfa2Handle);
        // driver'ı yeni acılan sekmeye gecirdik


        Thread.sleep(2000);

        // ikinci sayfa Title'ının 'Türkiye' icerdigini test edin.

        String ikinciSayfaTitle = driver.getTitle();

        Assert.assertTrue(ikinciSayfaTitle.contains("Türkiye"));


        Thread.sleep(2000);

        // ilk sayfaya donun ve Title'ını yazdırın

        driver.switchTo().window(sayfa1Handle); // driver'ı ilk sayfaya gecirdik



        String ilkSayfaTitle = driver.getTitle();
        System.out.println("İLKSAYFATİTLE: " + ilkSayfaTitle);

    }
}