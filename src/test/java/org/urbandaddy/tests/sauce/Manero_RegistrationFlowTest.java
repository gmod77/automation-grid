package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseManeroSauce;


public class Manero_RegistrationFlowTest extends iTestCaseManeroSauce {
    String date;
    String emailClient;
    String[] emailFriends;

    public Manero_RegistrationFlowTest() {
        emailFriends = new String[5];
    }

    @Test (groups = {"Regression", "Register" }, retryAnalyzer = Analyzer.class)
	public void ManeroRegistrationCheck(){
        emailHelper_Client = new EmailHelper_Client(client);

        date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        emailClient = emailHelper_Client.generateEmailClient(date);
        emailFriends = emailHelper_Client.generateFriendClient(5,date);

        Reporter.log("Visiting Home Page for the first time", true);
		visitManeroFirstTime();

        Reporter.log("Sign up for a new account", true);
        Reporter.log("Sign up Step 1",true);
        signUpManeroStep1(emailClient);
        Reporter.log("Sign up Step 2",true);
        signUpManeroStep2(date);
        Reporter.log("Sign up Step 3",true);
        signUpManeroStep3(emailFriends);
        Reporter.log("Sign u Step 4",true);
        signUpManeroStep4();


        Reporter.log("Log out", true);
		logoutManero();

    }

    @Test (groups = {"Regression"}, retryAnalyzer = Analyzer.class)
    public void ManeroHomePageChecksLoggedOut() {
        Reporter.log("Visiting Home Page for the first time", true);
        visitManeroFirstTime();

        Reporter.log("Do checks while logged out", true);

        Reporter.log("Check Header", true);
        checkManeroHomepageHeaderLoggedOut();
        Reporter.log("Check Footer", true);
        checkManeroHomepageFooterLoggedOut();

    }

//    @Test (groups = {"Regression"}, dependsOnGroups = {"Register"}, retryAnalyzer = Analyzer.class)
//    public void homePageChecksLoggedIn() {
//        Reporter.log("Visiting Home Page for the first time", true);
//        visitManeroFirstTime();
//
//        Reporter.log("Login");
//        loginManero(emailClient,PASSWORD);
//
//        Reporter.log("Check Header",true);
//        checkManeroHomepageHeaderLoggedIn();
//
//        client.navigate().refresh();
//
//        Reporter.log("Check Footer", true);
//        checkManeroHomePageFooterLoggedIn();
//
//    }
//
//    @Test (groups = {"Regression"}, dependsOnGroups = {"Register"}, retryAnalyzer = Analyzer.class)
//    public void verifyUDEmailsReceived(){
//        emailHelper_Client = new EmailHelper_Client(client);
//
//        Reporter.log("Log in to Gmail", true);
//        emailHelper_Client.loginToGmail();
//
//        Reporter.log("Verify Welcome to UD Email was received", true);
//        emailHelper_Client.verifyWelcomeUDEmailReceived(emailClient);
//
//        Reporter.log("Verify Invitation Email was received", true);
//        emailHelper_Client.verifyInvitationsUDEmailsReceived(emailFriends);
//
//        Reporter.log("Verify Password Reset Email was received", true);
//        emailHelper_Client.verifyResetPasswordUDRequestReceivedandPasswordReset(emailClient);
//
//        Reporter.log("Verify Edit Settings Email was received", true);
//        emailHelper_Client.verifyEditSettingsUDEmailReceived(emailClient);
//    }
}
