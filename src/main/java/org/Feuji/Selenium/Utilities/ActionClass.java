package org.Feuji.Selenium.Utilities;

import org.openqa.selenium.WebElement;

public class ActionClass {
	
	public void click(WebElement element) {
		try {
		element.click();
		}
		catch(Exception e) {
			System.out.println("The element is not clickable because : "+e);
		}
	}
	
	public void type(WebElement element,String value) {
		try {
			element.sendKeys(value);
		}
		catch(Exception e){
			System.out.println("The "+value + " cannot be entered in the field because : "+e);
		}
	}
	
	

}
