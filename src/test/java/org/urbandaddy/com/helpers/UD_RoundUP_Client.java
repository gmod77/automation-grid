package org.urbandaddy.com.helpers;

import org.openqa.selenium.WebDriver;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.locators.LocatorReader;

public class UD_RoundUP_Client extends IHelper_Client {

	private LocatorReader roundUPreader;
    private Boolean result = false;

    public UD_RoundUP_Client(WebDriver client) {
        super(client);
        roundUPreader = new LocatorReader("UD_RoundUP.xml");
    }
//Article Page

    public Boolean isHeaderImagePresent(){

        String str = roundUPreader.getLocator("RoundUPPage.HeaderImage");
        return this.isElementPresent(str);
    }
                 
    public Boolean isTowerAdPresent(){

        String str = roundUPreader.getLocator("RoundUPPage.TowerAd");
        return this.isElementPresent(str);
    }

    public Boolean isThumbImage1Present(){

        String str = roundUPreader.getLocator("RoundUPPage.ThumbImage1");
        return this.isElementPresent(str);
    }

    public Boolean isArticleTitle1Present(){

        String str = roundUPreader.getLocator("RoundUPPage.Title1");
        return this.isElementPresent(str);
    }

    public Boolean isHeading1Present(){

        String str = roundUPreader.getLocator("RoundUPPage.Heading1");
        return this.isElementPresent(str);
    }

    public Boolean isSubHeader1Present(){

        String str = roundUPreader.getLocator("RoundUPPage.SubHeader1");
        return this.isElementPresent(str);
    }

    public Boolean isBlurb1Present(){

        String str = roundUPreader.getLocator("RoundUPPage.Blurb1");
        return this.isElementPresent(str);
    }

    public Boolean isFourOneOne1Present(){

        String str = roundUPreader.getLocator("RoundUPPage.FourOneOne1");
        return this.isElementPresent(str);
    }

}
