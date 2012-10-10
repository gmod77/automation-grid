package org.urbandaddy.helpers.Comm;

import org.openqa.selenium.By;
import org.urbandaddy.helpers.*;

//Workflow specific imports

/**
 * This class contains all Perks domain specific tests
 */
public abstract class iTestCasePerks extends ITestCase {
    // Perks

    /**
     * After login navigate to account settings
     */
    public void editSettingsPerks(){
        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

        lastURL = client.getCurrentUrl();

        perks_headerHelper_Client.clickMyAccount();
        perks_headerHelper_Client.isMyAccountAccessible();

        client.get(lastURL);
    }

    /**
     * Navigate to the Perks domain
     *
     */
    public void visitPerksFirstTime(){

        // enter UD domain name, hit enter, arrive on homepage
        client.get(Perksdomain);
        client.manage().deleteAllCookies();
        client.get(Perksdomain);
    }

    /**
     * Execute all steps to sign up for perks
     * via the New York edition of UD
     */
    public void signUpPerks_viaNewYork(){

        this.signUpPerks_viaNewYorkStep1();
        this.signUpPerks_viaNewYorkStep2();
        this.signUpPerks_viaNewYorkStep3();
        this.signUpPerks_viaNewYorkStep4();
    }

    /**
     * Sign into the perks site
     */
    public void signInPerks(){

        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);
        perks_sealHelper_Client = new Perks_SealHelper_Client(client);

        client.get(Perksdomain);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //click signup
        perks_headerHelper_Client.clickSignUp();

        //b. Enter email address
        perks_signupHelper_Client.enterSigninEmail(emailClient);
        perks_signupHelper_Client.enterSigninPassword(password);

        perks_signupHelper_Client.clickSignIn();


        // do all footer checks	for logged in state
        perks_footerHelper_Client = new Perks_FooterHelper_Client(client);
        //this.checkPerksHomepageCityFooterLoggedIn();

    }

    /**
     * Log out of perks
     */
    public void logoutPerks(){

        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

        perks_headerHelper_Client.clickLogout();

        //click logout confirmation OK
        this.pause3();
        client.findElement(By.xpath("//html/body/div[5]/div[2]/div/div[2]/div[2]/div/a/span")).click();


        // do all footer checks	for logged out state
        //perks_footerHelper_Client = new Perks_FooterHelper_Client(client);
        //this.checkPerksHomepageCityFooterLoggedOut();

    }

    /**
     * Send a perks password reset email
     *
     */
    public void resetPasswordPerks(){

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
        this.pause3();
    }

    /**
     * Navigate to the perks home page and sign up
     * for perks by clicking editions and editorials.
     */
    public void signUpPerks_viaNewYorkStep1(){


        perks_homepageHelper_Client = new Perks_HomepageHelper_Client(client);
        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

        perks_signupHelper_Client = new Perks_SignupHelper_Client(client);

        System.out.println(emailClient);

        //step1, 1st signup modal:
        //a. Click SignUp Seal
        perks_headerHelper_Client.clickSignUp();

        //b. Enter email address
        perks_signupHelper_Client.enterJoinEmail(emailClient);

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
    public void signUpPerks_viaNewYorkStep2(){

        //step2, 2nd signup modal:
        //enter password
        perks_signupHelper_Client.enterPassword(password);
        //confirm password
        perks_signupHelper_Client.confirmPassword(password);
        //First Name
        perks_signupHelper_Client.enterFirstName("FN_"+emailFormat.format(now));
        //Last Name
        perks_signupHelper_Client.enterLastName("LN_"+emailFormat.format(now));
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
    public void signUpPerks_viaNewYorkStep3(){


        //	perks_homepageHelper_Client = new Perks_HomepageHelper_Client(client);
        //	perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);
        //
        //	perks_signupHelper_Client = new Perks_SignupHelper_Client(client);

        //step3, 3rd signup modal: Invite Friends

//		ud_signupHelper_Client.clickInvite();

        perks_signupHelper_Client.enterEmailFriend1(emailFriend1);
        perks_signupHelper_Client.enterEmailFriend2(emailFriend2);
        perks_signupHelper_Client.enterEmailFriend3(emailFriend3);
        perks_signupHelper_Client.enterEmailFriend4(emailFriend4);
        perks_signupHelper_Client.enterEmailFriend5(emailFriend5);

        System.out.println(emailFriend1);
        System.out.println(emailFriend2);
        System.out.println(emailFriend3);
        System.out.println(emailFriend4);
        System.out.println(emailFriend5);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        perks_signupHelper_Client.clickInvite();

//		perks_signupHelper_Client.clickSkip();
    }

    /**
     * After friend referral submission
     * close the perks signup form
     */
    public void signUpPerks_viaNewYorkStep4(){
        //step4, 4th signup modal confirmation, close final confirm signup box
        this.pause3();
        perks_signupHelper_Client.clickCloseFinalModal();
        //end of registration
    }

}
