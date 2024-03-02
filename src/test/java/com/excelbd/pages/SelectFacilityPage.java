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

public class SelectFacilityPage {
	ExtentTest test;

		
		public SelectFacilityPage(ExtentTest test) {
			PageFactory.initElements(PageDriver.getCurrentDriver(), this);
			this.test = test;
		}

		@FindBys({ @FindBy(xpath = "//select[@placeholder='Enter Province']") })
		WebElement clickprovince;
		
		@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/select[1]") })
		WebElement selectprovince;
		

		@FindBys({ @FindBy(xpath = "//select[@placeholder='Enter District']") })
		WebElement clickdistrict;
		
		@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/div[2]/select[1]") })
		WebElement selectdistrict;

		@FindBys({ @FindBy(xpath = "//input[@placeholder='Search facility']") })
		WebElement clickfacility;
		
		@FindBys({ @FindBy(xpath = "//div[contains(text(),'Dr. Watson Dental Clinic')]") })
		WebElement selectfacility;
		
		@FindBys({ @FindBy(xpath = "//button[contains(text(),'Enter')]") })
		WebElement enterbutton;
		
		
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
		
		public void selectfacility () throws IOException {
			try {
				test.info("Please click your province.");
				if (clickprovince.isDisplayed()) {
					clickprovince.click();
					passCase("You have clicked your province");
					Thread.sleep(2000);
					try {
						test.info("Please select your province.");
						if (selectprovince.isDisplayed()) {
							selectprovince.click();
							passCase("You have selected your province");
							Thread.sleep(2000);
							try {
								test.info("Please click your district.");
								if (clickdistrict.isDisplayed()) {
									clickdistrict.click();
									passCase("You have clicked your district");
									Thread.sleep(2000);
									try {
										test.info("Please select your district.");
										if (selectdistrict.isDisplayed()) {
											selectdistrict.click();
											passCase("You have selected your district");
											Thread.sleep(2000);
											try {
												test.info("Please click your facility.");
												if (clickfacility.isDisplayed()) {
													clickfacility.click();
													passCase("You have clicked your facility");
													Thread.sleep(2000);
													try {
														test.info("Please select your facility.");
														if (selectfacility.isDisplayed()) {
															selectfacility.click();
															passCase("You have selected your facility");
															Thread.sleep(2000);
															try {
																test.info("Please click on enter button.");
																if (enterbutton.isDisplayed()) {
																	enterbutton.click();
																	passCaseWithSC("Enter is Successful", "enter_button_pass");
																	Thread.sleep(2000);
																}
							
															} catch (Exception e) {
																failCase("Enter button was not locateable. Please check the error message.", "enter_button_fail");
															}
														}
													} catch (Exception e) {
														failCase("Select Facility was not locateable. Please check the error message.", "select_facility_fail");
													}
												}
											} catch (Exception e) {
												failCase("Click Facility was not locateable. Please check the error message.", "click_facility_fail");
											}
										}
									} catch (Exception e) {
										failCase("Select District was not locateable. Please check the error message.", "select_district_fail");
									}
								}
							} catch (Exception e) {
								failCase("Click District was not locateable. Please check the error message.", "click_district_fail");
							}
						}
					} catch (Exception e) {
						failCase("Select Province was not locateable. Please check the error message.", "select_province_fail");
					}
				}
			} catch (Exception e) {
				failCase("Click Province was not locateable. Please check the error message.", "click_province_fail");
			}
		}
}
