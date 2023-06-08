package day01_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01 {
    // https://ebay.com sayfasına gidiniz
    // electronics bolumune tıklayınız
    // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız


    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        
    }

    @Test
    public void test01() {
        // https://ebay.com sayfasına gidiniz
        driver.get("https://ebay.com");
        // electronics bolumune tıklayınız
        driver.findElement(By.xpath("//*[@class='hl-cat-nav__js-tab'][1]")).click();
        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız
        List<WebElement> resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
        for (int i = 0; i < resimler.size(); i++) {
            resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            resimler.get(i).click();
            System.out.println(driver.getTitle());
            driver.navigate().back();



        }






    }
}
