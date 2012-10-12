package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUDSauce;


public class UD_Admin_Create_RoundUP extends iTestCaseUDSauce {

    //Declare articleID to pass to the checker
    String articleID;

    @Test (groups = {"RoundUpCreate"})
    public void loginAdmin(){
        loginUDAdmin();
        articleID = createRoundUP(); //return the articleid that was created
    }

    @Test (dependsOnGroups = {"RoundUpCreate"})
    public void check() {
        confirmRoundUP(articleID);
    }
}