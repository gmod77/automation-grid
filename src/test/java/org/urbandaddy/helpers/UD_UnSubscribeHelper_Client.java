package org.urbandaddy.helpers;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;


/**
 * UD_UnSubscribeHelper_Client is used in the unsubscribing
 * of perks and editorials.
 */

public class UD_UnSubscribeHelper_Client extends IHelper_Client {

	private LocatorReader signupReader;

	public UD_UnSubscribeHelper_Client(WebDriver client) {
		super(client);
		signupReader = new LocatorReader("UD_SignUp.xml");
	}

    /**
     * Use this to update the email address
     * Possible use in future tests.
     * @param email Email address
     */
	public void enterEmail(String email){
		String str = signupReader.getLocator("Step1.Email");
		WebElement el = findElementAndCheckBy(str,100);
		el.clear();
		el.sendKeys(email);
	}

    /**
     * Click the update button in the ajax lightbox
     *
     */
	public void clickUpdate(){
		String str = signupReader.getLocator("Update.UpdateButton");
		WebElement el = client.findElement(ByLocator(str));
		el.submit();
	}

    /**
     * Click the confirm button after unsubscribing
     * from all perks/editorials.
     *
     */
    public void confirmUpdate(){
        String str = signupReader.getLocator("Update.ConfirmButton");
        WebElement el = client.findElement(ByLocator(str));
        el.submit();
    }
}
