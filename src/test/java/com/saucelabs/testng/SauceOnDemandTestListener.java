package com.saucelabs.testng;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.saucerest.SauceREST;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

/**
 *
 * Test Listener that providers helper logic for TestNG tests.  Upon startup, the class
 * will store any SELENIUM_* environment variables (typically set by a Sauce OnDemand CI
 * plugin) as system parameters, so that they can be retrieved by tests as parameters.
 *
 * TODO how to specify whether to download log/video?
 *
 * @author Ross Rowe
 */
public class SauceOnDemandTestListener extends TestListenerAdapter {

    private static final String SELENIUM_BROWSER = "SELENIUM_BROWSER";
    private static final String SELENIUM_PLATFORM = "SELENIUM_PLATFORM";
    private static final String SELENIUM_VERSION = "SELENIUM_VERSION";
    private static final String SELENIUM_DRIVER = "SELENIUM_DRIVER";

    /**
     * The underlying {@link com.saucelabs.common.SauceOnDemandSessionIdProvider} instance which contains the Selenium session id.  This is typically
     * the unit test being executed.
     */
    private SauceOnDemandSessionIdProvider sessionIdProvider;

    /**
     * The instance of the Sauce OnDemand Java REST API client.
     */
    private SauceREST sauceREST;

    /**
     * Check to see if environment variables that define the Selenium browser to be used have been set (typically by
     * a Sauce OnDemand CI plugin).  If so, then populate the appropriate system parameter, so that tests can use
     * these values.
     * @param testContext
     */
    @Override
    public void onStart(ITestContext testContext) {
        super.onStart(testContext);
        String browser = System.getenv(SELENIUM_BROWSER);
        if (browser != null && !browser.equals(""))  {
            System.setProperty("browser", browser);
        }
        String platform = System.getenv(SELENIUM_PLATFORM);
        if (platform != null && !platform.equals(""))  {
            System.setProperty("os", platform);
        }
        String browserVersion = System.getenv(SELENIUM_VERSION);
        if (browserVersion != null && !browserVersion.equals(""))  {
            System.setProperty("browserVersion", browserVersion);
        }
        String selDriver = System.getenv(SELENIUM_DRIVER);
        if (selDriver != null && !selDriver.equals("")) {
            System.setProperty("seleniumDriver", selDriver);
        }
    }

    /**
     * @param result
     */
    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);

        if (result.getInstance() instanceof SauceOnDemandSessionIdProvider) {
            this.sessionIdProvider = (SauceOnDemandSessionIdProvider) result.getInstance();
            //log the session id to the system out
            if (sessionIdProvider.getSessionId() != null) {
                System.out.println(String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", sessionIdProvider.getSessionId(), result.getMethod().getMethodName()));
            }
        }
        SauceOnDemandAuthentication sauceOnDemandAuthentication;
        if (result.getInstance() instanceof SauceOnDemandAuthenticationProvider) {
            //use the authentication information provided by the test class
            SauceOnDemandAuthenticationProvider provider = (SauceOnDemandAuthenticationProvider) result.getInstance();
            sauceOnDemandAuthentication = provider.getAuthentication();
        } else {
            //otherwise use the default authentication
            sauceOnDemandAuthentication = new SauceOnDemandAuthentication();
        }
        this.sauceREST = new SauceREST(sauceOnDemandAuthentication.getUsername(), sauceOnDemandAuthentication.getAccessKey());
    }

    /**
     * @param tr
     */
    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        markJobAsFailed();
    }

    private void markJobAsFailed() {
        try {
            if (this.sauceREST != null && sessionIdProvider != null) {
                String sessionId = sessionIdProvider.getSessionId();
                if (sessionId != null) {
                    sauceREST.jobFailed(sessionId);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException(ioe);
        }
    }

    /**
     * @param tr
     */
    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        markJobAsPassed();
    }

    private void markJobAsPassed() {
        try {
            if (this.sauceREST != null && sessionIdProvider != null) {
                String sessionId = sessionIdProvider.getSessionId();
                if (sessionId != null) {
                    sauceREST.jobPassed(sessionIdProvider.getSessionId());
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            throw new RuntimeException(ioe);
        }
    }

}
