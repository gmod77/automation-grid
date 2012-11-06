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
import org.urbandaddy.com.common.RetryTestListener;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.com.helpers.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

import static org.urbandaddy.com.helpers.HMacHelper.tokenGenerate;

@Listeners({SauceOnDemandTestListener.class, RetryTestListener.class})
public class iSauceBase implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider, UDBase {

    public SauceOnDemandAuthentication authentication;

    protected RemoteWebDriver client;

    /**
     * If the tests can rely on the username/key to be supplied by environment variables or the existence
     * of a ~/.sauce-ondemand file, then we don't need to specify them as parameters, just create a new instance
     * of {@link SauceOnDemandAuthentication} using the no-arg constructor.
     *
     * @param username Sauce Labs User Name
     * @param key Sauce Labs User Key
     * @param os Requested Operating System
     * @param browser Requested Browser Type
     * @param version Requested Browser Version
     * @param method Test Method
     * @throws Exception
     */
    @Parameters({"username", "key", "os", "browser", "version"})
    @BeforeMethod
    public void setUp(@Optional("") String username,
                      @Optional("") String key,
                      @Optional("") String os,
                      @Optional("") String browser,
                      @Optional("") String version,
                      Method method) throws Exception {

        System.out.println("\nSTARTING METHOD: " + method.getName() + "\n");
        System.out.println("browser HERE> " + browser);
        System.out.println("version HERE> " + version);
        System.out.println("os HERE> " + Platform.extractFromSysProperty(os));

        System.out.println("env SELENIUM_BROWSER> " + System.getenv("SELENIUM_BROWSER"));
        System.out.println("env SELENIUM_VERSION> " + System.getenv("SELENIUM_VERSION"));
        System.out.println("env SELENIUM_PLATFORM> " + System.getenv("SELENIUM_PLATFORM"));
        System.out.println("env SELENIUM_DRIVER> " + System.getenv("SELENIUM_DRIVER"));
        System.out.println("env SELENIUM_STARTING_URL> " + System.getenv("SELENIUM_STARTING_URL"));

        System.out.println("prop SELENIUM_BROWSER> " + System.getProperty("SELENIUM_BROWSER"));
        System.out.println("prop SELENIUM_VERSION> " + System.getProperty("SELENIUM_VERSION"));
        System.out.println("prop SELENIUM_PLATFORM> " + System.getProperty("SELENIUM_PLATFORM"));
        System.out.println("prop SELENIUM_DRIVER> " + System.getProperty("SELENIUM_DRIVER"));


        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(key)) {
            authentication = new SauceOnDemandAuthentication(username, key);
        } else {
            authentication = new SauceOnDemandAuthentication();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (System.getProperty("SELENIUM_BROWSER") != null ){
                capabilities.setBrowserName(System.getProperty("SELENIUM_BROWSER"));
                capabilities.setCapability("version", System.getProperty("SELENIUM_VERSION"));
                capabilities.setCapability("platform", Platform.extractFromSysProperty(System.getProperty("SELENIUM_PLATFORM")));
                capabilities.setCapability("tags", "Axis_Test");

        } else if (browser.equals("chrome") && StringUtils.isBlank(version) && StringUtils.isNotBlank(os)){
            capabilities = DesiredCapabilities.chrome(); // Sauce doesn't want us to pass a browser version with chrome

        // The below is for axis tests. The listener works find for single one shot tests.
        } else if (StringUtils.isNotBlank(browser) && StringUtils.isNotBlank(version) && StringUtils.isNotBlank(os)) {
                capabilities.setBrowserName(browser);
                capabilities.setCapability("version", version);
                capabilities.setCapability("platform", Platform.extractFromSysProperty(os));
                capabilities.setCapability("tags","Single_Test");
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
        Reporter.log(result.getMethod().getMethodName() + " SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
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

    //Declare helpers
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

    /**
     * Generates the token used for creating the public Sauce Labs
     * results URL
     * @param jobId The job ID generated from Sauce Labs
     * @return token
     * @throws IOException
     */
    private String generateToken(String jobId) throws IOException {
        String message = authentication.getUsername() + ":" + authentication.getAccessKey();
        try {
            return tokenGenerate(message, jobId);
        } catch (Exception e) {
            throw new IOException("Token Generation Failed");
        }
        //System.out.println("https://saucelabs.com/jobs/" + jobId +"?auth=" + token);
    }

    /**
     * Creates the link to the Sauce Labs results
     *
     * @param jobId The job ID generated from Sauce Labs
     * @return URL
     * @throws IOException
     */
    private String getResultsUrl(String jobId) throws IOException {
        String PUBLICURL = "https://saucelabs.com/jobs/%1$s";
        String JOB_ID_FORMAT = PUBLICURL + "?auth=%2$s";
        String token = generateToken(jobId);
        return String.format(JOB_ID_FORMAT, jobId, token);
    }


}
