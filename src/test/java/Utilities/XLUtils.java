package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class XLUtils {

	public static FileInputStream fis;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		int rowcount=sheet.getLastRowNum();
		return rowcount;
	}
	
	public static int getCellcount(String xlfile, String xlsheet, int rowno) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rowno);
		int cellcount=row.getLastCellNum();
		return cellcount;
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rowno, int cellno) throws IOException
	{
		fis=new FileInputStream(xlfile);
		workbook=new XSSFWorkbook(fis);
		sheet=workbook.getSheet(xlsheet);
		row=sheet.getRow(rowno);
		cell=row.getCell(cellno);
		String data;
		try
		{
			DataFormatter dtf=new DataFormatter();
			String cellData=dtf.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e)
		{
			data="";
		}
		return data;
	}
	
	
}
