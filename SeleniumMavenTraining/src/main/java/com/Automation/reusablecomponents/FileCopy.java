package com.Automation.reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.Automation.Base.TestBase;

/*The reusable function copies file from one location to another location*/

public class FileCopy extends TestBase {
	
	public static final SimpleDateFormat DateFormat= new SimpleDateFormat("yyyy.MM.dd.HHmmss");
	
	Timestamp ts = new Timestamp(System.currentTimeMillis());

	public void CopyFile() {
		
		
			
		System.out.println(DateFormat.format(ts));
		String Updated_Time = DateFormat.format(ts);
		File InputFile = new File("C:\\Users\\dines\\Downloads\\Linkedin_Profile.docx");
		File OutputFile = new File("C:\\Users\\dines\\Downloads\\Linkedin_Profile"+Updated_Time+".docx");
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		

		try {
			fis = new FileInputStream(InputFile);
			fos = new FileOutputStream(OutputFile);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(fis.available());
		} catch (IOException e) {
			e.printStackTrace();
		}

		int i = 0;
		try {
			while ((i = fis.read()) != -1) {
				fos.write(i);
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (fis != null) {
					fis.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("File successfully copied");

	}

}
