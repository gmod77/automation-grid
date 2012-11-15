package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class Manero_HomepageHelper_Client extends IHelper_Client {

	private LocatorReader signupReader;
    private int timeOut = 10;

	public Manero_HomepageHelper_Client(WebDriver client) {
		super(client);
		signupReader = new LocatorReader("Manero_HomePage.xml");
	}

//HomePage

	public Boolean isManeroLogoPresent(){
		String str = signupReader.getLocator("HomePageFirstTimeVisitor.ManeroLogo");
		return this.isElementPresent(str);
	}

    public void clickFBLike() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.FBLike");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }

    public void clickFBCounter() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.FBLikeCounter");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }

    public void clickTweetButton() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.TweetButton");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }

    public void clickCultura() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Cultura");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }

    public void clickMusica() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Cultura");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }

    public void clickSports() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Cultura");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }
    public void clickStyle() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Cultura");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }
    public void clickEntertainment() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Cultura");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }
    public void clickGadgets() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Cultura");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }
    public void clickTravel() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Cultura");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }
    public void clickNightLife() {
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Cultura");
        WebElement el = findElementAndCheckBy(str,timeOut);
        el.click();
    }

    public Boolean isCarouselPresent(){
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.Carousel");
        return this.isElementPresent(str);
    }

    public Boolean isShortListPresent(){
        String str = signupReader.getLocator("HomePageFirstTimeVisitor.ShortList");
        return this.isElementPresent(str);
    }

}
