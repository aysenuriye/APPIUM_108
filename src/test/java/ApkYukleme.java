import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYukleme {
    AndroidDriver<MobileElement> driver;//android cihazların driveri
    //   AppiumDriver<MobileElement>appiumDriver; //hem android hem de ios da calisir
    final  String cihazAdi="PIXEL";//final olması değiştirilememsini sağlar..
    final String platformIsmi="Android";
    final  String automation="UiAutomator2";
    final  String version="10.0";
    @Test
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities=new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazAdi);//telefonun ad
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);//version no
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation);
       capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\user\\OneDrive\\Masaüstü\\APPIUM_108\\Apps\\arabam.com_4.8.0_Apkpure.apk");

        driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

}
