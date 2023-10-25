package stepDefinition;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.Feuji.Selenium.Utilities.BaseClass;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Create_Customer_Page;
import pageObjects.DashboardPage;
import pageObjects.SignUpConfirmationPage;

public class Create_An_Account_StepDefinition extends BaseClass {
	
	static String username;
//	static String userEmailId;
	
	@Before
	public void setup() {
		
		readconfig=new Properties();
		try {
			FileInputStream fis= new FileInputStream("Properties.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		log=LogManager.getLogger("Create_An_Account_StepDefinition");
		
		String launchingbrowser=readconfig.getProperty("browser");
		
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		driver= new ChromeDriver(co);
		log.info("Logging for CreateAnAccount Class in Chrome Browser...");
		
		
		
	}

	
	
	@Given("The user is on the landing page of the application")
	public void the_user_is_on_the_landing_page_of_the_application() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		log.info("Maximizing the screen and launching the application");
		
//		launch_Chrome(driver);
		
		
	}
	
	@Given("The user clicks on Create an Account link")
	public void the_user_clicks_on_create_an_account_link() {
	    Create_Customer_Page cp= new Create_Customer_Page(driver);
		cp.clickOnCreateAccountLink();
		log.info("Clicking on Create an Account Link");
	}
	
	@When("The user enters all the new data in the Create New Customer Account Page")
	public void the_user_enters_all_the_new_data_in_the_create_new_customer_account_page() {
		
		Create_Customer_Page cp= new Create_Customer_Page(driver);
		cp.clickOnCreateAccountLink();
		cp.fillTheMandatoryParameters("Amit", "Rath", "h4@test.com", "Amit&Test123", "Amit&Test123");
    }
	
	@When("^The user enters all the new data \"([^\"]*)\",\"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" in the Create New Customer Account Page$")
	public void the_user_enters_all_the_new_data_in_the_create_new_customer_account_page(String FirstName, String LastName, String Pwd, String ConfirmPwd) {
		Create_Customer_Page cp= new Create_Customer_Page(driver);
		
		RandomStringUtils rs= new RandomStringUtils();
		String randomEmailValue=rs.randomAlphanumeric(5);
		userEmailId= randomEmailValue+"@test.com";
		cp.fillTheMandatoryParameters(FirstName, LastName, userEmailId, Pwd, ConfirmPwd);
		username=FirstName+" "+LastName;
		
		log.info("Filling all the mandatory Fields");
	}
	
	@When("The user clicks on Create an Account button")
	public void the_user_clicks_on_create_an_account_button() {
		Create_Customer_Page cp= new Create_Customer_Page(driver);
		cp.createAccountButton().click();
	    log.info("Clicking on Create an Account Button");
	}
	
	@Then("The user gets a success message")
	public void the_user_gets_a_success_message() {
		SignUpConfirmationPage sp= new SignUpConfirmationPage(driver);
		sp.SuccessMessage().isDisplayed();
		String alertMessage=sp.SuccessMessage().getText();
//		System.out.println(alertMessage);
		String expected_alert="Thank you for registering with Main Website Store.";
		AssertJUnit.assertTrue(alertMessage.equals(expected_alert));
	    log.info("The user is able to create an account and gets a successful message");
	}
	
	@Then("Close the application")
	public void close_the_application() {
	    driver.close();
	    
	}
	
	@Then("^Verify the user Details are displayed correctly \"([^\"]*)\"")
	public void verify_the_user_details_are_displayed_correctly(String AccountType) {
	    
		DashboardPage dp= new DashboardPage(driver);
	    dp.verifyHeaderTitle();
	    System.out.println("The account holder Name is: "+ dp.returnAccountHolderName());
	    String name[]= dp.returnAccountHolderName().split("\n");
	    
	    for (int i=0;i< name.length; i++) {
	    	System.out.println("value"+i+1 +": "+name[i]);
	    	nameOfUser=name[0];
	    	MailId=name[1];
	    	
	    }
	    
	    if(AccountType.equals("New")) {
	    	AssertJUnit.assertTrue(nameOfUser.equals(username));
	    }
	    
	    else if(AccountType.equals("Existing")) {
	    	System.out.println(MailId+ " "+ userEmailId);
	    	AssertJUnit.assertTrue(MailId.equals(userEmailId));
	    }
	    
	}
	
	@After
	public void teardown(Scenario sc) throws IOException {
		
		
		if(sc.isFailed()==true) {
			
			
			String filepath="C:\\Users\\amit.r\\eclipse-workspace\\org.Feuji.Selenium.Cucumber\\target\\cucumber-reports\\failure"+sc.getName()+".png";
			TakesScreenshot scrshot=((TakesScreenshot)driver);
			File srcfile=scrshot.getScreenshotAs(OutputType.FILE);
			File destfile=new File(filepath);
			FileUtils.copyFile(srcfile, destfile);
			log.info("The scenario failed and evidence is stored in "+"C:\\Users\\amit.r\\eclipse-workspace\\org.Feuji.Selenium.Cucumber\\target\\cucumber-reports\\failure"+sc.getName()+".png");
			driver.quit();
			
		}
		else {
			driver.quit();
		}
	}
	


}
