/**
 * @author PrepelRa
 * Helper to interact with elements
 */

package com.utils.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InputInteractionHelper {
	private WebDriver driver;
	private WebDriverWait wait;

	public InputInteractionHelper(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10); // Adjust the timeout as needed
	}

	public void sendKeysAndSubmit(By inputLocator, String text) {
		// Find the input field
		WebElement inputField = driver.findElement(inputLocator);

		// Enter the desired text into the input field
		inputField.sendKeys(text);

		// sleep
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Wait until the input field's value attribute matches the desired parameter
		// value
		wait.until(ExpectedConditions.attributeToBe(inputField, "value", text));

		// Simulate pressing the Enter key
		inputField.sendKeys(Keys.RETURN);

	}
}