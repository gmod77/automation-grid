package org.urbandaddy.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.urbandaddy.helpers.Comm.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.*;

public class UD_RoundUP_Client extends IHelper_Client {

	private LocatorReader roundUPreader;
    private Boolean result = false;

    public UD_RoundUP_Client(WebDriver client) {
        super(client);
        roundUPreader = new LocatorReader("UD_RoundUP_Client.xml");
    }
//Article Page

    public Boolean isHeaderImagePresent(){
        String str = roundUPreader.getLocator("RoundUPPage.HeaderImage");
        this.WaitForElementPresent(str,20);
        result = this.isElementPresent(str);
        return result;
    }

    public Boolean isTowerAdPresent(){
        String str = roundUPreader.getLocator("RoundUPPage.TowerAd");
        this.WaitForElementPresent(str,20);
        result = this.isElementPresent(str);
        return result;
    }

    public Boolean isThumbImage1Present(){
        String str = roundUPreader.getLocator("RoundUPPage.ThumbImage1");
        this.WaitForElementPresent(str,20);
        result = this.isElementPresent(str);
        return result;
    }

    public Boolean isArticleTitle1Present(){
        String str = roundUPreader.getLocator("RoundUPPage.Title1");
        this.WaitForElementPresent(str,20);
        result = this.isElementPresent(str);
        return result;
    }

    public Boolean isHeading1Present(){
        String str = roundUPreader.getLocator("RoundUPPage.Heading1");
        this.WaitForElementPresent(str,20);
        result = this.isElementPresent(str);
        return result;
    }

    public Boolean isSubHeader1Present(){
        String str = roundUPreader.getLocator("RoundUPPage.SubHeader1");
        this.WaitForElementPresent(str,20);
        result = this.isElementPresent(str);
        return result;
    }

    public Boolean isBlurb1Present(){
        String str = roundUPreader.getLocator("RoundUPPage.Blurb1");
        this.WaitForElementPresent(str,20);
        result = this.isElementPresent(str);
        return result;
    }

    public Boolean isFourOneOne1Present(){
        String str = roundUPreader.getLocator("RoundUPPage.FourOneOne1");
        this.WaitForElementPresent(str,20);
        result = this.isElementPresent(str);
        return result;
    }

}
