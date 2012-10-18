package org.urbandaddy.tests.grid;

import org.testng.annotations.Test;
import org.urbandaddy.com.grid.iTestCaseUD;




public class UD_Admin_Article_Three_Column extends iTestCaseUD {
	
	@Test (groups = "Smoke")
	public void flow1(){
	
		
	loginUDAdmin();
	createArticleThreeColumn();
		
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
