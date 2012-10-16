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
    Date now = new java.util.Date();
    java.text.DateFormat emailFormat = new java.text.SimpleDateFormat("DDD_HH_mm_SSS");

    String emailClient = "udtesterjenkins+"+emailFormat.format(now) + "@gmail.com";
    String emailFriend1 = "udtesterjenkins+"+"friend_1_"+emailFormat.format(now) + "@gmail.com";
    String emailFriend2 = "udtesterjenkins+"+"friend_2_"+emailFormat.format(now) + "@gmail.com";
    String emailFriend3 = "udtesterjenkins+"+"friend_3_"+emailFormat.format(now) + "@gmail.com";
    String emailFriend4 = "udtesterjenkins+"+"friend_4_"+emailFormat.format(now) + "@gmail.com";
    String emailFriend5 = "udtesterjenkins+"+"friend_5_"+emailFormat.format(now) + "@gmail.com";

    String membersource = "Member Source "+emailFormat.format(now);

    String UDdomain = "http://ud-branch.thedaddy.co";
    String UD_Admin_domain = "http://ud-branch.thedaddy.co/admin.php";
    String Perksdomain = "http://perks-branch.thedaddy.co";

    //String UDcity = "";
    //String UDcityPerks = "";
    String password="12345";
    String newpassword="1234";
    //String lastURL = "";

    String curDir = System.getProperty("user.dir");

    String returnImgPath();
}
