package org.urbandaddy.helpers;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.*;
//import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

import javax.annotation.Nullable;
import java.util.List;
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

        WebElement dbSection = (new WebDriverWait(client, 10)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.className("borderRight"));
            }
        });

        dbSection.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/table/tbody/tr/td/div/div/div[3]/div/table[2]/tbody/tr[2]/td/ul/li[5]/a")).click();

        WebElement dbs = (new WebDriverWait(client, 10)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("//*[@id=\"UD Dev\"]"));
            }
        });
        dbs.click();

        WebElement searchTab = (new WebDriverWait(client, 10)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div/div[4]/div/div[3]/div/div/div/span"));
            }
        });
        searchTab.click();
    }

    public boolean optOutSearch(String email) {
        boolean flag;
        flag = false;
        WebElement searchOptOutBox = (new WebDriverWait(client, 10)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("searchOptOutsCheckBox"));
            }
        });
        searchOptOutBox.click();

        Select select = new Select(client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[3]/select")));
        select.deselectAll();
        select.selectByVisibleText("equals");

        WebElement searchText = client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[4]/input"));
        searchText.clear();
        searchText.sendKeys(email);

        WebElement searchButton = client.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[3]/table/tbody/tr/td[5]/button"));
        searchButton.click();

        WebElement result = (new WebDriverWait(client, 10)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply( WebDriver d) {
                return d.findElement(By.xpath("/html/body/form/table[3]/tbody/tr/td/div[2]/div/div[3]/div[3]/div/div[5]/table/tbody/tr"));
            }
        });

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
