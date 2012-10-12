package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUDSauce;


public class UD_RegistrationFlow2 extends iTestCaseUDSauce {
	
	@Test (groups = "Smoke")
	public void UDregisterAndCheck(){

        Reporter.log("Visiting Home Page for the first time", true);
		visitUDFirstTime();

        Reporter.log("Access New York from the UD Homepage", true);
		accessNewYorkFromUDHomepage();

        Reporter.log("Sign up for a new account", true);
		signUpUD_viaNewYork();

        Reporter.log("Edit settings", true);
 		editSettingsUD();

        Reporter.log("Do homepage checks while logged in",true);
		doChecksCityHomePageLoggedIn();

        Reporter.log("Log out", true);
		logoutUD();

        Reporter.log("Return to homepage", true);
        goBackToUDHomepage();

        Reporter.log("Complete a password reset", true);
		resetPasswordUD();

        Reporter.log("Redo checks while logged out", true);
		doChecksCityHomePageLoggedOut();
    }

    @Test (groups = "Smoke")
    public void verifyUDEmailsReceived(){

        Reporter.log("Log in to Gmail", true);
        loginToGmail();

        Reporter.log("Verify Welcome to UD Email was received", true);
        verifyWelcomeUDEmailReceived();

        Reporter.log("Verify Invitation Email was received", true);
		verifyInvitationsUDEmailsReceived();

        Reporter.log("Verify Password Reset Email was received", true);
		verifyResetPasswordUDRequestReceivedandPasswordReset();

        Reporter.log("Verify Edit Settings Email was received", true);
		verifyEditSettingsUDEmailReceived();
    }
}
