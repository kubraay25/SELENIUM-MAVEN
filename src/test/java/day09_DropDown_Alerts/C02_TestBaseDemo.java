
package day09_DropDown_Alerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_TestBaseDemo extends TestBase {
//    @Test
//    public void test01() {
//        //Techproeducation sayfasına gidelim
//        driver.get("https://techproeducation.com");
//        //Başlığın "Bootcamp" içerdiğini test edelim
//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Bootcamp";
//        Assert.assertTrue(actualTitle.contains(expectedTitle));
//
//    }

    @Test
    public void sahibinden() {

        driver.get("http://www.sahibinden.com");

        driver.findElement(By.id("searchText")).sendKeys("otomobil", Keys.ENTER);

        WebElement otomobil = driver.findElement(By.xpath("//a[@title='Otomobil']"));
        otomobil.click();

        driver.findElement(By.linkText("Audi")).click();
        driver.findElement(By.linkText("A5")).click();
        WebElement aramaButonu = driver.findElement(By.xpath("//*[@class='faceted-select']"));

        aramaButonu.sendKeys(Keys.SHIFT, "Antalya", Keys.ENTER);
        WebElement istedigimIliSec = driver.findElement(By.xpath("(//*[@class='noChild facetedCheckbox'])[12]"));

        istedigimIliSec.sendKeys("Antalya" + Keys.ENTER);


    }

}