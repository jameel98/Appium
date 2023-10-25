package logic.components;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.enums.EventType;
import org.openqa.selenium.By;

public class TaskType extends BaseComponent {
    private final By IMPORTANT = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[1]/android.widget.TextView");
    private final By TASK = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView");
    private final By NOT_FORGET = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.RelativeLayout[3]/android.widget.TextView");

    MobileElement important;
    MobileElement task;
    MobileElement notForget;

    public TaskType(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void clickType(EventType eventType){
        switch (eventType){
            case IMPORTANT:
                important = findWithWait(IMPORTANT);
                important.click();
                break;
            case TASK:
                task = findWithWait(TASK);
                task.click();
                break;
            case NOT_FORGET:
                notForget = findWithWait(NOT_FORGET);
                notForget.click();
                break;
        }

    }

}
