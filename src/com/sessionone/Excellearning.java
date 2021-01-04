package com.sessionone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excellearning {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String S1="C:\\Users\\safia.syed\\eclipse-workspace\\Seleniumlearning\\Excellearning.xlsx";
		FileInputStream F1=new FileInputStream(new File(S1));
		Workbook w1=new XSSFWorkbook(F1);
		Sheet s1=w1.getSheet("Sheet1");
		Sheet s2=w1.getSheet("Sheet2");
		int row=s1.getLastRowNum()-s1.getFirstRowNum();
		System.out.println("Count of the row is " + row);
		for (int i=0;i<row+1;i++)
		{
			Row R1=s1.getRow(i);
			for (int j=0;j<R1.getLastCellNum();j++)
			{
				System.out.println(R1.getCell(j).getStringCellValue());
			}
		}
		
		int row1=s2.getLastRowNum()-s2.getFirstRowNum();
		System.out.println("Count of the rows in sheet2 are: " + row1);
		for(int k=0;k<row1+1;k++)
		{
			Row R2=s2.getRow(k);
			for(int l=0;l<R2.getLastCellNum();l++)
			{
				System.out.println(R2.getCell(l).getStringCellValue());
			}
		}
	}

}
/*Array
List
Map
Reading excel file via */

