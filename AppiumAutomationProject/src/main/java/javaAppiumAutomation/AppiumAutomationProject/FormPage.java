package javaAppiumAutomation.AppiumAutomationProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class FormPage extends AndroidActions {
	
	
	AndroidDriver driver;
	
	
	//constructors should be present in page object pages
	//constructor -- same class name as method name
	public FormPage(AndroidDriver driver)
	{
		super(driver); //parent class(AndroidActions class) driver is used here- mostly used when inherited another class 
		
		//super will keep connection between parent class and child class
		this.driver=driver;
		//this will provide connection btw the class which is using by this form page object it is connected
		
		//it will constructs the below locators and methods together with driver
        // This line initializes all @FindBy elements below
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	

	
	//locator  1
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")
	public WebElement appname;
	
	//verify webelement present for locator 1
	public WebElement getappname()
	{
		return appname;
		
	}
	

	

	
	//country name--- locator type
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")
	private WebElement countryname;
	
	
	
	//selecting a country by using scroll to the element
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"India\"]")
	private WebElement selectcountry;
	
	

	//selecting a country name to verify the country name
	
	
	@FindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/text1\"]")
	private WebElement verifycountry;
	
	
	
	
	//enter your name
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")
	private WebElement namefield;
		


	
	
	//scroll method initializing here 
	public void setcountryScroll(String countryName)
	{
		//scroll method called her , bec of inheritance 
		scrollToText(countryName);
		
	}
	//select gender
	
	@FindBy(id="com.androidsample.generalstore:id/radioFemale")
	public WebElement femaleopt;
	
	@FindBy(id="com.androidsample.generalstore:id/radioMale")
	public WebElement maleopt;
	
	//enter your name
	
	@FindBy(xpath="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")
	public WebElement letsshopbtn;
		
	
	
	//actions 
	
	
	//getcountry name
	public WebElement getcountryname()
	{
		return countryname;
		
	}
	
	
	//select country name
	public WebElement selectcountryname()
	{
		return selectcountry;
		
	}
	
	
	//select country name  text
	public WebElement verifycountryname()
	{
		return verifycountry;
		
	}
	
	//writer your name here  -- mmethod 2
	public void getname(String name)
	{
		
		namefield.sendKeys(name);
		driver.hideKeyboard();
	}
		
		
		
		
	//writer your name here
	public void getgender(String gender)
	{
		
		if(gender.contains("female"))
		{
			femaleopt.click();
		}
		
		else
		{
			maleopt.click();
		}
				
	}
			
			
			
			
	//writer your 2nd class page name and method name 
	public ProductCatalogPage getshopbtn()
	{
		letsshopbtn.click();
		
		//second class page object
		return new ProductCatalogPage(driver);
					
	}
				
		
		
		
		
		
		
		
	

}
