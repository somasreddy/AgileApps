package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.DesignTimePage;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utils.TestSetup;

public class VerifyDesignTime {
	TestSetup tSetup;
	WebDriver driver;
	PageObjectManager pom;
	DesignTimePage designTimepage;
	LoginPage loginpage;

	public VerifyDesignTime(TestSetup tSetup) {
		this.tSetup = tSetup;
		this.designTimepage = tSetup.pom.getDesignTimePage();
	}

	@Given("user is logged into RunTime of AgileApps")
	public void user_is_logged_into_run_time_of_agile_apps() throws InterruptedException {
		this.loginpage = tSetup.pom.getLoginPage();
		designTimepage.loadApp(tSetup.browserInit.getTestUrl());
		loginpage.validLogin(tSetup.browserInit.getUserName(), tSetup.browserInit.getPassword());
		Assert.assertEquals(loginpage.verifyValidLogin(), true);
	}

	@When("user clicks on the configuration icon")
	public void user_clicks_on_the_configuration_icon() throws InterruptedException {
		designTimepage.loadDesignTimePage();
	}

	@Then("user is navigated to designtime in newtab")
	public void user_is_navigted_to_designtime_in_newtab() throws InterruptedException {
		Thread.sleep(5000);
		tSetup.genericUtils.switchToChild();
		Assert.assertEquals(designTimepage.verifyDesignTimeLoaded(), true);
	}

	@Then("Logout from the Application")
	public void Logout_from_the_Application() {
		designTimepage.logout();
	}



}
