package com.Automation.reusablecomponents;

import java.util.ArrayList;
import java.util.Arrays;

import com.Automation.Base.TestBase;

public class DDTTestData extends TestBase{
	ReadWriteExcel reader = new ReadWriteExcel();
	
	public ArrayList<Object[]> testdatatestng() {
		ArrayList<Object[]> testdata = new ArrayList<Object[]>();
		
		
		try {
			reader.ReadExcel(Properties.getProperty("inputfilepath"), Properties.getProperty("inputfilename"));
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		for(int row =1;row<reader.getRowCount(Properties.getProperty("inputsheetname"));row++){
			
			String Items = reader.getsCellData(Properties.getProperty("inputsheetname"), "Items", row);
			String Department = reader.getsCellData(Properties.getProperty("inputsheetname"), "Department", row);
			
		
			
		testdata.add(new Object[] {Items,Department});
		
	}
	
	return testdata;
	}

}
