package javaAppiumAutomation.AppiumAutomationProject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions {
	AndroidDriver driver;
	
	
	//Third classs
	//constructor -- same class name as method name
	public CartPage(AndroidDriver driver)
	{
		super(driver); //parent class(AndroidActions class) driver is used here- mostly used when inherited another class 
		
		//super will keep connection between parent class and child class
		this.driver=driver;
		//this will provide connection btw the class which is using by this form page object it is connected
		
		//it will constructs the below locators and methods together with driver
        // This line initializes all @FindBy elements below
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@FindBy(id="com.androidsample.generalstore:id/productPrice")
	public WebElement productList;
	
	
	@FindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	
	@FindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement terms;
	
	
	@FindBy(id="android:id/button1")
	public WebElement acceptsbutton;
	
	@FindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	
	@FindBy(className="android.widget.CheckBox")
	public WebElement checkBox;
	
	/*
	@SuppressWarnings("unchecked")
	public List<WebElement> getProductList()
	{
		return (List<WebElement>) productList;
		
	}
	

	@SuppressWarnings("unchecked")
	public double getproductsum()
	{
		int count = ((List<WebElement>) productList).size();
		
		double totalsum=0;
		for(int i =0; i<count; i++)
		{
			String amountstring = productList.get(i).getText();
		}
		
		return count;
	}
	*/
	
	public String getproductprice()
	{
		return productList.getText();
	
		
	}
	
	//select country name  text
	public WebElement totalAmountcal()
	{
		return totalAmount;
	
		
	}
	
	public void termsbtn() throws InterruptedException
	{
		
		terms.click();
		System.out.println("terms btn clicked");
		Thread.sleep(2000);
		//acceptsbutton.click();
		//System.out.println("acceptbtn btn clicked");
		//Thread.sleep(2000);
		checkBox.click();
		System.out.println("checkbox 1  btn clicked");
		Thread.sleep(2000);
		proceed.click();
		System.out.println("proceed btn clicked");
		Thread.sleep(2000);

	}
	
	
	//to remove dolor symbol and get character as value means we use this method
	public Double getformateAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
	}

}
