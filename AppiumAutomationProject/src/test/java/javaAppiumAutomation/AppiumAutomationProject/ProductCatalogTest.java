package javaAppiumAutomation.AppiumAutomationProject;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePackage.BaseClass;

public class ProductCatalogTest extends BaseClass {


	private FormPage fp;
    private ProductCatalogPage PC;

    @BeforeMethod
    public void prepareTest() {
        // Step 1: Initialize FormPage after app launch
        fp = new FormPage(driver);
        System.out.println("FormPage initialized with active driver.");
    }

    @Test
    public void addItemsToCartTest() throws InterruptedException {
        // Step 2: Fill form details
        fp.getname("sai kumar");
        Thread.sleep(3000);
        fp.getgender("Male");
        Thread.sleep(3000);
        fp.getcountryname().click();
        fp.setcountryScroll("India");
        fp.selectcountryname().click();

        // Step 3: Navigate to ProductCatalogPage
        PC = fp.getshopbtn();
        System.out.println("Navigated to Product Catalog page.");

        // Step 4: Wait until product list is visible
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfAllElements(PC.productList));

        // Safety check
      //  Assert.assertFalse(PC.productList.isEmpty(), "Product list is empty!");

        // Step 5: Add items to cart
        PC.addItemToCart2(0);
        PC.addItemToCart2(0);
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
    }
}
