package org.urbandaddy.helpers.Comm;

import java.io.File;
//import java.io.IOException;

import java.lang.System;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;



//import org.openqa.selenium.JavascriptExecutor;
//import org.sikuli.script.*;


import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
//import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
//import org.openqa.selenium.Cookie;

//Workflow specific imports

import org.urbandaddy.helpers.*;
//import org.urbandaddy.helpers.ResetEmailHelper_Client;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.urbandaddy.helpers.SignupHelper;


public abstract class ITestCase {

    enum DriverType {
        Firefox, IE, Ghrome, Win7FF14Remote, Win7IE9Remote, IESauce, ChromeSauce, Win7FF14Sauce, MacFF14Sauce, MacSafariSauce
    }

    public WebDriver client;

    protected RemoteWebDriver driver;

//	private static ChromeDriverService service;

    @BeforeMethod
    @Parameters({ "driverType", "profilePath" })
    public void beforeMainMethod(String driverType, String profilePath) {
        // TODO: some config xml file
        if (DriverType.Firefox.toString().equals(driverType)) {

            if (profilePath == null || profilePath.isEmpty()) {
                client = new FirefoxDriver();
                //	cms = new FirefoxDriver();
                client.manage().window().maximize();

            } else {
                File file = new File(profilePath);
                FirefoxProfile profile = new FirefoxProfile(file);
                client = new FirefoxDriver(profile);
                //	cms = new FirefoxDriver(profile);
                client.manage().window().maximize();
            }

        } else if (DriverType.IE.toString().equals(driverType)) {
            client = new InternetExplorerDriver();
            //	cms = new InternetExplorerDriver();

        } else if (DriverType.Ghrome.toString().equals(driverType)) {
            client = new ChromeDriver();
            //	cms = new ChromeDriver();

        } else if (DriverType.Win7FF14Remote.toString().equals(driverType)) {
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
                //	client.manage().window().setSize(targetSize)
                //	resource = new RemoteWebDriver(new URL(Config.serverJenkins), capability);
                //	wald = new RemoteWebDriver(new URL(Config.serverJenkins), capability);
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else if (DriverType.Win7IE9Remote.toString().equals(driverType)) {
            DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
            capability.setCapability("seleniumProtocol", "WebDriver");

            //capability.setCapability("browserName", "firefox10");
            //capability.setBrowserName("firefox10");
            //capability.setCapability("firefox_binary" , "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
            //capability.setCapability("maxInstances", 5);
            capability.setCapability("jenkins.nodeName", "WindowsSlave2");
            //capability.setCapability("javascriptEnabled ", true);
            //FirefoxProfile ffPrfile;
            //ffprofile.setPreference("javascript.enabled", true);
            //capability.setVersion("14");


            try {
                client = new RemoteWebDriver(new URL("http://jenkins-master.thedaddy.co:4444/wd/hub"), capability);
                client.manage().window().maximize();
                //		client.manage().window().setSize(targetSize)
                //		resource = new RemoteWebDriver(new URL(Config.serverJenkins), capability);
                //		wald = new RemoteWebDriver(new URL(Config.serverJenkins), capability);
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }

        } else if (DriverType.IESauce.toString().equals(driverType)) {

            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            //  capabilities.setCapability("browser", "android");
            capabilities.setCapability("version", "8");
            capabilities.setCapability("platform", "Windows 2003");
            capabilities.setCapability("name", "Win7 IE8 Regression test");

            try {
                this.client = new RemoteWebDriver(
                        new URL("http://gmod77:6e93701d-fb46-4de2-b52d-f504e203647c@ondemand.saucelabs.com:80/wd/hub"),
                        capabilities);
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } else if (DriverType.ChromeSauce.toString().equals(driverType)) {

            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            //  capabilities.setCapability("browser", "android");
            //  capabilities.setCapability("version", "5");
            capabilities.setCapability("platform", "Windows 2003");
            capabilities.setCapability("name", "Win7 Chrome Regression test");

            try {
                this.client = new RemoteWebDriver(
                        new URL("http://gmod77:6e93701d-fb46-4de2-b52d-f504e203647c@ondemand.saucelabs.com:80/wd/hub"),
                        capabilities);
            }
            catch (MalformedURLException e) {
                e.printStackTrace();
            }
            client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }

        else if (DriverType.MacFF14Sauce.toString().equals(driverType))

        {

            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            //  capabilities.setCapability("browser", "android");
            capabilities.setCapability("version", "14");
            capabilities.setCapability("platform", "Mac 10.6");
            capabilities.setCapability("name", "Mac FF14 Regression test");

            try {
                this.client = new RemoteWebDriver(
                        new URL("http://gmod77:6e93701d-fb46-4de2-b52d-f504e203647c@ondemand.saucelabs.com:80/wd/hub"),
                        capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }

        else if (DriverType.MacSafariSauce.toString().equals(driverType))

        {

            DesiredCapabilities capabilities = DesiredCapabilities.safari();
            //  capabilities.setCapability("browser", "android");
            capabilities.setCapability("version", "5");
            capabilities.setCapability("platform", "Mac 10.6");
            capabilities.setCapability("name", "Mac Safari Regression test");

            try {
                this.client = new RemoteWebDriver(
                        new URL("http://gmod77:6e93701d-fb46-4de2-b52d-f504e203647c@ondemand.saucelabs.com:80/wd/hub"),
                        capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        }
        else if (DriverType.Win7FF14Sauce.toString().equals(driverType)) {
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();

            capabilities.setCapability("platform", "Windows 2003");
            capabilities.setCapability("name", "Win7 FireFox Regression test");

            try {
                driver = new RemoteWebDriver(
                        new URL("http://gmod77:6e93701d-fb46-4de2-b52d-f504e203647c@ondemand.saucelabs.com:80/wd/hub"),
                        capabilities);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.setFileDetector(new LocalFileDetector());
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
        else {
            client = new FirefoxDriver();
        }

        this.beforeMethod();
    }


    //declare helpers

    protected UD_HomepageHelper_Client ud_homepageHelper_Client;
    protected UD_HeaderHelper_Client ud_headerHelper_Client;
    protected UD_FooterHelper_Client ud_footerHelper_Client;
    protected UD_SealHelper_Client ud_sealHelper_Client;
    protected UD_SignupHelper_Client ud_signupHelper_Client;
    protected UD_RoundUP_Client ud_roundUP_client;
    protected UD_UnSubscribeHelper_Client ud_unSubscribeHelper_client;

    protected Perks_HomepageHelper_Client perks_homepageHelper_Client;
    protected Perks_HeaderHelper_Client perks_headerHelper_Client;
    protected Perks_FooterHelper_Client perks_footerHelper_Client;
    protected Perks_SealHelper_Client perks_sealHelper_Client;
    protected Perks_SignupHelper_Client perks_signupHelper_Client;

    protected CheckEmailHelper_Client checkEmailHelper_Client;


    //declare variables

    //set unique role names using time stamp
    protected Date now = new java.util.Date();
    protected java.text.DateFormat emailFormat = new java.text.SimpleDateFormat("DDD_HH_mm_SSS");

    protected String emailClient = "udtesterjenkins+"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend1 = "udtesterjenkins+"+"friend_1_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend2 = "udtesterjenkins+"+"friend_2_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend3 = "udtesterjenkins+"+"friend_3_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend4 = "udtesterjenkins+"+"friend_4_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend5 = "udtesterjenkins+"+"friend_5_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend6 = "udtesterjenkins+"+"friend_6_"+emailFormat.format(now) + "@gmail.com";

    protected String emailClient2 = "udtesterjenkins2+"+emailFormat.format(now) + "@gmail.com";
    protected String membersource = "Member Source "+emailFormat.format(now);


    protected String UDdomain = "http://ud-branch.thedaddy.co";
    protected String UD_Admin_domain = "http://ud-branch.thedaddy.co/admin.php";
    protected String Perksdomain = "http://perks-branch.thedaddy.co";
    //	private String UDdomain = "http://www.urbandaddy.com";
    //	private String Perksdomain = "http://perks.urbandaddy.com";
    protected String UDcity = "";
    protected String UDcityPerks = "";
    protected String password="12345";
    //	private String newpassword="1234";
    protected String lastURL = "";

    protected String curDir = System.getProperty("user.dir");

    public String returnImgPath () {
        if (System.getProperty("os.name").contains("Windows")) {
            return curDir + "\\src\\test\\upload_data\\";
        } else {
            return curDir + "/src/test/upload_data/";
        }
    }

    protected String imagePath = returnImgPath();

    /**
     * Pause for 7 seconds
     */
    public void pause1(){
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pause for 20 seconds
     */
    public void pause2(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pause for 3 seconds
     */
    public void pause3(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pause for 1 seconds
     */
    public void pause4(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set your own pause time
     * @param time Time in ms
     */
    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Global Email Check Methods

    /**
     * Log into Gmail and wait
     */
    public void loginToGmail(){
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        //go to gmail and confirm your email address
        this.client.navigate().to("https://mail.google.com/");
        checkEmailHelper_Client.clientLogInToGmail();

        this.pause2();
    }

    /**
     * Check for Welcome to UD email is received
     */
    public void verifyWelcomeUDEmailReceived(){

        checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        checkEmailHelper_Client.findSignupEmail("to: "+emailClient+" subject: Welcome to the Club");
    }

    /**
     * Check that invitation emails were received
     */
    public void verifyInvitationsUDEmailsReceived(){
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        checkEmailHelper_Client.findInvitationEmail1("to: "+emailFriend1+" subject: You're Invited");
        checkEmailHelper_Client.findInvitationEmail2("to: "+emailFriend2+" subject: You're Invited");
        checkEmailHelper_Client.findInvitationEmail3("to: "+emailFriend3+" subject: You're Invited");
        checkEmailHelper_Client.findInvitationEmail4("to: "+emailFriend4+" subject: You're Invited");
        checkEmailHelper_Client.findInvitationEmail5("to: "+emailFriend5+" subject: You're Invited");
    }

    /**
     * Check that the password reset email was received
     */
    public void verifyResetPasswordUDRequestReceivedandPasswordReset(){
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);
        //  resetEmailHelper_Client = new ResetEmailHelper_Client(client);
        //  ud_sealHelper_Client = new UD_SealHelper_Client(client);

        checkEmailHelper_Client.findResetEmailRequest("to: "+emailClient+" subject: UD | Password Reset Request");
        checkEmailHelper_Client.clickResetEmailRequestLink();
        //	resetEmailHelper_Client.enterNewPassword(newpassword);
        //	resetEmailHelper_Client.confirmNewPassword(newpassword);
        //	resetEmailHelper_Client.clickSubmit();
        //	Assert.assertTrue(sealHelper_Client.isSignedIn());
    }

    /**
     * Check that the edit settings email is received
     */
    public void verifyEditSettingsUDEmailReceived(){
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        checkEmailHelper_Client.findInvitationEmail1("to: "+emailClient+" subject: You've Changed");
    }

    /**
     * Check that the edit settings email is received
     *
     * @param email Enter email to search with
     */
    public void verifyEditSettingsUDEmailReceived(String email){
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        checkEmailHelper_Client.findInvitationEmail1("to: "+email+" subject: You've Changed");
    }

    /**
     * Log out of Gmail
     */
    public void logoutGmail() {
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);
        checkEmailHelper_Client.clientLogoutGmail();
    }


    @AfterMethod
    public void afterMainMethod() {
        this.afterMethod();
        client.quit();
    }

    @BeforeClass

// BeforeClass for ChromeDriverService
//	  public  void createAndStartService() {
//	    service = new ChromeDriverService.Builder()
//	        .usingChromeDriverExecutable(new File("src/test/util/chromedriver_mac"))
//	        .usingPort(5556)//.usingAnyFreePort()
//	        .build();
//	    try {
//			service.start();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	    }
//	


    public void beforeMainClass() {
        this.beforeClass();


    }

    @AfterClass
//   for ChromeDriverService	
//	  public static void createAndStopService() {
//	    service.stop();
//	  }


    public void afterMainClass() {
        this.afterClass();
    }

    @BeforeTest
//	  public void createDriver() {
//	    client = new RemoteWebDriver(service.getUrl(),
//	        DesiredCapabilities.chrome());
//	  }

    public void beforeMainTest() {
        this.beforeTest();
    }

    @AfterTest
//  Stop ChromeDriverService
//	  public void quitDriver() {
//	    client.quit();
//	  }

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
