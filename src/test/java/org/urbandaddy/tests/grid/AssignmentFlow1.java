package org.urbandaddy.tests.grid;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.Date;

public class AssignmentFlow1 {
	
	private String domainWithPassword = "http://www.urbandaddy.com";
	private String domain = "http://www.urbandaddy.com";
	
	@Test
	public void main() {
		Date now = new java.util.Date(); 
		java.text.DateFormat emailFormat = new java.text.SimpleDateFormat("MM_dd_yyyy_HH_mm_SSS");
		String assignmentTitle = "Regression Test Assignment" + emailFormat.format(now);
		String emailClient = "qa+client@urbandaddy.com";
		String emailResource = "qa+resource@urbandaddy.com";
		
		WebDriver client = new FirefoxDriver();
		WebDriver resource = new FirefoxDriver();
		
		Assert.assertTrue(login(client, emailClient));
		Assert.assertTrue(login(resource, emailResource));
		
		client.get(domain);
		client.findElement(By.id("title-text")).sendKeys(assignmentTitle);
		((JavascriptExecutor)client).executeScript("$('#desc-text').wysiwyg('setContent', 'monkey')");
		client.findElement(By.id("clientlocations2")).click();
		client.findElement(By.id("from")).sendKeys("12/30/2011");
		client.findElement(By.id("fromtime")).sendKeys("9:00am");
		client.findElement(By.id("flat_price")).sendKeys("0.01");
		client.findElement(By.id("submit-form")).click();
	}
	
	private boolean login(WebDriver driver, String email) {
		driver.get(domainWithPassword);
		driver.findElement(By.id("email_header")).sendKeys(email);
		driver.findElement(By.id("password_header")).sendKeys("labor1" + Keys.ENTER);
		if (driver.getCurrentUrl().equals(domain + "/home"))
			return true;
		return false;
	}
	
}