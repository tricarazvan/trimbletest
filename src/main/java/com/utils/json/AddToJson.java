/*
 * @author PrepelRa
 * Write results in the json files
 */

package com.utils.json;

import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import com.utils.pages.IndexPage;
import com.utils.pages.IssuesPage;

import io.cucumber.java.Before;

public class AddToJson {
	private WebDriver driver;
	private IndexPage indexPage;
	private IssuesPage issuesPage;
	private FileWriter fileWriter;
	private JSONObject jsonData;
	
	public AddToJson(WebDriver driver, String file) throws IOException {

		this.driver = driver;
		jsonData = new JSONObject();
		fileWriter = new FileWriter(file, true);

	}

	// Delete the Json files from the previous test
	public void DeleteJsonFiles(String file) throws IOException {

		fileWriter = new FileWriter(file);
	}

	public void AddValuesToJson(String valueToAddInJson, String file) throws IOException {
		IndexPage indexPage = new IndexPage(driver);
		IssuesPage issuesPage = new IssuesPage(driver);

		switch (valueToAddInJson) {

		case "url":
			jsonData.put("url", indexPage.getCloneURL());
			break;

		case "releases":
			jsonData.put("releases", indexPage.getNumberOfReleasesText());
			break;

		case "title":
			jsonData.put("title", issuesPage.getTitleIssue());
			break;

		case "numberOfComments":
			jsonData.put("comments", issuesPage.getCommentsNr());
			break;

		}

		try {
			fileWriter.write(jsonData.toString());
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
