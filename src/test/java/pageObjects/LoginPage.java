package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username_TB = By.cssSelector("#username");
	By password_TB = By.cssSelector("#password");
	By login_BTN = By.cssSelector(".mat-button-wrapper");
	By runTimeProfile_Icon = By.xpath("//span[.='Personalize']/../child::mat-icon");

	public void SendLoginCreds(String un, String pwd) {
		driver.findElement(username_TB).sendKeys(un);
		driver.findElement(password_TB).sendKeys(pwd);
	}

	public void clickLoginBtn() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(login_BTN).click();
	}

	public boolean verifyValidLogin() {
		boolean homePageDisp = false;
		try {
			homePageDisp = driver.findElement(runTimeProfile_Icon).isDisplayed();
		} catch (Exception e) {
		}
		return homePageDisp;
	}

	public void validLogin(String un, String pwd) throws InterruptedException {
		SendLoginCreds(un, pwd);
		clickLoginBtn();
	}

}
