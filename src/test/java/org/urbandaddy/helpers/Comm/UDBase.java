package org.urbandaddy.helpers.Comm;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: sargenziano
 * Date: 10/16/12
 * Time: 4:05 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UDBase {

    String UD_DOMAIN = "http://ud-branch.thedaddy.co";
    String UD_ADMIN_DOMAIN = "http://ud-branch.thedaddy.co/admin.php";
    String PERKS_DOMAIN = "http://perks-branch.thedaddy.co";

    String GOOGLE_EMAIL_LINK = "https://mail.google.com/mail/u/0/?logout&hl=en";
    String JENKINSEMAIL = "udtesterjenkins@gmail.com";
    String JENKINSEMAILPW = "commonud";

    //String UDcity = "";
    //String UDcityPerks = "";
    String PASSWORD="12345";
    String NEW_PASSWORD="1234";
    //String lastURL = "";

    String CUR_DIR = System.getProperty("user.dir");

    String IMAGE_PATH = CUR_DIR + "/src/test/upload_data/";

}
