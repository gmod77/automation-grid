package org.urbandaddy.tests.sauce.saucetesting;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_RegistrationTinySauceTest extends iTestCaseUDSauce {
    String date;
    String emailClient;
    String[] emailFriends;

    public UD_RegistrationTinySauceTest() {
        emailFriends = new String[5];
    }

    @Test (groups = {"regression", "register"})
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
        Reporter.log("Sign up Step 2",true);
        signUpUD_viaNewYorkStep2(date);
        Reporter.log("Sign up Step 3",true);
        signUpUD_viaNewYorkStep3(emailFriends, true);
        Reporter.log("Sign u Step 4",true);
        signUpUD_viaNewYorkStep4();

        Reporter.log("Log out", true);
        logoutUD();

    }


//    @Test (groups = {"check"}, dependsOnGroups = {"register"})
//    public void verifyUDEmailsReceived(){
//        emailHelper_Client = new EmailHelper_Client(client);
//        Reporter.log("Log in to Gmail", true);
//        emailHelper_Client.loginToGmail();
//
//        Reporter.log("Verify Welcome to UD Email was received", true);
//        verifyWelcomeUDEmailReceived();
//
//        Reporter.log("Verify Invitation Email was received", true);
//        verifyInvitationsUDEmailsReceived();

//    }


}