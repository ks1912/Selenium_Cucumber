package org.Feuji.Selenium.Utilities;

import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected static WebDriver driver;
	
	protected  String nameOfUser,MailId;
	protected static String userEmailId;
	protected static Logger log;
	protected Properties readconfig;
	
	public void launch_Chrome(WebDriver driver) {
		this.driver=driver;
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		
	}
	
	public void launch_Edge(WebDriver driver) {
		this.driver=driver;
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://magento.softwaretestingboard.com/");
		
	}
	

}
