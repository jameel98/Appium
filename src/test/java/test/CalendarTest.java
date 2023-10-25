package test;

import infra.AppiumConfig;
import infra.DriverManager;
import jdk.jfr.Description;
import logic.context.TestContext;
import logic.enums.EventData;
import logic.pages.MainPage;
import logic.utils.Utils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.logging.LogType.DRIVER;

public class CalendarTest {
    private TestContext context;
    private MainPage mainPage;

    String NO_PENDING_EVENT = "NO PENDING EVENT";
    String ONE_PENDING_EVENT = "1 PENDING EVENT";
    String TWO_PENDING_EVENT = "2 PENDING EVENTS";
    @BeforeEach
    public void setUp() {
        context = new TestContext();
        context.put(DRIVER, DriverManager.getDriver(AppiumConfig.configuration()));
        mainPage = new MainPage(context.get(DRIVER));
    }

    @AfterEach
    public void tearDown() {
        context = null;
        DriverManager.quitDriver();
    }

    @Test
    @Description("add new event for tomorrow and validate it added")
    public void addNewEventTomorrow(){
        //Arrange
        mainPage.clickNewEvent();
        //Act
        mainPage.addNewEventTomorrow(Utils.getEventName(), Utils.getEventDescription(), Utils.getStartHour(), Utils.getStartMinute()
                                     , Utils.getEndHour(), Utils.getEndMinute());
        //Assert
        assertEquals(ONE_PENDING_EVENT, mainPage.pendingEventGetText());

    }
    @Test
    @Description("add new event without name and validate it didn't add and showed error message")
    public void addNewEventWithOutName(){
        //Arrange
        mainPage.clickNewEvent();
        //Act
        mainPage.addNewEventTomorrow("", Utils.getEventDescription(), Utils.getStartHour(), Utils.getStartMinute()
                , Utils.getEndHour(), Utils.getEndMinute());
        //Assert
        assertEquals("Highlighted fields are mandatory", MainPage.getAddEventPage().getErrorMsg());
    }
    @Test
    @Description("add new event without wrong time and validate it didn't add and showed error message")
    public void addNewEventWithWrongTime(){
        //Arrange
        mainPage.clickNewEvent();
        //Act
        mainPage.addNewEventTomorrow(Utils.getEventName(), Utils.getEventDescription(), Utils.getEndHour(), Utils.getStartMinute()
                , Utils.getStartHour(), Utils.getEndMinute());
        //Assert
        assertEquals("End time cannot be earlier than start time", MainPage.getAddEventPage().getErrorMsg());

    }

    @Test
    public void addMultipleEventsValidateCounter(){
        //Arrange
        mainPage.clickNewEvent();
        mainPage.addNewEventTomorrow(Utils.getEventName(), Utils.getEventDescription(), Utils.getStartHour(), Utils.getStartMinute()
                , Utils.getEndHour(), Utils.getEndMinute());
        //Act
        mainPage.clickNewEvent();
        mainPage.addNewEventTomorrow(Utils.getEventName(), Utils.getEventDescription(), Utils.getStartHour(), Utils.getStartMinute()
                , Utils.getEndHour(), Utils.getEndMinute());

        //Assert
        assertEquals(TWO_PENDING_EVENT, mainPage.pendingEventGetText());

    }
    @Test
    public void editEvent(){
        //Arrange
        mainPage.clickNewEvent();
        mainPage.addNewEventTomorrow(Utils.getEventName(), Utils.getEventDescription(), Utils.getStartHour(), Utils.getStartMinute()
                , Utils.getEndHour(), Utils.getEndMinute());

        mainPage.clickPendingEvent();

        String eventName = "Party";

        mainPage.getEditEventPage().clickOnEdit();
        mainPage.getAddEventPage().fillName(eventName);
        mainPage.getAddEventPage().saveBtn();
        // Act
        mainPage.clickOnEventByName(eventName);
        // Assert
        assertEquals(eventName, mainPage.getEditEventPage().getEventData(EventData.NAME));
    }

    @Test
    public void removeEvent(){
        //Arrange
        mainPage.clickNewEvent();
        mainPage.addNewEventTomorrow(Utils.getEventName(), Utils.getEventDescription(), Utils.getStartHour(), Utils.getStartMinute()
                , Utils.getEndHour(), Utils.getEndMinute());

        mainPage.clickPendingEvent();
        //Act
        mainPage.getEditEventPage().clickOnDelete();

        //Assert
        assertEquals(NO_PENDING_EVENT, mainPage.pendingEventGetText());

    }

    @Test
    public void enableDarkMode(){
        //Arrange
        mainPage.clickSideMenu();

        //Act
        mainPage.enableDarkMode();

        //Assert
    }
}