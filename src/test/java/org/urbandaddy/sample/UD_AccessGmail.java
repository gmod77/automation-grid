package org.urbandaddy.sample;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUD;


public class UD_AccessGmail extends iTestCaseUD {

    @Test
    public void googleLogin() {
        loginToGmail();
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
