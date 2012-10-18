package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCasePerksSauce;


public class Perks_RegistrationFlow1Test extends iTestCasePerksSauce {
	
	@Test (groups = "perkSmoke")
	public void perksSignUp(){
		visitPerksFirstTime();
		//1. client signs up and logs in

		signUpPerks_viaNewYork();
		editSettingsPerks();
		//doChecksCityHomePageLoggedIn();
				
		logoutPerks();
        visitPerksFirstTime();//return to homepage
		resetPasswordPerks();
		
		//doChecksCityHomePageLoggedOut();

    }
    @Test (dependsOnGroups = {"perkSmoke"})
    public void perksConfirm() {
        emailHelper_Client = new EmailHelper_Client(client);

		emailHelper_Client.loginToGmail();
		
		emailHelper_Client.verifyWelcomeUDEmailReceived(emailClient);
		emailHelper_Client.verifyInvitationsUDEmailsReceived(emailFriend1, emailFriend2, emailFriend3, emailFriend4, emailFriend5);
		//verifyEditSettingsUDEmailReceived();
		emailHelper_Client.verifyResetPasswordUDRequestReceivedandPasswordReset(emailClient);
		

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
