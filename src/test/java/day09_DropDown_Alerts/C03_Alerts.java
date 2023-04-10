
package day09_DropDown_Alerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Alerts extends TestBase {

    /* mesala "JS" java scrip locate edilmez
       bu konunun amaci locate edemedigimiz durumlarda ne yapacagimizi gosteriyor

● accept( ) => Bir uyarıda(alert) OK'ı tıklamakla aynı.
driver.switchTo( ).alert( ).accept( );

● dismiss() => Bir uyarıda(alert) Cancel'ı tıklamakla aynı.
driver.switchTo( ).alert( ).dismiss( );

● getText() => Uyarıdaki(alert) mesajı almak için.
driver.switchTo( ).alert( ).getText( );

● sendKeys(“Text”) => Uyarı(alert) text kutusuna text göndermek için
driver.switchTo( ).alert( ).sendKeys("Text");  */




    /*
    https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
    Bir metod olusturun: acceptAlert
    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
    Bir metod olusturun: dismissAlert
    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    “successfuly” icermedigini test edin.
    Bir metod olusturun: sendKeysAlert
    3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

        @Test
        public void acceptAlert () throws InterruptedException {
            // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
            driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

            //    1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
            //“You successfully clicked an alert” oldugunu test edin.

            //birinci butona tiklayip locatesini aliyorum
            driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
            Thread.sleep(4000);

            //"tamam" butonuna kodlarla basiyorum
            driver.switchTo().//Geçmek,Değiştirmek
                    alert().//Alert'e geçiş yaptı
                    accept();//Çıkan uyarıda OK yada TAMAM butonuna basar

            //hizli gecmesin diye asagidakini yaziyorum
            Thread.sleep(4000);

            //butona bastiktan sonra yazinin olup olmadigini kontrol ediyorum
            String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
            String expectedText = "You successfully clicked an alert";
            Assert.assertEquals(expectedText, actualText);

        }

        @Test
        public void dismissAlert () throws InterruptedException {
            driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
            //    2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın

            //butona tikladim
            driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
            Thread.sleep(4000);

            //"tamam" ve "iptal"butonu ciktiginda iptal butonuna basiyorum
            driver.switchTo().alert().dismiss();

            // ve result mesajının  “successfuly” icermedigini test edin.
            // en sonuna getText() ekledim cunku yaziyi almasini istiyorum
            Thread.sleep(4000);
            String actualText = driver.findElement(By.xpath("//*[@id='result']")).getText();
            String expectedText = "successfuly";
            Assert.assertFalse(actualText.contains(expectedText));
        }


       @Test
       public void sendKeysAlert() throws InterruptedException {
       driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // 3. butona tıklayın,
        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();

        //yuyarıdaki metin kutusuna isminizi yazin, OK butonuna tiklayin
           //once ismi yazdiriyorum
           driver.switchTo().alert().sendKeys("Kubra");
           //ismi yazdirdiktan sonra tamam diyorum butona basarak
           driver.switchTo().alert().accept();
           Thread.sleep(3000);

        // result mesajında isminizin görüntülendiğini doğrulayın.
         WebElement result =driver.findElement(By.xpath("//*[@id='result']"));
        Assert.assertTrue(result.getText().contains("Kubra"));
        //ismi konsolda yazdirmak istersek
           System.out.println(result.getText());

    }

 }