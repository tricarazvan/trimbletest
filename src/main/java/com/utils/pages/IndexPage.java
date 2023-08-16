/*
 * @author PrepelRa
 * Page Object: Index page
 */

package com.utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.wait.WaitUtility;

public class IndexPage {

	private WebDriver driver;
	private WaitUtility waitUtility;

	public IndexPage(WebDriver driver) {
		this.driver = driver;
	}

	// Define locators and methods for interacting with the Repository page

	/* Code button */
	private By codeDialogButton = By.cssSelector(".Button--primary .Button-label");

	/* Repository Clone Input field */
	private By cloneURLField = By
			.xpath("//input[@type='text' and @class='form-control input-monospace input-sm color-bg-subtle']");

	/* Repository Clone Input field */
	private By numberOfReleases = By.xpath("//a[contains(., 'Releases')]/span[@class='Counter']");

	/* Issues tab */
	private By issuesTab = By.id("issues-tab");
	
	/* Click on the Code button */
	public void clickCodeDialogButton() {
		driver.findElement(codeDialogButton).click();
	}

	/* get the clone URL */
	public String getCloneURL() {
		return driver.findElement(cloneURLField).getAttribute("value");
	}

	/* get the number of releases */
	public String getNumberOfReleasesText() {
		return driver.findElement(numberOfReleases).getText();
	}

	/* Click on the Issues tab */
	public void clickOnIssuesTab() {
		driver.findElement(issuesTab).click();
	}

	public By getIssuesTab() {
		return issuesTab;	
	}	
	
	public By getCodeDialogButton() {
		return codeDialogButton;
	}

	public By cloneURLField() {
		return cloneURLField;
	}

	public void PageLoad() {

		// Use the waitUtility to wait for the "Code" button to be visible
		waitUtility.waitForVisibilityOfElement(codeDialogButton);
		// Now the page is loaded, continue with your actions
	}
	
	public String getCurentUrl() {
	
	return driver.getCurrentUrl();
	}

}
