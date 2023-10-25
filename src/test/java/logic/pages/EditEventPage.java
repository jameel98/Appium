package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.enums.EventData;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditEventPage extends BaseClass{
    // Locators
    private final By DELETE_BTN = By.id("com.claudivan.taskagenda:id/item_excluir");
    private final By CONFIRM_DELETE_BTN = By.id("android:id/button1");
    private final By PERMISSION_ALLOW = By.id("com.android.permissioncontroller:id/permission_allow_button");
    private final By EDIT_BTN = By.id("com.claudivan.taskagenda:id/item_editar");
    private final By COMPLETED_CHECK = By.id("com.claudivan.taskagenda:id/cbEventoConcluido");
    private final By EVENT_TYPE = By.id("com.claudivan.taskagenda:id/tvTipo");
    private final By EVENT_NAME = By.id("com.claudivan.taskagenda:id/tvTitulo");
    private final By EVENT_DESCRIPTION = By.id("com.claudivan.taskagenda:id/tvDescricao");
    private final By EVENT_DATE = By.id("com.claudivan.taskagenda:id/tvData");
    private final By EVENT_TIME = By.id("com.claudivan.taskagenda:id/tvHora");

    // Elements
    MobileElement deleteBtn;
    MobileElement confirmDeleteBtn;
    MobileElement allowPermissionBtn;
    MobileElement editBtn;
    MobileElement completedCheck;
    MobileElement eventType;
    MobileElement eventName;
    MobileElement eventDesc;
    MobileElement eventDate;
    MobileElement eventTime;
    public EditEventPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }
    private void init() {
        deleteBtn = findWithWait(DELETE_BTN);
        editBtn = findWithWait(EDIT_BTN);
        completedCheck = findWithWait(COMPLETED_CHECK);
        eventType = findWithWait(EVENT_TYPE);
        eventName = findWithWait(EVENT_NAME);
        eventDesc = findWithWait(EVENT_DESCRIPTION);
        eventDate = findWithWait(EVENT_DATE);
        eventTime = findWithWait(EVENT_TIME);
    }
    public void clickOnDelete(){
        deleteBtn.click();
        confirmDeleteBtn = findWithWait(CONFIRM_DELETE_BTN);
        confirmDeleteBtn.click();
        allowPermissionBtn = findWithWait(PERMISSION_ALLOW);
        allowPermissionBtn.click();
    }
    public void clickOnEdit(){
        editBtn.click();
    }
    public void checkCompleted(){
        completedCheck.click();
    }
    public String getEventData(EventData requestedData){
        switch (requestedData) {
            case NAME -> {
                return eventName.getText();
            }
            case DESCRIPTION -> {
                return eventDesc.getText();
            }
            case DATE -> {
                return convertDateFormat(eventDate.getText());
            }
            case TIME -> {
                return eventTime.getText();
            }
            case TYPE -> {
                return eventType.getText();
            }
        }
        throw new IllegalArgumentException("Requested Data: "+requestedData+" NOT FOUND/HANDLED!");
    }

    private String convertDateFormat(String inputDate) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("EEE, dd MMM yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't convert the date: " + inputDate);
        }
    }
}
