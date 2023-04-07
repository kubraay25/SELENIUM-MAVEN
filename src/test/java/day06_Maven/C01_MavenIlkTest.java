package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {

    /* WebDriverManager.chromedriver().setup();
       Bu ifade Java programlama dilinde Selenium WebDriver'ı kullanarak Chrome tarayıcısı
       için otomatik olarak sürücü dosyasını indirmenizi ve yapılandırmanızı sağlayan
       WebDriverManager kütüphanesinin bir yöntem çağrısıdır
       Selenium WebDriver, web tarayıcılarını otomatik olarak kontrol etmek için kullanılan bir araçtır.
       Ancak, WebDriver'ın her web tarayıcısı için ayrı bir sürücü dosyasına ihtiyacı vardır.
       Örneğin, Chrome tarayıcısı için kullanılan sürücü dosyası "chromedriver.exe" dosyasıdır.
       WebDriverManager kütüphanesi, sürücü dosyalarını otomatik olarak indirmenize ve
       yapılandırmanıza olanak tanır. Bu nedenle, yukarıdaki kod, Chrome tarayıcısı için
       kullanılan sürücü dosyasını indirir ve yapılandırır. Böylece,
       WebDriver'ın Chrome tarayıcısı ile iletişim kurabilmesi için gerekli olan
       tüm önkoşullar sağlanmış olur. */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        //ChromeDriver calismadiginda parantez icindeki kismi yazariz
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.https://www.amazon.com/ sitesine gidelim
        driver.get("https://www.amazon.com");

        //2.arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));

        //3."Samsung headphones" ile arama yapalim
        /* bu ifadeyi ramak icin "sendKeys" kullaniriz
           aramaKutusu.sendKeys("Samsung headphones");// bu sekildede yazabiliriz
           aramaKutusu.submit(); */
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        //4.bulunan sonuc sayisini yazdiralim
        //normalde xpath ile aldigimizda 23 sonuc cikti ama bana lazim olani bulup indexini yazdim
       WebElement sonucSayisi= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
       String [] sonuc=sonucSayisi.getText().split(" ");
       //1-16 of 221 results for burayi bosluklardan ayiriyorum dolayisiyla sonuc yazisi index 2
       System.out.println(sonuc[2]);
       //lambda ile boyle yapiyoruz
        Arrays.stream(sonucSayisi.getText().split(" ")).skip(2).limit(1).
                forEach(t-> System.out.println("Sonuc Sayisi "+t));


       //5.ilk urunu tiklayin
        WebElement ilkUrun=driver.findElement(By.xpath("(//*[@class='a-size-medium a-color-base a-text-normal'])[2]"));
        ilkUrun.click();

       //sayfadaki tum basliklari yazdiralim
       //basliklar "h1,h2" olarak gecer dolayisiyla basliklari "//h1" olarak alabiliriz
        List<WebElement> sayfaBasliklari =driver.findElements(By.xpath("//h1"));
       for(WebElement w:sayfaBasliklari){
           System.out.println(w.getText());
       }
        //Lambda ile yazalım
        //sayfaBasliklari.forEach(t-> System.out.println(t.getText()));

        //sayfayi kapatiniz
        driver.close();






    }
}
