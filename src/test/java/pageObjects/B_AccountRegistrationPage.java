package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class B_AccountRegistrationPage extends A_BasePage{

	
	//constructor
	
	public B_AccountRegistrationPage(WebDriver driver) {
		
		super(driver);
	}
	
	
	//locators  
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFirstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtmail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txttelphone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtConPwd;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement clkSubsctibe;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement privClk;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_cont;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action Methods
	
	public void setfname(String fname) {
		
		txtFirstname.sendKeys(fname);
	}
	
	
	public void setlastname(String lname) {
		
		txtLastname.sendKeys(lname);
	}
      
	
	public void setEmail(String mail) {
		
		txtmail.sendKeys(mail);
	}
	
	
	public void setPhone(String phone) {
		
		txttelphone.sendKeys(phone);
	}
	
	
	public void setpassword(String pwd) {
		
		txtpwd.sendKeys(pwd);
	}
	
	
	public void setConfirmPwd(String pwd) {
		
		txtConPwd.sendKeys(pwd);
	}
	
	public void clkButtonSubscribe() {
		
		clkSubsctibe.click();
		
	}
	
	
	
	public void clkPrivacyButton() {
		
		privClk.click();
		
	}
	
	
	public void clkContinueButton() {
		
		btn_cont.click();
		
	}
	
	
	public String getConfirmationMsg() {
		
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e) {
			
			return (e.getMessage());
		}
	}
	
	
	
	
	

}
