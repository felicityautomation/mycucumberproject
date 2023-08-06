package step.definition;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import utilities.BrowserUtil;

public class Steps {
	RemoteWebDriver driver;
	
	//Ctrl+Shift+O to import annotations or classes or interfaces
	@Given("user open the browser")
	public void user_open_the_browser() throws Exception {
	    driver=BrowserUtil.getDriver();
	}

	@When("user navigates to the login URL")
	public void user_navigates_to_the_login_url() {
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user inputs valid {string} and {string}")
	public void user_inputs_valid_and(String username, String password) {
	   LoginPage loginPage=new LoginPage(driver);
	   loginPage.login(username, password);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.clickOnLoginButton();
	}

	@Then("the home page is displayed")
	public void the_home_page_is_displayed() {
	   HomePage homePage=new HomePage(driver);
	   boolean flag=homePage.isProfileIconDisplayed();
	   Assert.assertEquals(flag, true);
	}
	
	
	@Given("user inputs invalid {string} and {string}")
	public void user_inputs_invalid_and(String username, String password) {
		 LoginPage loginPage=new LoginPage(driver);
		   loginPage.login(username, password);
	}

	@Then("the login page is displayed with error message")
	public void the_login_page_is_displayed_with_error_message() {
		 LoginPage loginPage=new LoginPage(driver);
		 boolean flag=loginPage.isLoginErrorDisplayed();
		 Assert.assertEquals(flag, true);
	}


}
