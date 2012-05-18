package org.urbandaddy.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;
//import org.openqa.selenium.interactions.*;

public class FooterHelper_Client extends IHelper_Client {

	private LocatorReader headerReader;
	private String UDdomain = "http://ud-branch.thedaddy.co";

	public FooterHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub
		headerReader = new LocatorReader("UD_Footer.xml");
	}

//HomePage
	public Boolean isAboutUsHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.AboutUs");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isSignUpHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.SignUp");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isMyUDHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.MyUD");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isContactHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Contact");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isJobsHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Jobs");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isAdvertiseHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Advertise");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isTipsHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Tips");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isEmailIssuesHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.EmailIssues");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isPrivacyPolicyHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.PrivacyPolicy");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isUserAgreementHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.UserAgreement");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isUnsubscribeHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Unsubscribe");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isEditorialPolicyHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.EditorialPolicy");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	//cities
	
	public Boolean isAtlantaHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Atlanta");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isBostonHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Boston");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isChicagoHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Chicago");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isDallasHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Dallas");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isDCHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.DC");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isDrivenHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Driven");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isJetsetHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Jetset");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isLasVegasHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.LasVegas");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isLosAngelesHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.LosAngeles");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isMiamiHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.Miami");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isNationalHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.National");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isNewYorkHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.NewYork");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isSanFranciscoHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.SanFrancisco");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public Boolean isSkiBoardHomePresent(){
		
		Boolean result = false;
		
		String str = headerReader.getLocator("HomePage.SkiBoard");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	//CityHomePage
		public Boolean isAboutUsCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.AboutUs");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public boolean isAboutUsCityAccessible(){
			
			String str = headerReader.getLocator("CityHomePage.AboutUs");
			this.WaitForElementPresent(str,20);		
			WebElement el = client.findElement(ByLocator(str));
			el.click();

			if (client.getCurrentUrl().equals(UDdomain + "/about"))
				return true;
			return false;

		}
		
		public Boolean isSignUpCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.SignUp");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isMyUDCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.MyUD");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isPerksCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Perks");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}

		
		public Boolean isContactCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Contact");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isJobsCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Jobs");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isAdvertiseCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Advertise");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isTipsCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Tips");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isUnsubscribeCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Unsubscribe");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isMobileSiteCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.MobileSite");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isEmailIssuesCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.EmailIssues");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isPrivacyPolicyCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.PrivacyPolicy");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isUserAgreementCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.UserAgreement");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		
		public Boolean isEditorialPolicyCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.EditorialPolicy");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		//cities
		
		public Boolean isAtlantaCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Atlanta");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isBostonCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Boston");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isChicagoCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Chicago");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isDallasCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Dallas");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isDCCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.DC");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isDrivenCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Driven");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isJetsetCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Jetset");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isLasVegasCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.LasVegas");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isLosAngelesCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.LosAngeles");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isMiamiCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.Miami");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isNationalCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.National");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isNewYorkCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.NewYork");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isSanFranciscoCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.SanFrancisco");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}
		
		public Boolean isSkiBoardCityPresent(){
			
			Boolean result = false;
			
			String str = headerReader.getLocator("CityHomePage.SkiBoard");
			this.WaitForElementPresent(str,20);		
			result = this.isElementPresent(str);		
			return result;
		}	
}
