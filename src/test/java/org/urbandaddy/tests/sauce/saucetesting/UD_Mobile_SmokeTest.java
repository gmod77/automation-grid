package org.urbandaddy.tests.sauce.saucetesting;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.helpers.UD_SignupHelper_Client;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.List;

import junit.framework.Assert;

import static org.urbandaddy.com.helpers.HMacHelper.tokenGenerate;

@Listeners({SauceOnDemandTestListener.class})
public class UD_Mobile_SmokeTest implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider, UDBase {

    public SauceOnDemandAuthentication authentication;

    protected WebDriver client;

    String date;
    String emailClient;
    String[] friend;

    public UD_Mobile_SmokeTest() {
//        emailHelper_Client = new EmailHelper_Client(client);

        friend = new String[5];
//        date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
//        emailClient = emailHelper_Client.generateEmailClient(date);
//        friend = emailHelper_Client.generateFriendClient(5,date);
    }


    @Parameters({"username", "key", "os", "browser", "version"})
    @BeforeMethod
    public void setUp(@Optional("") String username,
                      @Optional("") String key,
                      @Optional("") String os,
                      @Optional("") String browser,
                      @Optional("") String version,
                      Method method) throws Exception {

//        System.out.println("\nSTARTING METHOD: " + method.getName() + "\n");
//        System.out.println("browser HERE> " + browser);
//        System.out.println("version HERE> " + version);
//        System.out.println("os HERE> " + Platform.extractFromSysProperty(os));
//
//        System.out.println("env SELENIUM_BROWSER> " + System.getenv("SELENIUM_BROWSER"));
//        System.out.println("env SELENIUM_VERSION> " + System.getenv("SELENIUM_VERSION"));
//        System.out.println("env SELENIUM_PLATFORM> " + System.getenv("SELENIUM_PLATFORM"));
//        System.out.println("env SELENIUM_DRIVER> " + System.getenv("SELENIUM_DRIVER"));
//        System.out.println("env SELENIUM_STARTING_URL> " + System.getenv("SELENIUM_STARTING_URL"));
//
//        System.out.println("prop SELENIUM_BROWSER> " + System.getProperty("SELENIUM_BROWSER"));
//        System.out.println("prop SELENIUM_VERSION> " + System.getProperty("SELENIUM_VERSION"));
//        System.out.println("prop SELENIUM_PLATFORM> " + System.getProperty("SELENIUM_PLATFORM"));
//        System.out.println("prop SELENIUM_DRIVER> " + System.getProperty("SELENIUM_DRIVER"));

        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(key)) {
            authentication = new SauceOnDemandAuthentication(username, key);
        } else {
            authentication = new SauceOnDemandAuthentication();
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        // The below is for axis tests. The listener works find for single one shot tests.
        String browserProp = System.getProperty("SELENIUM_BROWSER");
        String versionProp = System.getProperty("SELENIUM_VERSION");
        String platformProp = System.getProperty("SELENIUM_PLATFORM");
        //&& StringUtils.isNotBlank(versionProp)
        if (StringUtils.isNotBlank(browserProp) && StringUtils.isNotBlank(platformProp)) {
            capabilities.setBrowserName(browserProp);
            capabilities.setCapability("version", versionProp);
            capabilities.setCapability("platform", Platform.extractFromSysProperty(platformProp));
            capabilities.setCapability("tags","Axis_Test");
            System.out.println("AXIS TEST");
        //&& StringUtils.isNotBlank(version)
        } else if (StringUtils.isNotBlank(browser) && StringUtils.isNotBlank(os)) {
            capabilities.setBrowserName(browser);
            capabilities.setCapability("version", version);
            capabilities.setCapability("platform", Platform.extractFromSysProperty(os));
            capabilities.setCapability("tags","Single_Test");
            System.out.println("SINGLE/NON-AXIS TEST");

        } else {
            capabilities = DesiredCapabilities.firefox();
            System.out.println("Failed to pass caps from Jenkins");
        }

        capabilities.setCapability("name", "Test Method: " + method.getName());
        this.client = new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        ((RemoteWebDriver) client).setFileDetector(new LocalFileDetector());
        Reporter.log(method.getName() + " SauceResultsUrl> " + getResultsUrl(getSessionId()),true);
        Reporter.log(String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", getSessionId(), method.getName()));
    }


    /**
     * Grab the sessionid
     *
     * @return sessionId to string
     */
    @Override
    public String getSessionId() {
        SessionId sessionId = ((RemoteWebDriver) client).getSessionId();
        return (sessionId == null) ? null : sessionId.toString();
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown(ITestResult result) throws Exception {
        System.out.println("METHOD END " + result.getMethod().getMethodName());
        client.quit();
    }

    @Test
    public void ud_mobile_smoke_1() {

//        ud_signupHelper_Client = new UD_SignupHelper_Client(client);


        String email;
        email = emailClient;
        String var;
        var = date;
        
        //
        
      //start afresh
		client.manage().deleteAllCookies();
		
		//assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[2]/a")));
		//Assert.assertTrue(login(resource, emailResource));
		
		// go to homepage
		client.get(UD_DOMAIN);
		
//click Chicago
		client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[2]/a")).click();
		
		//search for Jellyfish restaurant in Chicago
		
		//enter search text
		client.findElement(By.id("query")).sendKeys("Jellyfish");
		//click go
		client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

		
		//verify displayed results
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
		
		// use back button to go back to the citi's featured article 
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();

		
		//use the City icon on the upper-right corner to navigate to the main page
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();

		
//click Las Vegas
		client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[3]/a")).click();

		
		//search for Allegro restaurant in Las Vegas
		
		//enter search text
		client.findElement(By.id("query")).sendKeys("Allegro");
		//click go
		client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

				
		//verify displayed results
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
				
		// use back button to go back to the citi's featured article 
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();

				
		//use the City icon on the upper-right corner to navigate to the main page
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();
			
//click Los Angeles
		client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[4]/a")).click();

		
		//search for Nobu Malibu restaurant in LA
		
		//enter search text
		client.findElement(By.id("query")).sendKeys("Nobu Malibu");
		//click go
		client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

				
		//verify displayed results
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
				
		// use back button to go back to the citi's featured article 
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();

				
		//use the City icon on the upper-right corner to navigate to the main page
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();
		
		
//click Miami
		client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[5]/a")).click();

		
		//search for Doma Polo Bistro restaurant in Miami
		
		//enter search text
		client.findElement(By.id("query")).sendKeys("Doma Polo Bistro");
		//click go
		client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

						
		//verify displayed results
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
						
		// use back button to go back to the citi's featured article 
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();

						
		//use the City icon on the upper-right corner to navigate to the main page
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();

//click NYC
		client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[6]/a")).click();
		//search for Tomoka restaurant in NYC
		
		//enter search text
		client.findElement(By.id("query")).sendKeys("Tomoka");
		//click go
		client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

								
		//verify displayed results
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
								
		// use back button to go back to the citi's featured article 
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();

								
		//use the City icon on the upper-right corner to navigate to the main page
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();
		

		
//click San Fran
		client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[7]/a")).click();
		
		//search for The Corner Store restaurant in SF
		
		//enter search text
		client.findElement(By.id("query")).sendKeys("The Corner Store");
		//click go
		client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

								
		//verify displayed results
		Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
								
		// use back button to go back to the citi's featured article 
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();

								
		//use the City icon on the upper-right corner to navigate to the main page
		client.findElement(By.xpath("//html/body/div/div/a/img")).click();
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
//    protected UD_SignupHelper_Client ud_signupHelper_Client;
//    protected EmailHelper_Client emailHelper_Client;

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
     * @throws java.io.IOException
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

//    private boolean StaleElementHandleByXpath (String email){
//        ud_signupHelper_Client = new UD_SignupHelper_Client(client);
//        int count = 0;
//        boolean flag = false;
//        do {
//            try {
//                ud_signupHelper_Client.enterEmail(email);
//                count++;
//                flag = true;
//            } catch (StaleElementReferenceException e) {
//                e.toString();
//                System.out.println("Trying to recover from a stale element: " + e.getMessage());
//            }
//        } while (count < 4 && !flag);
//        if (count >= 4) {
//            return false;
//        } else {
//            return true;
//        }
//    }

}
