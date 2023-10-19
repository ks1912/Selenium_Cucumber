package pageObjects;

import org.Feuji.Selenium.Utilities.ActionClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	ActionClass ac= new ActionClass();
	public LandingPage(WebDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="(//ul[@class='header links']//a)[1]")
	WebElement Sign_In_Link;
	
	@FindBy(xpath="//a[text()='Create an Account'][1]")
	WebElement Create_Account_Link;
	
	public void clickOnCreateAccountLink() {
//		Create_Account_Link.click();
		ac.click(Create_Account_Link);
	}
	
	public void clickOnSignInLink() {
		ac.click(Sign_In_Link);
	}

}
