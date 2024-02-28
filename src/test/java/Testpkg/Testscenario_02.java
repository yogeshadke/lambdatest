package Testpkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Util.Baseclass;

public class Testscenario_02 extends Baseclass {

	Duration timeout;

	@Test
	public void testScenario2() {
		// Click “Checkbox Demo” under “Input Forms”.
		WebElement checkboxDemoLink = driver.findElement(By.xpath("//a[contains(text(),'Checkbox Demo')]"));
		checkboxDemoLink.click();

		// Click the checkbox under the “Single Checkbox Demo” section.
		WebElement singleCheckbox = driver.findElement(By.xpath("//input[@type='checkbox'and@id='isAgeSelected']"));
		singleCheckbox.click();

		// Validate whether this checkbox is “selected”.
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(singleCheckbox.isSelected(), "Checkbox is not selected");

		// Now click the checkbox again
		singleCheckbox.click();

		// Validate whether the checkbox is “unselected”.
		softAssert.assertFalse(singleCheckbox.isSelected(), "Checkbox is not unselected");

		// Assert all verifications
		softAssert.assertAll();
	}

}
