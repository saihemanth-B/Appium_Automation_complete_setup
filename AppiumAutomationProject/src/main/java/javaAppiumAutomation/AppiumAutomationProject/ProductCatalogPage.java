package javaAppiumAutomation.AppiumAutomationProject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogPage extends AndroidActions {
	AndroidDriver driver;
	
	
	//second classs
	//constructor -- same class name as method name
	public ProductCatalogPage(AndroidDriver driver)
	{
		super(driver); //parent class(AndroidActions class) driver is used here- mostly used when inherited another class 
		
		//super will keep connection between parent class and child class
		this.driver=driver;
		//this will provide connection btw the class which is using by this form page object it is connected
		
		//it will constructs the below locators and methods together with driver
        // This line initializes all @FindBy elements below
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	/*
	method 1
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public WebElement product1;

	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public WebElement product2;  */
	
	//taking like list -- method 2
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	public List<WebElement> AddToCart;

	
	@FindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cartbtn;
	
	/*  method 1
	public void addItemToCart()
	{
		product1.click();
		product2.click();
		appbtn.click();
	}
	*/
	
	public void addItemToCart2(int index)
	{
		AddToCart.get(index).click();
	}
	
	public CartPage cartbtn() throws InterruptedException
	{
		cartbtn.click();
		Thread.sleep(2000);
		
		//object initiated for third class
		return new CartPage(driver);
	}
	
	
}
