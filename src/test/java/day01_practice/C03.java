package day01_practice;
import com.beust.ah.A;
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

public class C03 {


    // https://www.bestbuy.com/ sayfasına gidin
    // sayfa Title'ini alın "Best" içerdigini test edin
    // BestBuy logosunun görüntülendigini test edin
    // Canada logosunun görüntülendigini test edin


    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        // https://www.bestbuy.com/ sayfasına gidin
        driver.get("https://www.bestbuy.com/");
        // sayfa Title'ini alın "Best" içerdigini test edin
        Assert.assertTrue(driver.getTitle().contains("Best"));
        // BestBuy logosunun görüntülendigini test edin
        WebElement logo = driver.findElement(By.xpath("//img[@class='logo'][1]"));
        Assert.assertTrue(logo.isDisplayed());
        // Canada logosunun görüntülendigini test edin
        WebElement kanadaLogo = driver.findElement(By.xpath("(//img[@alt='Canada'])[1]"));
        Assert.assertTrue(kanadaLogo.isDisplayed());

    }
}