package Testpkg;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Util.Baseclass;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testscenario_03 extends Baseclass {

	Duration timeout;

	@Test
	public void testScenario3() {
		driver.get("https://www.lambdatest.com/selenium-playground/");
		// Click “Javascript Alerts” under “Alerts & Modals”.
		WebElement javascriptAlertsLink = driver.findElement(By.xpath("//a[contains(text(),'Javascript Alerts')]"));
		javascriptAlertsLink.click();

		// Now click the “Click Me” button in the “Java Script Alert Box” section.
		WebElement clickMeButton = driver.findElement(
				By.xpath("//button[@class='btn btn-dark my-30 mx-10 hover:bg-lambda-900 hover:border-lambda-900']"));
		clickMeButton.click();

		// Switch to the alert
		Alert alert = driver.switchTo().alert();

		// Validate the alert message “I am an alert box!”
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(alert.getText(), "I am an alert box!", "Incorrect alert message");

		// Accept the alert (click OK)
		alert.accept();

		// Assert all verifications
		softAssert.assertAll();
	}

}
