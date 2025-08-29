//creating a parent class for constructor
//instead of creating a constructor class for every POM ,we creating common parent class
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class A_BasePage {
	
	WebDriver driver;
	
	public A_BasePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}


}