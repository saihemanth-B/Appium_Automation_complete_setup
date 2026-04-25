package ApiDemosApplication;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ApidemosPage extends AndroidActions {
	
	AndroidDriver driver;
	//constructor
	public ApidemosPage(AndroidDriver driver)
	{
		//taking from parent class
		super(driver); //parent class(AndroidActions class) driver is used here- mostly used when inherited another class 
		
		//super will keep connection between parent class and child class
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//locator  1
	@FindBy(xpath="//android.widget.TextView[@text=\"API Demos\"]")
	public WebElement PageTitle;
	
	//verify webelement present for locator 1
	public WebElement getappname()
	{
		return PageTitle;
		
	}
	
	
	//locator  2
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Accessibility\"]")
	public WebElement AccessibilityOpt;
	
	public WebElement getAccessibility()
	{
		return AccessibilityOpt;
		
	}
	
	@AndroidFindBy(id="Accessibility")
	public WebElement Accessibility;
	
	
	
	public WebElement getAccb()
	{
		return Accessibility;
		
	}
	
	
	
	
	//locator  3
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Animation\"]")
	public WebElement AnimationOpt;
	
	public WebElement getAnimation()
	{
		return AnimationOpt;
		
	}
	
	
	
	//locator  4
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"App\"]")
	public WebElement AppOpt;
	
	
	public WebElement getAppOpt()
	{
		return AppOpt;
		
	}
	
	//locator  5
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Content\"]")
	public WebElement ContentOpt;
	
	public WebElement getContent()
	{
		return ContentOpt;
		
	}
	
	
	//locator  6
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Graphics\"]")
	public WebElement GraphicsOpt;
	
	public WebElement getGraphis()
	{
		return GraphicsOpt;
		
	}
	
	//locator  7
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Media\"]")
	public WebElement MediaOpt;
	
	public WebElement getMedia()
	{
		return MediaOpt;
		
	}
	
	//locator  8
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"NFC\"]")
	public WebElement NFCOpt;
	
	public WebElement getNFC()
	{
		return NFCOpt;
		
	}
	
	//locator  9
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"OS\"]")
	public WebElement OSOpt;
	
	public WebElement getOS()
	{
		return OSOpt;
		
	}
	
	
	//locator  10
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Preference\"]")
	public WebElement PreferenceOpt;

	public WebElement getPreference()
	{
		return PreferenceOpt;
		
	}
	
	
	//locator  11
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Text\"]")
	public WebElement TextOpt;
	
	public WebElement getText()
	{
		return TextOpt;
		
	}
	
	//locator  12
	@FindBy(xpath="//android.widget.TextView[@content-desc=\"Views\"]")
	public WebElement ViewsOpt;
	
	public WebElement getViews()
	{
		return ViewsOpt;
		
	}
	
	
	
	

}
