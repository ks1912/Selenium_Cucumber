package stepDefinition;

import org.Feuji.Selenium.Utilities.BaseClass;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CustomerLoginPage;
import pageObjects.DashboardPage;
import pageObjects.LandingPage;

public class Verify_The_User_Details extends BaseClass {
	
	
	@Given("The user clicks on SignIn link")
	public void the_user_clicks_on_sign_in_link() {
		LandingPage lp= new LandingPage(driver);
		lp.clickOnSignInLink();
	  }
	
	@When("^The user enters \"([^\"]*)\", \"([^\"]*)\" in the Customer Login Page$")
	public void the_user_enters_data_in_the_customer_login_page(String username, String password) {
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		clp.enterUserEmailId(username);
		clp.enterUserPassword(password);
		userEmailId=username;
	    
	}
	@When("The user clicks on SignIn button")
	public void the_user_clicks_on_sign_in_button() {
		CustomerLoginPage clp= new CustomerLoginPage(driver);
		clp.clickSignInButton();
	    
	}
	@Then("The user lands into the Dashboard Page")
	public void the_user_lands_into_the_dashboard_page() {
	    DashboardPage dp= new DashboardPage(driver);
	    dp.clickSwitchButton();
	    dp.clickMyAccount();
	    dp.verifyHeaderTitle();
	}


}
