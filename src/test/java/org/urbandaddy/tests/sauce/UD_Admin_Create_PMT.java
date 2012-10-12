package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUDSauce;

public class UD_Admin_Create_PMT extends iTestCaseUDSauce {

    @Test (groups = "Smoke")
    public void flow1(){
        loginUDAdmin();
        createMemberSource();
        createPMT();
    }

}