package BasePackage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import io.appium.java_client.android.AndroidDriver;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class AppiumUtils {
	
	
	/*Flow of driver
Declared in AppiumUtils.

Initialized in BaseClass.setUp() (with capabilities, app path, etc.).

Passed into AndroidActions (or other page objects) via constructor, so those classes can use the same driver session.

Used in your test classes (FormPageTest, ProductCatalogTest) through page objects.*/

	//main reference of the driver --born here 
    protected AndroidDriver driver;   // ✅ keep driver protected so subclasses can use it

    // ✅ no‑arg constructor (TestNG friendly)
    public AppiumUtils() {
    }

    public void hemanth() {
        System.out.println("hello");
    }

    public Double getformateAmount(String amount) {
        return Double.parseDouble(amount.substring(1));
    }

    public void waitForElementToApper(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(ele, "text", "Cart"));
    }
    
    
    //json file data to read --taking file as input from apidemos.json file

    public static List<HashMap<String, String>> getJsonData(String filePath) throws IOException {
        // Wrap the path string in a File object
        File file = new File(filePath);

        // Read file content as String with UTF-8 encoding
        String jsonContent = FileUtils.readFileToString(file, StandardCharsets.UTF_8);

        // Parse JSON into List<HashMap<String, String>>
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(
            jsonContent,
            new TypeReference<List<HashMap<String, String>>>() {}
        );

        return data;
    }


    

 /*   public static List<Map<String, String>> getTestData(String filePath) throws IOException {
        FileReader reader = new FileReader(filePath);
        Gson gson = new Gson();
        List<Map<String, String>> data = gson.fromJson(reader, new TypeToken<List<Map<String, String>>>(){}.getType());
        reader.close();
        return data;
    }*/
}


