package org.urbandaddy.com.sauce;


import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.com.helpers.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Date;

import static org.urbandaddy.com.helpers.HMacHelper.tokenGenerate;

@Listeners({SauceOnDemandTestListener.class})
public class iSauceBase implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider, UDBase {

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

        System.out.println("\nSTARTING METHOD: " + method.getName() + "\n");
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

        } else if (browser.equals("chrome") && StringUtils.isBlank(browserVersion) && StringUtils.isNotBlank(os)){
            capabilities = DesiredCapabilities.chrome(); // Sauce doesn't want us to pass a browser version with chrome
        } else {
            capabilities = DesiredCapabilities.firefox();
        }
        capabilities.setCapability("name", "Test Method: " + method.getName());
        this.client = new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        this.client.setFileDetector(new LocalFileDetector());
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
        Reporter.log("SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
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

    //declare helpers and other common variables

    public String generateEmailClient (String e) {
        return "udtesterjenkins+"+emailFormat.format(now) + "@gmail.com";
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

    protected EmailHelper_Client emailHelper_Client;


    Date now = new java.util.Date();
    java.text.DateFormat emailFormat = new java.text.SimpleDateFormat("DDD_HH_mm_SSS");

    protected String emailClient = "udtesterjenkins+"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend1 = "udtesterjenkins+"+"friend_1_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend2 = "udtesterjenkins+"+"friend_2_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend3 = "udtesterjenkins+"+"friend_3_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend4 = "udtesterjenkins+"+"friend_4_"+emailFormat.format(now) + "@gmail.com";
    protected String emailFriend5 = "udtesterjenkins+"+"friend_5_"+emailFormat.format(now) + "@gmail.com";

    protected String MEMBER_SOURCE = "Member Source "+emailFormat.format(now);

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

    private String generateToken(String jobId) throws IOException {
        String message = authentication.getUsername() + ":" + authentication.getAccessKey();
        try {
            return tokenGenerate(message, jobId);
        } catch (Exception e) {
            throw new IOException("Token Generation Failed");
        }
        //System.out.println("https://saucelabs.com/jobs/" + jobId +"?auth=" + token);
    }

    private String getResultsUrl(String jobId) throws IOException {
        String PUBLICURL = "https://saucelabs.com/jobs/%1$s";
        String JOB_ID_FORMAT = PUBLICURL + "?auth=%2$s";
        String token = generateToken(jobId);
        return String.format(JOB_ID_FORMAT, jobId, token);
    }


}
