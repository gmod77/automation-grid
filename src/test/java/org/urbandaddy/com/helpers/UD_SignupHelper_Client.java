package org.urbandaddy.com.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

import java.util.List;

public class UD_SignupHelper_Client extends IHelper_Client {
	
	private String domain = "https://qa.urbandaddy.com";

	private LocatorReader signupReader;
	
	public UD_SignupHelper_Client(WebDriver client) {
		super(client);
		signupReader = new LocatorReader("UD_SignUp.xml");
	}
	
//HomePage
	
	public Boolean isUDLogoPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.UDLogo");
		//this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);
		return result;
	}
	
	public void clickSignUpSeal(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SignUpSeal");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
//Header
	
//	public void clickSignUpHeaderLink(){
//		String str = signupReader.getLocator("Header.SignUpHeaderLink");
//		//this.WaitForElementPresent(str, 20);
//		WebElement el = findElementAndCheckBy(str);
//		el.click();
//	}
	
	public void clickMemberLogInHeaderLink(){
		String str = signupReader.getLocator("Header.MemberLogInHeaderLink");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
//Sign up modal 1
	
	public void enterEmail(String email){
		
		String str = signupReader.getLocator("Step1.Email");
//		WebElement el = findElementAndCheckBy(str,5);
//		el.clear();
        WebElement el2 = findElementAndCheckBy(str,5);
        el2.sendKeys(email);
	}

// Select Editions
	public void checkNational(){
		String str = signupReader.getLocator("Step1.SelectEditionsNational");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}	
	public void checkNationalPerks(){
		String str = signupReader.getLocator("Step1.SelectEditionsNationalPerks");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkNewYork(){
		String str = signupReader.getLocator("Step1.SelectEditionsNewYork");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkNewYorkPerks(){
		String str = signupReader.getLocator("Step1.SelectEditionsNewYorkPerks");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkDriven(){
		String str = signupReader.getLocator("Step1.SelectEditionsDriven");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkJetset(){
		String str = signupReader.getLocator("Step1.SelectEditionsJetset");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkLasVegas(){
		String str = signupReader.getLocator("Step1.SelectEditionsLasVegas");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}	
	public void checkSkiBoard(){
		String str = signupReader.getLocator("Step1.SelectEditionsSkiBoard");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void clickMoreLinkNewYork1(){

		String str = signupReader.getLocator("Step1.MoreLinkNewYork1");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkAtlanta(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsAtlanta");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkBoston(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsBoston");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkChicago(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsChicago");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkDallas(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsDallas");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkDC(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsDC");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkLosAngeles(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsLosAngeles");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkMiami(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsMiami");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkSanFrancisco(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsSanFranciso");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void clickMoreLinkNewYork2(){

		String str = signupReader.getLocator("Step1.MoreLinkNewYork2");
		//this.WaitForElementVisible(str, 100);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
	public void checkBostonPerks(){
		String str = signupReader.getLocator("Step1.SelectPerksEditionsBostonPerks");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkChicagoPerks(){
		String str = signupReader.getLocator("Step1.SelectPerksEditionsChicagoPerks");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkDCPerks(){
		String str = signupReader.getLocator("Step1.SelectPerksEditionsDCPerks");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkLosAngelesPerks(){
		String str = signupReader.getLocator("Step1.SelectPerksEditionsLosAngelesPerks");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	public void checkMiamiPerks(){
		String str = signupReader.getLocator("Step1.SelectPerksEditionsMiamiPerks");
		//this.WaitForElementPresent(str, 20);
		WebElement el = findElementAndCheckBy(str);
		el.click();
	}
	
//	public void clickJoin(){
//		String str = signupReader.getLocator("Step1.Join");
//		//this.WaitForElementVisible(str, 100);
//		WebElement el = findElementAndCheckBy(str);
//		el.click();
////		seleniumClient.click(str);
//
////		try {
////			Thread.sleep(8000);
////		} catch (InterruptedException e) {
////			e.printStackTrace();
////		}
//	}

    public void clickJoin(){
        WebElement form = findElementAndCheckBy("xpath","/html/body/div[5]/div/div/div/form",10);
        form.submit();
    }

//Singup modal 2 (Help Us Help You)	
	
	public void enterPassword(String targetValue){
		
		String str = signupReader.getLocator("Step2.EnterPassword");		
		//this.WaitForElementVisible(str, 100);		
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(targetValue);
	}
	
	public void confirmPassword(String targetValue){
		
		String str = signupReader.getLocator("Step2.ConfirmPassword");		
		//this.WaitForElementPresent(str, 20);		
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(targetValue);
	}
	
	public void enterFirstName(String targetValue){
	
	String str = signupReader.getLocator("Step2.EnterFirstName");		
	//this.WaitForElementPresent(str, 20);		
	WebElement el = findElementAndCheckBy(str);
	el.clear();
	el.sendKeys(targetValue);
}

public void enterLastName(String lastName){
	
	String str = signupReader.getLocator("Step2.EnterLastName");		
	//this.WaitForElementPresent(str, 20);		
	WebElement el = findElementAndCheckBy(str);
	el.clear();
	el.sendKeys(lastName);
}

public void selectGender(String targetValue){
	String str=signupReader.getLocator("Step2.SelectGender");
	List <WebElement> options = client.findElements(By.tagName("option"));
	for (WebElement option : options){
		    if (targetValue.equalsIgnoreCase(option.getText())){
		     option.click();
		     break;
		    }
	}
}
	
public void selectIncomeRange(String targetValue){
	String str=signupReader.getLocator("Step2.SelectIncomeRange");
	List <WebElement> options = client.findElements(By.tagName("option"));
	for (WebElement option : options){
		    if (targetValue.equalsIgnoreCase(option.getText())){
		     option.click();
		     break;
		    }
	}
}
public void enterZipCode(String targetValue){
		
		String str = signupReader.getLocator("Step2.EnterZipCode");		
		//this.WaitForElementPresent(str, 20);		
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(targetValue);
	}
	
public void enterBirthday(String targetValue){
		
		String str = signupReader.getLocator("Step2.EnterBirthday");		
		//this.WaitForElementPresent(str, 20);		
		WebElement el = findElementAndCheckBy(str);
		el.clear();
		el.sendKeys(targetValue);
	}
	
//public void clickSubmit(){
//		String str = signupReader.getLocator("Step2.ClickSubmit");
//		//this.WaitForElementPresent(str, 20);
//		WebElement el = findElementAndCheckBy(str);
//		el.click();

    public void clickSubmit(){
        WebElement form = findElementAndCheckBy("xpath","/html/body/div[5]/div/div/div/form",10);
        form.submit();
    }



// Signup modal 3: Invite Friends

public void enterEmailFriend1(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail1");		
	//this.WaitForElementVisible(str, 100);		
	WebElement el = findElementAndCheckBy(str);
	el.clear();
	el.sendKeys(email);
	
}

public void enterEmailFriend2(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail2");		
	//this.WaitForElementVisible(str, 100);		
	WebElement el = findElementAndCheckBy(str);
	el.clear();
	el.sendKeys(email);
	
}

public void enterEmailFriend3(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail3");		
	//this.WaitForElementVisible(str, 100);		
	WebElement el = findElementAndCheckBy(str);
	el.clear();
	el.sendKeys(email);
	
}

public void enterEmailFriend4(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail4");		
	//this.WaitForElementVisible(str, 100);		
	WebElement el = findElementAndCheckBy(str);
	el.clear();
	el.sendKeys(email);
	
}

public void enterEmailFriend5(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail5");		
	//this.WaitForElementVisible(str, 100);		
	WebElement el = findElementAndCheckBy(str);
	el.clear();
	el.sendKeys(email);
	
}

public Boolean isInvitePresent() {

    Boolean result = false;
    String str = signupReader.getLocator("Step3.ClickInvite");
    result = this.isElementPresent(str);
    return result;
}

//public void clickInvite(){
//
//
//	String str = signupReader.getLocator("Step3.ClickInvite");
//	WebElement el = findElementAndCheckBy(str);
//	el.click();
//}
public void clickInvite(){
    WebElement form = findElementAndCheckBy("xpath","/html/body/div[5]/div/div/div/form",10);
    form.submit();
}

public void clickSkip(){
	
	String str = signupReader.getLocator("Step3.ClickSkip");
	WebElement el = findElementAndCheckBy(str);
	el.click();
}

public Boolean isCloseModalPresent() {

    Boolean result = false;
    String str = signupReader.getLocator("Step4.FinalConfirmationModal");
    result = this.isElementPresent(str);
    return result;

}

public void clickCloseFinalModal() {
	String str = signupReader.getLocator("Step4.FinalConfirmationModal");
	WebElement el = findElementAndCheckBy(str);
	el.click();
	}

//	public void findAndClickInvitationEmail (String searchString){
//		
//		// find search box and enter the searchString parameter
//		String targetString = "Invitation from Hello "+ searchString;
//		String sb = signupReader.getLocator("Gmail.SearchBox");		
//		//this.WaitForElementPresent(sb, 20);		
//		WebElement el1 = findElementAndCheckBy(sb));
//		el1.sendKeys(targetString);
//		
//		//find search mail button and click it
//		String smb = signupReader.getLocator("Gmail.SearchMailButton");		
//		//this.WaitForElementPresent(smb, 20);		
//		WebElement el2 = findElementAndCheckBy(smb));
//		el2.click();
//		
//		//assuming the single correct result came back, click that email
//		findElementAndCheckBy(By.cssSelector("span.ts")).click();  
//		
//		//click "Join the network" button
//		String invitationEmail = findElementAndCheckBy(By.partialLinkText("Join the")).getAttribute("href");  
//		
//	    String[] separated = invitationEmail.split("/");
//	    String invitationCode = separated[separated.length - 1];
//		
//		//String invitationCode = invitationEmail.substring(50,82);
//		String invitationURL = domain+"/register/invitation/"+ invitationCode; 
//		client.navigate().to(invitationURL);
//	}
//	
//	

	///error messaging 
	
	public Boolean isStupidErrorAfterStep1Present(){
		
		Boolean result = false;
					
		String el = signupReader.getLocator("Step1.ErrorMessage");
		//this.WaitForElementPresent(el,20);		
		result = this.isElementPresent(el);		
		return result;
	}
	
	public Boolean isStupidErrorAfterStep3Present(){
		
		Boolean result = false;
					
		String el = signupReader.getLocator("Step3.ErrorMessage");
		//this.WaitForElementVisible(el,20);		
		result = this.isElementPresent(el);		
		return result;
	}
	
}
