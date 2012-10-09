package org.urbandaddy.helpers;

//import org.openqa.selenium.By;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.HasInputDevices;
//import org.openqa.selenium.Mouse;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.internal.Coordinates;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

//import com.urbandaddy.testsuite.helpers.comm.IHelper_Client;
//import com.urbandaddy.testsuite.locators.LocatorReader;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

//import java.util.List;



public class ResetEmailHelper_Client extends IHelper_Client {
	
	private String domain = "https://qa.urbandaddy.com";

	private LocatorReader resetEmailReader;
	
	public ResetEmailHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub	
		resetEmailReader = new LocatorReader("UD_ResetPassword.xml");
	}
	
	public void enterNewPassword(String emailAdress){
		
		String str = resetEmailReader.getLocator("Reset.NewPassword");		
		this.WaitForElementPresent(str, 20);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(emailAdress);
	}
	
	public void confirmNewPassword(String password){
		String str = resetEmailReader.getLocator("Reset.ConfirmNewPassword");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(password);
	}
	
	public void clickSubmit(){
		String str = resetEmailReader.getLocator("Reset.Submit");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}

	
}
