package com.excelbd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.excelbd.drivers.PageDriver;
import com.excelbd.utilities.GetScreenShot;

public class ServicePointPage {
ExtentTest test;

	
	public ServicePointPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[3]/div[1]/div[1]/div[2]/div[1]/div[2]/a[1]/div[1]") })
	WebElement vitalbutton;
	
	
	//Pass Case
	public void passCase(String message) {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
	}
	
	public void passCaseWithSC(String message, String scName) throws IOException {
		test.pass("<p style=\"color:#85BC63; font-size:13px\"><b>"+message+"</b></p>");
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.pass(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
	}
	
	//Fail Case
	public void failCase(String message, String scName) throws IOException {
		test.fail("<p style=\"color:#FF5353; font-size:13px\"><b>"+message+"</b></p>");
		Throwable t = new InterruptedException("Exception");
		test.fail(t);
		String screenShotPath = GetScreenShot.capture(PageDriver.getCurrentDriver(), ""+scName+"");
		String dest = System.getProperty("user.dir") + "\\screenshots\\" + ""+scName+".png";
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath(dest).build());
		PageDriver.getCurrentDriver().quit();
	}
	
	public void servicepoint () throws IOException{
		try {
			test.info("Please click on the vital button");
			if (vitalbutton.isDisplayed()) {
				vitalbutton.click();
				passCaseWithSC("Vital button is Successful", "vital_button__pass");
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			failCase("Vital button was not locateable. Please check the error message.", "vital_button_fail");
		}
	}
}
