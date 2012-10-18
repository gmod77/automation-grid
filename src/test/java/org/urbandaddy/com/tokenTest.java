package org.urbandaddy.com;



import static org.urbandaddy.com.helpers.HMacHelper.tokenGenerate;

/**
 * Created with IntelliJ IDEA.
 * User: sargenziano
 * Date: 10/11/12
 * Time: 7:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class tokenTest {
    public static void main(String args []) throws Exception{
        String username = "sargenziano";
        String key = "c4ccd226-57b5-47f8-bab4-62b1801ff59b";
        String jobId = "5f9fef27854ca50a3c132ce331cb6034";
        String message = username + ":" + key;

        String token = tokenGenerate(message, jobId);

        System.out.println(token);
    }
}
