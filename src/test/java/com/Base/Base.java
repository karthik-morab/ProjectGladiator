package com.Base;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class Base {
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void beforeSuite() {
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/results/ExtentReport.html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}

	@BeforeTest
	public void beforeTest() throws Exception {
		driver = DriverUtil.getBrowser("chrome");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	@AfterMethod
	public void flush()
	{
		report.flush();
	}
}
