package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.A_HomePage;
import pageObjects.C_LoginPage;
import pageObjects.D_MyAccountPage;
import testBase.A_BaseClass;

public class TC002_LoginTest extends A_BaseClass{
	
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("***1.starting TC002_LoginTest*******");
		
		try {
		
		//HOME PAGE
		
		A_HomePage hp = new A_HomePage(driver);
		
		hp.clickMyAccount();
		
		hp.clickLogin();
		
		
		//LOGIN PAGE
		
		C_LoginPage lp = new C_LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		
		lp.setPassword(p.getProperty("password"));
		
		lp.ClickLogin();
		
		//MY ACCOUNG PAGE
		
		D_MyAccountPage map = new D_MyAccountPage(driver);
		
		boolean tarPage = map.isMyAccountPageExists();
		
		//Assert.assertEquals(tarPage,true,"Login Failed..");
		
		Assert.assertTrue(tarPage);
		
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		
		logger.info("***1.Finished TC002_LoginTest*******");

	}

}
