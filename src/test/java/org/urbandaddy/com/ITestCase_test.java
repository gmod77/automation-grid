//package org.urbandaddy.helpers.com;
//
//import java.io.File;
//import java.util.Date;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Parameters;
//
////Workflow specific imports
//
//import org.urbandaddy.helpers.AssignmentDetailsHelper_Client;
//import org.urbandaddy.helpers.AssignmentDetailsHelper_Resource;
//import org.urbandaddy.helpers.CreateAssignmentHelper_Client;
//import org.urbandaddy.helpers.FundHelper_Wald;
//import org.urbandaddy.helpers.HeaderHelper_Client;
//import org.urbandaddy.helpers.HeaderHelper_Resource;
//import org.urbandaddy.helpers.HeaderHelper_Wald;
//import org.urbandaddy.helpers.InvitationsHelper_Client;
//import org.urbandaddy.helpers.LoginHelper_Client;
//import org.urbandaddy.helpers.LoginHelper_Resource;
//import org.urbandaddy.helpers.LoginHelper_Wald;
//import org.urbandaddy.helpers.ReauthenticateHelper_Client;
//import org.urbandaddy.helpers.ReauthenticateHelper_Resource;
//import org.urbandaddy.helpers.SelectresourcesHelper_Client;
//import org.urbandaddy.helpers.SettingsHelper_Client;
////import org.urbandaddy.helpers.SSHHelper;
//
////import org.urbandaddy.helpers.Comm.ITestCase;
////import org.testng.Assert;
////import org.testng.annotations.Test;
////import org.urbandaddy.helpers.SignupHelper;
//
//import org.urbandaddy.helpers.SignupHelper_Client;
//import org.urbandaddy.helpers.SignupHelper_Resource;
//
//public abstract class ITestCase_test {
//
//	enum DriverType {
//		Firefox, IE, Ghrome
//	}
//
//	public WebDriver client;
//	public WebDriver resource;
//	public WebDriver wald;
//	
//	@BeforeMethod
//	@Parameters({ "driverType", "profilePath" })
//	public void beforeMainMethod(String driverType, String profilePath) {
//		// TODO: some config xml file
//		if (DriverType.Firefox.toString().equals(driverType)) {
//			
//			if (profilePath == null || profilePath.isEmpty()) {
//				client = new FirefoxDriver();
//				resource = new FirefoxDriver();
//				wald = new FirefoxDriver();
//			} else {
//				File file = new File(profilePath);
//				FirefoxProfile profile = new FirefoxProfile(file);
//				client = new FirefoxDriver(profile);
//				resource = new FirefoxDriver(profile);
//				wald = new FirefoxDriver(profile);
//			}
//			
//		} else if (DriverType.IE.toString().equals(driverType)) {
//			client = new InternetExplorerDriver();
//			resource = new InternetExplorerDriver();
//			wald = new InternetExplorerDriver();
//		} else if (DriverType.Ghrome.toString().equals(driverType)) {
//			client = new ChromeDriver();
//			resource = new ChromeDriver();
//			wald = new ChromeDriver();
//		} else {
//			client = new FirefoxDriver();
//			resource = new FirefoxDriver();
//			wald = new FirefoxDriver();
//		}
//
//		this.beforeMethod();
//	}
//
//	//declare helpers
//	private AssignmentDetailsHelper_Client assignmentDetailsHelper_Client;	
//	private AssignmentDetailsHelper_Resource assignmentDetailsHelper_Resource;	
//
//	private CreateAssignmentHelper_Client createAssignmentHelper_Client;
//	
//	private FundHelper_Wald fundHelper_Wald;
//	
//	private HeaderHelper_Client headerHelper_Client;
//	private HeaderHelper_Resource headerHelper_Resource;
//	private HeaderHelper_Wald headerHelper_Wald;
//	
//	private InvitationsHelper_Client invitationsHelper_Client;
//
//	private LoginHelper_Client loginHelper_Client;
//	private LoginHelper_Resource loginHelper_Resource;
//	private LoginHelper_Wald loginHelper_Wald;
//	
//	private ReauthenticateHelper_Client reauthenticateHelper_Client;
//	private ReauthenticateHelper_Resource reauthenticateHelper_Resource;
//
//	private SelectresourcesHelper_Client selectresourcesHelper_Client;
//	private SettingsHelper_Client settingsHelper_Client;
//
//	private SignupHelper_Client signupHelper_Client;
//	private SignupHelper_Resource signupHelper_Resource;
//	
////	private SSHHelper sSHHelper;
//	private String[] blah;
//	
//	//declare variables
//	private String actualURL;
//	private String expectedURL;
//	
//	private String AssignmentURL;
//	
//	private String firstNameResourceIndividual;
//	private String companyNameResourceIndividual;
//	
//	private String firstNameResource;
//	private String companyNameResource;
//	
//	private String firstNameClientIndividual;
//	private String companyNameClientIndividual;
//	
//	private String firstNameClient;
//	private String companyNameClient;
//	
//	private String firstNameHybridIndividual;
//	private String companyNameHybridIndividual;
//	
//	private String firstNameHybrid;
//	private String companyNameHybrid;
//	
//	//set unique role names using time stamp
//	Date now = new java.util.Date(); 
//	java.text.DateFormat emailFormat = new java.text.SimpleDateFormat("MM_dd_yyyy_HH_mm_SSS");
//	String emailPrefix = "qa+", emailSuffix="@urbandaddy.com"; 
//	String emailResource = emailPrefix + "Resource_" + emailFormat.format(now) + emailSuffix; 
//	String emailResourceIndividual = emailPrefix + "ResourceIndividual_" + emailFormat.format(now) + emailSuffix;
//	String emailClient = emailPrefix + "Client_" + emailFormat.format(now) + emailSuffix; 
//	String emailClientIndividual = emailPrefix + "ClientIndividual_" + emailFormat.format(now) + emailSuffix; 
//	String emailHybrid = emailPrefix + "Hybrid_" + emailFormat.format(now) + emailSuffix; 
//	String emailHybridIndividual = emailPrefix + "HybridIndividual_" + emailFormat.format(now) + emailSuffix; 
//	String assignmentTitle = "Regression Test Assignment" + emailFormat.format(now);
//		
//	private String domain = "https://qa.urbandaddy.com";
//	private String domainWithPassword = "https://wmarket:labor1@qa.urbandaddy.com";
//
////	public void reindexSolr(){
////		sSHHelper = new SSHHelper();
////		sSHHelper.reindexSolr(blah);
////	}
//
/////// Sign-up methods
//	
//// Hybrid Individual
//	
//	public void signUpHybridIndividual(){
//		this.client.navigate().to(domain);
//		
//
//		firstNameHybridIndividual = "HybridI" + "_" + emailFormat.format(now);
//		companyNameHybridIndividual = "Hybrid Individual Company" + "_" + emailFormat.format(now);
//		
//		signupHelper_Client.checkBoth();
//		signupHelper_Client.enterFirstName(firstNameHybridIndividual);
//		signupHelper_Client.enterLastName("HybridIndividual");
//		signupHelper_Client.enterEmail(emailHybridIndividual);
//		signupHelper_Client.enterZipCode("100021");
//		client.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//		signupHelper_Client.enterPhoneNumber("2122121222");
//		signupHelper_Client.enterExtension("4568");
//		signupHelper_Client.enterCompanyName(companyNameHybridIndividual);
//		signupHelper_Client.industrySelect("Technology and Communications");
//		signupHelper_Client.checkIndividual();
//		signupHelper_Client.enterPassword("labor1");
//		signupHelper_Client.checkTermsOfUse();
//		signupHelper_Client.clickGetStarted();
//		
//		///make sure you end up on Thank You page
//		expectedURL = domain+"/public/thankyou";
//		actualURL = client.getCurrentUrl();
//		Assert.assertEquals(actualURL, expectedURL);
//		
//		//get text from H1
//		signupHelper_Client.isTextExpextedH1();
//		signupHelper_Client.isTextExpextedP1();
//		signupHelper_Client.isTextExpextedP1();
//		
//		//go to gmail and confirm your email address
//		this.client.navigate().to("https://mail.google.com/");
//		signupHelper_Client.clientLogInToGmail();
//		signupHelper_Client.findAndClickSignupEmail(firstNameHybridIndividual);
//		
//		// Verify confirmation message
//		signupHelper_Client.isAccountConfirmed();
//		
//	}
//	
//	// Hybrid
//	
//		public void signUpHybrid(){
//			this.client.navigate().to(domain);
//			
//
//			firstNameHybrid = "Hybrid" + "_" + emailFormat.format(now);
//			companyNameHybrid = "Hybrid Company" + "_" + emailFormat.format(now);
//			
//			signupHelper_Client.checkBoth();
//			signupHelper_Client.enterFirstName(firstNameHybrid);
//			signupHelper_Client.enterLastName("Hybrid");
//			signupHelper_Client.enterEmail(emailHybrid);
//			signupHelper_Client.enterZipCode("100021");
//			client.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//			signupHelper_Client.enterPhoneNumber("2122121222");
//			signupHelper_Client.enterExtension("4568");
//			signupHelper_Client.enterCompanyName(companyNameHybrid);
//			signupHelper_Client.industrySelect("Technology and Communications");
//			signupHelper_Client.enterPassword("labor1");
//			signupHelper_Client.checkTermsOfUse();
//			signupHelper_Client.clickGetStarted();
//			
//			///make sure you end up on Thank You page
//			expectedURL = domain+"/public/thankyou";
//			actualURL = client.getCurrentUrl();
//			Assert.assertEquals(actualURL, expectedURL);
//			
//			//get text from H1
//			signupHelper_Client.isTextExpextedH1();
//			signupHelper_Client.isTextExpextedP1();
//			signupHelper_Client.isTextExpextedP1();
//			
//			//go to gmail and confirm your email address
//			this.client.navigate().to("https://mail.google.com/");
//			signupHelper_Client.clientLogInToGmail();
//			signupHelper_Client.findAndClickSignupEmail(firstNameHybrid);
//			
//			// Verify confirmation message
//			signupHelper_Client.isAccountConfirmed();
//			
//		}	
//	
//// 	Client Individual
//	
//	public void signUpClientIndividual(){
//		this.client.navigate().to(domainWithPassword);
//		
//
//		firstNameClientIndividual = "ClientI" + "_" + emailFormat.format(now);
//		companyNameClientIndividual = "Client Individual Company" + "_" + emailFormat.format(now);
//		
//		signupHelper_Client.checkFind();
//		signupHelper_Client.enterFirstName(firstNameClientIndividual);
//		signupHelper_Client.enterLastName("ClientIndividual");
//		signupHelper_Client.enterEmail(emailClientIndividual);
//		signupHelper_Client.enterZipCode("100021");
//		client.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//		signupHelper_Client.enterPhoneNumber("2122121222");
//		signupHelper_Client.enterExtension("4568");
//		signupHelper_Client.enterCompanyName(companyNameClientIndividual);
//		signupHelper_Client.industrySelect("Technology and Communications");
//		signupHelper_Client.checkIndividual();
//		signupHelper_Client.enterPassword("labor1");
//		signupHelper_Client.checkTermsOfUse();
//		signupHelper_Client.clickGetStarted();
//		
//		///make sure you end up on Thank You page
//		expectedURL = domain+"/public/thankyou";
//		actualURL = client.getCurrentUrl();
//		Assert.assertEquals(actualURL, expectedURL);
//		
//		//get text from H1
//		signupHelper_Client.isTextExpextedH1();
//		signupHelper_Client.isTextExpextedP1();
//		signupHelper_Client.isTextExpextedP1();
//		
//		//go to gmail and confirm your email address
//		this.client.navigate().to("https://mail.google.com/");
//		signupHelper_Client.clientLogInToGmail();
//		signupHelper_Client.findAndClickSignupEmail(firstNameClientIndividual);
//		
//		// Verify confirmation message
//		signupHelper_Client.isAccountConfirmed();
//		
//	}	
//	
//// 	Client
//	
//	public void signUpClient(){
//		this.client.navigate().to(domainWithPassword);
//		signupHelper_Client = new SignupHelper_Client(client);
//
//		firstNameClient = "C" + "_" + emailFormat.format(now);
//		companyNameClient = "CCompany" + "_" + emailFormat.format(now);
//		
//		signupHelper_Client.checkFind();
//		signupHelper_Client.enterFirstName(firstNameClient);
//		signupHelper_Client.enterLastName("Client");
//		signupHelper_Client.enterEmail(emailClient);
//		signupHelper_Client.enterZipCode("100021");
//		client.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//		signupHelper_Client.enterPhoneNumber("2122121222");
//		signupHelper_Client.enterExtension("4568");
//		signupHelper_Client.enterCompanyName(companyNameClient);
//		signupHelper_Client.industrySelect("Technology and Communications");
//		signupHelper_Client.enterPassword("labor1");
//		signupHelper_Client.checkTermsOfUse();
//		signupHelper_Client.clickGetStarted();
//		
//		///make sure you end up on Thank You page
//		expectedURL = domain+"/public/thankyou";
//		actualURL = client.getCurrentUrl();
//		Assert.assertEquals(actualURL, expectedURL);
//		
//		//get text from H1
//		signupHelper_Client.isTextExpextedH1();
//		signupHelper_Client.isTextExpextedP1();
//		signupHelper_Client.isTextExpextedP1();
//		
//		//go to gmail and confirm your email address
//		this.client.navigate().to("https://mail.google.com/");
//		signupHelper_Client.clientLogInToGmail();
//		signupHelper_Client.findAndClickSignupEmail(firstNameClient);
//		
//		// Verify confirmation message
//		signupHelper_Client.isAccountConfirmed();
//		System.out.println(emailClient);		
//	}	
//	
//// 	Resource Individual
//	
//	public void signUpResourceIndividual(){
//		this.resource.navigate().to(domain);
//		
//
//		firstNameResourceIndividual = "Doe" + "_" + emailFormat.format(now);
//		companyNameResourceIndividual = "Resource Individual Company" + "_" + emailFormat.format(now);
//		
//		signupHelper_Resource.checkGet();
//		signupHelper_Resource.enterFirstName(firstNameResourceIndividual);
//		signupHelper_Resource.enterLastName("ResourceIndividual");
//		signupHelper_Resource.enterEmail(emailResourceIndividual);
//		signupHelper_Resource.enterZipCode("100021");
//		resource.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//		signupHelper_Resource.enterPhoneNumber("2122121222");
//		signupHelper_Resource.enterExtension("4568");
//		signupHelper_Resource.enterCompanyName(companyNameResourceIndividual);
//		signupHelper_Resource.industrySelect("Technology and Communications");
//		signupHelper_Resource.checkIndividual();
//		signupHelper_Resource.enterPassword("labor1");
//		signupHelper_Resource.checkTermsOfUse();
//		signupHelper_Resource.clickGetStarted();
//		
//		///make sure you end up on Thank You page
//		expectedURL = domain+"/public/thankyou";
//		actualURL = resource.getCurrentUrl();
//		Assert.assertEquals(actualURL, expectedURL);
//		
//		//get text from H1
//		signupHelper_Resource.isTextExpextedH1();
//		signupHelper_Resource.isTextExpextedP1();
//		signupHelper_Resource.isTextExpextedP1();
//		
//		//go to gmail and confirm your email address
//		this.resource.navigate().to("https://mail.google.com/");
//		signupHelper_Resource.resourceLogInToGmail();
//		signupHelper_Resource.findAndClickSignupEmail(firstNameResourceIndividual);
//		
//		// Verify confirmation message
//		signupHelper_Resource.isAccountConfirmed();
//		
//	}	
//
//// 	Resource 
//	
//	public void signUpResource(){
//		this.resource.navigate().to(domain);
//		
//
//		firstNameResource = "Doe" + "_" + emailFormat.format(now);
//		companyNameResource = "Resource Company" + "_" + emailFormat.format(now);
//		
//		signupHelper_Resource.checkGet();
//		signupHelper_Resource.enterFirstName(firstNameResource);
//		signupHelper_Resource.enterLastName("ResourceIndividual");
//		signupHelper_Resource.enterEmail(emailResource);
//		signupHelper_Resource.enterZipCode("100021");
//		resource.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
//		signupHelper_Resource.enterPhoneNumber("2122121222");
//		signupHelper_Resource.enterExtension("4568");
//		signupHelper_Resource.enterCompanyName(companyNameResource);
//		signupHelper_Resource.industrySelect("Technology and Communications");
//		signupHelper_Resource.enterPassword("labor1");
//		signupHelper_Resource.checkTermsOfUse();
//		signupHelper_Resource.clickGetStarted();
//		
//		///make sure you end up on Thank You page
//		expectedURL = domain+"/public/thankyou";
//		actualURL = resource.getCurrentUrl();
//		Assert.assertEquals(actualURL, expectedURL);
//		
//		//get text from H1
//		signupHelper_Resource.isTextExpextedH1();
//		signupHelper_Resource.isTextExpextedP1();
//		signupHelper_Resource.isTextExpextedP1();
//		
//		//go to gmail and confirm your email address
//		this.resource.navigate().to("https://mail.google.com/");
//		signupHelper_Resource.resourceLogInToGmail();
//		signupHelper_Resource.findAndClickSignupEmail(firstNameResource);
//		
//		// Verify confirmation message
//		signupHelper_Resource.isAccountConfirmed();
//		
//	}
//	
//// 	Resource via Invitation from Client
//	
//	public void signUpResourceViaInvitation(){
//		//go to gmail and find your invitations
//		
//		signupHelper_Resource = new SignupHelper_Resource(resource);
//		
//		this.resource.navigate().to(domainWithPassword);
//		this.resource.navigate().to("https://mail.google.com/");
//		signupHelper_Resource.resourceLogInToGmail();
//		signupHelper_Resource.findAndClickInvitationEmail(firstNameResource);
//		//you now should be on /register/invitation/<invitation_code>
//		
//		// fill out the form
//		//signupHelper.EnterFirstNameInvitation(firstNameResource);
//		//signupHelper.EnterLastNameInvitation("Resource");
//		signupHelper_Resource.enterPhoneNumberInvitation("2122121222");
//		signupHelper_Resource.enterPasswordInvitation("labor1");
//		signupHelper_Resource.enterCompanyName(companyNameResource);
//		signupHelper_Resource.industrySelectInvitation("Technology and Communications");
//		signupHelper_Resource.enterZipCodeInvitation("10021");
//		signupHelper_Resource.checkTermsOfUseInvitation();
//		signupHelper_Resource.clickJoinurbandaddy();
//		
//		///you should be on /register/thankyou page
//				//expectedURL = "https://qa.urbandaddy.com/register/thankyou?i=" + invitationCode;
//				//actualURL = driver.getCurrentUrl();
//				//Assert.assertEquals(actualURL, expectedURL);
//	
//		//verify text on thank you page
//		//signupHelper.isTextExpextedH1();
//		//signupHelper.isTextExpextedP1();
//		//signupHelper.isTextExpextedP1();
//		
//		//go to gmail and confirm your email address
//		this.resource.navigate().to("https://mail.google.com/");
//		signupHelper_Resource.resourceLogInToGmail();
//		signupHelper_Resource.findAndClickSignupEmail(firstNameResource);
//		
//		// Verify confirmation message
//		signupHelper_Resource.isAccountConfirmed();
//		
//	}	
/////////////// Sign-up methods end here		
//	
/////////////// Fund client account	
//	public void fundClientAccount_Wald(){
//		//go to gmail and find your invitations
//		//this.client.navigate().to(domain+"/home");
//		this.wald.navigate().to(domainWithPassword+"/home");
//		loginHelper_Wald = new LoginHelper_Wald(wald);
//		fundHelper_Wald = new FundHelper_Wald(wald);
//		
//		loginHelper_Wald.enterSignonEmailAddress("jwald@urbandaddy.com");
//		loginHelper_Wald.enterSignonPassword("labor1");
//		loginHelper_Wald.clickSubmit();
//		
//		//navigate to Company Search
//		this.wald.navigate().to(domain+"/admin/manage/company/search");
//		//enter company name into search box
//		fundHelper_Wald.enterCompanyName(companyNameClient);
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		//click the company name
//		wald.findElement(By.partialLinkText(companyNameClient)).click(); 
//		//edit AP limit
//		fundHelper_Wald.clickEditLimit();
//		fundHelper_Wald.enterNewLimit("250000");
//		fundHelper_Wald.clickUpdate();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		// override bank setup
//		fundHelper_Wald.clickOverrideBankSetup();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		fundHelper_Wald.enterOverridePopupText("test "+now);
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		fundHelper_Wald.submitOverridePopupText();
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		//now go to Manage company funds
//		this.wald.navigate().to(domain+"/admin/accounting/managefunds");
//		fundHelper_Wald.enterCompanyNameManageFunds(companyNameClient);
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		fundHelper_Wald.clickCompanyNameManageFundsFirstOption();
//		
//		fundHelper_Wald.enterAmount("1000000");
//		
//		fundHelper_Wald.selectReason("Check deposit");
//		
//		fundHelper_Wald.clickSubmit();
//
//		
//	}
/////////////// Fund client account ends here	
//	
/////////////// Assignment related methods
//	
//	public void viewAssignmentsResourceSelfBeforeAccepted(){		
//		assignmentDetailsHelper_Resource = new AssignmentDetailsHelper_Resource(resource);
//
//		// if not FullCycle, needs to check for Assignment status = "Sent"
//		// go to Assignment URL;
//		this.resource.navigate().to(AssignmentURL);
//		//assignmentDetailsHelper_Resource.assertCustomFieldNotPresent();
//		//assignmentDetailsHelper.assertCustomFieldNotPresent();
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}
//	}
//		
//	public void selectResourceAndSendFullCycleClient(){
//		selectresourcesHelper_Client = new SelectresourcesHelper_Client(client);
//
//		// client logs-in, checks header, creates Assignment 
//		createAssignmentFullCycleClient();
//		selectresourcesHelper_Client.selectResource();
//		client.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//		selectresourcesHelper_Client.sendAssignment();
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}	
//		
//		AssignmentURL = client.getCurrentUrl();
//		System.out.println(AssignmentURL);
//
//	}
//	
//	public void selectResourceAndSend(){
//		selectresourcesHelper_Client = new SelectresourcesHelper_Client(client);
//
//		selectresourcesHelper_Client.selectResource();
//
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}
//		
//		selectresourcesHelper_Client.sendAssignment();
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}	
//		
//		AssignmentURL = client.getCurrentUrl();
//		System.out.println(AssignmentURL);
//
//	}
//	
//	public void createAssignmentFullCycleClient(){
//		createAssignmentHelper_Client = new CreateAssignmentHelper_Client(client);
//		//login, check header
//		checkHeaderFullCycle_Client();
//		headerHelper_Client.clickAssignmentsDropdown_Create_Assignment();
//		createAssignmentHelper_Client.templateSelect("One attachment on terms");
//		createAssignmentHelper_Client.saveDraft();
//		client.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//		createAssignmentHelper_Client.enterFlatFee("0.01");	
//		createAssignmentHelper_Client.selectresources();
//		client.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//	}
//	
//	public void createAssignment(){
//		createAssignmentHelper_Client = new CreateAssignmentHelper_Client(client);
//
//		headerHelper_Client.clickAssignmentsDropdown_Create_Assignment();
//		createAssignmentHelper_Client.templateSelect("One attachment on terms");
//		createAssignmentHelper_Client.saveDraft();
//		client.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
//		createAssignmentHelper_Client.enterFlatFee("0.01");	
//		createAssignmentHelper_Client.selectresources();
//		client.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
//	}
//	
//	public void createAssignmentViaresourcesAndSend(){
//		createAssignmentHelper_Client = new CreateAssignmentHelper_Client(client);
//
//		this.client.navigate().to(domain+"/resources");
//		// get resource ID
//		
//		//shnooze for a second
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}
//		
//		String resourceLink = client.findElement(By.partialLinkText(firstNameResource)).getAttribute("href"); 
//		
//	    String[] separated = resourceLink.split("/");
//	    String resourceID = separated[separated.length - 1];
//	    //String resourceID = resourceLink.substring(40,47);
//	    
//	    
//		//click send assignment
//		this.client.navigate().to("https://qa.urbandaddy.com/assignments/add?for="+ resourceID);		
//		
//		createAssignmentHelper_Client.enterTitle(assignmentTitle);
//		createAssignmentHelper_Client.enterDescription();
//		createAssignmentHelper_Client.enterInstructions();
//		createAssignmentHelper_Client.checkVirtualLocation();
//		createAssignmentHelper_Client.enterDate("12/16/2012");
//		createAssignmentHelper_Client.enterTime("8:30am");
//		createAssignmentHelper_Client.enterFlatFee("100.00");	
//		
//		createAssignmentHelper_Client.requireConfirmation();	
//		createAssignmentHelper_Client.enterConfirmationHours("1.00");
//		createAssignmentHelper_Client.requireCheckInOut();	
//		
//		createAssignmentHelper_Client.industrySelect("Technology and Communications");
//		createAssignmentHelper_Client.termsSelect("7 days");
//
//
//		createAssignmentHelper_Client.sendAssignment();	
//		
//		AssignmentURL = client.getCurrentUrl();
//		System.out.println(AssignmentURL);		
//	}
//	
//	public void completeAssignment_Resource_Self(){
//		assignmentDetailsHelper_Resource = new AssignmentDetailsHelper_Resource(resource);	
//		
//		this.resource.navigate().to(AssignmentURL);
//		assignmentDetailsHelper_Resource.clickCompleteAssignment();
//		assignmentDetailsHelper_Resource.enterCloseoutNotes("Test Closeout Notes "+now);
//		assignmentDetailsHelper_Resource.enterReviewNotes("Test Review Notes "+now);
//		assignmentDetailsHelper_Resource.clickSubmitForApproval();
//	}
//	
//	public void approveAssignment_Client_Self(){
//		assignmentDetailsHelper_Client = new AssignmentDetailsHelper_Client(client);	
//		
//		this.client.navigate().to(AssignmentURL);
//		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}
//		
//		assignmentDetailsHelper_Client.enterReviewNotes("Test Review Notes "+now);
//		assignmentDetailsHelper_Client.clickApproveAssignment();
//	}
//	
//	public void confirm_Resource_Self(){
//		assignmentDetailsHelper_Resource = new AssignmentDetailsHelper_Resource(resource);	
//		
//		this.resource.navigate().to(AssignmentURL);
//		
//		assignmentDetailsHelper_Resource.clickConfirm();
//	}
//	
//	public void checkIn_Resource_Self(){
//		assignmentDetailsHelper_Resource = new AssignmentDetailsHelper_Resource(resource);	
//		
//		this.resource.navigate().to(AssignmentURL);
//		
//		assignmentDetailsHelper_Resource.clickCheckIn();
//	}
//	
//	public void checkOut_Resource_Self(){
//		assignmentDetailsHelper_Resource = new AssignmentDetailsHelper_Resource(resource);	
//		
//		this.resource.navigate().to(AssignmentURL);
//		
//		assignmentDetailsHelper_Resource.clickCheckOut();
//	}
//	
//	
/////////////// Assignment related methods end here	approveAssignment_Client_Self
//
////////////// CounterOffer methods	
//	
//	public void counterofferResourceSelf(){
//		assignmentDetailsHelper_Resource = new AssignmentDetailsHelper_Resource(resource);	
//		
//		// click Counter Offer
//		//assignmentDetailsHelper_Resource.clickCounterOffer();
//		resource.findElement(By.linkText("Counter Offer")).click();
//
//		// on the Suggest Alternate Date or Price popup
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}
//		// enter Proposed Rate
//		assignmentDetailsHelper_Resource.enterProposedRate("101.01");
//		assignmentDetailsHelper_Resource.addNote("counter offer "+now);
//		assignmentDetailsHelper_Resource.clickProposeAlternateDateTime();
//		assignmentDetailsHelper_Resource.enterProposedDate("12/17/2012");
//		assignmentDetailsHelper_Resource.enterProposedTime("9:30am");		
//		assignmentDetailsHelper_Resource.submitProposal();	
//	}
//	
//	public void acceptCounterofferClientSelf(){
//		assignmentDetailsHelper_Client = new AssignmentDetailsHelper_Client(client);	
//		
//		this.client.navigate().to(AssignmentURL);
//		assignmentDetailsHelper_Client.approveCounteroffer();
//
//		//client.findElement(By.partialLinkText("Approve")).click();
//		//client.findElement(By.className("accept-negotiation btn primary")).click();
//	}
//		
////////////// CounterOffer methods end here
//	
/////////////// AddNote methods 	
//	
//	public void addPrivateNote_Client_Self(){
//		assignmentDetailsHelper_Client = new AssignmentDetailsHelper_Client(client);	
//		
//		this.client.navigate().to(AssignmentURL);
//		assignmentDetailsHelper_Client.clickAddNote();
//		assignmentDetailsHelper_Client.selectPrivate();
//		assignmentDetailsHelper_Client.enterNote("Private test note "+now);
//		assignmentDetailsHelper_Client.clickAddNote2();
//
//		//client.findElement(By.partialLinkText("Approve")).click();
//		//client.findElement(By.className("accept-negotiation btn primary")).click();
//	}
//	
//	public void addPublicNote_Client_Self(){
//		assignmentDetailsHelper_Client = new AssignmentDetailsHelper_Client(client);	
//		
//		this.client.navigate().to(AssignmentURL);
//		assignmentDetailsHelper_Client.clickAddNote();
//		assignmentDetailsHelper_Client.selectPublic();
//		assignmentDetailsHelper_Client.enterNote("Public test note "+now);
//		assignmentDetailsHelper_Client.clickAddNote2();
//
//		//client.findElement(By.partialLinkText("Approve")).click();
//		//client.findElement(By.className("accept-negotiation btn primary")).click();
//	}
//	
/////////////// AddNote methods end here
//	
///////////// Invitation methods
//	
//	public void inviteResourceClient(){
//		headerHelper_Client = new HeaderHelper_Client(client);
//		invitationsHelper_Client = new InvitationsHelper_Client(client);
//		
//		// go to Invitations
//		headerHelper_Client.clickresourcesDropdown_Invitations();
//		
//		// hit "Send Invitations"
//		invitationsHelper_Client.clickSendInvitations();
//		
//		// fill out the form with unique FirstName and email
//		firstNameResource = "R" + "_" + emailFormat.format(now);
//		companyNameResource = "RCompany" + "_" + emailFormat.format(now);
//	
//		invitationsHelper_Client.enterFirstName(firstNameResource);
//		invitationsHelper_Client.enterLastName("Resource");
//		invitationsHelper_Client.enterEmail(emailResource);
//		invitationsHelper_Client.clickSendInvitation();
//	}
//	
///////////// Invitation methods end here
//
//////////////// Settings methods
//	
//	public void accessSettingsClient(){
//		headerHelper_Client = new HeaderHelper_Client(client);
//		reauthenticateHelper_Client = new ReauthenticateHelper_Client(client);
//
//		headerHelper_Client.ClickDropdownToggle_SettingsOptionClient();
//		reauthenticateHelper_Client.enterConfirmEmailAddress(emailClient);
//		reauthenticateHelper_Client.enterConfirmPassword("labor1");	
//		reauthenticateHelper_Client.clickConfirm();
//	}	
//	
//	public void accessPaymentSettingsClient(){
//		headerHelper_Client = new HeaderHelper_Client(client);
//		reauthenticateHelper_Client = new ReauthenticateHelper_Client(client);
//
//		//headerHelper_Client.ClickDropdownToggle_SettingsOptionClient();
//		//go to /mmw/manage/paymenterms
//		this.client.navigate().to(domain+"/mmw/manage/paymenterms");
//		reauthenticateHelper_Client.enterConfirmEmailAddress(emailClient);
//		reauthenticateHelper_Client.enterConfirmPassword("labor1");	
//		reauthenticateHelper_Client.clickConfirm();
//		//this.client.findElement(By.linkText("Payment Settings")).click();
//	}
//	
//	public void enableStatementsClient(){
//		settingsHelper_Client = new SettingsHelper_Client(client);
//
//		settingsHelper_Client.clickConfigurePaymentTerms();
//		//step 1
//		settingsHelper_Client.selectStatements();
//		settingsHelper_Client.next();
//		//step 2
//		settingsHelper_Client.selectMonthly();
//		settingsHelper_Client.statementsMonthlyDaysSelect("13");
//		settingsHelper_Client.next();
//		//step 3
//		settingsHelper_Client.select1day();
//		settingsHelper_Client.next();
//		//step 4 
//		settingsHelper_Client.selectCreditCard();
//		settingsHelper_Client.next();
//		//step 5
//		//settingsHelper_Client.enableAutoPay();
//		settingsHelper_Client.next();
//		//step 6
//		//submit
//		settingsHelper_Client.next();
//		//back
//		//settingsHelper_Client.back();
//
//	}
//	
//	public void accessSettingsResource(){
//		headerHelper_Resource = new HeaderHelper_Resource(resource);
//		reauthenticateHelper_Resource = new ReauthenticateHelper_Resource(resource);
//		
//		headerHelper_Resource.ClickDropdownToggle_SettingsOptionResource();
//		reauthenticateHelper_Resource.enterConfirmEmailAddress(emailResource);
//		reauthenticateHelper_Resource.enterConfirmPassword("labor1");
//		reauthenticateHelper_Resource.clickConfirm();
//	}	
////////////////Settings methods end here
//	
/////////////////  Login/SignOut methods
//	
//	public void loginHybrid(){
//		loginHelper_Client = new LoginHelper_Client(client);
//
//		this.client.navigate().to(domain+"/home");
//		
//		loginHelper_Client.enterSignonEmailAddress(emailHybrid);
//		loginHelper_Client.enterSignonPassword("labor1");
//		loginHelper_Client.clickSubmit();
//	} 
//	
//	public void loginHybridIndivdual(){
//		loginHelper_Client = new LoginHelper_Client(client);
//
//		this.client.navigate().to(domain+"/home");
//		
//		loginHelper_Client.enterSignonEmailAddress(emailHybridIndividual);
//		loginHelper_Client.enterSignonPassword("labor1");
//		loginHelper_Client.clickSubmit();
//	} 
//	
//	public boolean loginClient(){
//		loginHelper_Client = new LoginHelper_Client(client);
//
//		this.client.navigate().to(domain+"/home");
//		
//		loginHelper_Client.enterSignonEmailAddress(emailClient);
//		loginHelper_Client.enterSignonPassword("labor1");
//		loginHelper_Client.clickSubmit();
//		
//		if (resource.getCurrentUrl().equals(domain + "/home"))
//			return true;
//		return false;
//	} 
//	
//	public void loginClientIndivdual(){
//		loginHelper_Client = new LoginHelper_Client(client);
//
//		this.client.navigate().to(domain+"/home");
//		
//		loginHelper_Client.enterSignonEmailAddress(emailClientIndividual);
//		loginHelper_Client.enterSignonPassword("labor1");
//		loginHelper_Client.clickSubmit();
//	} 
//	 	
//	public boolean loginResource(){
//		loginHelper_Resource = new LoginHelper_Resource(resource);
//
//		this.resource.navigate().to(domain+"/home");
//		
//		loginHelper_Resource.enterSignonEmailAddress(emailResource);
//		loginHelper_Resource.enterSignonPassword("labor1");
//		loginHelper_Resource.clickSubmit();
//		
//		if (resource.getCurrentUrl().equals(domain + "/home"))
//			return true;
//		return false;
//	}
//	
//	public void loginResourceIndividual(){
//		loginHelper_Resource = new LoginHelper_Resource(resource);
//
//		this.resource.navigate().to(domain+"/home");
//		
//		loginHelper_Resource.enterSignonEmailAddress(emailResourceIndividual);
//		loginHelper_Resource.enterSignonPassword("labor1");
//		loginHelper_Resource.clickSubmit();
//	}
//	
//	public void signOutClient(){
//		headerHelper_Client = new HeaderHelper_Client(client);
//
//		headerHelper_Client.clickSignOut();
//	}
//	
//	public void signOutResource(){
//		headerHelper_Resource = new HeaderHelper_Resource(resource);
//
//		headerHelper_Resource.clickSignOut();
//	}
//	
//	public void signOutWald(){
//		headerHelper_Wald = new HeaderHelper_Wald(wald);
//
//		headerHelper_Wald.clickSignOut();
//	}
/////////////////  Login/SignOut methods end here
//	
//
/////////// Check Methods
//// check if Assignments menu is displayed
//	//@Test //(dependsOnMethods = { "clientLogin" })
//	public void checkHeaderFullCycle_Client(){
//		headerHelper_Client = new HeaderHelper_Client(client);
//		// login first
//		loginClient();
//			Assert.assertTrue(headerHelper_Client.isAssigmentsDropdownPresent());
//		
//// mouse over Assignments
//		headerHelper_Client.mouseOverAssignmentsDropdown();
//		
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isAssigmentDashboardPresent());
//			Assert.assertTrue(headerHelper_Client.isProjectsPresent());
//			Assert.assertTrue(headerHelper_Client.isRatingsPresent());
//			Assert.assertTrue(headerHelper_Client.isReportsPresent());
//			Assert.assertTrue(headerHelper_Client.isLocationManagerPresent());
//			Assert.assertTrue(headerHelper_Client.isWMRealtimePresent());
//			Assert.assertTrue(headerHelper_Client.isCreateAssignmentPresent());
//			
//// check if resources menu is displayed
//			Assert.assertTrue(headerHelper_Client.isresourcesDropdownPresent());
//			
//// mouse over resources
//		headerHelper_Client.mouseOverresourcesDropdown();
//			
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isPeopleSearchPresent());
//			Assert.assertTrue(headerHelper_Client.isGroupsPresent());
//			Assert.assertTrue(headerHelper_Client.isInvitationsPresent());
//			Assert.assertTrue(headerHelper_Client.isRecruitingCampaignsPresent());
//			Assert.assertTrue(headerHelper_Client.isScreeningToolsPresent());
//			Assert.assertTrue(headerHelper_Client.isLearningCenterPresent());
//			Assert.assertTrue(headerHelper_Client.isSurveysPresent());
//			                       
//// check if Payments menu is displayed
//			Assert.assertTrue(headerHelper_Client.isPaymentsDropdownPresent());			
////mouse over Payments
//			headerHelper_Client.mouseOverPaymentsDropdown();
//		
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isPaymentCenterPresent());
//			Assert.assertTrue(headerHelper_Client.isInvoicesPresent());
//			Assert.assertTrue(headerHelper_Client.isBankAccountsPresent());
//
//// check if Search menu is displayed
//			Assert.assertTrue(headerHelper_Client.isSearchDropdownPresent());			
////mouse over Payments
//			headerHelper_Client.mouseOverSearchDropdown();
//					
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isSearchSelectPresent());
//			Assert.assertTrue(headerHelper_Client.isAssignmentsOptionPresent());
//			Assert.assertTrue(headerHelper_Client.isresourcesOptionPresent());
//			Assert.assertTrue(headerHelper_Client.isGroupsOptionPresent());
//			Assert.assertTrue(headerHelper_Client.isEnterSearchTermsBoxPresent());
//			Assert.assertTrue(headerHelper_Client.isSearchButtonPresent());
//	
//// check if Add menu is displayed
//			Assert.assertTrue(headerHelper_Client.isAddDropdownPresent());			
////mouse over Add menue
//			headerHelper_Client.mouseOverAddDropdown();
//								
//			// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isAssigmentPresent());
//			Assert.assertTrue(headerHelper_Client.isProjectPresent());
//			Assert.assertTrue(headerHelper_Client.isLocationClientPresent());
//			Assert.assertTrue(headerHelper_Client.isGroupPresent());
//			Assert.assertTrue(headerHelper_Client.isInvitationPresent());
//			Assert.assertTrue(headerHelper_Client.isCampaignPresent());	
//			Assert.assertTrue(headerHelper_Client.isTestPresent());			
//			Assert.assertTrue(headerHelper_Client.isSurveyPresent());			
//	}
//	
//	
//	public void checkHeaderClient(){
//		headerHelper_Client = new HeaderHelper_Client(client);
//			Assert.assertTrue(headerHelper_Client.isAssigmentsDropdownPresent());
//		
//// mouse over Assignments
//		headerHelper_Client.mouseOverAssignmentsDropdown();
//		
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isAssigmentDashboardPresent());
//			Assert.assertTrue(headerHelper_Client.isProjectsPresent());
//			Assert.assertTrue(headerHelper_Client.isRatingsPresent());
//			Assert.assertTrue(headerHelper_Client.isReportsPresent());
//			Assert.assertTrue(headerHelper_Client.isLocationManagerPresent());
//			Assert.assertTrue(headerHelper_Client.isWMRealtimePresent());
//			Assert.assertTrue(headerHelper_Client.isCreateAssignmentPresent());
//			
//// check if resources menu is displayed
//			Assert.assertTrue(headerHelper_Client.isresourcesDropdownPresent());
//			
//// mouse over resources
//		headerHelper_Client.mouseOverresourcesDropdown();
//			
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isPeopleSearchPresent());
//			Assert.assertTrue(headerHelper_Client.isGroupsPresent());
//			Assert.assertTrue(headerHelper_Client.isInvitationsPresent());
//			Assert.assertTrue(headerHelper_Client.isRecruitingCampaignsPresent());
//			Assert.assertTrue(headerHelper_Client.isScreeningToolsPresent());
//			Assert.assertTrue(headerHelper_Client.isLearningCenterPresent());
//			Assert.assertTrue(headerHelper_Client.isSurveysPresent());
//			                       
//// check if Payments menu is displayed
//			Assert.assertTrue(headerHelper_Client.isPaymentsDropdownPresent());			
////mouse over Payments
//		headerHelper_Client.mouseOverPaymentsDropdown();
//		
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isPaymentCenterPresent());
//			Assert.assertTrue(headerHelper_Client.isInvoicesPresent());
//			Assert.assertTrue(headerHelper_Client.isBankAccountsPresent());
//
//// check if Search menu is displayed
//			Assert.assertTrue(headerHelper_Client.isSearchDropdownPresent());			
////mouse over Payments
//			headerHelper_Client.mouseOverSearchDropdown();
//					
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isSearchSelectPresent());
//			Assert.assertTrue(headerHelper_Client.isAssignmentsOptionPresent());
//			Assert.assertTrue(headerHelper_Client.isresourcesOptionPresent());
//			Assert.assertTrue(headerHelper_Client.isGroupsOptionPresent());
//			Assert.assertTrue(headerHelper_Client.isEnterSearchTermsBoxPresent());
//			Assert.assertTrue(headerHelper_Client.isSearchButtonPresent());
//	
//// check if Add menu is displayed
//			Assert.assertTrue(headerHelper_Client.isAddDropdownPresent());			
////mouse over Add menue
//			headerHelper_Client.mouseOverAddDropdown();
//								
//			// check that all selection items are present
//			Assert.assertTrue(headerHelper_Client.isAssigmentPresent());
//			Assert.assertTrue(headerHelper_Client.isProjectPresent());
//			Assert.assertTrue(headerHelper_Client.isLocationClientPresent());
//			Assert.assertTrue(headerHelper_Client.isGroupPresent());
//			Assert.assertTrue(headerHelper_Client.isInvitationPresent());
//			Assert.assertTrue(headerHelper_Client.isCampaignPresent());	
//			Assert.assertTrue(headerHelper_Client.isTestPresent());			
//			Assert.assertTrue(headerHelper_Client.isSurveyPresent());			
//	}
//	
//	public void checkHeaderResource(){
//		headerHelper_Resource = new HeaderHelper_Resource(resource);
//			Assert.assertTrue(headerHelper_Resource.isAssigmentsDropdownPresent());
//		
//// mouse over Assignments
//		headerHelper_Resource.mouseOverAssignmentsDropdown();
//		
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Resource.isAssigmentDashboardPresent());
//			Assert.assertTrue(headerHelper_Resource.isProjectsPresent());
//			Assert.assertTrue(headerHelper_Resource.isRatingsPresent());
//			Assert.assertTrue(headerHelper_Resource.isReportsPresent());
//			Assert.assertTrue(headerHelper_Resource.isLocationManagerPresent());
//			Assert.assertTrue(headerHelper_Resource.isWMRealtimePresent());
//			Assert.assertTrue(headerHelper_Resource.isCreateAssignmentPresent());
//			
//// check if resources menu is displayed
//			Assert.assertTrue(headerHelper_Resource.isresourcesDropdownPresent());
//			
//// mouse over resources
//		headerHelper_Resource.mouseOverresourcesDropdown();
//			
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Resource.isPeopleSearchPresent());
//			Assert.assertTrue(headerHelper_Resource.isGroupsPresent());
//			Assert.assertTrue(headerHelper_Resource.isInvitationsPresent());
//			Assert.assertTrue(headerHelper_Resource.isRecruitingCampaignsPresent());
//			Assert.assertTrue(headerHelper_Resource.isScreeningToolsPresent());
//			Assert.assertTrue(headerHelper_Resource.isLearningCenterPresent());
//			Assert.assertTrue(headerHelper_Resource.isSurveysPresent());
//			                       
//// check if Payments menu is displayed
//			Assert.assertTrue(headerHelper_Resource.isPaymentsDropdownPresent());			
////mouse over Payments
//		headerHelper_Resource.mouseOverPaymentsDropdown();
//		
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Resource.isPaymentCenterPresent());
//			Assert.assertTrue(headerHelper_Resource.isInvoicesPresent());
//			Assert.assertTrue(headerHelper_Resource.isBankAccountsPresent());
//
//// check if Search menu is displayed
//			Assert.assertTrue(headerHelper_Resource.isSearchDropdownPresent());			
////mouse over Payments
//			headerHelper_Resource.mouseOverSearchDropdown();
//					
//// check that all selection items are present
//			Assert.assertTrue(headerHelper_Resource.isSearchSelectPresent());
//			Assert.assertTrue(headerHelper_Resource.isAssignmentsOptionPresent());
//			Assert.assertTrue(headerHelper_Resource.isresourcesOptionPresent());
//			Assert.assertTrue(headerHelper_Resource.isGroupsOptionPresent());
//			Assert.assertTrue(headerHelper_Resource.isEnterSearchTermsBoxPresent());
//			Assert.assertTrue(headerHelper_Resource.isSearchButtonPresent());
//	
//// check if Add menu is displayed
//			Assert.assertTrue(headerHelper_Resource.isAddDropdownPresent());			
////mouse over Add menue
//			headerHelper_Resource.mouseOverAddDropdown();
//								
//			// check that all selection items are present
//			Assert.assertTrue(headerHelper_Resource.isAssigmentPresent());
//			Assert.assertTrue(headerHelper_Resource.isProjectPresent());
//			Assert.assertTrue(headerHelper_Resource.isLocationClientPresent());
//			Assert.assertTrue(headerHelper_Resource.isGroupPresent());
//			Assert.assertTrue(headerHelper_Resource.isInvitationPresent());
//			Assert.assertTrue(headerHelper_Resource.isCampaignPresent());	
//			Assert.assertTrue(headerHelper_Resource.isTestPresent());			
//			Assert.assertTrue(headerHelper_Resource.isSurveyPresent());			
//	}
/////////// Check Methods end here
//
//	@AfterMethod
//	public void afterMainMethod() {
//		this.afterMethod();
//		client.quit();
//		resource.quit();
//		wald.quit();
//	}
//
//	@BeforeClass
//	public void beforeMainClass() {
//		this.beforeClass();
//	}
//
//	@AfterClass
//	public void afterMainClass() {
//		this.afterClass();
//	}
//
//	@BeforeTest
//	public void beforeMainTest() {
//		this.beforeTest();
//	}
//
//	@AfterTest
//	public void afterMainTest() {
//		this.afterTest();
//	}
//
//	public abstract void beforeMethod();
//
//	public abstract void afterMethod();
//
//	public abstract void beforeClass();
//
//	public abstract void afterClass();
//
//	public abstract void beforeTest();
//
//	public abstract void afterTest();
//}
