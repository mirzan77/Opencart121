package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.A_HomePage;
import pageObjects.C_LoginPage;
import pageObjects.D_MyAccountPage;
import testBase.A_BaseClass;
import utilities.DataProviders;



public class TC003_LoginDDT extends A_BaseClass{
	
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="datadriven")
	public void verify_loginDDT(String email,String pwd,String exp) {
		
		
		logger.info("**1.starting TC003 LoginDDT********");
		
		try
		{
		
		//HOME PAGE
		
		A_HomePage hp = new A_HomePage(driver);
		
		hp.clickMyAccount();
		
		hp.clickLogin();
		
		//LOGIN PAGE
		
		C_LoginPage lp = new C_LoginPage(driver);
		
		lp.setEmail(email);
		
		lp.setPassword(pwd);
		
		lp.ClickLogin();
		
		//MY ACCOUNG PAGE
		
		D_MyAccountPage map = new D_MyAccountPage(driver);
		
		boolean tarPage = map.isMyAccountPageExists();
		
		
		
		
		
		/*Data is valid  -- login success - test pass -- logout
		Data is valid  -- login failed - test fail


		Data is invalid -- login success - test fail -- logout
		Data is invalid -- login failed - test pass 
		*/
	
		if(exp.equalsIgnoreCase("valid")) {
			
			if(tarPage==true) {
				
				map.clicklogout();

				Assert.assertTrue(true);
				
			}
			else {
				
				Assert.assertTrue(false);

			}
		}
		
		
		if(exp.equalsIgnoreCase("invalid")) {
			
			if(tarPage==true) {
				
				
				map.clicklogout();

				Assert.assertTrue(false);
				
			}
			else {
				
				Assert.assertTrue(true);

			}
		}
		
		}
		catch(Exception e) {

			Assert.fail();
		}
		
		logger.info("**END.finished TC003 LoginDDT********");

	}
}