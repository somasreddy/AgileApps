package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToChild() {
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		i1.next();
		driver.switchTo().window(i1.next());
	}
	
	//Click
	//Clear
	//Sendkeys
	
}
