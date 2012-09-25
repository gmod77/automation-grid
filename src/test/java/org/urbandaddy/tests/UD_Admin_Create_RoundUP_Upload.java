package org.urbandaddy.tests;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUD;


public class UD_Admin_Create_RoundUP_Upload extends iTestCaseUD {

    //Declare articleID to pass to the checker
    String articleID;

    @Test (groups = {"RoundUpCreate"})
    public void loginAdmin(){
        loginUDAdmin();
        createRoundUPUpload();
    }

    @Override
    public void beforeMethod() {

    }

    @Override
    public void afterMethod() {
    // TODO Auto-generated method stub

    }

    @Override
    public void beforeClass() {
    // TODO Auto-generated method stub

    }

    @Override
    public void afterClass() {
    // TODO Auto-generated method stub

    }

    @Override
    public void beforeTest() {
    // TODO Auto-generated method stub

    }

    @Override
    public void afterTest() {
    // TODO Auto-generated method stub

    }

}