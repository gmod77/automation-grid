package org.urbandaddy.tests.sauce;

import org.testng.annotations.Test;
import org.urbandaddy.com.common.Analyzer;
import org.urbandaddy.com.helpers.EmailHelper_Client;
import org.urbandaddy.com.sauce.iTestCasePerksSauce;


public class Perks_RegistrationFlow1Test extends iTestCasePerksSauce {
    String date;
    String emailClient;
    String[] emailFriends;

    public Perks_RegistrationFlow1Test() {
        emailFriends = new String[5];
    }
    @Test (groups = "perkSmoke", retryAnalyzer = Analyzer.class)
    public void perksSignUp(){
        emailHelper_Client = new EmailHelper_Client(client);

        date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        emailClient = emailHelper_Client.generateEmailClient(date);
        emailFriends = emailHelper_Client.generateFriendClient(5,date);

        visitPerksFirstTime();
        //1. client signs up and logs in

        signUpPerks_viaNewYorkStep1(emailClient);
        signUpPerks_viaNewYorkStep2(date);
        signUpPerks_viaNewYorkStep3(emailFriends);
        signUpPerks_viaNewYorkStep4();

        editSettingsPerks();
        //doChecksCityHomePageLoggedIn();

        returnToPerks();
        logoutPerks();

        visitPerksFirstTime();//return to homepage
        resetPasswordPerks(emailClient);
        
        //doChecksCityHomePageLoggedOut();

    }
    @Test (dependsOnGroups = {"perkSmoke"}, retryAnalyzer = Analyzer.class)
    public void perksConfirm() {
        emailHelper_Client = new EmailHelper_Client(client);

        emailHelper_Client.loginToGmail();

        emailHelper_Client.verifyWelcomeUDEmailReceived(emailClient);
        emailHelper_Client.verifyInvitationsUDEmailsReceived(emailFriends);
        //verifyEditSettingsUDEmailReceived();
        emailHelper_Client.verifyResetPasswordUDRequestReceivedandPasswordReset(emailClient);

    }
}
