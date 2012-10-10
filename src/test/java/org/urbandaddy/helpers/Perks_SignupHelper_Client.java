package org.urbandaddy.helpers;

//import org.openqa.selenium.By;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

import java.util.List;

//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.HasInputDevices;
//import org.openqa.selenium.Mouse;
//import org.openqa.selenium.interactions.internal.Coordinates;

//import com.urbandaddy.testsuite.helpers.comm.IHelper_Client;
//import com.urbandaddy.testsuite.locators.LocatorReader;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

//import java.util.List;



public class Perks_SignupHelper_Client extends IHelper_Client {
	
	private String domain = "https://qa.urbandaddy.com";

	private LocatorReader signupReader;
	
	public Perks_SignupHelper_Client(WebDriver client) {
		super(client);
		// TODO Auto-generated constructor stub	
		signupReader = new LocatorReader("Perks_SignUp.xml");
	}
	
//HomePage
	
	public Boolean isUDLogoPresent(){
		
		Boolean result = false;
		
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.UDLogo");
		this.WaitForElementPresent(str,20);		
		result = this.isElementPresent(str);		
		return result;
	}
	
	public void clickSignUpSeal(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.SignUpSeal");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
//Header
	
//	public void clickSignUpHeaderLink(){
//		String str = signupReader.getLocator("Header.SignUpHeaderLink");
//		this.WaitForElementPresent(str, 20);
//		WebElement el = client.findElement(ByLocator(str));
//		el.click();
//	}
	
//	public void clickMemberLogInHeaderLink(){
//		String str = signupReader.getLocator("Header.MemberLogInHeaderLink");
//		this.WaitForElementPresent(str, 20);
//		WebElement el = client.findElement(ByLocator(str));
//		el.click();
//	}
	
//Singup/SignIn modal 1 
	
	///Join Section
	
	public void enterJoinEmail(String email){
		
		String str = signupReader.getLocator("Step1.JoinEmail");		
		this.WaitForElementVisible(str, 100);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(email);
	}
	
	public void clickAccept(){
		String str = signupReader.getLocator("Step1.Accept");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	///Join Section ends here
	
	
	///SignIn Section
	public void enterSigninEmail(String email){
		
		String str = signupReader.getLocator("Step1.SigninEmail");		
		this.WaitForElementVisible(str, 100);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(email);
	}
	
	public void enterSigninPassword(String password){
		
		String str = signupReader.getLocator("Step1.SigninPassword");		
		this.WaitForElementVisible(str, 100);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(password);
	}
	
	public void clickSignIn(){
		String str = signupReader.getLocator("Step1.SignIn");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}

	/// Forgot/Reset Password Section
	public void clickForgotYourPassword(){
		String str = signupReader.getLocator("Step1.ForgotPasswordLink");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void enterForgotPasswordEmail(String email){
		
		String str = signupReader.getLocator("Step1.ForgotEmail");		
		this.WaitForElementVisible(str, 100);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(email);
	}
	
	public void clickSend(){
		String str = signupReader.getLocator("Step1.Send");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	/// Forgot/Reset Password Section ends here

// Select Editions
	public void checkBostonPerks(){
		String str = signupReader.getLocator("Step1.SelectEditionsBostonPerks");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}	
	public void checkChicagoPerks(){
		String str = signupReader.getLocator("Step1.SelectEditionsChicagoPerks");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkDCPerks(){
		String str = signupReader.getLocator("Step1.SelectEditionsDCPerks");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkLosAngelesPerks(){
		String str = signupReader.getLocator("Step1.SelectEditionsLAPerks");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkMiamiPerks(){
		String str = signupReader.getLocator("Step1.SelectEditionsMiamiPerks");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkNationalPerks(){
		String str = signupReader.getLocator("Step1.SelectEditionsNationalPerks");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}

	public void clickMoreLinkNewYork1(){

		String str = signupReader.getLocator("Step1.MoreLinkNewYork1");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void checkAtlanta(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsAtlanta");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkBoston(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsBoston");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkChicago(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsChicago");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkDallas(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsDallas");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkDC(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsDC");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void checkDriven(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsDriven");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void checkJetset(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsJetset");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	public void checkLasVegas(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsLasVegas");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void checkLosAngeles(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsLosAngeles");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void checkMiami(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsMiami");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void checkNational(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsNational");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void checkSanFrancisco(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsSanFranciso");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void checkSkiBoard(){
		String str = signupReader.getLocator("Step1.SelectEditorialEditionsSkiBoard");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();
	}
	
	public void clickSubmit1(){
		String str = signupReader.getLocator("Step1.Submit1");
		this.WaitForElementVisible(str, 100);
		WebElement el = client.findElement(ByLocator(str));
		el.click();

	}
	
//Singup modal 2 (Help Us Help You)	
	
	public void enterPassword(String targetValue){
		
		String str = signupReader.getLocator("Step2.EnterPassword");		
		this.WaitForElementVisible(str, 100);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(targetValue);
	}
	
	public void confirmPassword(String targetValue){
		
		String str = signupReader.getLocator("Step2.ConfirmPassword");		
		this.WaitForElementPresent(str, 20);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(targetValue);
	}
	
	public void enterFirstName(String targetValue){
	
	String str = signupReader.getLocator("Step2.EnterFirstName");		
	this.WaitForElementPresent(str, 20);		
	WebElement el = client.findElement(ByLocator(str));
	el.clear();
	el.sendKeys(targetValue);
}

public void enterLastName(String lastName){
	
	String str = signupReader.getLocator("Step2.EnterLastName");		
	this.WaitForElementPresent(str, 20);		
	WebElement el = client.findElement(ByLocator(str));
	el.clear();
	el.sendKeys(lastName);
}

public void selectGender(String targetValue){
	String str=signupReader.getLocator("Step2.SelectGender");
	List <WebElement> options = client.findElement(ByLocator(str)).findElements(By.tagName("option"));
	for (WebElement option : options){
		    if (targetValue.equalsIgnoreCase(option.getText())){
		     option.click();
		     break;
		    }
	}
}
	
public void selectIncomeRange(String targetValue){
	String str=signupReader.getLocator("Step2.SelectIncomeRange");
	List <WebElement> options = client.findElement(ByLocator(str)).findElements(By.tagName("option"));
	for (WebElement option : options){
		    if (targetValue.equalsIgnoreCase(option.getText())){
		     option.click();
		     break;
		    }
	}
}
public void enterZipCode(String targetValue){
		
		String str = signupReader.getLocator("Step2.EnterZipCode");		
		this.WaitForElementPresent(str, 20);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(targetValue);
	}
	
public void enterBirthday(String targetValue){
		
		String str = signupReader.getLocator("Step2.EnterBirthday");		
		this.WaitForElementPresent(str, 20);		
		WebElement el = client.findElement(ByLocator(str));
		el.clear();
		el.sendKeys(targetValue);
	}
	
public void clickSubmit(){
		String str = signupReader.getLocator("Step2.ClickSubmit");
		this.WaitForElementPresent(str, 20);
		WebElement el = client.findElement(ByLocator(str));
		el.click();

//	try {
//	Thread.sleep(5000);
//	} catch (InterruptedException e) {
//	e.printStackTrace();
//		}
}

// Signup modal 3: Invite Friends

public void enterEmailFriend1(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail1");		
	this.WaitForElementVisible(str, 100);		
	WebElement el = client.findElement(ByLocator(str));
	el.clear();
	el.sendKeys(email);
	
}

public void enterEmailFriend2(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail2");		
	this.WaitForElementVisible(str, 100);		
	WebElement el = client.findElement(ByLocator(str));
	el.clear();
	el.sendKeys(email);
	
}

public void enterEmailFriend3(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail3");		
	this.WaitForElementVisible(str, 100);		
	WebElement el = client.findElement(ByLocator(str));
	el.clear();
	el.sendKeys(email);
	
}

public void enterEmailFriend4(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail4");		
	this.WaitForElementVisible(str, 100);		
	WebElement el = client.findElement(ByLocator(str));
	el.clear();
	el.sendKeys(email);
	
}

public void enterEmailFriend5(String email){
	
	String str = signupReader.getLocator("Step3.InviteEmail5");		
	this.WaitForElementVisible(str, 100);		
	WebElement el = client.findElement(ByLocator(str));
	el.clear();
	el.sendKeys(email);
	
}

public void clickInvite(){
	
	String str = signupReader.getLocator("Step3.ClickInvite");
	this.WaitForElementPresent(str, 20);
	WebElement el = client.findElement(ByLocator(str));
	el.click();

//	try {
//	Thread.sleep(6000);
//	} catch (InterruptedException e) {
//	e.printStackTrace();
//		}
}

public void clickSkip(){
	
	String str = signupReader.getLocator("Step3.ClickSkip");
	this.WaitForElementPresent(str, 20);
	WebElement el = client.findElement(ByLocator(str));
	el.click();
}

public void clickCloseFinalModal(){
	String str = signupReader.getLocator("Step4.FinalConfirmationModal");
	this.WaitForElementPresent(str, 20);
	WebElement el = client.findElement(ByLocator(str));
	el.click();

	try {
	Thread.sleep(3000);
	} catch (InterruptedException e) {
	e.printStackTrace();
		}

	}
//	
//	public void findAndClickInvitationEmail (String searchString){
//		
//		// find search box and enter the searchString parameter
//		String targetString = "Invitation from Hello "+ searchString;
//		String sb = signupReader.getLocator("Gmail.SearchBox");		
//		this.WaitForElementPresent(sb, 20);		
//		WebElement el1 = client.findElement(ByLocator(sb));
//		el1.sendKeys(targetString);
//		
//		//find search mail button and click it
//		String smb = signupReader.getLocator("Gmail.SearchMailButton");		
//		this.WaitForElementPresent(smb, 20);		
//		WebElement el2 = client.findElement(ByLocator(smb));
//		el2.click();
//		
//		//assuming the single correct result came back, click that email
//		client.findElement(By.cssSelector("span.ts")).click();  
//		
//		//click "Join the network" button
//		String invitationEmail = client.findElement(By.partialLinkText("Join the")).getAttribute("href");  
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
		this.WaitForElementPresent(el,20);		
		result = this.isElementPresent(el);		
		return result;
	}
	
	public Boolean isStupidErrorAfterStep3Present(){
		
		Boolean result = false;
					
		String el = signupReader.getLocator("Step3.ErrorMessage");
		this.WaitForElementVisible(el,20);		
		result = this.isElementPresent(el);		
		return result;
	}
	
}
