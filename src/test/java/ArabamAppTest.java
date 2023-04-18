import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ArabamAppTest {
    AndroidDriver<AndroidElement> driver; //android cihazlarin driveri
    final  String cihazAdi="PIXEL";//final olması değiştirilememsini sağlar..
    final String platformIsmi="Android";
    final  String automation="UiAutomator2";
    final  String version="10.0";

    @BeforeTest
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazAdi);//telefonun ad
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);//version no
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation);
        capabilities.setCapability("appPackage","com.dogan.arabam");//hangi uygulama üzerinde çalışmak istedğimizi apk infodan
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        //genelde Main.Activity ya da Homepage.activity olarak apk info icersinde activities kisminda gorulur
        capabilities.setCapability(MobileCapabilityType.NO_RESET,false);//App size 'i sıfırlama sadece
        // eger false kullanirsak uygulama calistiktan sonra yapilacak adimlari gerceklestirir uygulamayi islem bittikten sonra SIFIRLAR
        // eger true olursa uygulama calistiktan sonra yapilacak adimlari gercceklestirir uygulamayi islem bittikten sonra SIFIRLAMAZ
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void arabamTest() throws InterruptedException {

        //driver.findElementByXPath("//*[@text=\"İlan ver\"]").click();
        // Arabam kac para bolumune tiklayalim
        driver.findElement(By.xpath("(//*[@text='Arabam kaç para?'])[1]")).click();
// Aracimin fiyatini merak ediyorum bolumunetiklayalim

        AndroidElement fiyatMerak =driver.findElement(By.xpath("//*[@text='Aracımın fiyatını merak ediyorum']"));
        fiyatMerak.click();
// markasini secelim
        AndroidElement searchBox=driver.findElement(By.xpath("//*[@text='Listelenenler arasında ara']"));
        searchBox.sendKeys("Volkswagen");
      //  driver.wait(1000);
        AndroidElement Wolkswagen=driver.findElement(By.xpath("(//*[@text='Volkswagen'])[2]"));
        Wolkswagen.click();

// yil secimi yapalim
        driver.findElementByXPath("//*[@text=\"2007\"]").click();

// model secimi yapalim
        driver.findElementByXPath("//*[@text=\"Passat\"]").click();
    }





}
