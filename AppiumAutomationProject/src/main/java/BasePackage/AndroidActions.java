package BasePackage;

import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions extends AppiumUtils {

    // constructor: just set driver directly
    public AndroidActions(AndroidDriver driver) {
        this.driver = driver;   // ✅ use inherited driver from AppiumUtils
    }

    @Override
    public void hemanth() {
        super.hemanth();
        System.out.println("hello from child class");
    }

    public WebElement scrollToText(String text) {
        return driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
            ".scrollIntoView(new UiSelector().text(\"" + text + "\"))"
        ));
    }

    public void scrollUp(int steps) {
        driver.findElement(AppiumBy.androidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
            ".scrollBackward(" + steps + ")"
        ));
    }
}
