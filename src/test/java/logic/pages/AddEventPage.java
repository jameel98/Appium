package logic.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import logic.components.TimePicker;
import logic.components.TaskType;
import logic.enums.EventType;
import logic.utils.Utils;
import org.openqa.selenium.By;

public class AddEventPage extends BaseClass{

    private final By NAME = By.id("com.claudivan.taskagenda:id/etTitulo");
    private final By DATE = By.id("com.claudivan.taskagenda:id/btData");
    private final By TIME = By.id("com.claudivan.taskagenda:id/btHora");
    private final By DESCRIPTION = By.id("com.claudivan.taskagenda:id/etDescricao");
    private final By TYPE = By.id("com.claudivan.taskagenda:id/tvTipo");
    private final By REMINDER = By.id("com.claudivan.taskagenda:id/btAdicionarNotificacao");
    private final By SAVE = By.id("com.claudivan.taskagenda:id/item_salvar");
    private final By NAVIGATE_BACK = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
    private final By END_TIME = By.id("com.claudivan.taskagenda:id/btAddHoraFim");
    private final By ERROR_TOAST = By.id("com.claudivan.taskagenda:id/snackbar_text");


    // Elements
    MobileElement name;
    MobileElement description;
    MobileElement save;
    MobileElement navigateBack;
    MobileElement time;
    MobileElement endTime;
    MobileElement type;
    MobileElement errorMsg;
    public AddEventPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        init();
    }

    public void init(){
        name = findWithWait(NAME);
        description = findWithWait(DESCRIPTION);
        save = findWithWait(SAVE);
        navigateBack = findWithWait(NAVIGATE_BACK);
        time = findWithWait(TIME);
        type = findWithWait(TYPE);
    }
    public String getErrorMsg(){
        errorMsg = findWithWait(ERROR_TOAST);
        return errorMsg.getText();
    }

    public void addNewEvent(String nameInput, String descriptionInput, int startHour, int startMin, int endHour, int endMin) {
        name.clear();
        name.sendKeys(nameInput);
        description.clear();
        description.sendKeys(descriptionInput);

        pickTime(startHour, startMin, endHour, endMin);

        pickType();
        save.click();
    }

    private void pickType(){
        type.click();
        TaskType taskType = new TaskType(driver);
        EventType eventType = Utils.getEventRandomType();
        taskType.clickType(eventType);
    }
    private void pickTime(int startHour, int startMin, int endHour, int endMin) {
        time.click();
        TimePicker timePicker = new TimePicker(driver);

        timePicker.clickKeyboard();
        timePicker.fillHours(String.valueOf(startHour));
        timePicker.fillMinutes(String.valueOf(startMin));
        timePicker.clickOkBtn();

        endTime = findWithWait(END_TIME);
        endTime.click();

        timePicker.clickKeyboard();
        timePicker.fillHours(String.valueOf(endHour));
        timePicker.fillMinutes(String.valueOf(endMin));
        timePicker.clickOkBtn();

    }

    public void fillName(String nameInput){
        name.clear();
        name.sendKeys(nameInput);
    }
    public void saveBtn(){
        save.click();
    }
}
