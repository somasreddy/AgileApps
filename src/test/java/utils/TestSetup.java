package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestSetup {
	public WebDriver driver;
	public PageObjectManager pom;
	public BrowserInitialize browserInit;
	public GenericUtils genericUtils;

	public TestSetup() throws IOException {
		browserInit=new BrowserInitialize();
		driver=browserInit.BrowserManager();
		pom = new PageObjectManager(driver);
		genericUtils=new GenericUtils(driver);
	}	
}
