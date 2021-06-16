import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class automation {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        // The information about the device, platform and the application is defined
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME , "emulator-5554");
        dc.setCapability("platformName" , "android");
        dc.setCapability("appPackage" , "com.example");
        dc.setCapability("appActivity" , "com.example.MainActivity");

        //Android driver object and touch action for mobile testing are created
        AndroidDriver<AndroidElement> ad = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        TouchAction action = new TouchAction(ad);

        // TEST1 - INPUT VALIDATION OF TEXT BOX AREAS WITH EMPTY AND WRONG CREDENTIALS

        //Empty Credentials
        MobileElement el = (MobileElement) ad.findElementById("com.example:id/sendButton");
        el.click();
        //Wrong Credentials
        MobileElement el1 = (MobileElement) ad.findElementById("com.example:id/firstnameText");
        el1.click();
        el1.sendKeys("wrong_name/.@");
        MobileElement el2 = (MobileElement) ad.findElementById("com.example:id/surnameText");
        el2.click();
        el2.sendKeys("correctSurname");
        MobileElement el3 = (MobileElement) ad.findElementById("com.example:id/birthdateText");
        el3.click();
        el3.sendKeys("99/99/9999");


        //TEST2 - SPINNER TEST
        MobileElement el4 = (MobileElement) ad.findElementById("com.example:id/citiesSpinner");
        el4.click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement el5 = (MobileElement) ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]");
        el5.click();
        //Touch action to close the keyboard
        (new TouchAction(ad)).tap(PointOption.point(926, 2006)).perform();


        //TEST3 - RADIO BUTTON TEST
        MobileElement el7 = (MobileElement) ad.findElementById("com.example:id/femaleRadio");
        el7.click();
        MobileElement el8 = (MobileElement) ad.findElementById("com.example:id/maleRadio");
        el8.click();
        //Vaccine spinner is tested, but our second test case is already a spinner test, therefore, we didn't count this as a different test case
        MobileElement el9 = (MobileElement) ad.findElementById("com.example:id/vaccineSpinner");
        el9.click();
        TimeUnit.SECONDS.sleep(1);
        MobileElement el10 = (MobileElement) ad.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
        el10.click();
        TimeUnit.SECONDS.sleep(1);


        //TEST4 - CHECKBOX TEST
        MobileElement el11 = (MobileElement) ad.findElementById("com.example:id/feverCheckbox");
        el11.click();
        MobileElement el12 = (MobileElement) ad.findElementById("com.example:id/nauseaCheckbox");
        el12.click();
        MobileElement el13 = (MobileElement) ad.findElementById("com.example:id/painCheckbox");
        el13.click();
        MobileElement el14 = (MobileElement) ad.findElementById("com.example:id/tirednessCheckbox");
        el14.click();
        MobileElement el15 = (MobileElement) ad.findElementById("com.example:id/chillsCheckbox");
        el15.click();
        MobileElement el16 = (MobileElement) ad.findElementById("com.example:id/swellingCheckbox");
        el16.click();
        MobileElement el17 = (MobileElement) ad.findElementById("com.example:id/nauseaCheckbox");
        el17.click();
        MobileElement el18 = (MobileElement) ad.findElementById("com.example:id/chillsCheckbox");
        el18.click();
        MobileElement el19 = (MobileElement) ad.findElementById("com.example:id/swellingCheckbox");
        el19.click();
        MobileElement el20 = (MobileElement) ad.findElementById("com.example:id/nauseaCheckbox");
        el20.click();



        //TEST5 - SEND BUTTON TEST
        MobileElement el21 = (MobileElement) ad.findElementById("com.example:id/sendButton");
        el21.click();
        MobileElement el22 = (MobileElement) ad.findElementById("com.example:id/firstnameText");
        el22.click();
        el22.sendKeys("correctName");
        MobileElement el23 = (MobileElement) ad.findElementById("com.example:id/birthdateText");
        el23.click();
        el23.sendKeys("12/12/1998");
        (new TouchAction(ad)).tap(PointOption.point(926, 2006)).perform();
        MobileElement el24 = (MobileElement) ad.findElementById("com.example:id/sendButton");
        el24.click();


    }
}
