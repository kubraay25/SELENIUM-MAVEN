package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;


/* "Actions", Selenium WebDriver'da kullanılan bir sınıftır ve kullanıcının fare,
klavye veya dokunmatik ekran gibi etkileşimli öğeleri otomatik olarak çalıştırmasına
olanak tanır.

Örneğin, bir kullanıcının web sayfasında fare ile bir öğeye tıklamasını simüle etmek için
Actions sınıfı kullanılabilir. Ayrıca, bir kullanıcının bir sayfada bir metin kutusuna
yazması, sayfada kaydırması veya bir çeviriciyi açması gibi diğer etkileşimli
eylemleri de simüle edebilirsiniz. */


public class C01_Actions01 extends TestBase {

    /* EXAMPLE
    https://the-internet.herokuapp.com/context_menu  sitesine gidin
    Kutuya sağ tıklayın
    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    Tamam diyerek alert’i kapatın
     */

    @Test
    public void actions() {
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");




        //Kutuya sağ tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        //Webelemente sağ click yapabilmek için Actions class'ından obje oluşturmalıyız
        bekle(2);//testBase classından gelir

        //actions methodlarini kullanmam icin de obje olusturmam gerekir
        Actions actions = new Actions(driver);
        actions.
                contextClick(kutu).//actions objesi ile sağClick methodu olan contextClick methodunu kullanırız.
                perform();//Action'ı sonlandırmak için perform() methodunu kullanırız ve hep yazmaliyiz
        bekle(2);



        //Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alertText);
        bekle(2);





        //Tamam diyerek alert’i kapatın
        alertAccept();
    }
}