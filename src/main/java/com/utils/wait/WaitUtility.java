/*
 * @author PrepelRa
 */

package com.utils.wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	private WebDriver driver;
	private WebDriverWait wait;

	public WaitUtility(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10); // Default timeout of 10 seconds
	}

	public void waitForVisibilityOfElement(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}