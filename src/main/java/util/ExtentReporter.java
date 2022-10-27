/**
 * 
 */
package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * @author RajashekarGogulakond
 *
 */
public class ExtentReporter {
	
	
	public static ExtentReports getExtentReport()
	{
		String extentReportFilePath=System.getProperty("user.dir")+"\\reports\\extentReport.html";
		ExtentSparkReporter sparkReport=new ExtentSparkReporter(extentReportFilePath);
		sparkReport.config().setReportName("TutorialsNinja Automation Results");
		sparkReport.config().setDocumentTitle("TutorialNinja Test Automation Results");
		
		ExtentReports extentreport=new ExtentReports();
		extentreport.attachReporter(sparkReport);
		extentreport.setSystemInfo("Tool for automation", "Selenium");
		extentreport.setSystemInfo("Operating system", "windows 11");
		extentreport.setSystemInfo("Executed by", "rajashekar");
		
		return extentreport;
		
	}
	
}
