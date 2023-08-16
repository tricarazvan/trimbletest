/*
 * Steps for the feature: Repository Information
 */

package com.example.steps;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utils.drivers.Browser;
import com.utils.drivers.WebDriverUtility;
import com.utils.json.AddToJson;
import com.utils.pages.IndexPage;
import com.utils.pages.IssuesPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;

public class GatherIssueInformationSteps {

	private WebDriverWait wait;
	private WebDriver driver;
	private String repositoryUrlValue;
	private String numberOfReleasesText;
	private AddToJson addToJson;

	@Before
	public void Hooks() throws IOException {

		/* Browser is read from Maven parameter */
		String browserMaven = System.getProperty("browser");
		// driver = WebDriverUtility.getWebDriver(Browser.valueOf(browserMaven));
		driver = WebDriverUtility.getWebDriver(Browser.CHROME);
		wait = new WebDriverWait(driver, 30);
	
	}


	// Navigate to the provided URL
	@Given("the user is on the SeleniumHQ repository page")
	public void theUserIsOnGitHubRepositoryPage() {
		IndexPage indexPage = new IndexPage(driver);
		driver.get("https://github.com/SeleniumHQ/selenium");

	}

	// Locate and click on the "Code" dialog button
	@When("the user opens the Code dialog")
	public void theUserOpensCodeDialog() {
		IndexPage indexPage = new IndexPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(indexPage.getCodeDialogButton()));
		indexPage.clickCodeDialogButton();
	}

	// Locate and get the clone URL
	@Then("the repository clone URL is obtained from the input field")
	public void theRepositoryCloneURLIsObtained() {
		IndexPage indexPage = new IndexPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(indexPage.cloneURLField()));
		repositoryUrlValue = indexPage.getCloneURL();
	}

	// Open the issues tab
	@When("user open Issues tab")
	public void clickOpenIssuesTab() {
		IndexPage indexPage = new IndexPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(indexPage.getIssuesTab()));
		indexPage.clickOnIssuesTab();
	}

	// Clear search field and enter searchText
	@When("the user clears the search field and enters {string}")
	public void userClearsSearchFieldAndEnters(String searchText) {
		IssuesPage issuesPage = new IssuesPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(issuesPage.getSearchIssuesField()));
		issuesPage.ClearAndSearchInIssuesField(searchText);
	}

	// Click on Open button
	@When("the user clicks the Open button")
	public void clickOnOpenButton() {
		IssuesPage issuesPage = new IssuesPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(issuesPage.getOpenBttn()));
		issuesPage.clickOnOpenBttn();
	}

	@When("the user filters by the label {string}")
	public void FilterByLabel(String labelText) throws InterruptedException {
		IssuesPage issuesPage = new IssuesPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(issuesPage.getlabelFilterInput()));
		issuesPage.editLabelFilterInput(labelText);
	}

	// Click on Label filter
	@When("user press the Label filter")
	public void PressLabelFilter() {
		IssuesPage issuesPage = new IssuesPage(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(issuesPage.getLabelSelectMenu()));
		issuesPage.clickFilterByLabel();
	}

	// Locate and get the releases URL
	@Then("the number of releases is obtained")
	public void theNumberOfReleasesIsObtained() {
		IndexPage indexPage = new IndexPage(driver);
		numberOfReleasesText = indexPage.getNumberOfReleasesText();
	}

	@Then("the {string} is added to JSON file {string}")
	public void retrievesValuesAndAddThemToJSON(String valueToAddInJson, String file) throws IOException {
		AddToJson addToJson = new AddToJson(driver, file);
		addToJson.AddValuesToJson(valueToAddInJson, file);

	}

	@After
	public void tearDown() {
		driver.quit();
	}
}