package day08_Assertion_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    //bir secenek var aklimiza boyle gelebilir
    //hemen ardindan select
/*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
        3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
     */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(3000);
       // driver.close();
    }

    @Test
    public void test01() {

        // 1. Method:
        // a. Yil,ay,gün dropdown menu'leri locate ediniz
        // b. Select objesi olustur
        // c. Select object i kullaarak 3 farkli sekilde secim yapiniz

        //***********// YIL BOLUMUNE BAKALIM
        WebElement yil=driver.findElement(By.xpath("//*[@id='year']"));
        /* "yil" DropDownimi handle edicem ve select classimdan bir obje olusturucam bu olusturmus oldugum  yil webelementini
        select objemin icine koymus olucam */

        Select select = new Select(yil);
        select.selectByIndex(5);//index 0'dan baslar dolayisiyla 6.yi aldi
        //yil.sendKeys("2018"); //bu sekilde de yazabiliriz
        //driver.findElement(By.xpath("//*[@value='2016']")).click(); sadece bu sekilde bile yazabiliriz

        //*************// AY BOLUMUNE BAKALIM
        WebElement ay=driver.findElement(By.xpath("//*[@id='month']"));
        Select select1=new Select(ay);
        select1.selectByVisibleText("May");
        //select1.selectByIndex(5); bu sekildede yapabilirim
        //ay.sendKeys("5"); bu sekildede yapabilirim

        //***********// GUN BOLUMUNE BAKALIM
        WebElement gun=driver.findElement(By.xpath("//*[@id='day']"));
        Select select2= new Select(gun);
        select2.selectByVisibleText("6");// saturdey yerine rakamda yaxzabilirim mesela "6" gibi





    }

    @Test
    public void test02() {
        // 2.Method:
        // a. Tüm eyalet isimlerini yazdıralım
        WebElement tumEyaletler=driver.findElement(By.cssSelector("select[id='state']"));
        Select select=new Select(tumEyaletler);
        //simdi bunlaribir liste atalim.
        List<WebElement> stateList=select.getOptions();
        for(WebElement w:stateList){
            System.out.println(w.getText());
        }
        //birde bunu lambda ile yazdiralim
        //stateList.stream().forEach(t-> System.out.println(t.getText()));


    }

    @Test
    public void test03() {
        /* 3.Method:
           a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
           "burda ilk olarak yapacagimiz sey options ile tum sectiklerimizi once yazmak sonra ilk siradakini secmek
           cunku secili seceneklerde "Select a State" ilk siradadir. yani burada olay once listele sonra ilkini al. */
        //oncelikle tum listeyi lokate edelim
        WebElement tumEyaletler=driver.findElement(By.cssSelector("select[id='state']"));
        // Select classindan tekrardan objemi olusturayim
        // getFirstSelectedOption() methodu son secilen optionu verir
        Select select= new Select(tumEyaletler);
        String sonSecilenText=select.getFirstSelectedOption().getText();
        System.out.println(sonSecilenText);
        Assert.assertEquals("Select a State",sonSecilenText);


    }
}
