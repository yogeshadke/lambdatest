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
import org.testng.annotations.Parameters;


public class Test1 extends Baseclass {
	
	Duration timeout;
	@Test
    public void testScenario1() {
		timeout =Duration.ofMinutes(1);
		WebElement title= driver.findElement(By.xpath("//h1[contains(text(),'Selenium Playground')]"));
        // Explicit wait for all elements to be available 
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfAllElements(title));

        SoftAssert softAssert = new SoftAssert();
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        softAssert.assertEquals(pageTitle, "Selenium Grid Online | Run Selenium Test On Cloud", "Page Title does not match 'LambdaTest'");

        softAssert.assertAll();
    }
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

	@Test
    public void testScenario3() {
		driver.get("https://www.lambdatest.com/selenium-playground/");
        // Click “Javascript Alerts” under “Alerts & Modals”.
        WebElement javascriptAlertsLink = driver.findElement(By.xpath("//a[contains(text(),'Javascript Alerts')]"));
        javascriptAlertsLink.click();
      
        // Now click the “Click Me” button in the “Java Script Alert Box” section.
        WebElement clickMeButton = driver.findElement(By.xpath("//button[@class='btn btn-dark my-30 mx-10 hover:bg-lambda-900 hover:border-lambda-900']"));
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




