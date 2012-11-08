package org.urbandaddy.com.common;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class IHelper_Client {

	public WebDriver client;
	//public Selenium seleniumClient;

	public IHelper_Client(WebDriver webdriver) {
		client = webdriver;
		//seleniumClient = new WebDriverBackedSelenium(client, "http://ud-branch.thedaddy.co");
	}
	
	public void Log(String logMsg){
		System.out.println(logMsg);
	}

    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
        return findElementAndCheckBy(locator, 10) != null;
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
				//if (client.findElement(ByLocator(locator)).isEnabled()) {
                if (findElementAndCheckBy(locator).isEnabled()) {
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
				//if (!client.findElement(ByLocator(locator)).isEnabled()) {
                if (!findElementAndCheckBy(locator).isEnabled()) {
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
				//if (client.findElement(ByLocator(locator)).isDisplayed()) {
                if (findElementAndCheckBy(locator).isDisplayed()) {
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
				//if (!client.findElement(ByLocator(locator)).isDisplayed()) {
                if (!findElementAndCheckBy(locator).isDisplayed()) {
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

    public WebElement findElementAndCheckBy(String locator, int timeout) throws ElementNotVisibleException{
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
                        return d.findElement(ByLocator(ele));
                    }
                });
                flag = true;
            } catch (TimeoutException e) {
                counter++;
            }
        } while (counter <= 2 && !flag);
        if (a == null) {
          throw new ElementNotVisibleException("3rd Attempt reached. Could not find> " + ele);
        } else {
            return a;
        }
    }
    public WebElement findElementAndCheckBy(String locator) throws ElementNotVisibleException{
        int counter = 0;
        int timeout = 3;
        boolean flag = false;
        final String ele = locator;
        WebElement a = null;

        do {
            try {
                System.out.println("Trying to find the element> " + ele + "\nTimeout in> " + timeout + " seconds.");
                a = (new WebDriverWait(client, timeout)).until(new ExpectedCondition<WebElement>() {
                    @Override
                    public WebElement apply(WebDriver d) {
                        return d.findElement(ByLocator(ele));
                    }
                });
                flag = true;
            } catch (TimeoutException e) {
                counter++;
            }
        } while (counter <= 2 && !flag);
        if (a == null) {
          throw new ElementNotVisibleException("3rd Attempt reached. Could not find> " + ele);
        } else {
            return a;
        }
    }


    /**
     * Select an item from a dropdown.
     *
     * @param dropDownId Provide the ID of the dropdown element
     * @param dropDownTagName Provide name of the tag associated to the dropdown (ex. 'option')
     * @param text Name of the object to select from the dropdown
     */
    public void selectFromDropdown(String dropDownId, String dropDownTagName, String text) {
        WebElement element = client.findElement(By.id(dropDownId));
        List<WebElement> elements = element.findElements(By.tagName(dropDownTagName));
        for(WebElement option : elements){
            if(option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

    /**
     * Select an item from a dropdown. Uses WebElement to find
     * the dropdown. Works great with the findElementAndCheckBy() method.
     *
     * @param element Webelement returned from findElementAndCheckBy()
     * @param dropDownTagName Provide name of the tag associated to the dropdown (ex. 'option')
     * @param text Name of the object to select from the dropdown
     */
    public void selectFromDropdown (WebElement element, String dropDownTagName, String text) {
        List<WebElement> elements = element.findElements(By.tagName(dropDownTagName));
        for(WebElement option : elements){
            if(option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }
}
