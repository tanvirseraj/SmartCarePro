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
import com.excelbd.utilities.ExcelUtils;

public class VitalPage {
ExtentTest test;
ExcelUtils excelUtils = new ExcelUtils();

	
	public VitalPage(ExtentTest test) {
		PageFactory.initElements(PageDriver.getCurrentDriver(), this);
		this.test = test;
	}

	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]") })
	WebElement addvital;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]") })
	WebElement date;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/input[1]") })
	WebElement time;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/input[1]") })
	WebElement weight;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/input[1]") })
	WebElement height;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/input[1]") })
	WebElement temperature;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/input[1]") })
	WebElement systolic;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/input[1]") })
	WebElement diastolic;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[9]/div[1]/input[1]") })
	WebElement pulserate;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[10]/div[1]/input[1]") })
	WebElement respiratoryrate;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[11]/div[1]/input[1]") })
	WebElement oxygensaturation;
	
	@FindBys({ @FindBy(xpath = "//body/div[@id='root']/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/button[2]") })
	WebElement savebutton;
	
	
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
	
	public void vital () throws IOException{
		excelUtils.ReadExcel();
		try {
			test.info("Please click on the add vital button");
			if (addvital.isDisplayed()) {
				addvital.click();
				passCaseWithSC("Add vital button is Successful", "add_vital_button__pass");
				Thread.sleep(2000);
				try {
					test.info("Please enter the value of date");
					if (date.isDisplayed()) {
						date.sendKeys(excelUtils.Date);
						passCase("You have entered the value of date");
						Thread.sleep(2000);
						try {
							test.info("Please enter the value of time");
							if (time.isDisplayed()) {
								time.sendKeys(excelUtils.Time);
								passCase("You have entered the value of time");
								Thread.sleep(2000);
								try {
									test.info("Please enter the value of weight");
									if (weight.isDisplayed()) {
										weight.sendKeys(excelUtils.Weight);
										passCase("You have entered the value of weight");
										Thread.sleep(2000);
										try {
											test.info("Please enter the value of height");
											if (height.isDisplayed()) {
												height.sendKeys(excelUtils.Height);
												passCase("You have entered the value of height");
												Thread.sleep(2000);
												try {
													test.info("Please enter the value of temperature");
													if (temperature.isDisplayed()) {
														temperature.sendKeys(excelUtils.Temperature);
														passCase("You have entered the value of temperature");
														Thread.sleep(2000);
														try {
															test.info("Please enter the value of systolic");
															if (systolic.isDisplayed()) {
																systolic.sendKeys(excelUtils.Systolic);
																passCase("You have entered the value of systolic");
																Thread.sleep(2000);
																try {
																	test.info("Please enter the value of diastolic");
																	if (diastolic.isDisplayed()) {
																		diastolic.sendKeys(excelUtils.Diastolic);
																		passCase("You have entered the value of diastolic");
																		Thread.sleep(2000);
																		try {
																			test.info("Please enter the value of pulserate");
																			if (pulserate.isDisplayed()) {
																				pulserate.sendKeys(excelUtils.Pulse_Rate);
																				passCase("You have entered the value of pulserate");
																				Thread.sleep(2000);
																				try {
																					test.info("Please enter the value of respiratoryrate");
																					if (respiratoryrate.isDisplayed()) {
																						respiratoryrate.sendKeys(excelUtils.Respiratory_Rate);
																						passCase("You have entered the value of respiratoryrate");
																						Thread.sleep(2000);
																						try {
																							test.info("Please enter the value of oxygensaturation");
																							if (oxygensaturation.isDisplayed()) {
																								oxygensaturation.sendKeys(excelUtils.Oxygen_Saturation);
																								passCase("You have entered the value of oxygensaturation");
																								Thread.sleep(2000);
																								try {
																									test.info("Please click on the save button");
																									if (savebutton.isDisplayed()) {
																										savebutton.click();
																										passCaseWithSC("Save button is Successful", "save_button__pass");
																										Thread.sleep(2000);
																									}
																								} catch (Exception e) {
																									failCase("Save button was not locateable. Please check the error message.", "savebutton_fail");
																								}
																							}
																						} catch (Exception e) {
																							failCase("Oxygen Saturation was not locateable. Please check the error message.", "oxygensaturation_fail");
																						}
																					}
																				} catch (Exception e) {
																					failCase("Respiratory Rate was not locateable. Please check the error message.", "respiratoryrate_fail");
																				}
																			}
																		} catch (Exception e) {
																			failCase("Pulse Rate was not locateable. Please check the error message.", "pulserate_fail");
																	    }
																	}
																} catch (Exception e) {
																	failCase("Diastolic was not locateable. Please check the error message.", "diastolic_fail");
																}
															}
														} catch (Exception e) {
															failCase("Systolic was not locateable. Please check the error message.", "systolic_fail");
														}
													}
												} catch (Exception e) {
													failCase("Temperature was not locateable. Please check the error message.", "temperature_fail");
												}
											}
										} catch (Exception e) {
											failCase("Height was not locateable. Please check the error message.", "height_fail");
										}
									}
								} catch (Exception e) {
									failCase("Weight was not locateable. Please check the error message.", "weight_fail");
								}
							}
						} catch (Exception e) {
							failCase("Time was not locateable. Please check the error message.", "time_fail");
						}
					}
				} catch (Exception e) {
					failCase("Date was not locateable. Please check the error message.", "date_fail");
				}
			}
		} catch (Exception e) {
			failCase("Add vital button was not locateable. Please check the error message.", "add_vital_button_fail");
		}
	}
}
