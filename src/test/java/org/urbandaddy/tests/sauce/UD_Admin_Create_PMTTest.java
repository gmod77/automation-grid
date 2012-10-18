package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;

public class UD_Admin_Create_PMTTest extends iTestCaseUDSauce {

    @Test (groups = "Smoke")
    public void createPMTArticle(){
        loginUDAdmin();
        createMemberSource();
        createPMT();
    }

}