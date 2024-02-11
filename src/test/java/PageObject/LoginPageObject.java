package PageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	
	WebDriver ldriver;
	
	public LoginPageObject(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="(//input[@name='uid'])[1]")
	WebElement username;  //mngr552622
	
	public void setUsername(String user)
	{
		username.sendKeys(user);
	}
	
	@FindBy(xpath="(//input[@name='password'])[1]")
	WebElement password;  //mepUqym
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	@FindBy(xpath="(//input[@name='btnLogin'])[1]")
	WebElement clickLoginBtn;
	
	public void clickOnLoginBtn()
	{
		clickLoginBtn.click();
	}
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	WebElement clickLogoutBtn;
	
	public void clickOnLogoutBtn()
	{
		clickLogoutBtn.click();
	}
	
	@FindBy(xpath="//marquee[@class='heading3']")
	WebElement getMessage;
	
	public String getSuccessMessage()
	{
		return getMessage.getText();
	}
}
