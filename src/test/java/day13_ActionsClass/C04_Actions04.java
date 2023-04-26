package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions04 extends TestBase {


    @Test
    public void actions() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");




        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        //ic ice cerceve oldugu icin frame kullanmaliyim
        driver.switchTo().frame(0);
        // hedefi alip ustune goturecegim iki elementinde locate'ini almam lazim
        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        //"dragAndDrop" methodu ile bir elementi bir elementin ustune ekleriz :)
        //Source(drag) webelementini alıp Target(drop) webelementinin üzerine taşır
        actions.dragAndDrop(dragSource,dropTarget).perform();
    }








    @Test
    public void actions2() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource).//Webelementi tutup bekler
                moveToElement(dropTarget).//mouse'u elementin üzerine taşır
                release().//serbest bırakır
                perform();
    }







    @Test
    public void actions3() {
        //https://jqueryui.com/droppable/ adresine gidin
        driver.get("https://jqueryui.com/droppable/");

        //"Drag me to my target" elementini "Drop here" elementi üzerine bırakınız.
        driver.switchTo().frame(0);

        WebElement dragSource = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropTarget = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.clickAndHold(dragSource). //basti bekliyor
                //locate aldigimiz kisimda manuel olarak tutup koordinatlarini belirlemeye calistigimizda
                // position diye locate kisminda bize sayilari gosteriyor
                moveByOffset(84,28).//Webelementi istediğimiz kordinata taşır
                release().perform();             // mesela tam uzerine degil biraz daha yakinina tasimak istersem falan



    }
}