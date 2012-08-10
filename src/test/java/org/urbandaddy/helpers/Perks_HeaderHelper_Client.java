package org.urbandaddy.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;
import org.openqa.selenium.interactions.*;

public class Perks_HeaderHelper_Client extends IHelper_Client {

	private LocatorReader headerReader;
	private String UDdomain = "http://ud-branch.thedaddy.co";
//	private String UDdomain = "http://www.urbandaddy.com";


	public Perks_HeaderHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub
		headerReader = new LocatorReader("Perks_Header.xml");
	}

	public Boolean isLogoutPresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("LoggedInHeader.SignOut");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickLogout(){
		String str = headerReader.getLocator("LoggedInHeader.Logout");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void clickMyAccount(){
		String str = headerReader.getLocator("LoggedInHeader.MyAccount");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public boolean isMyAccountAccessible(){

		if (client.getCurrentUrl().equals("http://ud-branch.thedaddy.co/myud"))
			return true;
		return false;
	}
	
	public void clickSignUp(){
		String str = headerReader.getLocator("LoggedOutHeader.SignUp");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void clickChangeCity(){
		String str = headerReader.getLocator("LoggedInHeader.ChangeCity");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
public void clickChangeCityNewYork(){
		
		String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
		this.WaitForElementPresent(menu_locator, 20);
		String item = headerReader.getLocator("LoggedInHeader.NewYork");
		this.WaitForElementPresent(menu_locator, 20);
		
		// find DropdownToggle menu
		WebElement menu = client.findElement(ByLocator(menu_locator));
		// find SignOut element
		WebElement signout = client.findElement(ByLocator(item));
		
		//build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(client);    
		builder.moveToElement(menu).build().perform();

		//then click when menu option is visible
		signout.click();
	}	
	
public void clickChangeCityNational(){
		
		String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
		this.WaitForElementPresent(menu_locator, 20);
		String item = headerReader.getLocator("LoggedInHeader.National");
		this.WaitForElementPresent(menu_locator, 20);
		
		// find DropdownToggle menu
		WebElement menu = client.findElement(ByLocator(menu_locator));
		// find SignOut element
		WebElement signout = client.findElement(ByLocator(item));
		
		//build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(client);    
		builder.moveToElement(menu).build().perform();

		//then click when menu option is visible
		signout.click();
	}	
	
public void clickChangeCityChicago(){
		
		String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
		this.WaitForElementPresent(menu_locator, 20);
		String item = headerReader.getLocator("LoggedInHeader.Chicago");
		this.WaitForElementPresent(menu_locator, 20);
		
		// find DropdownToggle menu
		WebElement menu = client.findElement(ByLocator(menu_locator));
		// find SignOut element
		WebElement signout = client.findElement(ByLocator(item));
		
		//build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(client);    
		builder.moveToElement(menu).build().perform();

		//then click when menu option is visible
		signout.click();
	}	

public void clickChangeCityMiami(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.Miami");
	this.WaitForElementPresent(menu_locator, 20);
	
	// find DropdownToggle menu
	WebElement menu = client.findElement(ByLocator(menu_locator));
	// find SignOut element
	WebElement signout = client.findElement(ByLocator(item));
	
	//build and perform the mouseOver with Advanced User Interactions API
	Actions builder = new Actions(client);    
	builder.moveToElement(menu).build().perform();

	//then click when menu option is visible
	signout.click();
}
	
public void clickChangeCityBoston(){
		
		String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
		this.WaitForElementPresent(menu_locator, 20);
		String item = headerReader.getLocator("LoggedInHeader.Boston");
		this.WaitForElementPresent(menu_locator, 20);
		
		// find DropdownToggle menu
		WebElement menu = client.findElement(ByLocator(menu_locator));
		// find SignOut element
		WebElement signout = client.findElement(ByLocator(item));
		
		//build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(client);    
		builder.moveToElement(menu).build().perform();

		//then click when menu option is visible
		signout.click();
	}

public void clickChangeCityDC(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.DC");
	this.WaitForElementPresent(menu_locator, 20);
	
	// find DropdownToggle menu
	WebElement menu = client.findElement(ByLocator(menu_locator));
	// find SignOut element
	WebElement signout = client.findElement(ByLocator(item));
	
	//build and perform the mouseOver with Advanced User Interactions API
	Actions builder = new Actions(client);    
	builder.moveToElement(menu).build().perform();

	//then click when menu option is visible
	signout.click();
}

public void clickChangeCityLosAngeles(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.LosAngeles");
	this.WaitForElementPresent(menu_locator, 20);
	
	// find DropdownToggle menu
	WebElement menu = client.findElement(ByLocator(menu_locator));
	// find SignOut element
	WebElement signout = client.findElement(ByLocator(item));
	
	//build and perform the mouseOver with Advanced User Interactions API
	Actions builder = new Actions(client);    
	builder.moveToElement(menu).build().perform();

	//then click when menu option is visible
	signout.click();
}



//// Top Nav methods



public Boolean isBlahPresent(){
		
		Boolean result = false;
		
		String el = headerReader.getLocator("LoggedInHeader.Perks");
		this.WaitForElementPresent(el,20);		
		result = this.isElementPresent(el);		
		return result;
}

public void clickBlah(){
	
	String str = headerReader.getLocator("LoggedInHeader.Perks");
	this.WaitForElementPresent(str,20);		
	WebElement el = client.findElement(ByLocator(str));
	el.click();
}


	
}
