package org.urbandaddy.tests.grid;

import org.testng.annotations.Test;
import org.urbandaddy.com.grid.iTestCasePerks;




public class Perks_RegistrationFlow1 extends iTestCasePerks {
	
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
	
	@Override
	public void beforeMethod() {

	}

	@Override
	public void afterMethod() {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeClass() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterClass() {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTest() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterTest() {
		// TODO Auto-generated method stub

	}

}
