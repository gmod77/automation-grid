package org.urbandaddy.com.common;

/**
 * Common strings used across all tests.
 *
 */
public interface UDBase {

    String UD_DOMAIN = "http://ud-branch.thedaddy.co";
    String UD_ADMIN_DOMAIN = "http://ud-branch.thedaddy.co/admin.php";
    String PERKS_DOMAIN = "http://perks-branch.thedaddy.co";

    String MANERO_DOMAIN = "http://manero-branch.thedaddy.co";

    String GOOGLE_EMAIL_LINK = "https://mail.google.com/mail/u/0/?logout&hl=en";

    String EMAIL_USER_NAME = "udtesterjenkins";
    String EMAIL_DOMAIN = "@gmail.com";
    String JENKINSEMAIL = EMAIL_USER_NAME + EMAIL_DOMAIN;
    String JENKINSEMAILPW = "commonud";

    String PASSWORD="12345";
    String NEW_PASSWORD="1234";

    String CUR_DIR = System.getProperty("user.dir");

    String IMAGE_PATH = CUR_DIR + "/src/test/upload_data/";

}
