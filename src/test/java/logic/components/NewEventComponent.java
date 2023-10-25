package logic.components;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class NewEventComponent extends BaseComponent {

    private final By TODAY = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]");
    private final By TOMORROW = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");
    private final By OTHER = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");

    private MobileElement today;
    private MobileElement tomorrow;
    private MobileElement other;

    public NewEventComponent(AndroidDriver<MobileElement> driver){
        super(driver);
        init();
    }
    private void init(){
        today = findWithWait(TODAY);
        tomorrow = findWithWait(TOMORROW);
        other = findWithWait(OTHER);
    }
    public void clickToday(){
        today.click();
    }
    public void clickTomorrow(){
        tomorrow.click();
    }
    public void clickOther(){
        other.click();
    }
}
