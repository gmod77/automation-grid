package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_ShareArticle extends iTestCaseUDSauce {

    @Test (groups = {"shareArticle", "shareloggedOut"})
    public void UDshareArticleLoggedOut(){
        Reporter.log("Visit UD for the first time",true);
        visitUDFirstTime();

        Reporter.log("Access New York Edition",true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Sharing an article",true);
        shareArticle();
    }

    @Test (groups = {"shareArticle"}, dependsOnGroups = {"shareloggedOut"})
    public void checkSharedArticleLoggedOut(){
        emailHelper_Client = new EmailHelper_Client(client);

        Reporter.log("Logging into Gmail",true);
        emailHelper_Client.loginToGmail();

        Reporter.log("Verifying articles were received",true);
        emailHelper_Client.verifySharedArticleLoggedOutReceived(emailFriend1,emailFriend2,emailFriend3,emailFriend4,emailFriend5);

        Reporter.log("Logging out of Gmail",true);
        emailHelper_Client.logoutGmail();

    }

    @Test (groups = {"shareArticle", "shareloggedIn"})
    public void UDshareArticleLoggedIn(){
        Reporter.log("Visit UD for the first time",true);
        visitUDFirstTime();

        Reporter.log("Access New York Edition",true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Create an account",true);
        signUpUD_viaNewYork();

        Reporter.log("Returning to the homepage",true);
        goBackToUDHomepage();

        Reporter.log("Sharing article",true);
        shareArticle();
    }

    @Test (groups = {"shareArticle"}, dependsOnGroups = {"shareloggedIn"})
    public void checkSharedArticleLoggedIn() {
        emailHelper_Client = new EmailHelper_Client(client);

        Reporter.log("Logging into Gmail",true);
        emailHelper_Client.loginToGmail();

        Reporter.log("Verifying articles were shared",true);
        emailHelper_Client.verifySharedArticleLoggedInReceived(emailClient,emailFriend1,emailFriend2,emailFriend3,emailFriend4,emailFriend5);

        Reporter.log("Logging out of Gmail",true);
        emailHelper_Client.logoutGmail();
    }

}