package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.helpers.CheckEmailHelper_Client;
import org.urbandaddy.helpers.Comm.iTestCaseUDSauce;


public class UD_RegistrationShortSauceTest extends iTestCaseUDSauce {
	
	@Test (groups = {"regression", "register"})
    public void UDregisterAndCheck(){

        Reporter.log("Visiting Home Page for the first time", true);
        visitUDFirstTime();

        Reporter.log("Access New York from the UD Homepage", true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Sign up for a new account", true);
        signUpUD_viaNewYork();

        Reporter.log("Edit settings", true);
        editSettingsUD();

        Reporter.log("Log out", true);
        logoutUD();

        Reporter.log("Return to homepage", true);
        goBackToUDHomepage();
    }


    @Test (groups = {"check"}, dependsOnGroups = {"register"})
    public void verifyUDEmailsReceived(){
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        Reporter.log("Log in to Gmail", true);
        checkEmailHelper_Client.loginToGmail();

        Reporter.log("Verify Welcome to UD Email was received", true);
        checkEmailHelper_Client.verifyWelcomeUDEmailReceived(emailClient);

        Reporter.log("Verify Invitation Email was received", true);
        checkEmailHelper_Client.verifyInvitationsUDEmailsReceived(emailFriend1, emailFriend2, emailFriend3, emailFriend4, emailFriend5);


    }


}