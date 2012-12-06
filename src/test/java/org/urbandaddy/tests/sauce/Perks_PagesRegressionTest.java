package org.urbandaddy.tests.sauce;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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
//
    @Parameters ({"prodCheck"})
	@Test (groups = {"PerksRegression"}, retryAnalyzer = Analyzer.class)
	public void perksRegressionNational(String prodCheck) throws Exception {

        int count = 0;
        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);

        String city = "national";

        if (prodCheck.equals("false")) {
            visitPerksFirstTime(city);
        } else {
            visitPerksProdFirstTime(city);
        }

        List<WebElement> editionBlocks = getEditionBlocks();

        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);

        for (String perk : getPerkNameAndText(editionBlocks)) {
            count++;
            Reporter.log("Perk " +count + "> " + perk,true);
        }

        checkPerksPages(getPerksLinks(editionBlocks));

    }
//
//    @Parameters ({"prodCheck"})
//    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
//    public void perksRegressionNewYork(@Optional("false") String prodCheck) throws Exception{
//        int count = 0;
//
//        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
//
//        String city = "new-york";
//
//        if (prodCheck.equals("false")) {
//            visitPerksFirstTime(city);
//        } else {
//            visitPerksProdFirstTime(city);
//        }
//        List<WebElement> editionBlocks = getEditionBlocks();
//
//        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);
//
//        for (String perk : getPerkNameAndText(editionBlocks)) {
//            count++;
//            Reporter.log("Perk " +count + "> " + perk,true);
//        }
//
//        checkPerksPages(getPerksLinks(editionBlocks));
//
//    }
//
//    @Parameters ({"prodCheck"})
//    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
//    public void perksRegressionChicago(@Optional("false") String prodCheck) throws Exception{
//        int count = 0;
//        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
//
//        String city = "chicago";
//
//        if (prodCheck.equals("false")) {
//            visitPerksFirstTime(city);
//        } else {
//            visitPerksProdFirstTime(city);
//        }
//
//        List<WebElement> editionBlocks = getEditionBlocks();
//
//        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);
//
//        for (String perk : getPerkNameAndText(editionBlocks)) {
//            count++;
//            Reporter.log("Perk " +count + "> " + perk,true);
//        }
//
//        checkPerksPages(getPerksLinks(editionBlocks));
//
//    }
//
//    @Parameters ({"prodCheck"})
//    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
//    public void perksRegressionBoston(@Optional("false") String prodCheck) throws Exception{
//        int count = 0;
//        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
//
//        String city = "boston";
//
//        if (prodCheck.equals("false")) {
//            visitPerksFirstTime(city);
//        } else {
//            visitPerksProdFirstTime(city);
//        }
//
//        List<WebElement> editionBlocks = getEditionBlocks();
//
//        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);
//
//        for (String perk : getPerkNameAndText(editionBlocks)) {
//            count++;
//            Reporter.log("Perk " +count + "> " + perk,true);
//        }
//
//        checkPerksPages(getPerksLinks(editionBlocks));
//
//    }
//
//    @Parameters ({"prodCheck"})
//    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
//    public void perksRegressionDC(@Optional("false") String prodCheck) throws Exception{
//        int count = 0;
//        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
//
//        String city = "washington-dc";
//
//        if (prodCheck.equals("false")) {
//            visitPerksFirstTime(city);
//        } else {
//            visitPerksProdFirstTime(city);
//        }
//
//        List<WebElement> editionBlocks = getEditionBlocks();
//
//        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);
//
//        for (String perk : getPerkNameAndText(editionBlocks)) {
//            count++;
//            Reporter.log("Perk " +count + "> " + perk,true);
//        }
//
//        checkPerksPages(getPerksLinks(editionBlocks));
//
//    }
//
//    @Parameters ({"prodCheck"})
//    @Test (groups = "PerksRegression", retryAnalyzer = Analyzer.class)
//    public void perksRegressionLA(@Optional("false") String prodCheck) throws Exception{
//        int count = 0;
//        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
//
//        String city = "los-angeles";
//
//        if (prodCheck.equals("false")) {
//            visitPerksFirstTime(city);
//        } else {
//            visitPerksProdFirstTime(city);
//        }
//
//        List<WebElement> editionBlocks = getEditionBlocks();
//
//        Reporter.log("Perks found on page> " + getPerksLinkCount(),true);
//
//        for (String perk : getPerkNameAndText(editionBlocks)) {
//            count++;
//            Reporter.log("Perk " +count + "> " + perk,true);
//        }
//
//        checkPerksPages(getPerksLinks(editionBlocks));
//
//    }
}
