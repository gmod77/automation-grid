package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class Perks_HeaderHelper_Client extends IHelper_Client {

	private LocatorReader headerReader;

	public Perks_HeaderHelper_Client(WebDriver client) {
		super(client);
		headerReader = new LocatorReader("Perks_Header.xml");
	}

	public Boolean isLogoutPresent(){
		
		String str = headerReader.getLocator("LoggedInHeader.SignOut");
		return this.isElementPresent(str);
	}
	
	public void clickLogout(){
		String str = headerReader.getLocator("LoggedInHeader.Logout");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}
	
	public void clickMyAccount(){
		String str = headerReader.getLocator("LoggedInHeader.MyAccount");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}
	
	public boolean isMyAccountAccessible(){

		if (client.getCurrentUrl().equals("http://ud-branch.thedaddy.co/myud"))
			return true;
		return false;
	}
	
	public void clickSignUp(){
		String str = headerReader.getLocator("LoggedOutHeader.SignUp");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}
	
	public void clickChangeCity(){
		String str = headerReader.getLocator("LoggedInHeader.ChangeCity");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}
	
    public void clickChangeCityNewYork(){
			
		String item = headerReader.getLocator("LoggedInHeader.NewYork");
		findElementAndCheckBy(item, 20);
		
		// find DropdownToggle menu
        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
		WebElement menu = findElementAndCheckBy(menu_locator, 20);
		// find SignOut element
		WebElement signout = findElementAndCheckBy(item);
		
		//build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(client);    
		builder.moveToElement(menu).build().perform();

		//then click when menu option is visible
		signout.click();
	}	
	
    public void clickChangeCityNational(){

        String item = headerReader.getLocator("LoggedInHeader.NewYork");
        findElementAndCheckBy(item, 20);
		
		// find DropdownToggle menu
        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        WebElement menu = findElementAndCheckBy(menu_locator, 20);
		// find SignOut element
		WebElement signout = findElementAndCheckBy(item);
		
		//build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(client);    
		builder.moveToElement(menu).build().perform();

		//then click when menu option is visible
		signout.click();
	}	
	
    public void clickChangeCityChicago(){

		String item = headerReader.getLocator("LoggedInHeader.Chicago");
		findElementAndCheckBy(item, 20);
		
		// find DropdownToggle menu
        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        WebElement menu = findElementAndCheckBy(menu_locator, 20);
		// find SignOut element
		WebElement signout = findElementAndCheckBy(item);
		
		//build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(client);    
		builder.moveToElement(menu).build().perform();

		//then click when menu option is visible
		signout.click();
	}	

    public void clickChangeCityMiami(){

        String item = headerReader.getLocator("LoggedInHeader.Miami");
        findElementAndCheckBy(item, 20);

        // find DropdownToggle menu
        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        WebElement menu = findElementAndCheckBy(menu_locator, 20);
        // find SignOut element
        WebElement signout = findElementAndCheckBy(item);

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        signout.click();
    }
	
    public void clickChangeCityBoston(){

		String item = headerReader.getLocator("LoggedInHeader.Boston");
		findElementAndCheckBy(item, 20);
		
		// find DropdownToggle menu
        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
		WebElement menu = findElementAndCheckBy(menu_locator, 20);
		// find SignOut element
		WebElement signout = findElementAndCheckBy(item);
		
		//build and perform the mouseOver with Advanced User Interactions API
		Actions builder = new Actions(client);    
		builder.moveToElement(menu).build().perform();

		//then click when menu option is visible
		signout.click();
	}

    public void clickChangeCityDC(){

        String item = headerReader.getLocator("LoggedInHeader.DC");
        findElementAndCheckBy(item, 20);

        // find DropdownToggle menu
        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        WebElement menu = findElementAndCheckBy(menu_locator, 20);
        // find SignOut element
        WebElement signout = findElementAndCheckBy(item);

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        signout.click();
    }

    public void clickChangeCityLosAngeles(){

        String item = headerReader.getLocator("LoggedInHeader.LosAngeles");
        findElementAndCheckBy(item, 20);

        // find DropdownToggle menu
        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        WebElement menu = findElementAndCheckBy(menu_locator, 20);
        // find SignOut element
        WebElement signout = findElementAndCheckBy(item);

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        signout.click();
    }

//// Top Nav methods
	
}
