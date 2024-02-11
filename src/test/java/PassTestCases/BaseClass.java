package PassTestCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import PageObject.LoginPageObject;
import Utilities.ReadValidData;
import Utilities.XLUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadValidData rd=new ReadValidData();
	
	public String BS_Url=rd.getApplicationUrl();
	public String BS_Username=rd.getUSername();
	public String BS_Password=rd.getPassword();
	
	public WebDriver driver;
	public Logger log;
	public LoginPageObject lp;
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		log=log.getLogger("Guru-Banking");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterClass
	public void tearUp()
	{
		driver.quit();
	}
	
}
