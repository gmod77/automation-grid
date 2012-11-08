package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_RegistrationFlow2Test extends iTestCaseUDSauce{
    String date;
    String emailClient;
    String[] emailFriends;

    public UD_RegistrationFlow2Test() {
        emailFriends = new String[5];
    }

    @Test (groups = {"Regression", "Register" }, retryAnalyzer = Analyzer.class)
	public void UDregisterAndCheck(){
        emailHelper_Client = new EmailHelper_Client(client);

        date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        emailClient = emailHelper_Client.generateEmailClient(date);
        emailFriends = emailHelper_Client.generateFriendClient(5,date);

        Reporter.log("Visiting Home Page for the first time", true);
		visitUDFirstTime();

        Reporter.log("Access New York from the UD Homepage", true);
		accessNewYorkFromUDHomepage();

        Reporter.log("Sign up for a new account", true);
        Reporter.log("Sign up Step 1",true);
        signUpUD_viaNewYorkStep1(emailClient);
        signUpUD_viaNewYorkStepA();
        signUpUD_viaNewYorkStepB();
        Reporter.log("Sign up Step 2",true);
        signUpUD_viaNewYorkStep2(date);
        Reporter.log("Sign up Step 3",true);
        signUpUD_viaNewYorkStep3(emailFriends);
        signUpUD_viaNewYorkStep35();
        Reporter.log("Sign u Step 4",true);
        signUpUD_viaNewYorkStep4();

        Reporter.log("Edit settings", true);
 		editSettingsUD();

        Reporter.log("Do homepage checks while logged in",true);
		doChecksCityHomePageLoggedIn();

        Reporter.log("Log out", true);
		logoutUD();

        Reporter.log("Return to homepage", true);
        goBackToUDHomepage();

        Reporter.log("Complete a password reset", true);
		resetPasswordUD(emailClient);

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
        emailHelper_Client.verifyInvitationsUDEmailsReceived(emailFriends);

        Reporter.log("Verify Password Reset Email was received", true);
        emailHelper_Client.verifyResetPasswordUDRequestReceivedandPasswordReset(emailClient);

        Reporter.log("Verify Edit Settings Email was received", true);
        emailHelper_Client.verifyEditSettingsUDEmailReceived(emailClient);
    }
}
