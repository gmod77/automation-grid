package org.urbandaddy.tests;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.ITestCase;


public class UD_Admin_Create_RoundUP extends ITestCase {

@Test (groups = "Smoke")
public void flow1(){
	loginUDAdmin();
	createRoundUP();
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