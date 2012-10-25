package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_Admin_Create_RoundUPTest extends iTestCaseUDSauce {

    //Declare articleID to pass to the checker
    String articleID;

    @Test (groups = {"RoundUpCreate"}, retryAnalyzer = Analyzer.class)
    public void RoundUPAdminCreate(){
        loginUDAdmin();
        articleID = createRoundUP(); //return the articleid that was created
    }

    @Test (dependsOnGroups = {"RoundUpCreate"})
    public void checkRoundUp() {
        confirmRoundUP(articleID);
    }
}