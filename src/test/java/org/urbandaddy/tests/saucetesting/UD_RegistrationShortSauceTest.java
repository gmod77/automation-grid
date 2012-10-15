package org.urbandaddy.tests.saucetesting;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUDSauce;


public class UD_RegistrationShortSauceTest extends iTestCaseUDSauce {
	
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

        Reporter.log("Log in to Gmail", true);
        loginToGmail();
//
//        Reporter.log("Verify Welcome to UD Email was received", true);
//        verifyWelcomeUDEmailReceived();
//
//        Reporter.log("Verify Invitation Email was received", true);
//        verifyInvitationsUDEmailsReceived();

    }


}