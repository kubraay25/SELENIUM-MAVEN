package day08_Assertion_DropDown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C02_DropDown {
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

        WebElement yil=driver.findElement(By.id("//*[@id='year']"));
        /* "yil" DropDownimi handle edicem ve select classimdan bir obje olusturucam bu olusturmus oldugum  yil webelementini
        select objemin icine koymus olucam */
        Select select = new Select(yil);
        select.deselectByIndex(22);

//       git init
//        git add README.md
//        git commit -m "first commit"
//        git branch -M main
//        git remote add origin https://github.com/kubraay25/SELENIUM-MAVEN.git
//        git push -u origin main
//



    }

    @Test
    public void test02() {
    }

    @Test
    public void test03() {
    }
}
