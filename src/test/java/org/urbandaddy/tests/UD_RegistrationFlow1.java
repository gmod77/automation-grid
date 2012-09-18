package org.urbandaddy.tests;
import org.urbandaddy.helpers.Comm.iTestCaseUD;
import org.testng.annotations.Test;




public class UD_RegistrationFlow1 extends iTestCaseUD {
	
	@Test (groups = "Smoke")
	public void flow1(){
		visitUDFirstTime();
		//1. client signs up and logs in

		accessAtlantaFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
		changeCityFromUDHomepage();

		accessBostonFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
		changeCityFromUDHomepage();
		
		accessChicagoFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
		changeCityFromUDHomepage();
		
		accessDallasFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
		changeCityFromUDHomepage();
		
		accessWashingtonDCFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
		changeCityFromUDHomepage();
		
		accessLasVegasFromUDHomepage();
		doChecksLVPageLoggedOut();
		
		changeCityFromUDHomepage();
		
		accessLosAngelesFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
		changeCityFromUDHomepage();
		
		accessMiamiFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
		changeCityFromUDHomepage();
		
		accessNationalFromUDHomepage();
		doChecksNationalPageLoggedOut();
		
		changeCityFromUDHomepage();
		
		accessNewYorkFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
		accessSanFranciscoFromUDHomepage();
		doChecksCityHomePageLoggedOut();
		
//go back to new york and signup		
//		changeCityFromUDHomepage();
//		accessNewYorkFromUDHomepage();
//
//		signUpUD_viaNewYork();
//		doChecksCityHomePageLoggedIn();
//		
//		logoutUD();
//		doChecksCityHomePageLoggedOut();
//		
//		loginUD();
//		doChecksCityHomePageLoggedIn();

		
//		loginClient();
		
		//check the header is in place
//		checkHeaderClient();
		
		
		// both sign out
//		signOutClient();

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
