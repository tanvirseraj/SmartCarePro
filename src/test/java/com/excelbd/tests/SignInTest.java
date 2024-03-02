package com.excelbd.tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.excelbd.drivers.PageDriver;
import com.excelbd.pages.SignInPage;
import com.excelbd.utilities.CommonMethods;
import com.excelbd.utilities.ExtentFactory;

public class SignInTest extends CommonMethods{
	ExtentReports report;
	ExtentTest parentTest;
	ExtentTest childTest;
	
	@BeforeClass
	public void openUrl() throws InterruptedException {
		PageDriver.getCurrentDriver().get(url1);
		timeout();
		report = ExtentFactory.getInstance();
		parentTest = report.createTest("<p style=\"color:#FF6000; font-size:20px\"><b>SignIn</b></p>").assignAuthor("QA TEAM").assignDevice("Windows");
	}
	
	@Test
	public void testSignInMethod() throws IOException {
		childTest = parentTest.createNode("<p style=\"color:#3E96E7; font-size:20px\"><b>SignIn Details</b></p>");
		SignInPage signInPage = new SignInPage(childTest);
		signInPage.signin();
	}
	
	@AfterClass
	public void report() {
		report.flush();
	}

}
