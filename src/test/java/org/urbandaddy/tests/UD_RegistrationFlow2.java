package org.urbandaddy.tests;
import org.urbandaddy.helpers.Comm.iTestCaseUD;
import org.testng.annotations.Test;




public class UD_RegistrationFlow2 extends iTestCaseUD {
	
	@Test (groups = "Smoke")
	public void flow1(){
		visitUDFirstTime();
		//1. client signs up and logs in

		accessNewYorkFromUDHomepage();

		signUpUD_viaNewYork();
		
 		editSettingsUD();

		doChecksCityHomePageLoggedIn();

		logoutUD();
		resetPasswordUD();

		doChecksCityHomePageLoggedOut();
		
		loginToGmail();
		verifyWelcomeUDEmailReceived();
		verifyInvitationsUDEmailsReceived();
		verifyResetPasswordUDRequestReceivedandPasswordReset();
		verifyEditSettingsUDEmailReceived();

//		
//		logoutUD();
//		doChecksCityHomePageLoggedOut();
//
        // Login Using New Password and then LogOut
// 		loginUD();
// 		logoutUD();

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
