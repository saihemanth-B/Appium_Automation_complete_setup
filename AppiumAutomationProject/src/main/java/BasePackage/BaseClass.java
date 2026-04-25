package BasePackage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass extends AppiumUtils {

    private AppiumDriverLocalService service;

    @BeforeClass
    public void startServer() {
        service = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withLogFile(new File("appium.log"))
                .build();
        service.start();
        System.out.println("Appium Server started successfully.");
    }

    @AfterClass
    public void stopServer() {
        if (service != null) {
            service.stop();
            System.out.println("Appium Server stopped.");
        }
    }
    
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Redmi 12 5G");
        options.setUdid("2e8b6190217e");
        options.setPlatformVersion("15");
        options.setAutomationName("UiAutomator2");

        
        options.setApp("C:\\Users\\user\\Desktop\\practice_apps\\General-Store (1).apk");
        // Launch ApiDemos app directly
        //options.setAppPackage("io.appium.android.apis");
        //options.setAppActivity("io.appium.android.apis.ApiDemos");

        URL serverUrl = URI.create("http://127.0.0.1:4723/").toURL();
        driver = new AndroidDriver(serverUrl, options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("ApiDemos app launched successfully!");

    }

    
    
    /*
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 5");
        options.setUdid("0A261FDD400449");
        options.setPlatformVersion("13");
        options.setAutomationName("UiAutomator2");
        //options.setApp("C:\\Users\\user\\Desktop\\practice_apps\\General-Store (1).apk");
        
        //options.setApp("C:\\Users\\user\\Downloads\\ApiDemos-debug.apk");
        // options.setAppWaitActivity("com.androidsample.generalstore.MainActivity");

        // ✅ cleaner URL usage
       // URL serverUrl = new URL("http://127.0.0.1:4723/");
        //driver = new AndroidDriver(serverUrl, options);
        ((JavascriptExecutor) driver).executeScript(
                "mobile: startActivity",
                ImmutableMap.of("intent", "io.appium.android.apis/io.appium.android.apis.ApiDemos")
            );
        
        URL serverUrl = URI.create("http://127.0.0.1:4723/").toURL();
        driver = new AndroidDriver(serverUrl, options);

     

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        

        System.out.println("App launched successfully!");
    }*/
    
    /*
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 5");
        options.setUdid("0A261FDD400449");
        options.setPlatformVersion("13");
        options.setAutomationName("UiAutomator2");

        // 🚫 Do not use setApp() if you don’t want installation
        // options.setApp("C:\\Users\\user\\Downloads\\ApiDemos-debug.apk");

        // ✅ Instead, specify package + activity
        options.setAppPackage("io.appium.android.apis"); // package name of ApiDemos
        options.setAppActivity("io.appium.android.apis.ApiDemos"); // main activity

        URL serverUrl = URI.create("http://127.0.0.1:4723/").toURL();
        driver = new AndroidDriver(serverUrl, options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("App launched successfully without reinstalling!");
    }*/


    /*  THIS IS ALSO WORKING BUT old ,related to appium 1 -- depreceted for appium 2
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel 5");
        options.setUdid("0A261FDD400449");
        options.setPlatformVersion("13");
        options.setAutomationName("UiAutomator2");
        options.setApp("C:\\Users\\user\\Desktop\\practice_apps\\General-Store (1).apk");
        options.setAppWaitActivity("com.androidsample.generalstore.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        // ✅ New way to set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("App launched successfully!");
    }*/


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver session closed.");
        }
    }
}
