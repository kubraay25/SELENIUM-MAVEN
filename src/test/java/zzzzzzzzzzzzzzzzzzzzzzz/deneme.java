package zzzzzzzzzzzzzzzzzzzzzzz;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class deneme extends TestBase {

    @Test
    public void iframe() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        String actualText=driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
        Assert.assertTrue(actualText.contains("black border"));



    }
}
