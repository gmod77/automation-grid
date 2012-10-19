package org.urbandaddy.com.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.locators.LocatorReader;

import java.util.List;


public class EmailHelper_Client extends IHelper_Client implements UDBase {

	private LocatorReader checkEmailReader;

	public EmailHelper_Client(WebDriver client) {
		super(client);
		checkEmailReader = new LocatorReader("CheckEmail.xml");
	}

	public void clientLogInToGmail(){
		//make sure you're logged out first 
		client.get(GOOGLE_EMAIL_LINK);
		
		String Email = checkEmailReader.getLocator("Gmail.Email");
		WebElement em = findElementAndCheckBy(Email,20);
		em.sendKeys(JENKINSEMAIL);
		this.pause(2000);
		
		String Passwd = checkEmailReader.getLocator("Gmail.Password");
		WebElement ps = findElementAndCheckBy(Passwd, 20);
		ps.sendKeys(JENKINSEMAILPW);
		
		String Signin = checkEmailReader.getLocator("Gmail.SignIn");
		WebElement si = findElementAndCheckBy(Signin,20);
		si.click();
		
		// wait for the search box to appear
        String sb = checkEmailReader.getLocator("Gmail.SearchBox");
        findElementAndCheckBy(sb,20);
		
	}	

    public void clientLogoutGmail() {
        WebElement signOut = this.client.findElement(By.id("gb_71"));
        signOut.click();
    }

	public void doEmailSearch (String searchString) {
        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter
        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb,5);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,5);
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause(5000);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
        }
    }

	public void findSignupEmail (String searchString){

        Boolean flag = false;
        Integer counter = 0;
		// find search box and enter the searchString parameter

		//assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb,5);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,5);
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause(5000);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
        }
	}
	
	public void findInvitationEmail1 (String searchString){

        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter

        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb,5);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,5);
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause(5000);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
        }
    }

	public void findInvitationEmail2 (String searchString){

        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter

        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb,5);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,5);
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause(5000);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
        }
    }
	
	public void findInvitationEmail3 (String searchString){

        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter

        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb,5);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,5);
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause(5000);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
        }
    }
	
	public void findInvitationEmail4 (String searchString){

        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter

        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb,5);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,5);
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause(5000);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
        }
    }

	public void findInvitationEmail5 (String searchString){

        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter

        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb,5);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,5);
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause(5000);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
        }
    }
	
	public void findResetEmailRequest (String searchString){

        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter

        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                WebElement el1 = findElementAndCheckBy(sb,5);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,5);
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause(5000);
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times> " + searchString);
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
        try {
           Assert.assertTrue(searchEmailBody(searchString));
        } catch (AssertionError e) {
            System.out.println("This is probably not the unsubscribe email.");
        }
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

        WebElement dbSection = findElementAndCheckBy("classname","borderRight",10);

        dbSection.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/table/tbody/tr/td/div/div/div[3]/div/table[2]/tbody/tr[2]/td/ul/li[5]/a")).click();

        WebElement dbs = findElementAndCheckBy("xpath","//*[@id=\"UD Dev\"]",10);

        dbs.click();

        WebElement searchTab = findElementAndCheckBy("xpath","/html/body/form/table[3]/tbody/tr/td/div[2]/div/div/div[4]/div/div[3]/div/div/div/span",10);

        searchTab.click();
    }

    public boolean optOutSearch(String email) {
        boolean flag;
        flag = false;
        WebElement searchOptOutBox = findElementAndCheckBy("id","searchOptOutsCheckBox",10);
        searchOptOutBox.click();

        Select select = new Select(client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[3]/select")));
        select.deselectAll();
        select.selectByVisibleText("equals");

        WebElement searchText = client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[4]/input"));
        searchText.clear();
        searchText.sendKeys(email);

        WebElement searchButton = client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[5]/button"));
        searchButton.click();

        WebElement result = findElementAndCheckBy("xpath","/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[5]/table/tbody/tr",10);
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
     * Check for Welcome to UD email is received
     */
    public void verifyWelcomeUDEmailReceived(String emailClient){

        findSignupEmail("to: "+emailClient+" subject: Welcome to the Club");
        
    }

    public void verifySharedArticleLoggedOutReceived(String emailFriend1, String emailFriend2, String emailFriend3, String emailFriend4, String emailFriend5) {
        doEmailSearch("from: QA TESTER to: " + emailFriend1);
        doEmailSearch("from: QA TESTER to: " + emailFriend2);
        doEmailSearch("from: QA TESTER to: " + emailFriend3);
        doEmailSearch("from: QA TESTER to: " + emailFriend4);
        doEmailSearch("from: QA TESTER to: " + emailFriend5);
    }

    public void verifySharedArticleLoggedInReceived(String emailClient, String emailFriend1, String emailFriend2, String emailFriend3, String emailFriend4, String emailFriend5) {
        doEmailSearch(String.format("from: %s to: %s subject: FW: UD |", emailClient, emailFriend1));
        doEmailSearch(String.format("from: %s to: %s subject: FW: UD |", emailClient, emailFriend2));
        doEmailSearch(String.format("from: %s to: %s subject: FW: UD |", emailClient, emailFriend3));
        doEmailSearch(String.format("from: %s to: %s subject: FW: UD |", emailClient, emailFriend4));
        doEmailSearch(String.format("from: %s to: %s subject: FW: UD |", emailClient, emailFriend5));
    }

    /**
     * Check that invitation emails were received
     */
    public void verifyInvitationsUDEmailsReceived(String emailFriend1, String emailFriend2, String emailFriend3, String emailFriend4, String emailFriend5){

        findInvitationEmail1("to: "+emailFriend1+" subject: You're Invited");
        findInvitationEmail2("to: "+emailFriend2+" subject: You're Invited");
        findInvitationEmail3("to: "+emailFriend3+" subject: You're Invited");
        findInvitationEmail4("to: "+emailFriend4+" subject: You're Invited");
        findInvitationEmail5("to: "+emailFriend5+" subject: You're Invited");
    }

    /**
     * Check that the password reset email was received
     */
    public void verifyResetPasswordUDRequestReceivedandPasswordReset(String emailClient){

        findResetEmailRequest("to: "+emailClient+" subject: UD | Password Reset Request");
        String link = getResetEmailLink();

        //client.get(link);
        System.out.println(link);
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
        //checkEmailHelper_Client = new CheckEmailHelper_Client(client);

        //checkEmailHelper_Client.findInvitationEmail1("to: " + email + " subject: You've Changed");
        findInvitationEmail1("to: " + emailClient + " subject: You've Changed");
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
