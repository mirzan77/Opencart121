/*Constructor - Locators - Action  Methods*/
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class A_HomePage extends A_BasePage {

	
	//WebDriver driver;
	
	//Constructor
	public A_HomePage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	
	
	//Locators
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyaccount;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	WebElement lnkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement linklogin;
	
	
	//Action Methods
	public void clickMyAccount() {
		
		lnkMyaccount.click();
	}
	
	public void clickRegister() {
		
		lnkRegister.click();
	}
	
	
	public void clickLogin() {
		
		linklogin.click();
	}
	
}
