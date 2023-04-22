package tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamAppTest {
    AndroidDriver<AndroidElement> driver; //android cihazlarin driveri
    final String cihazAdi = "PIXEL";//final olması değiştirilememsini sağlar..
    final String platformIsmi = "Android";
    final String automation = "UiAutomator2";
    final String version = "10.0";

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, cihazAdi);//telefonun ad
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);//version no
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation);
        capabilities.setCapability("appPackage", "com.dogan.arabam");//hangi uygulama üzerinde çalışmak istedğimizi apk infodan
        capabilities.setCapability("appActivity", "com.dogan.arabam.presentation.feature.home.HomeActivity");
        //genelde Main.Activity ya da Homepage.activity olarak apk info icersinde activities kisminda gorulur
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);//App size 'i sıfırlama sadece
        // eger false kullanirsak uygulama calistiktan sonra yapilacak adimlari gerceklestirir uygulamayi islem bittikten sonra SIFIRLAR
        // eger true olursa uygulama calistiktan sonra yapilacak adimlari gercceklestirir uygulamayi islem bittikten sonra SIFIRLAMAZ
        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest() throws InterruptedException {

            // driver.findElement(By.xpath("//*[@text='İlan ver']")).click();
            // Arabam kac para bolumune tiklayalim
            driver.findElement(By.xpath("(//*[@text='Arabam kaç para?'])[1]")).click();
            // Aracimin fiyatini merak ediyorum bolumunetiklayalim
            AndroidElement fiyatMerak =driver.findElement(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']"));
            fiyatMerak.click();
            // Wolkswagen markasini secelim
            Thread.sleep(3000);
            TouchAction action=new TouchAction<>(driver);

            action.press(PointOption.point(542,2081)).
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                    moveTo(PointOption.point(550,600)).release().perform();
        action.press(PointOption.point(542,2081)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                moveTo(PointOption.point(550,600)).release().perform();

            Thread.sleep(1000);
            driver.findElementByXPath("//*[@text='Volkswagen']").click();
     /*
         action.press(PointOption.point(537,381)).
                 waitAction(WaitOptions.waitOptions(Dration.ofMillis(500))).
                 moveTo(PointOption.point(543,1732)).release().perform();
           Eger ki bizler daha onceden kaydirma islemi gerceklestirmissek tam tersi haraketini gerceklestirmek icin yazdigimiz
           koordinat degerlerini tam tersi olacak sekilde yazmak o islemin zittini gerceklestirir.
      */

            // yil secimi yapalim
            driver.findElementByXPath("//*[@text='2011']").click();
            // model secimi yapalim
            driver.findElementByXPath("//*[@text='Passat']").click();
            // govde tipini secelim
            driver.findElementByXPath("//*[@text='Sedan']").click();
            // yakit tipini secelim
            driver.findElementByXPath("//*[@text='Benzin']").click();
            // vites tipini secelim
            driver.findElementByXPath("//*[@text='Yarı Otomatik']").click();
            // Versiyon secimi yapalim
            Thread.sleep(3000);
          driver.findElementById("com.dogan.arabam:id/tvModelName").click();
            // aracin km bilgilerini girelim
            if (driver.isKeyboardShown()){
                driver.getKeyboard().pressKey("190000");
            }
            else {
                driver.findElementById("com.dogan.arabam:id/et_km").sendKeys("150000");
            }
            driver.findElementById("com.dogan.arabam:id/btn_price_prediction_submit").click();
            // aracin rengini secelim
            driver.findElementByXPath("//*[@text='Gri (metalik)']").click();
            // opsiyel donanim (varsa) seecelim
            driver.findElementById("com.dogan.arabam:id/btnNext").click();
            // degisen bilgisi ekleyerek tramer kaydi belirtelim
            AndroidElement kaput=driver.findElementById("com.dogan.arabam:id/iv_B01001");
            kaput.click();
            Thread.sleep(1000);
            driver.findElementByXPath("(//*[@text='Boyalı'])[2]").click();
            Thread.sleep(1000);
            driver.findElementById("com.dogan.arabam:id/btn_next").click();
            // tramer kaydi yok kismina tiklayalim
            driver.findElementById("com.dogan.arabam:id/rbHasNoTramerEntry").click();
            driver.findElementById("com.dogan.arabam:id/btnNext").click();
            // aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
            String avaragePrice= driver.findElementById("com.dogan.arabam:id/tvAveragePrice").getText();
            //588.500 TL
            String lastPrice=avaragePrice.replaceAll("\\D","");
            Assert.assertTrue(Integer.parseInt(lastPrice)>500000);

            // uygulamayi kapatalim
            driver.closeApp();

        }
    }