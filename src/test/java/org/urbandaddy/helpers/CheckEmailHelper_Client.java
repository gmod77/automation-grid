package org.urbandaddy.helpers;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import org.openqa.selenium.*;
//import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;
//import org.openqa.selenium.interactions.*;

public class CheckEmailHelper_Client extends IHelper_Client {

	private LocatorReader checkEmailReader;

	public void pause1(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pause2(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CheckEmailHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub
		checkEmailReader = new LocatorReader("CheckEmail.xml");
	}

	public void clientLogInToGmail(){
		//make sure you're logged out first 
		this.client.navigate().to("https://mail.google.com/mail/u/0/?logout&hl=en");
		
		String Email = checkEmailReader.getLocator("Gmail.Email");		
		this.WaitForElementPresent(Email, 20);		
		WebElement em = client.findElement(ByLocator(Email));
		em.sendKeys("udtesterjenkins@gmail.com");
		this.pause1();
		
		String Passwd = checkEmailReader.getLocator("Gmail.Password");
		this.WaitForElementPresent(Passwd, 20);
		WebElement ps = client.findElement(ByLocator(Passwd));
		ps.sendKeys("commonud");
		
		String Signin = checkEmailReader.getLocator("Gmail.SignIn");
		this.WaitForElementPresent(Signin, 20);
		WebElement si = client.findElement(ByLocator(Signin));
		si.click();
		
		// wait for email to arrive
		this.pause2();
		
		// refresh
		client.navigate().refresh();
		//switch to HTML view
		//this.client.navigate().to("https://mail.google.com/mail/?ui=html&zy=h");
		
	}	
	
	public void doEmailSearch (String searchString) {
        Boolean flag = false;
        Integer counter = 0;
        // find search box and enter the searchString parameter
        //assuming the single correct result came back, click that email

        do {
            try {
                String sb = checkEmailReader.getLocator("Gmail.SearchBox");
                this.WaitForElementPresent(sb, 20);
                WebElement el1 = client.findElement(ByLocator(sb));
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                this.WaitForElementPresent(smb, 20);
                WebElement el2 = client.findElement(ByLocator(smb));
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause2();
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times");
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
                this.WaitForElementPresent(sb, 20);
                WebElement el1 = client.findElement(ByLocator(sb));
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                this.WaitForElementPresent(smb, 20);
                WebElement el2 = client.findElement(ByLocator(smb));
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause2();
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times");
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
                this.WaitForElementPresent(sb, 20);
                WebElement el1 = client.findElement(ByLocator(sb));
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                this.WaitForElementPresent(smb, 20);
                WebElement el2 = client.findElement(ByLocator(smb));
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause2();
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times");
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
                this.WaitForElementPresent(sb, 20);
                WebElement el1 = client.findElement(ByLocator(sb));
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                this.WaitForElementPresent(smb, 20);
                WebElement el2 = client.findElement(ByLocator(smb));
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause2();
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times");
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
                this.WaitForElementPresent(sb, 20);
                WebElement el1 = client.findElement(ByLocator(sb));
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                this.WaitForElementPresent(smb, 20);
                WebElement el2 = client.findElement(ByLocator(smb));
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause2();
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times");
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
                this.WaitForElementPresent(sb, 20);
                WebElement el1 = client.findElement(ByLocator(sb));
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                this.WaitForElementPresent(smb, 20);
                WebElement el2 = client.findElement(ByLocator(smb));
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause2();
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times");
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
                this.WaitForElementPresent(sb, 20);
                WebElement el1 = client.findElement(ByLocator(sb));
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                this.WaitForElementPresent(smb, 20);
                WebElement el2 = client.findElement(ByLocator(smb));
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause2();
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times");
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
                this.WaitForElementPresent(sb, 20);
                WebElement el1 = client.findElement(ByLocator(sb));
                //el1.sendKeys(searchString);
                el1.clear();
                el1.sendKeys(searchString);

                //find search mail button and click it
                String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");
                this.WaitForElementPresent(smb, 20);
                WebElement el2 = client.findElement(ByLocator(smb));
                el2.click();
                client.findElement(By.cssSelector(".ts")).click();
                flag = true;
            } catch (NoSuchElementException e) {
                counter++;
                System.out.println("Email wasn't found, trying again");
                pause2();
            }
        } while (!flag && counter<3);

        if (counter >=3) {
            System.out.println("Attempted email search 3 times");
        }
    }
	
	public void clickResetEmailRequestLink (){
		client.findElement(By.partialLinkText("here")).click(); 

	}
}
