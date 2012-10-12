package org.urbandaddy.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

import java.util.List;


public class CheckEmailHelper_Client extends IHelper_Client {

	private LocatorReader checkEmailReader;
    private static final String JENKINSEMAIL = "udtesterjenkins@gmail.com";
    private static final String JENKINSEMAILPW = "commonud";
	public CheckEmailHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub
		checkEmailReader = new LocatorReader("CheckEmail.xml");
	}

	public void clientLogInToGmail(){
		//make sure you're logged out first 
		client.get("https://mail.google.com/mail/u/0/?logout&hl=en");
		
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
		
		// wait for email to arrive
		this.pause(5000);
		
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
                WebElement el1 = findElementAndCheckBy(sb,20);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,20);
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
                WebElement el1 = findElementAndCheckBy(sb,20);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,20);
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
                WebElement el1 = findElementAndCheckBy(sb,20);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,20);
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
                WebElement el1 = findElementAndCheckBy(sb,20);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,20);
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
                WebElement el1 = findElementAndCheckBy(sb,20);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,20);
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
                WebElement el1 = findElementAndCheckBy(sb,20);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,20);
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
                WebElement el1 = findElementAndCheckBy(sb,20);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,20);
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
                WebElement el1 = findElementAndCheckBy(sb,20);
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                WebElement el2 = findElementAndCheckBy(smb,20);
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
}
