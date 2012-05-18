//package org.urbandaddy.tests;
//import org.urbandaddy.helpers.Comm.ITestCase_test;
//import org.testng.annotations.Test;
//
//
////Flow 1 with Solr reindexing
//
//public class testFlow extends ITestCase_test {
//	
//	@Test 
//	public void flow1(){
//		//1. client signs up and logs in
//		signUpClient();
//		
////		reindexSolr();
//		
//		loginClient();
//		//accessSettingsClient();
//		
//		//check the header is in place
//		checkHeaderClient();
//		
//		//Fund the account
//		fundClientAccount_Wald();
//		
//		// client enables Terms
//		accessPaymentSettingsClient();
//		enableStatementsClient();
//		
//		//2.  client invites a Resource 
//		inviteResourceClient();
//		
//		//3. Resource checks email, accepts invitation, signs up and confirms
//		signUpResourceViaInvitation();
//		
//		//Resource logs in and checks the header
//		loginResource();
//		checkHeaderResource();
//		
//		for(int i=1; i<101; i++){
//			System.out.println(i);
//		//4. client goes to /resources and creates a new assignment for the Resource he/she just invited
//		createAssignmentViaresourcesAndSend();
//		
//		
//		//5. Resource views Assignment, counter-offers
//		viewAssignmentsResourceSelfBeforeAccepted();
//		counterofferResourceSelf();
//		
//		//6. Client Accepts Counter offer
//		acceptCounterofferClientSelf();
//		
//		//7.   Resource Confirms
//		confirm_Resource_Self();
//		
//		//8. Client adds Private Note
//		addPrivateNote_Client_Self();
//		
//		//9.   Resource Checks In
//		checkIn_Resource_Self();
//		
//		//10. Client adds Public Note
//		addPublicNote_Client_Self();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		//11.  Resource Checks Out
//		checkOut_Resource_Self();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		//12. Resource marks assignment complete
//		completeAssignment_Resource_Self();
//		
//		//13. Client approves
//		approveAssignment_Client_Self();
//		
//		}
//		
//		// both sign out
//		signOutClient();
//		signOutResource();
//		signOutWald();
//	}
//	
//	@Override
//	public void beforeMethod() {
//
//	}
//
//	@Override
//	public void afterMethod() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void beforeClass() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void afterClass() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void beforeTest() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void afterTest() {
//		// TODO Auto-generated method stub
//
//	}
//
//}
