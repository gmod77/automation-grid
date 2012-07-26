package org.urbandaddy.tests;
import org.urbandaddy.helpers.Comm.ITestCase;
import org.testng.annotations.Test;




public class UD_Admin_Article_Weekender extends ITestCase {
	
	@Test (groups = "Smoke")
	public void flow1(){loginUDAdmin();createArticleWeekender();
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
