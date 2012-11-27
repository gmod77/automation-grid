package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.sauce.iTestCasePerksSauce;



public class Perks_Admin_CreatePerk extends iTestCasePerksSauce {

    @Test (groups = {"Smoke"})
	public void createPerk(){
        Reporter.log("Login to Perks Admin",true);
        adminPerksLogin();

        Reporter.log("Create Perk",true);
        adminCreatePerk();

	}

}
