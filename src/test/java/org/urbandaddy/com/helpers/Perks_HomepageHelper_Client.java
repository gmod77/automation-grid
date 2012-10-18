package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class Perks_HomepageHelper_Client extends IHelper_Client {
	
	private LocatorReader signupReader;
	
	public Perks_HomepageHelper_Client(WebDriver client) {
		super(client);
		signupReader = new LocatorReader("UD_HomePage.xml");
	}

//HomePage

	public Boolean isUDLogoPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.UDLogo");
		return this.isElementPresent(str);
	}

	public Boolean isClickableCopyPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ClickableCopy");
		return this.isElementPresent(str);
	}

	public Boolean isSignUpSealPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SignUpSeal");
		return this.isElementPresent(str);
	}

	public Boolean isAtlantaLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.AtlantaLink");
		return this.isElementPresent(str);
	}

	public void clickAtlanta(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.AtlantaLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isBostonLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.BostonLink");
		return this.isElementPresent(str);
	}

	public void clickBoston(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.BostonLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isChicagoLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ChicagoLink");
		return this.isElementPresent(str);
	}

	public void clickChicago(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ChicagoLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isDallasLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DallasLink");
		return this.isElementPresent(str);
	}

	public void clickDallas(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DallasLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isWashingtonDCLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.WashingtonDCLink");
		return this.isElementPresent(str);
	}

	public void clickWashington(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.WashingtonDCLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isDrivenLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DrivenLink");
		return this.isElementPresent(str);
	}

	public void clickDriven(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.DrivenLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isJetsetLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.JetsetLink");
		return this.isElementPresent(str);
	}

	public void clickJetset(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.JetsetLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isLasVegasLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LasVegasLink");
		return this.isElementPresent(str);
	}

	public void clickLasVegas(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LasVegasLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isLosAngelesLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LosAngelesLink");
		return this.isElementPresent(str);
	}

	public void clickLosAngeles(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.LosAngelesLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isMiamiLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.MiamiLink");
		return this.isElementPresent(str);
	}

	public void clickMiami(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.MiamiLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isNationalLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NationalLink");
		return this.isElementPresent(str);
	}

	public void clickNational(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NationalLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isNewYorkLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NewYorkLink");
		return this.isElementPresent(str);
	}

	public void clickNewYork(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.NewYorkLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isSanFranciscoLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SanFranciscoLink");
		return this.isElementPresent(str);
	}

	public void clickSanFrancisco(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SanFranciscoLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	public Boolean isSkiBoardLinkPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SkiBoardLink");
		return this.isElementPresent(str);
	}

	public void clickSkiBoard(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SkiBoardLink");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

}
