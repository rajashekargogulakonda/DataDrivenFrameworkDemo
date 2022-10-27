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
public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy(xpath="//li//a[text()='Login']")
	private WebElement login;
	
	public void clickMyAccountDropdown()
	{
		myAccountDropdown.click();
	}
	
	public LoginPage clickLoginBtn()
	{
		login.click();
		return new LoginPage(driver);
	}
	
	
}
