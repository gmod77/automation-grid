package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class Perks_SealHelper_Client extends IHelper_Client {

	private LocatorReader sealReader;
	
	public Perks_SealHelper_Client(WebDriver client) {
		super(client);

		sealReader = new LocatorReader("Seal.xml");
	}
	
//	public void clickMemberLogIn(){
//		String str = sealReader.getLocator("Signon.HeaderLoginLink");
//		this.WaitForElementPresent(str, 20);
//		WebElement el = client.findElement(ByLocator(str));
//		el.click();
//		
//		try {
//			Thread.sleep(3000);
//			} catch (InterruptedException e) {
//			e.printStackTrace();
//				}
//	}
	
	public void enterEmailAddress(String emailAdress){
		
		String str = sealReader.getLocator("Signon.EmailAddress");
        WebElement el = findElementAndCheckBy(str,20);
        el.clear();
		el.sendKeys(emailAdress);
	}
	
	public void enterPassword(String password){
		String str = sealReader.getLocator("Signon.Password");
        WebElement el = findElementAndCheckBy(str,20);
		el.clear();
		el.sendKeys(password);
	}
	
	public void clickLogin(){
		String str = sealReader.getLocator("Signon.Login");
        WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}
	
	public void clickResetPassword(){
		String str = sealReader.getLocator("Signon.ResetPasswordLinkSub");
        WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}
	
	public void enterEmailToReset(String emailAdress){
		
		String str = sealReader.getLocator("ResetPassword.ResetEmailSub");		
        WebElement el = findElementAndCheckBy(str,20);
		el.clear();
		el.sendKeys(emailAdress);
	}
	
	public void clickSend(){
		String str = sealReader.getLocator("ResetPassword.SendSub");
        WebElement el = findElementAndCheckBy(str,20);
		el.click();
	}
	
	public boolean isSignedIn(){
		String str = sealReader.getLocator("ResetPassword.Send");
        WebElement el = findElementAndCheckBy(str,20);

		if (el.isDisplayed())
			return true;
		return false;
			
	}
}
