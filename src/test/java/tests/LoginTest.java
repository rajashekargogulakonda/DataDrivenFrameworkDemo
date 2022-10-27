/**
 * 
 */
package tests;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import util.DataUtil;
import util.MyXLSReader;

/**
 * @author RajashekarGogulakond
 *
 */
public class LoginTest extends Base{
	public WebDriver driver;
	MyXLSReader excelReader;

	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

	@Test(dataProvider="datasuplier")
	public void testlogin(HashMap<String, String> hMap)
	{
		if(DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N"))
		{
			throw new SkipException("Run mode is set to N, hence not executed");
		}
		driver=openBrowser(hMap.get("Browser"));

		driver.get(prop.getProperty("url"));
		HomePage hp=new HomePage(driver);
		hp.clickMyAccountDropdown();
		LoginPage lp=hp.clickLoginBtn();
		lp.enterUsernameTB(hMap.get("Username"));
		lp.enterPasswordTB(hMap.get("Password"));
		MyAccountPage ma=lp.clickLoginBtn();
		
		String expectedResult=hMap.get("ExpectedResult");
		boolean expectedConvertedResult=false;
		if(expectedResult.equalsIgnoreCase("Pass"))
		{
			expectedConvertedResult=true;
		}
		else if(expectedResult.equalsIgnoreCase("Fail"))
		{
			expectedConvertedResult=false;
		}

		boolean actualResult=false;
		
		actualResult=ma.verifyMyAccountPage();
		Assert.assertEquals(actualResult,expectedConvertedResult);
	}

	//	@DataProvider
	//	public Object[][] datasuplier()
	//	{
	//		Object[][] data = {{"amotooricap9@gmail.com","12345"},
	//				{"amotooricap1@gmail.com","12345"},
	//				{"amotooricap3@gmail.com","12345"}};
	//		return data;
	//		
	//	}
	@DataProvider
	public Object[][] datasuplier()
	{
		Object[][] data=null;
		try
		{
			excelReader=new MyXLSReader("C:\\Users\\RajashekarGogulakond\\eclipse-workspace\\DDFrameworkDemo\\src\\test\\resources\\TutorialsNinja.xlsx");
			data=DataUtil.getTestData(excelReader, "LoginTest", "Data");
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		return data;
	}


}
