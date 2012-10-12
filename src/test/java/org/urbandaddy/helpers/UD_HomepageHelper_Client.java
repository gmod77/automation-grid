package org.urbandaddy.helpers;

//import org.openqa.selenium.By;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.HasInputDevices;
//import org.openqa.selenium.Mouse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

//import org.openqa.selenium.interactions.internal.Coordinates;

//import com.urbandaddy.testsuite.helpers.comm.IHelper_Client;
//import com.urbandaddy.testsuite.locators.LocatorReader;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

//import java.util.List;



public class UD_HomepageHelper_Client extends IHelper_Client {

	private LocatorReader signupReader;
	
	public UD_HomepageHelper_Client(WebDriver client) {
		super(client);
		signupReader = new LocatorReader("UD_HomePage.xml");
	}
	
//HomePage
	
	public Boolean isUDLogoPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.UDLogo");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isClickableCopyPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ClickableCopy");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isSignUpSealPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SignUpSeal");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isAtlantaLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.AtlantaLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickAtlanta(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.AtlantaLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isBostonLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.BostonLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickBoston(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.BostonLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isChicagoLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ChicagoLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickChicago(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ChicagoLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isDallasLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DallasLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickDallas(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DallasLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isWashingtonDCLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.WashingtonDCLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickWashington(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.WashingtonDCLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isDrivenLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DrivenLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickDriven(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DrivenLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isJetsetLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.JetsetLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickJetset(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.JetsetLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isLasVegasLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LasVegasLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickLasVegas(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LasVegasLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isLosAngelesLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LosAngelesLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickLosAngeles(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LosAngelesLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isMiamiLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.MiamiLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickMiami(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.MiamiLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isNationalLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NationalLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickNational(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NationalLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isNewYorkLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NewYorkLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickNewYork(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NewYorkLink");
		//this.WaitForElementPresent(str,20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isSanFranciscoLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SanFranciscoLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickSanFrancisco(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SanFranciscoLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public Boolean isSkiBoardLinkPresent(){
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SkiBoardLink");
		//this.WaitForElementPresent(str,20);
		return this.isElementPresent(str);		
		
	}
	
	public void clickSkiBoard(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SkiBoardLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
		
}
