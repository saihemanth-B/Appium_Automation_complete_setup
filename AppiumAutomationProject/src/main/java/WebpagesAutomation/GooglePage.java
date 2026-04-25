package WebpagesAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasePackage.BaseClass;


/*
 * Driver Lifecycle Summary
Start → BaseClass.setUp() creates the driver.

Inheritance → Test class (FormPageTest2Website) inherits driver from BaseClass.

Injection → Driver is passed into Page Object (GooglePage) via constructor.

Usage → Page Object methods use the driver for actions (open URL, find elements).

End → BaseClass.tearDown() quits the driver after test execution.
 */

public class GooglePage extends BaseClass {

	
    private WebDriver driver;

    // Constructor connects BaseClass driver to this page object
    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator
    private By searchBox = By.name("q");

    // Actions
    public void openGoogle() {
        driver.get("https://www.google.com");
    }

    public void enterSearchQuery(String query) {
        WebElement box = driver.findElement(searchBox);
        box.sendKeys(query);
        box.submit();
    }
}
