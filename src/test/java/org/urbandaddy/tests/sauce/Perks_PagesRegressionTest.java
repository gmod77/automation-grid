package org.urbandaddy.tests.sauce;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.sauce.iTestCasePerksSauce;

import java.util.List;


public class Perks_PagesRegressionTest extends iTestCasePerksSauce {
//    national
//    new-york
//    chicago
//    boston
//    washington-dc
//    los-angeles

	@Test (groups = {"PerksRegression"}, retryAnalyzer = Analyzer.class)
	public void perksRegressionNational() throws Exception {
        int count = 0;
        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
		visitPerksProdFirstTime("national");

        List<WebElement> editionBlocks = getEditionBlocks();

        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);

        for (String perk : getPerkNameAndText(editionBlocks)) {
            count++;
            Reporter.log("Perk " +count + "> " + perk,true);
        }

        checkPerksPages(getPerksLinks(editionBlocks));

    }

    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
    public void perksRegressionNewYork() throws Exception{
        int count = 0;

        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
        visitPerksProdFirstTime("new-york");

        List<WebElement> editionBlocks = getEditionBlocks();

        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);

        for (String perk : getPerkNameAndText(editionBlocks)) {
            count++;
            Reporter.log("Perk " +count + "> " + perk,true);
        }

        checkPerksPages(getPerksLinks(editionBlocks));

    }

    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
    public void perksRegressionChicago() throws Exception{
        int count = 0;
        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
        visitPerksProdFirstTime("chicago");

        List<WebElement> editionBlocks = getEditionBlocks();

        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);

        for (String perk : getPerkNameAndText(editionBlocks)) {
            count++;
            Reporter.log("Perk " +count + "> " + perk,true);
        }

        checkPerksPages(getPerksLinks(editionBlocks));

    }

    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
    public void perksRegressionBoston() throws Exception{
        int count = 0;
        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
        visitPerksProdFirstTime("boston");

        List<WebElement> editionBlocks = getEditionBlocks();

        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);

        for (String perk : getPerkNameAndText(editionBlocks)) {
            count++;
            Reporter.log("Perk " +count + "> " + perk,true);
        }

        checkPerksPages(getPerksLinks(editionBlocks));

    }

    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
    public void perksRegressionDC() throws Exception{
        int count = 0;
        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
        visitPerksProdFirstTime("washington-dc");

        List<WebElement> editionBlocks = getEditionBlocks();

        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);

        for (String perk : getPerkNameAndText(editionBlocks)) {
            count++;
            Reporter.log("Perk " +count + "> " + perk,true);
        }

        checkPerksPages(getPerksLinks(editionBlocks));

    }

    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
    public void perksRegressionLA() throws Exception{
        int count = 0;
        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
        visitPerksProdFirstTime("los-angeles");

        List<WebElement> editionBlocks = getEditionBlocks();

        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);

        for (String perk : getPerkNameAndText(editionBlocks)) {
            count++;
            Reporter.log("Perk " +count + "> " + perk,true);
        }

        checkPerksPages(getPerksLinks(editionBlocks));

    }
}
