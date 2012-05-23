package org.urbandaddy.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;
//import org.openqa.selenium.interactions.*;

public class CheckEmailHelper_Client extends IHelper_Client {

	private LocatorReader checkEmailReader;
	private String UDdomain = "http://ud-branch.thedaddy.co";

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
		em.sendKeys("udtestergene@gmail.com");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		String Passwd = checkEmailReader.getLocator("Gmail.Password");
		this.WaitForElementPresent(Passwd, 20);
		WebElement ps = client.findElement(ByLocator(Passwd));
		ps.sendKeys("commonud");
		
		String Signin = checkEmailReader.getLocator("Gmail.SignIn");
		this.WaitForElementPresent(Signin, 20);
		WebElement si = client.findElement(ByLocator(Signin));
		si.click();
		
		// wait for email to arrive
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// refresh
		client.navigate().refresh();
		//switch to HTML view
		this.client.navigate().to("https://mail.google.com/mail/?ui=html&zy=h");
		
	}	
	
	
	
	public void findSignupEmail (String searchString){
		
		// find search box and enter the searchString parameter
		String sb = checkEmailReader.getLocator("Gmail.SearchBox");		
		this.WaitForElementPresent(sb, 20);		
		WebElement el1 = client.findElement(ByLocator(sb));
		el1.sendKeys(searchString);
		
		//find search mail button and click it
		String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");		
		this.WaitForElementPresent(smb, 20);		
		WebElement el2 = client.findElement(ByLocator(smb));
		el2.click();
		
		//assuming the single correct result came back, click that email
		
//		WebElement emailtitle = client.findElement(By.cssSelector("span.ts"));
//		emailtitle.getAttribute("value");
		client.findElement(By.cssSelector("span.ts")).click();  
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//do some checks
		
//		//click "Confrim My Account" button inside email
//		String confirmationEmail = client.findElement(By.partialLinkText("https://www.qa.urbandaddy.com/user/confirm_account/")).getText(); 
//		
//		//grab confirmation code from link
//	    String[] separated = confirmationEmail.split("/");
//	    String confirmationCode = separated[separated.length - 1];
//	    
//		String confirmationURL = domain+"/user/confirm_account/"+ confirmationCode; 
//		client.navigate().to(confirmationURL);
//		
		//String em = checkEmailReader.getLocator("Gmail.Email");		
		//this.WaitForElementPresent(em, 20);		
		//WebElement el3 = client.findElement(ByLocator(em));
		//el3.click();
		
	}
	
	public void findInvitationEmail1 (String searchString){
		
		// find search box and enter the searchString parameter
		
		String sb = checkEmailReader.getLocator("Gmail.SearchBox");		
		this.WaitForElementPresent(sb, 20);		
		WebElement el1 = client.findElement(ByLocator(sb));
		el1.clear();
		el1.sendKeys(searchString);
		
		//find search mail button and click it
		String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");		
		this.WaitForElementPresent(smb, 20);		
		WebElement el2 = client.findElement(ByLocator(smb));
		el2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assuming the single correct result came back, click that email
		
//		WebElement emailtitle = client.findElement(By.cssSelector("span.ts"));
//		emailtitle.getAttribute("value");
		client.findElement(By.cssSelector("span.ts")).click(); 	
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findInvitationEmail2 (String searchString){
		
		// find search box and enter the searchString parameter
		
		String sb = checkEmailReader.getLocator("Gmail.SearchBox");		
		this.WaitForElementPresent(sb, 20);		
		WebElement el1 = client.findElement(ByLocator(sb));
		el1.clear();
		el1.sendKeys(searchString);
		
		//find search mail button and click it
		String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");		
		this.WaitForElementPresent(smb, 20);		
		WebElement el2 = client.findElement(ByLocator(smb));
		el2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assuming the single correct result came back, click that email
		
//		WebElement emailtitle = client.findElement(By.cssSelector("span.ts"));
//		emailtitle.getAttribute("value");
		client.findElement(By.cssSelector("span.ts")).click(); 	
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findInvitationEmail3 (String searchString){
		
		// find search box and enter the searchString parameter

		String sb = checkEmailReader.getLocator("Gmail.SearchBox");		
		this.WaitForElementPresent(sb, 20);		
		WebElement el1 = client.findElement(ByLocator(sb));
		el1.clear();
		el1.sendKeys(searchString);
		
		//find search mail button and click it
		String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");		
		this.WaitForElementPresent(smb, 20);		
		WebElement el2 = client.findElement(ByLocator(smb));
		el2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assuming the single correct result came back, click that email
		
//		WebElement emailtitle = client.findElement(By.cssSelector("span.ts"));
//		emailtitle.getAttribute("value");
		client.findElement(By.cssSelector("span.ts")).click(); 	
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findInvitationEmail4 (String searchString){
		
		// find search box and enter the searchString parameter

		String sb = checkEmailReader.getLocator("Gmail.SearchBox");		
		this.WaitForElementPresent(sb, 20);		
		WebElement el1 = client.findElement(ByLocator(sb));
		el1.clear();
		el1.sendKeys(searchString);
		
		//find search mail button and click it
		String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");		
		this.WaitForElementPresent(smb, 20);		
		WebElement el2 = client.findElement(ByLocator(smb));
		el2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assuming the single correct result came back, click that email
		
//		WebElement emailtitle = client.findElement(By.cssSelector("span.ts"));
//		emailtitle.getAttribute("value");
		client.findElement(By.cssSelector("span.ts")).click(); 
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findInvitationEmail5 (String searchString){
		
		// find search box and enter the searchString parameter
	
		String sb = checkEmailReader.getLocator("Gmail.SearchBox");		
		this.WaitForElementPresent(sb, 20);		
		WebElement el1 = client.findElement(ByLocator(sb));
		el1.clear();
		el1.sendKeys(searchString);
		
		//find search mail button and click it
		String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");		
		this.WaitForElementPresent(smb, 20);		
		WebElement el2 = client.findElement(ByLocator(smb));
		
		el2.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//assuming the single correct result came back, click that email
		
//		WebElement emailtitle = client.findElement(By.cssSelector("span.ts"));
//		emailtitle.getAttribute("value");
		client.findElement(By.cssSelector("span.ts")).click(); 
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findResetEmailRequest (String searchString){
		// find search box and enter the searchString parameter
		String sb = checkEmailReader.getLocator("Gmail.SearchBox");		
		this.WaitForElementPresent(sb, 20);		
		WebElement el1 = client.findElement(ByLocator(sb));
		el1.clear();
		el1.sendKeys(searchString);
		
		//find search mail button and click it
		String smb = checkEmailReader.getLocator("Gmail.SearchMailButton");		
		this.WaitForElementPresent(smb, 20);		
		WebElement el2 = client.findElement(ByLocator(smb));
		el2.click();
		
		//assuming the single correct result came back, click that email
		
//		WebElement emailtitle = client.findElement(By.cssSelector("span.ts"));
//		emailtitle.getAttribute("value");
		client.findElement(By.cssSelector("span.ts")).click();  
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickResetEmailRequestLink (){
		client.findElement(By.partialLinkText("here")).click(); 

	}
}
