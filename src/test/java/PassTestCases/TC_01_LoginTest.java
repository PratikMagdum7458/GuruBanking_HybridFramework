package PassTestCases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPageObject;
import PassTestCases.BaseClass;

public class TC_01_LoginTest extends BaseClass{

	//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
	@Test
	public void loginTest() throws InterruptedException
	{
		driver.get(BS_Url);
		Thread.sleep(3000);
		log.info("Base Url open");
		lp=new LoginPageObject(driver);
		Thread.sleep(3000);
		lp.setUsername(BS_Username);
		log.info("Valid Username set");
		lp.setPassword(BS_Password);
		log.info("Valid Password set");
		lp.clickOnLoginBtn();
		log.info("Click on login Button");
		if(alertIsPresent()==true)
		{
			Alert alert=driver.switchTo().alert();
			System.out.println("After click Error is ::"+alert.getText());
			alert.accept();
			Assert.assertTrue(false);
		}
		else
		{
			System.out.println("Successfule message is :"+lp.getSuccessMessage());
			lp.clickOnLogoutBtn();
			log.info("Click on logout Button");
			driver.switchTo().alert().accept();
			Assert.assertTrue(true);
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
