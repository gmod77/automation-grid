package org.urbandaddy.tests.sauce;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.sauce.iTestCasePerksSauce;



public class Perks_Admin_CreatePerk extends iTestCasePerksSauce {

    @Test (groups = {"Perk Create"},retryAnalyzer = Analyzer.class)
	public void createPerk(){
        Reporter.log("Login to Perks Admin",true);
        adminPerksLogin();

        Reporter.log("Create Perk",true);
        adminCreatePerk();

        Reporter.log("Filling out General Tab",true);
        adminCreatePerkGeneral();

        Reporter.log("Filling out Inventory Counters",true);
        adminCreatePerkInventoryCounters();

        Reporter.log("Filling out perk Price Tab",true);
        adminCreatePerkPrice();

        Reporter.log("Filling out perk Inventory Tab",true);
        adminCreatePerkInventory();

        Reporter.log("Filling out Website Tab",true);
        adminCreatePerkWebSite();

        Reporter.log("Filling out Perk Categories Tab",true);
        adminCreatePerkCategories();

        Reporter.log("Filling out Perk Reporting Tab",true);
        adminCreatePerkReporting();

        Reporter.log("Saving perk",true);
        adminCreatePerkSave();

        Reporter.log("Make Perk visible", true);
        makePerkVisible();
	}

}
