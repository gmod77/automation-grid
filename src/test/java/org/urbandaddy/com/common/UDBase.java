package org.urbandaddy.com.common;

/**
 * Common strings used across all tests.
 *
 */
public interface UDBase {

    String UD_DOMAIN_BASE = "ud-branch.thedaddy.co";
    //String UD_DOMAIN = "http://ud-branch.thedaddy.co";
    String UD_DOMAIN = "http://" + UD_DOMAIN_BASE;
    String UD_ADMIN_DOMAIN = "http://ud-branch.thedaddy.co/admin.php";
    String UD_ADMIN_USERNAME = "jenkins";
    String UD_ADMIN_PW = "jenkins900!!";

    String PERKS_DOMAIN_BASE = "perks-branch.thedaddy.co";
    String PERKS_DOMAIN = "http://" + PERKS_DOMAIN_BASE;
    //String PERKS_DOMAIN = "http://perks-branch.thedaddy.co";
    String PERKS_ADMIN_DOMAIN = "https://perks-branch.thedaddy.co/index.php/admin";
    String PERKS_ADMIN_USERNAME = "jenkins";
    String PERKS_ADMIN_PW = "muffin1";

    String MANERO_DOMAIN = "http://manero-branch.thedaddy.co";

    String GOOGLE_EMAIL_LINK = "https://mail.google.com/mail/u/0/?logout&hl=en";

    String EMAIL_USER_NAME = "udtesterjenkins";
    String EMAIL_DOMAIN = "@gmail.com";
    String JENKINSEMAIL = EMAIL_USER_NAME + EMAIL_DOMAIN;
    String JENKINSEMAILPW = "commonud";

    String PASSWORD="12345";
    String NEW_PASSWORD="1234";

    String CUR_DIR = System.getProperty("user.dir");

    String IMAGE_PATH = "src/test/upload_data/";

}
