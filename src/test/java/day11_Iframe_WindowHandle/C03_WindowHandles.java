package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C03_WindowHandles extends TestBase {
    @Test
    public void windowHandles() {

        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //İlk sayfanın ID'sini(Window Handle değerini) alın.
        //direkt alttaki kodu yazarim
        String ilkSayfaWindowHandle = driver.getWindowHandle();


        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        //burada xpth'i direkt "h3" tagiyla almis olduk
        WebElement sayfaTexti = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window",sayfaTexti.getText());


        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet",actualTitle);


        //"Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();







        /* (Eğer bir button'a click yaptığımızda bizim kontrolümüz dışında yeni bir pencere açılıyorsa,
         o pencere içindeki webelementleri handle edebilmem için swichtto() methodu ile geçiş yapmam gerekir
         fakat kontrolümüz dışında açıldığı için handle değerini bilmediğimiz için tüm açılan pencereleri
         getWindowHandles() methodunu kullanarak bir SET'e assing ederiz. Yada ArrayList'e assing ederiz
        "Set<String>" ifadesi su manaya gelir
        Java programlama dilinde "Set" adında bir veri yapısı vardır.
        Bu veri yapısı, aynı türden elemanları içeren bir koleksiyondur ve
        her eleman sadece bir kez bulunabilir.
        Yani, bir Set içinde her eleman benzersizdir.

        "String" ise bir veri(data) tipidir ve Java'da metinleri temsil etmek için kullanılır.
        Örneğin, bir kelime veya cümle gibi metinsel veriler String tipiyle tutulabilir.
        Dolayısıyla, "Set<String>" ifadesi, metinsel verilerin bir Set içinde saklanacağını belirtir.
        Bu Set içinde her elemanın String türünde olacağı ve her elemanın benzersiz olacağı anlamına gelir.

        "driver.getWindowHandles()" ifadesi,
        Selenium WebDriver kullanılarak bir web tarayıcısı oturumunun açık olan
        tüm pencerelerinin bir Set olarak alınmasını sağlar. Bu Set, "Set<String>" türündedir,
        yani her eleman String türündedir.)*/

        //Açılan pencereye geçin.
        Set<String> tumPenceler = driver.getWindowHandles();
   for (String w:tumPenceler) {
      if(!w.equals(ilkSayfaWindowHandle)){ //ilk pencereyi es geciyorum ve buna esit olmayan ilk pencereyi ariyorum
         driver.switchTo().window(w); //o pencereye gecis yap
       }
     }   //Burda amaç bizim kontrolümüz dışında açılan pencereye geçiş yapmak

        /* 2.YOl (hoca bu methodu daha fazla kullandigini soyledi)
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(1));
        //birinci pencere "get(0)"dir
        /ikinci pencere "get(1)"dir */





        //Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String gercekBaslik = driver.getTitle();
        Assert.assertEquals("New Window",gercekBaslik);

        String ikinciSayfaHandleDegeri = driver.getWindowHandle();

        //Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(3);
        //2. pencereye tekrar geçin.
        //bu soruyu yaparken yukariya "String ikinciSayfaHandleDegeri = driver.getWindowHandle();" bunu ekledi
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        bekle(3);
        //1. pencereye tekrar dönün.
        driver.switchTo().window(ilkSayfaWindowHandle);

    }
}