package com.Automation.reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.io.output.DeferredFileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Automation.Base.TestBase;
import com.Automation.Base.TestUtil;

public class ReadWriteExcel extends TestBase {
	public File inputFile;
	public FileInputStream testdata;
	public Workbook InputWkBook;
	public Sheet inputSheet;
	String FileInputExtension;
	int rowcount;

	public void ReadExcel(String filepath, String fileName) {

		try {
			inputFile = new File(filepath + "\\" + fileName);
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
				e.printStackTrace();
			}

		} else if (FileInputExtension.equals(".xlsx")) {
			try {
				InputWkBook = new XSSFWorkbook(testdata);
				System.out.println(".xlsx inputfilefound");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	// Retrieve all the values under a column Name in an excel
	public String ReadingCelldataByHeader(String sheetName, String colName) {
		inputSheet = InputWkBook.getSheet(sheetName);

		int rowcount = inputSheet.getLastRowNum();
		int columnCount = inputSheet.getRow(0).getLastCellNum();

		int column_index = 0;
		// int column_index_2 = 0;
		// int column_index_3 = 0;
		Row row = inputSheet.getRow(0);
		String cellValue = null;

		for (Cell cell : row) {
			// Column header names.
			// switch (cell.getStringCellValue()) {
			if (cell.getStringCellValue().equalsIgnoreCase(colName)) {
				// case "Items":
				column_index = cell.getColumnIndex();
				break;
			}
		}

		for (Row r : inputSheet) {
			if (r.getRowNum() == 0)
				continue;// hearders
			Cell cell = r.getCell(column_index);
			// Cell c_2 = r.getCell(column_index_2);
			// Cell c_3 = r.getCell(column_index_3);
			// if (c_1 != null && c_1.getCellType() != CellType.BLANK)/*
			// &&c_2 != null && c_2.getCellType() != CellType.BLANK
			// &&c_3 != null && c_3.getCellType() != CellType.BLANK)*/ {
			// System.out.print(" "+c_1 + " " + c_2+" "+c_3+"\n");
			// System.out.print(" "+c_1 +"\n");

			{
				switch (cell.getCellType()) {
				case STRING:
					cellValue = cell.getStringCellValue();
					System.out.print(cellValue + "\n");
					break;

				case FORMULA:
					cellValue = cell.getCellFormula();
					System.out.print(cellValue + "\n");
					break;

				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						cellValue = cell.getDateCellValue().toString();
					} else {
						cellValue = Double.toString(cell.getNumericCellValue());
					}
					System.out.print(cellValue + "\n");
					break;

				case BLANK:
					cellValue = "";
					System.out.print(cellValue + "\n");
					break;

				case BOOLEAN:
					cellValue = Boolean.toString(cell.getBooleanCellValue());
					System.out.print(cellValue + "\n");
					break;
				}
			}
		}

		return cellValue;
	}

	// Read Data from Excel based on Column Name

	public String getsCellData(String sheetName, String colName, int rowNum) {
		Row row = null;
		Cell cell = null;
		int col_Num = -1;
		inputSheet = InputWkBook.getSheet(sheetName);
		try {

			row = inputSheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num = i;
			}

			row = inputSheet.getRow(rowNum);
			cell = row.getCell(col_Num);
			String cellValue = null;

			if (cell.getCellType() == CellType.STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA) {
				cellValue = String.valueOf(cell.getNumericCellValue());
				if (DateUtil.isCellDateFormatted(cell)) {
					DateFormat df = new SimpleDateFormat("dd/MM/yy");
					Date date = cell.getDateCellValue();
					cellValue = df.format(date);
				}
				return cellValue;
			} else if (cell.getCellType() == CellType.BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + col_Num + " does not exist  in Excel";
		}
	}

	// Get number of Rows from Excel
	public int GetRowCount(String sheetName) {
		inputSheet = InputWkBook.getSheet(sheetName);
		int rowcount = inputSheet.getLastRowNum();
		return rowcount;
	}

	// Get number of Columns from Excel
	public int GetColCount(String sheetName) {
		int columnCount = inputSheet.getRow(0).getLastCellNum();
		return columnCount;
	}

	// Close Excel
	public void closeexcel() {
	
		try {
			InputWkBook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<Object> ReadAllExcelDataUsingIterator(String sheetName) {

		// int rowcount = inputSheet.getLastRowNum();
		// int colcount = inputSheet.getRow(0).getLastCellNum();
		
		inputSheet = InputWkBook.getSheet(sheetName);
		String cellValue = null;
		ArrayList<Object> col = new ArrayList();

		Iterator<Row> iterator = inputSheet.iterator();

		while (iterator.hasNext()) {

			Row row = iterator.next();
			Iterator<Cell> CellIterator = row.cellIterator();
			while (CellIterator.hasNext()) {
				Cell cell = CellIterator.next();
				switch (cell.getCellType()) {
				case STRING:
					cellValue = cell.getStringCellValue();
					// System.out.print(cellValue + "\n");
					break;

				case FORMULA:
					cellValue = cell.getCellFormula();
					// System.out.print(cellValue + "\n");
					break;

				case NUMERIC:
					cellValue = String.valueOf(cell.getNumericCellValue());
					if (DateUtil.isCellDateFormatted(cell)) {
						DateFormat df = new SimpleDateFormat("dd/MM/yy");
						Date date = cell.getDateCellValue();
						cellValue = df.format(date);
					}
					break;

				case BLANK:
					cellValue = "";
					// System.out.print(cellValue + "\n");
					break;

				case BOOLEAN:
					cellValue = Boolean.toString(cell.getBooleanCellValue());
					// System.out.print(cellValue + "\n");
					break;
				}
				if (cell.getCellType() == CellType.NUMERIC) {
					//System.out.println(cell.getNumericCellValue());
					col.add(cell.getNumericCellValue());
				} else if (cell.getCellType() == CellType.STRING) {
					//System.out.println(cell.getRichStringCellValue());
					col.add(cell.getRichStringCellValue());
				} else if (cell.getCellType() == CellType.BOOLEAN) {
					//System.out.println(cell.getBooleanCellValue());
					col.add(cell.getBooleanCellValue());
				} else if (cell.getCellType() == CellType.FORMULA) {
					//System.out.println(cell.getNumericCellValue());
					col.add(cell.getBooleanCellValue());

				}
			}
		}

		return col;
	}

	public void WriteToExcel() {
		Workbook ouputWrkbk = null;
		Row row = null;
		Sheet outputSheet = null;
		FileOutputStream op = null;
		try {
			
			ouputWrkbk = new HSSFWorkbook();
			outputSheet = ouputWrkbk.createSheet("Results");
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		Object [][] Product = {
				{"Items", "Department",1,4},
				{"Items", "Department",1,4},
		{"Items", "Department",1,4},
		{"Items", "Department",1,4}
		};
			
		int Rows = 0;
		 for (Object[] aBook : Product) {
			row= outputSheet.createRow(Rows++);
			 int cols = 0;
			 for(Object Items :aBook){
				Cell cell = row.createCell(cols++);
				cell.setCellValue(false);
			 
			 if (Items instanceof String) {
                 cell.setCellValue((String) Items);
             } else if (Items instanceof Integer) {
                 cell.setCellValue((Integer) Items);
             }
		 }
		
		 }
		 
		// Write the output to a file
		try {
			
			
			String Filename = "Results";
			String Extn = ".xls";
			//+ "TU.gettimestamp()"
			String fileName = Filename +Extn;
						
			op = new FileOutputStream(System.getProperty("user.dir")+"\\Input\\"+fileName);
			ouputWrkbk.write(op);
			op.close();
			ouputWrkbk.close();
			System.out.println("Success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		}

	
	public int getRowCount(String sheetName) {
		int index = InputWkBook.getSheetIndex(sheetName);
		if (index == -1)
			return 0;
		else {
			inputSheet = InputWkBook.getSheetAt(index);
			int number = inputSheet.getLastRowNum() + 1;
			return number;
		}

	}

	
	    
	
	    	
	}

