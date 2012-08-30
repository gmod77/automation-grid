package org.urbandaddy.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import junit.framework.Assert;
import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class UD_test1_mobile_sauce_IPhone {
	private String domain = "http://m-branch.thedaddy.co";
	
	private WebDriver client;
	 @Test
    public void setUp() throws Exception {
        DesiredCapabilities capabillities = DesiredCapabilities.iphone();
//        capabillities.setCapability("browser", "android");
        capabillities.setCapability("version", "5");
        capabillities.setCapability("platform", "Mac 10.6");
        capabillities.setCapability("name", "UD IPhone Mobile Smoke Test");
        capabillities.setCapability("deviceOrientation", "portrait");

        this.client = new RemoteWebDriver(
           new URL("http://gmod77:6e93701d-fb46-4de2-b52d-f504e203647c@ondemand.saucelabs.com:80/wd/hub"),
           capabillities);
        client.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    
    @Test
    public void testSauce() throws Exception {
    	Date now = new java.util.Date(); 
		java.text.DateFormat emailFormat = new java.text.SimpleDateFormat("MM_dd_yyyy_HH_mm_SSS");
		String emailClient = "udtestergene+"+ emailFormat.format(now) + "@gmail.com";
		System.out.println(emailClient);
		
		//start afresh
				client.manage().deleteAllCookies();
				
				//assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[2]/a")));
				//Assert.assertTrue(login(resource, emailResource));
				
				// go to homepage
				client.get(domain);
				
		//click Chicago
				client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[2]/a")).click();
				
				//search for Jellyfish restaurant in Chicago
				
				//enter search text
				client.findElement(By.id("query")).sendKeys("Jellyfish");
				//click go
				client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

				
				//verify displayed results
				Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
				
				// use back button to go back to the citi's featured article 
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();

				
				//use the City icon on the upper-right corner to navigate to the main page
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();

				
		//click Las Vegas
				client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[3]/a")).click();

				
				//search for Allegro restaurant in Las Vegas
				
				//enter search text
				client.findElement(By.id("query")).sendKeys("Allegro");
				//click go
				client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

						
				//verify displayed results
				Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
						
				// use back button to go back to the citi's featured article 
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();

						
				//use the City icon on the upper-right corner to navigate to the main page
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();
					
		//click Los Angeles
				client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[4]/a")).click();

				
				//search for Nobu Malibu restaurant in LA
				
				//enter search text
				client.findElement(By.id("query")).sendKeys("Nobu Malibu");
				//click go
				client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

						
				//verify displayed results
				Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
						
				// use back button to go back to the citi's featured article 
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();

						
				//use the City icon on the upper-right corner to navigate to the main page
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();
				
				
		//click Miami
				client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[5]/a")).click();

				
				//search for Doma Polo Bistro restaurant in Miami
				
				//enter search text
				client.findElement(By.id("query")).sendKeys("Doma Polo Bistro");
				//click go
				client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

								
				//verify displayed results
				Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
								
				// use back button to go back to the citi's featured article 
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();

								
				//use the City icon on the upper-right corner to navigate to the main page
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();

		//click NYC
				client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[6]/a")).click();
				//search for Tomoka restaurant in NYC
				
				//enter search text
				client.findElement(By.id("query")).sendKeys("Tomoka");
				//click go
				client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

										
				//verify displayed results
				Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
										
				// use back button to go back to the citi's featured article 
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();

										
				//use the City icon on the upper-right corner to navigate to the main page
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();
				

				
		//click San Fran
				client.findElement(By.xpath("//html/body/div/div[2]/div/div[2]/ul/li[7]/a")).click();
				
				//search for The Corner Store restaurant in SF
				
				//enter search text
				client.findElement(By.id("query")).sendKeys("The Corner Store");
				//click go
				client.findElement(By.xpath("//html/body/div/div[2]/form/div/a/img")).click();

										
				//verify displayed results
				Assert.assertTrue(client.findElement(By.xpath("//html/body/div/div[2]/div[3]/ul/li/div/div[3]/a")).isDisplayed());
										
				// use back button to go back to the citi's featured article 
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();

										
				//use the City icon on the upper-right corner to navigate to the main page
				client.findElement(By.xpath("//html/body/div/div/a/img")).click();
				
				client.quit();
    }		
}