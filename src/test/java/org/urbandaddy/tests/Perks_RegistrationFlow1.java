package org.urbandaddy.tests;
import org.urbandaddy.helpers.Comm.ITestCase;
import org.testng.annotations.Test;




public class Perks_RegistrationFlow1 extends ITestCase {
	
	@Test (groups = "Smoke")
	public void flow1(){
		visitPerksFirstTime();
		//1. client signs up and logs in

		signUpPerks_viaNewYork();
		//doChecksCityHomePageLoggedIn();
				
		logoutPerks();
		resetPasswordPerks();
		
		//doChecksCityHomePageLoggedOut();
		
		loginToGmail();
//		verifyWelcomePerksEmailReceived();
//		verifyInvitationsPerksEmailsReceived();
//		verifyResetPasswordPerksRequestReceivedandPasswordReset();
		
		verifyWelcomeUDEmailReceived();
		verifyInvitationsUDEmailsReceived();
		verifyResetPasswordUDRequestReceivedandPasswordReset();

//		
//		logoutUD();
//		doChecksCityHomePageLoggedOut();
//		
		signInPerks();
//		doChecksCityHomePageLoggedIn();

		
//		loginClient();
		
		//check the header is in place
//		checkHeaderClient();
		
		
		// both sign out
//		signOutClient();

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
