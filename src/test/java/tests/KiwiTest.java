package tests;

import Pages.KiwiPage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class KiwiTest {
    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    KiwiPage page = new KiwiPage();


    @Test
    public void kiwiTest() throws InterruptedException {  // uygulamanin yuklendigi dogrulanir
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"), "uygulama yuklenemedi");
        // uygulamanin basariyla acildigi dogrulanir
        String yaziTextActual = page.asAGuest.getText();
        String yaziTextExpected = "Continue as a guest";
        Assert.assertEquals(yaziTextActual, yaziTextExpected, "uygulama basarili bir sekilde baslatilamadi");
        // misafir olarak devam et e tiklanir
        page.asAGuest.click();
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        page.ucButtonTiklama(0, 3, 546, 2030, 2500);
        Thread.sleep(1000);
        page.Explore_the_App_button.click();
        // Trip type,one way olarak secilir
        page.returnButton.click();
        page.oneWay.click();
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.kalkisButonu.click();
        page.defaultUlkeSILME.click();
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        driver.getKeyboard().pressKey("izmir");
        page.izmir.click();
        page.choose.click();
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        page.toButton.click();
        Thread.sleep(1000);
        driver.getKeyboard().pressKey("Gaziantep");
        page.gaziantep.click();
        page.choose.click();
 page.departureButon.click();
 Thread.sleep(2000);
        // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(500, 1680)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).
                moveTo(PointOption.point(500, 360)).release().perform();
        Thread.sleep(3000);
        action.press(PointOption.point(123, 1413)).release().perform();

        page.setDateButon.click();
        // search butonuna tiklanir
        page.searchButon.click();
        Thread.sleep(1000);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        action.press(PointOption.point(268, 364)).release().perform();
        Thread.sleep(1000);
        action.press(PointOption.point(1005, 709)).release().perform();
        Thread.sleep(1000);
        String biletFiyati = page.ilkOptionAktarmasiz.getText();

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        driver.sendSMS("5074924284", biletFiyati);

    }


}

