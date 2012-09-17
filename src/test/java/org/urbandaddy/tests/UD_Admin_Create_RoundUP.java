package org.urbandaddy.tests;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.ITestCase;


public class UD_Admin_Create_RoundUP extends ITestCase {

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