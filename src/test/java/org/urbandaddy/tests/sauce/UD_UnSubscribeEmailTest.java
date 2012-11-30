package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_UnSubscribeEmailTest extends iTestCaseUDSauce {
    String date;
    String emailClient;
    String[] emailFriends;

    public UD_UnSubscribeEmailTest() {
        emailFriends = new String[5];
    }

    @Test (groups = {"unsubscribe", "createAndUnsubscribe"}, retryAnalyzer = Analyzer.class)
    public void UDUnsubscribeLoggedIn(){
        emailHelper_Client = new EmailHelper_Client(client);

        date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        emailClient = emailHelper_Client.generateEmailClient(date);
        emailFriends = emailHelper_Client.generateFriendClient(5,date);

        Reporter.log("Visit UD for the first time",true);
        visitUDFirstTime();

        Reporter.log("Access New York Edition",true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Create an account:",true);
        Reporter.log("Sign up Step 1",true);
        signUpUD_viaNewYorkStep1(emailClient);
        Reporter.log("Sign up Step 2",true);
        signUpUD_viaNewYorkStep2(date);
        Reporter.log("Sign up Step 3",true);
        signUpUD_viaNewYorkStep3(emailFriends, true);
        Reporter.log("Sign u Step 4",true);
        signUpUD_viaNewYorkStep4();

        Reporter.log("Returning to the homepage",true);
        goBackToUDHomepage();

        Reporter.log("Return to My UD and unsubscribe", true);
        unSubscribeFromEmails();

        Reporter.log("Log out of UD");
        logoutUD();

    }

    @Test (groups = {"unsubscribe"}, dependsOnGroups = {"createAndUnsubscribe"}, retryAnalyzer = Analyzer.class)
    public void unsubscribeConfirmation() {
        emailHelper_Client = new EmailHelper_Client(client);
        String date = emailHelper_Client.generateDate("yy/MM/dd");

        Reporter.log("Logging into Gmail",true);
        emailHelper_Client.loginToGmail();

        Reporter.log("Searching For Account Modification Email",true);
        Boolean flag = emailHelper_Client.doEmailSearch("To: " + emailClient + " Subject: You've Changed After: " + date,60000);

        if (flag) {
            Reporter.log("Confirming Email",true);
            emailHelper_Client.searchEmail("successfully unsubscribed");
        } else {
            Reporter.log("WARNING: Unsubscribe email was not found. Manually confirm.",true);
        }

        Reporter.log("Logging out of Gmail",true);
        emailHelper_Client.logoutGmail();
    }

}