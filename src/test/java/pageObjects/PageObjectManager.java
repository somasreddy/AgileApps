package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	WebDriver driver;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getLoginPage() {
		return new LoginPage(driver);
	}

	public DesignTimePage getDesignTimePage() {
		return new DesignTimePage(driver);
	}

}
