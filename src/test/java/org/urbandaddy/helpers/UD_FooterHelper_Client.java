package org.urbandaddy.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class UD_FooterHelper_Client extends IHelper_Client {

	private LocatorReader headerReader;
	private String UDdomain;

	public UD_FooterHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub
		headerReader = new LocatorReader("UD_Footer.xml");
        UDdomain = "http://ud-branch.thedaddy.co";
    }

//HomePage
	public Boolean isAboutUsHomePresent(){
		
		String str = headerReader.getLocator("HomePage.AboutUs");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		

	}
	
	public Boolean isSignUpHomePresent(){
		
		String str = headerReader.getLocator("HomePage.SignUp");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		

	}
	
	public Boolean isMyUDHomePresent(){

		String str = headerReader.getLocator("HomePage.MyUD");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isContactHomePresent(){

		String str = headerReader.getLocator("HomePage.Contact");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isJobsHomePresent(){

		String str = headerReader.getLocator("HomePage.Jobs");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isAdvertiseHomePresent(){

		String str = headerReader.getLocator("HomePage.Advertise");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isTipsHomePresent(){

		String str = headerReader.getLocator("HomePage.Tips");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isEmailIssuesHomePresent(){
		
		String str = headerReader.getLocator("HomePage.EmailIssues");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isPrivacyPolicyHomePresent(){

		String str = headerReader.getLocator("HomePage.PrivacyPolicy");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isUserAgreementHomePresent(){
		
		String str = headerReader.getLocator("HomePage.UserAgreement");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isUnsubscribeHomePresent(){

		String str = headerReader.getLocator("HomePage.Unsubscribe");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isEditorialPolicyHomePresent(){

		String str = headerReader.getLocator("HomePage.EditorialPolicy");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	//cities
	
	public Boolean isAtlantaHomePresent(){

		String str = headerReader.getLocator("HomePage.Atlanta");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isBostonHomePresent(){

		String str = headerReader.getLocator("HomePage.Boston");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isChicagoHomePresent(){

		String str = headerReader.getLocator("HomePage.Chicago");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isDallasHomePresent(){

		String str = headerReader.getLocator("HomePage.Dallas");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isDCHomePresent(){

		String str = headerReader.getLocator("HomePage.DC");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isDrivenHomePresent(){

		String str = headerReader.getLocator("HomePage.Driven");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isJetsetHomePresent(){

		String str = headerReader.getLocator("HomePage.Jetset");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isLasVegasHomePresent(){

		String str = headerReader.getLocator("HomePage.LasVegas");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isLosAngelesHomePresent(){

		String str = headerReader.getLocator("HomePage.LosAngeles");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isMiamiHomePresent(){

		String str = headerReader.getLocator("HomePage.Miami");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isNationalHomePresent(){

		String str = headerReader.getLocator("HomePage.National");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isNewYorkHomePresent(){

		String str = headerReader.getLocator("HomePage.NewYork");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isSanFranciscoHomePresent(){

		String str = headerReader.getLocator("HomePage.SanFrancisco");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	public Boolean isSkiBoardHomePresent(){

		String str = headerReader.getLocator("HomePage.SkiBoard");
		//this.WaitForElementPresent(str,20);		
		return this.isElementPresent(str);		
		
	}
	
	//CityHomePage
		public Boolean isAboutUsCityPresent(){

			String str = headerReader.getLocator("CityHomePage.AboutUs");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public boolean isAboutUsCityAccessible(){
			
			String str = headerReader.getLocator("CityHomePage.AboutUs");
			//this.WaitForElementPresent(str,20);		
			WebElement el = client.findElement(ByLocator(str));
			el.click();

            return client.getCurrentUrl().equals(UDdomain + "/about");
		}
		
		public Boolean isSignUpCityPresent(){

			String str = headerReader.getLocator("CityHomePage.SignUp");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isMyUDCityPresent(){

			String str = headerReader.getLocator("CityHomePage.MyUD");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isPerksCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Perks");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}

		public Boolean isContactCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Contact");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isJobsCityPresent(){
			
			
			
			String str = headerReader.getLocator("CityHomePage.Jobs");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isAdvertiseCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Advertise");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isTipsCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Tips");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isUnsubscribeCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Unsubscribe");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isMobileSiteCityPresent(){

			String str = headerReader.getLocator("CityHomePage.MobileSite");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isEmailIssuesCityPresent(){

			String str = headerReader.getLocator("CityHomePage.EmailIssues");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isPrivacyPolicyCityPresent(){

			String str = headerReader.getLocator("CityHomePage.PrivacyPolicy");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isUserAgreementCityPresent(){

			String str = headerReader.getLocator("CityHomePage.UserAgreement");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}

		public Boolean isEditorialPolicyCityPresent(){

			String str = headerReader.getLocator("CityHomePage.EditorialPolicy");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		//cities
		
		public Boolean isAtlantaCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Atlanta");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isBostonCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Boston");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isChicagoCityPresent(){
			
			String str = headerReader.getLocator("CityHomePage.Chicago");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isDallasCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Dallas");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isDCCityPresent(){

			String str = headerReader.getLocator("CityHomePage.DC");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isDrivenCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Driven");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isJetsetCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Jetset");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isLasVegasCityPresent(){

			String str = headerReader.getLocator("CityHomePage.LasVegas");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isLosAngelesCityPresent(){

			String str = headerReader.getLocator("CityHomePage.LosAngeles");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isMiamiCityPresent(){

			String str = headerReader.getLocator("CityHomePage.Miami");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isNationalCityPresent(){

			String str = headerReader.getLocator("CityHomePage.National");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isNewYorkCityPresent(){

			String str = headerReader.getLocator("CityHomePage.NewYork");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isSanFranciscoCityPresent(){

			String str = headerReader.getLocator("CityHomePage.SanFrancisco");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}
		
		public Boolean isSkiBoardCityPresent(){

			String str = headerReader.getLocator("CityHomePage.SkiBoard");
			//this.WaitForElementPresent(str,20);		
			return this.isElementPresent(str);		
			
		}	
}
