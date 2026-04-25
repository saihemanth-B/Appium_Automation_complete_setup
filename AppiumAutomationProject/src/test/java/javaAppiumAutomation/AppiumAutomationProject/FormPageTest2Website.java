package javaAppiumAutomation.AppiumAutomationProject;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Basics.BaseClass;
import WebpagesAutomation.GooglePage;

public class FormPageTest2Website extends BaseClass {
	GooglePage gle;
	
	  @BeforeMethod
	    public void RunBeforeTest() {
	       
		  
		     gle = new GooglePage(driver);
	        System.out.println("Page Object 'gle' initialized with the active driver.");
	    }

    @Test(priority = 1)
    @Parameters({"searchQuery"})
    public void googleSearch(String searchQuery) throws InterruptedException {
        //GooglePage google = new GooglePage(driver);  // connection here
        gle.openGoogle();
        Thread.sleep(5000);
        gle.enterSearchQuery(searchQuery);
        Thread.sleep(5000);
        System.out.println("Search completed for: " + searchQuery);
    }
}
