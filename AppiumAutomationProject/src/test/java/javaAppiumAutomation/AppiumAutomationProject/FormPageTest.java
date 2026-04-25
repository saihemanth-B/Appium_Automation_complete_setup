package javaAppiumAutomation.AppiumAutomationProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

//import BasePackage.AndroidActions;
import BasePackage.BaseClass;

//driver not required 
//import io.appium.java_client.android.AndroidDriver;


/*Flow of driver
Declared in AppiumUtils.

Initialized in BaseClass.setUp() (with capabilities, app path, etc.).

Passed into AndroidActions (or other page objects) via constructor, so those classes can use the same driver session.

Used in your test classes (FormPageTest, ProductCatalogTest) through page objects.*/



public class FormPageTest extends BaseClass{
    
    //here object initialized
    //public AndroidActions Actions;  -- not required bec we are using super(driver) in formpage
    //when ever we create obj for formpage it will connect to constructor in formpage
    private FormPage fp;
    
    private ProductCatalogPage PC;
    
    
      // 2. PUT IT HERE: This runs after the server/app starts, but before the test runs
    @BeforeMethod
    public void RunBeforeTest() {
        // This 'driver' comes from the parent BfnAfclassnBfnAfmethods
        
        //form page object
        fp = new FormPage(driver); 
        
        //FormPage fp2 = new ProductCatalogPage(driver);
        
        //product page object
        //PC = new ProductCatalogPage(driver);
        //Actions = new AndroidActions(driver); 
        System.out.println("Page Object 'fp' initialized with the active driver.");
    }

        
    
    @Test(priority=6,enabled=false)
    public void login() throws InterruptedException
    {
        String title = fp.appname.getText();
        
        System.out.println("the app name is : "+title);
        
        //log.info("getting title of the application");
        
        //timer wait
        // Replace Thread.sleep with this in your Base Class or Test
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(fp.appname));

        
        //comparing the title
        Assert.assertEquals(title,"General Store","element not matched");
        //log.info("content matched , verified here");
        
        //lg.getyourname().sendKeys("krishna kumar");
        fp.getcountryname().click();
        
        Thread.sleep(3000);
        
        
        //scroll method 1
        // 2. Scroll until "India" is visible
        /*Actions.scrollToText("India"); 
        //Thread.sleep(10000); */
        
        
        //scroll method2
        fp.setcountryScroll("India");
        Thread.sleep(5000);
        
        //scrollToElementJS(selectcountry);
        
        // 3. Click the element found by scrolling
        fp.selectcountryname().click();
        
        
        String country = fp.verifycountryname().getText();
        //comparing the title
        Assert.assertEquals(country,"India","element not matched");
        //log.info("element matched  , verified here");
        Thread.sleep(3000);
        
        fp.getname("hemanth kumar b");
        
        Thread.sleep(5000);
        
        fp.getgender("female");
        Thread.sleep(3000);
    
        fp.getgender("male");
        Thread.sleep(3000);
        
        //fp.getshopbtn(); method 1
        //method 2
        //both class obj at one place -- smart way
        //ProductCatalogPage PC = fp.getshopbtn();
        PC = fp.getshopbtn();
    
        
        Thread.sleep(5000);
        
        
        
        //Product class 
        //PC.addItemToCart(); method 1

        
        //method 2
        PC.addItemToCart2(0);
        PC.addItemToCart2(0);   // ✅ fixed: previously you were adding index 0 twice
        
        Thread.sleep(5000);
        
        
        //cart CLASS 3 -- cart page
        CartPage CartP= PC.cartbtn();
        
        String cartprice = CartP.getproductprice();
        System.out.println("cart price is :"+cartprice);
        
        
        String totamt = CartP.totalAmountcal().getText();
        System.out.println(" the total amount is :"+totamt);
        
        CartP.termsbtn();
    }
 

        @Test(priority = 1)
        public void testCaseOne() {
            System.out.println("Test case 1");
        }

        @Test(priority = 2)
        public void testCaseTwo() {
        	System.out.println("Test case 2");
        }

        @Test(groups= {"hemanth"})
        public void testCaseThree() {
        	System.out.println("Test case 3");
        }

        @Test(groups= {"hemanth"})
        public void testCaseFour() {
        	System.out.println("Test case 4");
        }

        @Test(groups= {"hemanth"})
        public void testCaseFive() {
        	System.out.println("Test case 5");
        }
        

}
