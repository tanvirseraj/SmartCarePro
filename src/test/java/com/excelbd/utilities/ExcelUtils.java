package com.excelbd.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static String NRC;
	public static String Date;
	public static String Time;
	public static String Weight;
	public static String Height;
	public static String Temperature;
	public static String Systolic;
	public static String Diastolic;
	public static String Pulse_Rate;
	public static String Respiratory_Rate;
	public static String Oxygen_Saturation;
    
	//Read
	@SuppressWarnings({ "resource", "unused" })
	public void ReadExcel() throws IOException {
		String excelFilePath = "./tests/SampleDataset.xlsx";
		File file = new File(excelFilePath);
		System.out.println(file.getAbsolutePath());
		FileInputStream inputStream = new FileInputStream(file);

		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(1).getLastCellNum();
		
		for (int r = 1; r <= rows ; r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < 1; c++) {
				XSSFCell cell = row.getCell(c);

				row = sheet.getRow(r);
				cell = row.getCell(c + 0);
				NRC= cell.getStringCellValue();

				cell = row.getCell(c + 1);
				Date = cell.getStringCellValue();
				
				cell = row.getCell(c + 2);
				Time = cell.getStringCellValue();
				
				cell = row.getCell(c + 3);
				Weight = cell.getStringCellValue();
				
				cell = row.getCell(c + 4);
				Height = cell.getStringCellValue();
				
				cell = row.getCell(c + 5);
				Temperature = cell.getStringCellValue();
				
				cell = row.getCell(c + 6);
				Systolic = cell.getStringCellValue();
				
				cell = row.getCell(c + 7);
				Diastolic = cell.getStringCellValue();
				
				cell = row.getCell(c + 8);
				Pulse_Rate = cell.getStringCellValue();
				
				cell = row.getCell(c + 9);
				Respiratory_Rate = cell.getStringCellValue();
				
				cell = row.getCell(c + 10);
				Oxygen_Saturation = cell.getStringCellValue();
				
	

			}
		}
	}
	

}
