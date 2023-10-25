package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.components.NewEventComponent;
import logic.components.SideMenuComponent;
import org.openqa.selenium.By;

public class MainPage extends BaseClass {

    //locators

    private final By WEEK_TAP = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[1]");
    private final By CALENDAR = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.TextView[2]");
    private final By SIDE_MENU = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ImageView");
    private final By NEXT = By.xpath("(//android.widget.ImageButton[@content-desc=\"Image\"])[2]");
    private final By PREVIOUS = By.xpath("(//android.widget.ImageButton[@content-desc=\"Image\"])[1]");
    private final By NEW_EVENT = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.ImageButton");
    private final By PENDING_EVENT = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/android.widget.RelativeLayout/android.widget.Button");

    private MobileElement weekTap;
    private MobileElement calendar;
    private MobileElement sideMenu;
    private MobileElement next;
    private MobileElement previous;
    private MobileElement newEvent;
    private MobileElement pendingEvent;

    static AddEventPage addEventPage;
    EditEventPage editEventPage;

    public MainPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }
    private void init(){
        weekTap = findWithWait(WEEK_TAP);
        calendar = findWithWait(CALENDAR);
        sideMenu = findWithWait(SIDE_MENU);
        next = findWithWait(NEXT);
        previous = findWithWait(PREVIOUS);
        newEvent = findWithWait(NEW_EVENT);
        pendingEvent = findWithWait(PENDING_EVENT);
        addEventPage = new AddEventPage(driver);

    }

    public void clickWeekTap(){
        weekTap.click();
    }
    public void clickCalendar(){
        calendar.click();
    }
    public void clickSideMenu(){
        sideMenu.click();
    }
    public void clickNextBtn(){
        next.click();
    }
    public void clickPrevBtn(){
        previous.click();
    }
    public void clickNewEvent(){
        newEvent.click();
    }
    public void clickPendingEvent(){
        pendingEvent.click();
    }

    public String pendingEventGetText(){
        return pendingEvent.getText();
    }
    public void addNewEventTomorrow(String nameInput, String descriptionInput, int startHour, int startMin, int endHour, int endMin){
        NewEventComponent newEventComponent = new NewEventComponent(driver);
        newEventComponent.clickTomorrow();
        addEventPage.addNewEvent( nameInput,  descriptionInput,  startHour,  startMin,  endHour,  endMin);

    }
    public void enableDarkMode(){
        SideMenuComponent sideMenuComponent = new SideMenuComponent(driver);
        sideMenuComponent.clickColors();
        sideMenuComponent.clickDarkMode();
        sideMenuComponent.clickEnabled();
    }
    public void clickOnEventByName(String eventName) {
        scrollAndGetElementByName(eventName).click();
        editEventPage = new EditEventPage(driver);
    }

    public static AddEventPage getAddEventPage() {
        return addEventPage;
    }

    public EditEventPage getEditEventPage() {
        return editEventPage;
    }
}
