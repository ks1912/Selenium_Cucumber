package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpConfirmationPage {
	
	WebDriver driver;
	
	public SignUpConfirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@role='alert']//div[text()='Thank you for registering with Main Website Store.']")
	WebElement SuccessAlertMessage;
	
	public WebElement SuccessMessage() {
		return SuccessAlertMessage;
	}
	

}
