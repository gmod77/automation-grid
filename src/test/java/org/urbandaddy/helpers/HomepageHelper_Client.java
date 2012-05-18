package org.urbandaddy.helpers;

//import org.openqa.selenium.By;
import java.util.List;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.HasInputDevices;
//import org.openqa.selenium.Mouse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.internal.Coordinates;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

//import com.urbandaddy.testsuite.helpers.comm.IHelper_Client;
//import com.urbandaddy.testsuite.locators.LocatorReader;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

//import java.util.List;



public class HomepageHelper_Client extends IHelper_Client {
	
	private String domain = "https://qa.urbandaddy.com";

	private LocatorReader signupReader;
	
	public HomepageHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub	
		signupReader = new LocatorReader("UD_HomePage.xml");
	}
	
//HomePage
	
	public Boolean isUDLogoPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.UDLogo");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isClickableCopyPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ClickableCopy");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isSignUpSealPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SignUpSeal");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isAtlantaLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.AtlantaLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickAtlanta(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.AtlantaLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isBostonLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.BostonLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickBoston(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.BostonLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isChicagoLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ChicagoLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickChicago(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ChicagoLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isDallasLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DallasLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickDallas(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DallasLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isWashingtonDCLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.WashingtonDCLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickWashington(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.WashingtonDCLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isDrivenLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DrivenLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickDriven(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DrivenLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isJetsetLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.JetsetLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickJetset(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.JetsetLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isLasVegasLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LasVegasLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickLasVegas(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LasVegasLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isLosAngelesLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LosAngelesLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickLosAngeles(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LosAngelesLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isMiamiLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.MiamiLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickMiami(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.MiamiLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isNationalLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NationalLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickNational(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NationalLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isNewYorkLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NewYorkLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickNewYork(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NewYorkLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isSanFranciscoLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SanFranciscoLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickSanFrancisco(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SanFranciscoLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public Boolean isSkiBoardLinkPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SkiBoardLink");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickSkiBoard(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SkiBoardLink");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
		
}
