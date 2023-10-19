package pageObjects;

import org.Feuji.Selenium.Utilities.ActionClass;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	WebDriver driver;
	ActionClass ac= new ActionClass();
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1")
	WebElement header_title;
	
	@FindBy(xpath="//div[@class='box-content']/p")
	WebElement Account_Information;
	
	@FindBy(xpath="//div[@class='box-content']/p/br[1]")
	WebElement Account_EmailId;
	
	@FindBy(xpath="(//li[@class='customer-welcome'])[1]")
	WebElement switchButton;
	
	@FindBy(xpath="(//li/a[text()='My Account'])[1]")
	WebElement MyAccount_Option;
	
	
	public void verifyHeaderTitle() {
		Assert.assertTrue(header_title.getText().equals("My Account"));
	}
	
	public String returnAccountHolderName() {
		return Account_Information.getText();
	}
	
	public String returnAccountHolderEmail() {
		return Account_EmailId.getText();
	}
	
	public void clickSwitchButton() {
		ac.click(switchButton);
	}
	
	public void clickMyAccount() {
		ac.click(MyAccount_Option);
	}
	
	

}
