package com.HackerEarth.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetTestData {

public static String fromExcel(String fileName, String sheetName, int rIndex, int cIndex ) {
		
		String data=null;
		try{
			
			File f=new File(fileName);
			FileInputStream fis=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet st=wb.getSheet(sheetName);
			Row r=st.getRow(rIndex);
			Cell c=r.getCell(cIndex);
			data=c.toString();
			
		}
		catch(Exception e){
			
		e.getMessage();
		}
		return data;
	}
	public static void toExcel(String fileName, String sheetName, int rIndex, int cIndex, String cellValue){
		
		try{
			File f=new File(fileName);
			FileInputStream fis=new FileInputStream(f);
			Workbook wb=WorkbookFactory.create(fis);
			Sheet st=wb.getSheet(sheetName);
			Row r=st.getRow(rIndex);
			Cell c=r.getCell(cIndex);
			c.setCellValue(cellValue);
			FileOutputStream fos=new FileOutputStream(f);
			wb.write(fos);
		
		}
		catch (Exception e){
			e.getMessage();
		}
	}
}
