package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class UD_SealHelper_Client extends IHelper_Client {

	private LocatorReader sealReader;
	
	public UD_SealHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub
		
		sealReader = new LocatorReader("Seal.xml");
	}
	
//	public void clickMemberLogIn(){
//		String str = sealReader.getLocator("Signon.HeaderLoginLink");
//		//this.WaitForElementPresent(str, 20);
//		WebElement el = findElementAndCheckBy(str);
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
		////this.WaitForElementPresent(str, 20);		
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(emailAdress);
	}
	
	public void enterPassword(String password){
		String str = sealReader.getLocator("Signon.Password");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(password);
	}
	
	public void clickLogin(){
		String str = sealReader.getLocator("Signon.Login");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void clickResetPassword(){
		String str = sealReader.getLocator("Signon.ResetPasswordLinkSub");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void enterEmailToReset(String emailAdress){
		
		String str = sealReader.getLocator("ResetPassword.ResetEmailSub");		
		//this.WaitForElementPresent(str, 20);		
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(emailAdress);
	}
	
	public void clickSend(){
		String str = sealReader.getLocator("ResetPassword.SendSub");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public boolean isSignedIn(){
		String str = sealReader.getLocator("ResetPassword.Send");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);

		if (el.isDisplayed())
			return true;
		return false;
			
	}
	
	///Edit Settings
	
	public void clickEditSettings(){
		String str = sealReader.getLocator("Settings.EditSettings");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void enterPasswordMyUD(String password){
		
		String str = sealReader.getLocator("Settings.PasswordMyUD");		
		//this.WaitForElementPresent(str, 20);		
		WebElement el = findElementAndCheckBy(str,20);
		el.sendKeys(password);
	}
	
	public void confirmPasswordMyUD(String password){
		
		String str = sealReader.getLocator("Settings.PasswordConfirmMyUD");		
		//this.WaitForElementPresent(str, 20);		
		WebElement el = findElementAndCheckBy(str,20);
		el.sendKeys(password);
	}

    /**
     * Maybe use this guy to clean up the code a bit
     * probably no reason to have a method for each checkbox.
     * Just send the parameter to check.
     *
     * @param check
     */
    public void boxChecker(String check) {
        String str = sealReader.getLocator(check);
        //this.WaitForElementVisible(str, 100);
        WebElement el = findElementAndCheckBy(str);
        el.click();
    }

	public void checkDC(){
		String str = sealReader.getLocator("Settings.EditionsDC");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void checkPhilly(){
		String str = sealReader.getLocator("Settings.EditionsPhilly");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void checkSeattle(){
		String str = sealReader.getLocator("Settings.EditionsSeattle");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void checkDCPerks(){
		String str = sealReader.getLocator("Settings.PerksDC");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void clickUpdate(){
		String str = sealReader.getLocator("Settings.Update");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void clickClose(){
		String str = sealReader.getLocator("Settings.Close");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	
	
}
