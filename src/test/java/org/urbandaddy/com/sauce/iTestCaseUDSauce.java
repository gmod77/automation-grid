package org.urbandaddy.com.sauce;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.urbandaddy.com.common.IHelper_Client;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.com.helpers.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

//Workflow specific imports

/**
 *  Urban Daddy Domain Test Methods
 *
 *
 */
public abstract class iTestCaseUDSauce extends iSauceBase implements UDBase {

    String lastURL;
    String UDcity;
    String UDcityPerks;

///// Sign-up methods

    // UD

    /**
     *  Navigate to the home page and perform a series of checks
     *  to make sure certain links are present
     *
     */
    public void visitUDFirstTime(){

        // enter UD domain name, hit enter, arrive on homepage
        client.get(UD_DOMAIN);
        client.manage().deleteAllCookies();
        client.get(UD_DOMAIN);

        client.manage().addCookie(new Cookie ("udsubpop", "3","ud-branch.thedaddy.co", "/", null));
    }

    public Set<Cookie> getUdCookie() {
        return client.manage().getCookies();
    }

    public void doHomePageChecks() {
        //do all homepage checks
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        //Verify All items are present on HomePage
        Assert.assertTrue(ud_homepageHelper_Client.isUDLogoPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isClickableCopyPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isSignUpSealPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isAtlantaLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isBostonLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isChicagoLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isDallasLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isWashingtonDCLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isDrivenLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isJetsetLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isLasVegasLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isLosAngelesLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isMiamiLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isNationalLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isNewYorkLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isSanFranciscoLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isSkiBoardLinkPresent());
        Assert.assertTrue(ud_homepageHelper_Client.isUDLogoPresent());

        // do all footer checks
        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        this.checkUDHomepageFooter();
    }

    /**
     * Log into the UD Admin site
     * This is to create articles like RoundUP
     *
     */
    public void loginUDAdmin(){
        client.get(UD_ADMIN_DOMAIN);
        client.findElement(By.id("username")).sendKeys("jenkins");
        client.findElement(By.id("password")).sendKeys("jenkins900!!");
        client.findElement(By.name("commit")).click();
        //client.get(UD_ADMIN_DOMAIN+"/admin.php/articles");
    }

    /**
     * Share an article via email
     * PreRequisite: visitUDFirstTime()
     *
     */
    public void shareArticle(String mailClient, String[] friends){
        iHelper_client = new IHelper_Client(client);

        // Grab the first article under "The Five You Need To Read"
        client.findElement(By.xpath(".//*[@id='content']/div/div[1]/div[2]/div/div[2]/div[1]/p/a")).click();

        // Grab article title
        String articleTitle = iHelper_client.findElementAndCheckBy("xpath","//html/body/div/div[3]/div/div/h1/span",5).getText();
        System.out.println("Article Title> " + articleTitle);
        // Click on the Forward button
        iHelper_client.findElementAndCheckBy("xpath",".//*[@id='shareTools']/div[2]/a[3]",5).click();

        // Handle popup window
        String handler = popUpHandler("Forward to a Friend",client);

        // Confirm Name of Article Appears
        String confirmTitle = client.findElement(By.xpath("/html/body/div[1]/div/div/div/p")).getText();
        System.out.println("Confirm Title> " + confirmTitle);
        Assert.assertTrue(confirmTitle.contains(articleTitle), "Article title was not found on popup.");

        // Fill in email addresses
        for (int i = 0; i < friends.length; i++) {
            client.findElement(By.id("invite_email_" + i)).sendKeys(friends[i]);
        }

        // If visible fill in Name
        if (client.findElement(By.id("name")).isDisplayed()) {
            WebElement name = client.findElement(By.id("name"));
            name.sendKeys("QA TESTER");
        }

        // If visible fill in Email
        if (client.findElement(By.id("email")).isDisplayed()) {
            WebElement email = client.findElement(By.id("email"));
            email.sendKeys(mailClient);
        }


        //Fill in personal message
        client.findElement(By.id("msg")).sendKeys("QA Tester, personal message.\nLorem ipsum lorem ipsum.");

        //Click Submit
        client.findElement(By.id("myaccount_invite_users_form")).submit();

        //Confirmation screen check
        String str = iHelper_client.findElementAndCheckBy("xpath","//html/body/div/div/div/div[1]/p",5).getText();
        Assert.assertTrue(str.contains("Thank you. The article has been forwarded to your friend(s)."), "Popup failed to submit");

        //Close Popup
        client.findElement(By.tagName("input")).click();

        //Return to Parent Window
        returnToParentWindow(handler,client);

    }

    public void saveArticleToAccount () {
        iHelper_client = new IHelper_Client(client);

        // Grab the first article under "The Five You Need To Read"
        //client.findElement(By.xpath(".//*[@id='content']/div/div[1]/div[2]/div/div[2]/div[1]/p/a")).click();
        WebElement bigFiveBox = client.findElement(By.className("wideContentBoxTxt"));
        bigFiveBox.findElement(By.className("boxOne")).findElement(By.tagName("a")).click();

        // Click the save button
        findElementAndCheckBy("xpath",".//*[@id='shareTools']/div[2]/a[4]",10).click();

        // Save the URL
        String url = client.getCurrentUrl();

        // Confirm save button disappeared
        Assert.assertFalse(client.findElement(By.xpath(".//*[@id='shareTools']/div[2]/a[4]")).isDisplayed());

        // Navigate to MyUD
        client.get("http://ud-branch.thedaddy.co/myud");

        // Check MyUD box "Favorites" has incremented
        String favCount = client.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div[2]/dl/dd/b/a")).getText();
        Assert.assertEquals(favCount,"1","The article didn't save or count didn't increment to 1");

        // Check that the article appears under Favorite
        WebElement articleLink = client.findElement(By.xpath("/html/body/div/div[3]/div/div/div[2]/div[2]/div/div[2]/div/ul/li/a"));

        String favUrlMyUD = articleLink.getAttribute("href");
        // They add /favorites to the end
        Assert.assertEquals(url + "/favorites", favUrlMyUD, "Original article doesn't match saved article.");

    }

    public void createRoundUPUpload() {
        emailHelper_Client = new EmailHelper_Client(client);
        String date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        
        System.out.println(IMAGE_PATH);
        System.out.println(System.getProperty("os.name"));
        // 1. log into the UD admin
        // 2. Click on articles
        // 3. click on create

        // After login go to create the article
        client.get(UD_ADMIN_DOMAIN+"/articles/create");
        this.pause(7000);

        // 4. change status to approved
        WebElement status = client.findElement(By.id("article_article_status_id"));
        List<WebElement> status_options = status.findElements(By.tagName("option"));
        for(WebElement option : status_options){
            if(option.getText().equals("Approved")) {
                option.click();
                break;
            }
        }

        // 5. click dedicated
        client.findElement(By.id("article_is_dedicated")).click();

        // 6. choose Roundup template
        WebElement template = client.findElement(By.id("article_article_template_id"));
        List<WebElement> template_options = template.findElements(By.tagName("option"));
        for(WebElement option : template_options){
            if(option.getText().equals("Roundup")) {
                option.click();
                break;
            }
        }

        // 7. choose any ad campaign
        WebElement ad_campaign = client.findElement(By.id("article_article_template_id"));
        List<WebElement> ad_campaign_options = ad_campaign.findElements(By.tagName("option"));
        for(WebElement option : ad_campaign_options){
            if(option.getText().equals("Groupon")) {
                option.click();
                break;
            }
        }

        // 8. choose any author
        WebElement author = client.findElement(By.id("article_author_id"));
        List<WebElement> author_options = author.findElements(By.tagName("option"));
        for(WebElement option : author_options){
            if(option.getText().equals("Russ Brandom")) {
                option.click();
                break;
            }
        }

        // 9.  Enter in From Display "test <test@test.com>"
        client.findElement(By.id("details_from_display")).sendKeys("test <test@test.com>");

        // 10. choose segment qa addresses
        WebElement segment = client.findElement(By.id("details_segment"));
        List<WebElement> segment_options = segment.findElements(By.tagName("option"));
        for(WebElement option : segment_options){
            if(option.getText().equals("QA Addresses")) {
                option.click();
                break;
            }
        }

        // 11. Enter an Article title
        client.findElement(By.id("article_name")).sendKeys("Test Round Up Article Title "+ date);

        // 12. Enter Email subject line

        client.findElement(By.id("article_email_subject_line")).sendKeys("Test Round Up Email Subject "+ date);

        // 13. Enter Article Business Subject
        client.findElement(By.id("article_business_name")).sendKeys("Test Round Up Business Name "+ date);

        // 14. DO NOT ENTER COPY
        // 15. Enter Article Blurb

        client.findElement(By.id("article[blurb]")).sendKeys("Round Up Article Blurb Test "+ date);

        // 16. Enter IPHone Blurb

        client.findElement(By.id("article[blurb_iphone]")).sendKeys("Round Up iPhone Blurb Test "+ date);

        // 17. Enter Twitter Blurb

        client.findElement(By.id("article_blurb_twitter")).sendKeys("Round Up Twitter Blurb Test "+ date);

        // 18. Enter Note

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('article[footer]').SetHTML('Round Up Article Copy Test'))");

        // 19. Enter Legal Line

        client.findElement(By.id("article[footer_additional]")).sendKeys("Round Up Legal Line Test "+ date);

        // 20. Enter Keywords

        client.findElement(By.id("article_keywords")).sendKeys("Round Up Keywords Test Keywords "+ date);

        // 21. Choose business type

        WebElement business_type = client.findElement(By.id("article_business_type_id"));
        List<WebElement> business_type_options = business_type.findElements(By.tagName("option"));
        for(WebElement option : business_type_options){
            if(option.getText().equals("Clothing")) {
                option.click();
                break;
            }
        }

        // 22. Enter Business Specialty
        client.findElement(By.id("article_business_specialty")).sendKeys("Round Up Business Specialty Test "+ date);
        // 23. Click Save
        client.findElement(By.name("save")).click();
        this.pause(7000);

        // Get Article ID

        String articleLink = client.getCurrentUrl();

        String[] separated = articleLink.split("/");
        String articleID = separated[separated.length - 1];

        // 24. Click add Image
        // go to create image page
        client.get(UD_ADMIN_DOMAIN+"/article_images/create");
        this.pause(7000);


        // 25. Upload Email_Banner size 552 x 135

        // Local Mac
        //client.findElement(By.id("article_image_name")).sendKeys("/Users/sargenzi/Desktop/UDImages/email banner 3.jpg");
        // For PC
        //client.findElement(By.id("article_image_name")).sendKeys("C:\\Users\\Administrator\\Desktop\\ud\\email banner 3.jpg");
        String image1 = IMAGE_PATH + "email banner 3.jpg";
        System.out.println(image1);
        client.findElement(By.id("article_image_name")).sendKeys(image1);
        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        // 26. choose position Email_banner

        WebElement article1_position = client.findElement(By.id("article_image_article_image_position_id"));
        List<WebElement> position_options1 = article1_position.findElements(By.tagName("option"));
        for(WebElement option : position_options1){
            if(option.getText().equals("Email_Banner")) {
                option.click();
                break;
            }
        }

        // 27. click  save

        client.findElement(By.name("save_and_add")).click();
        this.pause(7000);

    }

        /**
        * Create a round up article
        *
        * @return The article id which was just created to do checks on the HTML email/article
        */
    public String createRoundUP() {
        iHelper_client = new IHelper_Client(client);
        emailHelper_Client = new EmailHelper_Client(client);
        String date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
        
        // 1. log into the UD admin
        // 2. Click on articles
        // 3. click on create

        // After login go to create the article
        client.get(UD_ADMIN_DOMAIN+"/articles/create");
        this.pause(7000);

        // 4. change status to approved
        iHelper_client.selectFromDropdown("article_article_status_id","option","Approved");


        // 5. click dedicated
        client.findElement(By.id("article_is_dedicated")).click();

        // 6. choose Roundup template
        iHelper_client.selectFromDropdown("article_article_template_id","option","Roundup");


        // 7. choose any ad campaign
        iHelper_client.selectFromDropdown("article_article_template_id","option","Groupon");


        // 8. choose any author
        iHelper_client.selectFromDropdown("article_author_id","option","Russ Brandom");


        // 9.  Enter in From Display "test <test@test.com>"
        client.findElement(By.id("details_from_display")).sendKeys("test <test@test.com>");

        // 10. choose segment qa addresses
        iHelper_client.selectFromDropdown("details_segment","option","QA Addresses");


        // 11. Enter an Article title
        client.findElement(By.id("article_name")).sendKeys("Test Round Up Article Title "+ date);

        // 12. Enter Email subject line

        client.findElement(By.id("article_email_subject_line")).sendKeys("Test Round Up Email Subject "+ date);

        // 13. Enter Article Business Subject
        client.findElement(By.id("article_business_name")).sendKeys("Test Round Up Business Name "+ date);

        // 14. DO NOT ENTER COPY
        // 15. Enter Article Blurb

        client.findElement(By.id("article[blurb]")).sendKeys("Round Up Article Blurb Test "+ date);

        // 16. Enter IPHone Blurb

        client.findElement(By.id("article[blurb_iphone]")).sendKeys("Round Up iPhone Blurb Test "+ date);

        // 17. Enter Twitter Blurb

        client.findElement(By.id("article_blurb_twitter")).sendKeys("Round Up Twitter Blurb Test "+ date);

        // 18. Enter Note

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('article[footer]').SetHTML('Round Up Article Copy Test'))");

        // 19. Enter Legal Line

        client.findElement(By.id("article[footer_additional]")).sendKeys("Round Up Legal Line Test "+ date);

        // 20. Enter Keywords

        client.findElement(By.id("article_keywords")).sendKeys("Round Up Keywords Test Keywords "+ date);

        // 21. Choose business type

        iHelper_client.selectFromDropdown("article_business_type_id","option","Clothing");

        // 22. Enter Business Specialty
        client.findElement(By.id("article_business_specialty")).sendKeys("Round Up Business Specialty Test "+ date);
        // 23. Click Save
        client.findElement(By.name("save")).click();
        this.pause(7000);

        // Get Article ID

        String articleLink = client.getCurrentUrl();

        String[] separated = articleLink.split("/");
        String articleID = separated[separated.length - 1];

        // 24. Click add Image
        // go to create image page
        client.get(UD_ADMIN_DOMAIN+"/article_images/create");
        this.pause(7000);


        // 25. Upload Email_Banner size 552 x 135

        String image1 = IMAGE_PATH + "email banner 3.jpg";
        client.findElement(By.id("article_image_name")).sendKeys(image1);
        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        // 26. choose position Email_banner

        iHelper_client.selectFromDropdown(findElementAndCheckBy("id","article_image_article_image_position_id",5),"option","Email_Banner");

        // 27. click  save

        client.findElement(By.name("save_and_add")).click();
        this.pause(7000);

        // 28. Add 2nd Image
        // 29. upload thumbnail size 139 x 95

        client.findElement(By.id("article_image_name")).sendKeys(IMAGE_PATH + "thumbnail 3.jpg");

        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        // 30. choose position thumbnail

        iHelper_client.selectFromDropdown("article_image_article_image_position_id","option","Thumbnail");

        // 31. click save

        client.findElement(By.name("save_and_add")).click();
        this.pause(7000);
        client.get(UD_ADMIN_DOMAIN+"/articles/edit/id/" + articleID);
        this.pause(7000);

        // 32. Add Ad module to Right module section, make it a tower
        //		a.	Select ad from component dropdown

        //        		a.	Select ad from component dropdown

        //iHelper_client.selectFromDropdown("_select_modules_right","option","Ad");
        WebElement add_right_components = client.findElement(By.id("_select_modules_right"));
        List<WebElement> add_right_components_options = add_right_components.findElements(By.tagName("option"));
        for(WebElement option : add_right_components_options){
            if(option.getText().equals("Ad")) {
                option.click();
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //		b.	Click on newsletter_ad

        findElementAndCheckBy("xpath","//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[5]/div/ul/li/table/tbody/tr/td[5]/a",5).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //	c.	Choose any Tower add.
        //set main window handle before pop-ups pop up
        String mwh2=client.getWindowHandle();

        //handle pop-up window
        Set<?> s_add2=client.getWindowHandles();
        //this method will you handle of all opened windows

        Iterator<?> ite_add2=s_add2.iterator();

        while(ite_add2.hasNext())
        {
            String popupHandle2=ite_add2.next().toString();
            if(!popupHandle2.contains(mwh2))
            {
                client.switchTo().window(popupHandle2);

                this.pause(3000);
                iHelper_client.selectFromDropdown(findElementAndCheckBy("xpath","//html/body/div/div[2]/div/div/form/fieldset/div/div/select",5),"option","49ers SF 11-8-11 tower (Tower)");
                client.findElement(By.id("save_button")).click();
                this.pause(7000);

                //After finished your operation in pop-up just select the main window again
                client.switchTo().window(mwh2);
            }
        }


        // 33. Click "here" to add the individual articles
        client.get(UD_ADMIN_DOMAIN+"/multiarticle/edit/id/"+articleID);
        this.pause(7000);

        // 34. Add Copy to the slots you are going to use (1 paragraph 3 sentences maxish)

        WebElement frameA = client.findElement(By.xpath(".//*[@id='sf_admin_edit_form']/fieldset/table/tbody/tr[2]/td[2]/div[1]/iframe"));
        String frameAid = frameA.getAttribute("id");

        client.switchTo().frame(frameAid);

        client.findElement(By.xpath(".//*[@id='xToolbar']/table[6]/tbody/tr/td[6]/div/table/tbody/tr/td[2]")).click();
        client.findElement(By.xpath(".//*[@id='xEditingArea']/textarea")).sendKeys("Lorem Ipsum. Lorem Ipsum. Lorem Ipsum." +  date);
        client.switchTo().defaultContent();

        // 35. add in 411 and turn one word into a hyper link

        WebElement frameB = client.findElement(By.xpath(".//*[@id='sf_admin_edit_form']/fieldset/table/tbody/tr[2]/td[2]/div[2]/iframe"));
        String frameBid = frameB.getAttribute("id");

        client.switchTo().frame(frameBid);
        client.findElement(By.xpath(".//*[@id='xToolbar']/table/tbody/tr/td[18]/div/table/tbody/tr/td[2]")).click();
        client.findElement(By.xpath(".//*[@id='xEditingArea']/textarea")).sendKeys("Lorem Ipsum <a href=\"http://www.google.com\">" +  date + "</a>");
        client.switchTo().defaultContent();

        // 36. Add Header to each slot

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[5]/input")).sendKeys("Weekender Header1 Test "+ date);

        // 37. Add Sub head to each slot

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[6]/input")).sendKeys("Weekender SubHeader1 Test "+ date);

        // 38. add image size 120 x 120
        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[8]/input")).sendKeys(IMAGE_PATH + "round up image.jpg");

        // 38a. add Alt text to slots

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[10]/input")).sendKeys("Weekender Alt Test"+ date);

        // 39. click Save
        client.findElement(By.name("save")).click();

        // 40. Click back to article to continue preview and mailing tests
        return articleID;
    }

    /**
     * Confirm the created RoundUP article
     *
     * @param articleID This comes from the return of createRoundUP()
     */
    public void confirmRoundUP(String articleID) {
        System.out.println("Article ID> " + articleID);
        client.get("http://ud-branch.thedaddy.co/newsletter/roundup/" + articleID + "?preview=true");
        ud_roundUP_client = new UD_RoundUP_Client(client);

        pause(5);
        Assert.assertTrue(ud_roundUP_client.isArticleTitle1Present());
        Assert.assertTrue(ud_roundUP_client.isBlurb1Present());
        Assert.assertTrue(ud_roundUP_client.isFourOneOne1Present());
        Assert.assertTrue(ud_roundUP_client.isHeaderImagePresent());
        Assert.assertTrue(ud_roundUP_client.isHeading1Present());
        Assert.assertTrue(ud_roundUP_client.isSubHeader1Present());
        Assert.assertTrue(ud_roundUP_client.isThumbImage1Present());
        Assert.assertTrue(ud_roundUP_client.isTowerAdPresent());
    }

    /**
     * Create a Weekender Article
     *
     */
    public void createArticleWeekender() {
        emailHelper_Client = new EmailHelper_Client(client);
        String date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");
//	1. Log in to the UD admin 
//	2. Click on articles
//	3. Click on create	

        client.get(UD_ADMIN_DOMAIN+"/articles/create");
        this.pause(7000);

//	4. Change status to Approved

        WebElement status = client.findElement(By.id("article_article_status_id"));
        List<WebElement> status_options = status.findElements(By.tagName("option"));
        for(WebElement option : status_options){
            if(option.getText().equals("Approved")) {
                option.click();
                break;
            }
        }

//	5.  Click Dedicated

        client.findElement(By.id("article_is_dedicated")).click();

//	6.  Change Template to Weekender

        WebElement template = client.findElement(By.id("article_article_template_id"));
        List<WebElement> template_options = template.findElements(By.tagName("option"));
        for(WebElement option : template_options){
            if(option.getText().equals("Weekender")) {
                option.click();
                break;
            }
        }

//	7.  Choose any ad campaign

        WebElement ad_campaign = client.findElement(By.id("article_article_template_id"));
        List<WebElement> ad_campaign_options = ad_campaign.findElements(By.tagName("option"));
        for(WebElement option : ad_campaign_options){
            if(option.getText().equals("Groupon")) {
                option.click();
                break;
            }
        }

//	8.  Choose any Author

        WebElement author = client.findElement(By.id("article_author_id"));
        List<WebElement> author_options = author.findElements(By.tagName("option"));
        for(WebElement option : author_options){
            if(option.getText().equals("Russ Brandom")) {
                option.click();
                break;
            }
        }

//	9.  Enter in From Display “test <test@test.com>”

        client.findElement(By.id("details_from_display")).sendKeys("test <test@test.com>");

//	10.   Choose QA Segment

        WebElement segment = client.findElement(By.id("details_segment"));
        List<WebElement> segment_options = segment.findElements(By.tagName("option"));
        for(WebElement option : segment_options){
            if(option.getText().equals("QA Addresses")) {
                option.click();
                break;
            }
        }

//	11.   Enter an Article title

        client.findElement(By.id("article_name")).sendKeys("Test Weekender Article Title "+ date);

//	12.   Enter a Business Name/Subject

        client.findElement(By.id("article_business_name")).sendKeys("Test Weekender Business Name "+ date);

//	13.   Enter an Article Subheader

        client.findElement(By.id("article_teaser")).sendKeys("Test Weekender Article Subheader "+ date);

//	14.   Enter a Email Subject Line

        client.findElement(By.id("article_email_subject_line")).sendKeys("Test Weekender Email Subject "+ date);

//	15.   Choose any weekender category

        //default selection is "NYC: Nightlife"

//	16.   Click Save

        client.findElement(By.name("save")).click();
        this.pause(7000);

        // Get Article ID

        String articleLink = client.getCurrentUrl();

        String[] separated = articleLink.split("/");
        String articleID = separated[separated.length - 1];

//	17.   Add Images: Email Banner, Option_A_Left_Column, and Thumbnail

        // go to create image page
        client.get(UD_ADMIN_DOMAIN+"/article_images/create");
        this.pause(7000);

        //browse to 1st image
        client.findElement(By.id("article_image_name")).sendKeys(IMAGE_PATH + "image001_optionA.jpg");

        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        //enter Position for 1st image: Option A Left Column

        WebElement article1_position = client.findElement(By.id("article_image_article_image_position_id"));
        List<WebElement> position_options1 = article1_position.findElements(By.tagName("option"));
        for(WebElement option : position_options1){
            if(option.getText().equals("Option_A_Left_Column")) {
                option.click();
                break;
            }
        }

        //click "save and add" button

        client.findElement(By.name("save_and_add")).click();
        this.pause(7000);


        //browse to 2nd image
        client.findElement(By.id("article_image_name")).sendKeys(IMAGE_PATH + "image002_EmailBanner.jpg");

        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        //enter Position for 1st image: Option A Left Column

        WebElement article2_position = client.findElement(By.id("article_image_article_image_position_id"));
        List<WebElement> position_options2 = article2_position.findElements(By.tagName("option"));
        for(WebElement option : position_options2){
            if(option.getText().equals("Email_Banner")) {
                option.click();
                break;
            }
        }

        //click "save and add" button

        client.findElement(By.name("save_and_add")).click();
        this.pause(7000);

        //browse to 3rd image
        client.findElement(By.id("article_image_name")).sendKeys(IMAGE_PATH + "image003_thumbnail.jpg");

        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        //enter Position for 1st image: Option A Left Column

        WebElement article3_position = client.findElement(By.id("article_image_article_image_position_id"));
        List<WebElement> position_options3 = article3_position.findElements(By.tagName("option"));
        for(WebElement option : position_options3){
            if(option.getText().equals("Thumbnail")) {
                option.click();
                break;
            }
        }

        //click "save and add" button

        client.findElement(By.name("save")).click();
        this.pause(7000);

        //go back to the article
        client.get(UD_ADMIN_DOMAIN+"/articles/edit/id/"+articleID);

//	18.   Enter text in photo credit

        client.findElement(By.id("article[photo_credit]")).sendKeys("Weekender Photo Credits Test "+ date);

//	19.   Enter text in Article Feature

        client.findElement(By.id("article[short]")).sendKeys("Weekender Article/Feature Introduction Test "+ date);

//	20.   Copy is not needed

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('article[content]').SetHTML('Weekender Article Copy Test'))");

//	21.   Enter text in Article Blurb

        client.findElement(By.id("article[blurb]")).sendKeys("Weekender Article Blurb Test "+ date);

//	22.   Enter Text in iPhone Blurb

        client.findElement(By.id("article[blurb_iphone]")).sendKeys("Weekender iPhone Blurb Test "+ date);

//	23.   Enter Text in Twitter Blurb

        client.findElement(By.id("article_blurb_twitter")).sendKeys("Weekender Twitter Blurb Test "+ date);

//	24.   Enter Text in Note


        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('article[footer]').SetHTML('Weekender Article Copy Test'))");

//	25.   Enter Text in Legal Line

        client.findElement(By.id("article[footer_additional]")).sendKeys("Weekender Legal Line Test "+ date);

//	26.   Add Ad to Bottom module
//		a.	Select ad from component dropdown

        WebElement add_bottom_components = client.findElement(By.id("_select_modules_center"));
        List<WebElement> add_bottom_components_options = add_bottom_components.findElements(By.tagName("option"));

        for(WebElement option : add_bottom_components_options){
            if(option.getText().equals("Ad")) {
                option.click();
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//		b.	Click on newsletter_ad

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[4]/div/ul/li/table/tbody/tr/td[5]/a")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//		c.	Choose any Footer ad.   
        //set main window handle before pop-ups pop up
        String mwh=client.getWindowHandle();

        //handle pop-up window
        Set<?> s_add1=client.getWindowHandles();
        //this method will you handle of all opened windows

        Iterator<?> ite_add1=s_add1.iterator();

        while(ite_add1.hasNext())
        {
            String popupHandle=ite_add1.next().toString();
            if(!popupHandle.contains(mwh))
            {
                client.switchTo().window(popupHandle);

                // select Footer template

                WebElement bottom_ad_type = findElementAndCheckBy("name","newsletter_content_slot[name]",5);

                List<WebElement> bottom_ad_type_options = bottom_ad_type.findElements(By.tagName("option"));
                for(WebElement option : bottom_ad_type_options){
                    if(option.getText().equals("49ers SF 11-8-11 footer (Footer)")) {
                        option.click();
                        break;
                    }
                }

                //d. 	Click Save

                WebElement clickMe = findElementAndCheckBy("id", "save_button", 5);
                clickMe.click();
                this.pause(7000);

                //After finished your operation in pop-up just select the main window again
                client.switchTo().window(mwh);
            }
        }



//	27.   Add Ad to Right Module
//		a.	Select ad from component dropdown

//        		a.	Select ad from component dropdown
        WebElement add_right_components = findElementAndCheckBy("id","_select_modules_right",5);
        //WebElement add_right_components = client.findElement(By.id("_select_modules_right"));
        List<WebElement> add_right_components_options = add_right_components.findElements(By.tagName("option"));

        for(WebElement option : add_right_components_options){
            if(option.getText().equals("Ad")) {
                option.click();
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//		b.	Click on newsletter_ad

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[5]/div/ul/li/table/tbody/tr/td[5]/a")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//		c.	Choose any Tower add.      
        //set main window handle before pop-ups pop up
        String mwh2=client.getWindowHandle();

        //handle pop-up window
        Set<?> s_add2=client.getWindowHandles();
        //this method will you handle of all opened windows

        Iterator<?> ite_add2=s_add2.iterator();

        while(ite_add2.hasNext())
        {
            String popupHandle2=ite_add2.next().toString();
            if(!popupHandle2.contains(mwh2))
            {
                client.switchTo().window(popupHandle2);

                this.pause(3000);

                // select Footer template

                WebElement right_ad_type = findElementAndCheckBy("name","newsletter_content_slot[name]",5);
                List<WebElement> right_ad_type_options = right_ad_type.findElements(By.tagName("option"));
                for(WebElement option : right_ad_type_options){
                    if(option.getText().equals("49ers SF 11-8-11 tower (Tower)")) {
                        option.click();
                        break;
                    }
                }
//        d.	Click Save
                client.findElement(By.id("save_button")).click();
                this.pause(7000);

                //After finished your operation in pop-up just select the main window again
                client.switchTo().window(mwh2);
            }
        }


//	28.   Enter text in keywords

        client.findElement(By.id("article_keywords")).sendKeys("Weekender Keywords Test Keywords "+ date);

//	29.   Choose business type

        WebElement business_type = findElementAndCheckBy("id","article_business_type_id",5);
        List<WebElement> business_type_options = business_type.findElements(By.tagName("option"));
        for(WebElement option : business_type_options){
            if(option.getText().equals("Clothing")) {
                option.click();
                break;
            }
        }

//	30.   Enter text in business specialty

        client.findElement(By.id("article_business_specialty")).sendKeys("Weekender Business Specialty Test "+ date);

//	31.   Click save

        client.findElement(By.name("save")).click();
        this.pause(7000);


//	32.   Click “here” next to Template this takes you to individual weekenders
        //html/body/div[3]/div/div[2]/form/fieldset/div[5]/div/a

//		or:

        client.get(UD_ADMIN_DOMAIN+"/multiarticle/edit/id/"+articleID);
        this.pause(7000);

//	33.   For each template, 3 is a good number:

        //1
//		a.       Choose the day

        WebElement day1 = client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div/select"));
        List<WebElement> day1_options = day1.findElements(By.tagName("option"));
        for(WebElement option : day1_options){
            if(option.getText().equals("Monday")) {
                option.click();
                break;
            }
        }

//		b.      Click show day image in title

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div/input[2]")).click();


//		c.       Enter text in Header


        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[5]/input")).sendKeys("Weekender Header1 Test "+ date);


//		d.      Enter text in Subheader

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[6]/input")).sendKeys("Weekender SubHeader1 Test "+ date);


//		e.      Put in some url for subheader URl

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[7]/input")).sendKeys("www.google.com");


//		f.        Click choose file under image and put in an image


        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[8]/input")).sendKeys(IMAGE_PATH + "solon.jpg");


//		g.       Check image url


        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[9]/input")).click();


//		h.      Put in some url for image url


        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[9]/input[2]")).sendKeys("http://images.sodahead.com/polls/001076173/even_kittens_are_going_bad_answer_2_xlarge.jpeg");


//		i.         Enter text in Alt


        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[2]/td/div[10]/input")).sendKeys("Weekender Alt Test"+ date);


//		j.        Enter text in Copy
//		k.       Enter text in 411

//		l.         Repeat for others


        //2
//		a.       Choose the day    

        WebElement day2 = client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div/select"));
        List<WebElement> day2_options = day2.findElements(By.tagName("option"));
        for(WebElement option : day2_options){
            if(option.getText().equals("Tuesday")) {
                option.click();
                break;
            }
        }

//		b.      Click show day image in title

        //client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div/input[2]")).click();

//		c.       Enter text in Header


        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[5]/input")).sendKeys("Weekender Header2 Test "+ date);

//		d.      Enter text in Subheader

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[6]/input")).sendKeys("Weekender SubHeader2 Test "+ date);


//		e.      Put in some url for subheader URl

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[7]/input")).sendKeys("www.yahoo.com");


//		f.        Click choose file under image and put in an image

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[8]/input")).sendKeys(IMAGE_PATH + "plato.jpg");


//		g.       Check image url

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[9]/input")).click();


//		h.      Put in some url for image url

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[9]/input[2]")).sendKeys("http://t0.gstatic.com/images?q=tbn:ANd9GcTYj5WyrHaLj6lqad-dIiNUTQSaKkuJmJtUKiPX3SbIpCfS-1aFqyr-mDWF");


//		i.         Enter text in Alt

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[4]/td/div[10]/input")).sendKeys("Weekender Alt2 Test"+ date);


//		j.        Enter text in Copy
//		k.       Enter text in 411
//		l.         Repeat for others


        //3

//		a.       Choose the day   

        WebElement day3 = client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div/select"));
        List<WebElement> day3_options = day3.findElements(By.tagName("option"));
        for(WebElement option : day3_options){
            if(option.getText().equals("Thursday")) {
                option.click();
                break;
            }
        }

//		b.      Click show day image in title

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div/input[2]")).click();


//		c.       Enter text in Header

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[5]/input")).sendKeys("Weekender Header3 Test "+ date);


//		d.      Enter text in Subheader

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[6]/input")).sendKeys("Weekender SubHeader3 Test "+ date);


//		e.      Put in some url for subheader URl

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[7]/input")).sendKeys("www.cnn.com");


//		f.        Click choose file under image and put in an image

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[8]/input")).sendKeys(IMAGE_PATH + "socrates.jpg");


//		g.       Check image url

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[9]/input")).click();

//		h.      Put in some url for image url

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[9]/input[2]")).sendKeys("http://imagecache6.allposters.com/LRG/38/3842/UJXYF00Z.jpg");


//		i.         Enter text in Alt

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[6]/td/div[10]/input")).sendKeys("Weekender Alt3 Test"+ date);


//		j.        Enter text in Copy
//		k.       Enter text in 411


//		m.    Delete slots you do not want to use
//		slot 4:/html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[8]/td/div[11]/input

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[8]/td/div[11]/input")).click();

        this.pause(7000);

//		slot 5:/html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[10]/td/div[11]/input

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[8]/td/div[11]/input")).click();
        this.pause(7000);

//		slot 6:/html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[12]/td/div[11]/input

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/table/tbody/tr[8]/td/div[11]/input")).click();
        this.pause(7000);




        //		n.      Click Save

        client.findElement(By.name("save")).click();
        this.pause(3000);

    }

    /**
     * Create a Three Column Article
     *
     */
    public void createArticleThreeColumn() {
        iHelper_client = new IHelper_Client(client);
        emailHelper_Client = new EmailHelper_Client(client);
        String date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");

        client.get(UD_ADMIN_DOMAIN+"/articles/create");

        //Set Status to Approved
        iHelper_client.selectFromDropdown("article_article_status_id","option","Approved");

        //Check Dedicated
        client.findElement(By.id("article_is_dedicated")).click();

        //Select Three-Column Template
        iHelper_client.selectFromDropdown("article_article_template_id","option","Three-Column");

        //Select Author: Russ Brandom
        iHelper_client.selectFromDropdown("article_author_id","option","Russ Brandom");

        //From display
        client.findElement(By.id("details_from_display")).sendKeys("test <test@test.com>");

        //Select Segment: QA
        iHelper_client.selectFromDropdown("details_segment","option","QA Addresses");

        //Enter Article Title:

        //client.findElement(By.id("article_name")).clear();
        client.findElement(By.id("article_name")).sendKeys("Test Three-Column Article Title "+ date);

        //Enter Business Name/Subject
        //client.findElement(By.id("article_business_name")).clear();
        client.findElement(By.id("article_business_name")).sendKeys("Test Three-Column Business Name "+ date);

        //Enter Article Subheader
        client.findElement(By.id("article_teaser")).sendKeys("Test Three-Column Article Subheader "+ date);

        //Enter Email Subject Line
        client.findElement(By.id("article_email_subject_line")).sendKeys("Test Three-Column Email Subject "+ date);

        //Save
        client.findElement(By.name("save")).click();
        this.pause(7000);

// Get Article ID

        String articleLink = client.getCurrentUrl();

        String[] separated = articleLink.split("/");
        String articleID = separated[separated.length - 1];


//Add images to Article

        // go to create image page
        client.get(UD_ADMIN_DOMAIN+"/article_images/create");

//browse to 1st image
        client.findElement(By.id("article_image_name")).sendKeys(IMAGE_PATH + "image001_optionA.jpg");

        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        //enter Position for 1st image: Option A Left Column

        iHelper_client.selectFromDropdown("article_image_article_image_position_id","option","Option_A_Left_Column");

        //click "save and add" button

        client.findElement(By.name("save_and_add")).click();
        this.pause(7000);


//browse to 2nd image
        client.findElement(By.id("article_image_name")).sendKeys(IMAGE_PATH + "image002_EmailBanner.jpg");

        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        //enter Position for 1st image: Option A Left Column

        iHelper_client.selectFromDropdown("article_image_article_image_position_id","option","Email_Banner");

        //click "save and add" button

        client.findElement(By.name("save_and_add")).click();
        this.pause(7000);

//browse to 3rd image
        client.findElement(By.id("article_image_name")).sendKeys(IMAGE_PATH + "image003_thumbnail.jpg");

        //enter Article ID
        client.findElement(By.id("article_image_article_id")).sendKeys(articleID);

        //enter Position for 1st image: Option A Left Column
        iHelper_client.selectFromDropdown("article_image_article_image_position_id","option","Thumbnail");

//click "save and add" button

        client.findElement(By.name("save")).click();
        this.pause(7000);

//go back to the article
        client.get(UD_ADMIN_DOMAIN+"/articles/edit/id/"+articleID);

//enter photo credits
        client.findElement(By.id("article[photo_credit]")).sendKeys("Three-Column Photo Credits Test "+ date);

//enter Article/Feature introduction
        client.findElement(By.id("article[short]")).sendKeys("Three-Column Article/Feature Introduction Test "+ date);

//enter Copy  
        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('article[content]').SetHTML('Three-Column Article Copy Test'))");

//Article Blurb
        client.findElement(By.id("article[blurb]")).sendKeys("Three-Column Article Blurb Test "+ date);

//iPhone Blurb
        client.findElement(By.id("article[blurb_iphone]")).sendKeys("Three-Column iPhone Blurb Test "+ date);

//Twitter Blurb
        client.findElement(By.id("article_blurb_twitter")).sendKeys("Three-Column Twitter Blurb Test "+ date);

//enter Note 
        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('article[footer]').SetHTML('Three-Column Article Footer Test'))");

//Legal Line
        client.findElement(By.id("article[footer_additional]")).sendKeys("Three-Column Legal Line Test "+ date);

//Keywords
        client.findElement(By.id("article_keywords")).sendKeys("Three-Column Keywords Test Keywords "+ date);

//Business type
        iHelper_client.selectFromDropdown("article_business_type_id","option","Clothing");

//Business specialty

        client.findElement(By.id("article_business_specialty")).sendKeys("Three-Column Business Specialty Test "+ date);

//Save
        client.findElement(By.name("save")).click();
        this.pause(7000);

// Add Vitals to the Left Module,
        iHelper_client.selectFromDropdown("_select_modules_left","option","Vitals");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//Add Sponsored Love to the Left Module,	    

        iHelper_client.selectFromDropdown("_select_modules_left","option","Sponsored Love");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //set main window handle before pop-ups pop up
        String mwh=client.getWindowHandle();

        //click on "Sponsored Love"
        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[3]/div/ul/li[3]/table/tbody/tr/td[5]/a")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Save default selection / assignment of newsletter slot

        //handle pop-up window
        Set<?> s=client.getWindowHandles();
        //this method will you handle of all opened windows

        Iterator<?> ite=s.iterator();

        while(ite.hasNext())
        {
            String popupHandle=ite.next().toString();
            if(!popupHandle.contains(mwh))
            {
                client.switchTo().window(popupHandle);
                this.pause(3000);
                // click save
                client.findElement(By.id("save_button")).click();

                //After finished your operation in pop-up just select the main window again
                client.switchTo().window(mwh);
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//Add Tools to the left Module,

        iHelper_client.selectFromDropdown("_select_modules_left","option","Tools");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//Add an Ad to the Bottom Module, 
        //iHelper_client.selectFromDropdown("_select_modules_center","option","Ad");
        WebElement add_bottom_components = client.findElement(By.id("_select_modules_center"));
        List<WebElement> add_bottom_components_options = add_bottom_components.findElements(By.tagName("option"));
        for(WebElement option : add_bottom_components_options){
            if(option.getText().equals("Ad")) {
                option.click();
                break;
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //click on "Ad"
        //client.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[4]/div/ul/li/table/tbody/tr/td[5]/a")).click();
        client.findElement(By.xpath("/html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[4]/div/ul/li/table/tbody/tr/td[5]/a")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // Save default selection / assignment of newsletter slot

        //handle pop-up window
        Set<?> s2=client.getWindowHandles();
        //this method will you handle of all opened windows

        Iterator<?> ite2=s2.iterator();

        while(ite2.hasNext())
        {
            String popupHandle=ite2.next().toString();
            if(!popupHandle.contains(mwh))
            {
                client.switchTo().window(popupHandle);
                // click save
                this.pause(3000);
                iHelper_client.selectFromDropdown(findElementAndCheckBy("name","newsletter_content_slot[name]",10),"option","Absolut Glimmer BOS 12-27-11 footer (Footer)");
                findElementAndCheckBy("id","save_button",5).click();
                this.pause(7000);

                //After finished your operation in pop-up just select the main window again
                client.switchTo().window(mwh);
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//Add an Ad to the Right Module, 
        //iHelper_client.selectFromDropdown("_select_modules_right","option","Ad");
        WebElement add_right_components = client.findElement(By.id("_select_modules_right"));
        List<WebElement> add_right_components_options = add_right_components.findElements(By.tagName("option"));
        for(WebElement option : add_right_components_options){
            if(option.getText().equals("Ad")) {
                option.click();
                break;
            }
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //click on "Ad"
        findElementAndCheckBy("xpath","//html/body/div[3]/div/div[2]/form/fieldset[7]/div/div/div/div[2]/div/div/table/tbody/tr[3]/td[5]/div/ul/li/table/tbody/tr/td[5]/a",5).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Save default selection / assignment of newsletter slot

        //handle pop-up window
        Set<?> s3=client.getWindowHandles();
        //this method will you handle of all opened windows

        Iterator<?> ite3=s3.iterator();

        while(ite3.hasNext())
        {
            String popupHandle=ite3.next().toString();
            if(!popupHandle.contains(mwh))
            {
                client.switchTo().window(popupHandle);

                // click save
                this.pause(3000);
                iHelper_client.selectFromDropdown(findElementAndCheckBy("xpath","/html/body/div/div[2]/div/div/form/fieldset/div/div/select",5),"option","Absolut Glimmer BOS 12-12-11 tower (Tower)");
                client.findElement(By.id("save_button")).click();
                this.pause(7000);

                //After finished your operation in pop-up just select the main window again
                client.switchTo().window(mwh);
            }
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//Click Save, 

        client.findElement(By.name("save")).click();
        this.pause(7000);

//Click HTML Newsletter, 
//Click Send Email, 
        //client.findElement(By.xpath("//html/body/div[3]/div/div/table/tbody/tr/td[2]/a[2]"));
        //or
        client.get(UD_ADMIN_DOMAIN+"/articles/sendMailing/id/"+articleID);

//Click send Test Mailing, 
        client.findElement(By.name("is_test")).click();
// Confirm Alert
        // Get a handle to the open alert, prompt or confirmation
        Alert alert = client.switchTo().alert();
        // Get the text of the alert or prompt
        alert.getText();
        // And acknowledge the alert (equivalent to clicking "OK")
        this.pause(3000);
        alert.accept();

        this.pause(7000);
        // Verify "Test email has been sent" success message


        Assert.assertTrue(findElementAndCheckBy("xpath","//html/body/div[3]/div/div/h2",5).getText().contains("Test email has been sent"));
        //Assert.assertTrue(client.findElement(By.xpath("//html/body/div[3]/div/div/h2")).getText().contains("Test email has been sent"));

//Add an e-mail address to the Send To field, Click Send Test Mailing, 
        client.findElement(By.id("mailing_send_to")).sendKeys("udtesterjenkins@gmail.com");

        //Click send Test Mailing,
        client.findElement(By.name("is_test")).click();
        // Confirm Alert
        // Get a handle to the open alert, prompt or confirmation
        Alert alert2 = client.switchTo().alert();
        // Get the text of the alert or prompt
        alert2.getText();
        // And acknowledge the alert (equivalent to clicking "OK")
        alert2.accept();
        this.pause(7000);

        // Verify "Test email has been sent" success message
        Assert.assertTrue(findElementAndCheckBy("xpath","//html/body/div[3]/div/div/h2",5).getText().contains("Test email has been sent."));

//Click Back to Article, Change Status to Ready to Send, Click Save, Click Send E-mail, Click Send Mailing at bottom of page
        //go back to the article
        client.get(UD_ADMIN_DOMAIN+"/articles/edit/id/"+articleID);
        this.pause(3000);

        //Change Status to Ready to Send, Click Save,

        //Set Status to Approved

        iHelper_client.selectFromDropdown("article_article_status_id","option","Ready to Send");

        //Save
        client.findElement(By.name("save")).click();

        //Click Send E-mail or go to sendMailing page
        client.get(UD_ADMIN_DOMAIN+"/articles/sendMailing/id/"+articleID);

        //click "Send Mailing" button
        client.findElement(By.xpath("//html/body/div[3]/div/form/div/input")).click();

        // Confirm Alert
        // Get a handle to the open alert, prompt or confirmation
        Alert alert3 = client.switchTo().alert();
        // Get the text of the alert or prompt
        alert3.getText();
        // And acknowledge the alert (equivalent to clicking "OK")
        alert3.accept();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

// Verify "Email has been sent successfully." success message
        Assert.assertTrue(client.findElement(By.xpath("//html/body/div[3]/div/div/h2")).getText().contains("Email has been sent successfully."));

    }

    /**
     * Create a member source
     */
    public void createMemberSource(String memberSource){

        //1. Click create member source
        //2. Enter name for member source
        //3. Choose subscribe type (can use default  one if you want)
        //4. Click save

        client.get(UD_ADMIN_DOMAIN+"/member_sources/edit");
        this.pause(3000);
        //enter Unique Name
        client.findElement(By.id("member_source_name")).sendKeys(memberSource);

        //hit save
        client.findElement(By.name("save_and_list")).click();
    }

    /**
     * Create a PMT
     */
    public void createPMT(String memberSource){
        emailHelper_Client = new EmailHelper_Client(client);
        String date = emailHelper_Client.generateDate("DDD_HH_mm_SSS");

        //1. Go to Campaign Templates under Partnerships
        //2. Click on Create

        client.get(UD_ADMIN_DOMAIN+"/pmt_universal_settings/create");
        // Make sure the page loaded
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_edit_form']/ul/li[2]/input",10);

        //3. Enter Name
        String campaignName ="PMT "+  date;
        client.findElement(By.id("pmt_universal_settings_name")).sendKeys(campaignName);

        //4. Choose Campaign end date some day in the future

        client.findElement(By.id("pmt_universal_settings_campaign_end_date")).sendKeys("2013-08-23 17:39");

        //5. Uncheck Campaign Disabled

        client.findElement(By.id("pmt_universal_settings_campaign_disabled")).click();

        //Select Member source created earlier

        WebElement status = client.findElement(By.id("pmt_universal_settings_member_source_id"));
        List<WebElement> status_options = status.findElements(By.tagName("option"));
        for(WebElement option : status_options){
            if(option.getText().equals(memberSource)) {
                option.click();
                break;
            }
        }

        //6. Check User picks editions

        client.findElement(By.id("pmt_universal_settings_user_picks_editions")).click();

        //7. Check User invites friends

        client.findElement(By.id("pmt_universal_settings_user_invites_friends")).click();

        //8. Choose a background image, must be 1280 by 568

        String PMTBackground = IMAGE_PATH + "background image.jpg";
        System.out.println(PMTBackground);
        client.findElement(By.id("pmt_universal_settings_background_image_path")).sendKeys(PMTBackground);

        //9. Choose a logo, must be 250 by 100

        //selected by Default

        //10. Choose a new Accent color hex, ex: 00FFFF
        client.findElement(By.id("pmt_universal_settings_accent_color_hex")).clear();
        client.findElement(By.id("pmt_universal_settings_accent_color_hex")).sendKeys("00FFFF");

        //11. Enter footer text
        // figure out how to write to wysiwyg editor now!!!
        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_universal_settings[footer_text]').SetHTML('Footer Text Test'))");

        //12. Link to a pdf for Rules and regs

        // not sure why this won't work
        String PMTPdf = IMAGE_PATH + "rules_regulations.pdf";
        System.out.println(PMTPdf);
        client.findElement(By.id("pmt_universal_settings_rules_and_regulations_path")).sendKeys(PMTPdf);

        //13. Click SAVE
        //???	 ↓ Only PDF files are allowed  ↓ for Rules and Regulations field???

        client.findElement(By.name("save")).click();

        // Make sure Success message displays
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_content']/div/h2",10);

        client.findElement(By.name("save_and_add")).click();

        //19. Click Add Partner
        // Partner 1

        WebElement addPartner = findElementAndCheckBy("xpath","//html/body/div[3]/div/div[3]/ul/li[2]/input",10);
        addPartner.click();

        //20. Enter partner name

        client.findElement(By.id("pmt_partner_settings_name")).sendKeys("Partner1 "+  date);

        //21. Enter opt in text

        client.findElement(By.id("pmt_partner_settings_opt_in_text")).sendKeys("Opt in text1 "+  date);

        //22. Enter privacy policy url

        client.findElement(By.id("pmt_partner_settings_privacy_policy_url")).sendKeys("http://ud-branch.thedaddy.co/privacypolicy");

        //23. Enter text in privacy policy label

        client.findElement(By.id("pmt_partner_settings_privacy_policy_label")).sendKeys("Privacy policy label1 "+  date);

        //24. Choose logo, must be 170 by 97

        client.findElement(By.id("pmt_partner_settings_logo_path")).sendKeys(IMAGE_PATH + "partner logo-1.png");

        //25. Click Save

        client.findElement(By.name("save")).click();
        findElementAndCheckBy("xpath","/html/body/div[3]/div/div[2]/div/h2",10);


        //26. Click List

        client.findElement(By.xpath(".//*[@id='sf_admin_edit_form']/ul/li[1]/input")).click();


        //27. Repeat Steps 19-26 for 2nd partner slot

        //19. Click Add Partner
        // Partner 2

        WebElement addPartner2 = findElementAndCheckBy("xpath","//html/body/div[3]/div/div[3]/ul/li[2]/input",10);
        addPartner2.click();


        //20. Enter partner name

        client.findElement(By.id("pmt_partner_settings_name")).sendKeys("Partner2 "+  date);

        //21. Enter opt in text

        client.findElement(By.id("pmt_partner_settings_opt_in_text")).sendKeys("Opt in text2 "+  date);

        //22. Enter privacy policy url

        client.findElement(By.id("pmt_partner_settings_privacy_policy_url")).sendKeys("http://ud-branch.thedaddy.co/privacypolicy");

        //23. Enter text in privacy policy label

        client.findElement(By.id("pmt_partner_settings_privacy_policy_label")).sendKeys("Privacy policy label2 "+  date);

        //24. Choose logo, must be 170 by 97

        client.findElement(By.id("pmt_partner_settings_logo_path")).sendKeys(IMAGE_PATH + "partner logo-2.png");

        //25. Click Save

        client.findElement(By.name("save")).click();
        findElementAndCheckBy("xpath","/html/body/div[3]/div/div[2]/div/h2",10);

        //26. Click List

        findElementAndCheckBy("xpath",".//*[@id='sf_admin_edit_form']/ul/li[1]/input",10).click();
        //client.findElement(By.xpath(".//*[@id='sf_admin_edit_form']/ul/li[1]/input")).click();


        //28. Click Next Step

        findElementAndCheckBy("xpath","//html/body/div[3]/div/div[3]/ul/li[4]/input",10).click();
//        client.findElement(By.xpath("//html/body/div[3]/div/div[3]/ul/li[4]/input")).click();
//        this.pause(3000);


        //29. Add Header text
        // Make sure we're on the next page
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_container']/h1",10);
        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_signup_settings[header1_text]').SetHTML('Signup Header Text Test'))");

        //30. Add Subhead text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_signup_settings[header2_text]').SetHTML('Signup Subheader Text Test'))");

        //31. Add Bottom text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_signup_settings[bottom_text]').SetHTML('Signup Bottom Text Test'))");

        //32. Click next step

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/ul/li[4]/input")).click();
        // Wait for success message
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_content']/div/h2",10);

        //33. Select all editions

        //find editions selector
        Select EditionsMulitpleSelection = new Select(client.findElement(By.id("unassociated_preselected_editions")));

        //select all editions
        EditionsMulitpleSelection.selectByVisibleText("National");
        EditionsMulitpleSelection.selectByVisibleText("National Perks");
        EditionsMulitpleSelection.selectByVisibleText("Atlanta");
        EditionsMulitpleSelection.selectByVisibleText("Boston");
        EditionsMulitpleSelection.selectByVisibleText("Boston Perks");
        EditionsMulitpleSelection.selectByVisibleText("Chicago");
        EditionsMulitpleSelection.selectByVisibleText("Chicago Perks");
        EditionsMulitpleSelection.selectByVisibleText("Dallas");
        EditionsMulitpleSelection.selectByVisibleText("DC");
        EditionsMulitpleSelection.selectByVisibleText("DC Perks");
        EditionsMulitpleSelection.selectByVisibleText("Los Angeles");
        EditionsMulitpleSelection.selectByVisibleText("Los Angeles Perks");
        EditionsMulitpleSelection.selectByVisibleText("Miami");
        EditionsMulitpleSelection.selectByVisibleText("Miami Perks");
        EditionsMulitpleSelection.selectByVisibleText("New York");
        EditionsMulitpleSelection.selectByVisibleText("New York Perks");
        EditionsMulitpleSelection.selectByVisibleText("Philly");
        EditionsMulitpleSelection.selectByVisibleText("San Francisco");
        EditionsMulitpleSelection.selectByVisibleText("Seattle");
        EditionsMulitpleSelection.selectByVisibleText("Driven");
        EditionsMulitpleSelection.selectByVisibleText("Jetset");
        EditionsMulitpleSelection.selectByVisibleText("Las Vegas");
        EditionsMulitpleSelection.selectByVisibleText("Ski & Board");

        //34. Click Right blue arrow to move them to the Selected column

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/fieldset/div[2]/div/div/div[2]/input")).click();

        //35. Add Header text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_edition_settings[header1_text]').SetHTML('Editions Header Text Test'))");
        //this.pause4();

        //36. Add subheader text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_edition_settings[header2_text]').SetHTML('Editions Subheader Text Test'))");
        //this.pause4();

        //37. Add bottom text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_edition_settings[bottom_text]').SetHTML('Editions Bottom Text Test'))");
        //this.pause4();

        //38. Click Next Step

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/ul/li[4]/input")).click();
        // Wait for success message
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_content']/div/h2",10);


        //39. Add Invite Friends Head text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_invite_friends_settings[header1_text]').SetHTML('Invite Friends Header Text Test'))");
        //this.pause4();

        //40. Add Invite Friends Subhead text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_invite_friends_settings[header2_text]').SetHTML('Invite Friends Subheader Text Test'))");
        //this.pause4();

        //41. Add Invite Friends bottom text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_invite_friends_settings[bottom_text]').SetHTML('Invite Friends Bottom Text Test'))");
        //this.pause4();

        //42. Click Next Step

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/ul/li[4]/input")).click();
        // Wait for success message
        findElementAndCheckBy("xpath","/html/body/div[3]/div/div[2]/div/h2",10);


        //43. Add thank you head text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_thank_you_settings[header1_text]').SetHTML('Thank You Header Text Test'))");

        //44. Add thank you sub text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_thank_you_settings[header2_text]').SetHTML('Thank You Subheader Text Test'))");

        //45. Add thank you bot text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_thank_you_settings[bottom_text]').SetHTML('Thank You Bottom Text Test'))");

        //46. Add twitter copy

        client.findElement(By.id("pmt_thank_you_settings_twitter_copy")).sendKeys("Twitter copy "+  date);

        //47. Add FB title

        client.findElement(By.id("pmt_thank_you_settings_facebook_title")).sendKeys("FB Title copy "+  date);

        //48. Add FB Copy

        client.findElement(By.id("pmt_thank_you_settings_facebook_copy")).sendKeys("FB copy "+  date);

        //49. Choose FB image, must be 50 X 50

        client.findElement(By.id("pmt_thank_you_settings_facebook_image_path")).sendKeys(IMAGE_PATH + "fb-image-test.jpg");

        //50. Choose Module 1 Image

        client.findElement(By.id("pmt_thank_you_settings_module1_image_path")).sendKeys(IMAGE_PATH + "Thank You-Campaign Closed Page Image Module-driven.jpg");

        //51. Add Module 1 URL

        client.findElement(By.id("pmt_thank_you_settings_module1_url")).sendKeys("http://www.ThankYouSettingsModule1url.com");

        //52. Choose Module 2 image

        client.findElement(By.id("pmt_thank_you_settings_module2_image_path")).sendKeys(IMAGE_PATH + "Thank You-Campaign Closed Page Image Module-jetset.jpg");

        //53. Add module 2 url

        client.findElement(By.id("pmt_thank_you_settings_module2_url")).sendKeys("http://www.ThankYouSettingsModule2url.com");

        //54. Choose Module 3 image

        client.findElement(By.id("pmt_thank_you_settings_module3_image_path")).sendKeys(IMAGE_PATH + "Thank You-Campaign Closed Page Image Module-perks.jpg");

        //55. Add module 3 url

        client.findElement(By.id("pmt_thank_you_settings_module3_url")).sendKeys("http://www.ThankYouSettingsModule3url.com");

        //56. Click Next Step

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/ul/li[4]/input")).click();
        //Check for success message
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_content']/div/h2",10);

        //57. Repeat Steps for the Closed page

        //Add Closed head text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_closed_settings[header1_text]').SetHTML('Closed Page Header Text Test'))");

        //Add thank you sub text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_closed_settings[header2_text]').SetHTML('Closed Page Subheader Text Test'))");

        //Add thank you bot text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_closed_settings[bottom_text]').SetHTML('Closed Page Bottom Text Test'))");


        // Choose Module 1 Image

        client.findElement(By.id("pmt_closed_settings_module1_image_path")).sendKeys(IMAGE_PATH + "Thank You-Campaign Closed Page Image Module-driven.jpg");

        //51. Add Module 1 URL

        client.findElement(By.id("pmt_closed_settings_module1_url")).sendKeys("http://www.ClosedSettingsModule1url.com");

        //52. Choose Module 2 image

        client.findElement(By.id("pmt_closed_settings_module2_image_path")).sendKeys(IMAGE_PATH + "Thank You-Campaign Closed Page Image Module-jetset.jpg");

        //53. Add module 2 url

        client.findElement(By.id("pmt_closed_settings_module2_url")).sendKeys("http://www.ClosedSettingsModule2url.com");

        //54. Choose Module 3 image

        client.findElement(By.id("pmt_closed_settings_module3_image_path")).sendKeys(IMAGE_PATH + "Thank You-Campaign Closed Page Image Module-perks.jpg");

        //55. Add module 3 url

        client.findElement(By.id("pmt_closed_settings_module3_url")).sendKeys("http://www.ClosedSettingsModule3url.com");

        //56. Click Next Step

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/ul/li[4]/input")).click();
        // Check for success message
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_content']/div/h2",10);

        //58. Invite Email Settings

        //Choose Invite Email Header Image

        client.findElement(By.id("pmt_invite_email_settings_header_image_path")).sendKeys(IMAGE_PATH + "email-header Image.jpg");

        //Subject Text

        client.findElement(By.id("pmt_invite_email_settings_subject_text")).sendKeys("Email subject text "+  date);

        //Email Body Text

        ((RemoteWebDriver) client).executeScript("(FCKeditorAPI.GetInstance('pmt_invite_email_settings[body_text]').SetHTML('Invite Email Text Test'))");

        // Click Next Step

        client.findElement(By.xpath("//html/body/div[3]/div/div[2]/form/ul/li[4]/input")).click();
        //Check for success message
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_content']/div/h2",10);

        //59. Go to newly created campaign

        //Back to PMT Universal Settings List

        client.get(UD_ADMIN_DOMAIN+"/pmt_universal_settings");
        // Make sure the page shows up
        findElementAndCheckBy("xpath",".//*[@id='sf_admin_container']/h1",10);


        // Get the campaign just created
        System.out.println(campaignName);
        WebElement campaignLink = client.findElement(By.linkText(campaignName));
        client.get(campaignLink.getAttribute("href"));


        //60. 		Check for elements

        //a. Campaign Name = Title of the Page
        //Assert.assertTrue(client.getTitle().equalsIgnoreCase(campaignName));

        //b. Signup Settings Header Text
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/section/form/section/h1")).getText().contains("Signup Header Text Test"));  

        //c. Signup Settings Subheader Text
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/section/form/section/h2")).getText().contains("Signup Subheader Text Test"));

        //d. Signup Settings Bottom Text
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/section/form/section/p")).getText().contains("Signup Bottom Text Test"));

        //e. Optin Text1
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/section/form/section[2]/ul/li[2]/label")).getText().contains("Opt in text1 " +  date));

        //f. Optin Text2
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/section/form/section[2]/ul/li[3]/label")).getText().contains("Opt in text2 " +  date));

        //g. Footer Text Test
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/p")).getText().contains("Footer Text Test"));

        //h. Privacy Policy label1
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/ul/li[3]/a")).getText().contains("Privacy policy label1 " +  date));

        //h. Privacy Policy label2
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/ul/li[4]/a")).getText().contains("Privacy policy label2 " +  date));

        //61. 		Enter Email

//				client.findElement(By.xpath("//html/body/section/form/section/fieldset/input")).sendKeys(emailClient);

        //62. 		Enter Zip

//				client.findElement(By.xpath("//html/body/section/form/section/fieldset/input[2]")).sendKeys("10003");

        // leave all check boxes that were checked by default onload checked

        //63. 		Click Enter Button

//				client.findElement(By.name("commit")).click();
//				this.pause(3000);
        //64.  On the Editions Page
        //do checks

        // Edition Settings Bottom Text Test

//				Assert.assertTrue(client.findElement(By.xpath("//html/body/section/form/section[2]/p")).getText().contains("Editions Bottom Text Test"));

        //g. Footer Text Test
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/p")).getText().contains("Footer Text Test"));

        //h. Privacy Policy label1
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/ul/li[3]/a")).getText().contains("Privacy policy label1 " +  date));

        //h. Privacy Policy label2
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/ul/li[4]/a")).getText().contains("Privacy policy label2 " +  date));

        //65. Click Enter Button

//				client.findElement(By.name("commit")).click();
//				this.pause(3000);

        //66. On Invite Friends Page
        // do checks

        // Invite Friends Settings Bottom Text Test

//				Assert.assertTrue(client.findElement(By.xpath("//html/body/section/form/section[2]/p")).getText().contains("Invite Friends Bottom Text Test"));

        //g. Footer Text Test
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/p")).getText().contains("Footer Text Test"));

        //h. Privacy Policy label1
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/ul/li[3]/a")).getText().contains("Privacy policy label1 " +  date));

        //h. Privacy Policy label2
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/ul/li[4]/a")).getText().contains("Privacy policy label2 " +  date));

        //67. click "More" link thrice
//				client.findElement(By.xpath("//html/body/section/form/section/fieldset/div[2]/ul/li[4]/a")).click();
//				this.pause4();
//				client.findElement(By.xpath("//html/body/section/form/section/fieldset/div[2]/ul/li[4]/a")).click();
//				this.pause4();
//				client.findElement(By.xpath("//html/body/section/form/section/fieldset/div[2]/ul/li[4]/a")).click();
//				this.pause4();

        //68. enter all the fields
        // Your name
//				client.findElement(By.id("from_name")).sendKeys("UD Tester");

        // Friend 1

//				client.findElement(By.id("friends")).sendKeys(emailFriend1);

        // Friend 2

//				client.findElement(By.xpath("(//input[@id='friends'])[2]")).sendKeys(emailFriend3);

        // Friend 3

//				client.findElement(By.xpath("(//input[@id='friends'])[3]")).sendKeys(emailFriend3);

        // Friend 4

//				client.findElement(By.xpath("(//input[@id='friends'])[4]")).sendKeys(emailFriend4);

        // Friend 5

//				client.findElement(By.xpath("(//input[@id='friends'])[5]")).sendKeys(emailFriend5);

        // Friend 6

//				client.findElement(By.xpath("(//input[@id='friends'])[6]")).sendKeys(emailFriend6);


        //67. Click Invite
//				client.findElement(By.name("commit")).click();
//				this.pause(3000);
        //68. On Thank you page
        //do checks

        // Thank You Settings Bottom Text Test

//				Assert.assertTrue(client.findElement(By.xpath("//html/body/section/section[2]/p")).getText().contains("Thank You Bottom Text Test"));

        //g. Footer Text Test
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/p")).getText().contains("Footer Text Test"));

        //h. Privacy Policy label1
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/ul/li[3]/a")).getText().contains("Privacy policy label1 " +  date));

        //h. Privacy Policy label2
//				Assert.assertTrue(client.findElement(By.xpath("//html/body/footer/nav/ul/li[4]/a")).getText().contains("Privacy policy label2 " +  date));

    }

    /**
     * Return to the Urban Daddy Homepage
     *
     */
    public void goBackToUDHomepage(){

        client.get(UD_DOMAIN);

    }

    /**
     * Check the Urban Daddy header while logged out
     * Confirm each link by clicking on it
     *
     */
    public void checkUDHomepageCityHeaderLoggedOut(){

        //do all homepage footer checks
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
        Assert.assertTrue(ud_headerHelper_Client.isNightlifePresent());
        Assert.assertTrue(ud_headerHelper_Client.isFoodPresent());
        Assert.assertTrue(ud_headerHelper_Client.isStylePresent());
        Assert.assertTrue(ud_headerHelper_Client.isGearPresent());
        Assert.assertTrue(ud_headerHelper_Client.isLeisurePresent());
        Assert.assertTrue(ud_headerHelper_Client.isDrivenPresent());
        Assert.assertTrue(ud_headerHelper_Client.isPerksPresent());
        Assert.assertTrue(ud_headerHelper_Client.isPartiesPresent());
        Assert.assertTrue(ud_headerHelper_Client.isKemptPresent());
        Assert.assertTrue(ud_headerHelper_Client.isMobilePresent());

        lastURL = client.getCurrentUrl();

        ud_headerHelper_Client.clickNightlife();
        this.pause(7000);
        Assert.assertTrue(isNightlifeAccessible(),"Night Life Wasn't Accessible");
        ud_headerHelper_Client.clickFood();
        this.pause(7000);
        Assert.assertTrue(isFoodAccessible(),"Food wasn't accessible");
        ud_headerHelper_Client.clickStyle();
        this.pause(7000);
        Assert.assertTrue(isStyleAccessible(), "Style wasn't accessible");
        ud_headerHelper_Client.clickGear();
        this.pause(7000);
        Assert.assertTrue(isGearAccessible(), "Gear wasn't accessible");
        ud_headerHelper_Client.clickLeisure();
        this.pause(7000);
        Assert.assertTrue(isLeisureAccessible(),"Leisure wasn't accessible");

        ud_headerHelper_Client.clickDriven();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isDrivenAccessible(), "Driven wasn't accessible");
        client.get(lastURL);

        ud_headerHelper_Client.clickPerks();
        this.pause(7000);
        Assert.assertTrue(isPerksAccessible(),"Perks wasn't accessible");
        client.get(lastURL);

        ud_headerHelper_Client.clickParties();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isPartiesAccessible(), "Parties wasn't accessible");
        client.get(lastURL);

        ud_headerHelper_Client.clickKempt();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isKemptAccessible(), "Kempt wasn't accessible");
        client.get(lastURL);

        ud_headerHelper_Client.clickMobile();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isMobileAccessible(), "Mobile wasn't accessible");
        client.get(lastURL);


    }

    /**
     * Check the Urban Daddy header with Las Vegas as the city
     * Confirm each link by clicking on it
     *
     */
    public void checkUDHomepageLasVegasHeaderLoggedOut(){

        //do all homepage footer checks
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
        Assert.assertTrue(ud_headerHelper_Client.isNightlifeLVPresent());
        Assert.assertTrue(ud_headerHelper_Client.isFoodLVPresent());
        Assert.assertTrue(ud_headerHelper_Client.isEntertainmentLVPresent());
        Assert.assertTrue(ud_headerHelper_Client.isPerksLVPresent());
        Assert.assertTrue(ud_headerHelper_Client.isPartiesLVPresent());
        Assert.assertTrue(ud_headerHelper_Client.isKemptLVPresent());
        Assert.assertTrue(ud_headerHelper_Client.isMobileLVPresent());

        ud_headerHelper_Client.clickNightlifeLV();
        this.pause(7000);
        Assert.assertTrue(isNightlifeAccessible());
        ud_headerHelper_Client.clickFoodLV();
        this.pause(7000);
        Assert.assertTrue(isFoodAccessible());
        ud_headerHelper_Client.clickEntertainmentLV();
        this.pause(7000);
        lastURL = client.getCurrentUrl();
        Assert.assertTrue(isEntertainmentAccessible());

        ud_headerHelper_Client.clickPerksLV();
        this.pause(7000);
        Assert.assertTrue(isPerksAccessible());
        //client.navigate().back();
        client.get(lastURL);

        ud_headerHelper_Client.clickPartiesLV();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isPartiesLVAccessible());
        //client.navigate().back();
        client.get(lastURL);

        ud_headerHelper_Client.clickKemptLV();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isKemptLVAccessible());
        //client.navigate().back();
        client.get(lastURL);

        ud_headerHelper_Client.clickMobileLV();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isMobileLVAccessible());
        //client.navigate().back();
        client.get(lastURL);


    }

    /**
     * Check the Urban Daddy national header while logged out
     * Confirm each link by clicking on it
     *
     */
    public void checkUDHomepageNationalHeaderLoggedOut(){

        //do all homepage footer checks
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
        Assert.assertTrue(ud_headerHelper_Client.isFoodDrinkNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isStyleNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isGearNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isEntertainmentNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isTravelNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isDrivenNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isPerksNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isPartiesNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isKemptNationalPresent());
        Assert.assertTrue(ud_headerHelper_Client.isMobileNationalPresent());

        ud_headerHelper_Client.clickFoodDrinkNational();
        this.pause(7000);
        Assert.assertTrue(isFoodDrinkNationalAccessible());
        ud_headerHelper_Client.clickStyleNational();
        this.pause(7000);
        Assert.assertTrue(isStyleAccessible());
        ud_headerHelper_Client.clickGearNational();
        this.pause(7000);
        Assert.assertTrue(isGearAccessible());
        ud_headerHelper_Client.clickEntertainmentNational();
        this.pause(7000);
        Assert.assertTrue(isEntertainmentAccessible());
        ud_headerHelper_Client.clickTravelNational();
        this.pause(7000);
        lastURL = client.getCurrentUrl();

        Assert.assertTrue(isTravelAccessible());

        Assert.assertTrue(ud_headerHelper_Client.isDrivenNationalAccessible());
        //client.navigate().back();
        client.get(lastURL);

        ud_headerHelper_Client.clickPerks();
        this.pause(7000);
        Assert.assertTrue(isPerksAccessible());
        //client.navigate().back();
        client.get(lastURL);

        ud_headerHelper_Client.clickPartiesNational();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isPartiesNationalAccessible());
        //client.navigate().back();
        client.get(lastURL);

        ud_headerHelper_Client.clickKemptNational();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isKemptNationalAccessible());
        //client.navigate().back();
        client.get(lastURL);

        ud_headerHelper_Client.clickMobileNational();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isMobileNationalAccessible());
        //client.navigate().back();
        client.get(lastURL);

    }

    /**
     * Check the Urban Daddy city header while logged in
     * Confirm each link by clicking on it
     *
     */
    public void checkUDHomepageCityHeaderLoggedIn(){

        //do all homepage footer checks
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);

        Assert.assertTrue(ud_headerHelper_Client.isNightlifePresent());
        Assert.assertTrue(ud_headerHelper_Client.isFoodPresent());
        Assert.assertTrue(ud_headerHelper_Client.isStylePresent());
        Assert.assertTrue(ud_headerHelper_Client.isGearPresent());
        Assert.assertTrue(ud_headerHelper_Client.isLeisurePresent());
        Assert.assertTrue(ud_headerHelper_Client.isDrivenPresent());
        Assert.assertTrue(ud_headerHelper_Client.isPerksPresent());
        Assert.assertTrue(ud_headerHelper_Client.isPartiesPresent());
        Assert.assertTrue(ud_headerHelper_Client.isKemptPresent());

        lastURL = client.getCurrentUrl();

        ud_headerHelper_Client.clickNightlife();
        this.pause(7000);
        Assert.assertTrue(isNightlifeAccessible());

        ud_headerHelper_Client.clickFood();
        this.pause(7000);
        Assert.assertTrue(isFoodAccessible());

        ud_headerHelper_Client.clickStyle();
        this.pause(7000);
        Assert.assertTrue(isStyleAccessible());

        ud_headerHelper_Client.clickGear();
        this.pause(7000);
        Assert.assertTrue(isGearAccessible());

        ud_headerHelper_Client.clickLeisure();
        this.pause(7000);
        Assert.assertTrue(isLeisureAccessible());

        ud_headerHelper_Client.clickDriven();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isDrivenAccessible());
        //client.navigate().back(); can't be used with Safari, because its history navigation does not work.
        client.get(lastURL);

        ud_headerHelper_Client.clickPerks();
        this.pause(7000);
        Assert.assertTrue(isPerksAccessible());
        //client.navigate().back(); can't be used with Safari, because its history navigation does not work.
        client.get(lastURL);

        ud_headerHelper_Client.clickParties();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isPartiesAccessible());
        //client.navigate().back(); can't be used with Safari, because its history navigation does not work.
        client.get(lastURL);

        ud_headerHelper_Client.clickKempt();
        this.pause(7000);
        Assert.assertTrue(ud_headerHelper_Client.isKemptAccessible());
        //client.navigate().back(); can't be used with Safari, because its history navigation does not work.
        client.get(lastURL);

    }

    /**
     * Check the Urban Daddy footer
     * Checks to see the links exist
     *
     */
    public void checkUDHomepageFooter(){

        //do all homepage footer checks
        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        Assert.assertTrue(ud_footerHelper_Client.isAboutUsHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isSignUpHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isMyUDHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isContactHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isJobsHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isAdvertiseHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isTipsHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isEmailIssuesHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isPrivacyPolicyHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isUserAgreementHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isUnsubscribeHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isEditorialPolicyHomePresent());


        Assert.assertTrue(ud_footerHelper_Client.isAtlantaHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isBostonHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isChicagoHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isDallasHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isDCHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isDrivenHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isJetsetHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isLasVegasHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isLosAngelesHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isMiamiHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isNationalHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isNewYorkHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isSanFranciscoHomePresent());
        Assert.assertTrue(ud_footerHelper_Client.isSkiBoardHomePresent());

    }

    /**
     * Check the Urban Daddy footer while logged in
     * Checks to see the links exist
     *
     */
    public void checkUDHomepageCityFooterLoggedIn(){

        //do all city homepage footer checks for logged in state
        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        Assert.assertTrue(ud_footerHelper_Client.isAboutUsCityPresent());
        //	Assert.assertTrue(ud_footerHelper_Client.isSignUpPresentCity());
        Assert.assertTrue(ud_footerHelper_Client.isMyUDCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isContactCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isJobsCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isAdvertiseCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isTipsCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isUnsubscribeCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isMobileSiteCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isEmailIssuesCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isPrivacyPolicyCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isUserAgreementCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isEditorialPolicyCityPresent());


        Assert.assertTrue(ud_footerHelper_Client.isAtlantaCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isBostonCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isChicagoCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isDallasCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isDCCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isDrivenCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isJetsetCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isLasVegasCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isLosAngelesCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isMiamiCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isNationalCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isNewYorkCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isSanFranciscoCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isSkiBoardCityPresent());

    }

    /**
     * Check the Urban Daddy footer while logged out
     * Checks to see the links exist
     *
     */
    public void checkUDHomepageCityFooterLoggedOut(){

        //do all city homepage footer checks for logged out state
        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        Assert.assertTrue(ud_footerHelper_Client.isAboutUsCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isSignUpCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isMyUDCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isContactCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isJobsCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isAdvertiseCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isTipsCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isUnsubscribeCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isMobileSiteCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isEmailIssuesCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isPrivacyPolicyCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isUserAgreementCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isEditorialPolicyCityPresent());


        Assert.assertTrue(ud_footerHelper_Client.isAtlantaCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isBostonCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isChicagoCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isDallasCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isDCCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isDrivenCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isJetsetCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isLasVegasCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isLosAngelesCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isMiamiCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isNationalCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isNewYorkCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isSanFranciscoCityPresent());
        Assert.assertTrue(ud_footerHelper_Client.isSkiBoardCityPresent());

    }

    /**
     * Confirm Night Life is accessible
     *
     * @return boolean
     */
    public boolean isNightlifeAccessible(){

        if (client.getCurrentUrl().contains(UD_DOMAIN + "/archives/" + UDcity + "/nightlife"))
            return true;
        return false;

    }

    /**
     * Confirm Food is accessible
     *
     * @return boolean
     */
    public boolean isFoodAccessible(){

        if (client.getCurrentUrl().contains(UD_DOMAIN + "/archives/" + UDcity + "/food"))
            return true;
        return false;

    }

    /**
     * Confirm Food & Drink is accessible
     *
     * @return boolean
     */
    public boolean isFoodDrinkNationalAccessible(){

        if (client.getCurrentUrl().contains(UD_DOMAIN + "/archives/" + UDcity + "/fooddrink"))
            return true;
        return false;

    }

    /**
     * Confirm Entertainment link is accessible
     *
     * @return boolean
     */
    public boolean isEntertainmentAccessible(){

        if (client.getCurrentUrl().contains(UD_DOMAIN + "/archives/" + UDcity + "/entertainment"))
            return true;
        return false;

    }

    /**
     * Confirm Travel link is accessible
     *
     * @return boolean
     */
    public boolean isTravelAccessible(){

        if (client.getCurrentUrl().contains(UD_DOMAIN + "/archives/" + UDcity + "/travel"))
            return true;
        return false;

    }

    /**
     * Confirm Style link is accessible
     *
     * @return boolean
     */
    public boolean isStyleAccessible(){

        if (client.getCurrentUrl().contains(UD_DOMAIN + "/archives/" + UDcity + "/style"))
            return true;
        return false;

    }

    /**
     * Confirm Gear link is accessible
     *
     * @return boolean
     */
    public boolean isGearAccessible(){

        if (client.getCurrentUrl().contains(UD_DOMAIN + "/archives/" + UDcity + "/gear"))
            return true;
        return false;

    }

    /**
     * Confirm Leisure link is accessible
     *
     * @return boolean
     */
    public boolean isLeisureAccessible(){

        return client.getCurrentUrl().contains(UD_DOMAIN + "/archives/" + UDcity + "/leisure");

    }

    /**
     * Confirm perks link is accessible
     *
     * @return boolean
     */
    public boolean isPerksAccessible(){

        return client.getCurrentUrl().contains(PERKS_DOMAIN + UDcityPerks);

    }

    /**
     * Perform checks on the header and footer while logged out
     *
     */
    public void doChecksCityHomePageLoggedOut() {
        // do all footer checks	for logged out state
//        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        this.checkUDHomepageCityFooterLoggedOut();
        this.checkUDHomepageCityHeaderLoggedOut();
    }

    /**
     * Perform checks on the header and footer while logged in
     *
     */
    public void doChecksCityHomePageLoggedIn(){
        // do all footer checks	for logged in state
//        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        this.checkUDHomepageCityFooterLoggedIn();
        this.checkUDHomepageCityHeaderLoggedIn();
    }

    /**
     * Perform checks on the Las Vegas UD header and footer
     * while logged out
     *
     */
    public void doChecksLVPageLoggedOut() {
        // do all footer checks	for logged out state
//        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        this.checkUDHomepageCityFooterLoggedOut();
        this.checkUDHomepageLasVegasHeaderLoggedOut();
    }

    /**
     * Perform checks on the National UD header and footer
     * while logged out
     *
     */
    public void doChecksNationalPageLoggedOut() {
        // do all footer checks	for logged out state
//        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        this.checkUDHomepageCityFooterLoggedOut();
        this.checkUDHomepageNationalHeaderLoggedOut();
    }

    /**
     * Run this method after logging in to unsubscribe
     * from all perks and editorial emails
     *
     */
    public void unSubscribeFromEmails(){
        // Declare helpers
        ud_sealHelper_Client = new UD_SealHelper_Client(client);
        ud_unSubscribeHelper_client = new UD_UnSubscribeHelper_Client(client);

        // Assume logged in, edit settings
        ud_sealHelper_Client.clickEditSettings();

        // Pause for a couple secs until ajax window shows up
        pause(3000);

        // Uncheck all the editorial boxes
        WebElement editorial = client.findElement(By.className("myUDpopupEditorials"));
        List<WebElement> editions = editorial.findElements(By.tagName("div"));
        for (WebElement edition : editions) {
            if (edition.findElement(By.tagName("input")).isSelected()) {
                WebElement box = edition.findElement(By.tagName("input"));
                box.click();
            }
        }

        // Uncheck all the perks boxes
        WebElement perksList = client.findElement(By.className("htmlEditionsHolder"));
        List<WebElement> perks = perksList.findElements(By.tagName("div"));
        for (WebElement perk : perks) {
            if (perk.findElement(By.tagName("input")).isSelected()) {
                WebElement box = perk.findElement(By.tagName("input"));
                box.click();
            }
        }

        // Click update
        ud_unSubscribeHelper_client.clickUpdate();
        pause(3000);
        // Confirm unsubscription
        ud_unSubscribeHelper_client.confirmUpdate();
        pause(3000);

        // Close the lightbox
        WebElement closeButton = client.findElement(By.className("ajaxClose"));
        closeButton.click();

    }

    /**
     * Confirm the unsubscribe email contains the text
     * "successfully unsubscribed"
     */
    public void unSubscribeMailConfirm(){
        emailHelper_Client = new EmailHelper_Client(client);

        emailHelper_Client.searchEmail("successfully unsubscribed");
    }

    public void silverPopConfirm(){
        emailHelper_Client = new EmailHelper_Client(client);

        emailHelper_Client.silverPopLogin("gmodin@urbandaddy.com", "commonUD77%");
        emailHelper_Client.navigateToSearch();
        Assert.assertTrue(emailHelper_Client.optOutSearch("udtesterjenkins+268_12_59_498@gmail.com"));

    }

    public boolean StaleElementHandleByXpath (String email){
        ud_signupHelper_Client = new UD_SignupHelper_Client(client);
        int count = 0;
        boolean flag = false;
        do {
            try {
                ud_signupHelper_Client.enterEmail(email);
                count++;
                flag = true;
            } catch (StaleElementReferenceException e) {
                e.toString();
                System.out.println("Trying to recover from a stale element: " + e.getMessage());
            }
        } while (count < 4 && !flag);
        if (count >= 4) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Sign up and register for perks & editorial
     * via New York UD edition
     *
     */
    public void signUpUD_viaNewYorkStep1(String email) throws ElementNotVisibleException {

        ud_signupHelper_Client = new UD_SignupHelper_Client(client);
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);

        //go to /home/nyc
		//ud_homepageHelper_Client.clickNewYork();

        //step1, 1st signup modal:
        //a. Click SignUp Seal
        ud_headerHelper_Client.clickSignUp();
        //findElementAndCheckBy("xpath","/html/body/div[5]",10);

        //b. Enter email address
        WebDriverWait wait = new WebDriverWait(client, 30);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        } catch (TimeoutException TE) {
            System.out.println("EMAIL BOX NOT FOUND");
        }
        // Stale element seems to happen here

        if (!StaleElementHandleByXpath(email)) {
            throw new ElementNotVisibleException("Email didn't show up");
        }
        System.out.println("UD EMAIL CLIENT> " + email);

        //c. Select Editions
        //New York, New York Perks are selected by default

        ud_signupHelper_Client.checkDriven();
        ud_signupHelper_Client.checkJetset();
        ud_signupHelper_Client.checkLasVegas();
        ud_signupHelper_Client.checkNational();
        ud_signupHelper_Client.checkSkiBoard();

        //click "more" link to show all Editorials
        ud_signupHelper_Client.clickMoreLinkNewYork1();

        // check all of them
        ud_signupHelper_Client.checkAtlanta();
        ud_signupHelper_Client.checkBoston();
        ud_signupHelper_Client.checkChicago();
        ud_signupHelper_Client.checkDallas();
        ud_signupHelper_Client.checkDC();
        ud_signupHelper_Client.checkLosAngeles();
        ud_signupHelper_Client.checkMiami();
        ud_signupHelper_Client.checkSanFrancisco();

        //click "more" link to see the Perks editions
        ud_signupHelper_Client.clickMoreLinkNewYork2();

        // check all of them
        ud_signupHelper_Client.checkBostonPerks();
        ud_signupHelper_Client.checkChicagoPerks();
        ud_signupHelper_Client.checkDCPerks();
        ud_signupHelper_Client.checkLosAngelesPerks();
        ud_signupHelper_Client.checkMiamiPerks();
        ud_signupHelper_Client.checkNationalPerks();

        //click "JOIN" button
        ud_signupHelper_Client.clickJoin();

        //Wait for the ajax response back. The email address will be displayed in the 'Seal' sign up box.
        WebDriverWait accountVisible = new WebDriverWait(client, 60);
        try {
            accountVisible.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[3]/div[2]/div[2]/div/div[2]/div")));
        } catch (TimeoutException TE) {
            throw new TimeoutException("POST TOOK TOO LONG");
        }
        String theEmail = client.findElement(By.xpath("/html/body/div/div[2]/div[3]/div[2]/div[2]/div/div[2]/div")).getText();
        System.out.println("THE EMAIL> " + theEmail);
    }

    /**
     * Complete registration form by filling out
     * name, gender, income range, zip code, etc.
     */
    public void signUpUD_viaNewYorkStep2(String var){

        ud_signupHelper_Client = new UD_SignupHelper_Client(client);

        //step2, 2nd signup modal:
        //enter PASSWORD
        ud_signupHelper_Client.enterPassword(PASSWORD);
        //confirm PASSWORD
        ud_signupHelper_Client.confirmPassword(PASSWORD);
        //First Name
        ud_signupHelper_Client.enterFirstName("FN_"+var);
        //Last Name
        ud_signupHelper_Client.enterLastName("LN_"+var);
        //Gender
        ud_signupHelper_Client.selectGender("Male");
        //ud_signupHelper_Client.selectGender("Female");
        //ud_signupHelper_Client.selectGenderRandom();

        //Income Range
        ud_signupHelper_Client.selectIncomeRange("Less than $30,000");
//		ud_signupHelper_Client.selectIncomeRange("$30,000-$44,999");
//		ud_signupHelper_Client.selectIncomeRange("$45,000-$59,999");
//		ud_signupHelper_Client.selectIncomeRange("$60,000-$74,999");
//		ud_signupHelper_Client.selectIncomeRange("$75,000-$99,999");
//		ud_signupHelper_Client.selectIncomeRange("$100,000-$199,999");
//		ud_signupHelper_Client.selectIncomeRange("$200,000-$299,999");
//		ud_signupHelper_Client.selectIncomeRange("$300,000-$499,999");
//		ud_signupHelper_Client.selectIncomeRange("$500,000+");
//		ud_signupHelper_Client.selectIncomeRangeRandom();

        //Zip Code
        ud_signupHelper_Client.enterZipCode("10001");
        //Birthday (MM/DD/YYYY)
        ud_signupHelper_Client.enterBirthday("07/07/1977");

        //click "SUBMIT" button
        WebElement submit = client.findElement(By.className("demos")).findElement(By.className("submitButtons")).findElement(By.tagName("input"));
        submit.click();

    }

    /**
     * Fills out the refer a friend form.
     */
    public void signUpUD_viaNewYorkStep3(String[] friend){

        ud_signupHelper_Client = new UD_SignupHelper_Client(client);

    //step3, 3rd signup modal: Invite Friends

        WebDriverWait InviteFriendsWindow = new WebDriverWait(client, 30);
        InviteFriendsWindow.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("ajaxSignupHolder")));

        for (int i = 0; i < friend.length; i++) {
            ud_signupHelper_Client.enterEmailFriend(friend[i],(i+1));
            System.out.println(friend[i]);
        }

        // Try submitting the form instead of clicking the invite button
        ud_signupHelper_Client.clickInvite();
    }

    /**
     * Close the sign up form.
     */
    public void signUpUD_viaNewYorkStep4(){
        //step4, 4th signup modal confirmation, close final confirm signup box
        ud_signupHelper_Client = new UD_SignupHelper_Client(client);

        WebDriverWait ThankYouWindow = new WebDriverWait(client, 30);
        ThankYouWindow.until(ExpectedConditions.visibilityOfElementLocated(By.className("thanks")));

        ud_signupHelper_Client.clickCloseFinalModal();
        //end of registration
    }

    /**
     * Click the change city link from the homepage
     */
    public void changeCityFromUDHomepage(){
        //click on "Change City" from any city home page, navigate back to home page
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);

        ud_headerHelper_Client.clickChangeCity();
    }

    /**
     * Click the Atlanta link from the homepage
     */
    public void accessAtlantaFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickAtlanta();
        UDcity = "atl";
        UDcityPerks = "/national.html";
    }

    /**
     * Click the Boston link from the homepage
     */
    public void accessBostonFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickBoston();
        UDcity = "bos";
        UDcityPerks = "/boston.html";
    }

    /**
     * Click the Chicago link from the homepage
     */
    public void accessChicagoFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickChicago();
        UDcity = "chi";
        UDcityPerks = "/chicago.html";
    }

    /**
     * Click the Dallas link from the homepage
     */
    public void accessDallasFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickDallas();
        UDcity = "dal";
        UDcityPerks = "/national.html";
    }

    /**
     * Click the DC link from the homepage
     */
    public void accessWashingtonDCFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickWashington();
        UDcity = "dc";
        UDcityPerks = "/washington-dc.html";
    }

    /**
     * Click the Jetset link from the homepage
     */
    public void accessJetsetFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickJetset();
        UDcity = "jt";
        UDcityPerks = "/national.html";
    }

    /**
     * Click the Las Vegas link from the homepage
     */
    public void accessLasVegasFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickLasVegas();
        UDcity = "lv";
        UDcityPerks = "/national.html";
    }

    /**
     * Click the LA link from the homepage
     */
    public void accessLosAngelesFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickLosAngeles();
        UDcity = "la";
        UDcityPerks = "/los-angeles.html";
    }

    /**
     * Click the Miami link from the homepage
     */
    public void accessMiamiFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickMiami();
        UDcity = "mia";
        UDcityPerks = "/miami.html";
    }

    /**
     * Click the National edition link from the homepage
     */
    public void accessNationalFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickNational();
        UDcity = "ntl";
        UDcityPerks = "/national.html";
    }

    /**
     * Click the New York link from the homepage
     */
    public void accessNewYorkFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);


        ud_homepageHelper_Client.clickNewYork();
        UDcity = "nyc";
        UDcityPerks = "/new-york.html";
    }

    /**
     * Click the San Francisco link from the homepage
     */
    public void accessSanFranciscoFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickSanFrancisco();
        UDcity = "sfo";
        UDcityPerks = "/national.html";
    }

    /**
     * Click the Ski Board link from the home page
     */
    public void accessSkiBoardFromUDHomepage(){
        ud_homepageHelper_Client = new UD_HomepageHelper_Client(client);

        ud_homepageHelper_Client.clickSkiBoard();
        UDcity = "bos";
        UDcityPerks = "/boston.html";
    }

///////////// Sign-up methods end here		

///////////////  Login/SignOut methods

    /**
     * Login using params from this class
     *
     */
    public void loginUD(String emailClient){
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
        ud_sealHelper_Client = new UD_SealHelper_Client(client);

        client.get(UD_DOMAIN);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //close the sign up modal
        //client.findElement(By.xpath("//div[@id='signInWrapper']/div")).click();


        ud_headerHelper_Client.clickMemberLogIn();
        ud_sealHelper_Client.enterEmailAddress(emailClient);
        ud_sealHelper_Client.enterPassword(PASSWORD);
        ud_sealHelper_Client.clickLogin();

        // do all footer checks	for logged in state
        ud_footerHelper_Client = new UD_FooterHelper_Client(client);
        this.checkUDHomepageCityFooterLoggedIn();
    }

    /**
     * Overloaded login class, use to pass email and PASSWORD in via
     * other tests.
     * ex. currently used in UD_Unsubscribe_EditionsPerks
     * @param email Email address
     * @param pw PASSWORD
     */
    public void loginUD(String email, String pw){
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
        ud_sealHelper_Client = new UD_SealHelper_Client(client);

        client.get(UD_DOMAIN);

        ud_headerHelper_Client.clickMemberLogIn();
        ud_sealHelper_Client.enterEmailAddress(email);
        ud_sealHelper_Client.enterPassword(pw);
        ud_sealHelper_Client.clickLogin();

        WebDriverWait accountVisible = new WebDriverWait(client, 60);
        try {
            accountVisible.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div[2]/div[3]/div[2]/div[2]/div/div[2]/div")));
        } catch (TimeoutException TE) {
            throw new TimeoutException("POST TOOK TOO LONG");
        }
    }

    /**
     * Logout of UD and do checks on the footer
     *
     */
    public void logoutUD(){
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);
        ud_headerHelper_Client.clickLogout();
    }

    /**
     * Perform a PASSWORD reset.
     */
    public void resetPasswordUD(String emailClient){
        ud_sealHelper_Client = new UD_SealHelper_Client(client);
        ud_headerHelper_Client = new UD_HeaderHelper_Client(client);

        ud_headerHelper_Client.clickMemberLogIn();
        ud_sealHelper_Client.clickResetPassword();
        ud_sealHelper_Client.enterEmailToReset(emailClient);
        ud_sealHelper_Client.clickSend();

    }

    /**
     * Login to the UD site then update your account
     * by checking some editions and perks
     *
     */
    public void editSettingsUD(){
        ud_sealHelper_Client = new UD_SealHelper_Client(client);

        ud_sealHelper_Client.clickEditSettings();
        ud_sealHelper_Client.enterPasswordMyUD(PASSWORD);
        ud_sealHelper_Client.confirmPasswordMyUD(PASSWORD);

        ud_sealHelper_Client.checkDC();
        ud_sealHelper_Client.checkPhilly();
        ud_sealHelper_Client.checkSeattle();
        ud_sealHelper_Client.checkDCPerks();

        ud_sealHelper_Client.clickUpdate();
        this.pause(3000);
        ud_sealHelper_Client.clickClose();

    }

    /**
     * Use the findElement method to extend some functionality to searching for
     * elements. Attempts to find the element 3 times before throwing an error.
     *
     * @param type  Search by name, xpath, tagname, classname, css, id
     * @param locator Enter the name of the element you're looking for
     * @param timeout Enter the number of seconds for the timeout
     * @return that web element or throw an error
     */
    public WebElement findElementAndCheckBy(final String type, String locator, int timeout) throws ElementNotVisibleException {
        int counter = 0;
        boolean flag = false;
        final String ele = locator;
        WebElement a = null;


        do {
            try {
                System.out.println("Trying to find the element> " + ele + "\nTimeout in> " + timeout + " seconds.");
                a = (new WebDriverWait(client, timeout)).until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        WebElement ret = null;
                        if (type.equals("name")) {
                            ret = d.findElement(By.name(ele));
                        } else if (type.equals("xpath")) {
                            ret = d.findElement(By.xpath(ele));
                        } else if (type.equals("tagname")) {
                            ret = d.findElement(By.tagName(ele));
                        } else if (type.equals("classname")) {
                            ret = d.findElement(By.className(ele));
                        } else if (type.equals("css")) {
                            ret = d.findElement(By.cssSelector(ele));
                        } else if (type.equals("id")) {
                            ret = d.findElement(By.id(ele));
                        }
                        System.out.println("Found> " + ele);
                        return ret;
                    }
                });
                flag = true;
            } catch (TimeoutException e) {
                counter++;
                System.out.println("Attempt " + counter + ": Could not find> " + ele);
                System.out.println("Trying again");
            }
        } while (counter <= 2 && !flag);
        if (a == null) {
            throw new ElementNotVisibleException("3rd Attempt reached. Could not find> " + ele);
        } else {
            return a;
        }
    }

    /**
     * Use this to handle popups
     * @param winTitle
     * @param client
     * @return
     */
    public String popUpHandler(String winTitle, WebDriver client) {
        String parentWindowHandle=client.getWindowHandle();
        WebDriver popup = null;
        //handle pop-up window
        Set<?> s_add2=client.getWindowHandles();
        //this method will you handle of all opened windows

        Iterator<?> windowIterator=s_add2.iterator();

        while(windowIterator.hasNext()) {
            String windowHandle = windowIterator.next().toString();
            popup = client.switchTo().window(windowHandle);
            if (popup.getTitle().contains(winTitle)) {
                break;
            }
        }
        return parentWindowHandle;
    }

    /**
     * Use this to return to parent window
     * @param parent
     * @param client
     */
    public void returnToParentWindow(String parent, WebDriver client) {
        client.switchTo().window(parent);
    }
}
