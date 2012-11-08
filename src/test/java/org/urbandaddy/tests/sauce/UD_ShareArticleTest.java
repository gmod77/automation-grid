package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_ShareArticleTest extends iTestCaseUDSauce {

    String dateA;
    String emailClientA;
    String[] emailFriendsA;

    String dateB;
    String emailClientB;
    String[] emailFriendsB;


    public UD_ShareArticleTest() {
        emailFriendsA = new String[5];
        emailFriendsB = new String[5];
    }

    @Test (groups = {"shareArticle", "shareloggedOut"}, retryAnalyzer = Analyzer.class)
    public void UDshareArticleLoggedOut(){
        emailHelper_Client = new EmailHelper_Client(client);

        dateA = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        emailClientA = emailHelper_Client.generateEmailClient(dateB);
        emailFriendsA = emailHelper_Client.generateFriendClient(5,dateA);

        Reporter.log("Visit UD for the first time",true);
        visitUDFirstTime();

        Reporter.log("Access New York Edition",true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Sharing an article",true);
        shareArticle(emailClientA, emailFriendsA);
    }

    @Test (groups = {"shareArticle"}, dependsOnGroups = {"shareloggedOut"})
    public void checkSharedArticleLoggedOut(){
        emailHelper_Client = new EmailHelper_Client(client);

        Reporter.log("Logging into Gmail",true);
        emailHelper_Client.loginToGmail();

        Reporter.log("Verifying articles were received",true);
        emailHelper_Client.verifySharedArticleLoggedOutReceived(emailFriendsA);

        Reporter.log("Logging out of Gmail",true);
        emailHelper_Client.logoutGmail();

    }

    @Test (groups = {"shareArticle", "shareloggedIn"}, retryAnalyzer = Analyzer.class)
    public void UDshareArticleLoggedIn(){
        emailHelper_Client = new EmailHelper_Client(client);

        dateB = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        emailClientB = emailHelper_Client.generateEmailClient(dateB);
        emailFriendsB = emailHelper_Client.generateFriendClient(5,dateB);

        Reporter.log("Visit UD for the first time",true);
        visitUDFirstTime();

        Reporter.log("Access New York Edition",true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Create an account",true);
        Reporter.log("Sign up Step 1",true);
        signUpUD_viaNewYorkStep1(emailClientB);
        signUpUD_viaNewYorkStepA();
        signUpUD_viaNewYorkStepB();
        Reporter.log("Sign up Step 2",true);
        signUpUD_viaNewYorkStep2(dateB);
        Reporter.log("Sign up Step 3",true);
        signUpUD_viaNewYorkStep3(emailFriendsB);
        signUpUD_viaNewYorkStep35();
        Reporter.log("Sign u Step 4",true);
        signUpUD_viaNewYorkStep4();
        Reporter.log("Returning to the homepage",true);
        goBackToUDHomepage();

        Reporter.log("Sharing article",true);
        shareArticle(emailClientB, emailFriendsB);
    }

    @Test (groups = {"shareArticle"}, dependsOnGroups = {"shareloggedIn"})
    public void checkSharedArticleLoggedIn() {
        emailHelper_Client = new EmailHelper_Client(client);

        Reporter.log("Logging into Gmail",true);
        emailHelper_Client.loginToGmail();

        Reporter.log("Verifying articles were shared",true);
        emailHelper_Client.verifySharedArticleLoggedInReceived(emailClientB, emailFriendsB);

        Reporter.log("Logging out of Gmail",true);
        emailHelper_Client.logoutGmail();
    }

}