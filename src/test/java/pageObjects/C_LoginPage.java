package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class C_LoginPage extends A_BasePage{
	
	

	public C_LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	//locators
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	
	//Action Methods
	
	public void setEmail(String email) {
		
		txtEmailAddress.sendKeys(email);
	}
	
	
	public void setPassword(String pwd) {
		
		txtPassword.sendKeys(pwd);
	}
	
	
	public void ClickLogin() {
		
		   btnLogin.click();
		}
	
	
	
	


	
	
	
	
	

}
