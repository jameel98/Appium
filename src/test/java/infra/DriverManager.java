package infra;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    private static AndroidDriver<MobileElement> driver;
    private static String url = "http://localhost:4723/wd/hub";

    public static AndroidDriver<MobileElement> getDriver(DesiredCapabilities capabilities){
        if (driver == null) {
            initializeDriver(capabilities);
        }
        return driver;
    }
    public static AndroidDriver<MobileElement> initializeDriver(DesiredCapabilities capabilities) {

        try {
            driver = new AndroidDriver<>(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return driver;
    }

    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
