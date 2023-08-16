/*
 * @author PrepelRa
 * Page Object: Issues page
 */

package com.utils.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.drivers.InputInteractionHelper;
import com.utils.wait.WaitUtility;

public class IssuesPage {

	private WebDriver driver;
	private WaitUtility waitUtility;

	public IssuesPage(WebDriver driver) {
		this.driver = driver;
	}

	// Define locators and methods for interacting with the Issues page

	/* Filter Label */
	private By filterLabel = By.xpath("//summary[@class='btn-link' and normalize-space(.) = 'Label']");

	/* Search label field */
	private By searchLabel = By.id("label-filter-field");

	/* Search field in Issues tab */
	private By searchIssuesField = By.id("js-issues-search");

	/* Label Filter Menu */
	private By LabelSelectMenu = By.xpath("//summary[@class='btn-link' and normalize-space() = 'Label']");

	/* Label Filter Input */
	// private By labelFilterInput = By.xpath("//input[@id='label-filter-field']");
	// private By labelFilterInput = By.xpath("//input[contains(@class,
	// 'SelectMenu-input') and contains(@class, 'form-control') and contains(@class,
	// 'js-filterable-field') and @id='label-filter-field']");
	// private By labelFilterInput = By.xpath("//input[@id='label-filter-field' and
	// contains(@class, 'SelectMenu-input') and contains(@class, 'form-control') and
	// contains(@class, 'js-filterable-field')]");
	private By labelFilterInput = By.xpath(
			"//details-menu[contains(@class, 'SelectMenu--hasFilter')]//input[@id='label-filter-field' and contains(@class, 'SelectMenu-input')]");

	/* Open Bttn */
	//private By OpenBttn = By.xpath("//a[contains(@class, 'btn-link') and contains(., 'Open')]");
	
	

	//private By OpenBttn =  By.cssSelector("a.btn-link.selected:contains('open')");
	//private By OpenBttn = By.xpath("//div[contains(@class, 'table-list-header-toggle') and contains(@class, 'states') and contains(@class, 'flex-auto')]");
	private By OpenBttn =  By.cssSelector(".flex-auto .table-list-header-toggle .selected");
					
	//private By OpenBttn= By.xpath("//a[contains(text(), ' Open')]");
	//private By OpenBttn = By.cssSelector("svg.octicon.octicon-issue-opened");
	//private By OpenBttn = By.xpath("//div[contains(@class, 'd-block d-lg-none no-wrap')]//svg[contains(@class, 'octicon octicon-issue-opened')]");
	                      


	/* issue Title */ 
	//private By TitleIssue =  By.xpath("//div[contains(@class, 'flex-auto min-width-0 p-2 pr-3 pr-md-2')][1]/a]");
	private By TitleIssue = By.xpath("(//a[@class='Link--primary v-align-middle no-underline h4 js-navigation-open markdown-title'])[1]");

		
	/* Issue Lable */ 
	//private By Labels = 
	
    /* Issue Comments */ 
	//private By Comments = 
	
	/* Issue IssueId */
	//private By IssueId =
	
	/* Issue Author */
	//private By Author = 
	
	/* Issue Created */
	//private By Created = 

	/* Label Selection */
	
	/*get the Text from Title */
	public String getTitleIssue() {
		System.out.println("blaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return driver.findElement(TitleIssue).getText();
	}

	/* Clear and enter values in the search issues field */
	public void ClearAndSearchInIssuesField(String searchIssuesValue) {
		driver.findElement(searchIssuesField).clear();
	    driver.findElement(searchIssuesField).sendKeys(searchIssuesValue);
	}
	
//	private By frameLocator = By.id("repo-content-turbo-frame");
//	
//	public void switchToFrame() {
//	    WebElement frameElement = driver.findElement(frameLocator);
//	    driver.switchTo().frame(frameElement);
//	}
//
//	public void switchToDefaultContent() {
//	    driver.switchTo().defaultContent();
//	}
	
	
	/* Add search text in label filter and enter */
	public void editLabelFilterInput(String label) {

		driver.findElement(labelFilterInput).clear();
		//driver.findElement(labelFilterInput).sendKeys(label);
		

		// Wait until the input field's value matches the expected parameter value
//		WebDriverWait wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
//		wait.until(ExpectedConditions.attributeToBe(labelFilterInput, "value", label));
//		driver.findElement(labelFilterInput).sendKeys(Keys.RETURN);
		
		// Create an instance of InputInteractionHelper
		InputInteractionHelper inputHelper = new InputInteractionHelper(driver);

        // Use the InputInteractionHelper helper to enter text and submit
		inputHelper.sendKeysAndSubmit(labelFilterInput, label);

	}

	public void clickOnOpenBttn() {
		
		 try {
	            // Find the element and perform an action
	            WebElement element = driver.findElement(OpenBttn);
	            element.click();
	        } catch (StaleElementReferenceException e) {
	            // If StaleElementReferenceException is caught, re-locate the element and retry the action
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(OpenBttn));
	            element.click();
	        }
	}

	public By getLabelSelectMenu() {

		return LabelSelectMenu;
	}

	public By getlabelFilterInput() {

		return labelFilterInput;
	}

	public By getOpenBttn() {
		return OpenBttn;
	}

	public By getSearchIssuesField() {
		return searchIssuesField;
	}
	

	public void clickFilterByLabel() {

		driver.findElement(filterLabel).click();

	}

	    private String invokeMethod(String methodName) {
	        try {
	            Method method = getClass().getMethod(methodName);
	            return (String) method.invoke(this);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Method invocation error for " + methodName;
	        }
	    }
}
