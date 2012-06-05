package org.urbandaddy.helpers.Comm;

import java.io.File;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
//import java.util.concurrent.TimeUnit;
import java.util.*;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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


import org.urbandaddy.helpers.FooterHelper_Client;
import org.urbandaddy.helpers.HeaderHelper_Client;
//import org.urbandaddy.helpers.InvitationsHelper_Client;
import org.urbandaddy.helpers.SealHelper_Client;
//import org.urbandaddy.helpers.ReauthenticateHelper_Client;
//import org.urbandaddy.helpers.SettingsHelper_Client;
import org.urbandaddy.helpers.HomepageHelper_Client;
import org.urbandaddy.helpers.CheckEmailHelper_Client;
import org.urbandaddy.helpers.ResetEmailHelper_Client;

//import org.urbandaddy.helpers.Comm.ITestCase;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.urbandaddy.helpers.SignupHelper;

import org.urbandaddy.helpers.SignupHelper_Client;

public abstract class ITestCase {

	enum DriverType {
		Firefox, IE, Ghrome, FirefoxRemote12
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
else if (DriverType.FirefoxRemote12.toString().equals(driverType)) 
			
		{
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setCapability("seleniumProtocol", "WebDriver");
			
			//capability.setCapability("browserName", "firefox10");
			//capability.setBrowserName("firefox10");
	    	//capability.setCapability("firefox_binary" , "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
			//capability.setCapability("maxInstances", 5);		
			capability.setCapability("jenkins.nodeName", "WindowsSlave1");
			capability.setCapability("javascriptEnabled ", true);
			//FirefoxProfile ffPrfile;
            //ffprofile.setPreference("javascript.enabled", true);
			capability.setVersion("12");
			
			
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
	
	private HomepageHelper_Client homepageHelper_Client;
	private HeaderHelper_Client headerHelper_Client;
	private FooterHelper_Client footerHelper_Client;
	private SealHelper_Client sealHelper_Client;
	private ResetEmailHelper_Client resetEmailHelper_Client;
//	private ReauthenticateHelper_Client reauthenticateHelper_Client;
//	private SettingsHelper_Client settingsHelper_Client;
	private SignupHelper_Client signupHelper_Client;
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
	private String newpassword="1234";

///// Sign-up methods
	
// 	Client
	
public void visitUDFirstTime(){
	
	// enter UDdomain name, hit enter, arrive on homepage
			this.client.navigate().to(UDdomain);
			this.client.manage().deleteAllCookies();
			this.client.navigate().to(UDdomain);
			this.client.manage().addCookie(new Cookie ("udsubpop", "3","ud-branch.thedaddy.co", "/", null));
			
	//do all homepage checks
		homepageHelper_Client = new HomepageHelper_Client(client);
		
		//Verify All items are present on HomePage
		Assert.assertTrue(homepageHelper_Client.isUDLogoPresent());
		Assert.assertTrue(homepageHelper_Client.isClickableCopyPresent());
		Assert.assertTrue(homepageHelper_Client.isSignUpSealPresent());
		Assert.assertTrue(homepageHelper_Client.isAtlantaLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isBostonLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isChicagoLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isDallasLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isWashingtonDCLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isDrivenLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isJetsetLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isLasVegasLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isLosAngelesLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isMiamiLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isNationalLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isNewYorkLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isSanFranciscoLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isSkiBoardLinkPresent());
		Assert.assertTrue(homepageHelper_Client.isUDLogoPresent());
		
	// do all footer checks	
		footerHelper_Client = new FooterHelper_Client(client); 
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

public void createArticleThreeColumn(){
	
	client.get(UD_Admin_domain+"/articles/create");
	//client.findElement(By.xpath("//html/body/div[3]/div/div[3]/ul/li/input")).click();
	
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
	client.findElement(By.id("article_name")).sendKeys("Test Article Title "+emailFormat.format(now));
    
	//Enter Business Name/Subject
	//client.findElement(By.id("article_business_name")).clear();
	client.findElement(By.id("article_business_name")).sendKeys("Test Business Name "+emailFormat.format(now));
	
	//Enter Article Subheader
	client.findElement(By.id("article_teaser")).sendKeys("Test Article Subheader "+emailFormat.format(now));

	//Enter Email Subject Line
	client.findElement(By.id("article_email_subject_line")).sendKeys("Test Email Subject "+emailFormat.format(now));

	//Save
	client.findElement(By.name("save")).click();
	
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

//go back to the article
		client.get(UD_Admin_domain+"/articles/edit/id/"+articleID);
		
//enter photo credits
		client.findElement(By.id("article[photo_credit]")).sendKeys("Photo Credits Test "+emailFormat.format(now));

//enter Article/Feature introduction
		client.findElement(By.id("article[short]")).sendKeys("Article/Feature Introduction Test "+emailFormat.format(now));
		
//enter Copy !!!Figure out how to interact with this version of FCK editor
	
		
//Article Blurb
		client.findElement(By.id("article[blurb]")).sendKeys("Article Blurb Test "+emailFormat.format(now));

//iPhone Blurb
		client.findElement(By.id("article[blurb_iphone]")).sendKeys("iPhone Blurb Test "+emailFormat.format(now));

//Twitter Blurb
		client.findElement(By.id("article_blurb_twitter")).sendKeys("Twitter Blurb Test "+emailFormat.format(now));
		
//enter Note !!!Figure out how to interact with this version of FCK editor

//Legal Line
		client.findElement(By.id("article[footer_additional]")).sendKeys("Legal Line Test "+emailFormat.format(now));

//Keywords
		client.findElement(By.id("article_keywords")).sendKeys("Keywords Test Keywords "+emailFormat.format(now));

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
		
		client.findElement(By.id("article_business_specialty")).sendKeys("Business Specialty Test "+emailFormat.format(now));

//Save
		client.findElement(By.name("save")).click();
		
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
		alert.accept();
		
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
				
		// Verify "Test email has been sent" success message
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div[3]/div/div/h2")).getText().contains("Test email has been sent"));

//Click Back to Article, Change Status to Ready to Send, Click Save, Click Send E-mail, Click Send Mailing at bottom of page
		//go back to the article
				client.get(UD_Admin_domain+"/articles/edit/id/"+articleID);
				
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
	headerHelper_Client = new HeaderHelper_Client(client);
	Assert.assertTrue(headerHelper_Client.isNightlifePresent());
	Assert.assertTrue(headerHelper_Client.isFoodPresent());
	Assert.assertTrue(headerHelper_Client.isStylePresent());
	Assert.assertTrue(headerHelper_Client.isGearPresent());
	Assert.assertTrue(headerHelper_Client.isLeisurePresent());
	Assert.assertTrue(headerHelper_Client.isDrivenPresent());
	Assert.assertTrue(headerHelper_Client.isPerksPresent());
	Assert.assertTrue(headerHelper_Client.isPartiesPresent());
	Assert.assertTrue(headerHelper_Client.isKemptPresent());
	Assert.assertTrue(headerHelper_Client.isMobilePresent());
	
	headerHelper_Client.clickNightlife();
	Assert.assertTrue(isNightlifeAccessible());
	headerHelper_Client.clickFood();
	Assert.assertTrue(isFoodAccessible());
	headerHelper_Client.clickStyle();
	Assert.assertTrue(isStyleAccessible());
	headerHelper_Client.clickGear();
	Assert.assertTrue(isGearAccessible());
	headerHelper_Client.clickLeisure();
	Assert.assertTrue(isLeisureAccessible());
	
	Assert.assertTrue(headerHelper_Client.isDrivenAccessible());
	this.client.navigate().back();
	headerHelper_Client.clickPerks();
	Assert.assertTrue(isPerksAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isPartiesAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isKemptAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isMobileAccessible());
	this.client.navigate().back();

}

public void checkUDHomepageLasVegasHeaderLoggedOut(){
	
	//do all homepage footer checks
	headerHelper_Client = new HeaderHelper_Client(client);
	Assert.assertTrue(headerHelper_Client.isNightlifeLVPresent());
	Assert.assertTrue(headerHelper_Client.isFoodLVPresent());
	Assert.assertTrue(headerHelper_Client.isEntertainmentLVPresent());
	Assert.assertTrue(headerHelper_Client.isPerksLVPresent());
	Assert.assertTrue(headerHelper_Client.isPartiesLVPresent());
	Assert.assertTrue(headerHelper_Client.isKemptLVPresent());
	Assert.assertTrue(headerHelper_Client.isMobileLVPresent());
	
	headerHelper_Client.clickNightlifeLV();
	Assert.assertTrue(isNightlifeAccessible());
	headerHelper_Client.clickFoodLV();
	Assert.assertTrue(isFoodAccessible());
	headerHelper_Client.clickEntertainmentLV();
	Assert.assertTrue(isEntertainmentAccessible());

	headerHelper_Client.clickPerksLV();
	Assert.assertTrue(isPerksAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isPartiesLVAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isKemptLVAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isMobileLVAccessible());
	this.client.navigate().back();

	
}

public void checkUDHomepageNationalHeaderLoggedOut(){
	
	//do all homepage footer checks
	headerHelper_Client = new HeaderHelper_Client(client);
	Assert.assertTrue(headerHelper_Client.isFoodDrinkNationalPresent());
	Assert.assertTrue(headerHelper_Client.isStyleNationalPresent());
	Assert.assertTrue(headerHelper_Client.isGearNationalPresent());
	Assert.assertTrue(headerHelper_Client.isEntertainmentNationalPresent());
	Assert.assertTrue(headerHelper_Client.isTravelNationalPresent());
	Assert.assertTrue(headerHelper_Client.isDrivenNationalPresent());
	Assert.assertTrue(headerHelper_Client.isPerksNationalPresent());
	Assert.assertTrue(headerHelper_Client.isPartiesNationalPresent());
	Assert.assertTrue(headerHelper_Client.isKemptNationalPresent());
	Assert.assertTrue(headerHelper_Client.isMobileNationalPresent());
	
	headerHelper_Client.clickFoodDrinkNational();
	Assert.assertTrue(isFoodDrinkNationalAccessible());
	headerHelper_Client.clickStyleNational();
	Assert.assertTrue(isStyleAccessible());
	headerHelper_Client.clickGearNational();
	Assert.assertTrue(isGearAccessible());
	headerHelper_Client.clickEntertainmentNational();
	Assert.assertTrue(isEntertainmentAccessible());
	headerHelper_Client.clickTravelNational();
	Assert.assertTrue(isTravelAccessible());
	
	Assert.assertTrue(headerHelper_Client.isDrivenNationalAccessible());
	this.client.navigate().back();
	headerHelper_Client.clickPerks();
	Assert.assertTrue(isPerksAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isPartiesNationalAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isKemptNationalAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isMobileNationalAccessible());
	this.client.navigate().back();
}

public void checkUDHomepageCityHeaderLoggedIn(){
	
	//do all homepage footer checks
	headerHelper_Client = new HeaderHelper_Client(client);
	Assert.assertTrue(headerHelper_Client.isNightlifePresent());
	Assert.assertTrue(headerHelper_Client.isFoodPresent());
	Assert.assertTrue(headerHelper_Client.isStylePresent());
	Assert.assertTrue(headerHelper_Client.isGearPresent());
	Assert.assertTrue(headerHelper_Client.isLeisurePresent());
	Assert.assertTrue(headerHelper_Client.isDrivenPresent());
	Assert.assertTrue(headerHelper_Client.isPerksPresent());
	Assert.assertTrue(headerHelper_Client.isPartiesPresent());
	Assert.assertTrue(headerHelper_Client.isKemptPresent());
	
	headerHelper_Client.clickNightlife();
	Assert.assertTrue(isNightlifeAccessible());
	headerHelper_Client.clickFood();
	Assert.assertTrue(isFoodAccessible());
	headerHelper_Client.clickStyle();
	Assert.assertTrue(isStyleAccessible());
	headerHelper_Client.clickGear();
	Assert.assertTrue(isGearAccessible());
	headerHelper_Client.clickLeisure();
	Assert.assertTrue(isLeisureAccessible());
	
	Assert.assertTrue(headerHelper_Client.isDrivenAccessible());
	this.client.navigate().back();
	headerHelper_Client.clickPerks();
	this.client.navigate().back();
	headerHelper_Client.clickPerks();
	Assert.assertTrue(isPerksAccessible());	
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isPartiesAccessible());
	this.client.navigate().back();
	Assert.assertTrue(headerHelper_Client.isKemptAccessible());
	this.client.navigate().back();
	
}

public void checkUDHomepageFooter(){
	
	//do all homepage footer checks
	footerHelper_Client = new FooterHelper_Client(client);
	Assert.assertTrue(footerHelper_Client.isAboutUsHomePresent());
	Assert.assertTrue(footerHelper_Client.isSignUpHomePresent());
	Assert.assertTrue(footerHelper_Client.isMyUDHomePresent());
	Assert.assertTrue(footerHelper_Client.isContactHomePresent());
	Assert.assertTrue(footerHelper_Client.isJobsHomePresent());
	Assert.assertTrue(footerHelper_Client.isAdvertiseHomePresent());
	Assert.assertTrue(footerHelper_Client.isTipsHomePresent());
	Assert.assertTrue(footerHelper_Client.isEmailIssuesHomePresent());
	Assert.assertTrue(footerHelper_Client.isPrivacyPolicyHomePresent());
	Assert.assertTrue(footerHelper_Client.isUserAgreementHomePresent());
	Assert.assertTrue(footerHelper_Client.isUnsubscribeHomePresent());
	Assert.assertTrue(footerHelper_Client.isEditorialPolicyHomePresent());
	
	
	Assert.assertTrue(footerHelper_Client.isAtlantaHomePresent());
	Assert.assertTrue(footerHelper_Client.isBostonHomePresent());
	Assert.assertTrue(footerHelper_Client.isChicagoHomePresent());
	Assert.assertTrue(footerHelper_Client.isDallasHomePresent());
	Assert.assertTrue(footerHelper_Client.isDCHomePresent());
	Assert.assertTrue(footerHelper_Client.isDrivenHomePresent());
	Assert.assertTrue(footerHelper_Client.isJetsetHomePresent());
	Assert.assertTrue(footerHelper_Client.isLasVegasHomePresent());
	Assert.assertTrue(footerHelper_Client.isLosAngelesHomePresent());
	Assert.assertTrue(footerHelper_Client.isMiamiHomePresent());
	Assert.assertTrue(footerHelper_Client.isNationalHomePresent());
	Assert.assertTrue(footerHelper_Client.isNewYorkHomePresent());
	Assert.assertTrue(footerHelper_Client.isSanFranciscoHomePresent());
	Assert.assertTrue(footerHelper_Client.isSkiBoardHomePresent());
	
}

public void checkUDHomepageCityFooterLoggedIn(){
	
	//do all city homepage footer checks for logged in state
	footerHelper_Client = new FooterHelper_Client(client);
	Assert.assertTrue(footerHelper_Client.isAboutUsCityPresent());
//	Assert.assertTrue(footerHelper_Client.isSignUpPresentCity());
	Assert.assertTrue(footerHelper_Client.isMyUDCityPresent());
	Assert.assertTrue(footerHelper_Client.isContactCityPresent());
	Assert.assertTrue(footerHelper_Client.isJobsCityPresent());
	Assert.assertTrue(footerHelper_Client.isAdvertiseCityPresent());
	Assert.assertTrue(footerHelper_Client.isTipsCityPresent());
	Assert.assertTrue(footerHelper_Client.isUnsubscribeCityPresent());
	Assert.assertTrue(footerHelper_Client.isMobileSiteCityPresent());
	Assert.assertTrue(footerHelper_Client.isEmailIssuesCityPresent());
	Assert.assertTrue(footerHelper_Client.isPrivacyPolicyCityPresent());
	Assert.assertTrue(footerHelper_Client.isUserAgreementCityPresent());
	Assert.assertTrue(footerHelper_Client.isEditorialPolicyCityPresent());
	
	
	Assert.assertTrue(footerHelper_Client.isAtlantaCityPresent());
	Assert.assertTrue(footerHelper_Client.isBostonCityPresent());
	Assert.assertTrue(footerHelper_Client.isChicagoCityPresent());
	Assert.assertTrue(footerHelper_Client.isDallasCityPresent());
	Assert.assertTrue(footerHelper_Client.isDCCityPresent());
	Assert.assertTrue(footerHelper_Client.isDrivenCityPresent());
	Assert.assertTrue(footerHelper_Client.isJetsetCityPresent());
	Assert.assertTrue(footerHelper_Client.isLasVegasCityPresent());
	Assert.assertTrue(footerHelper_Client.isLosAngelesCityPresent());
	Assert.assertTrue(footerHelper_Client.isMiamiCityPresent());
	Assert.assertTrue(footerHelper_Client.isNationalCityPresent());
	Assert.assertTrue(footerHelper_Client.isNewYorkCityPresent());
	Assert.assertTrue(footerHelper_Client.isSanFranciscoCityPresent());
	Assert.assertTrue(footerHelper_Client.isSkiBoardCityPresent());
	
}

public void checkUDHomepageCityFooterLoggedOut(){
	
	//do all city homepage footer checks for logged out state
	footerHelper_Client = new FooterHelper_Client(client);
	Assert.assertTrue(footerHelper_Client.isAboutUsCityPresent());
	Assert.assertTrue(footerHelper_Client.isSignUpCityPresent());
	Assert.assertTrue(footerHelper_Client.isMyUDCityPresent());
	Assert.assertTrue(footerHelper_Client.isContactCityPresent());
	Assert.assertTrue(footerHelper_Client.isJobsCityPresent());
	Assert.assertTrue(footerHelper_Client.isAdvertiseCityPresent());
	Assert.assertTrue(footerHelper_Client.isTipsCityPresent());
	Assert.assertTrue(footerHelper_Client.isUnsubscribeCityPresent());
	Assert.assertTrue(footerHelper_Client.isMobileSiteCityPresent());
	Assert.assertTrue(footerHelper_Client.isEmailIssuesCityPresent());
	Assert.assertTrue(footerHelper_Client.isPrivacyPolicyCityPresent());
	Assert.assertTrue(footerHelper_Client.isUserAgreementCityPresent());
	Assert.assertTrue(footerHelper_Client.isEditorialPolicyCityPresent());
	
	
	Assert.assertTrue(footerHelper_Client.isAtlantaCityPresent());
	Assert.assertTrue(footerHelper_Client.isBostonCityPresent());
	Assert.assertTrue(footerHelper_Client.isChicagoCityPresent());
	Assert.assertTrue(footerHelper_Client.isDallasCityPresent());
	Assert.assertTrue(footerHelper_Client.isDCCityPresent());
	Assert.assertTrue(footerHelper_Client.isDrivenCityPresent());
	Assert.assertTrue(footerHelper_Client.isJetsetCityPresent());
	Assert.assertTrue(footerHelper_Client.isLasVegasCityPresent());
	Assert.assertTrue(footerHelper_Client.isLosAngelesCityPresent());
	Assert.assertTrue(footerHelper_Client.isMiamiCityPresent());
	Assert.assertTrue(footerHelper_Client.isNationalCityPresent());
	Assert.assertTrue(footerHelper_Client.isNewYorkCityPresent());
	Assert.assertTrue(footerHelper_Client.isSanFranciscoCityPresent());
	Assert.assertTrue(footerHelper_Client.isSkiBoardCityPresent());
	
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
	footerHelper_Client = new FooterHelper_Client(client); 
	this.checkUDHomepageCityFooterLoggedOut();
	this.checkUDHomepageCityHeaderLoggedOut();
}

public void doChecksCityHomePageLoggedIn(){
	// do all footer checks	for logged in state
	footerHelper_Client = new FooterHelper_Client(client); 
	this.checkUDHomepageCityFooterLoggedIn();
	this.checkUDHomepageCityHeaderLoggedIn();
}

public void doChecksLVPageLoggedOut() {
	// do all footer checks	for logged out state
	footerHelper_Client = new FooterHelper_Client(client); 
	this.checkUDHomepageCityFooterLoggedOut();
	this.checkUDHomepageLasVegasHeaderLoggedOut();
}

public void doChecksNationalPageLoggedOut() {
	// do all footer checks	for logged out state
	footerHelper_Client = new FooterHelper_Client(client); 
	this.checkUDHomepageCityFooterLoggedOut();
	this.checkUDHomepageNationalHeaderLoggedOut();
}
	
public void signUpUD_viaNewYorkStep1(){
		
		
		homepageHelper_Client = new HomepageHelper_Client(client);
		headerHelper_Client = new HeaderHelper_Client(client);
		
		signupHelper_Client = new SignupHelper_Client(client);
				
		System.out.println(emailClient);
		

		
		//go to /home/nyc
//		homepageHelper_Client.clickNewYork();
				
		//step1, 1st signup modal: 
		//a. Click SignUp Seal
		headerHelper_Client.clickSignUp();
		
		//or open new tab or go to the signup url
		
		//headerHelper_Client.openSignUpNewTab();
		
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		//b. Enter email address
		signupHelper_Client.enterEmail(emailClient);
		//c. Select Editions
		//New York, New York Perks are selected by default
		//check Driven
		signupHelper_Client.checkDriven();
		signupHelper_Client.checkJetset();
		signupHelper_Client.checkLasVegas();
		signupHelper_Client.checkNational();
		signupHelper_Client.checkSkiBoard();
		
		//click "more" link to show all Editorials
		signupHelper_Client.clickMoreLinkNewYork1();
		
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		// check all of them
		signupHelper_Client.checkAtlanta();
		signupHelper_Client.checkBoston();
		signupHelper_Client.checkChicago();
		signupHelper_Client.checkDallas();
		signupHelper_Client.checkDC();
		signupHelper_Client.checkLosAngeles();
		signupHelper_Client.checkMiami();
		signupHelper_Client.checkSanFrancisco();
		
		//click "more" link to see the Perks editions
		signupHelper_Client.clickMoreLinkNewYork2();
		
		// check all of them
		signupHelper_Client.checkBostonPerks();
		signupHelper_Client.checkChicagoPerks();
		signupHelper_Client.checkDCPerks();
		signupHelper_Client.checkLosAngelesPerks();
		signupHelper_Client.checkMiamiPerks();
		signupHelper_Client.checkNationalPerks();
		
		//click "JOIN" button
		
		signupHelper_Client.clickJoin();
}
	

public void signUpUD_viaNewYorkStep2(){
	
	
	homepageHelper_Client = new HomepageHelper_Client(client);
	headerHelper_Client = new HeaderHelper_Client(client);
	
	signupHelper_Client = new SignupHelper_Client(client);
		
		
//handling the silly behaviour of ajax, when the form comes back with "You must enter an email address." message as if email was not entered		
//		You must enter an email address.
//		client.findElement(By.xpath("//html/body/div[7]/div/div/div/div[2]/div/div")).click();
		
		
//		Assert.assertFalse(client.findElement(By.xpath("//html/body/div[7]/div/div/div/div[2]/div/div")).isDisplayed()); 
		
		
//		Assert.assertFalse(signupHelper_Client.isStupidErrorAfterStep1Present());
		
//		try {
//			signupHelper_Client.isStupidErrorAfterStep1Present();
//		}

		
		//step2, 2nd signup modal: 
		//enter password
		signupHelper_Client.enterPassword(password);
		//confirm password
		signupHelper_Client.confirmPassword(password);
		//First Name
		signupHelper_Client.enterFirstName("FN_"+emailFormat.format(now));
		//Last Name
		signupHelper_Client.enterLastName("LN_"+emailFormat.format(now));
		//Gender
		signupHelper_Client.selectGender("Male");
		//signupHelper_Client.selectGender("Female");
		//signupHelper_Client.selectGenderRandom();

		//Income Range
		signupHelper_Client.selectIncomeRange("Less than $30,000");
//		signupHelper_Client.selectIncomeRange("$30,000-$44,999");
//		signupHelper_Client.selectIncomeRange("$45,000-$59,999");
//		signupHelper_Client.selectIncomeRange("$60,000-$74,999");
//		signupHelper_Client.selectIncomeRange("$75,000-$99,999");
//		signupHelper_Client.selectIncomeRange("$100,000-$199,999");
//		signupHelper_Client.selectIncomeRange("$200,000-$299,999");
//		signupHelper_Client.selectIncomeRange("$300,000-$499,999");
//		signupHelper_Client.selectIncomeRange("$500,000+");
//		signupHelper_Client.selectIncomeRangeRandom();

		//Zip Code
		signupHelper_Client.enterZipCode("10001");
		//Birthday (MM/DD/YYYY)
		signupHelper_Client.enterBirthday("07/07/1977");
		//click "SUBMIT" button
		
		try {
			Thread.sleep(1000);
			} catch (InterruptedException e) {
			e.printStackTrace();
				}
		signupHelper_Client.clickSubmit();
}


public void signUpUD_viaNewYorkStep3(){
	
	
	homepageHelper_Client = new HomepageHelper_Client(client);
	headerHelper_Client = new HeaderHelper_Client(client);
	
	signupHelper_Client = new SignupHelper_Client(client);
		
//step3, 3rd signup modal: Invite Friends
		
//		signupHelper_Client.clickInvite();
		
		signupHelper_Client.enterEmailFriend1(emailFriend1);
		signupHelper_Client.enterEmailFriend2(emailFriend2);
		signupHelper_Client.enterEmailFriend3(emailFriend3);
		signupHelper_Client.enterEmailFriend4(emailFriend4);
		signupHelper_Client.enterEmailFriend5(emailFriend5);
		
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
		
		signupHelper_Client.clickInvite();
		
//		signupHelper_Client.clickSkip();
	}	

public void signUpUD_viaNewYorkStep4(){
	//step4, 4th signup modal confirmation, close final confirm signup box		
			signupHelper_Client.clickCloseFinalModal();
	//end of registration
		}

public void signUpUD_viaNewYork(){
	
this.signUpUD_viaNewYorkStep1();
this.signUpUD_viaNewYorkStep2();
this.signUpUD_viaNewYorkStep3();
this.signUpUD_viaNewYorkStep4();
}

//this.signUpUD_viaNewYorkStep1();
//while (signupHelper_Client.isStupidErrorAfterStep1Present())
//{for(int n=2; n<20; n++){
//	System.out.println(n);
//	this.signUpUD_viaNewYorkStep1();}}
//this.signUpUD_viaNewYorkStep2();
//this.signUpUD_viaNewYorkStep3();
//while (signupHelper_Client.isStupidErrorAfterStep3Present())
//{this.signUpUD_viaNewYorkStep3();}
////this.signUpUD_viaNewYorkStep4();
//}

public void loginToGmail(){
	checkEmailHelper_Client = new CheckEmailHelper_Client(client);

	//go to gmail and confirm your email address
	this.client.navigate().to("https://mail.google.com/");
	checkEmailHelper_Client.clientLogInToGmail();
}

public void verifyWelcomeEmailReceived(){
	
	checkEmailHelper_Client = new CheckEmailHelper_Client(client);

	checkEmailHelper_Client.findSignupEmail("to: "+emailClient+" subject: Welcome to the Club");
	}

public void verifyInvitationsEmailsReceived(){
	checkEmailHelper_Client = new CheckEmailHelper_Client(client);
	
	checkEmailHelper_Client.findInvitationEmail1("to: "+emailFriend1+" subject: You're Invited");
	checkEmailHelper_Client.findInvitationEmail2("to: "+emailFriend2+" subject: You're Invited");
	checkEmailHelper_Client.findInvitationEmail3("to: "+emailFriend3+" subject: You're Invited");
	checkEmailHelper_Client.findInvitationEmail4("to: "+emailFriend4+" subject: You're Invited");
	checkEmailHelper_Client.findInvitationEmail5("to: "+emailFriend5+" subject: You're Invited");
}

public void verifyResetPasswordRequestReceivedandPasswordReset(){
	checkEmailHelper_Client = new CheckEmailHelper_Client(client);
	resetEmailHelper_Client = new ResetEmailHelper_Client(client);
	sealHelper_Client = new SealHelper_Client(client);
	
	checkEmailHelper_Client.findResetEmailRequest("to: "+emailClient+" subject: UD | Password Reset Request");
	checkEmailHelper_Client.clickResetEmailRequestLink();
//	resetEmailHelper_Client.enterNewPassword(newpassword);
//	resetEmailHelper_Client.confirmNewPassword(newpassword);
//	resetEmailHelper_Client.clickSubmit();
//	Assert.assertTrue(sealHelper_Client.isSignedIn());


}


	public void changeCityFromUDHomepage(){
		//click on "Change City" from any city home page, navigate back to home page
	headerHelper_Client = new HeaderHelper_Client(client);

	headerHelper_Client.clickChangeCity();
	}

	public void accessAtlantaFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickAtlanta();
		UDcity = "atl";
		UDcityPerks = "/national.html";
	}
	
	public void accessBostonFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickBoston();
		UDcity = "bos";
		UDcityPerks = "/boston.html";
	}
	
	public void accessChicagoFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickChicago();
		UDcity = "chi";
		UDcityPerks = "/chicago.html";
	}
	
	public void accessDallasFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickDallas();
		UDcity = "dal";
		UDcityPerks = "/national.html";
	}
	
	public void accessWashingtonDCFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickWashington();
		UDcity = "dc";
		UDcityPerks = "/washington-dc.html";
	}
	
	public void accessJetsetFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickJetset();
		UDcity = "jt";
		UDcityPerks = "/national.html";
	}
	
	public void accessLasVegasFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickLasVegas();
		UDcity = "lv";
		UDcityPerks = "/national.html";
	}
	
	public void accessLosAngelesFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickLosAngeles();
		UDcity = "la";
		UDcityPerks = "/los-angeles.html";
	}
	
	public void accessMiamiFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickMiami();
		UDcity = "mia";
		UDcityPerks = "/miami.html";
	}
	
	public void accessNationalFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickNational();
		UDcity = "ntl";
		UDcityPerks = "/national.html";
	}
	
	public void accessNewYorkFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickNewYork();
		UDcity = "nyc";
		UDcityPerks = "/new-york.html";
	}
	
	public void accessSanFranciscoFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickSanFrancisco();
		UDcity = "sfo";
		UDcityPerks = "/national.html";
	}
	
	public void accessSkiBoardFromUDHomepage(){
		homepageHelper_Client = new HomepageHelper_Client(client);

		homepageHelper_Client.clickSkiBoard();
		UDcity = "bos";
		UDcityPerks = "/boston.html";
	}
	
///////////// Sign-up methods end here		
			
///////////////  Login/SignOut methods
	
	
	public void loginUD(){
		headerHelper_Client = new HeaderHelper_Client(client);
		sealHelper_Client = new SealHelper_Client(client);
		
		this.client.navigate().to(UDdomain);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//close the signup modal
		//client.findElement(By.xpath("//div[@id='signInWrapper']/div")).click();
		
		headerHelper_Client.clickMembrerLogIn();
		sealHelper_Client.enterEmailAddress(emailClient);
		sealHelper_Client.enterPassword("1234");
		sealHelper_Client.clickLogin();
		
		// do all footer checks	for logged in state
		footerHelper_Client = new FooterHelper_Client(client); 
		this.checkUDHomepageCityFooterLoggedIn();
	} 
	 	

	public void logoutUD(){
		headerHelper_Client = new HeaderHelper_Client(client);
		
		headerHelper_Client.clickLogout();
		
		// do all footer checks	for logged out state
		footerHelper_Client = new FooterHelper_Client(client); 
		this.checkUDHomepageCityFooterLoggedOut();
		
	}
	
	public void resetPasswordUD(){
		sealHelper_Client = new SealHelper_Client(client);
		headerHelper_Client = new HeaderHelper_Client(client);
		
		headerHelper_Client.clickMembrerLogIn();
		sealHelper_Client.clickResetPassword();
		sealHelper_Client.enterEmailToReset(emailClient);
		sealHelper_Client.clickSend();	
		
	}

///check email methods
	
//	public void checkEmailWelcome(){
//		signupHelper_Client = new SignupHelper_Client(client);
//		checkEmailHelper_Client = new CheckEmailHelper_Client(client);
//		
//		//go to gmail and confirm your email address
//		this.client.navigate().to("https://mail.google.com/");
//		signupHelper_Client.clientLogInToGmail();
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
