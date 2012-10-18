package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_RegistrationFlow2Test extends iTestCaseUDSauce{

    @Test (groups = {"Regression", "Register" })
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

    @Test (groups = {"Regression"}, dependsOnGroups = {"Register"})
    public void verifyUDEmailsReceived(){
        emailHelper_Client = new EmailHelper_Client(client);

        Reporter.log("Log in to Gmail", true);
        emailHelper_Client.loginToGmail();

        Reporter.log("Verify Welcome to UD Email was received", true);
        emailHelper_Client.verifyWelcomeUDEmailReceived(emailClient);

        Reporter.log("Verify Invitation Email was received", true);
        emailHelper_Client.verifyInvitationsUDEmailsReceived(emailFriend1, emailFriend2, emailFriend3, emailFriend4, emailFriend5);

        Reporter.log("Verify Password Reset Email was received", true);
        emailHelper_Client.verifyResetPasswordUDRequestReceivedandPasswordReset(emailClient);

        Reporter.log("Verify Edit Settings Email was received", true);
        emailHelper_Client.verifyEditSettingsUDEmailReceived(emailClient);
    }
}
