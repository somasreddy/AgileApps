package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.PageObjectManager;
import utils.TestSetup;

public class VerifyLogin {

	WebDriver driver;
	TestSetup tSetup;
	PageObjectManager pom;
	LoginPage loginpage;

	public VerifyLogin(TestSetup tSetup) {
		this.tSetup = tSetup;
		this.loginpage = tSetup.pom.getLoginPage();
	}

	@Given("User opened the browser and navigated to loginPage of AgileApps")
	public void user_opened_the_browser_and_navigated_to_login_page_of_agile_apps() {
		loginpage = tSetup.pom.getLoginPage();
	}

	@When("^User enters the (.+) and (.+)$")
	public void user_enters_the_username_and_password(String username, String password) {
		loginpage.SendLoginCreds(username, password);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		loginpage.clickLoginBtn();
	}

	@Then("^I verify that the homePage is (.+) opened$")
	public void i_verify_that_the_home_page_is_status_opened(boolean status) {
		Assert.assertEquals(loginpage.verifyValidLogin(), status);
	}

}
