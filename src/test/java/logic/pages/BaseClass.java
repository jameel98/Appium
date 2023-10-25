package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseClass {

    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;
    public BaseClass(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }

    protected MobileElement findWithWait(By locator){
        wait = new WebDriverWait(driver, 20);
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected MobileElement scrollAndGetElementByName(String name) {
        return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + name + "\").instance(0))");
    }
}
