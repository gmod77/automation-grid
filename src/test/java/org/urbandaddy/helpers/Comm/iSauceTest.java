package org.urbandaddy.helpers.Comm;


import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.urbandaddy.helpers.*;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;

@Listeners({SauceOnDemandTestListener.class})
public class iSauceTest implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider, UDBase {

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
    @Parameters({"username", "key", "os", "browser", "browserVersion","selDriver"})
    @BeforeMethod
    public void setUp(@Optional("") String username,
                      @Optional("") String key,
                      @Optional("") String os,
                      @Optional("") String browser,
                      @Optional("") String browserVersion,
                      @Optional("") String selDriver,
                      Method method) throws Exception {

        System.out.println("browser HERE> " + browser);
        System.out.println("browserVersion HERE> " + browserVersion);
        System.out.println("os HERE> " + Platform.extractFromSysProperty(os));
        System.out.println("selDriver HERE> " + selDriver);

        System.out.println("SELENIUM_BROWSER> " + System.getenv("SELENIUM_BROWSER"));
        System.out.println("SELENIUM_VERSION> " + System.getenv("SELENIUM_VERSION"));
        System.out.println("SELENIUM_PLATFORM> " + System.getenv("SELENIUM_PLATFORM"));
        System.out.println("getenv SELENIUM_DRIVER> " + System.getenv("SELENIUM_DRIVER"));
        System.out.println("getProperty SELENIUM_DRIVER> " + System.getProperty("SELENIUM_DRIVER"));
        System.out.println("SELENIUM_STARTING_URL> " + System.getenv("SELENIUM_STARTING_URL"));

        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(key)) {
            authentication = new SauceOnDemandAuthentication(username, key);
        } else {
            authentication = new SauceOnDemandAuthentication();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (StringUtils.isNotBlank(browser) && StringUtils.isNotBlank(browserVersion) && StringUtils.isNotBlank(os)) {
            capabilities.setBrowserName(browser);
            capabilities.setCapability("version", browserVersion);
            capabilities.setCapability("platform", Platform.extractFromSysProperty(os));

        } else {
            capabilities = DesiredCapabilities.firefox();
        }
        capabilities.setCapability("name", "Test Method: " + method.getName());
        this.client = new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        this.client.setFileDetector(new LocalFileDetector());
        System.out.println("\nSTARTING METHOD: " + method.getName() + "\n");
    }

    //declare helpers

    public String generateEmailClient (String e) {
        return "udtesterjenkins+"+EMAIL_FORMAT.format(NOW) + "@gmail.com";
    }

    protected UD_HomepageHelper_Client ud_homepageHelper_Client;
    protected UD_HeaderHelper_Client ud_headerHelper_Client;
    protected UD_FooterHelper_Client ud_footerHelper_Client;
    protected UD_SealHelper_Client ud_sealHelper_Client;
    protected UD_SignupHelper_Client ud_signupHelper_Client;
    protected UD_RoundUP_Client ud_roundUP_client;
    protected UD_UnSubscribeHelper_Client ud_unSubscribeHelper_client;
    protected IHelper_Client iHelper_client;



    protected Perks_HomepageHelper_Client perks_homepageHelper_Client;
    protected Perks_HeaderHelper_Client perks_headerHelper_Client;
    protected Perks_FooterHelper_Client perks_footerHelper_Client;
    protected Perks_SealHelper_Client perks_sealHelper_Client;
    protected Perks_SignupHelper_Client perks_signupHelper_Client;

    protected CheckEmailHelper_Client checkEmailHelper_Client;


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

        this.pause(20000);
    }

    /**
     * Check for Welcome to UD email is received
     */
    public void verifyWelcomeUDEmailReceived(){

        checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        checkEmailHelper_Client.findSignupEmail("to: "+EMAIL_CLIENT+" subject: Welcome to the Club");
    }

    /**
     * Check that invitation emails were received
     */
    public void verifyInvitationsUDEmailsReceived(){
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        checkEmailHelper_Client.findInvitationEmail1("to: "+EMAIL_FRIEND1+" subject: You're Invited");
        checkEmailHelper_Client.findInvitationEmail2("to: "+EMAIL_FRIEND2+" subject: You're Invited");
        checkEmailHelper_Client.findInvitationEmail3("to: "+EMAIL_FRIEND3+" subject: You're Invited");
        checkEmailHelper_Client.findInvitationEmail4("to: "+EMAIL_FRIEND4+" subject: You're Invited");
        checkEmailHelper_Client.findInvitationEmail5("to: "+EMAIL_FRIEND5+" subject: You're Invited");
    }

    /**
     * Check that the password reset email was received
     */
    public void verifyResetPasswordUDRequestReceivedandPasswordReset(){
        checkEmailHelper_Client = new CheckEmailHelper_Client(client);
        //  resetEmailHelper_Client = new ResetEmailHelper_Client(client);
        //  ud_sealHelper_Client = new UD_SealHelper_Client(client);

        checkEmailHelper_Client.findResetEmailRequest("to: "+EMAIL_CLIENT+" subject: UD | Password Reset Request");
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

        checkEmailHelper_Client.findInvitationEmail1("to: "+EMAIL_CLIENT+" subject: You've Changed");
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
     * Select an item from a dropdown.
     *
     * @param dropDownId Provide the ID of the dropdown element
     * @param dropDownTagName Provide name of the tag associated to the dropdown (ex. 'option')
     * @param text Name of the object to select from the dropdown
     */
    public void selectFromDropdown(String dropDownId, String dropDownTagName, String text) {
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
     * the dropdown. Works great with the findElementAndCheckBy() method.
     *
     * @param element Webelement returned from findElementAndCheckBy()
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

    /**
     * Grab the sessionid
     *
     * @return sessionId to string
     */
    @Override
    public String getSessionId() {
        SessionId sessionId = (client).getSessionId();
        return (sessionId == null) ? null : sessionId.toString();
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
        System.out.println("METHOD END\n");
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
