package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class UD_HeaderHelper_Client extends IHelper_Client {

	private LocatorReader headerReader;
	private String UDdomain;
//	private String UDdomain = "http://www.urbandaddy.com";


	public UD_HeaderHelper_Client(WebDriver client) {
		super(client);
		headerReader = new LocatorReader("UD_Header.xml");
        UDdomain = "http://ud-branch.thedaddy.co";
    }

	public Boolean isLogoutPresent(){
		
				
		String str = headerReader.getLocator("LoggedInHeader.SignOut");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public void clickLogout(){
		String str = headerReader.getLocator("LoggedInHeader.Logout");
		//this.WaitForElementPresent(str,20);
		WebElement el = findElementAndCheckBy(str, 20);
		el.click();
	}
	
	public void clickMemberLogIn(){
		String str = headerReader.getLocator("LoggedOutHeader.MemberLogIn");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str, 20);
		el.click();
		
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
			e.printStackTrace();
				}
	}

    public boolean isSignUpPresent() {
        String str = headerReader.getLocator("LoggedOutHeader.SignUp");
        return this.isElementPresent(str);
    }

	public void clickSignUp(){
		String str = headerReader.getLocator("LoggedOutHeader.SignUp");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str, 5);
		el.click();
	}
	
	public void openSignUpNewTab(){
		this.client.navigate().to(UDdomain+"/myud/signup/location/login_bar/group/badge/edition#signupform");
	}
	
	public void clickChangeCity(){
		String str = headerReader.getLocator("LoggedInHeader.ChangeCity");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}
	
	
	public void clickChangeCityAtlanta(){
		
		String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
		//this.WaitForElementPresent(menu_locator, 20);
		String item = headerReader.getLocator("LoggedInHeader.Atlanta");
		//this.WaitForElementPresent(menu_locator, 20);
		
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
		//this.WaitForElementPresent(menu_locator, 20);
		String item = headerReader.getLocator("LoggedInHeader.Boston");
		//this.WaitForElementPresent(menu_locator, 20);
		
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
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.Chicago");
	//this.WaitForElementPresent(menu_locator, 20);
	
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

public void clickChangeCityDallas(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.Dallas");
	//this.WaitForElementPresent(menu_locator, 20);
	
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
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.DC");
	//this.WaitForElementPresent(menu_locator, 20);
	
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

public void clickChangeCityJetset(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.Jetset");
	//this.WaitForElementPresent(menu_locator, 20);
	
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

public void clickChangeCityLasVegas(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.LasVegas");
	//this.WaitForElementPresent(menu_locator, 20);
	
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
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.LosAngeles");
	//this.WaitForElementPresent(menu_locator, 20);
	
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
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.Miami");
	//this.WaitForElementPresent(menu_locator, 20);
	
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
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.National");
	//this.WaitForElementPresent(menu_locator, 20);
	
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

public void clickChangeCityNewYork(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.NewYork");
	//this.WaitForElementPresent(menu_locator, 20);
	
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

public void clickChangeCitySanFrancisco(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.SanFrancisco");
	//this.WaitForElementPresent(menu_locator, 20);
	
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

public void clickChangeCitySkiBoard(){
	
	String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
	//this.WaitForElementPresent(menu_locator, 20);
	String item = headerReader.getLocator("LoggedInHeader.SkiBoard");
	//this.WaitForElementPresent(menu_locator, 20);
	
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


	// Assignments Menu helpers
	
//	public void mouseOverAssignmentsDropdown(){
//		String menu_locator = headerReader.getLocator("LoggedInHeader.AssignmentsDropdown");
//		//this.WaitForElementPresent(menu_locator, 20);		
//		// find Assignments menu
//		WebElement el = client.findElement(ByLocator(menu_locator));
//		
//		//build and perform the mouseOver with Advanced User Interactions API
//		Actions builder = new Actions(client);    
//		builder.moveToElement(el).build().perform();
//
//	}
//	

// Top Nav methods

public Boolean isSearchBoxPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeader.SearchBox");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public Boolean isSearchBoxGoButtonPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeader.SearchBoxGoButton");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public Boolean isNightlifePresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Nightlife");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickNightlife(){
	
	String str = headerReader.getLocator("LoggedInHeader.Nightlife");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
	
}

public Boolean isNightlifeLVPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderLasVegas.Nightlife");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickNightlifeLV(){

String str = headerReader.getLocator("LoggedInHeaderLasVegas.Nightlife");
//this.WaitForElementPresent(str,20);		
WebElement el = findElementAndCheckBy(str, 20);
el.click();
}

	
public Boolean isFoodPresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Food");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickFood(){
	
	String str = headerReader.getLocator("LoggedInHeader.Food");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isFoodLVPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderLasVegas.Food");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickFoodLV(){
	
	String str = headerReader.getLocator("LoggedInHeaderLasVegas.Food");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isFoodDrinkNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.FoodDrink");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickFoodDrinkNational(){
	
	String str = headerReader.getLocator("LoggedInHeaderNational.FoodDrink");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isEntertainmentLVPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderLasVegas.Entertainment");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickEntertainmentLV(){
	
	String str = headerReader.getLocator("LoggedInHeaderLasVegas.Entertainment");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isEntertainmentNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Entertainment");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickEntertainmentNational(){
	
	String str = headerReader.getLocator("LoggedInHeaderNational.Entertainment");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isTravelNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Travel");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickTravelNational(){
	
	String str = headerReader.getLocator("LoggedInHeaderNational.Travel");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isStylePresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Style");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickStyle(){
	
	String str = headerReader.getLocator("LoggedInHeader.Style");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isStyleNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Style");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickStyleNational(){

String str = headerReader.getLocator("LoggedInHeaderNational.Style");
//this.WaitForElementPresent(str,20);		
WebElement el = findElementAndCheckBy(str, 20);
el.click();
}

public Boolean isGearPresent(){
				
		String el = headerReader.getLocator("LoggedInHeader.Gear");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickGear(){
	
	String str = headerReader.getLocator("LoggedInHeader.Gear");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isGearNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Gear");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickGearNational(){

String str = headerReader.getLocator("LoggedInHeaderNational.Gear");
//this.WaitForElementPresent(str,20);		
WebElement el = findElementAndCheckBy(str, 20);
el.click();
}

public Boolean isLeisurePresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Leisure");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickLeisure(){
	
	String str = headerReader.getLocator("LoggedInHeader.Leisure");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}
	
public Boolean isDrivenPresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Driven");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickDriven(){
	
	String str = headerReader.getLocator("LoggedInHeader.Driven");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isDrivenAccessible(){

    return client.getCurrentUrl().contains("http://driven.urbandaddy.com/");
}

public Boolean isDrivenNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Driven");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}


public boolean isDrivenNationalAccessible(){
	
	String str = headerReader.getLocator("LoggedInHeaderNational.Driven");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();

    return client.getCurrentUrl().contains("http://driven.urbandaddy.com/");
}

public Boolean isPerksPresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Perks");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickPerks(){
	
	String str = headerReader.getLocator("LoggedInHeader.Perks");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isPerksLVPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderLasVegas.Perks");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickPerksLV(){
	
	String str = headerReader.getLocator("LoggedInHeaderLasVegas.Perks");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public Boolean isPerksNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Perks");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickPerksNational(){
	
	String str = headerReader.getLocator("LoggedInHeaderNational.Perks");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public Boolean isPartiesPresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Parties");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickParties(){
	
	String str = headerReader.getLocator("LoggedInHeader.Parties");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isPartiesAccessible(){
	
	if (client.getCurrentUrl().contains("http://thechronicles.urbandaddy.com/"))
		return true;
	return false;
}

public Boolean isPartiesLVPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderLasVegas.Parties");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickPartiesLV(){
	
	String str = headerReader.getLocator("LoggedInHeaderLasVegas.Parties");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isPartiesLVAccessible(){
	
	if (client.getCurrentUrl().contains("http://thechronicles.urbandaddy.com/"))
		return true;
	return false;
}

public Boolean isPartiesNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Parties");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickPartiesNational(){
	
	String str = headerReader.getLocator("LoggedInHeaderNational.Parties");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isPartiesNationalAccessible(){
		
	if (client.getCurrentUrl().contains("http://thechronicles.urbandaddy.com/"))
		return true;
	return false;
}
	
public Boolean isKemptPresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Kempt");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
}

public void clickKempt(){
	
	String str = headerReader.getLocator("LoggedInHeader.Kempt");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isKemptAccessible(){
	
	if (client.getCurrentUrl().contains("http://www.getkempt.com/"))
		return true;
	return false;
}

public Boolean isKemptLVPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderLasVegas.Kempt");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickKemptLV(){
	
	String str = headerReader.getLocator("LoggedInHeaderLasVegas.Kempt");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isKemptLVAccessible(){

	if (client.getCurrentUrl().contains("http://www.getkempt.com/"))
		return true;
	return false;
}

public Boolean isKemptNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Kempt");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickKemptNational(){
	
	String str = headerReader.getLocator("LoggedInHeaderNational.Kempt");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isKemptNationalAccessible(){
		
	if (client.getCurrentUrl().contains("http://www.getkempt.com/"))
		return true;
	return false;
}

public Boolean isMobilePresent(){
		
				
		String el = headerReader.getLocator("LoggedInHeader.Mobile");
		//this.WaitForElementPresent(el,20);		
		return this.isElementPresent(el);		
		
	}

public void clickMobile(){
	
	String str = headerReader.getLocator("LoggedInHeader.Mobile");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isMobileAccessible(){
	
	if (client.getCurrentUrl().contains(UDdomain + "/mobile"))
		return true;
	return false;
}

public Boolean isMobileLVPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderLasVegas.Mobile");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickMobileLV(){
	
	String str = headerReader.getLocator("LoggedInHeaderLasVegas.Mobile");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isMobileLVAccessible(){
	
	if (client.getCurrentUrl().contains(UDdomain + "/mobile"))
		return true;
	return false;
}

public Boolean isMobileNationalPresent(){
	
		
	String el = headerReader.getLocator("LoggedInHeaderNational.Mobile");
	//this.WaitForElementPresent(el,20);		
	return this.isElementPresent(el);		
	
}

public void clickMobileNational(){
	
	String str = headerReader.getLocator("LoggedInHeaderNational.Mobile");
	//this.WaitForElementPresent(str,20);		
	WebElement el = findElementAndCheckBy(str, 20);
	el.click();
}

public boolean isMobileNationalAccessible(){
		
	if (client.getCurrentUrl().contains(UDdomain + "/mobile"))
		return true;
	return false;
}
	
}
