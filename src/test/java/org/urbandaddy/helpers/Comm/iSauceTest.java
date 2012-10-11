package org.urbandaddy.helpers.Comm;


import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.urbandaddy.helpers.*;

import javax.annotation.Nullable;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

@Listeners({SauceOnDemandTestListener.class})
public class iSauceTest implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider {

    public SauceOnDemandAuthentication authentication;

    protected RemoteWebDriver client;

    /**
     * If the tests can rely on the username/key to be supplied by environment variables or the existence
     * of a ~/.sauce-ondemand file, then we don't need to specify them as parameters, just create a new instance
     * of {@link SauceOnDemandAuthentication} using the no-arg constructor.
     *
     * @param username
     * @param key
     * @param os
     * @param browser
     * @param browserVersion
     * @param method
     * @throws Exception
     */
    @Parameters({"username", "key", "os", "browser", "browserVersion"})
    @BeforeMethod
    public void setUp(@Optional("") String username,
                      @Optional("") String key,
                      @Optional("") String os,
                      @Optional("") String browser,
                      @Optional("") String browserVersion,
                      Method method) throws Exception {

        System.out.println("HERE> " + browser);
        System.out.println("HERE> " + browserVersion);
        System.out.println("HERE> " + Platform.extractFromSysProperty(os));

        System.out.println("HERE2> " + System.getenv("SELENIUM_BROWSER"));
        System.out.println("HERE2> " + System.getenv("SELENIUM_VERSION"));
        System.out.println("HERE2> " + System.getenv("SELENIUM_PLATFORM"));
        System.out.println("HERE2> " + System.getenv("SELENIUM_DRIVER"));

        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(key)) {
            authentication = new SauceOnDemandAuthentication(username, key);
        } else {
            authentication = new SauceOnDemandAuthentication();
        }

        DesiredCapabilities capabillities = new DesiredCapabilities();
        if (StringUtils.isNotBlank(browser) && StringUtils.isNotBlank(browserVersion) && StringUtils.isNotBlank(os)) {
            capabillities.setBrowserName(browser);
            capabillities.setCapability("version", browserVersion);
            capabillities.setCapability("platform", Platform.extractFromSysProperty(os));

        } else {
            capabillities = DesiredCapabilities.firefox();
        }
        capabillities.setCapability("name", method.getName());
        this.client = new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
                capabillities);

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

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public String getSessionId() {
        SessionId sessionId = ((RemoteWebDriver) client).getSessionId();
        return (sessionId == null) ? null : sessionId.toString();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        client.quit();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public SauceOnDemandAuthentication getAuthentication() {
        return authentication;
    }
}
