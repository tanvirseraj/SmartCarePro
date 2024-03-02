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

public class ClientSearchPage {
	ExtentTest test;

	
	public ClientSearchPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[3]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/input[1]") })
	WebElement searchnrc;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[3]/div[1]/div[2]/form[1]/div[2]/button[1]") })
	WebElement searchbutton;
	
	@FindBys({ @FindBy(xpath = "//button[contains(text(),'Attend to Patient')]") })
	WebElement attendpatient;
	
	
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
	
	public void clientsearch () throws IOException{
		try {
			test.info("Please enter value on search NRC.");
			if (searchnrc.isDisplayed()) {
				searchnrc.sendKeys("1111111");
				passCase("You have enter value on search NRC");
				Thread.sleep(2000);
				try {
					test.info("Please click on search button.");
					if (searchbutton.isDisplayed()) {
						searchbutton.click();
						passCase("You have clicked on search button");
						Thread.sleep(2000);
						try {
							test.info("Please click on the attend to patient button.");
							if (attendpatient.isDisplayed()) {
								attendpatient.click();
								Thread.sleep(5000);
								passCaseWithSC("Attend patient is Successful", "attend_patient__pass");
							}
						} catch (Exception e) {
							failCase("Attend patient was not locateable. Please check the error message.", "attend_patient_fail");
						}
					}
				} catch (Exception e) {
					failCase("Search button was not locateable. Please check the error message.", "search_button_fail");
				}
			}
		} catch (Exception e) {
			failCase("Search NRC was not locateable. Please check the error message.", "search_nrc_fail");
		}
	}
}
