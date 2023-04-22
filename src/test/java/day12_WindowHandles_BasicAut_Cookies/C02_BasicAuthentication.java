
package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {
    @Test
    public void basicAuthentication() {
        /*

    Aşağıdaki bilgileri kullanarak authentication yapınız:

    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin

    Başarılı girişi doğrulayın.
     */



        //Authentication Url: "https://admin:admin@the-internet.herokuapp.com/basic_auth"

        //https://the-internet.herokuapp.com/basic_auth adresine gidiniz
        // "admin:admin@" bu ifadeyide ekleyerek "get" methodumun icerisine koyarim
        //cunku bunu yazarak guvenlik duvarini asmam gerekir
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        WebElement paragraph = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(paragraph.getText().contains("Congratulations"));
    }
}