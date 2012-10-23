package org.urbandaddy.tests.sauce;

import junit.framework.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_UnSubscribeEmailTest extends iTestCaseUDSauce {

    @Test (groups = {"unsubscribe", "createAndUnsubscribe"})
    public void UDUnsubscribeLoggedIn(){
        Reporter.log("Visit UD for the first time",true);
        visitUDFirstTime();

        Reporter.log("Access New York Edition",true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Create an account:",true);
        Reporter.log("Sign up Step 1",true);
        signUpUD_viaNewYorkStep1();
        Reporter.log("Sign up Step 2",true);
        signUpUD_viaNewYorkStep2();
        Reporter.log("Sign up Step 3",true);
        signUpUD_viaNewYorkStep3();
        Reporter.log("Sign up Step 4",true);
        signUpUD_viaNewYorkStep4();

        Reporter.log("Returning to the homepage",true);
        goBackToUDHomepage();

        Reporter.log("Return to My UD and unsubscribe", true);
        unSubscribeFromEmails();

        Reporter.log("Log out of UD");
        logoutUD();

    }

    @Test (groups = {"unsubscribe"}, dependsOnGroups = {"createAndUnsubscribe"})
    public void unsubscribeConfirmation() {
        emailHelper_Client = new EmailHelper_Client(client);

        Reporter.log("Logging into Gmail",true);
        emailHelper_Client.loginToGmail();

        Reporter.log("Searching For Account Modification Email",true);
        Boolean flag = emailHelper_Client.doEmailSearch("To: " + emailClient + " Subject: You've Changed After: " + gMailSearchDate.format(now),30000);
        Assert.assertTrue("Email wasn't found", flag);

        Reporter.log("Confirming Email",true);
        emailHelper_Client.searchEmail("successfully unsubscribed");

        Reporter.log("Logging out of Gmail",true);
        emailHelper_Client.logoutGmail();
    }

}