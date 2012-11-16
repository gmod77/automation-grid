package org.urbandaddy.com.sauce;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.com.helpers.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Workflow specific imports

/**
 *  Urban Daddy Domain Test Methods
 *
 *
 */
public abstract class iTestCaseManeroSauce extends iSauceBase implements UDBase {

    String lastURL;
    String maneroCity;


    private Manero_FooterHelper_Client manero_footerHelper_client;
    private Manero_HeaderHelper_Client manero_headerHelper_client;
    private Manero_SignupHelper_Client manero_signupHelper_client;
    private Manero_HomepageHelper_Client manero_HomepageHelper_Client;

///// Sign-up methods

    // UD

    /**
     *  Navigate to the home page and perform a series of checks
     *  to make sure certain links are present
     *
     */
    public void visitManeroFirstTime(){

        // enter Manero domain name, hit enter, arrive on homepage
        client.get(MANERO_DOMAIN);
        Assert.assertTrue(client.getCurrentUrl().equals(MANERO_DOMAIN + "/home/ntl"),"Manero URL didn't redirect to National Page");
        Assert.assertTrue(client.findElement(By.xpath("//*[@id=\"header\"]/div[2]/h1")).isDisplayed(),"Logo did not showup");

    }

    /**
     * Share an article via email
     * PreRequisite: visitUDFirstTime()
     *
     */
    public void shareArticle(String mailClient, String[] friends){
        //TODO update for Manero
        iHelper_client = new IHelper_Client(client);

        // Grab the first article under "The Five You Need To Read"
        client.findElement(By.xpath(".//*[@id='content']/div/div[1]/div[2]/div/div[2]/div[1]/p/a")).click();

        // Grab article title
        String articleTitle = iHelper_client.findElementAndCheckBy("xpath","//html/body/div/div[3]/div/div/h1/span",5).getText();
        System.out.println("Article Title> " + articleTitle);
        // Click on the Forward button
        iHelper_client.findElementAndCheckBy("xpath",".//*[@id='weekenderContentHolder']/div[1]/div[8]/a[1]",5).click();

        // Handle popup window
        String handler = popUpHandler("Forward to a Friend",client);

        // Confirm Name of Article Appears
        String confirmTitle = client.findElement(By.xpath("/html/body/div[1]/div/div/div/p")).getText();
        System.out.println("Confirm Title> " + confirmTitle);
        Assert.assertTrue(confirmTitle.contains(articleTitle), "Article title was not found on popup.");

        // Fill in email addresses
        for (int i = 0; i < friends.length; i++) {
            client.findElement(By.id("invite_email_" + i)).sendKeys(friends[i]);
        }

        // If visible fill in Name
        if (client.findElement(By.id("name")).isDisplayed()) {
            WebElement name = client.findElement(By.id("name"));
            name.sendKeys("QA TESTER");
        }

        // If visible fill in Email
        if (client.findElement(By.id("email")).isDisplayed()) {
            WebElement email = client.findElement(By.id("email"));
            email.sendKeys(mailClient);
        }


        //Fill in personal message
        client.findElement(By.id("msg")).sendKeys("QA Tester, personal message.\nLorem ipsum lorem ipsum.");

        //Click Submit
        client.findElement(By.id("myaccount_invite_users_form")).submit();

        //Confirmation screen check
        String str = iHelper_client.findElementAndCheckBy("xpath","//html/body/div/div/div/div[1]/p",5).getText();
        Assert.assertTrue(str.contains("Thank you. The article has been forwarded to your friend(s)."), "Popup failed to submit");

        //Close Popup
        client.findElement(By.tagName("input")).click();

        //Return to Parent Window
        returnToParentWindow(handler,client);

    }

    public void saveArticleToAccount () {
        //TODO update for Manero
        iHelper_client = new IHelper_Client(client);

        // Grab the first article under "The Five You Need To Read"
        //client.findElement(By.xpath(".//*[@id='content']/div/div[1]/div[2]/div/div[2]/div[1]/p/a")).click();
        WebElement bigFiveBox = client.findElement(By.className("wideContentBoxTxt"));
        bigFiveBox.findElement(By.className("boxOne")).findElement(By.tagName("a")).click();

        // Click the save button
        findElementAndCheckBy("xpath","//*[@id=\"buttonSave\"]",10).click();

        // Save the URL
        String url = client.getCurrentUrl();

        // Confirm save button disappeared
        Assert.assertFalse(client.findElement(By.xpath("//*[@id=\"buttonSave\"]")).isDisplayed());

        // Navigate to MyUD
        client.get("http://ud-branch.thedaddy.co/myud");

        // Check MyUD box "Favorites" has incremented
        String favCount = client.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div[2]/dl/dd/b/a")).getText();
        Assert.assertEquals(favCount,"1","The article didn't save or count didn't increment to 1");

        // Check that the article appears under Favorite
        WebElement articleLink = client.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div/ul/li/a"));

        String favUrlMyUD = articleLink.getAttribute("href");
        // They add /favorites to the end
        Assert.assertEquals(url + "/favorites", favUrlMyUD, "Original article doesn't match saved article.");

    }


    /**
     * Check the Manero header and homepage while logged out
     * Confirm each link by clicking on it
     *
     */
    public void checkManeroHomepageHeaderLoggedOut(){

        lastURL = client.getCurrentUrl();
        //do all homepage header checks
        manero_HomepageHelper_Client= new Manero_HomepageHelper_Client(client);
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        Assert.assertTrue(manero_headerHelper_client.isSignUpPresent());
        Assert.assertTrue(manero_HomepageHelper_Client.isCarouselPresent());
        Assert.assertTrue(manero_HomepageHelper_Client.isManeroLogoPresent());
        Assert.assertTrue(manero_HomepageHelper_Client.isShortListPresent());

        manero_HomepageHelper_Client.clickCultura();
        this.pause(7000);
        manero_HomepageHelper_Client.clickEntertainment();
        this.pause(7000);
        manero_HomepageHelper_Client.clickGadgets();
        this.pause(7000);
        manero_HomepageHelper_Client.clickMusica();
        this.pause(7000);
        manero_HomepageHelper_Client.clickNightLife();
        this.pause(7000);
        manero_HomepageHelper_Client.clickSports();
        this.pause(7000);
        manero_HomepageHelper_Client.clickStyle();
        this.pause(7000);
        manero_HomepageHelper_Client.clickTravel();
        this.pause(7000);
    }

    /**
     * Check the Manero header and homepage while logged in
     * Confirm each link by clicking on it
     *
     */
    public void checkManeroHomepageHeaderLoggedIn(){
        lastURL = client.getCurrentUrl();
        //do all homepage header checks
        manero_HomepageHelper_Client = new Manero_HomepageHelper_Client(client);
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        Assert.assertTrue(manero_headerHelper_client.isLogoutPresent());
        Assert.assertTrue(manero_HomepageHelper_Client.isCarouselPresent());
        Assert.assertTrue(manero_HomepageHelper_Client.isManeroLogoPresent());
        Assert.assertTrue(manero_HomepageHelper_Client.isShortListPresent());

        manero_HomepageHelper_Client.clickCultura();
        this.pause(7000);
        manero_HomepageHelper_Client.clickEntertainment();
        this.pause(7000);
        manero_HomepageHelper_Client.clickGadgets();
        this.pause(7000);
        manero_HomepageHelper_Client.clickMusica();
        this.pause(7000);
        manero_HomepageHelper_Client.clickNightLife();
        this.pause(7000);
        manero_HomepageHelper_Client.clickSports();
        this.pause(7000);
        manero_HomepageHelper_Client.clickStyle();
        this.pause(7000);
        manero_HomepageHelper_Client.clickTravel();
        this.pause(7000);
    }

    /**
     * Check the Manero footer
     * Checks to see the links exist
     *
     */
    public void checkManeroHomepageFooterLoggedOut(){

        //do all homepage footer checks
        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        Assert.assertTrue(manero_footerHelper_client.isAboutUsHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isAdvertiseHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isChicagoHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isContactHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isEditorialPolicyHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isEmailIssuesHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isHoustonHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isJobsHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isLosAngelesHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isMiamiHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isNationalHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isNewYorkHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isPrivacyPolicyHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isSignUpHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isUnsubscribeHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isUserAgreementHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isSignUpHomePresent());
    }

    /**
     * Check the Urban Daddy footer while logged in
     * Checks to see the links exist
     *
     */
    public void checkManeroHomePageFooterLoggedIn(){

        //do all city homepage footer checks for logged in state
        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        Assert.assertTrue(manero_footerHelper_client.isAboutUsHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isAdvertiseHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isChicagoHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isContactHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isEditorialPolicyHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isEmailIssuesHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isHoustonHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isJobsHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isLosAngelesHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isMiamiHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isNationalHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isNewYorkHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isPrivacyPolicyHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isSignUpHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isUnsubscribeHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isUserAgreementHomePresent());
        Assert.assertTrue(manero_footerHelper_client.isMyAccountPresent());

    }

    /**
     * Run this method after logging in to unsubscribe
     * from all perks and editorial emails
     *
     */
    public void unSubscribeFromEmails(){
        //TODO Finishs this
        // Declare helpers
        ud_sealHelper_Client = new UD_SealHelper_Client(client);
        ud_unSubscribeHelper_client = new UD_UnSubscribeHelper_Client(client);

        // Assume logged in, edit settings
        ud_sealHelper_Client.clickEditSettings();

        // Pause for a couple secs until ajax window shows up
        pause(3000);

        // Uncheck all the editorial boxes
        WebElement editorial = client.findElement(By.className("myUDpopupEditorials"));
        List<WebElement> editions = editorial.findElements(By.tagName("div"));
        for (WebElement edition : editions) {
            if (edition.findElement(By.tagName("input")).isSelected()) {
                WebElement box = edition.findElement(By.tagName("input"));
                box.click();
            }
        }

        // Uncheck all the perks boxes
        WebElement perksList = client.findElement(By.className("htmlEditionsHolder"));
        List<WebElement> perks = perksList.findElements(By.tagName("div"));
        for (WebElement perk : perks) {
            if (perk.findElement(By.tagName("input")).isSelected()) {
                WebElement box = perk.findElement(By.tagName("input"));
                box.click();
            }
        }

        // Click update
        ud_unSubscribeHelper_client.clickUpdate();
        pause(3000);
        // Confirm unsubscription
        ud_unSubscribeHelper_client.confirmUpdate();
        pause(3000);

        // Close the lightbox
        WebElement closeButton = client.findElement(By.className("ajaxClose"));
        closeButton.click();

    }

    /**
     * Confirm the unsubscribe email contains the text
     * "successfully unsubscribed"
     */
    public void unSubscribeMailConfirm(){
        //TODO
        emailHelper_Client = new EmailHelper_Client(client);

        emailHelper_Client.searchEmail("successfully unsubscribed");
    }


    public boolean StaleElementHandleByXpath (String email){
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

    /**
     * Sign up and register for perks & editorial
     * via New York UD edition
     *
     */
    public void signUpManeroStep1(String email) throws ElementNotVisibleException {

        manero_signupHelper_client = new Manero_SignupHelper_Client(client);
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        //step1, 1st signup modal:

        manero_headerHelper_client.clickSignUp();

        //b. Enter email address

        WebDriverWait waitForBox = new WebDriverWait(client,30);
        waitForBox.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("box_header")));

//
//        WebDriverWait wait = new WebDriverWait(client, 30);
//        try {
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
//        } catch (TimeoutException TE) {
//            System.out.println("EMAIL BOX NOT FOUND");
//        }
//        // Stale element seems to happen here
//
//        if (!StaleElementHandleByXpath(email)) {
//            throw new ElementNotVisibleException("Email didn't show up");
//        }
        System.out.println("MANERO EMAIL CLIENT> " + email);

        //c. Select Editions

        manero_signupHelper_client.enterSigninEmail(email);

        manero_signupHelper_client.checkChicago();
        manero_signupHelper_client.checkHouston();
        manero_signupHelper_client.checkLosAngeles();
        manero_signupHelper_client.checkMiami();
        manero_signupHelper_client.checkNational();
        manero_signupHelper_client.checkNewYork();

        //Click Join
        manero_signupHelper_client.clickJoin();

    }

    /**
     * Complete registration form by filling out
     * name, gender, income range, zip code, etc.
     */
    public void signUpManeroStep2(String var){

        manero_signupHelper_client = new Manero_SignupHelper_Client(client);

        //step2, 2nd signup modal:
        //enter PASSWORD
        manero_signupHelper_client.enterPassword(PASSWORD);

        //confirm PASSWORD
        manero_signupHelper_client.confirmPassword(PASSWORD);

        //First Name
        manero_signupHelper_client.enterFirstName("FN_"+var);

        //Last Name
        manero_signupHelper_client.enterLastName("LN_"+var);

        //Gender
        manero_signupHelper_client.selectGender("Male");
        //ud_signupHelper_Client.selectGender("Female");
        //ud_signupHelper_Client.selectGenderRandom();

        //Zip Code
        manero_signupHelper_client.enterZipCode("10001");

        //Birthday (MM/DD/YYYY)
        manero_signupHelper_client.enterBirthday("07/07/1977");

        //click "SUBMIT" button
        manero_signupHelper_client.clickSubmit();

    }

    /**
     * Fills out the refer a friend form.
     */
    public void signUpManeroStep3(String[] friend){

        manero_signupHelper_client = new Manero_SignupHelper_Client(client);

    //step3, 3rd signup modal: Invite Friends

        WebDriverWait InviteFriendsWindow = new WebDriverWait(client, 30);
        InviteFriendsWindow.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("sign_up_invites")));

        for (int i = 0; i < friend.length; i++) {
            manero_signupHelper_client.enterEmailFriend(friend[i],(i+1));
            System.out.println(friend[i]);
        }

        // Click Invite
        manero_signupHelper_client.clickInvite();
    }

    /**
     * Close the sign up form.
     */
    public void signUpManeroStep4(){
        //step4, 4th signup modal confirmation, close final confirm signup box
        manero_signupHelper_client = new Manero_SignupHelper_Client(client);

        WebDriverWait ThankYouWindow = new WebDriverWait(client, 30);
        ThankYouWindow.until(ExpectedConditions.visibilityOfElementLocated(By.id("signup-close")));

        Assert.assertTrue(manero_signupHelper_client.fbFriendUs().isDisplayed(),"FB Friend us link missing");
        Assert.assertTrue(manero_signupHelper_client.twitterFollow().isDisplayed(),"Twitter follow us link missing");
        Assert.assertTrue(manero_signupHelper_client.privacyPolicyLink().isDisplayed(),"Privacy Policy link is missing");
        Assert.assertTrue(manero_signupHelper_client.userAgreementLink().isDisplayed(),"User Agreement link is missing");

        manero_signupHelper_client.clickCloseButton();
    }

    /**
     * Click the change city link from the homepage
     */
    public void changeCityFromManeroHomepage(){
        //click on "Change City" from any city home page, navigate back to home page
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        manero_headerHelper_client.clickChangeCity();

    }

    /**
     * Click the Chicago link from the homepage
     */
    public void accessChicagoFromManeroHomepage(){
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        manero_headerHelper_client.clickChangeCityChicago();
        maneroCity = "chi";

    }

    /**
     * Click the Houston link from the homepage
     */
    public void accessHoustonFromManeroHomepage(){
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        manero_headerHelper_client.clickChangeCityHouston();
        maneroCity = "hou";

    }

    /**
     * Click the LA link from the homepage
     */
    public void accessLosAngelesFromManeroHomepage(){
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        manero_headerHelper_client.clickChangeCityLosAngeles();
        maneroCity = "la";
    }

    /**
     * Click the Miami link from the homepage
     */
    public void accessMiamiFromManeroHomepage(){
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        manero_headerHelper_client.clickChangeCityMiami();
        maneroCity = "mia";
    }

    /**
     * Click the National edition link from the homepage
     */
    public void accessNationalFromNationalHomepage(){
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        manero_headerHelper_client.clickChangeCityNational();
        maneroCity = "ntl";
    }

    /**
     * Click the New York link from the homepage
     */
    public void accessNewYorkFromNewYorkHomepage(){
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        manero_headerHelper_client.clickChangeCityNewYork();
        maneroCity = "nyc";
    }

///////////// Sign-up methods end here		

///////////////  Login/SignOut methods

    /**
     * Login using params from this class
     *
     */
    public void loginManero(String emailClient){
        //TODO Create Manero Login Helper
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        client.get(MANERO_DOMAIN);

        manero_headerHelper_client.clickMemberLogIn();
        ud_sealHelper_Client.enterEmailAddress(emailClient);
        ud_sealHelper_Client.enterPassword(PASSWORD);
        ud_sealHelper_Client.clickLogin();

    }

    /**
     * Overloaded login class, use to pass email and PASSWORD in via
     * other tests.
     * ex. currently used in UD_Unsubscribe_EditionsPerks
     * @param email Email address
     * @param pw PASSWORD
     */
    public void loginManero(String email, String pw){
        //TODO Create Overloaded Version
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);
        ud_sealHelper_Client = new UD_SealHelper_Client(client);

        client.get(UD_DOMAIN);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        manero_headerHelper_client.clickMemberLogIn();
        ud_sealHelper_Client.enterEmailAddress(email);
        ud_sealHelper_Client.enterPassword(pw);
        ud_sealHelper_Client.clickLogin();

    }

    /**
     * Logout of UD and do checks on the footer
     *
     */
    public void logoutManero(){
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);
        manero_headerHelper_client.clickLogout();
    }

    /**
     * Perform a PASSWORD reset.
     */
    public void resetPasswordUD(String emailClient){
        //TODO finish this
        ud_sealHelper_Client = new UD_SealHelper_Client(client);
        manero_headerHelper_client = new Manero_HeaderHelper_Client(client);

        manero_headerHelper_client.clickMemberLogIn();
        ud_sealHelper_Client.clickResetPassword();
        ud_sealHelper_Client.enterEmailToReset(emailClient);
        ud_sealHelper_Client.clickSend();

    }

    /**
     * Login to the UD site then update your account
     * by checking some editions and perks
     *
     */
    public void editSettingsUD(){
        //TODO finish this
        ud_sealHelper_Client = new UD_SealHelper_Client(client);

        ud_sealHelper_Client.clickEditSettings();
        ud_sealHelper_Client.enterPasswordMyUD(PASSWORD);
        ud_sealHelper_Client.confirmPasswordMyUD(PASSWORD);

        ud_sealHelper_Client.checkDC();
        ud_sealHelper_Client.checkPhilly();
        ud_sealHelper_Client.checkSeattle();
        ud_sealHelper_Client.checkDCPerks();

        ud_sealHelper_Client.clickUpdate();
        this.pause(3000);
        ud_sealHelper_Client.clickClose();

    }

    /**
     * Use the findElement method to extend some functionality to searching for
     * elements. Attempts to find the element 3 times before throwing an error.
     *
     * @param type  Search by name, xpath, tagname, classname, css, id
     * @param locator Enter the name of the element you're looking for
     * @param timeout Enter the number of seconds for the timeout
     * @return that web element or throw an error
     */
    public WebElement findElementAndCheckBy(final String type, String locator, int timeout) throws ElementNotVisibleException {
        int counter = 0;
        boolean flag = false;
        final String ele = locator;
        WebElement a = null;

        do {
            try {
                Reporter.log("Trying to find the element> " + ele + "\nTimeout in> " + timeout + " seconds.");
                a = (new WebDriverWait(client, timeout)).until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
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
                        Reporter.log("Found> " + ele);
                        return ret;
                    }
                });
                flag = true;
            } catch (TimeoutException e) {
                counter++;
                Reporter.log("Attempt " + counter + ": Could not find> " + ele);
                Reporter.log("Trying again");
            }
        } while (counter <= 2 && !flag);
        if (a == null) {
            throw new ElementNotVisibleException("3rd Attempt reached. Could not find> " + ele);
        } else {
            return a;
        }
    }

    /**
     * Use this to handle popups
     * @param winTitle
     * @param client
     * @return
     */
    public String popUpHandler(String winTitle, WebDriver client) {
        String parentWindowHandle=client.getWindowHandle();
        WebDriver popup = null;
        //handle pop-up window
        Set<?> s_add2=client.getWindowHandles();
        //this method will you handle of all opened windows

        Iterator<?> windowIterator=s_add2.iterator();

        while(windowIterator.hasNext()) {
            String windowHandle = windowIterator.next().toString();
            popup = client.switchTo().window(windowHandle);
            if (popup.getTitle().contains(winTitle)) {
                break;
            }
        }
        return parentWindowHandle;
    }

    /**
     * Use this to return to parent window
     * @param parent
     * @param client
     */
    public void returnToParentWindow(String parent, WebDriver client) {
        client.switchTo().window(parent);
    }
}
