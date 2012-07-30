package org.urbandaddy.helpers.Comm;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import java.util.*;

//import org.openqa.selenium.JavascriptExecutor;
//import org.sikuli.script.*;

//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.Cookie;

//Workflow specific imports


import org.urbandaddy.helpers.UD_FooterHelper_Client;
import org.urbandaddy.helpers.UD_HeaderHelper_Client;
import org.urbandaddy.helpers.UD_SealHelper_Client;
import org.urbandaddy.helpers.UD_HomepageHelper_Client;
import org.urbandaddy.helpers.UD_SignupHelper_Client;


import org.urbandaddy.helpers.Perks_FooterHelper_Client;
import org.urbandaddy.helpers.Perks_HeaderHelper_Client;
import org.urbandaddy.helpers.Perks_SealHelper_Client;
import org.urbandaddy.helpers.Perks_HomepageHelper_Client;
import org.urbandaddy.helpers.Perks_SignupHelper_Client;


import org.urbandaddy.helpers.CheckEmailHelper_Client;
import org.urbandaddy.helpers.ResetEmailHelper_Client;

//import org.urbandaddy.helpers.Comm.ITestCase;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.urbandaddy.helpers.SignupHelper;


public abstract class ITestCase {

	enum DriverType {
		Firefox, IE, Ghrome, FirefoxRemote13
	}

	public WebDriver client;
//	public WebDriver resource;
//	public WebDriver wald;
	
	@BeforeMethod
	@Parameters({ "driverType", "profilePath" })
	public void beforeMainMethod(String driverType, String profilePath) {
		// TODO: some config xml file
		if (DriverType.Firefox.toString().equals(driverType)) {
			
			if (profilePath == null || profilePath.isEmpty()) {
				client = new FirefoxDriver();
//				cms = new FirefoxDriver();
				client.manage().window().maximize();
				
			} else {
				File file = new File(profilePath);
				FirefoxProfile profile = new FirefoxProfile(file);
				client = new FirefoxDriver(profile);
//				cms = new FirefoxDriver(profile);
				client.manage().window().maximize();
			}
			
		} else if (DriverType.IE.toString().equals(driverType)) {
			client = new InternetExplorerDriver();
//			cms = new InternetExplorerDriver();
			
		} else if (DriverType.Ghrome.toString().equals(driverType)) {
			client = new ChromeDriver();
//			cms = new ChromeDriver();
			
		} 
else if (DriverType.FirefoxRemote13.toString().equals(driverType)) 
			
		{
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setCapability("seleniumProtocol", "WebDriver");
			
			//capability.setCapability("browserName", "firefox10");
			//capability.setBrowserName("firefox10");
	    	//capability.setCapability("firefox_binary" , "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			//capability.setCapability("maxInstances", 5);		
			capability.setCapability("jenkins.nodeName", "WindowsSlave2");
			capability.setCapability("javascriptEnabled ", true);
			//FirefoxProfile ffPrfile;
            //ffprofile.setPreference("javascript.enabled", true);
			capability.setVersion("14");
			
			
			try {
				client = new RemoteWebDriver(new URL("http://jenkins-master.thedaddy.co:4444/wd/hub"), capability);
				client.manage().window().maximize();
//				client.manage().window().setSize(targetSize)
//				resource = new RemoteWebDriver(new URL(Config.serverJenkins), capability);
//				wald = new RemoteWebDriver(new URL(Config.serverJenkins), capability);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		else {
			client = new FirefoxDriver();
//			cms = new FirefoxDriver();
			
		}

		this.beforeMethod();
	}

	//declare helpers
	
	private UD_HomepageHelper_Client ud_homepageHelper_Client;
	private UD_HeaderHelper_Client ud_headerHelper_Client;
	private UD_FooterHelper_Client ud_footerHelper_Client;
	private UD_SealHelper_Client ud_sealHelper_Client;
	private UD_SignupHelper_Client ud_signupHelper_Client;
	
	private Perks_HomepageHelper_Client perks_homepageHelper_Client;
	private Perks_HeaderHelper_Client perks_headerHelper_Client;
	private Perks_FooterHelper_Client perks_footerHelper_Client;
	private Perks_SealHelper_Client perks_sealHelper_Client;
	private Perks_SignupHelper_Client perks_signupHelper_Client;
	
	private CheckEmailHelper_Client checkEmailHelper_Client;

	
	//declare variables
	
	//set unique role names using time stamp
	Date now = new java.util.Date(); 
	java.text.DateFormat emailFormat = new java.text.SimpleDateFormat("HH_mm_SSS");
	
	String emailClient = "udtestergene+"+emailFormat.format(now) + "@gmail.com";
	String emailFriend1 = "udtestergene+"+"friend_1_"+emailFormat.format(now) + "@gmail.com";
	String emailFriend2 = "udtestergene+"+"friend_2_"+emailFormat.format(now) + "@gmail.com";
	String emailFriend3 = "udtestergene+"+"friend_3_"+emailFormat.format(now) + "@gmail.com";
	String emailFriend4 = "udtestergene+"+"friend_4_"+emailFormat.format(now) + "@gmail.com";
	String emailFriend5 = "udtestergene+"+"friend_5_"+emailFormat.format(now) + "@gmail.com";
		
	private String UDdomain = "http://ud-branch.thedaddy.co";
	private String UD_Admin_domain = "http://ud-branch.thedaddy.co/admin.php";
	private String Perksdomain = "http://perks-branch.thedaddy.co";
//	private String UDdomain = "http://www.urbandaddy.com";
//	private String Perksdomain = "http://perks.urbandaddy.com";
	private String UDcity = "";
	private String UDcityPerks = "";
	private String password="12345";
//	private String newpassword="1234";
	
	public void pause1(){
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pause2(){
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void pause3(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pause4(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

///// Sign-up methods
	
// Perks
	public void visitPerksFirstTime(){
		
		// enter UDdomain name, hit enter, arrive on homepage
				this.client.navigate().to(Perksdomain);
				this.client.manage().deleteAllCookies();
				this.client.navigate().to(Perksdomain);
	}
	
	
	public void signUpPerks_viaNewYork(){
		
		this.signUpPerks_viaNewYorkStep1();
		this.signUpPerks_viaNewYorkStep2();
		this.signUpPerks_viaNewYorkStep3();
		this.signUpPerks_viaNewYorkStep4();
		}
	
	public void logoutPerks(){
		
	}
	
	public void resetPasswordPerks(){
		
	}
	
	public void verifyWelcomePerksEmailReceived(){
		
	}
	
	public void verifyInvitationsPerksEmailsReceived(){
		
	}
	
	public void verifyResetPasswordPerksRequestReceivedandPasswordReset(){
		
	}
	
	public void signUpPerks_viaNewYorkStep1(){
		
		
		perks_homepageHelper_Client = new Perks_HomepageHelper_Client(client);
		perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);
		
		perks_signupHelper_Client = new Perks_SignupHelper_Client(client);
				
		System.out.println(emailClient);
		

		
		//go to /home/nyc
//		perks_homepageHelper_Client.clickNewYork();
				
		//step1, 1st signup modal: 
		//a. Click SignUp Seal
		ud_headerHelper_Client.clickSignUp();
		
		//or open new tab or go to the signup url
		
		//headerHelper_Client.openSignUpNewTab();
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//b. Enter email address
		ud_signupHelper_Client.enterEmail(emailClient);
		//c. Select Editions
		//New York, New York Perks are selected by default
		//check Driven
		ud_signupHelper_Client.checkDriven();
		ud_signupHelper_Client.checkJetset();
		ud_signupHelper_Client.checkLasVegas();
		ud_signupHelper_Client.checkNational();
		ud_signupHelper_Client.checkSkiBoard();
		
		//click "more" link to show all Editorials
		ud_signupHelper_Client.clickMoreLinkNewYork1();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		// check all of them
		ud_signupHelper_Client.checkAtlanta();
		ud_signupHelper_Client.checkBoston();
		ud_signupHelper_Client.checkChicago();
		ud_signupHelper_Client.checkDallas();
		ud_signupHelper_Client.checkDC();
		ud_signupHelper_Client.checkLosAngeles();
		ud_signupHelper_Client.checkMiami();
		ud_signupHelper_Client.checkSanFrancisco();
		
		//click "more" link to see the Perks editions
		ud_signupHelper_Client.clickMoreLinkNewYork2();
		
		// check all of them
		ud_signupHelper_Client.checkBostonPerks();
		ud_signupHelper_Client.checkChicagoPerks();
		ud_signupHelper_Client.checkDCPerks();
		ud_signupHelper_Client.checkLosAngelesPerks();
		ud_signupHelper_Client.checkMiamiPerks();
		ud_signupHelper_Client.checkNationalPerks();
		
		//click "JOIN" button
		
		ud_signupHelper_Client.clickJoin();
}
	

public void signUpPerks_viaNewYorkStep2(){
	
	
	ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
	
	ud_signupHelper_Client = new UD_SignupHelper_Client(client);
		
		
//handling the silly behaviour of ajax, when the form comes back with "You must enter an email address." message as if email was not entered		
//		You must enter an email address.
//		client.findElement(By.xpath("//html/body/div[7]/div/div/div/div[2]/div/div")).click();
		
		
//		Assert.assertFalse(client.findElement(By.xpath("//html/body/div[7]/div/div/div/div[2]/div/div")).isDisplayed()); 
		
		
//		Assert.assertFalse(ud_signupHelper_Client.isStupidErrorAfterStep1Present());
		
//		try {
//			ud_signupHelper_Client.isStupidErrorAfterStep1Present();
//		}

		
		//step2, 2nd signup modal: 
		//enter password
		ud_signupHelper_Client.enterPassword(password);
		//confirm password
		ud_signupHelper_Client.confirmPassword(password);
		//First Name
		ud_signupHelper_Client.enterFirstName("FN_"+emailFormat.format(now));
		//Last Name
		ud_signupHelper_Client.enterLastName("LN_"+emailFormat.format(now));
		//Gender
		ud_signupHelper_Client.selectGender("Male");
		//ud_signupHelper_Client.selectGender("Female");
		//ud_signupHelper_Client.selectGenderRandom();

		//Income Range
		ud_signupHelper_Client.selectIncomeRange("Less than $30,000");
//		ud_signupHelper_Client.selectIncomeRange("$30,000-$44,999");
//		ud_signupHelper_Client.selectIncomeRange("$45,000-$59,999");
//		ud_signupHelper_Client.selectIncomeRange("$60,000-$74,999");
//		ud_signupHelper_Client.selectIncomeRange("$75,000-$99,999");
//		ud_signupHelper_Client.selectIncomeRange("$100,000-$199,999");
//		ud_signupHelper_Client.selectIncomeRange("$200,000-$299,999");
//		ud_signupHelper_Client.selectIncomeRange("$300,000-$499,999");
//		ud_signupHelper_Client.selectIncomeRange("$500,000+");
//		ud_signupHelper_Client.selectIncomeRangeRandom();

		//Zip Code
		ud_signupHelper_Client.enterZipCode("10001");
		//Birthday (MM/DD/YYYY)
		ud_signupHelper_Client.enterBirthday("07/07/1977");
		//click "SUBMIT" button
		
		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
				}
		ud_signupHelper_Client.clickSubmit();
}


public void signUpPerks_viaNewYorkStep3(){
	
	
	ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
	
	ud_signupHelper_Client = new UD_SignupHelper_Client(client);
		
//step3, 3rd signup modal: Invite Friends
		
//		ud_signupHelper_Client.clickInvite();
		
		ud_signupHelper_Client.enterEmailFriend1(emailFriend1);
		ud_signupHelper_Client.enterEmailFriend2(emailFriend2);
		ud_signupHelper_Client.enterEmailFriend3(emailFriend3);
		ud_signupHelper_Client.enterEmailFriend4(emailFriend4);
		ud_signupHelper_Client.enterEmailFriend5(emailFriend5);
		
		System.out.println(emailFriend1);
		System.out.println(emailFriend2);
		System.out.println(emailFriend3);
		System.out.println(emailFriend4);
		System.out.println(emailFriend5);
		
		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
				}
		
		ud_signupHelper_Client.clickInvite();
		
//		ud_signupHelper_Client.clickSkip();
	}	

public void signUpPerks_viaNewYorkStep4(){
	//step4, 4th signup modal confirmation, close final confirm signup box		
			ud_signupHelper_Client.clickCloseFinalModal();
	//end of registration
		}
	
// UD	
public void visitUDFirstTime(){
	
	// enter UDdomain name, hit enter, arrive on homepage
			this.client.navigate().to(UDdomain);
			this.client.manage().deleteAllCookies();
			this.client.navigate().to(UDdomain);
			this.client.manage().addCookie(new Cookie ("udsubpop", "3","ud-branch.thedaddy.co", "/", null));
			
	//do all homepage checks
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);
		
		//Verify All items are present on HomePage
		Assert.assertTrue(ud_homepageHelper_Client.isUDLogoPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isClickableCopyPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isSignUpSealPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isAtlantaLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isBostonLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isChicagoLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isDallasLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isWashingtonDCLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isDrivenLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isJetsetLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isLasVegasLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isLosAngelesLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isMiamiLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isNationalLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isNewYorkLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isSanFranciscoLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isSkiBoardLinkPresent());
		Assert.assertTrue(ud_homepageHelper_Client.isUDLogoPresent());
		
	// do all footer checks	
		ud_footerHelper_Client = new UD_FooterHelper_Client(client); 
		this.checkUDHomepageFooter();
}

public void loginUDAdmin(){
	this.client.manage().deleteAllCookies();
	this.client.navigate().to(UD_Admin_domain);
	client.findElement(By.id("username")).sendKeys("gmodin");
	client.findElement(By.id("password")).sendKeys("UD@dmin900");
	client.findElement(By.name("commit")).click();
	//client.get(UD_Admin_domain+"/admin.php/articles");
}

public void createArticleWeekender() {

//	1. Log in to the UD admin 
//	2. Click on articles
//	3. Click on create	
	
	client.get(UD_Admin_domain+"/articles/create");
	this.pause1();

//	4. Change status to Approved
	
    WebElement status = client.findElement(By.id("article_article_status_id"));
    List<WebElement> status_options = status.findElements(By.tagName("option"));
    for(WebElement option : status_options){
        if(option.getText().equals("Approved")) {
            option.click();
            break;
        }
    }
    
//	5.  Click Dedicated
    
	client.findElement(By.id("article_is_dedicated")).click();
    
//	6.  Change Template to Weekender
	
    WebElement template = client.findElement(By.id("article_article_template_id"));
    List<WebElement> template_options = template.findElements(By.tagName("option"));
    for(WebElement option : template_options){
        if(option.getText().equals("Weekender")) {
            option.click();
            break;
        }
    }
	
//	7.  Choose any ad campaign
    
    WebElement ad_campaign = client.findElement(By.id("article_article_template_id"));
    List<WebElement> ad_campaign_options = ad_campaign.findElements(By.tagName("option"));
    for(WebElement option : ad_campaign_options){
        if(option.getText().equals("Groupon")) {
            option.click();
            break;
        }
    }
    
//	8.  Choose any Author
    
    WebElement author = client.findElement(By.id("article_author_id"));
    List<WebElement> author_options = author.findElements(By.tagName("option"));
    for(WebElement option : author_options){
        if(option.getText().equals("Russ Brandom")) {
            option.click();
            break;
        }
    }
    
//	9.  Enter in From Display “test <test@test.com>”
    
	client.findElement(By.id("details_from_display")).sendKeys("test <test@test.com>");
    
//	10.   Choose QA Segment
	
    WebElement segment = client.findElement(By.id("details_segment"));
    List<WebElement> segment_options = segment.findElements(By.tagName("option"));
    for(WebElement option : segment_options){
        if(option.getText().equals("QA Addresses")) {
            option.click();
            break;
        }
    }
    
//	11.   Enter an Article title
    
	client.findElement(By.id("article_name")).sendKeys("Test Weekender Article Title "+emailFormat.format(now));
	    
//	12.   Enter a Business Name/Subject
    
	client.findElement(By.id("article_business_name")).sendKeys("Test Weekender Business Name "+emailFormat.format(now));

//	13.   Enter an Article Subheader
    
	client.findElement(By.id("article_teaser")).sendKeys("Test Weekender Article Subheader "+emailFormat.format(now));
    
//	14.   Enter a Email Subject Line
    
	client.findElement(By.id("article_email_subject_line")).sendKeys("Test Weekender Email Subject "+emailFormat.format(now));
    
//	15.   Choose any weekender category
    
    //default selection is "NYC: Nightlife"
    
//	16.   Click Save
	
	client.findElement(By.name("save")).click();
	this.pause1();
	
	// Get Article ID
	
		String articleLink = client.getCurrentUrl();
		
	    String[] separated = articleLink.split("/");
	    String articleID = separated[separated.length - 1];
    
//	17.   Add Images: Email Banner, Option_A_Left_Column, and Thumbnail
	
	// go to create image page
	client.get(UD_Admin_domain+"/article_images/create");
	this.pause1();
	
	//browse to 1st image
	client.findElement(By.id("article_image_name")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\image001_optionA.jpg");
	
	//enter Article ID
	client.findElement(By.id("article_image_article_id")).sendKeys(articleID);
	
	//enter Position for 1st image: Option A Left Column
	
    WebElement article1_position = client.findElement(By.id("article_image_article_image_position_id"));
    List<WebElement> position_options1 = article1_position.findElements(By.tagName("option"));
    for(WebElement option : position_options1){
        if(option.getText().equals("Option_A_Left_Column")) {
            option.click();
            break;
        }
    }
    
    //click "save and add" button
    
	client.findElement(By.name("save_and_add")).click();
	this.pause1();
	
	
	//browse to 2nd image
		client.findElement(By.id("article_image_name")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\image002_EmailBanner.jpg");
		
		//enter Article ID
		client.findElement(By.id("article_image_article_id")).sendKeys(articleID);
		
		//enter Position for 1st image: Option A Left Column
		
	    WebElement article2_position = client.findElement(By.id("article_image_article_image_position_id"));
	    List<WebElement> position_options2 = article2_position.findElements(By.tagName("option"));
	    for(WebElement option : position_options2){
	        if(option.getText().equals("Email_Banner")) {
	            option.click();
	            break;
	        }
	    }
	    
	    //click "save and add" button
	    
		client.findElement(By.name("save_and_add")).click();
		this.pause1();
		
		//browse to 3rd image
		client.findElement(By.id("article_image_name")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\image003_thumbnail.jpg");
				
		//enter Article ID
		client.findElement(By.id("article_image_article_id")).sendKeys(articleID);
				
		//enter Position for 1st image: Option A Left Column
				
			    WebElement article3_position = client.findElement(By.id("article_image_article_image_position_id"));
			    List<WebElement> position_options3 = article3_position.findElements(By.tagName("option"));
			    for(WebElement option : position_options3){
			        if(option.getText().equals("Thumbnail")) {
			            option.click();
			            break;
			        }
			    }
			    
		//click "save and add" button
			    
		client.findElement(By.name("save")).click();
		this.pause1();
		
		//go back to the article
		client.get(UD_Admin_domain+"/articles/edit/id/"+articleID);	
	
//	18.   Enter text in photo credit
		
		client.findElement(By.id("article[photo_credit]")).sendKeys("Weekender Photo Credits Test "+emailFormat.format(now));

//	19.   Enter text in Article Feature
		
		client.findElement(By.id("article[short]")).sendKeys("Weekender Article/Feature Introduction Test "+emailFormat.format(now)); 

//	20.   Copy is not needed
//	21.   Enter text in Article Blurb
		
		client.findElement(By.id("article[blurb]")).sendKeys("Weekender Article Blurb Test "+emailFormat.format(now));
		
//	22.   Enter Text in iPhone Blurb
		
		client.findElement(By.id("article[blurb_iphone]")).sendKeys("Weekender iPhone Blurb Test "+emailFormat.format(now));

//	23.   Enter Text in Twitter Blurb
		
		client.findElement(By.id("article_blurb_twitter")).sendKeys("Weekender Twitter Blurb Test "+emailFormat.format(now));

//	24.   Enter Text in Note
		
		//!!!Figure out how to interact with this version of FCK editor
		
//	25.   Enter Text in Legal Line
		
		client.findElement(By.id("article[footer_additional]")).sendKeys("Weekender Legal Line Test "+emailFormat.format(now));

//	26.   Add Ad to Bottom module
//		a.	Select ad from component dropdown
		
		WebElement add_bottom_components = client.findElement(By.id("_select_modules_center"));
	    List<WebElement> add_bottom_components_options = add_bottom_components.findElements(By.tagName("option"));

	    for(WebElement option : add_bottom_components_options){
	        if(option.getText().equals("Ad")) {
	            option.click();
	            break;
	        }
	    }
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
//		b.	Click on newsletter_ad
	    
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[4]/div/ul/li/table/tbody/tr/td[5]/a")).click(); 
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		c.	Choose any Footer ad.   
		//set main window handle before pop-ups pop up
		String mwh=client.getWindowHandle();
		
		//handle pop-up window
				Set<?> s_add1=client.getWindowHandles();
				//this method will you handle of all opened windows

				Iterator<?> ite_add1=s_add1.iterator();

				while(ite_add1.hasNext())
				{
				    String popupHandle=ite_add1.next().toString();
				    if(!popupHandle.contains(mwh))
				    {
				                client.switchTo().window(popupHandle);
							 
							// select Footer template
				                this.pause3();
						
			    WebElement bottom_ad_type = client.findElement(By.name("newsletter_content_slot[name]"));
			    List<WebElement> bottom_ad_type_options = bottom_ad_type.findElements(By.tagName("option"));
			    for(WebElement option : bottom_ad_type_options){
			        if(option.getText().equals("49ers SF 11-8-11 footer (Footer)")) {
			            option.click();
			            break;
			        }
			    }	

		//				d. 	Click Save
                client.findElement(By.id("save_button")).click(); 
                this.pause1();
			    
                //After finished your operation in pop-up just select the main window again
                client.switchTo().window(mwh);
				    }
				}
		

		
//	27.   Add Ad to Right Module
//		a.	Select ad from component dropdown
                
//        		a.	Select ad from component dropdown
        		
        		WebElement add_right_components = client.findElement(By.id("_select_modules_right"));
        	    List<WebElement> add_right_components_options = add_right_components.findElements(By.tagName("option"));

        	    for(WebElement option : add_right_components_options){
        	        if(option.getText().equals("Ad")) {
        	            option.click();
        	            break;
        	        }
        	    }
        	    try {
        			Thread.sleep(2000);
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}
//		b.	Click on newsletter_ad
        	    
        		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[5]/div/ul/li/table/tbody/tr/td[5]/a")).click(); 
        		
        		try {
        			Thread.sleep(3000);
        		} catch (InterruptedException e) {
        			e.printStackTrace();
        		}

//		c.	Choose any Tower add.      
        		//set main window handle before pop-ups pop up
        		String mwh2=client.getWindowHandle();
        		
        		//handle pop-up window
        				Set<?> s_add2=client.getWindowHandles();
        				//this method will you handle of all opened windows

        				Iterator<?> ite_add2=s_add2.iterator();

        				while(ite_add2.hasNext())
        				{
        				    String popupHandle2=ite_add2.next().toString();
        				    if(!popupHandle2.contains(mwh2))
        				    {
        				                client.switchTo().window(popupHandle2);
        				                
        				                this.pause3();
        							 
        							// select Footer template
        						
        			    WebElement right_ad_type = client.findElement(By.name("newsletter_content_slot[name]"));
        			    List<WebElement> right_ad_type_options = right_ad_type.findElements(By.tagName("option"));
        			    for(WebElement option : right_ad_type_options){
        			        if(option.getText().equals("49ers SF 11-8-11 tower (Tower)")) {
        			            option.click();
        			            break;
        			        }
        			    }	
//        d.	Click Save
                        client.findElement(By.id("save_button")).click(); 
                        this.pause1();
        			    
		                //After finished your operation in pop-up just select the main window again
		                client.switchTo().window(mwh2);
        				    }
        				}

		
//	28.   Enter text in keywords
		
		client.findElement(By.id("article_keywords")).sendKeys("Weekender Keywords Test Keywords "+emailFormat.format(now));

//	29.   Choose business type
		
	    WebElement business_type = client.findElement(By.id("article_business_type_id"));
	    List<WebElement> business_type_options = business_type.findElements(By.tagName("option"));
	    for(WebElement option : business_type_options){
	        if(option.getText().equals("Clothing")) {
	            option.click();
	            break;
	        }
	    }
		
//	30.   Enter text in business specialty
	    
		client.findElement(By.id("article_business_specialty")).sendKeys("Weekender Business Specialty Test "+emailFormat.format(now));
	    
//	31.   Click save
		
		client.findElement(By.name("save")).click();
		this.pause1();
		
		
//	32.   Click “here” next to Template this takes you to individual weekenders
		//html/body/div[3]/div/div[2]/form/fieldset/div[5]/div/a

//		or:
		
		client.get(UD_Admin_domain+"/multiarticle/edit/id/"+articleID);
		this.pause1();
		
//	33.   For each template, 3 is a good number:
		
		//1
//		a.       Choose the day 
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div/select
		
		WebElement day1 = client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div/select"));
	    List<WebElement> day1_options = day1.findElements(By.tagName("option"));
	    for(WebElement option : day1_options){
	        if(option.getText().equals("Monday")) {
	            option.click();
	            break;
	        }
	    }
		
//		b.      Click show day image in title
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div/input
	    
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div/input[2]")).click();

		
//		c.       Enter text in Header
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[5]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[5]/input")).sendKeys("Weekender Header1 Test "+emailFormat.format(now));

		
//		d.      Enter text in Subheader
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[6]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[6]/input")).sendKeys("Weekender SubHeader1 Test "+emailFormat.format(now));

		
//		e.      Put in some url for subheader URl
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[7]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[7]/input")).sendKeys("www.google.com");


//		f.        Click choose file under image and put in an image
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[8]/input 
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[8]/input")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\solon.jpg");


//		g.       Check image url
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[9]/input    
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[9]/input")).click();

		
//		h.      Put in some url for image url
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[9]/input[2]
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[9]/input[2]")).sendKeys("http://images.sodahead.com/polls/001076173/even_kittens_are_going_bad_answer_2_xlarge.jpeg");


//		i.         Enter text in Alt
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[10]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[10]/input")).sendKeys("Weekender Alt Test"+emailFormat.format(now));


//		j.        Enter text in Copy
//		k.       Enter text in 411
		
//		l.         Repeat for others
		
		
		//2
//		a.       Choose the day    
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div/select
		
		WebElement day2 = client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div/select"));
	    List<WebElement> day2_options = day2.findElements(By.tagName("option"));
	    for(WebElement option : day2_options){
	        if(option.getText().equals("Tuesday")) {
	            option.click();
	            break;
	        }
	    }
		
//		b.      Click show day image in title
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div/input
	    
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div/input[2]")).click();
		
//		c.       Enter text in Header
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[5]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[5]/input")).sendKeys("Weekender Header2 Test "+emailFormat.format(now));
		
//		d.      Enter text in Subheader
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[6]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[6]/input")).sendKeys("Weekender SubHeader2 Test "+emailFormat.format(now));

		
//		e.      Put in some url for subheader URl
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[7]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[7]/input")).sendKeys("www.yahoo.com");


//		f.        Click choose file under image and put in an image
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[8]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[8]/input")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\plato.jpg");


//		g.       Check image url
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[9]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[9]/input")).click();

		
//		h.      Put in some url for image url
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[9]/input[2]
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[9]/input[2]")).sendKeys("http://t0.gstatic.com/images?q=tbn:ANd9GcTYj5WyrHaLj6lqad-dIiNUTQSaKkuJmJtUKiPX3SbIpCfS-1aFqyr-mDWF");


//		i.         Enter text in Alt
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[10]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[10]/input")).sendKeys("Weekender Alt2 Test"+emailFormat.format(now));


//		j.        Enter text in Copy
//		k.       Enter text in 411
//		l.         Repeat for others

		
		//3
		
//		a.       Choose the day   
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div/select
		
		WebElement day3 = client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div/select"));
	    List<WebElement> day3_options = day3.findElements(By.tagName("option"));
	    for(WebElement option : day3_options){
	        if(option.getText().equals("Thursday")) {
	            option.click();
	            break;
	        }
	    }
		
//		b.      Click show day image in title
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div/input
	    
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div/input[2]")).click();

		
//		c.       Enter text in Header
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[5]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[5]/input")).sendKeys("Weekender Header3 Test "+emailFormat.format(now));
		
		
//		d.      Enter text in Subheader
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[6]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[6]/input")).sendKeys("Weekender SubHeader3 Test "+emailFormat.format(now));

		
//		e.      Put in some url for subheader URl
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[7]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[7]/input")).sendKeys("www.cnn.com");


//		f.        Click choose file under image and put in an image
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[8]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[8]/input")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\socrates.jpg");


//		g.       Check image url
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[9]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[9]/input")).click();
		
//		h.      Put in some url for image url
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[9]/input[2]
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[9]/input[2]")).sendKeys("http://imagecache6.allposters.com/LRG/38/3842/UJXYF00Z.jpg");


//		i.         Enter text in Alt
		
		//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[10]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[10]/input")).sendKeys("Weekender Alt3 Test"+emailFormat.format(now));


//		j.        Enter text in Copy
//		k.       Enter text in 411
	
		
//		m.    Delete slots you do not want to use
//		slot 4:/html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[8]/td/div[11]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[8]/td/div[11]/input")).click();
		
		this.pause1();

//		slot 5:/html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[10]/td/div[11]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[8]/td/div[11]/input")).click();
		this.pause1();

//		slot 6:/html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[12]/td/div[11]/input
		
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[8]/td/div[11]/input")).click();
		this.pause1();



		
		//		n.      Click Save
		
		client.findElement(By.name("save")).click();

       }		    

public void createArticleThreeColumn() {
	
	client.get(UD_Admin_domain+"/articles/create");
	
	//Set Status to Approved
    WebElement status = client.findElement(By.id("article_article_status_id"));
    List<WebElement> status_options = status.findElements(By.tagName("option"));
    for(WebElement option : status_options){
        if(option.getText().equals("Approved")) {
            option.click();
            break;
        }
    }
    
    //Check Dedicated
	client.findElement(By.id("article_is_dedicated")).click();

	//Select Three-Column Template
    WebElement template = client.findElement(By.id("article_article_template_id"));
    List<WebElement> template_options = template.findElements(By.tagName("option"));
    for(WebElement option : template_options){
        if(option.getText().equals("Three-Column")) {
            option.click();
            break;
        }
    }
    
    //Select Author: Russ Brandom
    WebElement author = client.findElement(By.id("article_author_id"));
    List<WebElement> author_options = author.findElements(By.tagName("option"));
    for(WebElement option : author_options){
        if(option.getText().equals("Russ Brandom")) {
            option.click();
            break;
        }
    }

    //From display
    
	client.findElement(By.id("details_from_display")).sendKeys("test <test@test.com>");
    
    //Select Segment: QA
    WebElement segment = client.findElement(By.id("details_segment"));
    List<WebElement> segment_options = segment.findElements(By.tagName("option"));
    for(WebElement option : segment_options){
        if(option.getText().equals("QA Addresses")) {
            option.click();
            break;
        }
    }
    
    //Enter Article Title:

	//client.findElement(By.id("article_name")).clear();
	client.findElement(By.id("article_name")).sendKeys("Test Three-Column Article Title "+emailFormat.format(now));
    
	//Enter Business Name/Subject
	//client.findElement(By.id("article_business_name")).clear();
	client.findElement(By.id("article_business_name")).sendKeys("Test Three-Column Business Name "+emailFormat.format(now));
	
	//Enter Article Subheader
	client.findElement(By.id("article_teaser")).sendKeys("Test Three-Column Article Subheader "+emailFormat.format(now));

	//Enter Email Subject Line
	client.findElement(By.id("article_email_subject_line")).sendKeys("Test Three-Column Email Subject "+emailFormat.format(now));

	//Save
	client.findElement(By.name("save")).click();
	this.pause1();
	
// Get Article ID
	
	String articleLink = client.getCurrentUrl();
	
    String[] separated = articleLink.split("/");
    String articleID = separated[separated.length - 1];
//	System.out.println(articleID);
	
//Add images to Article
	
	// go to create image page
	client.get(UD_Admin_domain+"/article_images/create");
	
//browse to 1st image
	client.findElement(By.id("article_image_name")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\image001_optionA.jpg");
	
	//enter Article ID
	client.findElement(By.id("article_image_article_id")).sendKeys(articleID);
	
	//enter Position for 1st image: Option A Left Column
	
    WebElement article1_position = client.findElement(By.id("article_image_article_image_position_id"));
    List<WebElement> position_options1 = article1_position.findElements(By.tagName("option"));
    for(WebElement option : position_options1){
        if(option.getText().equals("Option_A_Left_Column")) {
            option.click();
            break;
        }
    }
    
    //click "save and add" button
    
	client.findElement(By.name("save_and_add")).click();
	this.pause1();
	
	
//browse to 2nd image
		client.findElement(By.id("article_image_name")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\image002_EmailBanner.jpg");
		
		//enter Article ID
		client.findElement(By.id("article_image_article_id")).sendKeys(articleID);
		
		//enter Position for 1st image: Option A Left Column
		
	    WebElement article2_position = client.findElement(By.id("article_image_article_image_position_id"));
	    List<WebElement> position_options2 = article2_position.findElements(By.tagName("option"));
	    for(WebElement option : position_options2){
	        if(option.getText().equals("Email_Banner")) {
	            option.click();
	            break;
	        }
	    }
	    
	    //click "save and add" button
	    
		client.findElement(By.name("save_and_add")).click();
		this.pause1();
		
//browse to 3rd image
		client.findElement(By.id("article_image_name")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\image003_thumbnail.jpg");
				
		//enter Article ID
		client.findElement(By.id("article_image_article_id")).sendKeys(articleID);
				
		//enter Position for 1st image: Option A Left Column
				
			    WebElement article3_position = client.findElement(By.id("article_image_article_image_position_id"));
			    List<WebElement> position_options3 = article3_position.findElements(By.tagName("option"));
			    for(WebElement option : position_options3){
			        if(option.getText().equals("Thumbnail")) {
			            option.click();
			            break;
			        }
			    }
			    
//click "save and add" button
			    
		client.findElement(By.name("save")).click();
		this.pause1();

//go back to the article
		client.get(UD_Admin_domain+"/articles/edit/id/"+articleID);
		
//enter photo credits
		client.findElement(By.id("article[photo_credit]")).sendKeys("Three-Column Photo Credits Test "+emailFormat.format(now));

//enter Article/Feature introduction
		client.findElement(By.id("article[short]")).sendKeys("Three-Column Article/Feature Introduction Test "+emailFormat.format(now)); 
		
//enter Copy !!!Figure out how to interact with this version of FCK editor
//		((JavascriptExecutor)client).executeScript("CKEDITOR.instances['editor1'].setData('hello world');");
//		client.switchTo().frame("article[content]___Frame");
//		client.switchTo().activeElement();
//		client.findElement(By.id("xEditingArea")).sendKeys("Test");
		
		// The image would be considered a match if 90% of it matches the source image
		// by default this is 70%
//		Settings.MinSimilarity = 0.9;


		// set the image location. This is where the source images are stored
		//ImageLocator imageLocator = new ImageLocator();
		//ImageLocator.addImagePath("file:///c:/");

		// Declare a new screen object
//		Screen screen = new Screen();


		// wait for the "Next" button. If it does not appear in 180 seconds,
		// this line will throw an exception
//		try {
//			screen.wait("src/test/upload_data/wysiwyg.png", 180);
//		} catch (FindFailed e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		// Click the next button
//		try {
//			screen.click("src/test/upload_data/wysiwyg.png", 0);
//		} catch (FindFailed e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			screen.type("Test", 0);
//		} catch (FindFailed e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//Article Blurb
		client.findElement(By.id("article[blurb]")).sendKeys("Three-Column Article Blurb Test "+emailFormat.format(now));

//iPhone Blurb
		client.findElement(By.id("article[blurb_iphone]")).sendKeys("Three-Column iPhone Blurb Test "+emailFormat.format(now));

//Twitter Blurb
		client.findElement(By.id("article_blurb_twitter")).sendKeys("Three-Column Twitter Blurb Test "+emailFormat.format(now));
		
//enter Note !!!Figure out how to interact with this version of FCK editor

//Legal Line
		client.findElement(By.id("article[footer_additional]")).sendKeys("Three-Column Legal Line Test "+emailFormat.format(now));

//Keywords
		client.findElement(By.id("article_keywords")).sendKeys("Three-Column Keywords Test Keywords "+emailFormat.format(now));

//Business type
		
	    WebElement business_type = client.findElement(By.id("article_business_type_id"));
	    List<WebElement> business_type_options = business_type.findElements(By.tagName("option"));
	    for(WebElement option : business_type_options){
	        if(option.getText().equals("Clothing")) {
	            option.click();
	            break;
	        }
	    }
//Business specialty
		
		client.findElement(By.id("article_business_specialty")).sendKeys("Three-Column Business Specialty Test "+emailFormat.format(now));

//Save
		client.findElement(By.name("save")).click();
		this.pause1();
		
// Add Vitals to the Left Module,
		
		WebElement left_components = client.findElement(By.id("_select_modules_left"));
	    List<WebElement> left_components_options = left_components.findElements(By.tagName("option"));
	    for(WebElement option : left_components_options){
	        if(option.getText().equals("Vitals")) {
	            option.click();
	            break;
	        }
	    }
	    
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
//Add Sponsored Love to the Left Module,	    
	    
		WebElement left_components2 = client.findElement(By.id("_select_modules_left"));
	    List<WebElement> left_components_options2 = left_components2.findElements(By.tagName("option"));

	    for(WebElement option : left_components_options2){
	        if(option.getText().equals("Sponsored Love")) {
	            option.click();
	            break;
	        }
	    }
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
		//set main window handle before pop-ups pop up
		String mwh=client.getWindowHandle();
	    
	    //click on "Sponsored Love" 
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[3]/div/ul/li[3]/table/tbody/tr/td[5]/a")).click(); 
	    
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Save default selection / assignment of newsletter slot
		
		//handle pop-up window
		Set<?> s=client.getWindowHandles();
		//this method will you handle of all opened windows

		Iterator<?> ite=s.iterator();

		while(ite.hasNext())
		{
		    String popupHandle=ite.next().toString();
		    if(!popupHandle.contains(mwh))
		    {
		                client.switchTo().window(popupHandle);
		                this.pause3();
		                // click save
		                client.findElement(By.id("save_button")).click(); 

		                //After finished your operation in pop-up just select the main window again
		                client.switchTo().window(mwh);
		    }
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}   
	    
//Add Tools to the left Module,
	    
		WebElement left_components3 = client.findElement(By.id("_select_modules_left"));
	    List<WebElement> left_components_options3 = left_components3.findElements(By.tagName("option"));
	    
	    for(WebElement option : left_components_options3){
	        if(option.getText().equals("Tools")) {
	            option.click();
	            break;
	        }
	    }
	   
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
//Add an Ad to the Bottom Module, 
	    
		WebElement bottom_components = client.findElement(By.id("_select_modules_center"));
	    List<WebElement> bottom_components_options = bottom_components.findElements(By.tagName("option"));
	    for(WebElement option : bottom_components_options){
	        if(option.getText().equals("Ad")) {
	            option.click();
	            break;
	        }
	    }
	    
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    //click on "Ad" 
		client.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[4]/div/ul/li/table/tbody/tr/td[5]/a")).click(); 
	    
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Save default selection / assignment of newsletter slot
		
				//handle pop-up window
				Set<?> s2=client.getWindowHandles();
				//this method will you handle of all opened windows

				Iterator<?> ite2=s2.iterator();

				while(ite2.hasNext())
				{
				    String popupHandle=ite2.next().toString();
				    if(!popupHandle.contains(mwh))
				    {
				                client.switchTo().window(popupHandle);
				                // click save
				                this.pause3();
				                client.findElement(By.id("save_button")).click(); 

				                //After finished your operation in pop-up just select the main window again
				                client.switchTo().window(mwh);
				    }
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
		
//Add an Ad to the Right Module, 
	    
		WebElement right_components = client.findElement(By.id("_select_modules_right"));
	    List<WebElement> right_components_options = right_components.findElements(By.tagName("option"));
	    for(WebElement option : right_components_options){
	        if(option.getText().equals("Ad")) {
	            option.click();
	            break;
	        }
	    }
	    
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    //click on "Ad" 
		client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[5]/div/ul/li/table/tbody/tr/td[5]/a")).click(); 
	    
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Save default selection / assignment of newsletter slot
		
		//handle pop-up window
		Set<?> s3=client.getWindowHandles();
		//this method will you handle of all opened windows

		Iterator<?> ite3=s3.iterator();

		while(ite3.hasNext())
		{
		    String popupHandle=ite3.next().toString();
		    if(!popupHandle.contains(mwh))
		    {
		                client.switchTo().window(popupHandle);
		                // click save
		                this.pause3();
		                client.findElement(By.id("save_button")).click(); 

		                //After finished your operation in pop-up just select the main window again
		                client.switchTo().window(mwh);
		    }
		}
			   
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//Click Save, 
	
		client.findElement(By.name("save")).click(); 
		this.pause1();
		
//Click HTML Newsletter, 
//Click Send Email, 
		//client.findElement(By.xpath("//html/body/div[3]/div/div/table/tbody/tr/td[2]/a[2]"));  
		//or
		client.get(UD_Admin_domain+"/articles/sendMailing/id/"+articleID);
		
//Click send Test Mailing, 
		client.findElement(By.name("is_test")).click();
// Confirm Alert
		// Get a handle to the open alert, prompt or confirmation
		Alert alert = client.switchTo().alert();
		// Get the text of the alert or prompt
		alert.getText();  
		// And acknowledge the alert (equivalent to clicking "OK")
		this.pause3();
		alert.accept();
		
		this.pause3();
		// Verify "Test email has been sent" success message
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div[3]/div/div/h2")).getText().contains("Test email has been sent"));

//Add an e-mail address to the Send To field, Click Send Test Mailing, 
		client.findElement(By.id("mailing_send_to")).sendKeys("udtestergene@gmail.com");
		
		//Click send Test Mailing, 
				client.findElement(By.name("is_test")).click();
		// Confirm Alert
				// Get a handle to the open alert, prompt or confirmation
				Alert alert2 = client.switchTo().alert();
				// Get the text of the alert or prompt
				alert2.getText();  
				// And acknowledge the alert (equivalent to clicking "OK")
				alert2.accept();
				this.pause3();
				
		// Verify "Test email has been sent" success message
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div[3]/div/div/h2")).getText().contains("Test email has been sent"));

//Click Back to Article, Change Status to Ready to Send, Click Save, Click Send E-mail, Click Send Mailing at bottom of page
		//go back to the article
				client.get(UD_Admin_domain+"/articles/edit/id/"+articleID);
				this.pause3();
				
		//Change Status to Ready to Send, Click Save,
				
				//Set Status to Approved
			    WebElement status2 = client.findElement(By.id("article_article_status_id"));
			    List<WebElement> status_options2 = status2.findElements(By.tagName("option"));
			    for(WebElement option : status_options2){
			        if(option.getText().equals("Ready to Send")) {
			            option.click();
			            break;
			        }
			    }
			    
				//Save
				client.findElement(By.name("save")).click();
				
				//Click Send E-mail or go to sendMailing page
				client.get(UD_Admin_domain+"/articles/sendMailing/id/"+articleID);
				
				//click "Send Mailing" button 
				client.findElement(By.xpath("//html/body/div[3]/div/form/div/input")).click();
				
				// Confirm Alert
				// Get a handle to the open alert, prompt or confirmation
				Alert alert3 = client.switchTo().alert();
				// Get the text of the alert or prompt
				alert3.getText();  
				// And acknowledge the alert (equivalent to clicking "OK")
				alert3.accept();
				
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
// Verify "Email has been sent successfully." success message
				Assert.assertTrue(client.findElement(By.xpath("//html/body/div[3]/div/div/h2")).getText().contains("Email has been sent successfully."));

		
	}

public void goBackToUDHomepage(){
	this.client.navigate().to(UDdomain);
}

public void checkUDHomepageCityHeaderLoggedOut(){
	
	//do all homepage footer checks
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
	Assert.assertTrue(ud_headerHelper_Client.isNightlifePresent());
	Assert.assertTrue(ud_headerHelper_Client.isFoodPresent());
	Assert.assertTrue(ud_headerHelper_Client.isStylePresent());
	Assert.assertTrue(ud_headerHelper_Client.isGearPresent());
	Assert.assertTrue(ud_headerHelper_Client.isLeisurePresent());
	Assert.assertTrue(ud_headerHelper_Client.isDrivenPresent());
	Assert.assertTrue(ud_headerHelper_Client.isPerksPresent());
	Assert.assertTrue(ud_headerHelper_Client.isPartiesPresent());
	Assert.assertTrue(ud_headerHelper_Client.isKemptPresent());
	Assert.assertTrue(ud_headerHelper_Client.isMobilePresent());
	
	ud_headerHelper_Client.clickNightlife();
	this.pause1();
	Assert.assertTrue(isNightlifeAccessible());
	ud_headerHelper_Client.clickFood();
	this.pause1();
	Assert.assertTrue(isFoodAccessible());
	ud_headerHelper_Client.clickStyle();
	this.pause1();
	Assert.assertTrue(isStyleAccessible());
	ud_headerHelper_Client.clickGear();
	this.pause1();
	Assert.assertTrue(isGearAccessible());
	ud_headerHelper_Client.clickLeisure();
	this.pause1();
	Assert.assertTrue(isLeisureAccessible());
	ud_headerHelper_Client.clickDriven();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isDrivenAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickPerks();
	this.pause1();
	Assert.assertTrue(isPerksAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickParties();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isPartiesAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickKempt();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isKemptAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickMobile();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isMobileAccessible());
	this.client.navigate().back();

}

public void checkUDHomepageLasVegasHeaderLoggedOut(){
	
	//do all homepage footer checks
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
	Assert.assertTrue(ud_headerHelper_Client.isNightlifeLVPresent());
	Assert.assertTrue(ud_headerHelper_Client.isFoodLVPresent());
	Assert.assertTrue(ud_headerHelper_Client.isEntertainmentLVPresent());
	Assert.assertTrue(ud_headerHelper_Client.isPerksLVPresent());
	Assert.assertTrue(ud_headerHelper_Client.isPartiesLVPresent());
	Assert.assertTrue(ud_headerHelper_Client.isKemptLVPresent());
	Assert.assertTrue(ud_headerHelper_Client.isMobileLVPresent());
	
	ud_headerHelper_Client.clickNightlifeLV();
	this.pause1();
	Assert.assertTrue(isNightlifeAccessible());
	ud_headerHelper_Client.clickFoodLV();
	this.pause1();
	Assert.assertTrue(isFoodAccessible());
	ud_headerHelper_Client.clickEntertainmentLV();
	this.pause1();
	Assert.assertTrue(isEntertainmentAccessible());

	ud_headerHelper_Client.clickPerksLV();
	this.pause1();
	Assert.assertTrue(isPerksAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickPartiesLV();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isPartiesLVAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickKemptLV();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isKemptLVAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickMobileLV();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isMobileLVAccessible());
	this.client.navigate().back();

	
}

public void checkUDHomepageNationalHeaderLoggedOut(){
	
	//do all homepage footer checks
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
	Assert.assertTrue(ud_headerHelper_Client.isFoodDrinkNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isStyleNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isGearNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isEntertainmentNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isTravelNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isDrivenNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isPerksNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isPartiesNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isKemptNationalPresent());
	Assert.assertTrue(ud_headerHelper_Client.isMobileNationalPresent());
	
	ud_headerHelper_Client.clickFoodDrinkNational();
	this.pause1();
	Assert.assertTrue(isFoodDrinkNationalAccessible());
	ud_headerHelper_Client.clickStyleNational();
	this.pause1();
	Assert.assertTrue(isStyleAccessible());
	ud_headerHelper_Client.clickGearNational();
	this.pause1();
	Assert.assertTrue(isGearAccessible());
	ud_headerHelper_Client.clickEntertainmentNational();
	this.pause1();
	Assert.assertTrue(isEntertainmentAccessible());
	ud_headerHelper_Client.clickTravelNational();
	this.pause1();
	Assert.assertTrue(isTravelAccessible());
	
	Assert.assertTrue(ud_headerHelper_Client.isDrivenNationalAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickPerks();
	this.pause1();
	Assert.assertTrue(isPerksAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickPartiesNational();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isPartiesNationalAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickKemptNational();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isKemptNationalAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickMobileNational();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isMobileNationalAccessible());
	this.client.navigate().back();
}

public void checkUDHomepageCityHeaderLoggedIn(){
	
	//do all homepage footer checks
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
	Assert.assertTrue(ud_headerHelper_Client.isNightlifePresent());
	Assert.assertTrue(ud_headerHelper_Client.isFoodPresent());
	Assert.assertTrue(ud_headerHelper_Client.isStylePresent());
	Assert.assertTrue(ud_headerHelper_Client.isGearPresent());
	Assert.assertTrue(ud_headerHelper_Client.isLeisurePresent());
	Assert.assertTrue(ud_headerHelper_Client.isDrivenPresent());
	Assert.assertTrue(ud_headerHelper_Client.isPerksPresent());
	Assert.assertTrue(ud_headerHelper_Client.isPartiesPresent());
	Assert.assertTrue(ud_headerHelper_Client.isKemptPresent());
	
	ud_headerHelper_Client.clickNightlife();
	this.pause1();
	Assert.assertTrue(isNightlifeAccessible());
	ud_headerHelper_Client.clickFood();
	this.pause1();
	Assert.assertTrue(isFoodAccessible());
	ud_headerHelper_Client.clickStyle();
	this.pause1();
	Assert.assertTrue(isStyleAccessible());
	ud_headerHelper_Client.clickGear();
	this.pause1();
	Assert.assertTrue(isGearAccessible());
	ud_headerHelper_Client.clickLeisure();
	this.pause1();
	Assert.assertTrue(isLeisureAccessible());
	ud_headerHelper_Client.clickDriven();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isDrivenAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickPerks();
	//this.pause1();
	this.client.navigate().back();
	ud_headerHelper_Client.clickPerks();
	this.pause1();
	Assert.assertTrue(isPerksAccessible());	
	this.client.navigate().back();
	ud_headerHelper_Client.clickParties();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isPartiesAccessible());
	this.client.navigate().back();
	ud_headerHelper_Client.clickKempt();
	this.pause1();
	Assert.assertTrue(ud_headerHelper_Client.isKemptAccessible());
	this.client.navigate().back();
	
}

public void checkUDHomepageFooter(){
	
	//do all homepage footer checks
	ud_footerHelper_Client = new UD_FooterHelper_Client(client);
	Assert.assertTrue(ud_footerHelper_Client.isAboutUsHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isSignUpHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isMyUDHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isContactHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isJobsHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isAdvertiseHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isTipsHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isEmailIssuesHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isPrivacyPolicyHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isUserAgreementHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isUnsubscribeHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isEditorialPolicyHomePresent());
	
	
	Assert.assertTrue(ud_footerHelper_Client.isAtlantaHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isBostonHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isChicagoHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isDallasHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isDCHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isDrivenHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isJetsetHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isLasVegasHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isLosAngelesHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isMiamiHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isNationalHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isNewYorkHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isSanFranciscoHomePresent());
	Assert.assertTrue(ud_footerHelper_Client.isSkiBoardHomePresent());
	
}

public void checkUDHomepageCityFooterLoggedIn(){
	
	//do all city homepage footer checks for logged in state
	ud_footerHelper_Client = new UD_FooterHelper_Client(client);
	Assert.assertTrue(ud_footerHelper_Client.isAboutUsCityPresent());
//	Assert.assertTrue(ud_footerHelper_Client.isSignUpPresentCity());
	Assert.assertTrue(ud_footerHelper_Client.isMyUDCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isContactCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isJobsCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isAdvertiseCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isTipsCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isUnsubscribeCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isMobileSiteCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isEmailIssuesCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isPrivacyPolicyCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isUserAgreementCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isEditorialPolicyCityPresent());
	
	
	Assert.assertTrue(ud_footerHelper_Client.isAtlantaCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isBostonCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isChicagoCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isDallasCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isDCCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isDrivenCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isJetsetCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isLasVegasCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isLosAngelesCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isMiamiCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isNationalCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isNewYorkCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isSanFranciscoCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isSkiBoardCityPresent());
	
}

public void checkUDHomepageCityFooterLoggedOut(){
	
	//do all city homepage footer checks for logged out state
	ud_footerHelper_Client = new UD_FooterHelper_Client(client);
	Assert.assertTrue(ud_footerHelper_Client.isAboutUsCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isSignUpCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isMyUDCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isContactCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isJobsCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isAdvertiseCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isTipsCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isUnsubscribeCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isMobileSiteCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isEmailIssuesCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isPrivacyPolicyCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isUserAgreementCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isEditorialPolicyCityPresent());
	
	
	Assert.assertTrue(ud_footerHelper_Client.isAtlantaCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isBostonCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isChicagoCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isDallasCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isDCCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isDrivenCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isJetsetCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isLasVegasCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isLosAngelesCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isMiamiCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isNationalCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isNewYorkCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isSanFranciscoCityPresent());
	Assert.assertTrue(ud_footerHelper_Client.isSkiBoardCityPresent());
	
}

public boolean isNightlifeAccessible(){
	
	if (client.getCurrentUrl().equals(UDdomain + "/archives/" + UDcity + "/nightlife"))
		return true;
	return false;
		
}

public boolean isFoodAccessible(){
	
	if (client.getCurrentUrl().equals(UDdomain + "/archives/" + UDcity + "/food"))
		return true;
	return false;
		
}

public boolean isFoodDrinkNationalAccessible(){
	
	if (client.getCurrentUrl().equals(UDdomain + "/archives/" + UDcity + "/fooddrink"))
		return true;
	return false;
		
}

public boolean isEntertainmentAccessible(){
	
	if (client.getCurrentUrl().equals(UDdomain + "/archives/" + UDcity + "/entertainment"))
		return true;
	return false;
		
}

public boolean isTravelAccessible(){
	
	if (client.getCurrentUrl().equals(UDdomain + "/archives/" + UDcity + "/travel"))
		return true;
	return false;
		
}

public boolean isStyleAccessible(){
	
	if (client.getCurrentUrl().equals(UDdomain + "/archives/" + UDcity + "/style"))
		return true;
	return false;
		
}

public boolean isGearAccessible(){
	
	if (client.getCurrentUrl().equals(UDdomain + "/archives/" + UDcity + "/gear"))
		return true;
	return false;
		
}

public boolean isLeisureAccessible(){
	
	if (client.getCurrentUrl().equals(UDdomain + "/archives/" + UDcity + "/leisure"))
		return true;
	return false;
		
}

public boolean isPerksAccessible(){
	
	if (client.getCurrentUrl().equals(Perksdomain + UDcityPerks))
		return true;
	return false;
		
}

public void doChecksCityHomePageLoggedOut() {
	// do all footer checks	for logged out state
	ud_footerHelper_Client = new UD_FooterHelper_Client(client); 
	this.checkUDHomepageCityFooterLoggedOut();
	this.checkUDHomepageCityHeaderLoggedOut();
}

public void doChecksCityHomePageLoggedIn(){
	// do all footer checks	for logged in state
	ud_footerHelper_Client = new UD_FooterHelper_Client(client); 
	this.checkUDHomepageCityFooterLoggedIn();
	this.checkUDHomepageCityHeaderLoggedIn();
}

public void doChecksLVPageLoggedOut() {
	// do all footer checks	for logged out state
	ud_footerHelper_Client = new UD_FooterHelper_Client(client); 
	this.checkUDHomepageCityFooterLoggedOut();
	this.checkUDHomepageLasVegasHeaderLoggedOut();
}

public void doChecksNationalPageLoggedOut() {
	// do all footer checks	for logged out state
	ud_footerHelper_Client = new UD_FooterHelper_Client(client); 
	this.checkUDHomepageCityFooterLoggedOut();
	this.checkUDHomepageNationalHeaderLoggedOut();
}
	
public void signUpUD_viaNewYorkStep1(){
		
		
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);
		ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
		
		ud_signupHelper_Client = new UD_SignupHelper_Client(client);
				
		System.out.println(emailClient);
		

		
		//go to /home/nyc
//		ud_homepageHelper_Client.clickNewYork();
				
		//step1, 1st signup modal: 
		//a. Click SignUp Seal
		ud_headerHelper_Client.clickSignUp();
		
		//or open new tab or go to the signup url
		
		//headerHelper_Client.openSignUpNewTab();
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//b. Enter email address
		ud_signupHelper_Client.enterEmail(emailClient);
		//c. Select Editions
		//New York, New York Perks are selected by default
		//check Driven
		ud_signupHelper_Client.checkDriven();
		ud_signupHelper_Client.checkJetset();
		ud_signupHelper_Client.checkLasVegas();
		ud_signupHelper_Client.checkNational();
		ud_signupHelper_Client.checkSkiBoard();
		
		//click "more" link to show all Editorials
		ud_signupHelper_Client.clickMoreLinkNewYork1();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		// check all of them
		ud_signupHelper_Client.checkAtlanta();
		ud_signupHelper_Client.checkBoston();
		ud_signupHelper_Client.checkChicago();
		ud_signupHelper_Client.checkDallas();
		ud_signupHelper_Client.checkDC();
		ud_signupHelper_Client.checkLosAngeles();
		ud_signupHelper_Client.checkMiami();
		ud_signupHelper_Client.checkSanFrancisco();
		
		//click "more" link to see the Perks editions
		ud_signupHelper_Client.clickMoreLinkNewYork2();
		
		// check all of them
		ud_signupHelper_Client.checkBostonPerks();
		ud_signupHelper_Client.checkChicagoPerks();
		ud_signupHelper_Client.checkDCPerks();
		ud_signupHelper_Client.checkLosAngelesPerks();
		ud_signupHelper_Client.checkMiamiPerks();
		ud_signupHelper_Client.checkNationalPerks();
		
		//click "JOIN" button
		
		ud_signupHelper_Client.clickJoin();
}
	

public void signUpUD_viaNewYorkStep2(){
	
	
	ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
	
	ud_signupHelper_Client = new UD_SignupHelper_Client(client);
		
		
//handling the silly behaviour of ajax, when the form comes back with "You must enter an email address." message as if email was not entered		
//		You must enter an email address.
//		client.findElement(By.xpath("//html/body/div[7]/div/div/div/div[2]/div/div")).click();
		
		
//		Assert.assertFalse(client.findElement(By.xpath("//html/body/div[7]/div/div/div/div[2]/div/div")).isDisplayed()); 
		
		
//		Assert.assertFalse(ud_signupHelper_Client.isStupidErrorAfterStep1Present());
		
//		try {
//			ud_signupHelper_Client.isStupidErrorAfterStep1Present();
//		}

		
		//step2, 2nd signup modal: 
		//enter password
		ud_signupHelper_Client.enterPassword(password);
		//confirm password
		ud_signupHelper_Client.confirmPassword(password);
		//First Name
		ud_signupHelper_Client.enterFirstName("FN_"+emailFormat.format(now));
		//Last Name
		ud_signupHelper_Client.enterLastName("LN_"+emailFormat.format(now));
		//Gender
		ud_signupHelper_Client.selectGender("Male");
		//ud_signupHelper_Client.selectGender("Female");
		//ud_signupHelper_Client.selectGenderRandom();

		//Income Range
		ud_signupHelper_Client.selectIncomeRange("Less than $30,000");
//		ud_signupHelper_Client.selectIncomeRange("$30,000-$44,999");
//		ud_signupHelper_Client.selectIncomeRange("$45,000-$59,999");
//		ud_signupHelper_Client.selectIncomeRange("$60,000-$74,999");
//		ud_signupHelper_Client.selectIncomeRange("$75,000-$99,999");
//		ud_signupHelper_Client.selectIncomeRange("$100,000-$199,999");
//		ud_signupHelper_Client.selectIncomeRange("$200,000-$299,999");
//		ud_signupHelper_Client.selectIncomeRange("$300,000-$499,999");
//		ud_signupHelper_Client.selectIncomeRange("$500,000+");
//		ud_signupHelper_Client.selectIncomeRangeRandom();

		//Zip Code
		ud_signupHelper_Client.enterZipCode("10001");
		//Birthday (MM/DD/YYYY)
		ud_signupHelper_Client.enterBirthday("07/07/1977");
		//click "SUBMIT" button
		
		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
				}
		ud_signupHelper_Client.clickSubmit();
}


public void signUpUD_viaNewYorkStep3(){
	
	
	ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
	
	ud_signupHelper_Client = new UD_SignupHelper_Client(client);
		
//step3, 3rd signup modal: Invite Friends
		
//		ud_signupHelper_Client.clickInvite();
		
		ud_signupHelper_Client.enterEmailFriend1(emailFriend1);
		ud_signupHelper_Client.enterEmailFriend2(emailFriend2);
		ud_signupHelper_Client.enterEmailFriend3(emailFriend3);
		ud_signupHelper_Client.enterEmailFriend4(emailFriend4);
		ud_signupHelper_Client.enterEmailFriend5(emailFriend5);
		
		System.out.println(emailFriend1);
		System.out.println(emailFriend2);
		System.out.println(emailFriend3);
		System.out.println(emailFriend4);
		System.out.println(emailFriend5);
		
		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
				}
		
		ud_signupHelper_Client.clickInvite();
		
//		ud_signupHelper_Client.clickSkip();
	}	

public void signUpUD_viaNewYorkStep4(){
	//step4, 4th signup modal confirmation, close final confirm signup box		
			ud_signupHelper_Client.clickCloseFinalModal();
	//end of registration
		}

public void signUpUD_viaNewYork(){
	
this.signUpUD_viaNewYorkStep1();
this.signUpUD_viaNewYorkStep2();
this.signUpUD_viaNewYorkStep3();
this.signUpUD_viaNewYorkStep4();
}

//this.signUpUD_viaNewYorkStep1();
//while (ud_signupHelper_Client.isStupidErrorAfterStep1Present())
//{for(int n=2; n<20; n++){
//	System.out.println(n);
//	this.signUpUD_viaNewYorkStep1();}}
//this.signUpUD_viaNewYorkStep2();
//this.signUpUD_viaNewYorkStep3();
//while (ud_signupHelper_Client.isStupidErrorAfterStep3Present())
//{this.signUpUD_viaNewYorkStep3();}
////this.signUpUD_viaNewYorkStep4();
//}

public void loginToGmail(){
	checkEmailHelper_Client = new CheckEmailHelper_Client(client);

	//go to gmail and confirm your email address
	this.client.navigate().to("https://mail.google.com/");
	checkEmailHelper_Client.clientLogInToGmail();
	
	this.pause2();
}

public void verifyWelcomeUDEmailReceived(){
	
	checkEmailHelper_Client = new CheckEmailHelper_Client(client);

	checkEmailHelper_Client.findSignupEmail("to: "+emailClient+" subject: Welcome to the Club");
	}

public void verifyInvitationsUDEmailsReceived(){
	checkEmailHelper_Client = new CheckEmailHelper_Client(client);
	
	checkEmailHelper_Client.findInvitationEmail1("to: "+emailFriend1+" subject: You're Invited");
	checkEmailHelper_Client.findInvitationEmail2("to: "+emailFriend2+" subject: You're Invited");
	checkEmailHelper_Client.findInvitationEmail3("to: "+emailFriend3+" subject: You're Invited");
	checkEmailHelper_Client.findInvitationEmail4("to: "+emailFriend4+" subject: You're Invited");
	checkEmailHelper_Client.findInvitationEmail5("to: "+emailFriend5+" subject: You're Invited");
}

public void verifyResetPasswordUDRequestReceivedandPasswordReset(){
	checkEmailHelper_Client = new CheckEmailHelper_Client(client);
//	resetEmailHelper_Client = new ResetEmailHelper_Client(client);
	ud_sealHelper_Client = new UD_SealHelper_Client(client);
	
	checkEmailHelper_Client.findResetEmailRequest("to: "+emailClient+" subject: UD | Password Reset Request");
	checkEmailHelper_Client.clickResetEmailRequestLink();
//	resetEmailHelper_Client.enterNewPassword(newpassword);
//	resetEmailHelper_Client.confirmNewPassword(newpassword);
//	resetEmailHelper_Client.clickSubmit();
//	Assert.assertTrue(sealHelper_Client.isSignedIn());


}


	public void changeCityFromUDHomepage(){
		//click on "Change City" from any city home page, navigate back to home page
	ud_headerHelper_Client = new UD_HeaderHelper_Client(client);

	ud_headerHelper_Client.clickChangeCity();
	}

	public void accessAtlantaFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickAtlanta();
		UDcity = "atl";
		UDcityPerks = "/national.html";
	}
	
	public void accessBostonFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickBoston();
		UDcity = "bos";
		UDcityPerks = "/boston.html";
	}
	
	public void accessChicagoFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickChicago();
		UDcity = "chi";
		UDcityPerks = "/chicago.html";
	}
	
	public void accessDallasFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickDallas();
		UDcity = "dal";
		UDcityPerks = "/national.html";
	}
	
	public void accessWashingtonDCFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickWashington();
		UDcity = "dc";
		UDcityPerks = "/washington-dc.html";
	}
	
	public void accessJetsetFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickJetset();
		UDcity = "jt";
		UDcityPerks = "/national.html";
	}
	
	public void accessLasVegasFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickLasVegas();
		UDcity = "lv";
		UDcityPerks = "/national.html";
	}
	
	public void accessLosAngelesFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickLosAngeles();
		UDcity = "la";
		UDcityPerks = "/los-angeles.html";
	}
	
	public void accessMiamiFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickMiami();
		UDcity = "mia";
		UDcityPerks = "/miami.html";
	}
	
	public void accessNationalFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickNational();
		UDcity = "ntl";
		UDcityPerks = "/national.html";
	}
	
	public void accessNewYorkFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickNewYork();
		UDcity = "nyc";
		UDcityPerks = "/new-york.html";
	}
	
	public void accessSanFranciscoFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickSanFrancisco();
		UDcity = "sfo";
		UDcityPerks = "/national.html";
	}
	
	public void accessSkiBoardFromUDHomepage(){
		ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

		ud_homepageHelper_Client.clickSkiBoard();
		UDcity = "bos";
		UDcityPerks = "/boston.html";
	}
	
///////////// Sign-up methods end here		
			
///////////////  Login/SignOut methods
	
	
	public void loginUD(){
		ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
		ud_sealHelper_Client = new UD_SealHelper_Client(client);
		
		this.client.navigate().to(UDdomain);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//close the signup modal
		//client.findElement(By.xpath("//div[@id='signInWrapper']/div")).click();
		
		ud_headerHelper_Client.clickMembrerLogIn();
		ud_sealHelper_Client.enterEmailAddress(emailClient);
		ud_sealHelper_Client.enterPassword("1234");
		ud_sealHelper_Client.clickLogin();
		
		// do all footer checks	for logged in state
		ud_footerHelper_Client = new UD_FooterHelper_Client(client); 
		this.checkUDHomepageCityFooterLoggedIn();
	} 
	 	

	public void logoutUD(){
		ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
		
		ud_headerHelper_Client.clickLogout();
		
		// do all footer checks	for logged out state
		ud_footerHelper_Client = new UD_FooterHelper_Client(client); 
		this.checkUDHomepageCityFooterLoggedOut();
		
	}
	
	public void resetPasswordUD(){
		ud_sealHelper_Client = new UD_SealHelper_Client(client);
		ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
		
		ud_headerHelper_Client.clickMembrerLogIn();
		ud_sealHelper_Client.clickResetPassword();
		ud_sealHelper_Client.enterEmailToReset(emailClient);
		ud_sealHelper_Client.clickSend();	
		
	}

///check email methods
	
//	public void checkEmailWelcome(){
//		ud_signupHelper_Client = new UD_SignupHelper_Client(client);
//		checkEmailHelper_Client = new CheckEmailHelper_Client(client);
//		
//		//go to gmail and confirm your email address
//		this.client.navigate().to("https://mail.google.com/");
//		ud_signupHelper_Client.clientLogInToGmail();
//		checkEmailHelper_Client.searchAndFindEmailWelcome(groupname);
//		this.client.navigate().to(UDdomain +"/home");
//	}

	@AfterMethod
	public void afterMainMethod() {
		this.afterMethod();
		client.quit();
	}

	@BeforeClass
	public void beforeMainClass() {
		this.beforeClass();
	}

	@AfterClass
	public void afterMainClass() {
		this.afterClass();
	}

	@BeforeTest
	public void beforeMainTest() {
		this.beforeTest();
	}

	@AfterTest
	public void afterMainTest() {
		this.afterTest();
	}

	public abstract void beforeMethod();

	public abstract void afterMethod();

	public abstract void beforeClass();

	public abstract void afterClass();

	public abstract void beforeTest();

	public abstract void afterTest();
}
