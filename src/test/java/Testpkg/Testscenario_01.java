package Testpkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Util.Baseclass;

public class Testscenario_01 extends Baseclass {
	Duration timeout;

	@Test
	public void testScenario1() {
		timeout = Duration.ofMinutes(1);
		WebElement title = driver.findElement(By.xpath("//h1[contains(text(),'Selenium Playground')]"));
		// Explicit wait for all elements to be available
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOfAllElements(title));

		SoftAssert softAssert = new SoftAssert();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		softAssert.assertEquals(pageTitle, "Selenium Grid Online | Run Selenium Test On Cloud",
				"Page Title does not match 'LambdaTest'");

		softAssert.assertAll();
	}

}
