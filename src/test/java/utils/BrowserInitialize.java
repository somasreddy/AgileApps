package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInitialize {
	public WebDriver driver;
	FileInputStream fis;
	Properties prop;

	public void BrowserProps(String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	public String getTestUrl() {
		return prop.getProperty("testUrl");
	}

	public String getBrowser() {
		return prop.getProperty("browser");
	}

	public String getUserName() {
		return prop.getProperty("username");
	}

	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public WebDriver BrowserManager() throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//globalProp.properties");
		prop = new Properties();
		prop.load(fis);
		String url=getTestUrl();
		String browser_prop=getBrowser();
		String browser_maven = System.getProperty("browser");
		String browser = browser_maven != null ? browser_maven : browser_prop;

		if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			if (driver == null) {
				driver = new EdgeDriver();
				BrowserProps(url);
			}
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			if (driver == null) {
				driver = new FirefoxDriver();
				BrowserProps(url);
			}
		} else {
			WebDriverManager.chromedriver().setup();
			if (driver == null) {
				driver = new ChromeDriver();
				BrowserProps(url);
			}
		}

		return driver;
	}
}
