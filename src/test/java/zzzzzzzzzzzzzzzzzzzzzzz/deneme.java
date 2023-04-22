package zzzzzzzzzzzzzzzzzzzzzzz;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class deneme extends TestBase {

    @Test
    public void iframe() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        String actualText=driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actualText.contains("black border"));
         driver.switchTo().frame(0);
        String  actualtext02=driver.findElement(By.xpath("//*[text()='Applications lists']")).getText();
        Assert.assertEquals(actualtext02,"Applications lists");
         driver.switchTo().defaultContent();
        WebElement yazi=driver.findElement(By.xpath("//*[text()='Povered By'][1]"));
        Assert.assertTrue(yazi.getText().contains("Povered By"));



    }
}
