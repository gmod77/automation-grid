package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.helpers.Comm.iTestCaseUDSauce;


public class UD_Admin_Article_Three_Column extends iTestCaseUDSauce {
	
	@Test (groups = "Smoke")
	public void createThreeColumnArticle(){

	loginUDAdmin();
	createArticleThreeColumn();
		
	}

}
