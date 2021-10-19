package flightOneWay;

import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.*;

public class flightCredentials {
WebDriver driver=null;
//	public List<String> getToCity() throws Exception {
//		FileInputStream fil=new FileInputStream(new File("src\\test\\resources\\Utilities\\Credentials_flights_hotels.xlsx"));
//		List<String> list=new ArrayList<String>();
//		XSSFWorkbook workbook=new XSSFWorkbook(fil);
//		XSSFSheet sheet=workbook.getSheet("Sheet1");
//		int count=sheet.getLastRowNum();
//		//System.out.println(count);
//		for (int i = 1; i<=count; i++) {
//		XSSFRow row = sheet.getRow(i);
//		XSSFCell cell1 = row.getCell(1);
//		 list.add( cell1.getStringCellValue());
//		
//		}
//		return list;
//	}
	

	public void getFromCity() throws Exception {
		flightElements f=new flightElements(driver);
		f.setFrom();
		
		
	}
	
	public static void main(String args[]) throws Exception
	{
		flightCredentials f=new flightCredentials();
		f.getFromCity();
	//	f.getToCity();
		
	}
}
//
//	public String getFirstName() throws Exception {
//		Properties prop = new Properties();
//		prop.load(new FileInputStream("src/main/resources/credentials.property"));
//		String n = prop.getProperty("Name");
//		return n;
//	}
//
//	public String getValidEmail() throws Exception {
//		Properties prop = new Properties();
//		prop.load(new FileInputStream("src/main/resources/credentials.property"));
//		String n = prop.getProperty("validEmail");
//		return n;
//	}
//
//	public String getInvalidEmail() throws Exception {
//		Properties prop = new Properties();
//		prop.load(new FileInputStream("src/main/resources/credentials.property"));
//		String n = prop.getProperty("inValidEmail");
//		return n;
//	}
//
//	public String getValidNo() throws Exception {
//		Properties prop = new Properties();
//		prop.load(new FileInputStream("src/main/resources/credentials.property"));
//		String n = prop.getProperty("validNumber");
//		return n;
//	}
//
//	public String getInvalidNo() throws Exception {
//		Properties prop = new Properties();
//		prop.load(new FileInputStream("src/main/resources/credentials.property"));
//		String n = prop.getProperty("inValidLongNum");
//		return n;
//	}
//
//	public String getTitledd() throws Exception {
//		Properties prop = new Properties();
//		prop.load(new FileInputStream("src/main/resources/credentials.property"));
//		String n = prop.getProperty("title");
//		return n;
//	}
//	
//}
