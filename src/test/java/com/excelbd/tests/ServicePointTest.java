package com.excelbd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.excelbd.drivers.PageDriver;
import com.excelbd.pages.ClientSearchPage;
import com.excelbd.pages.ServicePointPage;
import com.excelbd.utilities.CommonMethods;
import com.excelbd.utilities.ExtentFactory;

public class ServicePointTest extends CommonMethods{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url4);
		timeout();
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Service Point</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	@Test
	public void testServicePointMethod() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Service Point Details</b></p>");
		ServicePointPage servicePointPage = new ServicePointPage(childTest);
		servicePointPage.servicepoint();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
