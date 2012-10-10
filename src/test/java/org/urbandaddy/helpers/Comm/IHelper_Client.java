package org.urbandaddy.helpers.Comm;

import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;

public abstract class IHelper_Client {

	public WebDriver client;
	public Selenium seleniumClient;

	public IHelper_Client(WebDriver webdriver) {
		client = webdriver;
		seleniumClient = new WebDriverBackedSelenium(client, "http://ud-branch.thedaddy.co");
	}
	
	public void Log(String logMsg){
		System.out.println(logMsg);
	}

	public By ByLocator(String locator) {
		By result = null;

		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("#", ""));
		} else if (locator.startsWith("#")) {
			result = By.name(locator.replace("#", ""));
		} else {
			result = By.id(locator);
		}

		return result;
	}

	public Boolean isElementPresent(String locator) {

		Boolean result = false;
		try {
			client.findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {

		}

		return result;
	}

	public void WaitForElementPresent(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementEnabled(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (client.findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementNotEnabled(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!client.findElement(ByLocator(locator)).isEnabled()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void WaitForElementVisible(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (client.findElement(ByLocator(locator)).isDisplayed()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementNotVisible(String locator, int timeout) {

		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				if (!client.findElement(ByLocator(locator)).isDisplayed()) {
					break;
				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
