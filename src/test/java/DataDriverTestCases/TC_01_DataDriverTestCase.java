package DataDriverTestCases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LoginPageObject;

public class TC_01_DataDriverTestCase extends BaseClass3{

	@Test(dataProvider="data")
	public void loginData(String user, String pass) throws InterruptedException
	{
		driver.get(BS_Url);
		Thread.sleep(3000);
		log.info("Base Url open");
		lp=new LoginPageObject(driver);
		Thread.sleep(3000);
		lp.setUsername(user);
		log.info("Valid Username set");
		lp.setPassword(pass);
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
	
	@DataProvider(name="data")
	String[][] getData() throws IOException
	{
		String ExcelFile=".//DATTestData//LoginData.xlsx";
		int row = xl.getRowCount(ExcelFile, "Sheet1");
		int cell = xl.getCellcount(ExcelFile, "Sheet1", 1);

		String[][] loginData = new String[row][cell];
		for (int i = 1; i <= row; i++) {
			for (int c = 0; c < cell; c++) {
				loginData[i - 1][c] = xl.getCellData(ExcelFile, "Sheet1", i, c);
			}
		}
		return loginData;
	}
}
