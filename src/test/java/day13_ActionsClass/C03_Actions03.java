package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions03 extends TestBase {
    @Test
    public void actions() {
        //https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();





        //Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);
        //page_down sayfanin alt tarafina iner
        //surekli indirme yapiyoruz
        //dolayisiyla bu islemi surekli yaziyoruz manuel olarak bakariz ne kadar indirmemiz gerektigine
        //arrow page gore daha az indirir
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();




        //Sayfanın üst tarafına gidin
        bekle(2);
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
    }





    @Test
    public void actions2() {
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);
        //Sayfanın üst tarafına gidin
        bekle(4);
        //home tusu bir sayfada en uste gitmek icin kullanilir
        //build() methodu ile birden fazla isleri zincir halinde birbirine baglayabiliriz
        //mesela bir suru send keys methodu yazarim yazarim en sonda build yapip hepsini birbirine baglarim
        //perform() ile action objemi işleme alıyorum bir nevi methodlari calistiriyorum
        //builde baglayacaksam methodlarin hepsinin sonuna "perform" yazmam en son yazarim
        actions.sendKeys(Keys.HOME).build().perform();

    }




    @Test
    public void actions3() {
        //Amazon anasayfasına gidin
        driver.get("https://amazon.com");


        //Arama kutusunda büyük harflerle samsung aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //"shift" tusuna basili tuttugumuzda buyuk yazdirir "sa"yi buyuk yazdiracak
        //elimi sihift ten kaldirdigimda da yine Keys Shift yaziyorum
        aramaKutusu.sendKeys(Keys.SHIFT,"sa",Keys.SHIFT,"msung",Keys.ENTER);//SAmsung
        //geri geliyorum arama kutusuna tekrardan "iphone" yazdiriyorum
        driver.navigate().back();
        WebElement aramaKutusuu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuu.sendKeys(Keys.SHIFT,"iphone");//IPHONE


//        //SHIFT kullanmadan da asagida ki gibi yapabiliriz
//            WebElement aramaKutusu1 = driver.findElement(By.id("twotabsearchtextbox"));
//                aramaKutusu1.sendKeys("SAMSUNG", Keys.ENTER);
//
//              driver.navigate().back();
//
//             WebElement aramaKutusuu1 = driver.findElement(By.id("twotabsearchtextbox"));
//              aramaKutusuu1.sendKeys("IPHONE", Keys.ENTER);
//           // Burada, sendKeys() yöntemi kullanılarak ilk önce "SAMSUNG" ve "IPHONE"
//           // metinleri doğrudan gönderildi. shift tuşu kullanımına gerek kalmadı.









    }
}