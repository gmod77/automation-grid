package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;

public class UD_Admin_Create_PMTTest extends iTestCaseUDSauce {
    String date;

    @Test (groups = "Smoke", retryAnalyzer = Analyzer.class)
    public void createPMTArticle(){
        emailHelper_Client = new EmailHelper_Client(client);
        date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        String memberSource = "Member Source "+date;

        loginUDAdmin();
        createMemberSource(memberSource);
        createPMT(memberSource);
    }

}