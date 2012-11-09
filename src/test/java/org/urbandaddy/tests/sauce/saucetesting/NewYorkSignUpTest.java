package org.urbandaddy.tests.sauce.saucetesting;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.testng.SauceOnDemandAuthenticationProvider;
import com.saucelabs.testng.SauceOnDemandTestListener;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
public class NewYorkSignUpTest implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider, UDBase {

    public SauceOnDemandAuthentication authentication;

    protected WebDriver client;

    String date;
    String emailClient;
    String[] friend;

    public NewYorkSignUpTest() {
        emailHelper_Client = new EmailHelper_Client(client);

        friend = new String[5];
        date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        emailClient = emailHelper_Client.generateEmailClient(date);
        friend = emailHelper_Client.generateFriendClient(5,date);
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

        if (StringUtils.isNotBlank(browserProp) && StringUtils.isNotBlank(versionProp) && StringUtils.isNotBlank(platformProp)) {
            capabilities.setBrowserName(browserProp);
            capabilities.setCapability("version", versionProp);
            capabilities.setCapability("platform", Platform.extractFromSysProperty(platformProp));
            capabilities.setCapability("tags","Axis_Test");
            System.out.println("AXIS TEST");

        } else if (StringUtils.isNotBlank(browser) && StringUtils.isNotBlank(version) && StringUtils.isNotBlank(os)) {
            capabilities.setBrowserName(browser);
            capabilities.setCapability("version", version);
            capabilities.setCapability("platform", Platform.extractFromSysProperty(os));
            capabilities.setCapability("tags","Single_Test");
            System.out.println("SINGLE/NON-AXIS TEST");

        } else if (browser.equals("chrome") && StringUtils.isBlank(version) && StringUtils.isNotBlank(os)){
            capabilities = DesiredCapabilities.chrome(); // Sauce doesn't want us to pass a browser version with chrome
            System.out.println("CHROME TEST");

        } else {
            capabilities = DesiredCapabilities.firefox();
        }

        capabilities.setCapability("name", "Test Method: " + method.getName());
        this.client = new RemoteWebDriver(
                new URL("http://" + authentication.getUsername() + ":" + authentication.getAccessKey() + "@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
        ((RemoteWebDriver) client).setFileDetector(new LocalFileDetector());
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
        System.out.println("METHOD END\n");
        Reporter.log(result.getMethod().getMethodName() + " SauceResultsUrl> " + getResultsUrl(getSessionId()), true);
        client.quit();
    }

    @Test
    public void SignUp() {
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);
        ud_signupHelper_Client = new UD_SignupHelper_Client(client);
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);

        String email;
        email = emailClient;
        String var;
        var = date;

        client.get(UD_DOMAIN);
        client.manage().addCookie(new Cookie("udsubpop", "3","ud-branch.thedaddy.co", "/", null));

        // Click NYC Link
        WebElement el1 = client.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/a[12]"));
        el1.click();

        // Click SignUp
        WebElement el2 = client.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/a[2]"));
        el2.click();

        //b. Enter email address
        WebDriverWait wait = new WebDriverWait(client, 30);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        } catch (TimeoutException TE) {
            System.out.println("EMAIL BOX NOT FOUND");
        }
        // Stale element seems to happen here

        if (!StaleElementHandleByXpath(email)) {
            throw new ElementNotVisibleException("Email didn't show up");
        }
        System.out.println("UD EMAIL CLIENT> " + email);

        ud_signupHelper_Client.checkDriven();
        ud_signupHelper_Client.checkJetset();
        ud_signupHelper_Client.checkLasVegas();
        ud_signupHelper_Client.checkNational();
        ud_signupHelper_Client.checkSkiBoard();

        //click "more" link to show all Editorials
        WebElement el3 = client.findElement(By.xpath("/html/body/div[5]/div/div/div/form/div[4]/label/a"));
        el3.click();

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
        WebElement el4 = client.findElement(By.xpath("/html/body/div[5]/div/div/div/form/div[5]/label/a"));
        el4.click();

        // check all of them
        ud_signupHelper_Client.checkBostonPerks();
        ud_signupHelper_Client.checkChicagoPerks();
        ud_signupHelper_Client.checkDCPerks();
        ud_signupHelper_Client.checkLosAngelesPerks();
        ud_signupHelper_Client.checkMiamiPerks();
        ud_signupHelper_Client.checkNationalPerks();


        WebElement el5 = client.findElement(By.xpath("/html/body/div[5]/div/div/div/form/div[7]/div/input"));
        el5.click();


        //step2, 2nd signup modal:
        //enter PASSWORD
        ud_signupHelper_Client.enterPassword(PASSWORD);
        //confirm PASSWORD
        ud_signupHelper_Client.confirmPassword(PASSWORD);
        //First Name
        ud_signupHelper_Client.enterFirstName("FN_"+var);
        //Last Name
        ud_signupHelper_Client.enterLastName("LN_"+var);
        //Gender
        ud_signupHelper_Client.selectGender("Male");
        //ud_signupHelper_Client.selectGender("Female");
        //ud_signupHelper_Client.selectGenderRandom();

        //Income Range
        ud_signupHelper_Client.selectIncomeRange("Less than $30,000");

        //Zip Code
        ud_signupHelper_Client.enterZipCode("10001");
        //Birthday (MM/DD/YYYY)
        ud_signupHelper_Client.enterBirthday("07/07/1977");
        //click "SUBMIT" button

        //ud_signupHelper_Client.clickSubmit();
        WebElement submit = client.findElement(By.xpath("/html/body/div[5]/div/div/div/form/div[3]/div[1]/input"));
        submit.click();


        //step3, 3rd signup modal: Invite Friends

        Assert.assertTrue(ud_signupHelper_Client.isInvitePresent());

        for (int i = 0; i < friend.length; i++) {
            ud_signupHelper_Client.enterEmailFriend(friend[i],(i+1));
            System.out.println(friend[i]);
        }

        // Try submitting the form instead of clicking the invite button
        WebElement invite = client.findElement(By.xpath("/html/body/div[5]/div/div/div/form/div/div/input"));
        invite.click();

        // ud_signupHelper_Client.clickSkip();
        WebDriverWait wait1 = new WebDriverWait(client, 30);
        try {
            wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[5]/div/div/div/form/div/div[2]")));
        } catch (TimeoutException TE) {
            System.out.println("TIMED OUT WAITING FOR SPINNER TO STOP");
        }

        WebElement thanks = client.findElement(By.className("thanks"));
        Assert.assertTrue(thanks.isDisplayed());


        //step4, 4th signup modal confirmation, close final confirm signup box

        WebElement close = client.findElement(By.xpath("/html/body/div[5]/div/div/div/a"));
        close.click();

        //end of registration
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

    private boolean StaleElementHandleByXpath (String email){
        ud_signupHelper_Client = new UD_SignupHelper_Client(client);
        int count = 0;
        boolean flag = false;
        do {
            try {
                ud_signupHelper_Client.enterEmail(email);
                count++;
                flag = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element: " + e.getMessage());
            }
        } while (count < 4 && !flag);
        if (count >= 4) {
            return false;
        } else {
            return true;
        }
    }

}
