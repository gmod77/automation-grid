package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.com.sauce.iTestCaseUDSauce;


public class UD_Admin_Article_Three_ColumnTest extends iTestCaseUDSauce {

    @Test (groups = "Smoke")
	public void createThreeColumnArticle(){

	loginUDAdmin();
	createArticleThreeColumn();
		
	}

}