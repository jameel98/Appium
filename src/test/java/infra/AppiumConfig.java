package infra;

import io.appium.java_client.remote.MobileCapabilityType;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;

public class AppiumConfig {

    private static JSONParser parser = new JSONParser();
    private static JSONObject jsonConfig;

    static {
        try {
            jsonConfig = (JSONObject) parser.parse(new FileReader("src/test/java/infra/appium_config.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static DesiredCapabilities configuration(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, jsonConfig.get("deviceName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, jsonConfig.get("platformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, jsonConfig.get("platformVersion"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, jsonConfig.get("automationName"));
        capabilities.setCapability("appPackage", jsonConfig.get("appPackage"));
        capabilities.setCapability("appActivity", jsonConfig.get("appActivity"));

        return capabilities;
    }
}
