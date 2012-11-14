package org.urbandaddy.com.sauce;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.com.helpers.*;

//Workflow specific imports

/**
 * This class contains all Perks domain specific tests
 */
public abstract class iTestCasePerksSauce extends iSauceBase implements UDBase {

    String lastURL;

    // Perks

    /**
     * After login navigate to account settings
     */
    public void editSettingsPerks(){
        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);
        //Reuse methods in UD client
        ud_sealHelper_Client = new UD_SealHelper_Client(client);
        lastURL = client.getCurrentUrl();

        perks_headerHelper_Client.clickMyAccount();
        perks_headerHelper_Client.isMyAccountAccessible();

        ud_sealHelper_Client.clickEditSettingsMyUD();
        ud_sealHelper_Client.enterPasswordMyUD(PASSWORD);
        ud_sealHelper_Client.confirmPasswordMyUD(PASSWORD);

        ud_sealHelper_Client.checkDCPerks();


        ud_sealHelper_Client.clickUpdate();
        this.pause(3000);
        ud_sealHelper_Client.clickClose();
    }

    /**
     * Navigate to the Perks domain
     *
     */
    public void visitPerksFirstTime(){

        // enter UD domain name, hit enter, arrive on homepage
        client.get(PERKS_DOMAIN);
        client.manage().deleteAllCookies();
        client.get(PERKS_DOMAIN);
    }

    /**
     * Execute all steps to sign up for perks
     * via the New York edition of UD
     */
//    public void signUpPerks_viaNewYork(){
//
//        this.signUpPerks_viaNewYorkStep1();
//        this.signUpPerks_viaNewYorkStep2();
//        this.signUpPerks_viaNewYorkStep3();
//        this.signUpPerks_viaNewYorkStep4();
//    }

    /**
     * Sign into the perks site
     */
    public void signInPerks(String emailClient){

        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);
        perks_sealHelper_Client = new Perks_SealHelper_Client(client);

        client.get(PERKS_DOMAIN);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //click signup
        perks_headerHelper_Client.clickSignUp();

        //b. Enter email address
        perks_signupHelper_Client.enterSigninEmail(emailClient);

        perks_signupHelper_Client.enterSigninPassword(PASSWORD);

        perks_signupHelper_Client.clickSignIn();
    }

    public void checkPerksHomepageCityFooter () {

    }

    public void returnToPerks() {
        client.get(PERKS_DOMAIN);
    }

    /**
     * Log out of perks
     */
    public void logoutPerks(){

        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

        perks_headerHelper_Client.clickLogout();

        //click logout confirmation OK
        this.pause(3000);
        client.findElement(By.xpath("//html/body/div/div/div[4]/ul/li[3]/a")).click();


        // do all footer checks	for logged out state
        //perks_footerHelper_Client = new Perks_FooterHelper_Client(client);
        //this.checkPerksHomepageCityFooterLoggedOut();

        WebDriverWait waitForContinue = new WebDriverWait(client, 30);
        waitForContinue.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[2]/div/a/span"))).click();
    }

    /**
     * Send a perks password reset email
     *
     */
    public void resetPasswordPerks(String emailClient){

		// perks_homepageHelper_Client = new Perks_HomepageHelper_Client(client);
		// perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

		// perks_signupHelper_Client = new Perks_SignupHelper_Client(client);

        System.out.println(emailClient);

        //step1, 1st signup modal:
        //a. Click SignUp Seal
        perks_headerHelper_Client.clickSignUp();

        perks_signupHelper_Client.clickForgotYourPassword();

        perks_signupHelper_Client.enterForgotPasswordEmail(emailClient);

        perks_signupHelper_Client.clickSend();
        this.pause(3000);
    }

    /**
     * Navigate to the perks home page and sign up
     * for perks by clicking editions and editorials.
     */
    public void signUpPerks_viaNewYorkStep1(String email){


        perks_homepageHelper_Client = new Perks_HomepageHelper_Client(client);
        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

        perks_signupHelper_Client = new Perks_SignupHelper_Client(client);

        System.out.println(email);

        //step1, 1st signup modal:
        //a. Click SignUp Seal
        perks_headerHelper_Client.clickSignUp();

        //b. Enter email address
        perks_signupHelper_Client.enterJoinEmail(email);

        perks_signupHelper_Client.clickAccept();

        //c. Select Editions
        //New York, New York Perks are selected by default
        //check Driven
        perks_signupHelper_Client.checkBostonPerks();
        perks_signupHelper_Client.checkChicagoPerks();
        perks_signupHelper_Client.checkDCPerks();
        perks_signupHelper_Client.checkLosAngelesPerks();
        perks_signupHelper_Client.checkMiamiPerks();
        perks_signupHelper_Client.checkNationalPerks();

        //click "more" link to show all Editorials
        perks_signupHelper_Client.clickMoreLinkNewYork1();

        // check all of them
        perks_signupHelper_Client.checkAtlanta();
        perks_signupHelper_Client.checkBoston();
        perks_signupHelper_Client.checkChicago();
        perks_signupHelper_Client.checkDallas();
        perks_signupHelper_Client.checkDC();
        perks_signupHelper_Client.checkDriven();
        perks_signupHelper_Client.checkJetset();
        perks_signupHelper_Client.checkLasVegas();
        perks_signupHelper_Client.checkLosAngeles();
        perks_signupHelper_Client.checkMiami();
        perks_signupHelper_Client.checkNational();
        perks_signupHelper_Client.checkSanFrancisco();
        perks_signupHelper_Client.checkSkiBoard();

        //click "JOIN" button

        perks_signupHelper_Client.clickSubmit1();
    }

    /**
     * Fill out the perks registration form providing
     * Name, Gender, Income Range, etc.
     */
    public void signUpPerks_viaNewYorkStep2(String date){

        //step2, 2nd signup modal:
        //enter password
        perks_signupHelper_Client.enterPassword(PASSWORD);
        //confirm password
        perks_signupHelper_Client.confirmPassword(PASSWORD);
        //First Name
        perks_signupHelper_Client.enterFirstName("FN_"+date);
        //Last Name
        perks_signupHelper_Client.enterLastName("LN_"+date);
        //Gender
        perks_signupHelper_Client.selectGender("Male");
        //perks_signupHelper_Client.selectGender("Female");
        //perks_signupHelper_Client.selectGenderRandom();

        //Income Range
        perks_signupHelper_Client.selectIncomeRange("Less than $30,000");
//		perks_signupHelper_Client.selectIncomeRange("$30,000-$44,999");
//		perks_signupHelper_Client.selectIncomeRange("$45,000-$59,999");
//		perks_signupHelper_Client.selectIncomeRange("$60,000-$74,999");
//		perks_signupHelper_Client.selectIncomeRange("$75,000-$99,999");
//		perks_signupHelper_Client.selectIncomeRange("$100,000-$199,999");
//		perks_signupHelper_Client.selectIncomeRange("$200,000-$299,999");
//		perks_signupHelper_Client.selectIncomeRange("$300,000-$499,999");
//		perks_signupHelper_Client.selectIncomeRange("$500,000+");
//		perks_signupHelper_Client.selectIncomeRangeRandom();

        //Zip Code
        perks_signupHelper_Client.enterZipCode("10001");
        //Birthday (MM/DD/YYYY)
        perks_signupHelper_Client.enterBirthday("07/07/1977");
        //click "SUBMIT" button

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        perks_signupHelper_Client.clickSubmit();
    }

    /**
     * Enter friend referrals and print the emails
     * used to the log
     */
    public void signUpPerks_viaNewYorkStep3(String[] friends){


        //	perks_homepageHelper_Client = new Perks_HomepageHelper_Client(client);
        //	perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);
        //
        //	perks_signupHelper_Client = new Perks_SignupHelper_Client(client);

        //step3, 3rd signup modal: Invite Friends

//		ud_signupHelper_Client.clickInvite();

        for (int i = 0; i < friends.length; i++) {
            perks_signupHelper_Client.enterEmailFriend(friends[i],(i+1));
            System.out.println(friends[i]);
        }



//        perks_signupHelper_Client.enterEmailFriend1(emailFriend1);
//        perks_signupHelper_Client.enterEmailFriend2(emailFriend2);
//        perks_signupHelper_Client.enterEmailFriend3(emailFriend3);
//        perks_signupHelper_Client.enterEmailFriend4(emailFriend4);
//        perks_signupHelper_Client.enterEmailFriend5(emailFriend5);
//
//        System.out.println(emailFriend1);
//        System.out.println(emailFriend2);
//        System.out.println(emailFriend3);
//        System.out.println(emailFriend4);
//        System.out.println(emailFriend5);



        perks_signupHelper_Client.clickInvite();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//		perks_signupHelper_Client.clickSkip();
    }

    /**
     * After friend referral submission
     * close the perks signup form
     */
    public void signUpPerks_viaNewYorkStep4(){
        //step4, 4th signup modal confirmation, close final confirm signup box
        this.pause(3000);
        perks_signupHelper_Client.clickCloseFinalModal();
        //end of registration
    }

}
