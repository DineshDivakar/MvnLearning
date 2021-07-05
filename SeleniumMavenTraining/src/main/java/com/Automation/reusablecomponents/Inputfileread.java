package com.Automation.reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Automation.Base.TestBase;

public class Inputfileread extends TestBase {

	public File inputFile;
	public FileInputStream testdata;
	public Workbook InputWkBook;
	public Sheet inputSheet;
	String FileInputExtension;
	int excelrowcount;
	String filepath = Properties.getProperty("inputfilepath");
	String filename = Properties.getProperty("inputfilename");
	String sheetName = Properties.getProperty("inputsheetname");
	

	public void readinputfile(String filepath, String fileName, String sheetName) {
		
		try {
			inputFile = new File(filepath+"\\"+filepath);
			testdata = new FileInputStream(inputFile);
			InputWkBook = null;
			FileInputExtension = fileName.substring(fileName.indexOf("."));
						
		}catch(IOException e) {
			e.printStackTrace();
		}
		
				if(FileInputExtension.equals(".xls")) {	
				try {
					InputWkBook = new HSSFWorkbook(testdata);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if(FileInputExtension.equals(".xlsx")){
				try {
					InputWkBook = new XSSFWorkbook(testdata);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				inputSheet = InputWkBook.getSheet(sheetName);
				
				//row count
				excelrowcount = inputSheet.getLastRowNum()-inputSheet.getFirstRowNum();
									
				// column count
				
			}
				for (int i=0;i < excelrowcount+1 ; i++){
					Row row = inputSheet.getRow(i);
					for (int j = 0; j < row.getLastCellNum(); j++) {

			            //Print Excel data in console

			            System.out.print(row.getCell(j).getStringCellValue()+"|| ");

		}
	
		
	}
	}
}