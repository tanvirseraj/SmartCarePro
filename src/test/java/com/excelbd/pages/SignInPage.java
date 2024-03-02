package com.excelbd.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.excelbd.drivers.PageDriver;
import com.excelbd.utilities.ExcelUtils;
import com.excelbd.utilities.GetScreenShot;

public class SignInPage {
	ExtentTest test;

		public SignInPage(ExtentTest test) {
			PageFactory.initElements(PageDriver.getCurrentDriver(), this);
			this.test = test;
		}

		@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/input[1]") })
		WebElement username;

		@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/div[2]/input[1]") })
		WebElement password;

		@FindBys({ @FindBy(xpath = "//button[contains(text(),'Sign In')]") })
		WebElement signin;
		
		
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
		
		public void signin() throws IOException{
			try {
				test.info("Please enter your username.");
				if (username.isDisplayed()) {
					username.sendKeys("tester");
					passCase("You have entered your username");
					Thread.sleep(2000);
					try {
						test.info("Please enter your password.");
						if (password.isDisplayed()) {
							password.sendKeys("tester2023!");
							passCase("You have entered your password");
							Thread.sleep(2000);
							try {
								test.info("Please click on the Login Button.");
								if (signin.isDisplayed()) {
									signin.click();
									Thread.sleep(5000);
									passCaseWithSC("Signin is Successful", "signin_pass");
								}
							} catch (Exception e) {
								failCase("Submit button was not locateable.", "signin_fail");
							}
						}
					} catch (Exception e) {
						failCase("Password was not locateable. Please check the error message.", "password_fail");
					}
				}
			} catch (Exception e) {
				failCase("User name was not locateable. Please check the error message.", "username_fail");
			}
		}

}
