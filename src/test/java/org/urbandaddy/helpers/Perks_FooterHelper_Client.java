package org.urbandaddy.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.*;

public class Perks_FooterHelper_Client extends IHelper_Client {

	private LocatorReader headerReader;
	private String UDdomain = "http://ud-branch.thedaddy.co";

	public Perks_FooterHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub
		headerReader = new LocatorReader("UD_Footer.xml");
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
	
	public Boolean isMyUDHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.MyUD");
				
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
	
	public Boolean isTipsHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.Tips");
				
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
	
	public Boolean isAtlantaHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.Atlanta");
				
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isBostonHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.Boston");
				
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isChicagoHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.Chicago");
				
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isDallasHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.Dallas");
				
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isDCHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.DC");
				
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isDrivenHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.Driven");
				
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isJetsetHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.Jetset");
				
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isLasVegasHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.LasVegas");
				
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
	
	public Boolean isSanFranciscoHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.SanFrancisco");
				
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isSkiBoardHomePresent(){
		
		
		
		String str = headerReader.getLocator("HomePage.SkiBoard");
				
		return this.isElementPresent(str);		
		
	}
	
	//CityHomePage
		public Boolean isAboutUsCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.AboutUs");
					
			return this.isElementPresent(str);		
			
		}
		
		public boolean isAboutUsCityAccessible(){
			
			String str = headerReader.getLocator("CityHomePage.AboutUs");
					
			WebElement el = client.findElement(ByLocator(str));
			el.click();

			if (client.getCurrentUrl().equals(UDdomain + "/about"))
				return true;
			return false;

		}
		
		public Boolean isSignUpCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.SignUp");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isMyUDCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.MyUD");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isPerksCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Perks");
					
			return this.isElementPresent(str);		
			
		}

		
		public Boolean isContactCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Contact");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isJobsCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Jobs");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isAdvertiseCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Advertise");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isTipsCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Tips");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isUnsubscribeCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Unsubscribe");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isMobileSiteCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.MobileSite");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isEmailIssuesCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.EmailIssues");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isPrivacyPolicyCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.PrivacyPolicy");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isUserAgreementCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.UserAgreement");
					
			return this.isElementPresent(str);		
			
		}
		
		
		public Boolean isEditorialPolicyCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.EditorialPolicy");
					
			return this.isElementPresent(str);		
			
		}
		
		//cities
		
		public Boolean isAtlantaCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Atlanta");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isBostonCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Boston");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isChicagoCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Chicago");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isDallasCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Dallas");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isDCCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.DC");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isDrivenCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Driven");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isJetsetCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Jetset");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isLasVegasCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.LasVegas");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isLosAngelesCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.LosAngeles");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isMiamiCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Miami");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isNationalCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.National");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isNewYorkCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.NewYork");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isSanFranciscoCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.SanFrancisco");
					
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isSkiBoardCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.SkiBoard");
					
			return this.isElementPresent(str);		
			
		}	
}
