package org.urbandaddy.tests.sauce.saucetesting;

import org.testng.annotations.Test;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_SimpleChecksSauceTest extends iTestCaseUDSauce {
    String date;
    String emailClient;
    String[] emailFriends;

    public UD_SimpleChecksSauceTest() {
        emailFriends = new String[5];
    }

//    @Test (groups = {"regression"})
//    public void CheckWhileLoggedOut(){
//
//        Reporter.log("Visiting Home Page for the first time", true);
//        visitUDFirstTime();
//
//        Reporter.log("Doing checks on the home page links", true);
//        doHomePageChecks();
//
//        Reporter.log("Access New York from the UD Homepage", true);
//        accessNewYorkFromUDHomepage();
//
//        Reporter.log("Do checks while logged out", true);
//        doChecksCityHomePageLoggedOut();
//    }

    @Test (groups = {"shareArticle", "shareloggedOut"})
    public void UDshareArticleLoggedOut(){
        visitUDFirstTime();
        accessNewYorkFromUDHomepage();
        shareArticle(emailClient, emailFriends);
    }

    @Test (groups = {"shareArticle"}, dependsOnGroups = {"shareloggedOut"})
    public void checkSharedArticleLoggedOut(){
        emailHelper_Client = new EmailHelper_Client(client);

        emailHelper_Client.loginToGmail();
        emailHelper_Client.verifySharedArticleLoggedOutReceived(emailFriends);
        emailHelper_Client.logoutGmail();

    }

    @Test (groups = {"shareArticle", "shareloggedIn"})
    public void UDshareArticleLoggedIn(){
        visitUDFirstTime();
        accessNewYorkFromUDHomepage();
        signUpUD_viaNewYorkStep1(emailClient);
        signUpUD_viaNewYorkStep2(date);
        signUpUD_viaNewYorkStep3(emailFriends,true);
        signUpUD_viaNewYorkStep4();
        goBackToUDHomepage();
        shareArticle(emailClient,emailFriends);
    }

    @Test (groups = {"shareArticle"}, dependsOnGroups = {"shareloggedIn"})
    public void checkSharedArticleLoggedIn() {
        emailHelper_Client = new EmailHelper_Client(client);

        emailHelper_Client.loginToGmail();
        emailHelper_Client.verifySharedArticleLoggedInReceived(emailClient,emailFriends);
        emailHelper_Client.logoutGmail();
    }

}