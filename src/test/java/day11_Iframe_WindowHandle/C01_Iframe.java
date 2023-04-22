package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
   https://the-internet.herokuapp.com/iframe sayfasına gidiniz
   Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
   Textbox içindeki yazıyı siliniz.
   Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
   Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
    */

    @Test
    public void iframe() {
        //EXAMPLE 1: https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");


        //EXAMPLE 2:Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        WebElement baslikElementi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.getText().contains("Editor"));
        bekle(2);


        //EXAMPLE 3: Textbox içindeki yazıyı siliniz.
        //sayfa icindeki sayfada oldugu icin oncelikle iframe ye girmem gerekir
        driver.switchTo().frame(0);
        WebElement textbox = driver.findElement(By.xpath("//p"));
        textbox.clear();//Textbox içindeki yazıyı sileriz
        bekle(2);

        //EXAMPLE 4: Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        bekle(2);

        //EXAMPLE 5: Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        //girdigim sayfanın bir onceki sayfasında oldugu icin o sayfadan cıkmam lazım
        driver.switchTo().defaultContent();
        //driver.switchTo().parentFrame();
        //driver.navigate().refresh();
        // Bu methodla sayfayı yenilediğimiz için ilk bölüme tekrar geçmiş oluruz
        //kisacasi bu methodlar birbirinin yerine kullanilabilirler
        bekle(2);
        WebElement elementalSeleniumWE = driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSeleniumWE.isDisplayed());

    }
}