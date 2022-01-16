package com.test.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportSetUp {
	public static ExtentReports extent = new ExtentReports();
	
	public static ExtentReports setUpExtentReport() {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
		
		Date date = new Date();
		
		String actualDate= dateformat.format(date);
		
		String reportPath= System.getProperty("user.dir")+"/target/TestExtentReport"+actualDate+".html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		
		
		
		extent.attachReporter(reporter);
		
		reporter.config().setDocumentTitle("API Test Automation Result");
		
		reporter.config().setReportName("TestTenant");
		
		return extent;
	}

}
