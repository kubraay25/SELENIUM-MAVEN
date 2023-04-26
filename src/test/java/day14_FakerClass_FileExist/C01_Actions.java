package day14_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    @Test
    public void actions() {
        //"https://techproeducation.com/" gidin
        driver.get("https://techproeducation.com/");
        driver.findElement(By.cssSelector("i[class='eicon-close']")).click();




        // İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
        WebElement search = driver.findElement(By.xpath("//*[@type='search']"));
        Actions actions = new Actions(driver);
        // "keyDown" deyip shift'e bastim sonra yazdim sonrasinda da "sendKeys" deyip kaldirdim
        actions.keyDown(search, Keys.SHIFT).//Search üzerinde shift tuşuna basılı tutar
                sendKeys("techpro").
                keyUp(Keys.SHIFT).//shift tuşuna basma işlemi sonlanır
                sendKeys(" education",Keys.ENTER).perform();




        bekle(3);
        //Sayfayi Richmond College Enrollment Form linkine kadar scroll(indirelim) yapalım
        WebElement richmondCollege = driver.findElement(By.xpath("(//h3//a)[9]"));
        actions.scrollToElement(richmondCollege).perform();
        //scrollToElement() methodu ile locate ettiğiniz bir webelemente kadar yani o element
        // görünene kadar scroll
        //yapabilirsiniz

    }
}