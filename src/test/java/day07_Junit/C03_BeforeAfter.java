
package day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_BeforeAfter {

    //WebDriver driver;--> tanimlamamin sebebi driver objesini rahatlikla kullanabilmek
    //eger yazmassam hata alirim
    //class seviyesinde yaziyorum cunku before after methodlarinin altinda rahatca kullanabilmeliyim
    //before class altinda kullanabilmem icinde classin static olması gerekir
    WebDriver driver;
    //en basta before'un icerisinde driver'imi tanimliyorum
    //asagidakileri bir kere tanimliyorum her test methodunda kullanabiliyorum
    //webDriver'imi tanimliyorum
    //sonra maximize ediyorum
    //"setUp" ayarlamak demek

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {
        driver.get("https://techproeducation.com");
    }

    @Test
    public void test02() {
        driver.get("https://amazon.com");
    }
}