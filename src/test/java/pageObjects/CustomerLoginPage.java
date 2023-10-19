package pageObjects;

import org.Feuji.Selenium.Utilities.ActionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage {
	
	WebDriver driver;
	ActionClass ac= new ActionClass();
	public CustomerLoginPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	WebElement UserEmailIdField;
	
	@FindBy(id="pass")
	WebElement passwordField;
	
	@FindBy(xpath="(//span[text()='Sign In'])[1]")
	WebElement SignInButton;
	
	
	public WebElement returnEmailField() {
		return UserEmailIdField;
	}
	
	public WebElement returnPasswordField() {
		return passwordField;
	}
	
	public void enterUserEmailId(String email) {
		ac.type(UserEmailIdField, email);
	}
	
	public void enterUserPassword(String pwd) {
		ac.type(passwordField, pwd);
	}
	
	public void clickSignInButton() {
		ac.click(SignInButton);
	}
	

}
