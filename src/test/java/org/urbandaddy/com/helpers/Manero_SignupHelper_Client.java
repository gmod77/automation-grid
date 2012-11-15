package org.urbandaddy.com.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

import java.util.List;

public class Manero_SignupHelper_Client extends IHelper_Client {

	private LocatorReader signupReader;

	public Manero_SignupHelper_Client(WebDriver client) {
		super(client);
		signupReader = new LocatorReader("Manero_SignUp.xml");
	}

    public void clickJoinTheClub() {

    }

    // Signup modal 1

	// Step1
	public void enterSigninEmail(String email){
		String str = signupReader.getLocator("Step1.Email");
		WebElement el = findElementAndCheckBy(str,10);
		//el.clear();
		el.sendKeys(email);
	}

    // Select Editions
    public void checkChicago(){
        String str = signupReader.getLocator("Step1.SelectEditionsChicago");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

    public void checkMiami(){
        String str = signupReader.getLocator("Step1.SelectEditionsMiami");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

    public void checkLosAngeles(){
        String str = signupReader.getLocator("Step1.SelectEditionsLosAngeles");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }
    public void checkNational(){
        String str = signupReader.getLocator("Step1.SelectEditionsNational");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

    public void checkHouston(){
        String str = signupReader.getLocator("Step1.SelectEditionsHouston");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

    public void checkNewYork(){
        String str = signupReader.getLocator("Step1.SelectEditionsNewYork");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

    public void clickJoin(){
        String str = signupReader.getLocator("Step1.Join");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

	
    //Signup modal 2 (Help Us Help You)
	public void enterPassword(String targetValue){
		String str = signupReader.getLocator("Step2.EnterPassword");		
		WebElement el = findElementAndCheckBy(str,10);
		el.clear();
		el.sendKeys(targetValue);
	}
	
	public void confirmPassword(String targetValue){
		String str = signupReader.getLocator("Step2.ConfirmPassword");		
		WebElement el = findElementAndCheckBy(str,10);
		el.clear();
		el.sendKeys(targetValue);
	}
	
	public void enterFirstName(String targetValue){
        String str = signupReader.getLocator("Step2.EnterFirstName");
        WebElement el = findElementAndCheckBy(str,10);
        el.clear();
        el.sendKeys(targetValue);
    }

    public void enterLastName(String lastName){
        String str = signupReader.getLocator("Step2.EnterLastName");
        WebElement el = findElementAndCheckBy(str,10);
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

    public void enterZipCode(String targetValue){
        String str = signupReader.getLocator("Step2.EnterZipCode");
        WebElement el = findElementAndCheckBy(str,10);
        el.clear();
        el.sendKeys(targetValue);
    }

    public void enterBirthday(String targetValue){
        String str = signupReader.getLocator("Step2.EnterBirthday");
        WebElement el = findElementAndCheckBy(str,10);
        el.clear();
        el.sendKeys(targetValue);
    }

    public void clickSubmit(){
        String str = signupReader.getLocator("Step2.ClickSubmit");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

    // Signup modal 3: Invite Friends
    public void enterEmailFriend(String email, int num) {
        String str = signupReader.getLocator("Step3.InviteEmail" + num);
        WebElement el = findElementAndCheckBy(str,10);
        el.clear();
        el.sendKeys(email);
    }

    public void clickInvite(){
        String str = signupReader.getLocator("Step3.ClickInvite");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

    public void clickSkip(){
        String str = signupReader.getLocator("Step3.ClickSkip");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

    // Step 4
    public WebElement fbFriendUs() {
        String str = signupReader.getLocator("Step4.FBFriendUs");
        return findElementAndCheckBy(str,10);
    }

    public WebElement twitterFollow() {
        String str = signupReader.getLocator("Step4.TwitterFollowUs");
        return findElementAndCheckBy(str,10);
    }

    public WebElement privacyPolicyLink() {
        String str = signupReader.getLocator("Step4.PrivacyPolicyLink");
        return findElementAndCheckBy(str,10);
    }

    public WebElement userAgreementLink() {
        String str = signupReader.getLocator("Step4.UserAgreementLink");
        return findElementAndCheckBy(str,10);
    }

    public void clickCloseButton(){
        String str = signupReader.getLocator("Step4.CloseButton");
        WebElement el = findElementAndCheckBy(str,10);
        el.click();
    }

}
