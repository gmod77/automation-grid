package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCasePerksSauce;


public class Perks_RegistrationFlow1 extends iTestCasePerksSauce {
	
	@Test (groups = "Smoke")
	public void flow1(){
		visitPerksFirstTime();
		//1. client signs up and logs in

		signUpPerks_viaNewYork();
		editSettingsPerks();
		//doChecksCityHomePageLoggedIn();
				
		logoutPerks();
		resetPasswordPerks();
		
		//doChecksCityHomePageLoggedOut();

		loginToGmail();
		
		verifyWelcomeUDEmailReceived();
		verifyInvitationsUDEmailsReceived();
		//verifyEditSettingsUDEmailReceived();
		verifyResetPasswordUDRequestReceivedandPasswordReset();
		

//		
//		logoutUD();
//		doChecksCityHomePageLoggedOut();
//		
//		signInPerks();
//		editSettingsPerks();
//		logoutPerks();
		
//		doChecksCityHomePageLoggedIn();

	}
}
