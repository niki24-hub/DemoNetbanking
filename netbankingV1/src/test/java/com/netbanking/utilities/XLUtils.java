package com.netbanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils 

{
    public static FileInputStream fi;
    public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getrowcount(String filepath,String sheetname) throws IOException
	{
		fi=new FileInputStream(filepath);
		wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(sheetname);		
		int rowcount=sh.getLastRowNum();
		wb.close();
        fi.close();
		return rowcount;
		
	}
	
	public static int getcellcount(String filepath, String sheetname, int rownum) throws IOException
	{
		fi=new FileInputStream(filepath);
		wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(sheetname);	
        row=sh.getRow(rownum);
        int cellcount=row.getLastCellNum();
        wb.close();
        fi.close();
		return cellcount;
        
		
	}
	
	public static String getcelldata(String filepath, String sheetname, int rownum, int colnum ) throws IOException
	{
		fi=new FileInputStream(filepath);
		wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(sheetname);
        row=sh.getRow(rownum);
        cell=row.getCell(colnum);
        String data;
        try
        {
        	DataFormatter formatter=new DataFormatter();
        	String celdata=formatter.formatCellValue(cell);
    		return celdata;

        	
        }
        catch(Exception e)
        {
        	data="";
    	
        }
        
        wb.close();
        fi.close();
    	return data;
	}
	
	public static void setcelldata(String filepath, String sheetname, int rownum, int colnum, String Data) throws IOException
	{
		fi=new FileInputStream(filepath);
		wb=new XSSFWorkbook(fi);
        sh=wb.getSheet(sheetname);
        row=sh.getRow(rownum);
        cell=row.createCell(colnum);
        cell.setCellValue(Data);
        fo=new FileOutputStream(filepath);
        wb.write(fo);
        fi.close();
        fo.close();
        
	}
}
