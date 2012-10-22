package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_SaveArticleTest extends iTestCaseUDSauce {

    @Test (groups = {"saveArticle", "saveArticleloggedIn"})
    public void UDsaveArticleLoggedIn(){
        Reporter.log("Visit UD for the first time",true);
        visitUDFirstTime();

        Reporter.log("Access New York Edition",true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Create an account",true);
        signUpUD_viaNewYork();

        Reporter.log("Returning to the homepage",true);
        goBackToUDHomepage();

        Reporter.log("Saving article",true);
        saveArticleToAccount();
    }

}