package org.urbandaddy.tests.saucetesting;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUDSauce;


public class UD_SimpleChecksSauceTest extends iTestCaseUDSauce {


    @Test (groups = {"regression"})
    public void CheckWhileLoggedOut(){

        Reporter.log("Visiting Home Page for the first time", true);
        visitUDFirstTime();

//        Reporter.log("Doing checks on the home page links", true);
//        doHomePageChecks();
//
//        Reporter.log("Access New York from the UD Homepage", true);
//        accessNewYorkFromUDHomepage();
//
//        Reporter.log("Do checks while logged out", true);
//        doChecksCityHomePageLoggedOut();
    }


}