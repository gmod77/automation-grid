package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_Admin_Article_WeekenderTest extends iTestCaseUDSauce {

    @Test (groups = "Smoke")
    public void createWeekenderArticle(){
        loginUDAdmin();
        createArticleWeekender();
    }


}