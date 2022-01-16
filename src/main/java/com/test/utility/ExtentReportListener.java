package com.test.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReportListener implements ITestListener{
	
	public static ExtentReports extent;
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		test.assignCategory(result.getTestClass().getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test Case: "+result.getMethod().getMethodName()+" Passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test Case: "+result.getMethod().getMethodName()+" Failed");
		test.log(Status.FAIL,result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		extent = ExtentReportSetUp.setUpExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
	}

}
