package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DesignTimePage {
	WebDriver driver;

	public DesignTimePage(WebDriver driver) {
		this.driver = driver;
	}

	By config_icon = By.xpath("//mat-icon[normalize-space()='settings']");
	By gotoApp_BTN = By.xpath("//input[@value='Go to application']");
	By home_BTN = By.cssSelector("input[value='Home']");
	By profile = By.id("user_name_anchor_tag");
	By logOutLink = By.xpath("//span[contains(text(),'Logout')]");

	public boolean verifyDesignTimeLoaded() {
		boolean gotoAppDisp = false;
		try {
			gotoAppDisp = driver.findElement(gotoApp_BTN).isDisplayed();
		} catch (NoSuchElementException nse) {
		}
		return gotoAppDisp;
	}

	public void loadDesignTimePage() throws InterruptedException {
		driver.findElement(config_icon).click();
		Thread.sleep(15000);
	}

	public void loadApp(String url) {
		driver.get(url);
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(profile)).build().perform();
		driver.findElement(logOutLink).click();
	}

}
