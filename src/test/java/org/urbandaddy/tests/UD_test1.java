package org.urbandaddy.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Date;

public class UD_test1 {
	
	private String domain = "http://ud-branch.thedaddy.co";
	
	@Test
	public void main() {
		Date now = new java.util.Date(); 
		java.text.DateFormat emailFormat = new java.text.SimpleDateFormat("MM_dd_yyyy_HH_mm_SSS");
		String emailClient = "udtesterjenkins+"+ emailFormat.format(now) + "@gmail.com";
		System.out.println(emailClient);

		
		WebDriver client = new FirefoxDriver();
				
		// go to homepage
		client.get(domain);
		
		//click Atlanta
		client.findElement(By.xpath("//.//*[@id='splashMain']/div/div[2]/div/div[2]/a[1]/img")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//click Join Now in the header
		client.findElement(By.linkText("JOIN NOW")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//enter email
		client.findElement(By.id("email")).sendKeys(emailClient);
		
		//select the rest of the Editions
		client.findElement(By.id("member_editions_33")).click();
		client.findElement(By.id("member_editions_13")).click();
		client.findElement(By.id("member_editions_18")).click();
		client.findElement(By.id("member_editions_25")).click();
		client.findElement(By.id("member_editions_12")).click();
		
		//submit
		client.findElement(By.name("submit")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}	

		//step2, select Perks Editions

		client.findElement(By.id("member_editions_28")).click();
	
		//submit
		client.findElement(By.name("submit")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//step3
		//enter password
		client.findElement(By.id("flowPassword")).sendKeys("1234");
		//confirm password
		client.findElement(By.id("flowPasswordRetype")).sendKeys("1234");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		//submit
		client.findElement(By.name("submit")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//logout
		client.findElement(By.linkText("Logout")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//sign back in again
		client.findElement(By.linkText("Member Log In")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		//enter email
		client.findElement(By.id("email")).sendKeys(emailClient);
		//confirm password
		client.findElement(By.id("password")).sendKeys("1234");
		//submit
		client.findElement(By.name("submit")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		

		//click Nightlife in the header
		client.findElement(By.linkText("NIGHTLIFE")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//click Food in the header
		client.findElement(By.linkText("FOOD")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
//		//signup overlay pops up, fill it out:
//		//enter email
//		client.findElement(By.id("email")).sendKeys(emailClient);
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}
//		
//		//click accept
//		client.findElement(By.linkText("Accept")).click();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-qarated catch block
//			e.printStackTrace();
//		}
			

		/////////////////////////////////////////////
		//click Nightlife in the header
		client.findElement(By.linkText("STYLE")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		
		//click Nightlife in the header
		client.findElement(By.linkText("GEAR")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//click Nightlife in the header
		client.findElement(By.linkText("LEISURE")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//click Nightlife in the header
		client.findElement(By.linkText("DRIVEN")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		client.navigate().back();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//click Nightlife in the header
		client.findElement(By.linkText("PERKS")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		client.navigate().back();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//click Nightlife in the header
		client.findElement(By.linkText("PARTIES")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		client.navigate().back();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//click Nightlife in the header
		client.findElement(By.linkText("KEMPT")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		client.navigate().back();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}
		
		//click Nightlife in the header
		client.findElement(By.linkText("MOBILE")).click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-qarated catch block
			e.printStackTrace();
		}

//		client.manage().deleteAllCookies();
		client.quit();
	}
	
}