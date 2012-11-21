package org.urbandaddy.com.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.locators.LocatorReader;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class EmailHelper_Client extends IHelper_Client implements UDBase {

    private int emailTimeOut = 15000; //Timeout in MS for retrying emails
    private int globalTimeOut = 10; //Timeout in SEC for finding elements
    
	private LocatorReader checkEmailReader;

	public EmailHelper_Client(WebDriver client) {
		super(client);
		checkEmailReader = new LocatorReader("CheckEmail.xml");
	}

    public String generateDate(String dateFormat) {
        //    DDD_HH_mm_SSS <-- should pass this format
        Date now = new java.util.Date();
        DateFormat df = new SimpleDateFormat(dateFormat);
        return df.format(now);
    }

    public String generateEmailClient(String dateSet) {
        String client = EMAIL_USER_NAME + "+"+ dateSet + EMAIL_DOMAIN;
        return client;
    }

    public String[] generateFriendClient(int count, String dateSet) {
        if (count > 5) {
            count = 5;
            System.out.println("Count set over 5, max is 5.");
        }
        String[] arr = new String[count];
        for (int i = 0; i<count; i++) {
            arr[i] = EMAIL_USER_NAME + "+friend_" + (i+1) + "_" + dateSet + EMAIL_DOMAIN;
        }
        return arr;
    }

	public void clientLogInToGmail(){
		//make sure you're logged out first 
		client.get(GOOGLE_EMAIL_LINK);
		
		String Email = checkEmailReader.getLocator("Gmail.Email");
		WebElement em = findElementAndCheckBy(Email, globalTimeOut);
		em.sendKeys(JENKINSEMAIL);
		this.pause(2000);
		
		String Passwd = checkEmailReader.getLocator("Gmail.Password");
		WebElement ps = findElementAndCheckBy(Passwd, globalTimeOut);
		ps.sendKeys(JENKINSEMAILPW);
		
		String Signin = checkEmailReader.getLocator("Gmail.SignIn");
		WebElement si = findElementAndCheckBy(Signin, globalTimeOut);
		si.click();
		
		// wait for the search box to appear
        String sb = checkEmailReader.getLocator("Gmail.SearchBox");
        findElementAndCheckBy(sb, globalTimeOut);
		
	}	

    public void clientLogoutGmail() {
        WebElement signOut = this.client.findElement(By.id("gb_71"));
        signOut.click();
    }

	public boolean doEmailSearch (String searchString, int timeout) {
        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter
        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb, globalTimeOut);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                findElementAndCheckBy(smb).click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again. Time out in> " + TimeUnit.MILLISECONDS.toSeconds(timeout) +" seconds.");
                pause(timeout);
            } catch (StaleElementReferenceException sere) {
                counter++;
                System.out.println("Stale Element Reference");
                System.out.println("Email wasn't found, trying again. Time out in> " + TimeUnit.MILLISECONDS.toSeconds(timeout) +" seconds.");
                pause(timeout);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
            return false;
        } else {
            return true;
        }
    }

    public String getResetEmailLink () {
        WebElement link = client.findElement(By.partialLinkText("here"));
        return link.getAttribute("href");
    }

	public void clickResetEmailRequestLink (){
		client.findElement(By.partialLinkText("here")).click(); 

	}

    public boolean searchEmailBody (String searchString) {
        WebElement content = client.findElement(By.className("msg"));
        String data = content.getText();
        return (data.contains(searchString));
    }

    public void searchEmail(String searchString) {
           Assert.assertTrue(searchEmailBody(searchString),"Text or email not found.");
    }

    public void silverPopLogin(String email, String pass) {
        client.navigate().to("https://login5.silverpop.com/");
        WebElement username = client.findElement(By.id("username"));
        username.sendKeys(email);
        WebElement password = client.findElement(By.id("password"));
        password.sendKeys(pass);
        WebElement login = client.findElement(By.className("button"));
        login.click();
    }

    public void navigateToSearch() {

        WebElement dbSection = findElementAndCheckBy("classname","borderRight", globalTimeOut);
        dbSection.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/table/tbody/tr/td/div/div/div[3]/div/table[2]/tbody/tr[2]/td/ul/li[5]/a")).click();
        WebElement dbs = findElementAndCheckBy("xpath","//*[@id=\"UD Dev\"]", globalTimeOut);
        dbs.click();
        WebElement searchTab = findElementAndCheckBy("xpath","/html/body/form/table[3]/tbody/tr/td/div[2]/div/div/div[4]/div/div[3]/div/div/div/span", globalTimeOut);
        searchTab.click();
    }

    public boolean optOutSearch(String email) {
        boolean flag;
        flag = false;
        WebElement searchOptOutBox = findElementAndCheckBy("id","searchOptOutsCheckBox", globalTimeOut);
        searchOptOutBox.click();

        Select select = new Select(client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[3]/select")));
        select.deselectAll();
        select.selectByVisibleText("equals");

        WebElement searchText = client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[4]/input"));
        searchText.clear();
        searchText.sendKeys(email);

        WebElement searchButton = client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[5]/button"));
        searchButton.click();

        WebElement result = findElementAndCheckBy("xpath","/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[5]/table/tbody/tr", globalTimeOut);
        List<WebElement> columns = result.findElements(By.tagName("td"));

        for (WebElement column : columns) {
            if (column.getText().equals("Opted Out")) {
                flag = true;
                break;
            }
        }
        return flag;
    }


    // Global Email Check Methods

    /**
     * Log into Gmail and wait
     */
    public void loginToGmail(){

        clientLogInToGmail();

    }

    /**
     * Check for Welcome to Manero email is received
     */
    public void verifyWelcomeManeroEmailReceived(String emailClient){
        Reporter.log("Searching for Welcome Email",true);
        doEmailSearch("to: " + emailClient + " subject: We Embrace You", emailTimeOut);
    }

    /**
     * Check that invitation emails were received
     */
    public void verifyInvitationsManeroEmailsReceived(String[] friends){
        for (int i = 0; i<friends.length; i++) {
            Reporter.log("Searching for invitation email to friend " + (i+1),true);
            doEmailSearch("to: "+ friends[i]+" subject: You've been invited to join Manero Club Social y Deportivo", emailTimeOut);
        }
    }

    /**
     * Check for Welcome to UD email is received
     */
    public void verifyWelcomeUDEmailReceived(String emailClient){
        Reporter.log("Searching for Welcome Email",true);
        doEmailSearch("to: " + emailClient + " subject: Welcome to the Club", emailTimeOut);

    }

    public void verifySharedArticleLoggedOutReceived(String[] emailFriends) {
        for (int i = 0; i<emailFriends.length; i++) {
            Reporter.log("Logged out test: Searching for Shared article to friend " + (i+1),true);
            doEmailSearch("from: QA TESTER to: " + emailFriends[i], emailTimeOut);
        }

    }

    public void verifySharedArticleLoggedInReceived(String emailClient, String[] emailFriends) {
        for (int i = 0; i<emailFriends.length; i++) {
            Reporter.log("Logged in test: Searching for Shared article to friend " + (i+1),true);
            doEmailSearch(String.format("from: %s to: %s subject: FW: UD |", emailClient, emailFriends[i]), emailTimeOut);
        }
    }

    /**
     * Check that invitation emails were received
     */
    public void verifyInvitationsUDEmailsReceived(String[] friends){
        for (int i = 0; i<friends.length; i++) {
            Reporter.log("Searching for invitation email to friend " + (i+1),true);
            doEmailSearch("to: "+ friends[i]+" subject: You're Invited", emailTimeOut);
        }
    }

    /**
     * Check that the password reset email was received
     */
    public void verifyResetPasswordUDRequestReceivedandPasswordReset(String emailClient){
        Reporter.log("Searching for password reset link",true);
        if (doEmailSearch("to: "+emailClient+" subject: UD | Password Reset Request", emailTimeOut)) {
            String link = getResetEmailLink();
            System.out.println(link);
        } else {
            Reporter.log("WARNING: Password Reset Email wasn't received in time.",true);
        }
        //client.get(link);
        //  checkEmailHelper_Client.clickResetEmailRequestLink();
//        	resetEmailHelper_Client.enterNewPassword(newpassword);
//        	resetEmailHelper_Client.confirmNewPassword(newpassword);
//        	resetEmailHelper_Client.clickSubmit();
//        	Assert.assertTrue(sealHelper_Client.isSignedIn());
    }

    /**
     * Check that the edit settings email is received
     *
     * @param emailClient Enter email to search with
     */
    public void verifyEditSettingsUDEmailReceived(String emailClient){
        Reporter.log("Searching for account settings change mail",true);
        doEmailSearch("to: " + emailClient + " subject: You've Changed", emailTimeOut);
    }

    /**
     * Log out of Gmail
     */
    public void logoutGmail() {
        //checkEmailHelper_Client = new CheckEmailHelper_Client(client);
        //checkEmailHelper_Client.clientLogoutGmail();
        clientLogoutGmail();
    }




}
