package com.Automation.reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hpsf.Date;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Automation.Base.TestBase;

public class ReadExcelByColHeader extends TestBase {

	public File inputFile;
	public FileInputStream testdata;
	public String FileInputExtension;
	public Workbook InputWkBook;
	public Sheet Inputsheet;

	
    
	public void ReadByColHeader(String filepath, String fileName, String sheetName) {

		try {
			inputFile = new File(filepath + "\\" + fileName);
			System.out.println("input file found");
			testdata = new FileInputStream(inputFile);
			InputWkBook = null;
			FileInputExtension = fileName.substring(fileName.indexOf("."));

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (FileInputExtension.equals(".xls")) {
			try {
				InputWkBook = new HSSFWorkbook(testdata);
				System.out.println(".xls inputfilefound");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (FileInputExtension.equals(".xlsx")) {
			try {
				InputWkBook = new XSSFWorkbook(testdata);
				System.out.println(".xlsx inputfilefound");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Inputsheet = InputWkBook.getSheet(sheetName);
		Row row = Inputsheet.getRow(0);
		int rowcount = Inputsheet.getLastRowNum();
		 int col_num = -1;
		 
		 
	        for(int i=0; i < row.getLastCellNum(); i++)
	        {
	            if(row.getCell(i).getStringCellValue().trim().equals("Items"))
	                col_num = i;
	        }
	 
	       row = Inputsheet.getRow(1);
	       Cell cell = row.getCell(col_num);
	 
	        String value = cell.getStringCellValue();
	        System.out.println("Value of the Excel Cell is - "+ value);
	        
	            	        
	    }
	
	public void extractExcelContentByColumnIndex(String filepath, String fileName, String sheetName, String Items){
       
        
        try {
			inputFile = new File(filepath + "\\" + fileName);
			System.out.println("input file found");
			testdata = new FileInputStream(inputFile);
			InputWkBook = null;
			FileInputExtension = fileName.substring(fileName.indexOf("."));

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (FileInputExtension.equals(".xls")) {
			try {
				InputWkBook = new HSSFWorkbook(testdata);
				System.out.println(".xls inputfilefound");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (FileInputExtension.equals(".xlsx")) {
			try {
				InputWkBook = new XSSFWorkbook(testdata);
				System.out.println(".xlsx inputfilefound");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Inputsheet = InputWkBook.getSheet(sheetName);
		
		int column_index = 0;
		//int column_index_2 = 0;
		//int column_index_3 = 0;
		Row row = Inputsheet.getRow(0);
		for (Cell cell : row) {
			// Column header names.
			//switch (cell.getStringCellValue()) {
			if (cell.getStringCellValue().equalsIgnoreCase(Items)) {
			//case "Items":
				column_index = cell.getColumnIndex();
				break;
			        }
		    }

		    for (Row r : Inputsheet) {
		        if (r.getRowNum()==0) continue;//hearders
		        Cell c_1 = r.getCell(column_index);
		        //Cell c_2 = r.getCell(column_index_2);
		        //Cell c_3 = r.getCell(column_index_3);
		        if (c_1 != null && c_1.getCellType() != CellType.BLANK)/*
		                &&c_2 != null && c_2.getCellType() != CellType.BLANK
		                &&c_3 != null && c_3.getCellType() != CellType.BLANK)*/ {
		           // System.out.print("  "+c_1 + "   " + c_2+"   "+c_3+"\n");
		            System.out.print("  "+c_1 +"\n");
		        }
		    }

}
}
