package FailTestCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPageObject;
import PassTestCases.BaseClass;

public class TC_01_FailedLoginTest extends BaseClass1{

	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(BS_Url);
		Thread.sleep(3000);
		log.info("Base Url open");
		lp=new LoginPageObject(driver);
		Thread.sleep(3000);
		lp.setUsername(BS_Username);
		log.info("Invalid Username set");
		lp.setPassword(BS_Password);
		log.info("Invalid Password set");
		lp.clickOnLoginBtn();
		log.info("Click on login Button");
		if(alertIsPresent()==true)
		{
			Alert alert=driver.switchTo().alert();
			System.out.println("After click Error is ::"+alert.getText());
			alert.accept();
			Assert.assertTrue(false);
		}
	}
	
	public boolean alertIsPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
}
