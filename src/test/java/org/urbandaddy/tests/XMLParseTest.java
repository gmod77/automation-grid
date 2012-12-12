package org.urbandaddy.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.urbandaddy.com.common.UDBase;
import org.urbandaddy.locators.XMLParse;

import static org.junit.Assert.fail;


public class XMLParseTest implements UDBase {

    private WebDriver client;
    private XMLParse homePage;

    @Before
    public void setUp() throws Exception {
        client = new FirefoxDriver();
        client.get("http://www.urbandaddy.com");
    }

    @Test
    public void testXml() {

        client.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/a[12]")).click();

        try {
            homePage = new XMLParse("src/test/java/org/urbandaddy/locators/UD_HomePage_v2.xml");

            WebElement logo = client.findElement(homePage.getLocator("UDLogo"));
            System.out.println(logo.getAttribute("href"));

        } catch (Exception e) {
            fail("This didn't work");
            e.printStackTrace();
        }

    }

    @After
    public void tearDown() throws Exception {
        client.quit();
    }
}
