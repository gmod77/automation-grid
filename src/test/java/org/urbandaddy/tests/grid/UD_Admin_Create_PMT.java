package org.urbandaddy.tests.grid;

import org.testng.annotations.Test;
import org.urbandaddy.com.grid.iTestCaseUD;



//Before Class
public class UD_Admin_Create_PMT extends iTestCaseUD {

//Before Method
@Test (groups = "Smoke")
public void flow1(){
	loginUDAdmin();
	createMemberSource();
	createPMT();
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