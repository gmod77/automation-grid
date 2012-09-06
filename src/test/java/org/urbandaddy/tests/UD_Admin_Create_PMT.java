package org.urbandaddy.tests;
import org.urbandaddy.helpers.Comm.ITestCase;
import org.testng.annotations.Test;




public class UD_Admin_Create_PMT extends ITestCase {

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