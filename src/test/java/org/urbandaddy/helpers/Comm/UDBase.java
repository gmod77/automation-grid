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
    Date NOW = new java.util.Date();
    java.text.DateFormat EMAIL_FORMAT = new java.text.SimpleDateFormat("DDD_HH_mm_SSS");
    String generateEmailClient(String e);
    String EMAIL_CLIENT = "udtesterjenkins+"+EMAIL_FORMAT.format(NOW) + "@gmail.com";
    String EMAIL_FRIEND1 = "udtesterjenkins+"+"friend_1_"+EMAIL_FORMAT.format(NOW) + "@gmail.com";
    String EMAIL_FRIEND2 = "udtesterjenkins+"+"friend_2_"+EMAIL_FORMAT.format(NOW) + "@gmail.com";
    String EMAIL_FRIEND3 = "udtesterjenkins+"+"friend_3_"+EMAIL_FORMAT.format(NOW) + "@gmail.com";
    String EMAIL_FRIEND4 = "udtesterjenkins+"+"friend_4_"+EMAIL_FORMAT.format(NOW) + "@gmail.com";
    String EMAIL_FRIEND5 = "udtesterjenkins+"+"friend_5_"+EMAIL_FORMAT.format(NOW) + "@gmail.com";

    String MEMBER_SOURCE = "Member Source "+EMAIL_FORMAT.format(NOW);

    String UD_DOMAIN = "http://ud-branch.thedaddy.co";
    String UD_ADMIN_DOMAIN = "http://ud-branch.thedaddy.co/admin.php";
    String PERKS_DOMAIN = "http://perks-branch.thedaddy.co";

    //String UDcity = "";
    //String UDcityPerks = "";
    String PASSWORD="12345";
    String NEW_PASSWORD="1234";
    //String lastURL = "";

    String CUR_DIR = System.getProperty("user.dir");

    String IMAGE_PATH = CUR_DIR + "/src/test/upload_data/";

}
