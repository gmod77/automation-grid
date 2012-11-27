package org.urbandaddy.com.sauce;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.com.helpers.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

//Workflow specific imports

/**
 * This class contains all Perks domain specific tests
 */
public abstract class iTestCasePerksSauce extends iSauceBase implements UDBase {

    String lastURL;


    Random generator = new Random();
    int r = (generator.nextInt(6) + 1) * 20;

    // Perks

    /**
     * After login navigate to account settings
     */
    public void editSettingsPerks(){
        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);
        //Reuse methods in UD client
        ud_sealHelper_Client = new UD_SealHelper_Client(client);
        lastURL = client.getCurrentUrl();

        perks_headerHelper_Client.clickMyAccount();
        perks_headerHelper_Client.isMyAccountAccessible();

        ud_sealHelper_Client.clickEditSettingsMyUD();
        ud_sealHelper_Client.enterPasswordMyUD(PASSWORD);
        ud_sealHelper_Client.confirmPasswordMyUD(PASSWORD);

        ud_sealHelper_Client.checkDCPerks();


        ud_sealHelper_Client.clickUpdate();
        this.pause(3000);
        ud_sealHelper_Client.clickClose();
    }

    /**
     * Navigate to the Perks domain
     *
     */
    public void visitPerksFirstTime(){

        // enter UD domain name, hit enter, arrive on homepage
        client.get(PERKS_DOMAIN);
        client.manage().deleteAllCookies();
        client.get(PERKS_DOMAIN);
    }

    /**
     * Sign into the perks site
     */
    public void signInPerks(String emailClient){

        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);
        perks_sealHelper_Client = new Perks_SealHelper_Client(client);

        client.get(PERKS_DOMAIN);

        //click signup
        perks_headerHelper_Client.clickSignUp();

        //b. Enter email address
        perks_signupHelper_Client.enterSigninEmail(emailClient);

        perks_signupHelper_Client.enterSigninPassword(PASSWORD);

        perks_signupHelper_Client.clickSignIn();
    }

    public void checkPerksHomepageCityFooter () {

    }

    public void returnToPerks() {
        client.get(PERKS_DOMAIN);
    }

    /**
     * Log out of perks
     */
    public void logoutPerks(){

        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

        //click logout in header
        perks_headerHelper_Client.clickLogout();

        //click logout confirmation
        WebDriverWait waitForContinue = new WebDriverWait(client, 30);
        try {
            waitForContinue.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[2]/div/a/span"))).click();
        } catch (UnhandledAlertException uae) {
            //Workaround for Safari
        }
    }

    /**
     * Send a perks password reset email
     *
     */
    public void resetPasswordPerks(String emailClient){

		// perks_homepageHelper_Client = new Perks_HomepageHelper_Client(client);
		// perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

		// perks_signupHelper_Client = new Perks_SignupHelper_Client(client);

        System.out.println(emailClient);

        //step1, 1st signup modal:
        //a. Click SignUp Seal
        perks_headerHelper_Client.clickSignUp();

        perks_signupHelper_Client.clickForgotYourPassword();

        perks_signupHelper_Client.enterForgotPasswordEmail(emailClient);

        perks_signupHelper_Client.clickSend();
        this.pause(3000);
    }

    /**
     * Navigate to the perks home page and sign up
     * for perks by clicking editions and editorials.
     */
    public void signUpPerks_viaNewYorkStep1(String email){


        perks_homepageHelper_Client = new Perks_HomepageHelper_Client(client);
        perks_headerHelper_Client = new Perks_HeaderHelper_Client(client);

        perks_signupHelper_Client = new Perks_SignupHelper_Client(client);

        System.out.println(email);

        //step1, 1st signup modal:
        //a. Click SignUp Seal
        perks_headerHelper_Client.clickSignUp();

        //b. Enter email address
        perks_signupHelper_Client.enterJoinEmail(email);

        perks_signupHelper_Client.clickAccept();

        //c. Select Editions
        //New York, New York Perks are selected by default
        //check Driven
        perks_signupHelper_Client.checkBostonPerks();
        perks_signupHelper_Client.checkChicagoPerks();
        perks_signupHelper_Client.checkDCPerks();
        perks_signupHelper_Client.checkLosAngelesPerks();
        perks_signupHelper_Client.checkMiamiPerks();
        perks_signupHelper_Client.checkNationalPerks();

        //click "more" link to show all Editorials
        perks_signupHelper_Client.clickMoreLinkNewYork1();

        // check all of them
        perks_signupHelper_Client.checkAtlanta();
        perks_signupHelper_Client.checkBoston();
        perks_signupHelper_Client.checkChicago();
        perks_signupHelper_Client.checkDallas();
        perks_signupHelper_Client.checkDC();
        perks_signupHelper_Client.checkDriven();
        perks_signupHelper_Client.checkJetset();
        perks_signupHelper_Client.checkLasVegas();
        perks_signupHelper_Client.checkLosAngeles();
        perks_signupHelper_Client.checkMiami();
        perks_signupHelper_Client.checkNational();
        perks_signupHelper_Client.checkSanFrancisco();
        perks_signupHelper_Client.checkSkiBoard();

        //click "JOIN" button

        perks_signupHelper_Client.clickSubmit1();
    }

    /**
     * Fill out the perks registration form providing
     * Name, Gender, Income Range, etc.
     */
    public void signUpPerks_viaNewYorkStep2(String date){

        //step2, 2nd signup modal:
        //enter password
        perks_signupHelper_Client.enterPassword(PASSWORD);
        //confirm password
        perks_signupHelper_Client.confirmPassword(PASSWORD);
        //First Name
        perks_signupHelper_Client.enterFirstName("FN_"+date);
        //Last Name
        perks_signupHelper_Client.enterLastName("LN_"+date);
        //Gender
        perks_signupHelper_Client.selectGender("Male");
        //perks_signupHelper_Client.selectGender("Female");
        //perks_signupHelper_Client.selectGenderRandom();

        //Income Range
        perks_signupHelper_Client.selectIncomeRange("Less than $30,000");
//		perks_signupHelper_Client.selectIncomeRange("$30,000-$44,999");
//		perks_signupHelper_Client.selectIncomeRange("$45,000-$59,999");
//		perks_signupHelper_Client.selectIncomeRange("$60,000-$74,999");
//		perks_signupHelper_Client.selectIncomeRange("$75,000-$99,999");
//		perks_signupHelper_Client.selectIncomeRange("$100,000-$199,999");
//		perks_signupHelper_Client.selectIncomeRange("$200,000-$299,999");
//		perks_signupHelper_Client.selectIncomeRange("$300,000-$499,999");
//		perks_signupHelper_Client.selectIncomeRange("$500,000+");
//		perks_signupHelper_Client.selectIncomeRangeRandom();

        //Zip Code
        perks_signupHelper_Client.enterZipCode("10001");
        //Birthday (MM/DD/YYYY)
        perks_signupHelper_Client.enterBirthday("07/07/1977");
        //click "SUBMIT" button

        perks_signupHelper_Client.clickSubmit();
    }

    /**
     * Enter friend referrals and print the emails
     * used to the log
     */
    public void signUpPerks_viaNewYorkStep3(String[] friends){

        for (int i = 0; i < friends.length; i++) {
            perks_signupHelper_Client.enterEmailFriend(friends[i],(i+1));
            System.out.println(friends[i]);
        }


        perks_signupHelper_Client.clickInvite();

//		perks_signupHelper_Client.clickSkip();
    }

    /**
     * After friend referral submission
     * close the perks signup form
     */
    public void signUpPerks_viaNewYorkStep4(){
        //step4, 4th signup modal confirmation, close final confirm signup box

        WebDriverWait ThankYouWindow = new WebDriverWait(client, 30);
        ThankYouWindow.until(ExpectedConditions.visibilityOfElementLocated(By.className("close-button")));

        perks_signupHelper_Client.clickCloseFinalModal();
        //end of registration
    }

    public void adminPerksLogin() {
        client.get(PERKS_ADMIN_DOMAIN);
        client.findElement(By.id("username")).sendKeys(PERKS_ADMIN_USERNAME);
        client.findElement(By.id("login")).sendKeys(PERKS_ADMIN_PW);
        client.findElement(By.id("loginForm")).submit();
    }

    public void adminCreatePerk() {

        // Handle notification window
        if (client.findElement(By.id("message-popup-window")).isDisplayed()) {
            client.findElement(By.id("message-popup-window")).findElement(By.xpath("/html/body/div/div[4]/div/a")).click();
        }


        // Click on manage products under Catalog--Get the URL and open that instead.
        client.get(client.findElement(By.xpath("/html/body/div/div/div[3]/ul/li[4]/ul/li/a")).getAttribute("href"));

        // click Add Product,
        client.findElement(By.xpath("/html/body/div/div[3]/div/div[2]/table/tbody/tr/td[2]")).findElement(By.tagName("button")).click();

        // Change Attribute Set to Perk,
        Select attributeSet = new Select(client.findElement(By.id("attribute_set_id")));
        attributeSet.selectByVisibleText("Perk");

        // Set Product Type to Simple Product,
        Select productType = new Select(client.findElement(By.id("product_type")));
        productType.selectByVisibleText("Simple Product");
        // click continue,
        client.findElement(By.id("continue_button")).findElement(By.tagName("button")).click();

        // Under GENERAL tab put data in:
        // Business name
        client.findElement(By.id("business_name")).sendKeys("QA Test " + r);

        // Description
        client.findElement(By.id("description")).sendKeys("QA Test Copy " + r);

        // Subject
        client.findElement(By.id("name")).sendKeys("QA Test Subject " + r);

        // Offer
        client.findElement(By.id("offer")).sendKeys("QA Test Offer " + r);

        // Internal name
        client.findElement(By.id("perk_internal_name")).sendKeys("QA Test Internal Name " + r);

        // SKU
        client.findElement(By.id("sku")).sendKeys("QA54321A"+r);

        // Module Headline
        client.findElement(By.id("subheader")).sendKeys("QA Test Headline " + r);

        // Iphone Headline
        client.findElement(By.id("subheader_iphone")).sendKeys("QA Test Iphone Headline " + r);

        // Item Page Headline
        client.findElement(By.id("subheader_product")).sendKeys("QA Test Item Page Headline " + r);

        // change status to Enabled
        Select status = new Select(client.findElement(By.id("status")));
        status.selectByVisibleText("Enabled");

        // INVENTORY COUNTERS:
        // Click Inventory Counters
        client.findElement(By.id("product_info_tabs_group_48")).click();

        // Choose future date for Timer End Date
        client.findElement(By.id("countdown_end_date")).sendKeys(getFutureDate());

        // Put 1200 in Timer End Hour
        client.findElement(By.id("countdown_end_hour")).sendKeys("1200");

        // Choose D in Timer Format
        Select timerFormat = new Select(client.findElement(By.id("countdown_format")));
        timerFormat.selectByVisibleText("D");

        // PRICES:
        // Click Prices
        client.findElement(By.id("product_info_tabs_group_38")).click();

        // cost 0
        client.findElement(By.id("cost")).sendKeys("0");

        // Price 1.00
        client.findElement(By.id("price")).sendKeys("1.00");

        // tax class none
        Select taxClass = new Select(client.findElement(By.id("tax_class_id")));
        taxClass.selectByVisibleText("None");

        // IMAGES
        // Click Images
        client.findElement(By.id("product_info_tabs_group_40")).click();
        // click browse files

        // Choose an image
        // Click upload files
        // Select that image as the Large Module

        // INVENTORY:
        // Click inventory
        client.findElement(By.id("product_info_tabs_inventory")).click();

        // Change manage stock to Yes
        client.findElement(By.id("inventory_use_config_manage_stock")).click();
        Select manageStock = new Select(client.findElement(By.id("inventory_manage_stock")));
        manageStock.selectByVisibleText("Yes");

        // Change Qty to 1000
        client.findElement(By.id("inventory_qty")).clear();
        client.findElement(By.id("inventory_qty")).sendKeys("1000");

        Select inventoryStockAvailability = new Select(client.findElement(By.id("inventory_stock_availability")));
        inventoryStockAvailability.selectByVisibleText("In Stock");

        // WEBSITES:
        // Click Websites
        client.findElement(By.id("product_info_tabs_websites")).click();

        // Check Main Website
        client.findElement(By.id("product_website_1")).click();

        // CATEGORIES:
        // Click Categories
        client.findElement(By.id("product_info_tabs_categories")).click();

        // Wait for tree to load
        WebDriverWait iconWait = new WebDriverWait(client, 60);
        iconWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product_info_tabs_categories_content")));

        // Choose what edition you want it to appear in
        WebElement one = client.findElement(By.id("product-categories")).findElement(By.className("x-tree-root-node")).findElements(By.className("x-tree-node")).get(1);
        WebElement two = one.findElement(By.className("x-tree-node-ct")).findElements(By.className("x-tree-node")).get(1);
        WebElement three = two.findElement(By.className("x-tree-node-el")).findElement(By.tagName("input"));
        three.click();

        // REPORTING
        // Click Reporting
        client.findElement(By.id("product_info_tabs_group_75")).click();

        // Input Rev Share
        client.findElement(By.id("ud_rev_share")).sendKeys("54321" + r);

        // click Save
        client.findElement(By.className("content-buttons")).findElements(By.tagName("button")).get(2).click();
    }

    public void makePerkVisible() {
        // The perk is now created, but to make it appear on the site you must:
        // click on Manage Categories under Catalog,
        client.get(client.findElement(By.xpath("/html/body/div/div/div[3]/ul/li[4]/ul/li[2]/a")).getAttribute("href"));
        // choose the edition you want the perk to show in (i.e. Chicago),
        // click on the Category Products tab,
        // Reorder the positions of all the products listed 1-X,
        // click Save Category
    }

    private String getFutureDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE,14);
        String futureDate = dateFormat.format(c.getTime());
        return futureDate;
    }
}
