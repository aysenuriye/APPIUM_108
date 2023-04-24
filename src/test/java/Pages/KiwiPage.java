package Pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;


import java.time.Duration;

public class KiwiPage {
    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);

    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement asAGuest;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy(xpath ="//*[@text='One way']" )
    public WebElement oneWay;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement kalkisButonu;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Clear All\"]")
    public WebElement defaultUlkeSILME;

    @FindBy(xpath = "//*[@text='İzmir, Turkey']")
    public WebElement izmir;
    @FindBy(xpath = "//*[@text='To:']")
    public WebElement toButton;
    @FindBy(xpath = "//*[@text='Gaziantep, Turkey']")
    public WebElement gaziantep;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement choose;
    @FindBy(xpath = "//*[@text='Departure:']")
    private WebElement departureButon;
    public void departureButtonClick(){
        departureButon.click();
    }
    @FindBy(xpath = "//*[@text='Set date']")
    public WebElement setDateButon;
    @FindBy(xpath = "(//*[@text='Search'])[1]")
    public WebElement searchButon;
    @FindBy(xpath = "(//*[@text='Stops'])[1]")
    public  WebElement StopsButton;
   @FindBy(xpath = "(//*[@class=\"android.widget.TextView\"])[12]")
   public WebElement ticketPrice;


    @FindBy(xpath ="//*[@text='Explore the app']")
    public WebElement Explore_the_App_button;

    public static void ucButtonTiklama(int baslangic,int bitis,int xCoordinat,int yCoordinat,int wait){
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        for (int i=baslangic; i<bitis; i++){
            action.press(PointOption.point(xCoordinat,yCoordinat)).
                    waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                    .release().
                    perform();
        }
    }


}