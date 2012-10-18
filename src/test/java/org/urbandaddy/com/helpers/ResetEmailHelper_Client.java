package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

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
		WebElement el = findElementAndCheckBy(str,20);
		el.clear();
		el.sendKeys(emailAdress);
	}
	
	public void confirmNewPassword(String password){
		String str = resetEmailReader.getLocator("Reset.ConfirmNewPassword");
		WebElement el = findElementAndCheckBy(str,20);
		el.clear();
		el.sendKeys(password);
	}
	
	public void clickSubmit(){
		String str = resetEmailReader.getLocator("Reset.Submit");
		WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}

	
}
