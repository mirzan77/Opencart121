package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class D_MyAccountPage extends A_BasePage{
	
	
	

	public D_MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	//locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	
	//action methods
	public boolean isMyAccountPageExists() {
		
		try {
		return msgHeading.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clicklogout() {
		
		lnkLogout.click();
	}
	

}
