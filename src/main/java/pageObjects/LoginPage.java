/**
 * 
 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author RajashekarGogulakond
 *
 */
public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginbtn;
	
	public void enterUsernameTB(String email)
	{
		username.clear();
		username.sendKeys(email);
	}
	
	public void enterPasswordTB(String pswd)
	{
		password.clear();
		password.sendKeys(pswd);
	}
	
	public MyAccountPage clickLoginBtn()
	{
		loginbtn.click();
		return new MyAccountPage(driver);
	}
	
	
}
