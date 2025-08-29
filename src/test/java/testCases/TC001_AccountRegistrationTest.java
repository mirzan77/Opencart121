package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
*/
import pageObjects.A_HomePage;
import pageObjects.B_AccountRegistrationPage;
import testBase.A_BaseClass;

public class TC001_AccountRegistrationTest extends A_BaseClass{
	
/*
	public WebDriver driver;
	
	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
	}

	
	
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
	
	*/
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		
		logger.info("******Starting TC001_AccountRegistrationTest******");
		//home page
		//first create obj of home page class
		try
		{
		A_HomePage hp = new A_HomePage(driver);
		
		hp.clickMyAccount();
		
		logger.info("Clicked on My Account Link");

		
		hp.clickRegister();
		
		logger.info("Clicked on Register Link");

		
		
		//account registration page
		
		B_AccountRegistrationPage rp = new B_AccountRegistrationPage(driver);
		
		logger.info("Providing customer details.....");

		
		rp.setfname(randomString().toUpperCase());
		rp.setlastname(randomString().toUpperCase());
		rp.setEmail(randomString()+"@gmail.com");
		rp.setPhone(randomNumber());
		
		//first capture
		String password = randomAlphaNumeric();
		rp.setpassword(password);
		rp.setConfirmPwd(password);
		
		
		rp.clkButtonSubscribe();
		
		
		rp.clkPrivacyButton();
		
		rp.clkContinueButton();
		
		
		logger.info("validating expected message....");

		
		String confmsg = rp.getConfirmationMsg();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		
		
		
	}
		
	/*
		public String randomString() {
			
			String generatedString = RandomStringUtils.secure().nextAlphabetic(5);
			return generatedString;
		}
		
		
		
		public String randomNumber() {
			
			String generatedString = RandomStringUtils.secure().nextNumeric(10);
			return generatedString;
		}
	
		
		
		public String randomAlphaNumeric() {
			
			String generatedString = RandomStringUtils.secure().nextAlphanumeric(10);
			return generatedString;
		}
	
*/
		
		  catch(Exception e) {
				
				logger.error("Test failed.....");
				logger.debug("Debug logs......");
				Assert.fail();

			}
		
		logger.info("****Finished TC001_AccountRegistrationTest*****");
	} 
	  
	
	

}
