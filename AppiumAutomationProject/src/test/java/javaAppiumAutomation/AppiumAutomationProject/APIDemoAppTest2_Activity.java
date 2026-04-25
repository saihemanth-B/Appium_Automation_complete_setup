package javaAppiumAutomation.AppiumAutomationProject;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;

import org.openqa.selenium.JavascriptExecutor; 
import com.google.common.collect.ImmutableMap;

public class APIDemoAppTest2_Activity extends BaseClass {

    private FormPage fp;
    private ProductCatalogPage PC;

    @BeforeMethod
    public void prepareTest() {
        // Step 1: Initialize FormPage after app launch
        //fp = new FormPage(driver);
        
    	((JavascriptExecutor) driver).executeScript( "mobile: startActivity", ImmutableMap.of( "intent", "io.appium.android.apis/io.appium.android.apis.preference.AdvancedPreferences" ) );

        // ✅ Initialize ProductCatalogPage directly since we jumped into AllProductsActivity
        PC = new ProductCatalogPage(driver);

        System.out.println("FormPage initialized with active driver.");
    }

    @Test
    public void addItemsToCartTest() throws InterruptedException {
        // Step 2: Fill form details (skipped because we jumped directly into ProductCatalogActivity)
        /* fp.getname("sai kumar");
           fp.getgender("Male");
           fp.getcountryname().click();
           fp.setcountryScroll("India");
           fp.selectcountryname().click();
           PC = fp.getshopbtn(); */
        
        System.out.println("Navigated to Product Catalog page.");

        // Step 4: Wait until product list is visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOfAllElements(PC.productList));

        // Safety check
        //Assert.assertFalse(PC.productList.isEmpty(), "Product list is empty!");

        // Step 5: Add items to cart
        
        /*
        PC.addItemToCart2(0);
        PC.addItemToCart2(1);   // ✅ fixed: add a different item
        Thread.sleep(3000);

        // Step 6: Navigate to CartPage
        CartPage cartPage = PC.cartbtn();

        // Step 7: Verify product price and total amount
        String cartPrice = cartPage.getproductprice();
        System.out.println("Cart price is: " + cartPrice);

        String totalAmount = cartPage.totalAmountcal().getText();
        System.out.println("Total amount is: " + totalAmount);

        //Assert.assertTrue(totalAmount.contains(cartPrice), "Total does not match cart price");

        // Step 8: Accept terms
        cartPage.termsbtn();
        */
    }
}
