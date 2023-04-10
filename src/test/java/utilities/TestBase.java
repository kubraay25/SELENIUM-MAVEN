package utilities;

import com.fasterxml.jackson.databind.ser.std.StdKeySerializers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class TestBase {
    //abstract etmek zorunda degilim
    //WebDriver'imi burada tanimladim arik direkt driver.get() seklinde kullanabilecegim
    //TestBase class'indan obje olusturmanin onune gecilmesi icin abstract yapilabilir
    //Orn: TestBase = new TestBase
    //Bu class'i extend ettigimiz test classlarinda driver'a direk ulasabiliriz.
    protected static WebDriver driver;

    @Before
    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //  Thread.sleep(3000);
        //driver.quit();
    }

    //HARD WAIT METHOD
    //biz bu bekle methodunu istedigimiz yerde rahatlikla kullanabilecegiz
    //ve her saniyesinde exception firlatmasin diye "try catch" blogu icine aliyorum
    //exception attiginda sürekli ugrasmaktansa yani altinin kirmizi yanmasindansa
    //burada hallediyorum ki baska yerlerde ugrasmayayim
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //buraya method yukluyorum ve bir guzellll baska classlarimda kullaniyorum
    //Alert ACCEPT
    public static void alertAccept() {
        driver.switchTo().alert().accept();
    }

    //Alert DISMISS
    public static void alertDismiss() {
        driver.switchTo().alert().dismiss();
    }

    //Alert getText()
    public static void alertText() {
        driver.switchTo().alert().getText();
    }

    //Alert promptBox
    public static void alertprompt(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");

        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm, String secenek) {
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);


    }
    //DropDown Index
    public static void ddmIndex(WebElement ddm, int index){
        Select select =  new Select(ddm);
        select.selectByIndex(index);

    }
    //DropDown Value
    public static void ddmValue(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }

    //SwitchToWindow
    public static void switchToWindow(int sayi){
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(sayi));
    }
    //SwitchToWindow2
    public static void window(int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }
}