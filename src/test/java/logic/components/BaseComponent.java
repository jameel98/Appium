package logic.components;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseComponent {
    protected AndroidDriver<MobileElement> driver;
    protected WebDriverWait wait;
    public BaseComponent(AndroidDriver<MobileElement> driver){
        this.driver = driver;
    }

    protected MobileElement findWithWait(By locator){
        wait = new WebDriverWait(driver, 20);
        return (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
