package pageObjects;

import org.Feuji.Selenium.Utilities.ActionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Customer_Page {
	
	WebDriver driver;
	ActionClass ac= new ActionClass();
	
	public Create_Customer_Page(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="firstname")
	WebElement FirstName;
	
	@FindBy(id="lastname")
	WebElement LastName;
	
	@FindBy(id="email_address")
	WebElement EmailId;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="password-confirmation")
	WebElement ConfirmPassword;
	
	@FindBy(xpath="//button[@title='Create an Account']")
	WebElement Create_Account_Button;
	
	@FindBy(xpath="//a[text()='Create an Account'][1]")
	WebElement Create_Account_Link;
	
	
	//Corresponding Methods
	
	public void clickOnCreateAccountLink() {
//		Create_Account_Link.click();
		ac.click(Create_Account_Link);
	}
	
	public WebElement FirstNameField() {
		return FirstName;
	}
	
	public void fillTheMandatoryParameters(String FirstName1,String LastName1,String EmailId1,String pwd1,String conf_pwd1) {
//		FirstName.sendKeys(FirstName1);
//		LastName.sendKeys(LastName1);
//		EmailId.sendKeys(EmailId1);
//		Password.sendKeys(pwd1);
//		ConfirmPassword.sendKeys(conf_pwd1);
		
		ac.type(FirstName, FirstName1);
		ac.type(LastName, LastName1);
		ac.type(EmailId, EmailId1);
		ac.type(Password, pwd1);
		ac.type(ConfirmPassword, conf_pwd1);
		
	}
	
	public WebElement LastNameField() {
		return LastName;
	}
	
	public WebElement EmailIdField() {
		return EmailId;
	}
	
	public WebElement PasswordField() {
		return Password;
	}
	
	public WebElement PasswordConfirmationField() {
		return ConfirmPassword ;
	}
	
	public WebElement createAccountButton() {
		return Create_Account_Button;
	}
	
	

}
