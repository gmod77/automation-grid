package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCasePerksSauce;


public class Perks_PagesRegressionTest extends iTestCasePerksSauce {
    String date;
    String emailClient;
    String[] emailFriends;

    public Perks_PagesRegressionTest() {
        emailFriends = new String[5];
    }
	@Test (groups = "perkSmoke", retryAnalyzer = Analyzer.class)
	public void perksRegression(){

		visitPerksFirstTime();

	    checkPerksPages(getPerksLinks(getPerksLinkCount()));

    }

}
