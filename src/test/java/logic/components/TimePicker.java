package logic.components;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class TimePicker extends BaseComponent
{
    private final By SET_TIME_BY_KEYBOARD = By.id("android:id/toggle_mode");
    private final By OK_TIME_BTN = By.id("android:id/button1");
    private final By CANCEL_TIME_BTN = By.id("android:id/button2");
    private final String HOURS_LOCATOR = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"%d\"]";
    private final By HOUR_INPUT = By.id("android:id/input_hour");
    private final By MINUTES_INPUT = By.id("android:id/input_minute");

    MobileElement keyboardTime;
    MobileElement okBtn;
    MobileElement cancelBtn;
    MobileElement hours;

    MobileElement inputHour;
    MobileElement inputMinute;

    public TimePicker(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public void clickKeyboard(){
        keyboardTime = findWithWait(SET_TIME_BY_KEYBOARD);
        keyboardTime.click();
    }

    public void clickOkBtn(){
        okBtn = findWithWait(OK_TIME_BTN);
        okBtn.click();
    }

    public void clickCancelBtn(){
        cancelBtn = findWithWait(CANCEL_TIME_BTN);
        cancelBtn.click();
    }

    public void fillHours(String hour){
        inputHour = findWithWait(HOUR_INPUT);
        inputHour.sendKeys(hour);
    }
    public void fillMinutes(String minute){
        inputMinute = findWithWait(MINUTES_INPUT);
        inputMinute.sendKeys(minute);
    }



}
