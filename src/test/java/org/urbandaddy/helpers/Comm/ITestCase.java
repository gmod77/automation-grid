package org.urbandaddy.helpers.Comm;

import junit.framework.TestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.urbandaddy.helpers.*;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class ITestCase extends TestCase {

    enum DriverType {
        SauceRunner, Firefox, IE, Ghrome, Win7FF14Remote, Win7IE9Remote, IESauce, ChromeSauce, Win7FF14Sauce, MacFF14Sauce, MacSafariSauce
    }


    protected RemoteWebDriver client;

    @Parameters({ "driverType", "profilePath", "sauceEnabled","sauceUser","sauceKey" })
    @BeforeMethod

    public void beforeMainMethod(String driverType, String profilePath, @Optional("false") Boolean sauceEnabled, @Optional String sauceUser, @Optional String sauceKey) throws InterruptedException {


        if (sauceEnabled) {

            String sauceUrl = "http://" + sauceUser + ":" + sauceKey + "@ondemand.saucelabs.com:80/wd/hub";

            if (DriverType.IESauce.toString().equals(driverType)) {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability("version", "8");
                capabilities.setCapability("platform", "Windows 2003");

                try {
                    this.client = new RemoteWebDriver(
                            new URL(sauceUrl),
                            capabilities);
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                this.client.setFileDetector(new LocalFileDetector());
                client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            } else if (DriverType.ChromeSauce.toString().equals(driverType)) {

                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability("platform", "Windows 2003");

                try {
                    this.client = new RemoteWebDriver(
                            new URL(sauceUrl),
                            capabilities);
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                this.client.setFileDetector(new LocalFileDetector());
                client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            } else if (DriverType.MacFF14Sauce.toString().equals(driverType)) {

                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                capabilities.setCapability("platform", "Mac 10.6");

                try {
                    this.client = new RemoteWebDriver(
                            new URL(sauceUrl),
                            capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                this.client.setFileDetector(new LocalFileDetector());
                client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            } else if (DriverType.MacSafariSauce.toString().equals(driverType)) {

                DesiredCapabilities capabilities = DesiredCapabilities.safari();
                capabilities.setCapability("platform", "Mac 10.6");

                try {
                    this.client = new RemoteWebDriver(
                            new URL(sauceUrl),
                            capabilities);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                this.client.setFileDetector(new LocalFileDetector());
                client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            } else if (DriverType.Win7FF14Sauce.toString().equals(driverType)) {

                DesiredCapabilities capabilities = DesiredCapabilities.firefox();

                capabilities.setCapability("platform", "Windows 2003");
                capabilities.setCapability("name",getClass().getName());
                capabilities.setCapability("command-timeout", 60); //one minute per step
                capabilities.setCapability("max-duration", 1200);  //twenty minutes per test
                capabilities.setCapability("disable-popup-handler", false);
                try {
                    this.client = new RemoteWebDriver(
                            new URL(sauceUrl),
                            capabilities);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                this.client.setFileDetector(new LocalFileDetector());
                client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            } else if (DriverType.SauceRunner.toString().equals(driverType)) {

                client.setFileDetector(new LocalFileDetector());
                client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            }
        } else {

            String remoteUrl = "http://jenkins-master.thedaddy.co:4444/wd/hub";

            if (DriverType.Firefox.toString().equals(driverType)) {

                if (profilePath == null || profilePath.isEmpty()) {
                    client = new FirefoxDriver();
                    client.manage().window().maximize();

                } else {
                    File file = new File(profilePath);
                    FirefoxProfile profile = new FirefoxProfile(file);
                    client = new FirefoxDriver(profile);
                    client.manage().window().maximize();
                }

            } else if (DriverType.IE.toString().equals(driverType)) {
                client = new InternetExplorerDriver();

            } else if (DriverType.Ghrome.toString().equals(driverType)) {
                client = new ChromeDriver();

            } else if (DriverType.Win7FF14Remote.toString().equals(driverType)) {
                DesiredCapabilities capability = DesiredCapabilities.firefox();
                capability.setCapability("seleniumProtocol", "WebDriver");
                capability.setCapability("jenkins.nodeName", "WindowsSlave2");
                capability.setCapability("javascriptEnabled ", true);
                capability.setVersion("14");

                try {
                    client = new RemoteWebDriver(new URL(remoteUrl), capability);
                    client.manage().window().maximize();
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                this.client.setFileDetector(new LocalFileDetector());

            } else if (DriverType.Win7IE9Remote.toString().equals(driverType)) {
                DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
                capability.setCapability("seleniumProtocol", "WebDriver");
                capability.setCapability("jenkins.nodeName", "WindowsSlave2");

                try {
                    client = new RemoteWebDriver(new URL(remoteUrl), capability);
                    client.manage().window().maximize();
                }
                catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                this.client.setFileDetector(new LocalFileDetector());

            } else {
                client = new FirefoxDriver();
            }
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


    /**
     * Based on the OS name get the directory where
     * we use images
     * @return path to image dir
     */
    public String returnImgPath () {
        return curDir + "/src/test/upload_data/";
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
        //client.get("https://mail.google.com/");
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
        String link = checkEmailHelper_Client.getResetEmailLink();
        //client.get(link);
        System.out.println(link);
        //  checkEmailHelper_Client.clickResetEmailRequestLink();
//        	resetEmailHelper_Client.enterNewPassword(newpassword);
//        	resetEmailHelper_Client.confirmNewPassword(newpassword);
//        	resetEmailHelper_Client.clickSubmit();
//        	Assert.assertTrue(sealHelper_Client.isSignedIn());
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

        checkEmailHelper_Client.findInvitationEmail1("to: " + email + " subject: You've Changed");
    }

    /**
     * Log out of Gmail
     */
    public void logoutGmail() {
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);
        checkEmailHelper_Client.clientLogoutGmail();
    }

    /**
     * Use the checkForBy method to extend some functionality to searching for
     * elements. Attempts to find the element 3 times before throwing an error.
     *
     * @param type  Search by name, xpath, tagname, classname, css, id
     * @param check Enter the name of the element you're looking for
     * @param timeout Enter the number of seconds for the timeout
     * @return that web element or throw an error
     */
    public WebElement findElement(final String type, String check, int timeout){
        int counter = 0;
        boolean flag = false;
        final String ele;
        ele = check;
        WebElement a = null;


        do {
            try {
                System.out.println("Trying to find the element> " + ele + "\nTimeout in> " + timeout + " seconds.");
                a = (new WebDriverWait(client, timeout)).until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(@Nullable WebDriver d) {
                        WebElement ret = null;
                        if (type.equals("name")) {
                            ret = d.findElement(By.name(ele));
                        } else if (type.equals("xpath")) {
                            ret = d.findElement(By.xpath(ele));
                        } else if (type.equals("tagname")) {
                            ret = d.findElement(By.tagName(ele));
                        } else if (type.equals("classname")) {
                            ret = d.findElement(By.className(ele));
                        } else if (type.equals("css")) {
                            ret = d.findElement(By.cssSelector(ele));
                        } else if (type.equals("id")) {
                            ret = d.findElement(By.id(ele));
                        }
                        System.out.println("Found> " + ele);
                        return ret;
                    }
                });
                flag = true;
            } catch (TimeoutException e) {
                counter++;
                System.out.println("Attempt " + counter + ": Could not find> " + ele);
                System.out.println("Trying again");
            }
        } while (counter <= 2 && !flag);
        if (a == null) {
            throw new NullPointerException("3rd Attempt reached. Could not find> " + ele);
        } else {
        return a;
        }
    }

    /**
     * Select an item from a dropdown.
     *
     * @param dropDownId Provide the ID of the dropdown element
     * @param dropDownTagName Provide name of the tag associated to the dropdown (ex. 'option')
     * @param text Name of the object to select from the dropdown
     */
    public void selectFromDropdown (String dropDownId, String dropDownTagName, String text) {
        WebElement element = client.findElement(By.id(dropDownId));
        List<WebElement> elements = element.findElements(By.tagName(dropDownTagName));
        for(WebElement option : elements){
            if(option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

    /**
     * Select an item from a dropdown. Uses WebElement to find
     * the dropdown. Works great with the checkForBy() method.
     *
     * @param element Webelement returned from checkForBy()
     * @param dropDownTagName Provide name of the tag associated to the dropdown (ex. 'option')
     * @param text Name of the object to select from the dropdown
     */
    public void selectFromDropdown (WebElement element, String dropDownTagName, String text) {
        List<WebElement> elements = element.findElements(By.tagName(dropDownTagName));
        for(WebElement option : elements){
            if(option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

    private URL getFileURL(String username, String session, String fileName) throws MalformedURLException {
        // userinfo in URL doesn't result in the BASIC auth, so in this method we won't set the credential.
        return new URL(MessageFormat.format("https://saucelabs.com/rest/{0}/jobs/{1}/results/{2}",
                username, session, fileName));
    }


    @AfterMethod (alwaysRun = true)
    @Parameters ({"sauceEnabled", "sauceUser", "sauceKey"})
    public void afterMainMethod(ITestResult result, Boolean sauceEnabled, String sauceUser, String sauceKey) throws IOException {
        this.afterMethod();
        // Sauce Stuff here
        if(sauceEnabled) {
            String sauceJobID = client.getSessionId().toString();
            /**
            SauceREST sauceClient = new SauceREST(sauceUser,sauceKey);
            Map<String, Object> sauceJob = new HashMap<String, Object>();
            sauceJob.put("name", "Test method: " + result.getMethod().getMethodName());
            if(result.isSuccess()) {
                sauceClient.jobPassed(sauceJobID);

            } else {
                sauceClient.jobFailed(sauceJobID);
            }
            sauceClient.updateJobInfo(sauceJobID, sauceJob);
            **/

            String sauceUrl = "http://saucelabs.com/rest/" + sauceUser + "/jobs/" + sauceJobID + "/results/";

            System.out.println(sauceUrl + "video.flv");
            System.out.println(sauceUrl + "selenium-server.log");

        }
        client.manage().deleteAllCookies();
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
//    public void getSomeTestData(IResultMap context) {
//        Set<ITestResult> results = context.getAllResults();
//        Iterator it = results.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//        this.afterTest();
//    }
//    public void afterMainTest() {
//        this.afterTest();
//    }

    @AfterSuite


    public abstract void beforeMethod();

    public abstract void afterMethod();

    public abstract void beforeClass();

    public abstract void afterClass();

    public abstract void beforeTest();

    public abstract void afterTest();
}
