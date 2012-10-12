package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCasePerksSauce;


public class Perks_RegistrationFlow1 extends iTestCasePerksSauce {
	
	@Test (groups = "perkSmoke")
	public void perksSignUp(){
		visitPerksFirstTime();
		//1. client signs up and logs in

		signUpPerks_viaNewYork();
		editSettingsPerks();
		//doChecksCityHomePageLoggedIn();
				
		logoutPerks();
		resetPasswordPerks();
		
		//doChecksCityHomePageLoggedOut();

    }
    @Test (dependsOnGroups = {"perkSmoke"})
    public void perksConfirm() {
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
