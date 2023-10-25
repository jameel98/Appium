package logic.components;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SideMenuComponent extends BaseComponent{

    private final By ALL_EVENTS = By.xpath("");
    private final By LATE_EVENTS = By.xpath("");
    private final By COLORS = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView");
    private final By SETTINGS = By.xpath("");
    private final By ABOUT = By.xpath("");
    private final By DARK_MODE = By.id("com.claudivan.taskagenda:id/itemTemaEscuro");
    private final By ENABLED = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]");

    MobileElement colors;
    MobileElement darkMode;
    MobileElement enabled;
    public SideMenuComponent(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
    public void clickColors(){
        colors =findWithWait(COLORS);
        colors.click();
    }
    public void clickDarkMode(){
        darkMode = findWithWait(DARK_MODE);
        darkMode.click();
    }

    public void clickEnabled(){
        enabled = findWithWait(ENABLED);
        enabled.click();
    }
}
