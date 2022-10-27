/**
 * 
 */
package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import util.ExtentReporter;

/**
 * @author RajashekarGogulakond
 *
 */
public class MyListeners implements ITestListener{
	
	ExtentReports extentreport = ExtentReporter.getExtentReport();	
	ExtentTest extentTest;
	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentreport.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test got passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.FAIL, "Test got failed");
		extentTest.fail(result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.SKIP, "Test got skipped");
		extentTest.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}

	
	
	
	
}
