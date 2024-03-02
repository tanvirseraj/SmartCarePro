package com.excelbd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.excelbd.drivers.PageDriver;
import com.excelbd.pages.SelectFacilityPage;
import com.excelbd.pages.SignInPage;
import com.excelbd.utilities.CommonMethods;
import com.excelbd.utilities.ExtentFactory;

public class SelectFacilityTest extends CommonMethods{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url2);
		timeout();
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>Select Facility</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	@Test
	public void testSelectFacilityMethod() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>Select Facility Details</b></p>");
		SelectFacilityPage selectFacilityPage = new SelectFacilityPage(childTest);
		selectFacilityPage.selectfacility();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}
}
