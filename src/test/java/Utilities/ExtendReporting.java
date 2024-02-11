package Utilities;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReporting extends TestListenerAdapter{

	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentrp;
	public ExtentTest logger;
		public void onStart(ITestContext testContext) {
			String timeStamp=new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
			String reportName="Test-Report"+timeStamp+".html";
			htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Report/"+reportName);
			htmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
			extentrp=new ExtentReports();
			extentrp.attachReporter(htmlReporter);
			extentrp.setSystemInfo("Host Name", "localHhost");
			extentrp.setSystemInfo("Environement", "QA");
			extentrp.setSystemInfo("user", "Pratik");
			
			htmlReporter.config().setReportName("Functional Test Automation Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTheme(Theme.DARK);
		}
		
		public void onTestSuccess(ITestResult tr) {
			logger=extentrp.createTest(tr.getName());   //create new entry in the report
			logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));  //Send the Passed Information
			
		}
		
		public void onTestFailure(ITestResult tr) {
			logger=extentrp.createTest(tr.getName());   //create new entry in the report
			logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
			String screenshotPath=System.getProperty("user.dir")+"\\Screeenshots\\"+tr.getName()+".png";
			File f=new File(screenshotPath);
			if(f.exists())
			{
				try {
					logger.fail("Screenshot is below :"+logger.addScreenCaptureFromPath(screenshotPath));
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
			public void onTestSkipped(ITestResult tr)
			{
				logger=extentrp.createTest(tr.getName());   //create new entry in the report
				logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
			
			}
			public void onFinish(ITestContext testContext) {
				extentrp.flush();
			}
			}
