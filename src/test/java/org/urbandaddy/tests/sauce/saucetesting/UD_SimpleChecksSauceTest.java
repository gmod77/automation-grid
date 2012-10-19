package org.urbandaddy.tests.sauce.saucetesting;

import org.testng.annotations.Test;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_SimpleChecksSauceTest extends iTestCaseUDSauce {

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
        shareArticle();
    }

    @Test (groups = {"shareArticle"}, dependsOnGroups = {"shareloggedOut"})
    public void checkSharedArticleLoggedOut(){
        emailHelper_Client = new EmailHelper_Client(client);

        emailHelper_Client.loginToGmail();
        emailHelper_Client.verifySharedArticleLoggedOutReceived(emailFriend1,emailFriend2,emailFriend3,emailFriend4,emailFriend5);
        emailHelper_Client.logoutGmail();

    }

    @Test (groups = {"shareArticle", "shareloggedIn"})
    public void UDshareArticleLoggedIn(){
        visitUDFirstTime();
        accessNewYorkFromUDHomepage();
        signUpUD_viaNewYork();
        goBackToUDHomepage();
        shareArticle();
    }

    @Test (groups = {"shareArticle"}, dependsOnGroups = {"shareloggedIn"})
    public void checkSharedArticleLoggedIn() {
        emailHelper_Client = new EmailHelper_Client(client);

        emailHelper_Client.loginToGmail();
        emailHelper_Client.verifySharedArticleLoggedInReceived(emailClient,emailFriend1,emailFriend2,emailFriend3,emailFriend4,emailFriend5);
        emailHelper_Client.logoutGmail();
    }

}