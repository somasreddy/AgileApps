package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestSetup;

public class Hooks {
	TestSetup tSetup;
	static List<String> browsers;

	public Hooks(TestSetup tSetup) {
		this.tSetup = tSetup;
	}
	
	@After
	public void quitBrowser() throws IOException, InterruptedException {
		tSetup.browserInit.BrowserManager().quit();
		if (browsers == null) {
			browsers = new ArrayList<>();
			browsers.add(tSetup.browserInit.getBrowser());
		}
		browsers.add(tSetup.browserInit.getBrowser());
	}

	@AfterAll
	public static void CloseAlldriver() {
		System.out.println("Killing the browser instances in TaskManager....");
		for(String browser:browsers) {
			KillDriver(browser);
		}
	}
	
	public static void KillDriver(String browserName) {
		browserName = browserName.toLowerCase();
		if (browserName.isEmpty()) {
			browserName = "chrome";
		}
		try {
			Runtime.getRuntime().exec("taskkill /f /im " + browserName + "driver.exe");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException {
		WebDriver driver = tSetup.browserInit.BrowserManager();
		if (scenario.isFailed()) {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");

		}

	}

}
