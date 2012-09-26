package org.urbandaddy.tests;
import org.urbandaddy.helpers.Comm.iTestCaseUD;
import org.testng.annotations.Test;

/**
 * This test series creates an UD account, signs up for perks
 * and editorials, and then logs out. It the next test logs in
 * again with the same account and unchecks all the perks the
 * account signed up with; effectively unsubscribing the account
 * from all email.
 *
 */

public class UD_Unsubscribe_EditionsPerks extends iTestCaseUD{
    // Grab the email and password from ITestCase to be used
    // in both tests.
    String email = emailClient;
    String pass = password;

    /**
     * Create a new account and sign up for perks
     *
     */
    @Test (groups = "Setup")
    public void flow1(){
        visitUDFirstTime();

        accessNewYorkFromUDHomepage();

        signUpUD_viaNewYork();

        logoutUD();
        System.out.println("Used email> " + email);

    }

    /**
     * Log in to the newly created account
     * passing the email and password via loginUD2
     *
     */
    @Test (groups = "Unsubscribe", dependsOnGroups = {"Setup"})
    public void flow2() {
        visitUDFirstTime();
        accessNewYorkFromUDHomepage();
        loginUD(email, pass);
        unSubscribeFromEmails();
        System.out.println("Used email> " + email);

    }

    /**
     * Login to Gmail and check for the unsubscribe email
     */
    @Test (groups = "Confirm", dependsOnGroups = {"Setup", "Unsubscribe"})
    public void flow3(){
        loginToGmail();
        verifyEditSettingsUDEmailReceived(email);
        unSubscribeMailConfirm();
        logoutGmail();
    }

//    @Test
//    public void flow4(){
//        silverPopConfirm();
//    }

    @Override
    public void beforeMethod() {

    }

    @Override
    public void afterMethod() {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeClass() {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterClass() {
        // TODO Auto-generated method stub

    }

    @Override
    public void beforeTest() {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterTest() {
        // TODO Auto-generated method stub

    }
}
