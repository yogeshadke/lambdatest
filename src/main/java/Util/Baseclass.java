package Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {

	public static WebDriver driver;

	public void lambdaSetup() throws MalformedURLException {

		String hubURL = "https://hub.lambdatest.com/wd/hub";

		String[] Tags = new String[] { "Feature", "Falcon", "Severe" };

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("browserVersion", "latest");

		HashMap<String, Object> ltOptions = new HashMap<String, Object>();
		ltOptions.put("user", "yogeshadke24");
		ltOptions.put("accessKey", "z1X4peHZ569ffrZTqF4bvdO6zBp7CJ0uPDIGWQlLejy4m7Dv56");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", this.getClass().getName());
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "4.0.0");
		ltOptions.put("tags", Tags);
		capabilities.setCapability("LT:Options", ltOptions);

		driver = new RemoteWebDriver(new URL(hubURL), capabilities);
		System.out.println(driver);
	}

	@BeforeClass
	public void setup() throws MalformedURLException {

		// launch browser

		lambdaSetup();
		driver.get("https://www.lambdatest.com/selenium-playground/");

	}

	@AfterClass
	public void tearDown() {
		// driver.close();
		driver.quit();
	}
}