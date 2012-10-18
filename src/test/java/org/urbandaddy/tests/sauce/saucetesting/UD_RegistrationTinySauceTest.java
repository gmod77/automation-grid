package org.urbandaddy.tests.sauce.saucetesting;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_RegistrationTinySauceTest extends iTestCaseUDSauce {

    @Test (groups = {"regression", "register"})
    public void UDregisterAndCheck(){
//
        Reporter.log("Visiting Home Page for the first time", true);
        visitUDFirstTime();
//
        Reporter.log("Access New York from the UD Homepage", true);
        accessNewYorkFromUDHomepage();
//
//        Reporter.log("Sign up for a new account", true);
//        signUpUD_viaNewYork();
//
//        Reporter.log("Edit settings", true);
//        editSettingsUD();
//
//        Reporter.log("Log out", true);
//        logoutUD();
//
//        Reporter.log("Return to homepage", true);
//        goBackToUDHomepage();
    }


    @Test (groups = {"check"}, dependsOnGroups = {"register"})
    public void verifyUDEmailsReceived(){
        emailHelper_Client = new EmailHelper_Client(client);
        Reporter.log("Log in to Gmail", true);
        emailHelper_Client.loginToGmail();
//
//        Reporter.log("Verify Welcome to UD Email was received", true);
//        verifyWelcomeUDEmailReceived();
//
//        Reporter.log("Verify Invitation Email was received", true);
//        verifyInvitationsUDEmailsReceived();

    }


}