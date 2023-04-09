package day10_Alert_Iframe;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class zzzzzzzzzzz extends TestBase {

    @Test
    public void sabindn() {

            driver.get("https://www.ebay.com/b/Cars-Trucks/6001/bn_1865117%22");
                    // driver.findElement(By.xpath("//[@class='b-listfooter-resetbutton b-listfooter--viewall']")).click();
                    driver.findElement(By.linkText("Audi")).click();
            driver.findElement(By.xpath("//[text()='Price']")).click();
            driver.findElement(By.xpath("//[text()='Under $15,000.00']")).click();
            driver.switchTo().frame(0);
            driver.findElement(By.xpath("//[@class='i_ div si135']")).click();



    }
}

