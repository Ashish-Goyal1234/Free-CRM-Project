package org.freecrm.listeners;

import java.io.IOException;
import java.util.Arrays;
import org.freecrm.utility.ApplicationConfiguration;
import org.freecrm.utility.Logger;
import org.freecrm.utility.Utilities;
import org.testng.Assert;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener implements ITestListener{
    private ExtentReports      extentRpt;
    private ExtentTest         extentTest;
    ApplicationConfiguration config;
    

    public void onStart(ITestContext context) {
        ISuite suiteInstance = context.getSuite();
        extentRpt = (ExtentReports) suiteInstance.getAttribute("extentReport");
        config = (ApplicationConfiguration) suiteInstance.getAttribute("configurations");
    }
    
    public void onFinish(ITestContext context) {
          
    }
    
    public void onTestStart(ITestResult result) {
        extentTest  = extentRpt.createTest(result.getTestClass().getName()+"      @TestCase : " + result.getMethod().getMethodName());
        extentTest.assignCategory(result.getTestClass().getName());  // This line is ued to add catagories.
        extentTest.log(Status.INFO, result.getTestClass().getName()+"      @TestCase : " + result.getMethod().getMethodName() + "test is started");
    }
    
    public void onTestSuccess(ITestResult result){
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE : - " + methodName.toUpperCase()
                + " Passed" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
        extentTest.pass(m);
    }
   
    public void onTestFailure(ITestResult result) {
        String path = config.getScreenshotPath();
        String screenshotPath =Utilities.captureScreenshotWithRobot(result.getName(), path);
        String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
        extentTest.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured : Click to see"  + "</font>" + "</b>" + "</summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details>"  + "\n");
        String failureLog = "TEST CASE FAILED";
        Markup m = MarkupHelper.createLabel(failureLog, ExtentColor.RED);
        extentTest.log(Status.FAIL, m);
        try {
            extentTest.fail("<font color=" + "red>" + "Snapshot below: " + extentTest.addScreenCaptureFromPath(screenshotPath));
            } catch (IOException e) {
                Logger.debug("Failed to add scrxeenshot in extent report", e);
                Assert.fail("Failed to add screenshot in extent report", e);
            }

    }
    
    public void onTestSkipped(ITestResult result) {
        String methodName = result.getMethod().getMethodName();
        String logText = "<b>" + "TEST CASE : - " + methodName.toUpperCase()+ " SKipped" + "</b>";
        Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
        extentTest.skip(m);
    }



	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}
}
