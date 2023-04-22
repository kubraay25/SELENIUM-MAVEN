
package day12_WindowHandles_BasicAut_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {
    @Test
    public void cookies() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        //TÜM COOKIE'LERI LİSTELEYEBİLMEK İÇİN driver.manage().getCookies() METHODUNU KULLANIRIZ
        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac=1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac+ ".ci cookie: "+w );
            System.out.println("Name : "+w.getName());
            System.out.println("Value : "+w.getValue());
            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        // cookies sayisina locate aldigimiz yerden bakiyoruz
        //"uygulamalar" kismindan tikliyoruz
        int cookieSayisi = cookieSet.size();
        Assert.assertTrue(cookieSayisi>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String cookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        /*
        Name : i18n-prefs
        Value : USD
        String cookieValue = --> USD
         */
        Assert.assertEquals("USD",cookieValue);
        /*
        for (Cookie each:cookieSet) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",cookieValue);
            }
        }
         */

        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();
        sayac=1;
        for (Cookie cookie1:cookieSet) {
            System.out.println(sayac+ ".ci cookie: "+cookie1);
            sayac++;
        }

        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        int silinmedenOnce = driver.manage().getCookies().size();
        driver.manage().deleteCookieNamed("skin");
        int silindiktenSonra = driver.manage().getCookies().size();
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));
        //Assert.assertFalse(cookieSet.contains("skin"));
        cookieSet = driver.manage().getCookies();
        sayac=1;
        for (Cookie cookie1:cookieSet) {
            System.out.println(sayac+ ".ci cookie: "+cookie1);
            sayac++;
        }

        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookieSet = driver.manage().getCookies();
        Assert.assertTrue(cookieSet.isEmpty());
    }
}