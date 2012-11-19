package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class Manero_HeaderHelper_Client extends IHelper_Client {

	private LocatorReader headerReader;
    private int timeOut = 10;

	public Manero_HeaderHelper_Client(WebDriver client) {
		super(client);
		headerReader = new LocatorReader("Manero_Header.xml");
    }

    public boolean isLogoutPresent() {
        String str = headerReader.getLocator("LoggedInHeader.Logout");
        return isElementPresent(str);
    }

	public void clickLogout(){
		String str = headerReader.getLocator("LoggedInHeader.Logout");
		WebElement el = findElementAndCheckBy(str, timeOut);
		el.click();
	}
	
	public void clickMemberLogIn(){
		String str = headerReader.getLocator("LoggedOutHeader.MemberLogIn");
		WebElement el = findElementAndCheckBy(str, timeOut);
		el.click();
	}

    public boolean isSignUpPresent() {
        String str = headerReader.getLocator("LoggedOutHeader.SignUp");
        return isElementPresent(str);
    }

	public void clickSignUp(){
		String str = headerReader.getLocator("LoggedOutHeader.SignUp");
		WebElement el = findElementAndCheckBy(str, timeOut);
		el.click();
	}

	public void clickChangeCity(){
		String str = headerReader.getLocator("LoggedInHeader.ChangeCity");
		WebElement el = findElementAndCheckBy(str,timeOut);
		el.click();
	}

    public void clickChangeCityChicago(){

        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        String item = headerReader.getLocator("LoggedInHeader.Chicago");

        // find DropdownToggle menu
        WebElement menu = client.findElement(ByLocator(menu_locator));
        // find City element
        WebElement city = client.findElement(ByLocator(item));

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        city.click();
    }

    public void clickChangeCityLosAngeles(){

        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        String item = headerReader.getLocator("LoggedInHeader.LosAngeles");

        // find DropdownToggle menu
        WebElement menu = client.findElement(ByLocator(menu_locator));
        // find City element
        WebElement city = client.findElement(ByLocator(item));

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        city.click();
    }

    public void clickChangeCityMiami(){

        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        String item = headerReader.getLocator("LoggedInHeader.Miami");

        // find DropdownToggle menu
        WebElement menu = client.findElement(ByLocator(menu_locator));
        // find City element
        WebElement city = client.findElement(ByLocator(item));

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        city.click();
    }

    public void clickChangeCityNational(){

        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        String item = headerReader.getLocator("LoggedInHeader.National");

        // find DropdownToggle menu
        WebElement menu = client.findElement(ByLocator(menu_locator));
        // find City element
        WebElement city = client.findElement(ByLocator(item));

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        city.click();
    }

    public void clickChangeCityNewYork(){

        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        String item = headerReader.getLocator("LoggedInHeader.NewYork");

        // find DropdownToggle menu
        WebElement menu = client.findElement(ByLocator(menu_locator));
        // find City element
        WebElement city = client.findElement(ByLocator(item));

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        city.click();
    }

    public void clickChangeCityHouston(){

        String menu_locator = headerReader.getLocator("LoggedInHeader.ChangeCity");
        String item = headerReader.getLocator("LoggedInHeader.Houston");

        // find DropdownToggle menu
        WebElement menu = client.findElement(ByLocator(menu_locator));
        // find SignOut element
        WebElement city = client.findElement(ByLocator(item));

        //build and perform the mouseOver with Advanced User Interactions API
        Actions builder = new Actions(client);
        builder.moveToElement(menu).build().perform();

        //then click when menu option is visible
        city.click();
    }

}
