package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class Manero_LoginHelper_Client extends IHelper_Client {

	private LocatorReader sealReader;

	public Manero_LoginHelper_Client(WebDriver client) {
		super(client);
		sealReader = new LocatorReader("Manero_Login.xml");
	}
	
	public void enterEmailAddress(String emailAdress){
		String str = sealReader.getLocator("Signon.EmailAddress");
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(emailAdress);
	}
	
	public void enterPassword(String password){
		String str = sealReader.getLocator("Signon.Password");
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(password);
	}
	
	public void clickLogin(){
		String str = sealReader.getLocator("Signon.Login");
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void clickResetPassword(){
		String str = sealReader.getLocator("Signon.ResetPasswordLink");
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void enterEmailToReset(String emailAdress){
		String str = sealReader.getLocator("ResetPassword.ResetEmail");
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(emailAdress);
	}
	
	public void clickSend(){
		String str = sealReader.getLocator("ResetPassword.Send");
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}

    public void clickResetCancel(){
        String str = sealReader.getLocator("ResetPassword.Cancel");
        WebElement el = findElementAndCheckBy(str);
        el.click();
    }

	
	///Edit Settings
	
	public void clickEditSettings(){
		String str = sealReader.getLocator("Settings.EditSettings");
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}

    public void editEmail(){
        String str = sealReader.getLocator("Settings.EditEmail");
        WebElement el = findElementAndCheckBy(str);
        el.click();
    }

	public void editPassword(String password){
		
		String str = sealReader.getLocator("Settings.EditPassword");
		WebElement el = findElementAndCheckBy(str,20);
		el.sendKeys(password);
	}
	
	public void confirmPassword(String password){
		
		String str = sealReader.getLocator("Settings.ConfirmPassword");
		WebElement el = findElementAndCheckBy(str,20);
		el.sendKeys(password);
	}

	public void checkEditionChicago(){
		String str = sealReader.getLocator("Settings.EditionChicago");
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}

    public void checkEditionMiami(){
        String str = sealReader.getLocator("Settings.EditionMiami");
        WebElement el = findElementAndCheckBy(str);
        el.click();
    }
    public void checkEditionNewYork(){
        String str = sealReader.getLocator("Settings.EditionNewYork");
        WebElement el = findElementAndCheckBy(str);
        el.click();
    }
    public void checkEditionLA(){
        String str = sealReader.getLocator("Settings.EditionLA");
        WebElement el = findElementAndCheckBy(str);
        el.click();
    }
    public void checkEditionNational(){
        String str = sealReader.getLocator("Settings.EditionNational");
        WebElement el = findElementAndCheckBy(str);
        el.click();
    }
    public void checkEditionHouston(){
        String str = sealReader.getLocator("Settings.EditionHouston");
        WebElement el = findElementAndCheckBy(str);
        el.click();
    }
	public void clickUpdate(){
		String str = sealReader.getLocator("Settings.Update");
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}

    public WebElement checkMessageBox() {
        String str = sealReader.getLocator("Settings.MessageBox");
        return findElementAndCheckBy(str);
    }

	public void clickClose(){
		String str = sealReader.getLocator("Settings.Close");
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}

}
