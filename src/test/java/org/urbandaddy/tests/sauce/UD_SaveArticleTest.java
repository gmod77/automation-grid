package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_SaveArticleTest extends iTestCaseUDSauce {

    String date;
    String emailClient;
    String[] emailFriends;

    public UD_SaveArticleTest() {
        emailFriends = new String[5];
    }

    @Test (groups = {"saveArticle", "saveArticleloggedIn"}, retryAnalyzer = Analyzer.class)
    public void UDsaveArticleLoggedIn(){
        emailHelper_Client = new EmailHelper_Client(client);

        date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        emailClient = emailHelper_Client.generateEmailClient(date);
        emailFriends = emailHelper_Client.generateFriendClient(5,date);

        Reporter.log("Visit UD for the first time",true);
        visitUDFirstTime();

        Reporter.log("Access New York Edition",true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Create an account",true);
        //signUpUD_viaNewYork();
        signUpUD_viaNewYorkStep1(emailClient);
        signUpUD_viaNewYorkStep2(date);
        signUpUD_viaNewYorkStep3(emailFriends);
        signUpUD_viaNewYorkStep4();


        Reporter.log("Returning to the homepage",true);
        goBackToUDHomepage();

        Reporter.log("Saving article",true);
        saveArticleToAccount();
    }

}