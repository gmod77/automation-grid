package org.urbandaddy.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUDSauce;


public class UD_RegistrationSauceTest extends iTestCaseUDSauce {
	
	@Test (groups = "Smoke")
	public void flow1(){
        Reporter.log("Visiting Home Page for the first time", true);
        visitUDFirstTime();

        Reporter.log("Access New York from the UD Homepage", true);
        accessNewYorkFromUDHomepage();

        Reporter.log("Sign up for a new account", true);
        signUpUD_viaNewYork();

        Reporter.log("Log out", true);
        logoutUD();
    }

}
