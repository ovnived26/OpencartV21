package testCases;

import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class AccountRegistrationTest extends BaseClass{

	
	
	@Test
	public void verify_account_reg()
	{
		try
		{
		HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();
			
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		
		String password= randomeAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.clickPrivacyPolicy();
		regpage.clickContinue();
		
		//Assertion is used to compare the values.
		//Assert equals is used to verify that two values are equal. First argument will be the actual value 
		//and second argument will be the expected value.
		String cnfmsg=regpage.getConfirmationMsg();
		if(cnfmsg.equals("Congratulations! Your new account has been successfully created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	
		//Assert.assertEquals(cnfmsg,"Congratulations! Your new account has been successfully created!");
	}
		catch(Exception e)
		{
			Assert.fail();
		}
	}	
}
