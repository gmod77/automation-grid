package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class Manero_FooterHelper_Client extends IHelper_Client {

	private LocatorReader headerReader;

	public Manero_FooterHelper_Client(WebDriver client) {
		super(client);
		headerReader = new LocatorReader("Manero_Footer.xml");
	}

    //HomePage
	public Boolean isAboutUsHomePresent(){
		String str = headerReader.getLocator("HomePage.AboutUs");
		return this.isElementPresent(str);
	}
	
	public Boolean isSignUpHomePresent(){
		String str = headerReader.getLocator("HomePage.SignUp");
		return this.isElementPresent(str);
		
	}
	
	public Boolean isMyAccountPresent(){
		String str = headerReader.getLocator("HomePage.MyAccount");
		return this.isElementPresent(str);
	}
	
	public Boolean isContactHomePresent(){
		String str = headerReader.getLocator("HomePage.Contact");
		return this.isElementPresent(str);		
	}
	
	public Boolean isJobsHomePresent(){
		String str = headerReader.getLocator("HomePage.Jobs");
		return this.isElementPresent(str);
	}
	
	public Boolean isAdvertiseHomePresent(){
		String str = headerReader.getLocator("HomePage.Advertise");
		return this.isElementPresent(str);
	}

	public Boolean isEmailIssuesHomePresent(){
		String str = headerReader.getLocator("HomePage.EmailIssues");
		return this.isElementPresent(str);
	}
	
	public Boolean isPrivacyPolicyHomePresent(){
		String str = headerReader.getLocator("HomePage.PrivacyPolicy");
		return this.isElementPresent(str);
	}
	
	public Boolean isUserAgreementHomePresent(){
		String str = headerReader.getLocator("HomePage.UserAgreement");
		return this.isElementPresent(str);
	}
	
	public Boolean isUnsubscribeHomePresent(){
		String str = headerReader.getLocator("HomePage.Unsubscribe");
		return this.isElementPresent(str);
	}
	
	public Boolean isEditorialPolicyHomePresent(){
		String str = headerReader.getLocator("HomePage.EditorialPolicy");
		return this.isElementPresent(str);
	}
	
	//cities
	public Boolean isChicagoHomePresent(){
		String str = headerReader.getLocator("HomePage.Chicago");
		return this.isElementPresent(str);
	}
	
	public Boolean isHoustonHomePresent(){
		String str = headerReader.getLocator("HomePage.Houston");
		return this.isElementPresent(str);		
    }

	public Boolean isLosAngelesHomePresent(){
		String str = headerReader.getLocator("HomePage.LosAngeles");
		return this.isElementPresent(str);
	}
	
	public Boolean isMiamiHomePresent(){
		String str = headerReader.getLocator("HomePage.Miami");
		return this.isElementPresent(str);
	}
	
	public Boolean isNationalHomePresent(){
		String str = headerReader.getLocator("HomePage.National");
		return this.isElementPresent(str);
	}
	
	public Boolean isNewYorkHomePresent(){
		String str = headerReader.getLocator("HomePage.NewYork");
		return this.isElementPresent(str);
	}

}
